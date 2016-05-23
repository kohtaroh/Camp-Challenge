/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kotaroh
 */
public class テーブル確認 extends HttpServlet {

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
        UserDataDTO resultUd  = new UserDataDTO();
        ArrayList<String> al = new ArrayList<String>();

        try {
            /* TODO output your page here. You may use following sample code. */
           Class.forName("com.mysql.jdbc.Driver").newInstance();
           db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","Ohguchi","0086");
           db_st = db_con.prepareStatement("select *from  user_t");
          db_data = db_st.executeQuery();
            while(db_data.next()){
               out.println("userIDは"+db_data.getString("userID")+"<br>");
               out.println("名前は"+db_data.getString("name")+"<br>");
               out.println("誕生日は"+db_data.getString("birthday")+"<br>");
               out.println("種別は"+db_data.getString("type")+"<br>");
               out.println("電話番号は"+db_data.getString("tell")+"<br>");
               out.println("自己紹介！"+db_data.getString("comment")+"<br>");
               out.println("登録時間"+db_data.getString("newDate")+"<br>");
               out.println("<br>");
            resultUd.setUserID(db_data.getInt(1));
            resultUd.setName(db_data.getString(2));
            resultUd.setBirthday(db_data.getDate(3));
            resultUd.setTell(db_data.getString(4));
            resultUd.setType(db_data.getInt(5));
            resultUd.setComment(db_data.getString(6));
            resultUd.setNewDate(db_data.getTimestamp(7));
            al.add(db_data.getString(3));
            }                
            out.println(al.get(1));
            
            db_data.close();
            db_st.close();
            db_con.close();  
            
       out.println("表示完了！<br>");
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