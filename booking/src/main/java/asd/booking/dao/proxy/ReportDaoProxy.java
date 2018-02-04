/*
 * Created on Feb 3, 2018
 */
package asd.booking.dao.proxy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import asd.booking.dao.ReportDAO;
import asd.booking.dao.factory.DAOFactory;
import asd.booking.domain.Report;
import asd.booking.domain.User;

public class ReportDaoProxy implements IReportProxy {

    private ReportDAO reportDao;

    public ReportDaoProxy(HttpServletRequest request) throws Exception {
        if (request == null) {
            throw new Exception("you have no authorization to get the report!!!");
        }
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("currentSessionUser");
        if (user == null) {
            throw new Exception("you have no authorization to get the report!!!");
        } else {
            DAOFactory daoFactory = DAOFactory.getInstance("javabase.jdbc");
            reportDao = daoFactory.getReportDAO();
        }
    }

    @Override
    public List<Report> getList(String startDate, String enddate) {
        return reportDao.getList(startDate, enddate);
    }


}
