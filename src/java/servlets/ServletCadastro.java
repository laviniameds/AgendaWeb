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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*processRequest(request, response);*/
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*HttpSession sessao = request.getSession();
        Agenda agenda = (Agenda) sessao.getAttribute("agenda");*/
        agenda = (Agenda)request.getAttribute("agenda");
        if(agenda == null)
            agenda = new Agenda();
        
        Contato contato = new Contato();
        contato.setNome("nome");
        
        try {
            agenda.inserirContato(contato);
        } catch (Exception ex) {
            Logger.getLogger(ServletCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("agenda", agenda);
        
        getServletContext().getRequestDispatcher("/ServletImpressao").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
