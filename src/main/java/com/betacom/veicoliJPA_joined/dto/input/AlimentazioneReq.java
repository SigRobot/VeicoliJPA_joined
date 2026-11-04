package com.betacom.veicoliJPA_joined.dto.input;

import jakarta.validation.constraints.NotNull;

public class AlimentazioneReq {
	@NotNull(groups = ValidationGroup.Update.class)
	private Integer id;

	private String descrizione;
}
