/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kotaroh
 */
public class Delete extends HttpServlet {

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

        try {
            /*cart.jspとbuyconfirm.jspで商品を削除したい場合に利用
            原則として購入確認画面での商品の削除をしてほしくはないので、リンク先をCartに限定している
            一項目消去する場合とまとめて消す場合の処理の両方に対応できるようにして、
            仕事の類似するサーブレットの量を減らした*/

            if ("all".equals(request.getParameter("id"))) {
                Log.getInstance().LogWrite("Deleteにアクセスされました。cart.jspに遷移します");
                UserDataDAO.getInstance().DeleteCartAll();
                request.setAttribute("add", "カートを全て削除しました");
            } else {
                Log.getInstance().LogWrite("Deleteにアクセスされました。cart.jspに遷移します");
                UserDataDAO.getInstance().DeleteCart(request.getParameter("id"));
                request.setAttribute("add", "カートから削除しました");
            }
            request.getRequestDispatcher("/Cart").forward(request, response);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
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
