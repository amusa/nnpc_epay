/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejb.EpayBean;
import entity.*;
import exception.NoAppraisalException;
import exception.NoPayresultException;
import exception.NoSuchEmployeeException;
import exception.NoUpfrontException;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.logging.*;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.PieChartModel;
import utility.*;

/**
 *
 * @author Ayemi
 */
@ManagedBean
@SessionScoped
public class PayManager implements Serializable {

    @EJB
    private EpayBean epayBean;
    private Employee employee;
    private StreamedContent ageChart, serviceChart, appraisalChart, barcode;
    private AppraisalRt appraisal;
    private List<Payresult> payresultList, deductionList, earningList, loanBalanceList, ytdStatList;
    private List<OneOffPayment> oneOffPmtList;
    private PieChartModel model;
    private double netPay;
    private String userId;
    private String payperiod;
    private boolean display = false;

    /** Creates a new instance of PayManager */
    public PayManager() {
        deductionList = new ArrayList<Payresult>();
        earningList = new ArrayList<Payresult>();
        loanBalanceList = new ArrayList<Payresult>();
        ytdStatList = new ArrayList<Payresult>();
        model = new PieChartModel();

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayperiod() {
        return payperiod;
    }

    public void setPayperiod(String payperiod) {
        this.payperiod = payperiod;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public String display() {
        try {
            employee = epayBean.findEmployee(userId);

        } catch (NoSuchEmployeeException ex) {
            employee = null;
            Logger.getLogger(PayManager.class.getName()).log(Level.SEVERE, null, ex);
            setDisplay(false);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "No Employee", "No Employee exists with Staff ID: " + userId));
        }


        try {
            appraisal = epayBean.findAppraisal(userId);
        } catch (NoAppraisalException nre) {
            appraisal = null;
            setDisplay(true);
        }
        earningList.clear();
        deductionList.clear();
        ytdStatList.clear();
        loanBalanceList.clear();
        try {
            payresultList = epayBean.findPayResult(userId, payperiod);

            for (Payresult py : payresultList) {
                if (py.getWageClass().equals("01")) {
                    earningList.add(py);
                } else if (py.getWageClass().equals("02")) {
                    deductionList.add(py);
                } else if (py.getWageClass().equals("03")) {
                    ytdStatList.add(py);
                } else if (py.getWageClass().equals("04")) {
                    loanBalanceList.add(py);
                }
            }

        } catch (NoPayresultException nre) {

            setDisplay(true);
        }
        try {
            oneOffPmtList = epayBean.findOneOffPmt(userId);

            for (OneOffPayment offPmt : oneOffPmtList) {
                model.set(offPmt.getDescription(), offPmt.getAmount());
                netPay += offPmt.getAmount().doubleValue();
            }
            setDisplay(true);

        } catch (NoUpfrontException nre) {
            netPay = 0.0;
            model = new PieChartModel();
            oneOffPmtList = null;
            setDisplay(true);

        }
        return null;
    }

    public StreamedContent getAgeChart() {
        int age = employee == null ? 0 : employee.getAge();
        ageChart = new GaugeFactory(50, 55, 60, age, "Age Gauge").getChart();
        return ageChart;
    }

    public StreamedContent getServiceChart() {
        int years = employee == null ? 0 : employee.getYearsOfService();
        serviceChart = new GaugeFactory(25, 30, 35, years, "Service Gauge").getChart();
        return serviceChart;
    }

    public StreamedContent getAppraisalChart() {
        String incr = appraisal == null ? "0" : appraisal.getIncrement().toString();
        appraisalChart = new CombinationGauge(incr).getChart();
        return appraisalChart;
    }

    public StreamedContent getBarcode() {
        if (employee != null) {
            try {
                File barcodeFile = new File(employee.getId());
                NumberFormat formatter = new DecimalFormat("0000000000");
                String code = formatter.format(Long.parseLong(employee.getId()));
                BarcodeImageHandler.saveJPEG(BarcodeFactory.createCode128(code), barcodeFile);

                barcode = new DefaultStreamedContent(new FileInputStream(barcodeFile), "image/jpeg");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return barcode;
    }

    public void setBarcode(StreamedContent barcode) {
        this.barcode = barcode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AppraisalRt getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(AppraisalRt appraisal) {
        this.appraisal = appraisal;
    }

    public long getAgePerc() {
        int age = employee == null ? 0 : employee.getAge();
        return Math.round(age / 60.0 * 100.0);
    }

    public long getServPerc() {
        int years = employee == null ? 0 : employee.getYearsOfService();
        return Math.round(years / 35.0 * 100.0);
    }

    public List<Payresult> getPayresultList() {
        return payresultList;
    }

    public List<Payresult> getDeductionList() {
        return deductionList;
    }

    public List<Payresult> getEarningList() {
        return earningList;
    }

    public List<Payresult> getLoanBalanceList() {
        return loanBalanceList;
    }

    public List<Payresult> getYtdStatList() {
        return ytdStatList;
    }

    public double getTotalEarnings() {
        double totalEarnings = 0.0;
        try {
            for (Payresult pr : earningList) {
                totalEarnings += pr.getAmount().doubleValue();
            }
        } catch (NullPointerException npe) {
        }
        return totalEarnings;
    }

    public double getTotalDeductions() {
        double totalDeductions = 0.0;
        try {
            for (Payresult pr : deductionList) {
                totalDeductions += pr.getAmount().doubleValue();
            }
        } catch (NullPointerException npe) {
        }
        return totalDeductions;
    }

    public List<OneOffPayment> getOneOffPmtList() {
        return oneOffPmtList;
    }

    public PieChartModel getModel() {
        return model;
    }

    public double getNetPay() {
        return netPay;
    }
}
