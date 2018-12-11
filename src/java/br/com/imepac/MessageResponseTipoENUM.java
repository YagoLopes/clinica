/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imepac;

/**
 *
 * @author lenovo
 */
public enum MessageResponseTipoENUM {
    ERROR("alert-danger"), WARNING("alert-warning"), SUCCESS("alert-success"), INFO("alert-info");
    private String format;

    MessageResponseTipoENUM(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
