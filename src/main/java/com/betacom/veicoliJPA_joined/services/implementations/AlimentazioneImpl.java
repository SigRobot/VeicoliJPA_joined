package com.betacom.veicoliJPA_joined.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.veicoliJPA_joined.dto.input.AlimentazioneReq;
import com.betacom.veicoliJPA_joined.dto.output.AlimentazioneDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.mapper.AlimentazioneMap;
import com.betacom.veicoliJPA_joined.models.Alimentazione;
import com.betacom.veicoliJPA_joined.repositories.IAlimentazioneRepository;
import com.betacom.veicoliJPA_joined.services.interfaces.IAlimentazioneServices;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AlimentazioneImpl implements IAlimentazioneServices{
	
	private IAlimentazioneRepository alimR;
	
	@Transactional
	@Override
	public AlimentazioneDTO create(AlimentazioneReq req) throws VeicoloException {
		if (alimR.existsByDescrizione(req.getDescrizione())) {
			throw new VeicoloException("alimentazione.gia.presente");
		}
		Alimentazione c = new Alimentazione();
		c.setDescrizione(req.getDescrizione());
		alimR.save(c);
		return AlimentazioneMap.mapToDTO(c);
	}
	@Transactional
	@Override
	public AlimentazioneDTO update(AlimentazioneReq req) throws VeicoloException {
		if (!alimR.existsById(req.getId())) {
			throw new VeicoloException("alimentazione.non.trovata");
		}
		if (alimR.existsByDescrizione(req.getDescrizione())) {
			throw new VeicoloException("alimentazione.gia.presente");
		}
		Alimentazione c = alimR.getReferenceById(req.getId());
		c.setDescrizione(req.getDescrizione());
		alimR.save(c);
		return AlimentazioneMap.mapToDTO(c);
	}
	@Transactional
	@Override
	public void delete(Integer id) throws VeicoloException {
		Alimentazione c = alimR.findById(id)
				.orElseThrow(() -> new VeicoloException("alimentazione.non.trovata"));
		alimR.delete(c);
		
	}
	@Transactional
	@Override
	public List<AlimentazioneDTO> listAll() {
		return alimR.findAll().stream()
				.map(AlimentazioneMap::mapToDTO)
				.toList();
	}

}
