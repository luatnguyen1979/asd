/*
 * Created on Feb 3, 2018
 */
package asd.booking.dao.proxy;

import asd.booking.domain.Report;

import java.util.List;

public interface IReportProxy {

    public List<Report> getList(String startDate, String enddate);
}
