package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.interfaces.IUsuarioDAO;
import br.pucpr.prog4.forum.models.Usuario;
import br.pucpr.prog4.forum.models.dao.UsuarioDAOImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/cadastroUserJSP.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomeLogin, email;
        IUsuarioDAO impl = new UsuarioDAOImpl();

        nomeLogin = request.getParameter("login");
        email = request.getParameter("email");
        Usuario usuario = new Usuario(nomeLogin, email);
        usuario.setNomeUser("nome");
        usuario.setSenha(request.getParameter("password"));
        impl.inserirUsuario(usuario);
        response.sendRedirect("index");
    }
}