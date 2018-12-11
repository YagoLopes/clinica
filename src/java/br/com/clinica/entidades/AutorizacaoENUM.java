/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.entidades;

/**
 *
 * @author lenovo
 */
public enum AutorizacaoENUM {
    PERMITIDO("S"), NEGADO("N");

    public String value;

    AutorizacaoENUM(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
