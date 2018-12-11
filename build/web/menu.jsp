<%@page import="br.com.imepac.MessageResponse,br.com.clinica.entidades.*" %>
<nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
    <div class="container">
        <%
         Usuario authenticatedUser = (Usuario) session.getAttribute("autenticado");
        %>
        <% if(authenticatedUser == null){ %>
        <a class="navbar-brand js-scroll-trigger" href="<%=request.getContextPath()%>/index.jsp">Home</a>
        <% } %>
        <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">


                <% if(authenticatedUser != null && authenticatedUser.getCadastrarFuncionario() == AutorizacaoENUM.PERMITIDO){ %>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/funcionario/cadastrar.jsp">funcionário</a>
                </li>
                <% } %>
                <% if(authenticatedUser != null && authenticatedUser.getCadastrarUsuario() == AutorizacaoENUM.PERMITIDO){ %>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/usuario/cadastrar.jsp">Usuário</a>
                </li>
                <% } %>
                <% if(authenticatedUser != null && authenticatedUser.getCadastrarPaciente() == AutorizacaoENUM.PERMITIDO){ %>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/paciente/cadastrar.jsp">Paciente</a>
                </li>
                <% } %>
                <% if(authenticatedUser != null && authenticatedUser.getCadastrarEspecialidade() == AutorizacaoENUM.PERMITIDO){ %>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/especialidade/cadastrar.jsp">Especialidade</a>
                </li>
                <% } %>
                <% if(authenticatedUser != null && authenticatedUser.getCadastrarMedico() == AutorizacaoENUM.PERMITIDO){ %>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/medico/cadastrar.jsp">Médico</a>
                </li>
                <% } %>
                <% if(authenticatedUser != null && authenticatedUser.getCadastrarConvenio() == AutorizacaoENUM.PERMITIDO){ %>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/convencio/cadastrar.jsp">Convênio</a>
                </li>
                <% } %>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">Sobre</a>
                </li>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#contact">Contate-nos</a>
                </li>
                <% if(authenticatedUser == null){ %>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/login/index.jsp">Login</a>
                </li>
                <% }else{ %>

                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/login/UsuarioLogout">Sair</a>
                </li>
                <% } %>

            </ul>
        </div>
    </div>
</nav>