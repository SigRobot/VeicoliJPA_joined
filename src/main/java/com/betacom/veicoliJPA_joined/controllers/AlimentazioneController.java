package com.betacom.veicoliJPA_joined.controllers;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoliJPA_joined.dto.input.AlimentazioneReq;
import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup;
import com.betacom.veicoliJPA_joined.dto.output.AlimentazioneDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.services.interfaces.IAlimentazioneServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/alimentazione")
public class AlimentazioneController {
	
	private IAlimentazioneServices alimS;
	
	@PostMapping("/createAlimentazione")
	public AlimentazioneDTO create(@RequestBody @Validated(ValidationGroup.Create.class) AlimentazioneReq req) throws VeicoloException {
		return alimS.create(req);
	}
	
	@PostMapping("/updateAlimentazione")
	public AlimentazioneDTO update(@RequestBody @Validated(ValidationGroup.Update.class) AlimentazioneReq req) throws VeicoloException {
		return alimS.update(req);
	}
	
	@GetMapping("/list")
	public List<AlimentazioneDTO> listAll() {
		return alimS.listAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws VeicoloException {
		alimS.delete(id);
	}
	
}
