package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisley.costa
 */
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario user;
        user = (Usuario) request.getSession().getAttribute("usuario"); 
        if(user != null){ 
            request.setAttribute("usuario", user.getNomeUser()); 
        } 

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/indexJSP.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
}