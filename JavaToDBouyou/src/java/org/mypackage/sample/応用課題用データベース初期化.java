/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kotaroh
 */
public class 応用課題用データベース初期化 extends HttpServlet {

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
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        Statement stmt = null;
        String db_Command = null;
        int num = 0;
        
        try {
            /* TODO output your page here. You may use following sample code. */

            out.println("初期化します<br>");
            
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","Ohguchi","0086");
                   stmt = db_con.createStatement();
                   db_Command =
                   "delete from JavaToDBouyouUser;";
                    num = stmt.executeUpdate(db_Command);
                   db_Command =
                   "delete from JavaToDBouyouItem;";
                    num = stmt.executeUpdate(db_Command);  
                    
                   db_Command =
                   "insert into JavaToDBouyouUser value(1,'Ohguchi','0086');";
                    num = stmt.executeUpdate(db_Command);  

            db_st = db_con.prepareStatement("select *from  JavaToDBouyouUser");

                       out.println("初期化完了！<br>");

            db_data = db_st.executeQuery();
            while(db_data.next()){
               out.println("userIDは"+db_data.getString("userID")+"<br>");
               out.println("名前は"+db_data.getString("username")+"<br>");
               out.println("パスワードは"+db_data.getString("password")+"<br>");
               out.println("<br>");
            }
            db_st = db_con.prepareStatement("select *from  JavaToDBouyouItem");

                       out.println("初期化完了！<br>");

            db_data = db_st.executeQuery();
            while(db_data.next()){
               out.println("itemIDは"+db_data.getString("itemID")+"<br>");
               out.println("商品の名前は"+db_data.getString("itemName")+"<br>");
               out.println("商品種別は"+db_data.getString("itemGenre")+"<br>");
               out.println("値段は"+db_data.getString("itemPrice")+"<br>");
               out.println("原価は"+db_data.getString("itemCost")+"<br>");
               out.println("<br>");
            }
            
            db_data.close();
            db_st.close();
            db_con.close();
        }  catch (SQLException e_sql){
             out.println("sql接続えらー"+ e_sql.toString());
        }  catch (Exception e){
              out.println("e接続えらー"+ e.toString());          
        } finally {
            if (db_con !=null){
                try {
                    db_con.close();
                   } 
                catch (Exception e_con)
                 {
                    System.out.println("nullエラー"+e_con.getMessage());
                 }
            }
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
