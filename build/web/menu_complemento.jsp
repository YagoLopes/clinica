<div class="copyright py-4 text-center text-white" style="position:fixed;bottom: 0; width: 100%">

    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase" id="mainNav">
        <div class="container">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <% if(authenticatedUser != null && authenticatedUser.getAgendarConsulta() == AutorizacaoENUM.PERMITIDO){ %>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/consulta/agendar.jsp">Agendar Consulta</a>
                    </li>
                    <% } %>
                    <% if(authenticatedUser != null && authenticatedUser.getCancelarConsulta() == AutorizacaoENUM.PERMITIDO){ %>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/consulta/cancelar.jsp">Cancelar Consulta</a>
                    </li>
                    <% } %>
                    <% if(authenticatedUser != null && authenticatedUser.getModuloAdministrativo() == AutorizacaoENUM.PERMITIDO){ %>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/adm/index.jsp">Administrativo</a>
                    </li>
                    <% } %>
                    <% if(authenticatedUser != null && authenticatedUser.getModuloAgendamento() == AutorizacaoENUM.PERMITIDO){ %>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/agendamento/index.jsp">Agendamento</a>
                    </li>
                    <% } %>
                    <% if(authenticatedUser != null && authenticatedUser.getModuloAdministrativo() == AutorizacaoENUM.PERMITIDO){ %>
                    <li class="nav-item mx-0 mx-lg-1">
                        <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath()%>/atendimento/index.jsp">Atendimento</a>
                    </li>
                    <% } %>
                </ul>
            </div>
        </div>
    </nav>
</div>