/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.logging.Logger;
import java.io.IOException;

/**
 *
 * @author kotaroh
 */
public class JAVAhyoujunOuyou extends HttpServlet {
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
Date start = new Date();
Calendar st = Calendar.getInstance();
st.setTime(start);
int ye1 = st.get(Calendar.YEAR);
int mo1 = st.get(Calendar.MONTH)+1;
int da1 = st.get(Calendar.DAY_OF_MONTH);
int ho1 = st.get(Calendar.HOUR_OF_DAY);
int mi1 = st.get(Calendar.MINUTE);
int se1 = st.get(Calendar.SECOND);

File tes= new File("C:\\Users\\kotaroh\\Downloads\\tes.txt");
BufferedWriter Rew = new BufferedWriter(new FileWriter(tes));
Rew.write("処理の開始時間は"+ye1+"-"+mo1+"-"+da1+" "+ho1+":"+mi1+":"+se1+"<br>");
Rew.newLine();
double a=4;
double b=27;
a = Math.sqrt(a);
b = Math.cbrt(b);
Rew.write(String.valueOf(a)+"<br>");
Rew.newLine();
Rew.write(String.valueOf(b)+"<br>");
Rew.newLine();
a = Math.max(a, b);
Rew.write(String.valueOf(a)+"<br>");
Rew.newLine();
a = Math.pow(a, b);
Rew.write(String.valueOf(a)+"<br>");
Rew.newLine();
Rew.close();

Date end = new Date();
Calendar en = Calendar.getInstance();
en.setTime(end);
int ye2 = en.get(Calendar.YEAR);
int mo2 = en.get(Calendar.MONTH)+1;
int da2 = en.get(Calendar.DAY_OF_MONTH);
int ho2 = en.get(Calendar.HOUR_OF_DAY);
int mi2 = en.get(Calendar.MINUTE);
int se2 = en.get(Calendar.SECOND);
tes= new File("C:\\Users\\kotaroh\\Downloads\\tes.txt");
Rew = new BufferedWriter(new FileWriter(tes,true));
Rew.write("処理の終了時間は"+ye2+"-"+mo2+"-"+da2+" "+ho2+":"+mi2+":"+se2);
Rew.close();
tes = new File("C:\\Users\\kotaroh\\Downloads\\tes.txt");

try {
FileReader filereader = new FileReader(tes);
int ch;
while((ch = filereader.read()) != -1){
out.print((char)ch);}
filereader.close();
}catch(FileNotFoundException e){
out.println(e);
}catch(IOException e){
out.println(e);            
            /* TODO output your page here. You may use following sample code. */
        } finally {
            out.close();}}
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

    private void out(Logger logger) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}