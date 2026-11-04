package com.betacom.veicoliJPA_joined.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoliJPA_joined.dto.input.MarcaReq;
import com.betacom.veicoliJPA_joined.dto.output.MarcaDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.mapper.MarcaMap;
import com.betacom.veicoliJPA_joined.models.Marca;
import com.betacom.veicoliJPA_joined.repositories.IMarcaRepository;
import com.betacom.veicoliJPA_joined.repositories.IVeicoloRepository;
import com.betacom.veicoliJPA_joined.services.interfaces.IMarcaServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarcaImpl implements IMarcaServices {

	private final IMarcaRepository marcaR;
	private final IVeicoloRepository veicoloR;

	@Override
	@Transactional(rollbackFor = VeicoloException.class)
	public MarcaDTO create(MarcaReq req) throws VeicoloException {
		String descr = pulisciDescrizione(req);

		if (marcaR.findByDescrizioneIgnoreCase(descr).isPresent())
			throw new VeicoloException("marca.esistente");

		Marca m = MarcaMap.toEntity(req);
		m.setDescrizione(descr);
		return MarcaMap.toDTO(marcaR.save(m));
	}

	@Override
	@Transactional(rollbackFor = VeicoloException.class)
	public MarcaDTO update(MarcaReq req) throws VeicoloException {
		if (req.getId() == null)
			throw new VeicoloException("marca.id.obbligatorio");

		String descr = pulisciDescrizione(req);

		Marca m = marcaR.findById(req.getId())
				.orElseThrow(() -> new VeicoloException("marca.non.trovata"));

		// stessa descrizione ammessa solo se è la marca che sto modificando
		Optional<Marca> duplicata = marcaR.findByDescrizioneIgnoreCase(descr);
		if (duplicata.isPresent() && !duplicata.get().getId().equals(m.getId()))
			throw new VeicoloException("marca.esistente");

		m.setDescrizione(descr);
		return MarcaMap.toDTO(marcaR.save(m));
	}

	@Override
	@Transactional(rollbackFor = VeicoloException.class)
	public void delete(Integer id) throws VeicoloException {
		Marca m = marcaR.findById(id)
				.orElseThrow(() -> new VeicoloException("marca.non.trovata"));

		if (veicoloR.existsByMarcaId(id))
			throw new VeicoloException("marca.in.uso");

		marcaR.delete(m);
	}

	@Override
	@Transactional(readOnly = true)
	public MarcaDTO getById(Integer id) throws VeicoloException {
		return marcaR.findById(id)
				.map(MarcaMap::toDTO)
				.orElseThrow(() -> new VeicoloException("marca.non.trovata"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<MarcaDTO> listAll() {
		return MarcaMap.toDTO(marcaR.findAll(Sort.by("descrizione")));
	}

	// controllo di sicurezza lato service (non ci si affida solo al @Valid del controller)
	private String pulisciDescrizione(MarcaReq req) throws VeicoloException {
		if (req.getDescrizione() == null || req.getDescrizione().isBlank())
			throw new VeicoloException("marca.descr.obbligatoria");

		String descr = req.getDescrizione().trim();
		if (descr.length() > 50)
			throw new VeicoloException("marca.descr.troppo.lunga");
		return descr;
	}
}
