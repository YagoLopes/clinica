/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao;

import br.com.clinica.entidades.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class FuncionarioDAO extends GenericDAO implements IPersistent<Funcionario> {

    public FuncionarioDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void save(Funcionario entity) throws SQLException {
        String sql = "INSERT INTO FUNCIONARIOS VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, entity.getNome());
        stm.setString(2, entity.getRg());
        stm.setString(3, entity.getOrgaoEmissor());
        stm.setString(4, entity.getCpf());
        stm.setString(5, entity.getEndereco());
        stm.setString(6, entity.getNumero());
        stm.setString(7, entity.getComplemento());
        stm.setString(8, entity.getBairro());
        stm.setString(9, entity.getCidade());
        stm.setString(10, entity.getEstado());
        stm.setString(11, entity.getTelefoneResidencial());
        stm.setString(12, entity.getTelefoneCelular());
        stm.setString(13, entity.getCtps());
        stm.setString(14, entity.getPis());
        stm.setDate(15, new java.sql.Date(entity.getNascimento().getTime()));
        stm.execute();
    }

    @Override
    public void delete(Funcionario entity) throws SQLException {
        this.delete(entity.getId());
    }

    @Override
    public void update(Funcionario entity) throws SQLException {
        String sql = "UPDATE FUNCIONARIOS SET nome = ?, rg = ?, orgao_emissor = ?, cpf = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, telefone = ?, celular = ?, ctps = ?, pis = ?, nascimento = ? WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, entity.getNome());
        stm.setString(2, entity.getRg());
        stm.setString(3, entity.getOrgaoEmissor());
        stm.setString(4, entity.getCpf());
        stm.setString(5, entity.getEndereco());
        stm.setString(6, entity.getNumero());
        stm.setString(7, entity.getComplemento());
        stm.setString(8, entity.getBairro());
        stm.setString(9, entity.getCidade());
        stm.setString(10, entity.getEstado());
        stm.setString(11, entity.getTelefoneResidencial());
        stm.setString(12, entity.getTelefoneCelular());
        stm.setString(13, entity.getCtps());
        stm.setString(14, entity.getPis());
        stm.setDate(15, new java.sql.Date(entity.getNascimento().getTime()));
        stm.setInt(16, entity.getId());
        stm.execute();
    }

    @Override
    public Funcionario find(int id) throws SQLException {
        String sql = "SELECT * FROM FUNCIONARIOS WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet result = stm.executeQuery();

        Funcionario funcionario = null;
        if (result.next()) {
            funcionario = new Funcionario();
            funcionario.setId(result.getInt("id"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setRg(result.getString("rg"));
            funcionario.setOrgaoEmissor(result.getString("orgao_emissor"));
            funcionario.setCpf(result.getString("cpf"));
            funcionario.setEndereco(result.getString("endereco"), result.getString("numero"), result.getString("complemento"), result.getString("bairro"), result.getString("cidade"), result.getString("estado"));
            funcionario.setTelefoneCelular(result.getString("telefone"));
            funcionario.setTelefoneResidencial(result.getString("celular"));
            funcionario.setCtps(result.getString("ctps"));
            funcionario.setPis(result.getString("pis"));
            funcionario.setNascimento(result.getDate("nascimento"));
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> findAll() throws SQLException {
        String sql = "SELECT * FROM FUNCIONARIOS";
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Funcionario> listFuncionarios = new ArrayList<>();
        
        while (result.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(result.getInt("id"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setRg(result.getString("rg"));
            funcionario.setOrgaoEmissor(result.getString("orgao_emissor"));
            funcionario.setCpf(result.getString("cpf"));
            funcionario.setEndereco(result.getString("endereco"), result.getString("numero"), result.getString("complemento"), result.getString("bairro"), result.getString("cidade"), result.getString("estado"));
            funcionario.setTelefoneCelular(result.getString("telefone"));
            funcionario.setTelefoneResidencial(result.getString("celular"));
            funcionario.setCtps(result.getString("ctps"));
            funcionario.setPis(result.getString("pis"));
            funcionario.setNascimento(result.getDate("nascimento"));
            listFuncionarios.add(funcionario);
        }
        return listFuncionarios;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM FUNCIONARIOS WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.execute();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        conn.close();
    }

}
