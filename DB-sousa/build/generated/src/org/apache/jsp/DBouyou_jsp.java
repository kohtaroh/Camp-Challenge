package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;

public final class DBouyou_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");

      String name="";
      String sex="";
      String fun="";

      File ReadName = new File("C:\\Users\\kotaroh\\Downloads\\DBouyouName.txt");
      if (ReadName.exists()){
      FileReader Nreader = new FileReader(ReadName);
      BufferedReader brN=new BufferedReader(Nreader);
      name = brN.readLine();
      brN.close();}
      
      
      File ReadSex = new File("C:\\Users\\kotaroh\\Downloads\\DBouyouSex.txt");
      if (ReadSex.exists()){
      FileReader Sreader = new FileReader(ReadSex);
      BufferedReader brS=new BufferedReader(Sreader);
      sex = brS.readLine();
      brS.close();}
      
      String Male = "";
      String Female = "";
      
      if(sex.equals("男")){
              Male = "checked";}
      if(sex.equals("女")){
              Female = "checked";}

      File ReadFun = new File("C:\\Users\\kotaroh\\Downloads\\DBouyouFun.txt");
      if (ReadFun.exists()){
      FileReader Freader = new FileReader(ReadFun);
      BufferedReader brF=new BufferedReader(Freader);
      fun = brF.readLine();
      brF.close();}
    
      out.write("\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Javaでのデータ操作.応用課題</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Javaでのデータ操作.応用課題</h1>\n");
      out.write("              <form id=\"入力\" action=\"http://localhost:8080/DB-sousa/DBouyou\" method=\"post\">\n");
      out.write("                  名前:<input type=\"text\" name=\"txtName\" value=\"");
      out.print( name );
      out.write("\"><br><br>\n");
      out.write("      性別:\n");
      out.write("      男:<input type=\"radio\" name=\"rdoSex\" value=\"男\" ");
      out.print( Male );
      out.write(">\n");
      out.write("      女:<input type=\"radio\" name=\"rdoSex\" value=\"女\" ");
      out.print( Female );
      out.write("><br><br>\n");
      out.write("      趣味:<br><textarea name=\"txtFun\" rows=\"4\" cols=\"30\" >");
      out.print( fun );
      out.write("</textarea><br>\n");
      out.write("      <input type=\"submit\" value=\"送信\">\n");
      out.write("    </form>\n");
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
