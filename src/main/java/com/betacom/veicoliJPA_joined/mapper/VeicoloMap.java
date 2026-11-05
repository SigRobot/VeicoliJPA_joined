package com.betacom.veicoliJPA_joined.mapper;

import com.betacom.veicoliJPA_joined.dto.output.VeicoloDTO;
import com.betacom.veicoliJPA_joined.dto.output.VeicoloDTO.VeicoloDTOBuilder;
import com.betacom.veicoliJPA_joined.models.Bici;
import com.betacom.veicoliJPA_joined.models.Macchina;
import com.betacom.veicoliJPA_joined.models.Moto;
import com.betacom.veicoliJPA_joined.models.Veicolo;

public class VeicoloMap {

	private VeicoloMap() {}

	public static VeicoloDTO mapToDTO(Veicolo v) {
		VeicoloDTOBuilder<?, ?> b = VeicoloDTO.builder()
				.id(v.getId())
				.tipo(v.getTipoVeicolo())
				.modello(v.getModello())
				.anno(v.getAnno())
				.ruote(v.getRuote())
				.marca(v.getMarca() != null ? v.getMarca().getDescrizione() : null)
				.colore(v.getColore() != null ? v.getColore().getDescrizione() : null)
				.alimentazione(v.getAlimentazione() != null ? v.getAlimentazione().getDescrizione() : null)
				.categoria(v.getCategoria() != null ? v.getCategoria().getDescrizione() : null);

		if (v instanceof Macchina m) {
			b.porte(m.getPorte()).targa(m.getTarga());
		} else if (v instanceof Moto mo) {
			b.targa(mo.getTarga())
			 .tipoForcella(mo.getTipoForcella() != null ? mo.getTipoForcella().name() : null);
		} else if (v instanceof Bici bi) {
			b.marce(bi.getMarce())
			 .freno(bi.getFreno() != null ? bi.getFreno().name() : null)
			 .sospensione(bi.getSospensione() != null ? bi.getSospensione().name() : null)
			 .pieghevole(bi.getPieghevole());
		}

		return b.build();
	}
}
