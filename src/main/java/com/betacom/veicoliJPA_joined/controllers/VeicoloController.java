package com.betacom.veicoliJPA_joined.controllers;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoliJPA_joined.dto.input.BiciReq;
import com.betacom.veicoliJPA_joined.dto.input.VeicoloSearchReq;
import com.betacom.veicoliJPA_joined.dto.output.VeicoloDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.services.interfaces.IVeicoloServices;

@RestController
@RequestMapping("/veicoli")
public class VeicoloController {

	@Autowired
	private IVeicoloServices veicoloS;

	@PostMapping("/macchina")
	public VeicoloDTO createMacchina(@RequestBody @Validated({Create.class, Default.class}) MacchinaReq req) throws VeicoloException {
		return veicoloS.createMacchina(req);
	}

	@PostMapping("/moto")
	public VeicoloDTO createMoto(@RequestBody @Validated({Create.class, Default.class}) MotoReq req) throws VeicoloException {
		return veicoloS.createMoto(req);
	}

	@PostMapping("/bici")
	public VeicoloDTO createBici(@RequestBody @Validated({Create.class, Default.class}) BiciReq req) throws VeicoloException {
		return veicoloS.createBici(req);
	}

	@PutMapping("/macchina")
	public VeicoloDTO updateMacchina(@RequestBody @Validated({Update.class, Default.class}) MacchinaReq req) throws VeicoloException {
		return veicoloS.updateMacchina(req);
	}

	@PutMapping("/moto")
	public VeicoloDTO updateMoto(@RequestBody @Validated({Update.class, Default.class}) MotoReq req) throws VeicoloException {
		return veicoloS.updateMoto(req);
	}

	@PutMapping("/bici")
	public VeicoloDTO updateBici(@RequestBody @Validated({Update.class, Default.class}) BiciReq req) throws VeicoloException {
		return veicoloS.updateBici(req);
	}

	@GetMapping("/{id}")
	public VeicoloDTO getById(@PathVariable Integer id) throws VeicoloException {
		return veicoloS.getById(id);
	}

	@GetMapping("/list")
	public List<VeicoloDTO> listAll() {
		return veicoloS.listAll();
	}

	@PostMapping("/search")
	public List<VeicoloDTO> search(@RequestBody VeicoloSearchReq req) {
		return veicoloS.search(req);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws VeicoloException {
		veicoloS.delete(id);
	}
}
