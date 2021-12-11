package com.koreait.pjt;

import java.sql.*;

public class DbUtils {

    public static Connection getCon() throws ClassNotFoundException, SQLException {
        final String URL = "jdbc:mysql://localhost:3306/hustar2";
        final String USER_NAME = "root";
        final String PASSWORD = "koreait";
        Class.forName("com.mysql.cj.jdbc.Driver"); //사용하는 데이터베이스 전용 드라이버 이름
        Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        System.out.println("접속 성공");
        return con;
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(ps != null) {
            try {
                ps.close();
            } catch (Exception e) {}
        }

        if(con != null) {
            try {
                con.close();
            } catch (Exception e) {}
        }
    }
}
