package com.betacom.veicoliJPA_joined.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeicoloSearchReq {
	private String tipo;            // macchina / moto / bici
	private String marca;
	private String colore;
	private String alimentazione;
	private String categoria;
	private Integer annoMin;
	private Integer annoMax;
	private Integer porte;          // filtra implicitamente le macchine
	private Integer marce;          // filtra implicitamente le bici
	private String targaAuto;
	private String targaMoto;
}
