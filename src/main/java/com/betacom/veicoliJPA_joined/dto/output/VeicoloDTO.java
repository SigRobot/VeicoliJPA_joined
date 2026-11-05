package com.betacom.veicoliJPA_joined.dto.output;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class VeicoloDTO extends ResponseDTO {

	private Integer id;
	private String tipo;
	private String modello;
	private Integer anno;
	private Integer ruote;
	private String marca;
	private String colore;
	private String alimentazione;
	private String categoria;

	// specifici: valorizzati solo per il tipo pertinente
	private Integer porte;
	private String targa;
	private String tipoForcella;
	private Integer marce;
	private String freno;
	private String sospensione;
	private Boolean pieghevole;
}
