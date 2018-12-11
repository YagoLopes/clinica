/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imepac;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class MessageResponse {

    private MessageResponseTipoENUM tipo;
    private String message;
    private List<String> itens = new ArrayList<String>();

    public MessageResponse(String message, MessageResponseTipoENUM tipo) {
        this.message = message;
        this.tipo = tipo;
    }

    public String getMessage() {
        return message;
    }

    public MessageResponseTipoENUM getTipo() {
        return tipo;
    }

    public String getFormat() {
        return tipo.getFormat();
    }

}
