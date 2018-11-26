package kz.iitu.projects.model;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product extends BaseEntity implements Serializable{

    @Column(name = "product_name")
    @NotEmpty
    private String productName;

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "product_category")
    @NotEmpty
    private String productCategory;

    @Column(name = "product_weight")
    @NotEmpty
    private String productWeight;

    @Column(name = "product_amount")
    private Integer productAmount;

    @Column(name = "product_description")
    @NotEmpty
    private String productDescription;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("new", this.isNew())
                .append("name", this.getProductName())
                .append("price", this.getProductPrice())
                .append("category", this.getProductCategory())
                .append("weight", this.getProductWeight())
                .append("amount", this.getProductAmount())
                .append("description", this.getProductDescription())
                .toString();
    }
}

