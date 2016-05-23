package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hayashi-s
 */
public class SearchResult extends HttpServlet {

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

        try {
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

            //getで受けとった日本語はそのままでは文字化けしてしまう
            UserDataBeans udb = new UserDataBeans();
            udb.setName(new String(request.getParameter("name").getBytes("iso-8859-1"), "UTF-8"));
            udb.setYear(request.getParameter("year"));
            udb.setType(request.getParameter("type"));

            //javabeansにメソッドを作成したかったが、引数にnullを用いれるjavabeansの用法を見つけられなかったため、
            //サーブレットに書いた
            String Submit = "";
            if (request.getParameter("and") != null) {
                if ("完全一致検索".equals(new String(request.getParameter("and").getBytes("iso-8859-1"), "UTF-8"))) {
                    Submit = "完全一致検索";
                }
            }
            if (request.getParameter("or") != null) {
                if ("部分一致検索".equals(new String(request.getParameter("or").getBytes("iso-8859-1"), "UTF-8"))) {
                    Submit = "部分一致検索";
                }
            }
            //UserDataDAOのsearchメソッドは引数二つに変更している
            //ここでrequestに入れているのは、次の.javaであるResultDetailでのブックマークに対応するため
            UserDataDTO searchData = new UserDataDTO();
            udb.UD2DTOMapping(searchData);
            request.setAttribute("resultData", UserDataDAO.getInstance().search(searchData, Submit));

            request.getRequestDispatcher("/searchresult.jsp").forward(request, response);

        } catch (Exception e) {
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
