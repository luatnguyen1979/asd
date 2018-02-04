package asd.booking.builder;

import asd.booking.dao.PortDAO;
import asd.booking.dao.UserDAO;
import asd.booking.dao.factory.DAOFactory;
import asd.booking.domain.Report;
import asd.booking.domain.trip.Route;
import asd.booking.utils.DateTimeUtils;

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
		
        report.setSourceName(portDAO.get(route.getSourceId()).getName());
        report.setDestName(portDAO.get(route.getDestinationId()).getName());
    }
}
