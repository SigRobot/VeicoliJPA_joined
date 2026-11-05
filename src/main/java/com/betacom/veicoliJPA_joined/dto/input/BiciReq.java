package com.betacom.veicoliJPA_joined.dto.input;

import com.betacom.veicoliJPA_joined.models.Freno;
import com.betacom.veicoliJPA_joined.models.Sospensione;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class BiciReq extends VeicoloReq {

	@Min(value = 1, message = "marce.inv")
	@Max(value = 30, message = "marce.inv")
	private Integer marce;

	private Freno freno;

	private Sospensione sospensione;

	private Boolean pieghevole;
}
