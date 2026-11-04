package com.betacom.veicoliJPA_joined.services.interfaces;

import java.util.List;

import com.betacom.veicoliJPA_joined.dto.input.CategoriaReq;
import com.betacom.veicoliJPA_joined.dto.output.CategoriaDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException; // Aggiungi questo import

public interface ICategoriaServices {
    
    
    CategoriaDTO create(CategoriaReq req) throws VeicoloException;
    
    void update(CategoriaReq req) throws VeicoloException;
    
    void delete(Integer id) throws VeicoloException;
    
  
    List<CategoriaDTO> listAll();
}