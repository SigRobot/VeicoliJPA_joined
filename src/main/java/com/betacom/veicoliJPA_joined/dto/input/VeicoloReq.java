package com.betacom.veicoliJPA_joined.dto.input;


import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup.Create;
import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup.Update;

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

	@NotNull(groups = Update.class, message = "id.req")
	private Integer id;

	@NotBlank(groups = Create.class, message = "modello.req")
	private String modello;

	@Min(value = 1900, message = "anno.inv")
	@Max(value = 2100, message = "anno.inv")
	private Integer anno;

	// ruote: vincolo stretto nei figli, qui niente
	@NotNull(groups = Create.class, message = "ruote.req")
	@Min(value = 2, groups = {Create.class, Update.class}, message = "ruote.auto.inv")
	@Max(value = 6, groups = {Create.class, Update.class}, message = "ruote.auto.inv")
	private Integer ruote;

	@NotBlank(groups = Create.class, message = "marca.req")
	private String marca;

	private String colore;   // opzionale

	@NotBlank(groups = Create.class, message = "alim.req")
	private String alimentazione;

	@NotBlank(groups = Create.class, message = "cat.req")
	private String categoria;
}
