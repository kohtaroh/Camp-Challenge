package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class JavaToDBouyouDataSet_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");

    
    
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JavaToDBouyouDateSet</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>商品情報登録機能</h1>\n");
      out.write("               <form action=\"http://localhost:8080/JavaToDBouyou/JavaToDBouyouDataGet\" method=\"post\">\n");
      out.write("                       商品情報入力フォームです<br>\n");
      out.write("                       全ての項目が入力必須となっています<br>\n");
      out.write("                   ID<input type=\"text\" name=\"txtID\" required><br><br>\n");
      out.write("                   名前<input type=\"text\" name=\"txtName\" required><br>\n");
      out.write("                   種類<select name=\"txtGenre\" size=\"1\" required><br><br>\n");
      out.write("                            <option></option>\n");
      out.write("                            <option value=\"肉類\">肉類</option>\n");
      out.write("                            <option value=\"魚介類\">魚介類</option>\n");
      out.write("                            <option value=\"青果\">青果</option>\n");
      out.write("                            <option value=\"飲料\">飲料</option>\n");
      out.write("                            <option value=\"菓子類\">菓子類</option>\n");
      out.write("                            <option value=\"酒\">酒</option>\n");
      out.write("                            <option value=\"雑貨\">雑貨</option>\n");
      out.write("                       </select><br><br>\n");
      out.write("                   値段<input type=\"text\" name=\"txtPrice\" required><br>\n");
      out.write("                   原価<input type=\"text\" name=\"txtCost\" required><br>\n");
      out.write("                   <input type=\"submit\" value=\"登録\">\n");
      out.write("               </form>  \n");
      out.write("               <form action=\"http://localhost:8080/JavaToDBouyou/JavaToDBouyouResults\" method=\"post\">\n");
      out.write("                  <br><br>\n");
      out.write("                  このボタンを押すと入力フォームが保存されません！！<br>\n");
      out.write("                  注意！！<br>\n");
      out.write("                  <input type=\"submit\" value=\"一覧を見る\">\n");
      out.write("               </form>          \n");
      out.write("               <form action=\"http://localhost:8080/JavaToDBouyou/JavaToDBouyouLogin.jsp\" method=\"post\">\n");
      out.write("                  <br><br>\n");
      out.write("                  <input type=\"submit\" value=\"ログアウト\">\n");
      out.write("               </form>          \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
