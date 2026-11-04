package com.betacom.veicoliJPA_joined.mapper;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.input.MarcaReq;
import com.betacom.veicoliJPA_joined.dto.output.MarcaDTO;
import com.betacom.veicoliJPA_joined.models.Marca;

public class MarcaMap {

	private MarcaMap() {
	}

	public static MarcaDTO toDTO(Marca m) {
		return MarcaDTO.builder()
				.id(m.getId())
				.descrizione(m.getDescrizione())
				.build();
	}

	public static List<MarcaDTO> toDTO(List<Marca> lista) {
		return lista.stream().map(MarcaMap::toDTO).toList();
	}

	// l'id non viene copiato: lo gestisce il DB (IDENTITY) o il service in update
	public static Marca toEntity(MarcaReq req) {
		Marca m = new Marca();
		m.setDescrizione(req.getDescrizione());
		return m;
	}
}
