package com.betacom.veicoliJPA_joined.services.interfaces;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.input.BiciReq;
import com.betacom.veicoliJPA_joined.dto.input.MacchinaReq;
import com.betacom.veicoliJPA_joined.dto.input.MotoReq;
import com.betacom.veicoliJPA_joined.dto.input.VeicoloSearchReq;
import com.betacom.veicoliJPA_joined.dto.output.VeicoloDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;

public interface IVeicoloServices {

	VeicoloDTO createMacchina(MacchinaReq req) throws VeicoloException;
	VeicoloDTO createMoto(MotoReq req) throws VeicoloException;
	VeicoloDTO createBici(BiciReq req) throws VeicoloException;

	VeicoloDTO updateMacchina(MacchinaReq req) throws VeicoloException;
	VeicoloDTO updateMoto(MotoReq req) throws VeicoloException;
	VeicoloDTO updateBici(BiciReq req) throws VeicoloException;

	void delete(Integer id) throws VeicoloException;
	VeicoloDTO getById(Integer id) throws VeicoloException;
	List<VeicoloDTO> listAll();
	List<VeicoloDTO> search(VeicoloSearchReq req);
	
}
