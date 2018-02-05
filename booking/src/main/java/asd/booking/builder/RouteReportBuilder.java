package asd.booking.builder;

import asd.booking.utils.DateTimeUtils;
import asd.framework.booking.dao.PortDAO;
import asd.framework.booking.dao.UserDAO;
import asd.framework.booking.dao.factory.DAOFactory;
import asd.framework.booking.domain.Report;
import asd.framework.booking.domain.trip.Route;

public class RouteReportBuilder implements ReportBuilder<Route> {

    private Report report;
    private Route route;

    public RouteReportBuilder(Report report, Route route) {
        this.report = report;
        this.route = route;
    }

    @Override
    public void build() {
        report.setDate(DateTimeUtils.adaptToDateTime(route.getDepartureDate()));
        report.setTrainName(route.getTrain().getName());
        DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
        PortDAO portDAO = daoFactory.getPortDAO();

        report.setSourceName(portDAO.get(route.getSource().getId()).getName());
        report.setDestName(portDAO.get(route.getDestination().getId()).getName());
    }
}
