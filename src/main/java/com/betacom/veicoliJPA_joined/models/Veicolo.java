package com.betacom.veicoliJPA_joined.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "veicolo")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_veicolo", discriminatorType = DiscriminatorType.STRING)
public class Veicolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tipo_veicolo", insertable = false, updatable = false)
	private String tipoVeicolo;

	@Column(length = 50, nullable = false)
	private String modello;

	private Integer anno;

	@Column(nullable = false)
	private Integer ruote;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marca_id", nullable = false)
	private Marca marca;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "colore_id")
	private Colore colore;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "alimentazione_id", nullable = false)
	private Alimentazione alimentazione;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;
}
