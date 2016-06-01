/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.servlet.ServletException;

/**
 *
 * @author kotaroh
 */
public class Log implements Serializable {

    public static Log getInstance() {
        return new Log();
    }
/**
 *何か処理が発生するたびにその時点の時刻とともに引数に入れられたコメントが出力される
 * 初期化はされない。
 */
    public void LogWrite(String words) throws ServletException, IOException {
        File tes = new File("C:\\Users\\kotaroh\\Documents\\NetBeansProjects\\kagoyume\\web\\WEB-INF\\log\\log.txt");
        Date date = new Date();
        BufferedWriter Rew = new BufferedWriter(new FileWriter(tes,true));
        Rew.write(words);
        Rew.write("実行時間" + date + "<br>");
        Rew.newLine();
        Rew.close();

    }
}
