package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.interfaces.ITopicoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import br.pucpr.prog4.forum.models.Usuario;
import br.pucpr.prog4.forum.models.dao.TopicoDAOImpl;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisl
 */
public class CadastroTopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/cadastroTopicoJSP.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ITopicoDAO impl = new TopicoDAOImpl();
        String txtTopico;
        Usuario autor;
        Assunto assunto;
        //autor = new Usuario(request.getSession().getAttribute("nomeLogin").toString(), request.getSession().getAttribute("email").toString());
        autor = (Usuario)request.getSession().getAttribute("usuario");
        assunto = (Assunto) request.getSession().getAttribute("assunto");
        txtTopico = request.getParameter("nameTopico");
        Topico topico;
        topico = new Topico(txtTopico, autor, assunto, new Date());
        impl.inserirTopico(topico);
        response.sendRedirect("Topico");
    }
}