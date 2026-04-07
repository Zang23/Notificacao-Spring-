package com.notificacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mensagem {
    

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String texto;
    private boolean enviada;

    public Mensagem() {
    }

    public Mensagem(String texto){
        this.texto = texto;
        this.enviada = false;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isEnviada() {
        return enviada;
    }

    public void setEnviada(boolean enviada) {
        this.enviada = enviada;
    }

    public long getId() {
        return id;
    }
    

}
