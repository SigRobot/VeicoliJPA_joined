package com.betacom.veicoliJPA_joined.services.interfaces;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.input.ColoreReq;
import com.betacom.veicoliJPA_joined.dto.output.ColoreDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;

public interface IColoreServices {

	ColoreDTO create(ColoreReq req) throws VeicoloException;

	ColoreDTO update(ColoreReq req) throws VeicoloException;

	void delete(Integer id) throws VeicoloException;

	ColoreDTO getById(Integer id) throws VeicoloException;

	List<ColoreDTO> listAll();
}
