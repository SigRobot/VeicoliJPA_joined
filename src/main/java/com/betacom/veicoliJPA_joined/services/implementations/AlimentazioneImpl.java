package com.betacom.veicoliJPA_joined.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoliJPA_joined.dto.input.AlimentazioneReq;
import com.betacom.veicoliJPA_joined.dto.output.AlimentazioneDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.mapper.AlimentazioneMap;
import com.betacom.veicoliJPA_joined.models.Alimentazione;
import com.betacom.veicoliJPA_joined.repositories.IAlimentazioneRepository;
import com.betacom.veicoliJPA_joined.repositories.IVeicoloRepository;
import com.betacom.veicoliJPA_joined.services.interfaces.IAlimentazioneServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AlimentazioneImpl implements IAlimentazioneServices {

	private final IAlimentazioneRepository alimentazioneR;
	private final IVeicoloRepository veicoloR;   // per il controllo "in uso" prima della delete

	@Override
	@Transactional
	public AlimentazioneDTO create(AlimentazioneReq req) throws VeicoloException {
		if (alimentazioneR.existsByDescrizioneIgnoreCase(req.getDescrizione())) {
			throw new VeicoloException("alimentazione.gia.presente");
		}
		Alimentazione a = new Alimentazione();
		a.setDescrizione(req.getDescrizione());
		alimentazioneR.save(a);
		return AlimentazioneMap.mapToDTO(a);
	}

	@Override
	@Transactional
	public AlimentazioneDTO update(AlimentazioneReq req) throws VeicoloException {
		Alimentazione a = alimentazioneR.findById(req.getId())
				.orElseThrow(() -> new VeicoloException("alimentazione.non.trovata"));
		if (req.getDescrizione() != null) {
			// se cambia descrizione, controlla che la nuova non sia già di un'altra
			if (!req.getDescrizione().equalsIgnoreCase(a.getDescrizione())
					&& alimentazioneR.existsByDescrizioneIgnoreCase(req.getDescrizione())) {
				throw new VeicoloException("alimentazione.gia.presente");
			}
			a.setDescrizione(req.getDescrizione());
		}
		alimentazioneR.save(a);
		return AlimentazioneMap.mapToDTO(a);
	}

	@Override
	public List<AlimentazioneDTO> listAll() {
		return alimentazioneR.findAll().stream().map(AlimentazioneMap::mapToDTO).toList();
	}

	@Override
	@Transactional
	public void delete(Integer id) throws VeicoloException {
		Alimentazione a = alimentazioneR.findById(id)
				.orElseThrow(() -> new VeicoloException("alimentazione.non.trovata"));
		if (veicoloR.existsByAlimentazione_Id(id)) {
			throw new VeicoloException("alimentazione.in.uso");
		}
		alimentazioneR.delete(a);
	}
}
