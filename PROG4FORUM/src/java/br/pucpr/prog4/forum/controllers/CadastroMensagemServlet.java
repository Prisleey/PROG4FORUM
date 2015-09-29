package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.models.Mensagem;
import br.pucpr.prog4.forum.models.Topico;
import br.pucpr.prog4.forum.models.Usuario;
import br.pucpr.prog4.forum.models.dao.MensagemDAOImpl;
import br.pucpr.prog4.forum.models.dao.TopicoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisley.costa
 */
public class CadastroMensagemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/cadastroMensagemJSP.jsp");
        rd.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario user = (Usuario)request.getSession().getAttribute("usuario");
        TopicoDAOImpl topicoDAO = new TopicoDAOImpl();
        Topico topico = topicoDAO.buscarTopicoPorId(Integer.parseInt(request.getParameter("id_topico")));
        
        Mensagem msg; // = new Mensagem(topico, request.getParameter("mensagem"), user);
        
        msg = new Mensagem(request.getParameter("mensagem"), new Date(), topico, user);
        MensagemDAOImpl mensagemDAO = new MensagemDAOImpl();
        mensagemDAO.inserirMensagem(msg);
        response.sendRedirect("/Forum/mensagens?id_topico="+Integer.parseInt(request.getParameter("id_topico")));
    }
}