package com.betacom.veicoliJPA_joined.services.interfaces;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.input.MarcaReq;
import com.betacom.veicoliJPA_joined.dto.output.MarcaDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;

public interface IMarcaServices {

	MarcaDTO create(MarcaReq req) throws VeicoloException;

	MarcaDTO update(MarcaReq req) throws VeicoloException;

	void delete(Integer id) throws VeicoloException;

	MarcaDTO getById(Integer id) throws VeicoloException;

	List<MarcaDTO> listAll();
}
