package asd.booking.builder;

import asd.framework.booking.domain.Report;
import asd.framework.booking.domain.trip.Trip;

public class TripReportBuilder implements ReportBuilder<Trip> {

    private Report report;
    private Trip trip;

    public TripReportBuilder(Report report, Trip trip) {
        this.report = report;
        this.trip = trip;
    }

    @Override
    public void build() {
        report.setPassenger(trip.getPassengerList().size());
        report.setTotalPrice(trip.getTotalPrice());
    }
}
