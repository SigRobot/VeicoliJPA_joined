package com.betacom.veicoliJPA_joined.dto.input;

import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup.Create;
import com.betacom.veicoliJPA_joined.models.TipoForcella;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// i campi comuni (id, modello, anno, ruote, marca, ...) sono in VeicoloReq
@Getter
@Setter
@ToString(callSuper = true)
public class MotoReq extends VeicoloReq {

	// enum: un valore non valido nel JSON viene gestito da ExceptionManager (json.non.valido)
	private TipoForcella tipoForcella;

	@NotBlank(groups = Create.class, message = "veicolo.targa.obbligatoria")
	@Size(max = 10, message = "veicolo.targa.troppo.lunga")
	private String targa;

	// vincolo stretto sulle ruote (il campo è in VeicoloReq): una moto ne ha 2 o 3
	@JsonIgnore
	@AssertTrue(message = "veicolo.ruote.nonvalide")
	public boolean isRuoteValide() {
		return getRuote() == null || (getRuote() >= 2 && getRuote() <= 3);
	}
}
