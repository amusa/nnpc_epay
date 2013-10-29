/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ayemi
 */
@Embeddable
public class PayresultPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pay_period")
    private String payPeriod;
    @Basic(optional = false)
    @Column(name = "wage_type")
    private String wageType;
    @Basic(optional = false)
    @Column(name = "employee_id")
    private String employeeId;

    public PayresultPK() {
    }

    public PayresultPK(String payPeriod, String wageType, String employeeId) {
        this.payPeriod = payPeriod;
        this.wageType = wageType;
        this.employeeId = employeeId;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getWageType() {
        return wageType;
    }

    public void setWageType(String wageType) {
        this.wageType = wageType;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payPeriod != null ? payPeriod.hashCode() : 0);
        hash += (wageType != null ? wageType.hashCode() : 0);
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PayresultPK)) {
            return false;
        }
        PayresultPK other = (PayresultPK) object;
        if ((this.payPeriod == null && other.payPeriod != null) || (this.payPeriod != null && !this.payPeriod.equals(other.payPeriod))) {
            return false;
        }
        if ((this.wageType == null && other.wageType != null) || (this.wageType != null && !this.wageType.equals(other.wageType))) {
            return false;
        }
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PayresultPK[payPeriod=" + payPeriod + ", wageType=" + wageType + ", employeeId=" + employeeId + "]";
    }

}
