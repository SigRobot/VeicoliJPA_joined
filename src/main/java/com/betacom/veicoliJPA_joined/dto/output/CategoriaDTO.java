package com.betacom.veicoliJPA_joined.dto.output;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class CategoriaDTO extends ResponseDTO {

	private Integer id;
	private String descrizione;
}

