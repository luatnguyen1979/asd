package asd.framework.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PromotionDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    public static double getPercent(String code) {
        double ret = 0.00;
        final String sql = "SELECT percent FROM promotion " +
                "WHERE promotioncode = ? " +
                "AND startdate <= now() " +
                "AND enddate > now()";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            currentCon = ConnectionManager.getConnection();
            ps = currentCon.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                ret = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                }
                ps = null;
            }
            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }
        return ret;
    }
}
