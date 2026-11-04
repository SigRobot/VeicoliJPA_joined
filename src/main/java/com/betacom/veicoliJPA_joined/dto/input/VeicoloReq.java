package com.betacom.veicoliJPA_joined.dto.input;


import org.hibernate.sql.Update;

import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup.Create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class VeicoloReq {

	@NotNull(groups = Update.class, message = "veicolo.id.obbligatorio")
	private Integer id;

	@NotBlank(groups = Create.class, message = "veicolo.modello.obbligatorio")
	private String modello;

	@Min(value = 1900, message = "veicolo.anno.nonvalido")
	@Max(value = 2100, message = "veicolo.anno.nonvalido")
	private Integer anno;

	// ruote: vincolo stretto nei figli, qui niente
	@NotNull(groups = Create.class, message = "veicolo.ruote.obbligatorie")
	private Integer ruote;

	@NotBlank(groups = Create.class, message = "veicolo.marca.obbligatoria")
	private String marca;

	private String colore;   // opzionale

	@NotBlank(groups = Create.class, message = "veicolo.alimentazione.obbligatoria")
	private String alimentazione;

	@NotBlank(groups = Create.class, message = "veicolo.categoria.obbligatoria")
	private String categoria;
}
