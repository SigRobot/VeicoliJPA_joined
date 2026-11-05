package com.betacom.veicoliJPA_joined.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlimentazioneReq {

	private Integer id;   // usato in update

	@NotBlank(message = "alimentazione.descrizione.obbligatoria")
	private String descrizione;
}
