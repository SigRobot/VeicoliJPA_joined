package com.betacom.veicoliJPA_joined.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoliJPA_joined.dto.input.AlimentazioneReq;
import com.betacom.veicoliJPA_joined.dto.output.AlimentazioneDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.services.interfaces.IAlimentazioneServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alimentazioni")
public class AlimentazioneController {

	@Autowired
	private IAlimentazioneServices alimentazioneS;

	@PostMapping("/create")
	public AlimentazioneDTO create(@RequestBody @Valid AlimentazioneReq req) throws VeicoloException {
		return alimentazioneS.create(req);
	}

	@PutMapping("/update")
	public AlimentazioneDTO update(@RequestBody AlimentazioneReq req) throws VeicoloException {
		return alimentazioneS.update(req);
	}

	@GetMapping("/list")
	public List<AlimentazioneDTO> listAll() {
		return alimentazioneS.listAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws VeicoloException {
		alimentazioneS.delete(id);
	}
}
