package asd.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import asd.booking.dao.proxy.IReportProxy;
import asd.booking.domain.Report;

public interface ReportDAO{

    
    public List<Report> getList(String startDate, String endDate);
}
