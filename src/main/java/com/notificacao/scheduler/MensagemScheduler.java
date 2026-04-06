package com.notificacao.scheduler;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.notificacao.model.Mensagem;
import com.notificacao.service.MensagemService;

@Component
public class MensagemScheduler {
    
    private final MensagemService service;

    public MensagemScheduler(MensagemService service){
        this.service = service;
    }


    @Scheduled(fixedRate = 10000)
    public void enviarMensagens(){
        System.out.println("Verificando Mensagens...");

        List<Mensagem> invativas = service.buscarInativas();

        for(Mensagem m : invativas){
            m.setEnviada(true);
            System.out.println("Mensagem Enviada: " + m.getTexto());
        }
    }

}
