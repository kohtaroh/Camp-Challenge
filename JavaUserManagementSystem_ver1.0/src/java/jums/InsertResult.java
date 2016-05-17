package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
                 PrintWriter out = response.getWriter();
        //セッションスタート
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");//課題4データが戻ってきたとき用のエンコード処理
        try{
            String accesschk = request.getParameter("result");
            if(accesschk ==null || (Integer)session.getAttribute("result")!=Integer.parseInt(accesschk)){
                
                throw new Exception("不正なアクセスです");
               
            }//課題2修正箇所 insertconfirmからアクセスされたときにランダムの値を受け取る。
            //受け取れないとエラーになる
            kadai7Bean k = (kadai7Bean)session.getAttribute("kadai7Bean");
            String str = k.getYear()+"/"+k.getMonth()+"/"+k.getDay();
            //課題6誕生日のデータをDate型に変換できるように連結して変数に保存
            java.util.Date date = DateFormat.getDateInstance().parse(str);
      
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName(k.getName());
            userdata.setBirthday(date);//ここで連結した文字をいれる
            userdata.setType(Integer.parseInt(k.getType()));
            userdata.setTell(k.getTell());
            userdata.setComment(k.getComment());
        

   /*         String str = session.getAttribute("year")+"/"+session.getAttribute("month")+"/"+session.getAttribute("day");
            //課題6誕生日のデータをDate型に変換できるように連結して変数に保存
            java.util.Date date = DateFormat.getDateInstance().parse(str);
      
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName((String)session.getAttribute("name"));
            userdata.setBirthday(date);//ここで連結した文字をいれる
            userdata.setType(Integer.parseInt((String)session.getAttribute("type")));
            userdata.setTell((String)session.getAttribute("tell"));
            userdata.setComment((String)session.getAttribute("comment"));
    */    
            //DBへデータの挿入
            UserDataDAO .getInstance().insert(userdata);
         
             
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
      //      session.invalidate(); //課題5いらなくなったセッションを削除 そのためリロードするとエラーになってしまう
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
