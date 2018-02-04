package asd.booking.dao;

import asd.booking.domain.Report;
import asd.booking.iteration.ArrayIteration;
import junit.framework.Assert;
import junit.framework.TestCase;

public class ReportDAOTest extends TestCase {

    public void testGetList() throws Exception {
        //IReportProxy reportProxy = new ReportDaoProxy("");
        ReportDAO reportDAO = new ReportDAO();
        ArrayIteration<Report> reportList = reportDAO.getList("2017-01-01", "2018-12-31");
        Assert.assertNotNull(reportList);
        System.out.println(reportList.size());
    }
}