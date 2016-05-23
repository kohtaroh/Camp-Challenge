package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.JumsHelper;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

    JumsHelper jh = JumsHelper.getInstance();

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMSユーザー情報検索画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <form action=\"SearchResult\" method=\"get\">\n");
      out.write("             <table border=1>\n");
      out.write("                 <th>部分一致で空白を入力した場合は全件表示されます</th>\n");
      out.write("             </table><br>\n");
      out.write("             \n");
      out.write("             <table border=1>\n");
      out.write("                 <th>名前:</th>\n");
      out.write("                <td><input type=\"text\" name=\"name\"></td>\n");
      out.write("             </table><br>\n");
      out.write("                \n");
      out.write("             <table border=1><th>生年:</th>\n");
      out.write("                <td> <select name=\"year\">\n");
      out.write("                    <option value=\"\">----</option>\n");
      out.write("                    ");
 for(int i=1950; i<=2010; i++){ 
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                    ");
 } 
      out.write("</select>年生まれ\n");
      out.write("                </td>\n");
      out.write("             </table><br>\n");
      out.write("\n");
      out.write("        <table border=1>\n");
      out.write("            <th align=\"center\" rowspan=\"5\">種別:</th>\n");
      out.write("            ");
 for(int i = 1; i<=3; i++){ 
      out.write("\n");
      out.write("            <tr><td><input type=\"radio\" name=\"type\" value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(jh.exTypenum(i));
      out.write("</td></tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            <tr><td><input type=\"radio\" name=\"type\" value=\"0\" checked>なし</td></tr>\n");
      out.write("        </table>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <input type=\"submit\" name=\"and\" value=\"完全一致検索\"><br>\n");
      out.write("        <input type=\"submit\" name=\"or\" value=\"部分一致検索\"><br>\n");
      out.write("    </form>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.print(jh.home());
      out.write("\n");
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
