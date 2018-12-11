/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imepac.usuario;

import br.com.clinica.dao.UsuarioDAO;
import br.com.clinica.entidades.AutorizacaoENUM;
import br.com.clinica.entidades.Usuario;
import br.com.imepac.MessageResponse;
import br.com.imepac.MessageResponseTipoENUM;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "UsuarioSave", urlPatterns = {"/usuario/UsuarioSave"})
public class UsuarioSave extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Validar os dados do formulário
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");

            if (nome.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo nome é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/usuario/cadastrar.jsp").forward(request, response);

            }
            if (senha.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo senha é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/usuario/cadastrar.jsp").forward(request, response);

            }
            if (senha.length() < 8) {//validação de tamanho da senha
                MessageResponse message = new MessageResponse("O campo senha deverá ter mais que 7 caracteres.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/usuario/cadastrar.jsp").forward(request, response);

            }

            Usuario usuario = new Usuario();
            usuario.setNome(request.getParameter("nome"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setCadastrarFuncionario((request.getParameter("cad_func") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarUsuario((request.getParameter("cad_usu") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarPaciente((request.getParameter("cad_pac") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarEspecialidade((request.getParameter("cad_esp") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarMedico((request.getParameter("cad_med") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCadastrarConvenio((request.getParameter("cad_conv") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setAgendarConsulta((request.getParameter("ag_cons") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setCancelarConsulta((request.getParameter("can_cons") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAdministrativo((request.getParameter("mod_adm") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAgendamento((request.getParameter("mod_agd") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);
            usuario.setModuloAtendimento((request.getParameter("mod_atd") != null) ? AutorizacaoENUM.PERMITIDO : AutorizacaoENUM.NEGADO);

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.save(usuario);

            MessageResponse message = new MessageResponse("Cadastro realizado com sucesso..", MessageResponseTipoENUM.SUCCESS);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/usuario/index.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.print(ex);
            MessageResponse message = new MessageResponse("Sistema instável. Por favor, retorne mais tarde.", MessageResponseTipoENUM.WARNING);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/especialidade/cadastrar.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
