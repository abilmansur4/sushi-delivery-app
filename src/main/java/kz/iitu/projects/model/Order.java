package kz.iitu.projects.model;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable{

    @Column(name = "customer_name")
    @NotEmpty
    private String customerName;

    @Column(name = "phone_number")
    @NotEmpty
    private String phoneNumber;

    @Column(name = "email")
    @NotEmpty
    private String email;

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "status")
    @NotEmpty
    private String status;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("new", this.isNew())
                .append("name", this.getCustomerName())
                .append("phone_number", this.getPhoneNumber())
                .append("email", this.getEmail())
                .append("address", this.getAddress())
                .append("status", this.getStatus())
                .toString();
    }
}

