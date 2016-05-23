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
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author kotaroh
 */
public class テーブル初期化 extends HttpServlet {

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
        PreparedStatement st = null;
                
        try {
            /* TODO output your page here. You may use following sample code. */

           Class.forName("com.mysql.jdbc.Driver").newInstance();
           db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","Ohguchi","0086");           
            
            stmt = db_con.createStatement();

                   db_Command =
                   "delete from user_t;";
                    num = stmt.executeUpdate(db_Command);    
                    Date date = new Date();
                            Calendar cal = Calendar.getInstance(); //課題6 セッションに格納した情報を取得
        cal.set(1990,02,04,0,00,00);//util.dateからsql.dateに変換
        cal.set(Calendar.MILLISECOND, 0);
        java.sql.Date d2 = new java.sql.Date(cal.getTimeInMillis());  
                    
            st =  db_con.prepareStatement("INSERT INTO user_t(userID,name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?,?)");
            st.setInt(1, 1);
            st.setString(2, "大口");
            st.setDate(3, d2);//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(4, "000");
            st.setInt(5, 1);
            st.setString(6, "ユニヴァース！");
            st.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
                    
            st =  db_con.prepareStatement("INSERT INTO user_t(userID,name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?,?)");
            st.setInt(1, 2);
            st.setString(2, "光太郎");
            st.setDate(3, d2);//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(4, "001");
            st.setInt(5, 1);
            st.setString(6, "テスト");
            st.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
                    
            st =  db_con.prepareStatement("INSERT INTO user_t(userID,name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?,?)");
            st.setInt(1, 3);
            st.setString(2, "大");
            st.setDate(3, d2);//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(4, "007");
            st.setInt(5, 1);
            st.setString(6, "！！！");
            st.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
                    
            String sql = "update user_t set name=?,birthday=?,tell=?,type=?,comment=? WHERE userID = ?";
            
            st =  db_con.prepareStatement(sql);
            st.setString(1, "a");
            st.setDate(2,d2);
            st.setString(3,"abc");
            st.setInt(4,1);
            st.setString(5,"ユニヴァース！");
            st.setInt(6,3);
            
            st.executeUpdate();
                    
                    

            db_con.close();  
       out.println("初期化完了！<br>");
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