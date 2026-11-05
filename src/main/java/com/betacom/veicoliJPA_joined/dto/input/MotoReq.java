package com.betacom.veicoliJPA_joined.dto.input;

import com.betacom.veicoliJPA_joined.dto.input.ValidationGroup.Create;
import com.betacom.veicoliJPA_joined.models.TipoForcella;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
	
	@NotBlank(groups = Create.class, message = "targa.req")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{5}$", message = "targa.moto.fmt")
	private String targa;
}
