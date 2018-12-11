/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao;

import br.com.clinica.entidades.Especialidade;
import br.com.clinica.entidades.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class MedicoDAO extends GenericDAO implements IPersistent<Medico> {

    public MedicoDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void save(Medico entity) throws SQLException {
        String sql = "INSERT INTO MEDICOS VALUES(null,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, entity.getNome());
        stm.setString(2, entity.getCRM());
        stm.setInt(3, entity.getEspecialidade().getId());
        stm.execute();
    }

    @Override
    public void delete(Medico entity) throws SQLException {
        this.delete(entity.getId());
    }

    @Override
    public void update(Medico entity) throws SQLException {
        String sql = "UPDATE MEDICOS SET nome = ?, crm = ?, especialidades_id = ? WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, entity.getNome());
        stm.setString(2, entity.getCRM());
        stm.setInt(3, entity.getEspecialidade().getId());
        stm.setInt(4, entity.getId());
        stm.execute();
    }

    @Override
    public Medico find(int id) throws SQLException {
        String sql = "SELECT * FROM MEDICOS "
                + "INNER JOIN ESPECIALIDADES ON ESPECIALIDADES.ID = MEDICOS.ESPECIALIDADES_ID "
                + "WHERE MEDICOS.ID = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet result = stm.executeQuery();

        Medico medico = null;
        if (result.next()) {
            medico = new Medico();
            medico.setId(result.getInt("id"));
            medico.setNome(result.getString("nome"));
            medico.setCRM(result.getString("crm"));

            Especialidade especialdiade = new Especialidade();
            especialdiade.setId(result.getInt("ESPECIALIDADES.ID"));
            especialdiade.setDescricao(result.getString("ESPECIALIDADES.DESCRICAO"));

            medico.setEspecialidade(especialdiade);
        }
        return medico;
    }

    @Override
    public List<Medico> findAll() throws SQLException {
        String sql = "SELECT * FROM MEDICOS "
                + "INNER JOIN ESPECIALIDADES ON ESPECIALIDADES.ID = MEDICOS.ESPECIALIDADES_ID ";
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Medico> listFuncionarios = new ArrayList<>();

        while (result.next()) {
            Medico medico = new Medico();
            medico.setId(result.getInt("id"));
            medico.setNome(result.getString("nome"));
            medico.setCRM(result.getString("crm"));

            Especialidade especialdiade = new Especialidade();
            especialdiade.setId(result.getInt("ESPECIALIDADES.ID"));
            especialdiade.setDescricao(result.getString("ESPECIALIDADES.DESCRICAO"));

            medico.setEspecialidade(especialdiade);

            listFuncionarios.add(medico);
        }
        return listFuncionarios;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM MEDICOS WHERE id = ?";
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
