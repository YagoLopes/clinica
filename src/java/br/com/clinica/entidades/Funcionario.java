/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.entidades;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class Funcionario {

    private int id;
    private String nome;
    private String rg;
    private String orgaoEmissor;
    private String cpf;
    private Endereco endereco = new Endereco();
    private String telefoneResidencial;
    private String telefoneCelular;
    private String ctps;
    private String pis;
    private Date nascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco.getEndereco();
    }

    public String getBairro() {
        return endereco.getBairro();
    }

    public String getCidade() {
        return endereco.getCidade();
    }

    public String getEstado() {
        return endereco.getEstado();
    }

    public String getComplemento() {
        return endereco.getComplemento();
    }

    public String getNumero() {
        return endereco.getNumero();
    }

    public void setEndereco(String endereco, String numero, String complemento, String bairro, String cidade, String estado) {
        this.endereco.setEndereco(endereco);
        this.endereco.setBairro(bairro);
        this.endereco.setCidade(cidade);
        this.endereco.setEstado(estado);
        this.endereco.setComplemento(complemento);
        this.endereco.setNumero(numero);
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

}
