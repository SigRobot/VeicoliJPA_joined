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

	@Min(value = 1, message = "bici.marce.nonvalide")
	@Max(value = 30, message = "bici.marce.nonvalide")
	private Integer marce;

	private Freno freno;

	private Sospensione sospensione;

	private Boolean pieghevole;

	@Min(value = 2, message = "bici.ruote.nonvalide")
	@Max(value = 2, message = "bici.ruote.nonvalide")
	private Integer ruote;
}
