package RestourantRezervation.Restaurant.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reservations"})


public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;


    @NotNull
    @NotBlank
    @Column(name = "sur_name")
    private String surName;


    @NotNull
    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;


    @NotNull
    @NotBlank
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

}
