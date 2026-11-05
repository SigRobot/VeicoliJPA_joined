package com.betacom.veicoliJPA_joined.dto.input;

import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup.Create;
import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup.Update;

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
	
	
	@Min(value = 3, message = "porte.inv", groups = {Create.class, Update.class})
	@Max(value = 5, message = "porte.inv", groups = {Create.class, Update.class})
	private Integer porte;
	@NotBlank(groups = Create.class, message = "targa.req")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$", message = "targa.auto.fmt")
	private String targa;

}