package com.betacom.veicoliJPA_joined.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.betacom.veicoliJPA_joined.models.Colore;
@Repository
public interface IColoreRepository extends JpaRepository<Colore, Integer> {
	

}
