package jp.co.scsk.kyushu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Jdbc_07 {

	public static Map<String, Shop> getShopData() throws SQLException {
        String conUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=java_learning;"
                + "user=java_learning;"
                + "password=java_learning;"
                + "encrypt=true;"
                + "trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(conUrl);

        String sql = "select * from nmrm_shop";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        Map<String, Shop> shopMap = new HashMap<>();
        while (rs.next()) {
            Shop shop = new Shop(
                rs.getString("shop_id"),
                rs.getString("shop_name"),
                rs.getDate("ins_date"),
                rs.getString("ins_user_id"),
                rs.getInt("upd_counter"),
                rs.getDate("upd_date"),
                rs.getString("upd_user_id")
            );
            shopMap.put(rs.getString("shop_id"), shop);
        }

        rs.close();
        stmt.close();
        con.close();

        return shopMap;
    }
}