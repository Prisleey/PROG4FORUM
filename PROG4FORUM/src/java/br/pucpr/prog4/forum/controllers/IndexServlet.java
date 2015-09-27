package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.dao.AssuntoDAOImpl;
import java.io.IOException;
import java.util.List;
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
        List<Assunto> assuntos; 
        AssuntoDAOImpl assuntoManager = new AssuntoDAOImpl(); 
        assuntos = assuntoManager.buscarAssuntos();    
        request.setAttribute("assuntos", assuntos); 

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/indexJSP.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }
}