package com.betacom.veicoliJPA_joined.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.betacom.veicoliJPA_joined.models.Veicolo;

@Repository
public interface IVeicoloRepository extends JpaRepository<Veicolo, Integer>, JpaSpecificationExecutor<Veicolo> {

	boolean existsByColoreId(Integer coloreId);
	boolean existsByMarcaId(Integer marcaId);
}
