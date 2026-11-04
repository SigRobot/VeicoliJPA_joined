package com.betacom.veicoliJPA_joined.mapper;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.output.MacchinaDTO;
import com.betacom.veicoliJPA_joined.models.Macchina;

public class MacchinaMap {
	private MacchinaMap() {
		
	}
	public static MacchinaDTO toDTO(Macchina m) {
		return MacchinaDTO.builder().
				id(m.getId()).
				tipoVeicolo(m.getTipoVeicolo()).
				modello(m.getModello()).
				anno(m.getAnno()).
				ruote(m.getRuote()).
				marca(m.getMarca() == null ? null:m.getMarca().getDescrizione()).
				colore(m.getColore() == null ? null:m.getColore().getDescrizione()).
				alimentazione(m.getAlimentazione() == null ? null:m.getAlimentazione().getDescrizione()).
				categoria(m.getCategoria() == null ? null:m.getCategoria().getDescrizione()).
				porte(m.getPorte()).
				targa(m.getTarga()).
				build();
				
				
	}
	public static List<MacchinaDTO> toDTOList(List<Macchina> lM){
		return lM.stream()
				.map(MacchinaMap::toDTO)
				.toList();
	}

}
