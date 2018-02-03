/*
 * Created on Feb 3, 2018
 */
package asd.booking.dao.proxy;

import java.util.List;

import asd.booking.domain.Report;

public interface IReportProxy {

    public List<Report> getList(String startDate, String enddate);
}
