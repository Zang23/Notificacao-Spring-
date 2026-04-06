package com.notificacao.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.stereotype.Service;

import com.notificacao.model.Mensagem;
import com.notificacao.repository.MensagemRepository;

@Service
public class MensagemService {

    private final MensagemRepository repository;

    public MensagemService(MensagemRepository repository){
        this.repository = repository;
    }

    public Mensagem cadastrarMensagem(String texto){
        if(texto == null || texto.isBlank()){
            throw new IllegalArgumentException("Texto invalido");
        }

        Mensagem msg = new Mensagem(texto);
        return repository.save(msg);
       
    }

    public List<Mensagem> listar(){
    
        return repository.findAll();

    }

    public Mensagem buscarMensagem(long id){
        
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));

    }

    public List<Mensagem> buscarInativas(){

        List<Mensagem> todas = repository.findAll();
        List<Mensagem> inativas = new ArrayList<>();

        for(Mensagem m : todas){
            if(!m.isEnviada()){
                inativas.add(m);
            }
        }

        return inativas;

    }

    public Mensagem editarMensagem (long id, String novoTxt){

        if (novoTxt == null || novoTxt.isBlank()) {
            throw new IllegalArgumentException("Texto inválido");
        }

        Mensagem msg = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));

        msg.setTexto(novoTxt);
        msg.setEnviada(false);

        return repository.save(msg);
        
    }

    public boolean removerMensagem(long id){
        

        if(!repository.existsById(id)){
            return false;
        }

        repository.deleteById(id);
        return true;


    }


    
}
