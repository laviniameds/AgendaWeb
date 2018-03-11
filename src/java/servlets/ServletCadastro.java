/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.Agenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Contato;

/**
 *
 * @author lavinia
 */
@WebServlet(name = "ServletCadastro", urlPatterns = {"/ServletCadastro"})
public class ServletCadastro extends HttpServlet {
    
    Agenda agenda;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sessao = request.getSession();
        agenda = (Agenda)sessao.getAttribute("agenda");      
        
        Contato contato = new Contato();
        contato.setNome(request.getParameter("nome").toString());
        contato.setEmail(request.getParameter("email").toString());
        contato.setFone(request.getParameter("fone").toString());
        contato.setCidade(request.getParameter("cidade").toString());
        contato.setEstado(request.getParameter("estado").toString());
        contato.setRua(request.getParameter("rua").toString());
        contato.setBairro(request.getParameter("bairro").toString());
        contato.setNumero(request.getParameter("numero").toString());
        
        agenda.inserirContato(contato);
        
        request.setAttribute("agenda", agenda);             
        
        getServletContext().getRequestDispatcher("/ServletImpressao").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        processRequest(request, response);     
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
