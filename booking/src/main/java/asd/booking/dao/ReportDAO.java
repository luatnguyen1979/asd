package asd.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import asd.booking.dao.proxy.IReportProxy;
import asd.booking.domain.Report;
import asd.booking.iteration.ArrayIteration;

public class ReportDAO implements IReportProxy {

    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    @Override
    public ArrayIteration<Report> getList(String startDate, String enddate) {
        ArrayIteration<Report> ret = new ArrayIteration<>(Report.class);
        final String sql = "SELECT * FROM report WHERE date >= ? and date < ?";
        try {
            currentCon = ConnectionManager.getConnection();
            ps = currentCon.prepareStatement(sql);
            ps.setString(1, startDate);
            ps.setString(2, enddate);
            rs = ps.executeQuery();
            while (rs.next()) {
                Report report = new Report(
                        rs.getString("date"),
                        rs.getString("trainname"),
                        rs.getInt("passenger"),
                        rs.getString("sourceport"),
                        rs.getString("destport"),
                        rs.getDouble("totalprice"));
                ret.add(report);
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
