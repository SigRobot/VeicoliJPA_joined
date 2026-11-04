package com.betacom.veicoliJPA_joined.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "macchina")
@DiscriminatorValue("macchina")
public class Macchina extends Veicolo {

	@Column(nullable = false)
	private Integer porte;

	@Column(length = 10, nullable = false, unique = true)
	private String targa;
}
