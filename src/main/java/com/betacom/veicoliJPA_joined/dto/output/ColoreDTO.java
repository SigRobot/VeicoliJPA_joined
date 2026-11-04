package com.betacom.veicoliJPA_joined.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ColoreDTO {
	private Integer id;
	private String descrizione;
}
