package asd.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import asd.booking.domain.Train;
import asd.booking.domain.trip.Port;
import asd.booking.domain.trip.Route;
import asd.booking.utils.DateTimeAdapter;

public class RouteDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;

    public static Route getRoute(int sourcePortId, int destinationPortId, LocalDate departureDate) {
        String date = DateTimeAdapter.adaptToDate(departureDate);
        Route ret = null;
        final String sql = "SELECT * FROM route WHERE sourceport_id = ? " +
                "AND destinationport_id = ? " +
                "AND DATE(departuredate) = ? ";
        try {
            currentCon = ConnectionManager.getConnection();
            ps = currentCon.prepareStatement(sql);
            ps.setInt(1, sourcePortId);
            ps.setInt(2, destinationPortId);
            ps.setString(3, date);
            rs = ps.executeQuery();
            if (rs.next()) {
                Port sourcePort = PortDAO.get(rs.getInt("sourceport_id"));
                Port destinationPort = PortDAO.get(rs.getInt("destinationport_id"));
                ret = new Route(rs.getInt("id"),
                        sourcePort,
                        destinationPort,
                        rs.getDouble("duration"),
                        rs.getDouble("distance"),
                        rs.getDouble("pricesingleway"),
                        rs.getDouble("priceroundway"),
                        TrainDAO.get(rs.getInt("trainid")),
                        rs.getDate("departuredate").toLocalDate(),
                        rs.getDate("arrivaldate").toLocalDate());
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

    public static List<Route> getRoute(int sourcePortId, int destinationPortId, String departureDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        List<Route> routeList = new ArrayList<Route>();

        StringBuffer searchQuery = new StringBuffer();
        searchQuery.append("select * from route r");
        searchQuery.append(" left JOIN train t ON r.trainid = t.trainid");
        searchQuery.append(" where sourceport_id = ? AND destinationport_id = ?");
        searchQuery.append(" AND DATE(departuredate) = ?");
        System.out.println("Query: " + searchQuery.toString().replace("?", "" + sourcePortId));
        try {
            // connect to DB
            currentCon = ConnectionManager.getConnection();
            ps = currentCon.prepareStatement(searchQuery.toString());
            ps.setInt(1, sourcePortId);
            ps.setInt(2, destinationPortId);
            ps.setString(3, departureDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                int rId = rs.getInt("id");
                Port sourcePort = PortDAO.get(destinationPortId);
                Port desPort = PortDAO.get(destinationPortId);
                double duration​ = rs.getDouble("duration");
                double distance = rs.getDouble("distance");
                double priceOneWay = rs.getDouble("pricesingleway");
                double priceRoundWay = rs.getDouble("priceroundway");
                Train train = TrainDAO.get(rs.getInt("trainid"));
                LocalDate rdepartureDate = rs.getDate("departuredate").toLocalDate();
                LocalDate arrivalDate = rs.getDate("arrivaldate").toLocalDate();
                Route route = new Route(rId, sourcePort, desPort, duration​, distance, priceOneWay, priceRoundWay, train, rdepartureDate, arrivalDate);
                routeList.add(route);
            }

            System.out.println("Port list size: " + routeList.size());

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

        return routeList;

    }

    public static Route get(int id) {
        Route ret = null;
        final String sql = "SELECT * FROM route WHERE id = ?";
        try {
            currentCon = ConnectionManager.getConnection();
            ps = currentCon.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Port sourcePort = PortDAO.get(rs.getInt("sourceport_id"));
                Port destinationPort = PortDAO.get(rs.getInt("destinationport_id"));
                ret = new Route(rs.getInt("id"),
                        sourcePort,
                        destinationPort,
                        rs.getDouble("duration"),
                        rs.getDouble("distance"),
                        rs.getDouble("pricesingleway"),
                        rs.getDouble("priceroundway"),
                        TrainDAO.get(rs.getInt("trainid")),
                        rs.getDate("departuredate").toLocalDate(),
                        rs.getDate("arrivaldate").toLocalDate());
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
