package jums;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 *
 * @author hayashi-s
 */
public class JumsHelper {

    //トップへのリンクを定数として設定
    private final String homeURL = "index.jsp";

    public static JumsHelper getInstance() {
        return new JumsHelper();
    }

    //トップへのリンクを返却
    public String home() {
        return "<a href=\"" + homeURL + "\">トップへ戻る</a>";
    }

    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が 未入力なのかのhtml文を返却する
     *
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList) {
        String output = "";
        for (String val : chkList) {
            if (val.equals("name")) {
                output += "名前";
            }
            if (val.equals("year")) {
                output += "年";
            }
            if (val.equals("month")) {
                output += "月";
            }
            if (val.equals("day")) {
                output += "日";
            }
            if (val.equals("type")) {
                output += "種別";
            }
            if (val.equals("tell")) {
                output += "電話番号";
            }
            if (val.equals("comment")) {
                output += "自己紹介";
            }
            output += "が未記入です<br>";
        }
        return output;
    }

    /**
     * 種別は数字で取り扱っているので画面に表示するときは日本語に変換
     *
     * @param i
     * @return
     */
    public String exTypenum(int i) {
        switch (i) {
            case 1:
                return "営業";
            case 2:
                return "エンジニア";
            case 3:
                return "その他";
        }
        return "";
    }
//Object型を変換したい場合が発生したため
    public String exTypeOb(Object i) {
        String i2 = i.toString();
        int i3 = new Integer(i2);
        switch (i3) {
            case 1:
                return "営業";
            case 2:
                return "エンジニア";
            case 3:
                return "その他";
        }
        return "";
    }
//マッピングでないのは、表示のみ変更できればそれでいいため
    public int[] exBirth(Date i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String str = sdf.format(i);
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(5, 7));
        int day = Integer.parseInt(str.substring(8, 10));
        int[] Brith = {year, month, day};
        return Brith;
    }
}
