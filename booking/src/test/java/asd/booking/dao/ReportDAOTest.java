package asd.booking.dao;

import java.util.List;

import asd.booking.dao.proxy.IReportProxy;
import asd.booking.dao.proxy.ReportDaoProxy;
import asd.booking.domain.Report;
import junit.framework.Assert;
import junit.framework.TestCase;

public class ReportDAOTest extends TestCase {

    public void testGetList() throws Exception {
        IReportProxy reportProxy = new ReportDaoProxy(null);
        List<Report> reportList = reportProxy.getList("2017-01-01", "2018-12-31");
        Assert.assertNotNull(reportList);
        System.out.println(reportList.size());
    }
}