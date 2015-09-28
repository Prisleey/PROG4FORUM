package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.interfaces.IAssuntoDAO;
import br.pucpr.prog4.forum.interfaces.ITopicoDAO;
import br.pucpr.prog4.forum.models.Assunto;
import br.pucpr.prog4.forum.models.Topico;
import br.pucpr.prog4.forum.models.Usuario;
import br.pucpr.prog4.forum.models.dao.AssuntoDAOImpl;
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

        request.setAttribute("id_assunto", request.getParameter("id_assunto"));

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/cadastroTopicoJSP.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt((String) request.getParameter("id_assunto")); 

        ITopicoDAO impl = new TopicoDAOImpl();
        IAssuntoDAO implAss = new AssuntoDAOImpl();
        String txtTopico;
        Usuario autor;
        Assunto assunto;
        //autor = new Usuario(request.getSession().getAttribute("nomeLogin").toString(), request.getSession().getAttribute("email").toString());
        autor = (Usuario)request.getSession().getAttribute("usuario");
        assunto = implAss.buscarAssuntoPorId(id);
        txtTopico = request.getParameter("nameTopico");
        Topico topico;
        topico = new Topico(txtTopico, autor, assunto, new Date());
        impl.inserirTopico(topico);
        response.sendRedirect("Topico?id_assunto="+id);
    }
}