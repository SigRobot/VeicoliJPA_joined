package com.betacom.veicoliJPA_joined.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.veicoliJPA_joined.dto.input.CategoriaReq;
import com.betacom.veicoliJPA_joined.dto.output.CategoriaDTO;
import com.betacom.veicoliJPA_joined.exceptions.VeicoloException;
import com.betacom.veicoliJPA_joined.mapper.CategoriaMap;
import com.betacom.veicoliJPA_joined.models.Categoria;
import com.betacom.veicoliJPA_joined.repositories.ICategoriaRepository;
import com.betacom.veicoliJPA_joined.services.interfaces.ICategoriaServices;

@Service
public class CategoriaImpl implements ICategoriaServices {

    @Autowired
    private ICategoriaRepository categoriaRepo;

    @Autowired
    private CategoriaMap categoriaMap;

    @Override
    public CategoriaDTO create(CategoriaReq req) throws VeicoloException {
        if (categoriaRepo.existsByDescrizione(req.getDescrizione())) {
            throw new VeicoloException("Categoria già esistente");
        }

        Categoria categoria = new Categoria();
        categoria.setDescrizione(req.getDescrizione());
        
        Categoria savedCategoria = categoriaRepo.save(categoria);
        
        return categoriaMap.toDto(savedCategoria);
    }

    @Override
    public List<CategoriaDTO> listAll() {
        return categoriaRepo.findAll().stream()
                .map(categoriaMap::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) throws VeicoloException {
        Categoria categoria = categoriaRepo.findById(id)
                .orElseThrow(() -> new VeicoloException("Categoria non trovata con ID: " + id));
        
        categoriaRepo.delete(categoria);
    }

    @Override
    public void update(CategoriaReq req) throws VeicoloException {
        if (req.getId() == null) {
            throw new VeicoloException("L'ID della categoria è obbligatorio per l'aggiornamento");
        }
        
        Categoria categoria = categoriaRepo.findById(req.getId())
                .orElseThrow(() -> new VeicoloException("Categoria non trovata con ID: " + req.getId()));

        if (!categoria.getDescrizione().equalsIgnoreCase(req.getDescrizione()) && 
            categoriaRepo.existsByDescrizione(req.getDescrizione())) {
            throw new VeicoloException("Descrizione categoria già in uso");
        }

        categoria.setDescrizione(req.getDescrizione());
        categoriaRepo.save(categoria);
    }
}