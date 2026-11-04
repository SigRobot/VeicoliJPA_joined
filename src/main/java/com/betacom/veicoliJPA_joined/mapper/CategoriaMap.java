package com.betacom.veicoliJPA_joined.mapper;

import org.springframework.stereotype.Component;

import com.betacom.veicoliJPA_joined.dto.output.CategoriaDTO;
import com.betacom.veicoliJPA_joined.models.Categoria;

@Component
public class CategoriaMap {

    public CategoriaDTO toDto(Categoria categoria) {
        if (categoria == null) {
            return null;
        }
        return CategoriaDTO.builder()
                .id(categoria.getId())
                .descrizione(categoria.getDescrizione())
                .build();
    }
}