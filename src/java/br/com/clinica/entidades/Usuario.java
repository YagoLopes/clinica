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
public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private AutorizacaoENUM cadastrarFuncionario;
    private AutorizacaoENUM cadastrarUsuario;
    private AutorizacaoENUM cadastrarPaciente;
    private AutorizacaoENUM cadastrarEspecialidade;
    private AutorizacaoENUM cadastrarMedico;
    private AutorizacaoENUM cadastrarConvenio;
    private AutorizacaoENUM agendarConsulta;
    private AutorizacaoENUM cancelarConsulta;
    private AutorizacaoENUM moduloAdministrativo;
    private AutorizacaoENUM moduloAgendamento;
    private AutorizacaoENUM moduloAtendimento;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public AutorizacaoENUM getCadastrarFuncionario() {
        return cadastrarFuncionario;
    }

    public void setCadastrarFuncionario(AutorizacaoENUM cadastrarFuncionario) {
        this.cadastrarFuncionario = cadastrarFuncionario;
    }

    public AutorizacaoENUM getCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public void setCadastrarUsuario(AutorizacaoENUM cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    public AutorizacaoENUM getCadastrarPaciente() {
        return cadastrarPaciente;
    }

    public void setCadastrarPaciente(AutorizacaoENUM cadastrarPaciente) {
        this.cadastrarPaciente = cadastrarPaciente;
    }

    public AutorizacaoENUM getCadastrarEspecialidade() {
        return cadastrarEspecialidade;
    }

    public void setCadastrarEspecialidade(AutorizacaoENUM cadastrarEspecialidade) {
        this.cadastrarEspecialidade = cadastrarEspecialidade;
    }

    public AutorizacaoENUM getCadastrarMedico() {
        return cadastrarMedico;
    }

    public void setCadastrarMedico(AutorizacaoENUM cadastrarMedico) {
        this.cadastrarMedico = cadastrarMedico;
    }

    public AutorizacaoENUM getCadastrarConvenio() {
        return cadastrarConvenio;
    }

    public void setCadastrarConvenio(AutorizacaoENUM cadastrarConvenio) {
        this.cadastrarConvenio = cadastrarConvenio;
    }

    public AutorizacaoENUM getAgendarConsulta() {
        return agendarConsulta;
    }

    public void setAgendarConsulta(AutorizacaoENUM agendarConsulta) {
        this.agendarConsulta = agendarConsulta;
    }

    public AutorizacaoENUM getCancelarConsulta() {
        return cancelarConsulta;
    }

    public void setCancelarConsulta(AutorizacaoENUM cancelarConsulta) {
        this.cancelarConsulta = cancelarConsulta;
    }

    public AutorizacaoENUM getModuloAdministrativo() {
        return moduloAdministrativo;
    }

    public void setModuloAdministrativo(AutorizacaoENUM moduloAdministrativo) {
        this.moduloAdministrativo = moduloAdministrativo;
    }

    public AutorizacaoENUM getModuloAgendamento() {
        return moduloAgendamento;
    }

    public void setModuloAgendamento(AutorizacaoENUM moduloAgendamento) {
        this.moduloAgendamento = moduloAgendamento;
    }

    public AutorizacaoENUM getModuloAtendimento() {
        return moduloAtendimento;
    }

    public void setModuloAtendimento(AutorizacaoENUM moduloAtendimento) {
        this.moduloAtendimento = moduloAtendimento;
    }

}
