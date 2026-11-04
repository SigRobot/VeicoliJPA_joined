package com.betacom.veicoliJPA_joined.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.veicoliJPA_joined.models.Messaggi;
import com.betacom.veicoliJPA_joined.models.MessaggiID;

@Repository
public interface IMessaggiRepository extends JpaRepository<Messaggi, MessaggiID> {

}