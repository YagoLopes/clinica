/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao;

import br.com.clinica.entidades.AutorizacaoENUM;
import br.com.clinica.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class UsuarioDAO extends GenericDAO implements IPersistent<Usuario> {

    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void save(Usuario entity) throws SQLException {
        String sql = "INSERT INTO usuarios VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, entity.getNome());
        stm.setString(2, entity.getSenha());
        stm.setString(3, entity.getCadastrarFuncionario().getValue());
        stm.setString(4, entity.getCadastrarUsuario().getValue());
        stm.setString(5, entity.getCadastrarPaciente().getValue());
        stm.setString(6, entity.getCadastrarEspecialidade().getValue());
        stm.setString(7, entity.getCadastrarMedico().getValue());
        stm.setString(8, entity.getCadastrarConvenio().getValue());
        stm.setString(9, entity.getAgendarConsulta().getValue());
        stm.setString(10, entity.getCancelarConsulta().getValue());
        stm.setString(11, entity.getModuloAdministrativo().getValue());
        stm.setString(12, entity.getModuloAgendamento().getValue());
        stm.setString(13, entity.getModuloAtendimento().getValue());
        stm.execute();
    }

    @Override
    public void delete(Usuario entity) throws SQLException {
        this.delete(entity.getId());
    }

    @Override
    public void update(Usuario entity) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, senha = ?, cad_func = ?, cad_usuario = ?, cad_paciente = ?, cad_especialidade = ?, cad_usuario = ?, cad_convenio = ?, ag_consulta = ?, can_consulta = ?, mod_administrativo = ?, mod_agendamento = ?, mod_atendimento = ?  WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, entity.getNome());
        stm.setString(2, entity.getSenha());
        stm.setString(3, entity.getCadastrarFuncionario().getValue());
        stm.setString(4, entity.getCadastrarUsuario().getValue());
        stm.setString(5, entity.getCadastrarPaciente().getValue());
        stm.setString(6, entity.getCadastrarEspecialidade().getValue());
        stm.setString(7, entity.getCadastrarMedico().getValue());
        stm.setString(8, entity.getCadastrarConvenio().getValue());
        stm.setString(9, entity.getAgendarConsulta().getValue());
        stm.setString(10, entity.getCancelarConsulta().getValue());
        stm.setString(11, entity.getModuloAdministrativo().getValue());
        stm.setString(12, entity.getModuloAgendamento().getValue());
        stm.setString(13, entity.getModuloAtendimento().getValue());
        stm.setInt(14, entity.getId());
        stm.execute();
    }

    @Override
    public Usuario find(int id) throws SQLException {
        String sql = "SELECT * usuarios WHERE usuarios.id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);

        ResultSet result = stm.executeQuery();

        Usuario usuario = null;
        if (result.next()) {
            usuario = new Usuario();
            usuario.setId(result.getInt("id"));
            usuario.setNome(result.getString("nome"));
            usuario.setSenha(result.getString("senha"));
            usuario.setCadastrarFuncionario((result.getString("cad_funcionario").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarUsuario((result.getString("cad_usuario").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarPaciente((result.getString("cad_paciente").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarEspecialidade((result.getString("cad_especialidade").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarMedico((result.getString("cad_medico").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarConvenio((result.getString("cad_convenio").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setAgendarConsulta((result.getString("ag_consulta").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCancelarConsulta((result.getString("can_consulta").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAdministrativo((result.getString("mod_administrativo").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAgendamento((result.getString("mod_agendamento").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAtendimento((result.getString("mod_atendimento").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
        }
        return usuario;
    }

    public List<Usuario> findAll(int index, int count) throws SQLException {
        String sql = "SELECT * FROM usuarios LIMIT ?,?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, index);
        stm.setInt(2, count);
        ResultSet result = stm.executeQuery();
        List<Usuario> listUsuarios = new ArrayList<>();

        while (result.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(result.getInt("id"));
            usuario.setNome(result.getString("nome"));
            usuario.setSenha(result.getString("senha"));
            usuario.setCadastrarFuncionario((result.getString("cad_funcionario").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarUsuario((result.getString("cad_usuario").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarPaciente((result.getString("cad_paciente").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarEspecialidade((result.getString("cad_especialidade").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarMedico((result.getString("cad_medico").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarConvenio((result.getString("cad_convenio").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setAgendarConsulta((result.getString("ag_consulta").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCancelarConsulta((result.getString("can_consulta").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAdministrativo((result.getString("mod_administrativo").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAgendamento((result.getString("mod_agendamento").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAtendimento((result.getString("mod_atendimento").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);

            listUsuarios.add(usuario);
        }
        return listUsuarios;
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
        String sql = "SELECT * FROM usuarios ";
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        List<Usuario> listUsuarios = new ArrayList<>();

        while (result.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(result.getInt("id"));
            usuario.setNome(result.getString("nome"));
            usuario.setSenha(result.getString("senha"));
            usuario.setCadastrarFuncionario((result.getString("cad_funcionario").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarUsuario((result.getString("cad_usuario").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarPaciente((result.getString("cad_paciente").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarEspecialidade((result.getString("cad_especialidade").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarMedico((result.getString("cad_medico").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarConvenio((result.getString("cad_convenio").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setAgendarConsulta((result.getString("ag_consulta").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCancelarConsulta((result.getString("can_consulta").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAdministrativo((result.getString("mod_administrativo").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAgendamento((result.getString("mod_agendamento").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAtendimento((result.getString("mod_atendimento").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);

            listUsuarios.add(usuario);
        }
        return listUsuarios;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.execute();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        conn.close();
    }

    public int count() throws SQLException {
        String sql = "SELECT count(id) as count FROM usuarios";
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet result = stm.executeQuery();
        result.next();
        return result.getInt("count");
    }

    public Usuario login(String usuario, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE nome = ? and senha = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, usuario);
        stm.setString(2, senha);

        ResultSet result = stm.executeQuery();

        Usuario usuarioAutenticado = null;
        if (result.next()) {
            usuarioAutenticado = new Usuario();
            usuarioAutenticado.setId(result.getInt("id"));
            usuarioAutenticado.setNome(result.getString("nome"));
            usuarioAutenticado.setSenha(result.getString("senha"));
            usuarioAutenticado.setCadastrarFuncionario((result.getString("cad_funcionario").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setCadastrarUsuario((result.getString("cad_usuario").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setCadastrarPaciente((result.getString("cad_paciente").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setCadastrarEspecialidade((result.getString("cad_especialidade").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setCadastrarMedico((result.getString("cad_medico").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setCadastrarConvenio((result.getString("cad_convenio").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setAgendarConsulta((result.getString("ag_consulta").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setCancelarConsulta((result.getString("can_consulta").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setModuloAdministrativo((result.getString("mod_administrativo").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setModuloAgendamento((result.getString("mod_agendamento").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuarioAutenticado.setModuloAtendimento((result.getString("mod_atendimento").equals("S")) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
        }
        return usuarioAutenticado;
    }

}
