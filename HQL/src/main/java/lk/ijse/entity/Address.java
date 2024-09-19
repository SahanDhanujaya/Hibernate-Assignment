package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Address {
    @Id
    private int aId;
    private String no;
    private String street;
    private String city;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
