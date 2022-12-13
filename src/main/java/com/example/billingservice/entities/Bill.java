package com.example.billingservice.entities;

import com.example.billingservice.model.Customer;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    private long customerID;
    @Transient
    private Customer customer;

    public double getTotal(){
        double somme=0;
        for(ProductItem pi: productItems){
            somme+=pi.getAmount();
        }
        return somme;
    }

}
