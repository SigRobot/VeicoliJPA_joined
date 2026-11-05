package com.betacom.veicoliJPA_joined.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoliJPA_joined.models.Macchina;
public interface IMacchinaRepository extends JpaRepository<Macchina, Integer>{
	Optional<Macchina>findByTarga(String targa);
	
	boolean existsByTarga(String targa);

}
