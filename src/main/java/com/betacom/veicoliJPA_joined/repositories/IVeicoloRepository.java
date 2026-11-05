package com.betacom.veicoliJPA_joined.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.betacom.veicoliJPA_joined.models.Veicolo;

public interface IVeicoloRepository extends JpaRepository<Veicolo, Integer>, JpaSpecificationExecutor<Veicolo> {

	boolean existsByMarcaId(Integer marcaId);
	boolean existsByColoreId(Integer coloreId);
	boolean existsByMarcaId(Integer marcaId);
}
