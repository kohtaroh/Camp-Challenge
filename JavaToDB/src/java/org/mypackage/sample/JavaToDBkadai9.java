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
public class JavaToDBkadai9 extends HttpServlet {

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
        String ID = request.getParameter("txtID");
        String Name = request.getParameter("txtName");
        String Tell = request.getParameter("txtTell");
        String Age = request.getParameter("txtAge");
        String Birth = request.getParameter("txtBirth");
   
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        Statement stmt = null;
        String db_Command = null;
        int num = 0;
        
        try {
            /* TODO output your page here. You may use following sample code. */
           out.println("入力されたIDは"+ID+"<br>");
           if(Name != "")
           {
           out.println("入力された名前は"+Name+"<br>");
           }else {out.println("未入力です<br>");}
           if(Tell != "")
           {
           out.println("入力された電話番号は"+Tell+"<br>");
           }else {out.println("未入力です<br>");}
           if(Age != "")
           {
           out.println("入力された年齢は"+Age+"<br>");
           }else {out.println("未入力です<br>");}
           if(Birth != "")
           {
           out.println("入力された誕生日は"+Birth+"<br>");
           }else {out.println("未入力です<br>");}

           Class.forName("com.mysql.jdbc.Driver").newInstance();
           db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","Ohguchi","0086");
           
            db_st = db_con.prepareStatement("select *from  profiles where profileiD="+ID+";");
            db_data = db_st.executeQuery();
            
                   if(Name == "")
                   {
                      Name = "未入力";
                   }
                   if(Tell == "")
                   {
                      Tell = "未入力";
                   }
                   if(Age == "")
                   {
                      Age = "0";
                   }
                   if(Birth == "")
                   {
                       Birth = "1900-01-01";
                   }
                   stmt = db_con.createStatement();
                   db_Command =
                   "INSERT INTO profiles VALUES("+ID+",'"+Name+"','"+Tell+"',"+Age+",'"+Birth+"');";
                    num = stmt.executeUpdate(db_Command);
               
            db_st = db_con.prepareStatement("select *from  profiles");
           
            db_data = db_st.executeQuery();
            out.println("<br>現在の入力済みデータ"+"<br>");
            while(db_data.next()){
               out.println("IDは"+db_data.getString("profileID")+"<br>");
               out.println("名前は"+db_data.getString("name")+"<br>");
               out.println("電話番号は"+db_data.getString("tell")+"<br>");
               out.println("年齢は"+db_data.getString("age")+"<br>");
               out.println("誕生日は"+db_data.getString("birthday")+"<br>");
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
