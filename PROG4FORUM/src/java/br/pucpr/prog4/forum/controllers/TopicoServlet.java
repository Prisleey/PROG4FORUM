package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import br.pucpr.prog4.forum.models.dao.AssuntoDAOImpl;
import br.pucpr.prog4.forum.models.dao.TopicoDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisl
 */
public class TopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id_assunto")); 
        AssuntoDAOImpl assuntoDAO = new AssuntoDAOImpl(); 
        Assunto assunto = assuntoDAO.buscarAssuntoPorId(id); 
        request.setAttribute("assunto", assunto); 

        List<Topico> topicos;
        TopicoDAOImpl implTop = new TopicoDAOImpl();
        topicos = implTop.buscarTopicosPorAssunto(assunto);
        request.setAttribute("topicos", topicos);

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/topicoJSP.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}