package com.betacom.veicoliJPA_joined.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.veicoliJPA_joined.models.Alimentazione;

public interface IAlimentazioneRepository extends JpaRepository<Alimentazione, Integer> {
	Alimentazione findByDescrizioneIgnoreCase(String descrizione);

	boolean existsByDescrizione(String descrizione);
}
