/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imepac.especialidade;

import br.com.clinica.dao.EspecialidadeDAO;
import br.com.clinica.entidades.Especialidade;
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
@WebServlet(name = "EspecialidadeSave", urlPatterns = {"/especialidade/EspecialidadeSave"})
public class EspecialidadeSave extends HttpServlet {

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
            String descricao = request.getParameter("descricao");

            if (descricao.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo descricao é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                (request.getSession()).setAttribute("message", message);
                response.sendRedirect(getServletContext().getContextPath() + "/especialidade/cadastrar.jsp");
                return;
            }

            Especialidade especialidade = new Especialidade();
            especialidade.setDescricao(request.getParameter("descricao"));

            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            especialidadeDAO.save(especialidade);

            MessageResponse message = new MessageResponse("Cadastro realizado com sucesso..", MessageResponseTipoENUM.SUCCESS);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/especialidade/index.jsp").forward(request, response);
        } catch (Exception ex) {
            MessageResponse message = new MessageResponse("Sistema instável. Por favor, retorne mais tarde.", MessageResponseTipoENUM.WARNING);
            (request.getSession()).setAttribute("message", message);
            response.sendRedirect("/especialidade/cadastrar.jsp");
        }
    }

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
