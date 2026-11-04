package com.betacom.veicoliJPA_joined.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.veicoliJPA_joined.dto.input.ColoreReq;
import com.betacom.veicoliJPA_joined.dto.output.ColoreDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.mapper.ColoreMap;
import com.betacom.veicoliJPA_joined.models.Colore;
import com.betacom.veicoliJPA_joined.repositories.IColoreRepository;
import com.betacom.veicoliJPA_joined.repositories.IVeicoloRepository;
import com.betacom.veicoliJPA_joined.services.interfaces.IColoreServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ColoreImpl implements IColoreServices {

	private final IColoreRepository coloreR;
	private final IVeicoloRepository veicoloR;

	@Override
	@Transactional(rollbackFor = VeicoloException.class)
	public ColoreDTO create(ColoreReq req) throws VeicoloException {
		String descr = pulisciDescrizione(req);

		if (coloreR.findByDescrizioneIgnoreCase(descr).isPresent())
			throw new VeicoloException("colore.esistente");

		Colore c = ColoreMap.toEntity(req);
		c.setDescrizione(descr);
		return ColoreMap.toDTO(coloreR.save(c));
	}

	@Override
	@Transactional(rollbackFor = VeicoloException.class)
	public ColoreDTO update(ColoreReq req) throws VeicoloException {
		if (req.getId() == null)
			throw new VeicoloException("colore.id.obbligatorio");

		String descr = pulisciDescrizione(req);

		Colore c = coloreR.findById(req.getId())
				.orElseThrow(() -> new VeicoloException("colore.non.trovato"));

		
		Optional<Colore> duplicato = coloreR.findByDescrizioneIgnoreCase(descr);
		if (duplicato.isPresent() && !duplicato.get().getId().equals(c.getId()))
			throw new VeicoloException("colore.esistente");

		c.setDescrizione(descr);
		return ColoreMap.toDTO(coloreR.save(c));
	}

	@Override
	@Transactional(rollbackFor = VeicoloException.class)
	public void delete(Integer id) throws VeicoloException {
		Colore c = coloreR.findById(id)
				.orElseThrow(() -> new VeicoloException("colore.non.trovato"));

		
		if (veicoloR.existsByColoreId(id))
			throw new VeicoloException("colore.in.uso");

		coloreR.delete(c);
	}

	@Override
	@Transactional(readOnly = true)
	public ColoreDTO getById(Integer id) throws VeicoloException {
		return coloreR.findById(id)
				.map(ColoreMap::toDTO)
				.orElseThrow(() -> new VeicoloException("colore.non.trovato"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<ColoreDTO> listAll() {
		return ColoreMap.toDTO(coloreR.findAll(Sort.by("descrizione")));
	}

	
	private String pulisciDescrizione(ColoreReq req) throws VeicoloException {
		if (req.getDescrizione() == null || req.getDescrizione().isBlank())
			throw new VeicoloException("colore.descr.obbligatoria");

		String descr = req.getDescrizione().trim();
		if (descr.length() > 30)
			throw new VeicoloException("colore.descr.troppo.lunga");
		return descr;
	}
}
