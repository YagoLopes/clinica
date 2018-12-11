/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imepac.usuario;

import br.com.clinica.dao.UsuarioDAO;
import br.com.clinica.entidades.Usuario;
import br.com.imepac.MessageResponse;
import br.com.imepac.MessageResponseTipoENUM;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "UsuarioLogin", urlPatterns = {"/login/UsuarioLogin"})
public class UsuarioLogin extends HttpServlet {

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
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            if (usuario.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo usuário é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/login/index.jsp").forward(request, response);
                return;
            }
            if (senha.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo senha é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/login/index.jsp").forward(request, response);
                return;
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuarioAutenticado = usuarioDAO.login(usuario, senha);

            if (usuarioAutenticado == null) {
                MessageResponse message = new MessageResponse("Dados de acesso inválido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/login/index.jsp").forward(request, response);
                return;
            }

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("autenticado", usuarioAutenticado);

            response.sendRedirect(getServletContext().getContextPath());
        } catch (Exception ex) {
            MessageResponse message = new MessageResponse("Sistema instável. Por favor, retorne mais tarde.", MessageResponseTipoENUM.WARNING);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/login/index.jsp").forward(request, response);
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
