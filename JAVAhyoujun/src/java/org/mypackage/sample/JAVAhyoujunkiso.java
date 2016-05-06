/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.*;

/**
 *
 * @author kotaroh
 */
public class JAVAhyoujunkiso extends HttpServlet {

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

Calendar cal = Calendar.getInstance();//課題1
cal.set(2016,1,1,0,00,00);
Date kadai1 = cal.getTime();
out.print(kadai1.getTime()+"<br>");//課題1

Date kadai2 = new Date();
Calendar k2 = Calendar.getInstance();//課題2
k2.setTime(kadai2);
int ye2 = k2.get(Calendar.YEAR);
int mo2 = k2.get(Calendar.MONTH)+1;
int da2 = k2.get(Calendar.DAY_OF_MONTH);
int ho2 = k2.get(Calendar.HOUR_OF_DAY);
int mi2 = k2.get(Calendar.MINUTE);
int se2 = k2.get(Calendar.SECOND);
out.print("今は"+ye2+"-"+mo2+"-"+da2+" "+ho2+":"+mi2+":"+se2+"<br>" );//課題2

Calendar k3 = Calendar.getInstance();//課題3
k3.set(2016,11,4,10,00,00);
int ye3 = k3.get(Calendar.YEAR);
int mo3 = k3.get(Calendar.MONTH);
int da3 = k3.get(Calendar.DAY_OF_MONTH);
int ho3 = k3.get(Calendar.HOUR_OF_DAY);
int mi3 = k3.get(Calendar.MINUTE);
int se3 = k3.get(Calendar.SECOND);
out.print(ye3+"-"+mo3+"-"+da3+" "+ho3+":"+mi3+":"+se3+"<br>" );//課題3

Calendar ka4a = Calendar.getInstance();//課題4
cal.set(2015,1,1,0,00,00);
Date ka4n = cal.getTime();
Calendar ka4b = Calendar.getInstance();
cal.set(2015,12,31,23,59,59);
Date ka4m = cal.getTime();
long kadai4 =(ka4m.getTime()-ka4n.getTime());
out.print(kadai4+"<br>");//課題4


String kadai5 = "大口光太郎";//課題5
out.print("バイト数は"+kadai5.getBytes().length+"文字数は"+kadai5.length()+"<br>");//課題5

String k6 = "0.satisfact.0@gmail.com";//課題6
int kadai6=k6.indexOf("@");
out.println(k6.substring(kadai6)+"<br>");//課題6

String kadai7="きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";//課題7
kadai7=kadai7.replace("U","う");
kadai7=kadai7.replace("I","い");
out.println(kadai7+"<br>");//課題7

File kadai8= new File("C:\\Users\\kotaroh\\Downloads\\test.txt");//課題8
BufferedWriter Rew = new BufferedWriter(new FileWriter(kadai8));
Rew.write("私の名前は大口光太郎");
Rew.newLine();
Rew.write("javaの勉強をしています");
Rew.close();

try {
    /* TODO output your page here. You may use following sample code. */

File kadai9 = new File("C:\\Users\\kotaroh\\Downloads\\test.txt");//課題9
FileReader filereader = new FileReader(kadai9);
int ch;
while((ch = filereader.read()) != -1)
    {
        out.print((char)ch);
    }
     filereader.close();
}
catch(FileNotFoundException e)
    {
    out.println(e);
    }
        catch(IOException e)
        {
            out.println(e);            
        } finally {
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