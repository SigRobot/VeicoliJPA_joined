package com.betacom.veicoliJPA_joined.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.veicoliJPA_joined.models.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Integer> {

}
