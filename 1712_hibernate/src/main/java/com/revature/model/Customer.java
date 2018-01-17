package com.revature.model;

import javax.persistence.*;

@Entity
@Table (name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="seqname")
    @SequenceGenerator(name="seqname", sequenceName="cust_seq_id", allocationSize=1)
    @Column(name="CUST_ID", nullable=false)
    private int custId;
    
    @Column(name="CUST_NAME", nullable=true, length=20)
    private String custName;
    
    @Column(name="CUST_PHONE", nullable=true, length=20)
    private String custPhone;
    
    @Column(name="CUST_ADDRESS", nullable=true, length=50)
    private String custAddress;
    
    public Customer(int custId, String custName, String custPhone, String custAddress) {
        super();
        this.custId = custId;
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
    }
    
    public Customer() {
        super();
    }
    
    public Customer(String custName, String custPhone, String custAddress) {
        super();
        this.custName = custName;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
    }
    public int getCustId() {
        return custId;
    }
    public void setCustId(int custId) {
        this.custId = custId;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getCustPhone() {
        return custPhone;
    }
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
    public String getCustAddress() {
        return custAddress;
    }
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((custAddress == null) ? 0 : custAddress.hashCode());
        result = prime * result + custId;
        result = prime * result + ((custName == null) ? 0 : custName.hashCode());
        result = prime * result + ((custPhone == null) ? 0 : custPhone.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (custAddress == null) {
            if (other.custAddress != null)
                return false;
        } else if (!custAddress.equals(other.custAddress))
            return false;
        if (custId != other.custId)
            return false;
        if (custName == null) {
            if (other.custName != null)
                return false;
        } else if (!custName.equals(other.custName))
            return false;
        if (custPhone == null) {
            if (other.custPhone != null)
                return false;
        } else if (!custPhone.equals(other.custPhone))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Customer [custId=" + custId + ", custName=" + custName + ", custPhone=" + custPhone + ", custAddress="
                + custAddress + "]";
    }
    
    
    
}
