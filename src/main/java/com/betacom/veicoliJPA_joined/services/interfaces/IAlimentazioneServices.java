package com.betacom.veicoliJPA_joined.services.interfaces;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.input.AlimentazioneReq;
import com.betacom.veicoliJPA_joined.dto.output.AlimentazioneDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;

public interface IAlimentazioneServices {
	
	AlimentazioneDTO create(AlimentazioneReq req) throws VeicoloException;
	AlimentazioneDTO update(AlimentazioneReq req) throws VeicoloException;
	void delete(Integer id) throws VeicoloException;
	
	List<AlimentazioneDTO> listAll();
}
