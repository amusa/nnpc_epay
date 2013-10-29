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
public class OneOffPaymentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "year")
    private long year;
    @Basic(optional = false)
    @Column(name = "wage_type")
    private String wageType;
    @Basic(optional = false)
    @Column(name = "employee_id")
    private String employeeId;

    public OneOffPaymentPK() {
    }

    public OneOffPaymentPK(long year, String wageType, String employeeId) {
        this.year = year;
        this.wageType = wageType;
        this.employeeId = employeeId;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
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
        hash += (int) year;
        hash += (wageType != null ? wageType.hashCode() : 0);
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OneOffPaymentPK)) {
            return false;
        }
        OneOffPaymentPK other = (OneOffPaymentPK) object;
        if (this.year != other.year) {
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
        return "entity.OneOffPaymentPK[year=" + year + ", wageType=" + wageType + ", employeeId=" + employeeId + "]";
    }

}
