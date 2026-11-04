package com.betacom.veicoliJPA_joined.dto.output;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class MotoDTO extends ResponseDTO{
	private Integer id;
	private String tipoVeicolo;
	private String modello;
	private Integer anno;
	private Integer ruote;
	private String marca;
	private String colore;
	private String alimentazione;
	private String categoria;
	private String tipoForcella;
	private String targa;
}
