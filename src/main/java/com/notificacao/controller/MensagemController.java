package com.notificacao.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notificacao.model.Mensagem;
import com.notificacao.service.MensagemService;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
     
    

    private final MensagemService service;


    public MensagemController(MensagemService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Mensagem msg){
        
        try{
            Mensagem nova = service.cadastrarMensagem(msg.getTexto());
            return ResponseEntity.status(201).body(nova);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<Mensagem>> listar(){
        List<Mensagem> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/inativas")
    public ResponseEntity<List<Mensagem>> listarInativas(){
        return ResponseEntity.ok(service.buscarInativas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id){
        
        try{
            Mensagem msg = service.buscarMensagem(id);
            return ResponseEntity.ok(msg);            
        }catch(RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable long id, @RequestBody String novoTxt){

        try{
            Mensagem msg =  service.editarMensagem(id, novoTxt);
            return ResponseEntity.ok(msg);
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
        
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        
        if(service.removerMensagem(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(404).body("Mensagem nao encontrada");
    }

    




}
