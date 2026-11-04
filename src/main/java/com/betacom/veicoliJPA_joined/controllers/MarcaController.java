package com.betacom.veicoliJPA_joined.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.veicoliJPA_joined.dto.input.MarcaReq;
import com.betacom.veicoliJPA_joined.dto.output.MarcaDTO;
import com.betacom.veicoliJPA_joined.dto.output.ResponseDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.services.interfaces.IMarcaServices;
import com.betacom.veicoliJPA_joined.services.interfaces.IMessaggioServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// le eccezioni (VeicoloException, validazione, ecc.) sono gestite da ExceptionManager
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/marca")
public class MarcaController {

	private final IMarcaServices marcaS;
	private final IMessaggioServices msgS;

	@PostMapping("/create")
	public ResponseDTO create(@Valid @RequestBody MarcaReq req) throws VeicoloException {
		marcaS.create(req);
		return ResponseDTO.builder()
				.rc(true)
				.msg(msgS.get("marca.creata"))
				.build();
	}

	@PutMapping("/update")
	public ResponseDTO update(@Valid @RequestBody MarcaReq req) throws VeicoloException {
		marcaS.update(req);
		return ResponseDTO.builder()
				.rc(true)
				.msg(msgS.get("marca.aggiornata"))
				.build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseDTO delete(@PathVariable Integer id) throws VeicoloException {
		marcaS.delete(id);
		return ResponseDTO.builder()
				.rc(true)
				.msg(msgS.get("marca.eliminata"))
				.build();
	}

	@GetMapping("/getById/{id}")
	public MarcaDTO getById(@PathVariable Integer id) throws VeicoloException {
		return marcaS.getById(id);
	}

	@GetMapping("/listAll")
	public List<MarcaDTO> listAll() {
		return marcaS.listAll();
	}
}