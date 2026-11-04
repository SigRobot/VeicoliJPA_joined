package com.betacom.veicoliJPA_joined.mapper;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.input.ColoreReq;
import com.betacom.veicoliJPA_joined.dto.output.ColoreDTO;
import com.betacom.veicoliJPA_joined.models.Colore;

public class ColoreMap {

	private ColoreMap() {
	}

	public static ColoreDTO toDTO(Colore c) {
		return ColoreDTO.builder()
				.id(c.getId())
				.descrizione(c.getDescrizione())
				.build();
	}

	public static List<ColoreDTO> toDTO(List<Colore> lista) {
		return lista.stream().map(ColoreMap::toDTO).toList();
	}

	public static Colore toEntity(ColoreReq req) {
		Colore c = new Colore();
		c.setDescrizione(req.getDescrizione());
		return c;
	}
}
