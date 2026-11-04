package com.betacom.veicoliJPA_joined.dto.input;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoReq {

	@NotNull(message = "id.obbligatorio", groups = OnUpdate.class)
	private Integer id;               

	@NotBlank(message = "modello.obbligatorio", groups = OnCreate.class)
	@Size(max = 50, message = "modello.troppo.lungo", groups = { OnCreate.class, OnUpdate.class })
	private String modello;

	@Min(value = 1900, message = "anno.non.valido", groups = { OnCreate.class, OnUpdate.class })
	@Max(value = 2100, message = "anno.non.valido", groups = { OnCreate.class, OnUpdate.class })
	private Integer anno;

	@Min(value = 2, message = "ruote.non.valide", groups = { OnCreate.class, OnUpdate.class })
	@Max(value = 3, message = "ruote.non.valide", groups = { OnCreate.class, OnUpdate.class })
	private Integer ruote;            

	@NotNull(message = "marca.obbligatoria", groups = OnCreate.class)
	private Integer marcaId;

	private Integer coloreId;         

	@NotNull(message = "alimentazione.obbligatoria", groups = OnCreate.class)
	private Integer alimentazioneId;

	@NotNull(message = "categoria.obbligatoria", groups = OnCreate.class)
	private Integer categoriaId;

	@Pattern(regexp = "(?i)TELESCOPICA|UPSIDE_DOWN|RIGIDA", message = "tipo.forcella.non.valido",
			groups = { OnCreate.class, OnUpdate.class })
	private String tipoForcella;      

	@NotBlank(message = "targa.obbligatoria", groups = OnCreate.class)
	@Size(max = 10, message = "targa.troppo.lunga", groups = { OnCreate.class, OnUpdate.class })
	private String targa;
}
