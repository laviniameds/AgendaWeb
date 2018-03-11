/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.Agenda;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletImpressao", urlPatterns = {"/ServletImpressao"})
public class ServletImpressao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession sessao = request.getSession();
        Agenda agenda = (Agenda)sessao.getAttribute("agenda");
        
        PrintWriter out = response.getWriter();
        
        out.println("<h1>Contatos</h1><br>");
        out.println("<a href=\"CadastrarContato.html\">Cadastrar</a><br><br>");
        out.println("<table style=\"width:70%; border: 1px solid black;\">");
        out.println("<tr><th>Nome</th>");
        out.println("<th>E-mail</th>");
        out.println("<th>Telefone</th>");
        out.println("<th>Endereço</th>");
        out.println("<th>Detalhes</th></tr>");
        
        for(Contato cont:agenda.getAgenda()){
            if(cont != null)
                out.println("<tr><td>" + cont.getNome()+ "<td></tr>");
        }
        
        out.println("</table>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
