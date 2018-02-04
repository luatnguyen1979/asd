/*
 * Created on Feb 3, 2018
 */
package asd.booking.dao.proxy;

import asd.booking.domain.Report;
import asd.booking.iteration.ArrayIteration;

public interface IReportProxy {

    public ArrayIteration<Report> getList(String startDate, String enddate);
}
