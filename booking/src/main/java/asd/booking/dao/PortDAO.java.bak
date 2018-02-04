package asd.booking.dao;

import asd.booking.domain.Address;
import asd.booking.domain.trip.Port;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PortDAO {
    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    public static List<Port> getPortList() {
        List<Port> portList = new ArrayList<>();

        final String searchQuery = "SELECT * FROM port";
        // process

        System.out.println("Query: " + searchQuery);

        try {
            // connect to DB
            currentCon = ConnectionManager.getConnection();
            ps = currentCon.prepareStatement(searchQuery);
            rs = ps.executeQuery(searchQuery.toString());
            while (rs.next()) {
                int addressId = rs.getInt("address_id");
                Address address = AddressDAO.get(addressId);
                Port port = new Port(rs.getInt("id"), rs.getString("name"), address);
                portList.add(port);
            }

            System.out.println("Port list size: " + portList.size());

        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        // some exception handling
        finally {
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

        return portList;
    }

    public static Port get(int id) {
        Port ret = null;
        final String sql = "SELECT * FROM port WHERE id = ?";
        try {
            currentCon = ConnectionManager.getConnection();
            ps = currentCon.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Address address = AddressDAO.get(rs.getInt("address_id"));
                ret = new Port(rs.getInt("id"), rs.getString("name"), address);
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
