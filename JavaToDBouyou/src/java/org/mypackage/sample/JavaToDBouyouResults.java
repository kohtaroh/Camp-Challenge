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
public class JavaToDBouyouResults extends HttpServlet {

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
            
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","Ohguchi","0086");
           
           db_st = db_con.prepareStatement("select *from JavaToDBouyouItem;");   

           db_data = db_st.executeQuery();
           out.println("現在の入力済みデータ"+"<br>");
               
           while(db_data.next())
                            {
                   out.println("商品IDは"+db_data.getString("itemID")+"<br>");
                   out.println("名前は"+db_data.getString("itemName")+"<br>");
                   out.println("商品種別は"+db_data.getString("itemGenre")+"<br>");
                   out.println("値段は"+db_data.getString("itemPrice")+"<br>");
                   out.println("原価は"+db_data.getString("itemCost")+"<br>");
                   out.println("<br>");
                            }           
                            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JavaToDBouyouDataGet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1></h1>");
            out.println("</body>");
            out.println("<form action=\"http://localhost:8080/JavaToDBouyou/JavaToDBouyouDataSet.jsp\">");
            out.println("<input type=\"submit\" value=\"登録フォームに戻る\">");
            out.println("</form><br>");
            out.println("<form action=\"http://localhost:8080/JavaToDBouyou/JavaToDBouyouLogin.jsp\">");
            out.println("<input type=\"submit\" value=\"ログアウト\">");
            out.println("</form>");
            out.println("</html>");                         
            
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
