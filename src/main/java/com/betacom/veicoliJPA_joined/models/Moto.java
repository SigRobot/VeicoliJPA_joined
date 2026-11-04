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
@Table(name = "moto")
@DiscriminatorValue("moto")
public class Moto extends Veicolo {

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_forcella", length = 20)
	private TipoForcella tipoForcella;

	@Column(length = 10, nullable = false, unique = true)
	private String targa;
}
