package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Usuario;
import br.pucpr.prog4.forum.models.dao.AssuntoDAOImpl;
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
public class CadastroAssuntoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/cadastroAssuntoJSP.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        IAssuntoDAO impl = new AssuntoDAOImpl();
        String txtAssunto;
        Usuario autor;
        //autor = new Usuario(request.getSession().getAttribute("nomeLogin").toString(), request.getSession().getAttribute("email").toString());
        autor = (Usuario)request.getSession().getAttribute("usuario");
        txtAssunto = request.getParameter("nomeAssunto");
        Assunto assunto;
        assunto = new Assunto(txtAssunto, autor, new Date());
        impl.inserirAssunto(assunto);
        response.sendRedirect("index");
    }
}