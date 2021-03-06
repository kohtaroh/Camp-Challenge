package jums;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラスです。定数なども保存されます
 * @author hayashi-s
 */
public class JumsHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<A Href=http://localhost:8080/JavaUserManagementSystem_ver1.0/"+homeURL+">トップへ戻る</a>";
        //課題1修正箇所、戻り値を「index.jsp」のみから「ジャンプさせたいURLすべて」に修正しました
    }
}
