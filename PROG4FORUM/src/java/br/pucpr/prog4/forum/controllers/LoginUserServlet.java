package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.models.Usuario;
import br.pucpr.prog4.forum.models.dao.UsuarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisl
 */
public class LoginUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/loginUserJSP.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAOImpl userDAO = new UsuarioDAOImpl();
        Usuario usuario = userDAO.getUsuarioLogin(request.getParameter("email"),request.getParameter("senha")); 
        request.getSession().setAttribute("usuario", usuario);
    }
}