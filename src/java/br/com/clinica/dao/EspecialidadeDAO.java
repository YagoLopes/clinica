/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao;

import br.com.clinica.entidades.Especialidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class EspecialidadeDAO extends GenericDAO implements IPersistent<Especialidade> {

    public EspecialidadeDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void save(Especialidade entity) throws SQLException {
        String sql = "INSERT INTO ESPECIALIDADES VALUES(null,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, entity.getDescricao());
        stm.execute();
    }

    @Override
    public void delete(Especialidade entity) throws SQLException {
        this.delete(entity.getId());
    }

    @Override
    public void update(Especialidade entity) throws SQLException {
        String sql = "UPDATE ESPECIALIDADES SET descricao = ? WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, entity.getDescricao());
        stm.setInt(2, entity.getId());
        stm.execute();
    }

    @Override
    public Especialidade find(int id) throws SQLException {
        String sql = "SELECT * FROM ESPECIALIDADES WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet result = stm.executeQuery();

        Especialidade especialidade = null;
        if (result.next()) {
            especialidade = new Especialidade();
            especialidade.setId(result.getInt("id"));
            especialidade.setDescricao(result.getString("descricao"));
        }
        return especialidade;
    }

    @Override
    public List<Especialidade> findAll() throws SQLException {
        String sql = "SELECT * FROM ESPECIALIDADES";
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Especialidade> listEspecialidades = new ArrayList<>();

        while (result.next()) {
            Especialidade especialidade = new Especialidade();
            especialidade.setId(result.getInt("id"));
            especialidade.setDescricao(result.getString("descricao"));
            listEspecialidades.add(especialidade);
        }
        return listEspecialidades;
    }

    public List<Especialidade> findAll(int index, int count) throws SQLException {
        String sql = "SELECT * FROM ESPECIALIDADES LIMIT ?,?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, index);
        stm.setInt(2, count);
        ResultSet result = stm.executeQuery();
        List<Especialidade> listEspecialidades = new ArrayList<>();

        while (result.next()) {
            Especialidade especialidade = new Especialidade();
            especialidade.setId(result.getInt("id"));
            especialidade.setDescricao(result.getString("descricao"));
            listEspecialidades.add(especialidade);
        }
        return listEspecialidades;
    }

    public int count() throws SQLException {
        String sql = "SELECT count(id) as count FROM ESPECIALIDADES";
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        result.next();
        return result.getInt("count");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM ESPECIALIDADES WHERE id = ?";
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
