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

import com.betacom.veicoliJPA_joined.dto.input.ColoreReq;
import com.betacom.veicoliJPA_joined.dto.output.ColoreDTO;
import com.betacom.veicoliJPA_joined.dto.output.ResponseDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.services.interfaces.IColoreServices;
import com.betacom.veicoliJPA_joined.services.interfaces.IMessaggioServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/colore")
public class ColoreController {

	private final IColoreServices coloreS;
	private final IMessaggioServices msgS;

	@PostMapping("/create")
	public ResponseDTO create(@Valid @RequestBody ColoreReq req) throws VeicoloException {
		coloreS.create(req);
		return ResponseDTO.builder()
				.rc(true)
				.msg(msgS.get("colore.creato"))
				.build();
	}

	@PutMapping("/update")
	public ResponseDTO update(@Valid @RequestBody ColoreReq req) throws VeicoloException {
		coloreS.update(req);
		return ResponseDTO.builder()
				.rc(true)
				.msg(msgS.get("colore.aggiornato"))
				.build();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseDTO delete(@PathVariable Integer id) throws VeicoloException {
		coloreS.delete(id);
		return ResponseDTO.builder()
				.rc(true)
				.msg(msgS.get("colore.eliminato"))
				.build();
	}

	@GetMapping("/getById/{id}")
	public ColoreDTO getById(@PathVariable Integer id) throws VeicoloException {
		return coloreS.getById(id);
	}

	@GetMapping("/listAll")
	public List<ColoreDTO> listAll() {
		return coloreS.listAll();
	}
}
