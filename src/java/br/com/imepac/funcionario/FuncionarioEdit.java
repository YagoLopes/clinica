/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.imepac.funcionario;

import br.com.clinica.dao.FuncionarioDAO;
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
@WebServlet(name = "FuncionarioEdit", urlPatterns = {"/funcionario/FuncionarioEdit"})
public class FuncionarioEdit extends HttpServlet {

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

            if (nome.isEmpty() == true) {//validação de campo obrigatorio
                MessageResponse message = new MessageResponse("O campo nome é obrigatório e deverá ser preenchido.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/funcionario/cadastrar.jsp").forward(request, response);

            }

            if (nome.length() <= 3) {//validação de campo - tamanho
                MessageResponse message = new MessageResponse("O campo nome deve conter mais que 3 caracteres.", MessageResponseTipoENUM.ERROR);
                request.setAttribute("message", message);
                request.getServletContext().getRequestDispatcher("/funcionario/cadastrar.jsp").forward(request, response);
            }

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            Funcionario funcionario = funcionarioDAO.find(Integer.parseInt(request.getParameter("id")));
            funcionario.setNome(request.getParameter("nome"));
            funcionario.setRg(request.getParameter("rg"));
            funcionario.setOrgaoEmissor(request.getParameter("orgao_emissor"));
            funcionario.setCpf(request.getParameter("cpf"));
            funcionario.setEndereco(request.getParameter("endereco"), request.getParameter("numero"), request.getParameter("complemento"), request.getParameter("bairro"), request.getParameter("cidade"), request.getParameter("estado"));
            funcionario.setTelefoneCelular(request.getParameter("telefone_residencial"));
            funcionario.setTelefoneResidencial(request.getParameter("telefone_celular"));
            funcionario.setCtps(request.getParameter("ctps"));
            funcionario.setPis(request.getParameter("pis"));
            funcionario.setNascimento(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("nascimento")));

            funcionarioDAO.update(funcionario);

            MessageResponse message = new MessageResponse("Atualização realizada com sucesso..", MessageResponseTipoENUM.SUCCESS);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/funcionario/index.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.print(ex);
            MessageResponse message = new MessageResponse("Sistema instável. Por favor, retorne mais tarde.", MessageResponseTipoENUM.WARNING);
            request.setAttribute("message", message);
            request.getServletContext().getRequestDispatcher("/funcionario/cadastrar.jsp").forward(request, response);
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
