/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.AppraisalRt;
import entity.Employee;
import entity.OneOffPayment;
import entity.Payresult;
import exception.NoAppraisalException;
import exception.NoPayresultException;
import exception.NoSuchEmployeeException;
import exception.NoUpfrontException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ayemi
 */
@Stateless
public class EpayBean {

    @PersistenceContext(unitName = "PayrollPU")
    private EntityManager em;

    public Employee findEmployee(Object id) throws NoSuchEmployeeException {
        Employee emp = em.find(Employee.class, id);
        if (emp == null) {
            throw new NoSuchEmployeeException();
        }
        return emp;
    }

    public List<Payresult> findPayResult(Object empId, Object payperiod) throws NoPayresultException {
        List<Payresult> payresult = em.createQuery("select p from Payresult p where p.payresultPK.employeeId = :id "
                + " and p.payresultPK.payPeriod = :period").setParameter("id", empId).setParameter("period", payperiod).getResultList();

        if (payresult.isEmpty() || payresult == null) {
            throw new NoPayresultException();
        }
        return payresult;
    }

    public AppraisalRt findAppraisal(Object empId) throws NoAppraisalException {
        AppraisalRt appraisalRt;
        try {
            appraisalRt = (AppraisalRt) em.createQuery("select a from AppraisalRt a where a.appraisalRtPK.employeeId = :id "
                    + " and a.appraisalRtPK.year = "
                    + " (select max(b.appraisalRtPK.year) from AppraisalRt b where b.appraisalRtPK.employeeId = :id )").setParameter("id", empId).getSingleResult();

        } catch (NoResultException nre) {
            throw new NoAppraisalException();
        }
        return appraisalRt;
    }

    public List<OneOffPayment> findOneOffPmt(Object empId) throws NoUpfrontException {
        List<OneOffPayment> upfront = (List<OneOffPayment>) em.createQuery("select o from OneOffPayment o where o.oneOffPaymentPK.employeeId = :id "
                + " and o.oneOffPaymentPK.year = "
                + " (select max(p.oneOffPaymentPK.year) from OneOffPayment p "
                + "where p.oneOffPaymentPK.employeeId = :id) ").setParameter("id", empId).getResultList();
        if (upfront == null || upfront.isEmpty()) {
            throw new NoUpfrontException();
        }
        return upfront;
    }
}
