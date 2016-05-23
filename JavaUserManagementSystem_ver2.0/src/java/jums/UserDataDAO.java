package jums;

import base.DBManager;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する DB接続系はDBManagerクラスに一任 基本的にはやりたい1種類の動作に対して1メソッド
 *
 * @author hayashi-s
 */
public class UserDataDAO implements Serializable {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }

    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void insert(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * データの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    //戻り値をArrayList<String>にして、複数の結果が戻るようにした
    //第一引数のudはフォームから入力された検索用の情報であり、
    //第二引数のSubmitはSubmitボタンから送られてくる情報である
    public ArrayList<String> search(UserDataDTO ud, String Submit) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ArrayList<String> al = new ArrayList();
        try {
            con = DBManager.getConnection();
            //完全一致検索のボタンを押された時に使われる
            //使用されることはあまり想定していない
            if ("完全一致検索".equals(Submit)) {
                String sql = "SELECT * FROM user_t WHERE name = ? AND birthday like ? AND type = ?";
                st = con.prepareStatement(sql);
                st.setString(1, ud.getName());
                st.setString(2, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                st.setInt(3, ud.getType());
            }

            //部分一致検索のボタンを押された時に使いたい
            //空文字の検索にも対応。このコードの場合は空文字検索時に全て表示する
            if ("部分一致検索".equals(Submit)) {
                String sql = "SELECT * FROM user_t";
                boolean flag = false;
                if (!ud.getName().equals("")) {
                    sql += " WHERE name like ?";
                    flag = true;
                }
                if (ud.getBirthday() != null) {
                    if (!flag) {
                        sql += " WHERE birthday like ?";
                        flag = true;
                    } else {
                        sql += " AND birthday like ?";
                    }
                }
                if (ud.getType() != 0) {
                    if (!flag) {
                        sql += " WHERE type like ?";
                    } else {
                        sql += " AND type like ?";
                    }
                }

                st = con.prepareStatement(sql);
                flag = false;
                boolean lag = false;
                if (!ud.getName().equals("")) {
                    st.setString(1, "%" + ud.getName() + "%");
                    flag = true;
                }
                if (ud.getBirthday() != null) {
                    if (!flag) {
                        st.setString(1, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                        flag = true;
                    } else {
                        st.setString(2, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                        lag = true;
                    }
                }
                if (ud.getType() != 0) {
                    if (!flag) {
                        st.setInt(1, ud.getType());
                    } else if (!lag) {
                        st.setInt(2, ud.getType());
                    } else {
                        st.setInt(3, ud.getType());
                    }
                }
            }
            
            //上記から複数パターンあるselect文の一つが送られてき、検索結果が全てArrayListに入る
            //insert.jspやupdate.jspの仕様上空白が送られてくることはない
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                al.add(rs.getString(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(5));
                al.add(rs.getString(7));
            }
            System.out.println("search completed");
            //戻り値は配列alである
            return al;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public UserDataDTO searchByID(String ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            String sql = "SELECT * FROM user_t WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(ud));

            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));

            System.out.println("searchByID completed");

            return resultUd;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void update(UserDataDTO ud) throws SQLException {
        //UpdateResult.javaで使用するメソッド。
        //resultdetail.jspからのuserIDとupdate.jspで入力された
        //各種データ(空白なし)を使用してデータの変更を行いたい
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            String sql = "update user_t set name=?,birthday=?,tell=?,type=?,comment=? WHERE userID = ?";

            Calendar cal = Calendar.getInstance();
            cal.setTime(ud.getBirthday());
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            java.sql.Date t = new java.sql.Date(cal.getTimeInMillis());

            st = con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setDate(2, t);
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setInt(6, ud.getUserID());

            st.executeUpdate();

            System.out.println("update completed");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public void delete(String id) throws SQLException {
        //DeleteResult.javaで使用するメソッド
        //resultdetail.jspからのuserIDを使用して
        //データを削除する
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            int ud = Integer.parseInt(id);

            String sql = "delete  FROM user_t WHERE userID = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, ud);
            st.executeUpdate();

            System.out.println("delete completed");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
