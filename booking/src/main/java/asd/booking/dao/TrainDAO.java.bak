/**
 * created Jan/30/2018
 */
package asd.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import asd.booking.domain.Train;

public class TrainDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    public static Train get(int id) {
        Train ret = null;
        final String sql = "SELECT * FROM train WHERE trainid = ?";
        try {
            currentCon = ConnectionManager.getConnection();
            ps = currentCon.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int trainid = rs.getInt("trainid");
                String trainName = rs.getString("name");
                String model = rs.getString("model");
                String type = rs.getString("type");
                String madeBy = rs.getString("madeby");
                int capacity = rs.getInt("capacity");
                ret = new Train(trainName,type,model,madeBy,true,capacity);
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
