/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kotaroh
 */
public class BuyComplete extends HttpServlet {

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
        HttpSession session = request.getSession();
        try {
            /*購入履歴をDBに登録したいのでログイン時にsessionへ格納されるuserIDとbuycomfirmの金額と配送方法を受けとりたい。
             また、非ログイン状態でのアクセスに対してLoginに飛ばし、非ログイン状態であることを伝えたい
            LookCartBeansからUserCartDTOにMappingを考えたが、購入商品の発送方法はここで初めて受け取れ、
            userIDは独立しているため、要素一つだけを変換する方が手間だと考えました*/

            Log.getInstance().LogWrite("BuyCompleteにアクセスされました。userID" + session.getAttribute("userID")
                    + Integer.parseInt(request.getParameter("total")) + "を追加しました");
            if (session.getAttribute("userID") == null || session.getAttribute("userID").equals("0")) {
                request.setAttribute("error", "ログインされていません");
                request.getRequestDispatcher("/Login").forward(request, response);
            } else {
                UserCartDTO ucd = new UserCartDTO();
                ucd.setUserID(Integer.parseInt(session.getAttribute("userID").toString()));
                ucd.setTotal(Integer.parseInt(request.getParameter("total")));
                ucd.setType(Integer.parseInt(request.getParameter("type")));
                UserDataDAO.getInstance().UserTotal(ucd);
                UserDataDAO.getInstance().UserBuy(ucd);
                UserDataDAO.getInstance().DeleteCartAll();
                request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
