package asd.booking.builder;

import asd.booking.domain.Report;
import asd.booking.domain.trip.Route;
import asd.booking.domain.trip.Trip;

import java.util.LinkedList;
import java.util.List;

public class ReportDirector {

    private List<ReportBuilder> builderList;

    public ReportDirector(Report report, Trip trip, Route route) {
        builderList = new LinkedList<>();
        builderList.add(new TripReportBuilder(report, trip));
        builderList.add(new RouteReportBuilder(report, route));
    }

    public void constructReport() {
        for (ReportBuilder reportBuilder : builderList) {
            reportBuilder.build();
        }
    }
}
