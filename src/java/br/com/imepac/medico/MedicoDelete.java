/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imepac.medico;

import br.com.imepac.funcionario.*;
import br.com.clinica.dao.MedicoDAO;
import br.com.clinica.entidades.Funcionario;
import br.com.imepac.MessageResponse;
import br.com.imepac.MessageResponseTipoENUM;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "MedicoDelete", urlPatterns = {"/medico/MedicoDelete"})
public class MedicoDelete extends HttpServlet {

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
            if (request.getParameter("deleted") == null) {
                MessageResponse message = new MessageResponse("Você deverá selecionar ao menos um registro.", MessageResponseTipoENUM.WARNING);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/medico/index.jsp").forward(request, response);
            }

            for (String idValue : request.getParameterValues("deleted")) {
                MedicoDAO MedicoDAO = new MedicoDAO();
                MedicoDAO.delete(Integer.parseInt(idValue));
            }

            MessageResponse message = new MessageResponse("Exclusões realizadas com sucesso..", MessageResponseTipoENUM.SUCCESS);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/medico/index.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.print(ex);
            MessageResponse message = new MessageResponse("Sistema instável. Por favor, retorne mais tarde.", MessageResponseTipoENUM.WARNING);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/medico/index.jsp").forward(request, response);
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
