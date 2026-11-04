package com.betacom.veicoliJPA_joined.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MarcaReq {

	// obbligatorio solo in update (il controllo è nel service)
	private Integer id;

	// i message sono CODE: vengono tradotti da ExceptionManager tramite messaggi_sistema
	@NotBlank(message = "marca.descr.obbligatoria")
	@Size(max = 50, message = "marca.descr.troppo.lunga")
	private String descrizione;
}
