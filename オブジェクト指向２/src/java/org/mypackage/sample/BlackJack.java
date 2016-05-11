/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;



/**
 *
 * @author kotaroh
 */
public class BlackJack extends HttpServlet {

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
        try {
            Dealer dealhand=new Dealer();
            ArrayList<Integer> dealerCards = dealhand.myCards;
            dealhand.deal();
            dealhand.setCard();
            dealhand.open();
            while(dealhand.checkSum())
            {dealhand.hit();
            dealhand.setCard();
            dealhand.open();}
            int Do=dealhand.open();
                       
            out.println("Dealerの引いたカードは"+dealerCards.get(0)+"と"+dealerCards.get(1));
            if(dealerCards.get(0)+dealerCards.get(1)<15||Do<15){
            for(int i=2;dealerCards.size()>i;i++){
            out.println("、"+dealerCards.get(i));
            }out.println("であり、合計は"+Do+"<br>");
            }else {
                out.println("合計は"+Do+"<br>");}
            
             User userhand = new User(dealhand);
             ArrayList<Integer> userCards = userhand.myCards;
             userhand.deal();
             userhand.setCard();
             userhand.open();
             while(userhand.checkSum())
             {userhand.hit();
             userhand.setCard();
             userhand.open();}
             int Uo=userhand.open();            
                   
             out.println("Userの引いたカードは"+userCards.get(0)+"と"+userCards.get(1));
             if(userCards.get(0)+userCards.get(1)<15||Do<15){
             for(int i=2;userCards.size()>i;i++){
             out.println("、"+userCards.get(i));
             }out.println("であり、合計は"+Uo+"<br>");
             }else {
                out.println("合計は"+Uo+"<br>");}            
             
            if(Do>21&&Uo<=21)
            {
            out.print("Userの勝ち！");
            }
            else if(Do<=21&&Uo>21)
            {
            out.print("Dealerの勝ち！"); 
            }
            else if(Do>Uo)
            {
            out.print("Dealerの勝ち！");
            }
            else if(Do<Uo)
            {
            out.print("Userの勝ち！");
            }
            else if(Do>21&&Uo>21)
            {
            out.print("Userの勝ち！");
            }
            else if(Do==Uo&&Do<=21&&Uo<=21)
            {
            out.print("Dealerの勝ち！");
            }
            else{out.println("エラー");         }        

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
