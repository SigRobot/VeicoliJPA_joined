package com.betacom.veicoliJPA_joined.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaReq {

	private Integer id;  
	
	@NotBlank(message = "categoria.desc.obbligatoria")
	private String descrizione;
}
