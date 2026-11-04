package com.betacom.veicoliJPA_joined.mapper;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.output.MotoDTO;
import com.betacom.veicoliJPA_joined.models.Moto;

public class MotoMap {

	private MotoMap() {
	}

	public static MotoDTO toDTO(Moto m) {
		return MotoDTO.builder()
				.id(m.getId())
				.tipoVeicolo(m.getTipoVeicolo())
				.modello(m.getModello())
				.anno(m.getAnno())
				.ruote(m.getRuote())
				.marca(m.getMarca() == null ? null : m.getMarca().getDescrizione())
				.colore(m.getColore() == null ? null : m.getColore().getDescrizione())
				.alimentazione(m.getAlimentazione() == null ? null : m.getAlimentazione().getDescrizione())
				.categoria(m.getCategoria() == null ? null : m.getCategoria().getDescrizione())
				.tipoForcella(m.getTipoForcella() == null ? null : m.getTipoForcella().name())
				.targa(m.getTarga())
				.build();
	}

	public static List<MotoDTO> toDTOList(List<Moto> lM) {
		return lM.stream()
				.map(MotoMap::toDTO)
				.toList();
	}
}
