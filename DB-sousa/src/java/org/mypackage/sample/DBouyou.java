/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kotaroh
 */
public class DBouyou extends HttpServlet {
    
    
    
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
        PrintWriter out = response.getWriter();
        
    request.setCharacterEncoding("UTF-8");
    String Name = request.getParameter("txtName");
    String Sex = request.getParameter("rdoSex");
    String Fun = request.getParameter("txtFun");
    
    HttpSession ouyou = request.getSession(true);
    
    File Named= new File("C:\\Users\\kotaroh\\Downloads\\DBouyouName.txt");
     BufferedWriter Rew = new BufferedWriter(new FileWriter(Named));
            Rew.write(Name);
            Rew.close();      
    File Sexed= new File("C:\\Users\\kotaroh\\Downloads\\DBouyouSex.txt");
     Rew = new BufferedWriter(new FileWriter(Sexed));
            Rew.write(Sex);
            Rew.close();      
    File Funs= new File("C:\\Users\\kotaroh\\Downloads\\DBouyouFun.txt");
     Rew = new BufferedWriter(new FileWriter(Funs));
            Rew.write(Fun);
            Rew.close();      

    ouyou.setAttribute("名前", Name);
    ouyou.setAttribute("性別", Sex);
    ouyou.setAttribute("趣味", Fun);
    out.println("名前は"+Name+"<br>");
    out.println("性別は"+Sex+"<br>");
    out.println("趣味は"+Fun+"<br>");
        try {
            /* TODO output your page here. You may use following sample code. */
        } finally {
            out.close();
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
