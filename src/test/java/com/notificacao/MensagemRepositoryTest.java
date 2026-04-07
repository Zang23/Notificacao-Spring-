package com.notificacao;

import com.notificacao.model.Mensagem;
import com.notificacao.repository.MensagemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MensagemRepositoryTest {

    @Autowired
    private MensagemRepository repository;

    @Test
    public void testSalvarEBuscarMensagem() {
        
        Mensagem msg = new Mensagem("Teste conexão banco");
        repository.save(msg);

        
        List<Mensagem> mensagens = repository.findAll();

        
        assertThat(mensagens).isNotEmpty();

        System.out.println("Banco funcionando! Mensagens encontradas: " + mensagens.size());
    }
}