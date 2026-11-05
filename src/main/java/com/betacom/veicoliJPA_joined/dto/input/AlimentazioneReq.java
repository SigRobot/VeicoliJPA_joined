package com.betacom.veicoliJPA_joined.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlimentazioneReq {
	@NotNull(groups = ValidationGroup.Update.class, message = "alim-id-not-present")
	private Integer id;
	
	@NotNull(groups = {ValidationGroup.Update.class, ValidationGroup.Create.class}, message = "alim-desc-not-present")
	@NotBlank(groups = {ValidationGroup.Update.class, ValidationGroup.Create.class}, message = "alim-desc-not-present")
	private String descrizione;
}
