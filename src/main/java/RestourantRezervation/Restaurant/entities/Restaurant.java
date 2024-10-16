package RestourantRezervation.Restaurant.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="restaurants")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","kitchens","reservations"})

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int restaurantId;

    @Column(name="restaurant_name")
    private String restaurantName;


    @Column(name = "number_of_person")
    private Integer numberOfPerson;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "restaurant")
    List<Reservation> reservations;

    // ManyToMany relationship with TypeOfKitchen
    @ManyToMany
    @JoinTable(
            name = "restaurant_kitchens", // Name of the join table
            joinColumns = @JoinColumn(name = "restaurant_id"), // Foreign key to Restaurant
            inverseJoinColumns = @JoinColumn(name = "kitchen_id") // Foreign key to TypeOfKitchen
    )
    private List<TypeOfKitchen> kitchens;

}
