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
@WebServlet(name = "ServletDetalhesContato", urlPatterns = {"/ServletDetalhesContato"})
public class ServletDetalhesContato extends HttpServlet {

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
        
        HttpSession sessao = request.getSession();
        Agenda agenda = (Agenda)sessao.getAttribute("agenda");
        Contato c = agenda.buscarContato(request.getParameter("nome"));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Editar contato</h1>\n" +
"        <div style=\"width: 70%;\">\n" +
"        <form method=\"post\" action=\"ServletEditarContato\">\n" +
"            <label>Nome:</label>\n" +
"            <input type=\"text\" value=\""+ c.getNome() +"\" name=\"nome\">\n" +
"            <br>\n" +
"            <label>E-mail:</label>\n" +
"            <input type=\"email\" value=\""+ c.getEmail()+"\" name=\"email\">\n" +
"            <br>\n" +
"            <label>Telefone:</label>\n" +
"            <input type=\"text\" value=\""+ c.getFone()+"\" name=\"fone\">\n" +
"            <br>\n" +
"            \n" +
"            <h3>Endereço</h3>\n" +
"            <label>Cidade:</label>\n" +
"            <input type=\"text\" value=\""+ c.getCidade()+"\" name=\"cidade\"/>\n" +
"            <br>\n" +
"            <label>Estado:</label>\n" +
"            <input type=\"text\"value=\""+ c.getEstado()+"\" name=\"estado\"/>\n" +
"            <br>\n" +
"            <label>Bairro:</label>\n" +
"            <input type=\"text\" value=\""+ c.getBairro()+"\" name=\"bairro\"/>\n" +
"            <br>\n" +
"            <label>Rua:</label>\n" +
"            <input type=\"text\" value=\""+ c.getRua()+"\" name=\"rua\"/>\n" +
"            <br>\n" +
"            <label>Número:</label>\n" +
"            <input type=\"text\" value=\""+ c.getNumero()+"\" name=\"numero\"/>\n" +
"            <br>\n" +
"            <br> <br>\n" +
"            <input type=\"submit\" value=\"Enviar\" />" +
"             </form>\n" +
"             </div>");
        }
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
