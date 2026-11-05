package com.betacom.veicoliJPA_joined.mapper;

import com.betacom.veicoliJPA_joined.dto.output.AlimentazioneDTO;
import com.betacom.veicoliJPA_joined.models.Alimentazione;

public class AlimentazioneMap {
	public static AlimentazioneDTO mapToDTO(Alimentazione c) {
		return AlimentazioneDTO.builder()
				.id(c.getId())
				.descrizione(c.getDescrizione())
				.build();
	}
}
