package com.notificacao.scheduler;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.notificacao.model.Mensagem;
import com.notificacao.repository.MensagemRepository;
import com.notificacao.service.MensagemService;

@Component
public class MensagemScheduler {
    
    private final MensagemService service;
    private final MensagemRepository repository;

    public MensagemScheduler(MensagemService service, MensagemRepository repository){
        this.service = service;
        this.repository = repository;
    }

    


    @Scheduled(fixedRate = 10000)
    public void enviarMensagens(){
        System.out.println("Verificando Mensagens...");

        List<Mensagem> invativas = service.buscarInativas();

        for(Mensagem m : invativas){
            m.setEnviada(true);
            repository.save(m);
            System.out.println("Mensagem Enviada: " + m.getTexto());
        }
    }

}
