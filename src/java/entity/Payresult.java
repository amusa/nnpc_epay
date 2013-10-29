/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ayemi
 */
@Entity
@Table(name = "payresult")
@NamedQueries({
    @NamedQuery(name = "Payresult.findAll", query = "SELECT p FROM Payresult p"),
    @NamedQuery(name = "Payresult.findByPayPeriod", query = "SELECT p FROM Payresult p WHERE p.payresultPK.payPeriod = :payPeriod"),
    @NamedQuery(name = "Payresult.findByWageType", query = "SELECT p FROM Payresult p WHERE p.payresultPK.wageType = :wageType"),
    @NamedQuery(name = "Payresult.findByEmployeeId", query = "SELECT p FROM Payresult p WHERE p.payresultPK.employeeId = :employeeId"),
    @NamedQuery(name = "Payresult.findByDescription", query = "SELECT p FROM Payresult p WHERE p.description = :description"),
    @NamedQuery(name = "Payresult.findByWageClass", query = "SELECT p FROM Payresult p WHERE p.wageClass = :wageClass"),
    @NamedQuery(name = "Payresult.findByAmount", query = "SELECT p FROM Payresult p WHERE p.amount = :amount")})
public class Payresult implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PayresultPK payresultPK;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "wage_class")
    private String wageClass;
    @Basic(optional = false)
    @Column(name = "amount")
    private BigDecimal amount;

    public Payresult() {
    }

    public Payresult(PayresultPK payresultPK) {
        this.payresultPK = payresultPK;
    }

    public Payresult(PayresultPK payresultPK, String description, String wageClass, BigDecimal amount) {
        this.payresultPK = payresultPK;
        this.description = description;
        this.wageClass = wageClass;
        this.amount = amount;
    }

    public Payresult(String payPeriod, String wageType, String employeeId) {
        this.payresultPK = new PayresultPK(payPeriod, wageType, employeeId);
    }

    public PayresultPK getPayresultPK() {
        return payresultPK;
    }

    public void setPayresultPK(PayresultPK payresultPK) {
        this.payresultPK = payresultPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWageClass() {
        return wageClass;
    }

    public void setWageClass(String wageClass) {
        this.wageClass = wageClass;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payresultPK != null ? payresultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payresult)) {
            return false;
        }
        Payresult other = (Payresult) object;
        if ((this.payresultPK == null && other.payresultPK != null) || (this.payresultPK != null && !this.payresultPK.equals(other.payresultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payresult[payresultPK=" + payresultPK + "]";
    }

}
