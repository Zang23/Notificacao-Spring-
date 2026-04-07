package com.notificacao.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.notificacao.dto.MensagemDTO;
import com.notificacao.model.Mensagem;
import com.notificacao.repository.MensagemRepository;
import com.notificacao.service.MensagemService;

import org.springframework.ui.Model;

@Controller
@RequestMapping
public class MensagemController {

    private final MensagemService service;
    private final MensagemRepository mensagemRepository;

    public MensagemController(MensagemService service, MensagemRepository mensagemRepository){
        this.service = service;
        this.mensagemRepository = mensagemRepository;
    }

    
    // Endpoints Thymeleaf
   

    @GetMapping("/mensagens")
    public ModelAndView listarMensagens(Model model) {

        ModelAndView mv = new ModelAndView("mensagens");
        List<Mensagem> mensagens = mensagemRepository.findAll();



        mv.addObject("mensagens", mensagens);

        return mv; 
    }   

    @PostMapping("/mensagens")
    public String cadastrarMensagem(@RequestParam("texto") String texto){
        
        try{
            service.cadastrarMensagem(texto);
        }catch(RuntimeException e){
            e.printStackTrace();
        }

        return "redirect:/mensagens";
    }

    @PostMapping("/mensagens/{id}")
    public String editarMensagem(@PathVariable Long id, @RequestParam("novoTexto") String novoTexto){
        
        try{
            service.editarMensagem(id, novoTexto);
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        
        return "redirect:/mensagens";
    }

    @PostMapping("/mensagens/{id}/delete")
    public String deletarMensagem(@PathVariable Long id){
        try{
            service.removerMensagem(id);
        }catch(RuntimeException e){
            e.printStackTrace();
        }

        return "redirect:/mensagens";
    }
    
    
    // Endpoints REST
  
    @RestController
    @RequestMapping("/api/mensagens")
    static class MensagemRestController {

        private final MensagemService service;

        public MensagemRestController(MensagemService service) {
            this.service = service;
        }

        @GetMapping
        public List<Mensagem> listar() {
            return service.listar();
        }

        @PostMapping
        public ResponseEntity<?> criar(@RequestBody MensagemDTO dto){
            try {
                Mensagem nova = service.cadastrarMensagem(dto.getTexto());
                return ResponseEntity.status(201).body(nova);
            } catch (IllegalArgumentException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping("/inativas")
        public List<Mensagem> listarInativas(){
            return service.buscarInativas();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> buscar(@PathVariable long id){
            try{
                Mensagem msg = service.buscarMensagem(id);
                return ResponseEntity.ok(msg);            
            } catch(RuntimeException e){
                return ResponseEntity.status(404).body(e.getMessage());
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> editar(@PathVariable long id, @RequestBody String novoTxt){
            try{
                Mensagem msg =  service.editarMensagem(id, novoTxt);
                return ResponseEntity.ok(msg);
            } catch(IllegalArgumentException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            } catch(RuntimeException e){
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
}