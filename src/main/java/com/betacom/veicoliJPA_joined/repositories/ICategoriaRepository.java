package com.betacom.veicoliJPA_joined.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoliJPA_joined.models.Categoria;


public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
  
    boolean existsByDescrizione(String descrizione);
    Optional<Categoria> findByDescrizioneIgnoreCase(String descrizione); 
}
