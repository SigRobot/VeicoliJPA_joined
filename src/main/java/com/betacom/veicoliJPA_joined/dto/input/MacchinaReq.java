package com.betacom.veicoliJPA_joined.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MacchinaReq {
	private Integer id;
	private String modello;
	private Integer anno;
	private Integer ruote;
	private Integer marcaId;
	private Integer coloreId;
	private Integer alimentazioneId;
	private Integer categoriaId;
	private Integer porte;
	private String targa;

}
