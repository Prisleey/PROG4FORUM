/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.models.dao.UsuarioDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prisl
 */
public class CadastroUserServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Criar a JSP e um form com a method="POST" e a action para a propria jsp.
        
        UsuarioDAOImpl impl = new UsuarioDAOImpl();
        //request.getParameter("bome")
        //criar o objeto pessoa
        //impl.inserirUsuario(new Pessoa())
    }
}
