package com.betacom.veicoliJPA_joined.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ColoreReq {

	private Integer id;

	@NotBlank(message = "cat.desc.req")
	@Size(max = 30, message = "colore.descr.troppo.lunga")
	private String descrizione;
}
