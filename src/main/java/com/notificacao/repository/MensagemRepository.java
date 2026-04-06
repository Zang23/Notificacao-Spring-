package com.notificacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificacao.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
    
}
