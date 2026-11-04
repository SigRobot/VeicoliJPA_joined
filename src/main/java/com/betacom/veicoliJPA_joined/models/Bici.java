package com.betacom.veicoliJPA_joined.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "bici")
@DiscriminatorValue("bici")
public class Bici extends Veicolo {

	private Integer marce;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Freno freno;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Sospensione sospensione;

	private Boolean pieghevole;
}
