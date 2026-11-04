package com.betacom.veicoliJPA_joined.dto.input;

import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup.Create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MacchinaReq extends VeicoloReq{
	@Min(value = 1900, message = "anno.non.valido", groups = { OnCreate.class, OnUpdate.class })
	@Max(value = 2100, message = "anno.non.valido", groups = { OnCreate.class, OnUpdate.class })
	private Integer anno;
	@Min(value = 4, message = "ruote.non.valido", groups = {OnCreate.class, OnUpdate.class})
	@Max(value = 6, message = "ruote.non.valido", groups = {OnCreate.class, OnUpdate.class})
	private Integer ruote;
	@Min(value = 3, message = "porte.non.valide", groups = {OnCreate.class, OnUpdate.class})
	@Max(value = 5, message = "porte.non.valide", groups = {OnCreate.class, OnUpdate.class})
	private Integer porte;
	@NotBlank(groups = Create.class, message = "veicolo.targa.obbligatoria")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$", message = "veicolo.targa.auto.formato")
	private String targa;

}