package com.betacom.veicoliJPA_joined.mapper;

import com.betacom.veicoliJPA_joined.dto.output.AlimentazioneDTO;
import com.betacom.veicoliJPA_joined.models.Alimentazione;

public class AlimentazioneMap {

	private AlimentazioneMap() {}

	public static AlimentazioneDTO mapToDTO(Alimentazione a) {
		return AlimentazioneDTO.builder()
				.id(a.getId())
				.descrizione(a.getDescrizione())
				.build();
	}
}
