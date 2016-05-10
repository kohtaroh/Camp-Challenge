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
public class JavaToDBkadai12 extends HttpServlet {

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
        
        String Submit = "";
        if("完全一致".equals(request.getParameter("AND")))
        {
            Submit = request.getParameter("AND");
        }
        else if("部分一致".equals(request.getParameter("OR")))
        {
            Submit = request.getParameter("OR");
        }
        
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
            
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","Ohguchi","0086");
           
            if(Submit.equals("完全一致"))
                {
                 out.println("完全一致検索です");
                 out.println("<br>現在の入力済みデータ"+"<br>");
                 db_st = db_con.prepareStatement("select *from  profiles where name='"+Name+"' AND tell='"+Tell+"' AND age="+Age+" AND birthday ='"+Birth+"';");   
                 db_data = db_st.executeQuery();
               
                 while(db_data.next())
                            {
                   out.println("IDは"+db_data.getString("profileID")+"<br>");
                   out.println("名前は"+db_data.getString("name")+"<br>");
                   out.println("電話番号は"+db_data.getString("tell")+"<br>");
                   out.println("年齢は"+db_data.getString("age")+"<br>");
                   out.println("誕生日は"+db_data.getString("birthday")+"<br>");
                   out.println("<br>");
                            }   
                 }
            if(Submit.equals("部分一致"))
                {
                 out.println("部分一致検索です");
                 
                 if(Birth.length() == 0 && Age.length() == 0)
                      {
                 db_st = db_con.prepareStatement("select *from  profiles where name like '%"+Name+"%';");   
                      }                 
                 if(Birth.length() == 0 && Age.length() > 0)
                      {
                 db_st = db_con.prepareStatement("select *from  profiles where name like '%"+Name+"%' AND age = "+Age+";");   
                      }
                 if(Birth.length() > 0 && Age.length() == 0)
                      {
                 db_st = db_con.prepareStatement("select *from  profiles where name like '%"+Name+"%' AND birthday like '%"+Birth+"%';");
                      }
                 if(Birth.length() > 0 && Age.length() > 0)
                      {    
                 db_st = db_con.prepareStatement("select *from  profiles where name like '%"+Name+"%'  AND age ="+Age+" AND birthday like '%"+Birth+"%';");   
                      }
                 
                 db_data = db_st.executeQuery();
                 out.println("<br>現在の入力済みデータ"+"<br>");
               
                 while(db_data.next())
                            {
                   out.println("IDは"+db_data.getString("profileID")+"<br>");
                   out.println("名前は"+db_data.getString("name")+"<br>");
                   out.println("電話番号は"+db_data.getString("tell")+"<br>");
                   out.println("年齢は"+db_data.getString("age")+"<br>");
                   out.println("誕生日は"+db_data.getString("birthday")+"<br>");
                   out.println("<br>");
                            }           
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
