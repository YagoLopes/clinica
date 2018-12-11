/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imepac.medico;

import br.com.clinica.dao.EspecialidadeDAO;
import br.com.clinica.dao.MedicoDAO;
import br.com.clinica.entidades.Especialidade;
import br.com.clinica.entidades.Medico;
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
@WebServlet(name = "MedicoEdit", urlPatterns = {"/medico/MedicoEdit"})
public class MedicoEdit extends HttpServlet {

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
            String crm = request.getParameter("crm");
            String especialidade = request.getParameter("especialidade");

            if (nome.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo nome é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/medico/editar.jsp").forward(request, response);
            }
            if (crm.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo CRM é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/medico/editar.jsp").forward(request, response);
            }
            if (especialidade.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo especialidade é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/medico/editar.jsp").forward(request, response);
            }

            Medico medico = new Medico();
            medico.setId(Integer.parseInt(request.getParameter("id")));
            medico.setNome(nome);
            medico.setCRM(crm);

            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            Especialidade espec = especialidadeDAO.find(Integer.parseInt(especialidade));
            medico.setEspecialidade(espec);

            MedicoDAO medicoDAO = new MedicoDAO();
            medicoDAO.update(medico);

            MessageResponse message = new MessageResponse("Cadastro realizado com sucesso..", MessageResponseTipoENUM.SUCCESS);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/medico/index.jsp").forward(request, response);
        } catch (Exception ex) {
            MessageResponse message = new MessageResponse("Sistema instável. Por favor, retorne mais tarde.", MessageResponseTipoENUM.WARNING);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/medico/editar.jsp").forward(request, response);
        }
    }

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
