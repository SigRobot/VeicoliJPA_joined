package com.betacom.veicoliJPA_joined.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.veicoliJPA_joined.models.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
