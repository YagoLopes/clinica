<%@page import="br.com.imepac.MessageResponse, java.util.*, br.com.clinica.dao.*, br.com.clinica.entidades.*, br.com.imepac.*" %>

<%
    Usuario autenticadoUser = (Usuario) session.getAttribute("autenticado");
    
    if(autenticadoUser == null || autenticadoUser.getModuloAdministrativo() == AutorizacaoENUM.NEGADO){
       MessageResponse message = new MessageResponse("Área de acesso restrito. Solicite autorização.", MessageResponseTipoENUM.ERROR);
       request.setAttribute("message", message);
       request.getServletContext().getRequestDispatcher("/login/index.jsp").forward(request, response);
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%@include file="../head.jsp" %>
    </head> 

    <body id="page-top">

        <%@include file="../menu.jsp" %>

        <!-- Header -->
        <header class="masthead bg-primary text-white ">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">

                        <%
                            MessageResponse message = (MessageResponse) request.getAttribute("message");
                            if(message != null){
                        %>
                        <div class="alert <%=message.getFormat()%>" role="alert"><%=message.getMessage()%></div>
                        <%
                        }
                                                        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                                                        Funcionario funcionario = funcionarioDAO.find(Integer.parseInt(request.getParameter("editId")));
                        %>

                        <form id="funcionario" method="post" action="FuncionarioEdit">
                            <fieldset>
                                <legend>Dados pessoais</legend>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="nome">Nome</label>
                                            <input type="hidden" class="form-control"  name="id" value="<%=funcionario.getId() %>">
                                            <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome completo" required value="<%=funcionario.getNome() %>">
                                        </div>
                                    </div>
                                    <div class="col-md-4">

                                        <div class="form-group">
                                            <label for="cpf">CPF</label>
                                            <input type="text" class="form-control" id="cpf" name="cpf" value="<%=funcionario.getCpf() %>">
                                        </div>
                                    </div>

                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="nascimento">Data nascimento</label>
                                            <input type="date" class="form-control" id="nascimento" name="nascimento" value="<%=funcionario.getNascimento() %>">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="rg">Rg</label>
                                            <input type="text" class="form-control" id="rg" name="rg" value="<%=funcionario.getRg() %>">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="orgao_emissor">Orgão emissor</label>
                                            <input type="text" class="form-control" id="orgao_emissor" name="orgao_emissor" value="<%=funcionario.getOrgaoEmissor() %>">
                                        </div>
                                    </div>
                                </div>
                            </fieldset>

                            <fieldset>
                                <legend>Endereço</legend>

                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="endereco">Endereço</label>
                                            <input type="text" class="form-control" id="endereco" name="endereco" value="<%=funcionario.getEndereco() %>">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="numero">Nº</label>
                                            <input type="text" class="form-control" id="numero" name="numero" value="<%=funcionario.getNumero() %>">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="complemento">Complemento</label>
                                            <input type="text" class="form-control" id="complemento" name="complemento" value="<%=funcionario.getComplemento() %>">
                                        </div>
                                    </div>
                                </div>                          
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="bairro">Bairro</label>
                                            <input type="text" class="form-control" id="bairro" name="bairro" value="<%=funcionario.getBairro() %>">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="cidade">Cidade</label>
                                            <input type="text" class="form-control" id="cidade" name="cidade" value="<%=funcionario.getCidade() %>">
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="estado">Estado</label>
                                            <input type="text" class="form-control" id="estado" name="estado" value="<%=funcionario.getEstado() %>">
                                        </div>
                                    </div>
                                </div>      
                            </fieldset>
                            <fieldset>
                                <legend>Contato</legend>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="telefone_residencial">Telefone residencial</label>
                                            <input type="text" class="form-control telefone" id="telefone_residencial" name="telefone_residencial" value="<%=funcionario.getTelefoneResidencial() %>">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="telefone_celular">Telefone celular</label>
                                            <input type="text" class="form-control telefone" id="telefone_celular" name="telefone_celular" value="<%=funcionario.getTelefoneCelular() %>">
                                        </div>
                                    </div>
                                </div>                                
                            </fieldset>
                            <fieldset>
                                <legend>Dados trabalhista</legend>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="ctps">CTPS</label>
                                            <input type="text" class="form-control" id="ctps" name="ctps" value="<%=funcionario.getCtps() %>">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="pis">PIS</label>
                                            <input type="text" class="form-control" id="pis" name="pis" value="<%=funcionario.getPis() %>">
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            <button type="submit" class="btn btn-success btn-lg">Salvar</button>
                        </form>
                    </div>
                </div>
            </div>
        </header>



        <!-- Footer -->
        <footer class="footer text-center">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Location</h4>
                        <p class="lead mb-0">2215 John Daniel Drive
                            <br>Clark, MO 65243</p>
                    </div>
                    <div class="col-md-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Around the Web</h4>
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-facebook"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-google-plus"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-twitter"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-linkedin"></i>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a class="btn btn-outline-light btn-social text-center rounded-circle" href="#">
                                    <i class="fa fa-fw fa-dribbble"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-4">
                        <h4 class="text-uppercase mb-4">About Freelancer</h4>
                        <p class="lead mb-0">Freelance is a free to use, open source Bootstrap theme created by
                            <a href="http://startbootstrap.com">Start Bootstrap</a>.</p>
                    </div>
                </div>
            </div>
        </footer>

        <div class="copyright py-4 text-center text-white">
            <div class="container">
                <small>Copyright &copy; Your Website 2018</small>
            </div>
        </div>

        <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
        <div class="scroll-to-top d-lg-none position-fixed ">
            <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
                <i class="fa fa-chevron-up"></i>
            </a>
        </div>

        <!-- Portfolio Modals -->

        <!-- Portfolio Modal 1 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/cabin.png" alt="">
                            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Portfolio Modal 2 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-2">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/cake.png" alt="">
                            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Portfolio Modal 3 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-3">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/circus.png" alt="">
                            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Portfolio Modal 4 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-4">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/game.png" alt="">
                            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Portfolio Modal 5 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-5">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/safe.png" alt="">
                            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Portfolio Modal 6 -->
        <div class="portfolio-modal mfp-hide" id="portfolio-modal-6">
            <div class="portfolio-modal-dialog bg-white">
                <a class="close-button d-none d-md-block portfolio-modal-dismiss" href="#">
                    <i class="fa fa-3x fa-times"></i>
                </a>
                <div class="container text-center">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                            <h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
                            <hr class="star-dark mb-5">
                            <img class="img-fluid mb-5" src="img/portfolio/submarine.png" alt="">
                            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias magnam, recusandae quos quis inventore quisquam velit asperiores, vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
                            <a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss" href="#">
                                <i class="fa fa-close"></i>
                                Close Project</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript -->
        <script src="../vendor/jquery/jquery.min.js"></script>
        <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="../vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

        <!-- Contact Form JavaScript -->
        <script src="../js/jqBootstrapValidation.js"></script>
        <script src="../js/contact_me.js"></script>

        <!-- Custom scripts for this template -->
        <script src="../js/freelancer.min.js"></script>
        <script src="../js/jquery.mask.min.js"></script>

        <script src="../js/jquery.validate.min.js"></script>
        <script src="../js/funcionario.js"></script>


    </body>

</html>
