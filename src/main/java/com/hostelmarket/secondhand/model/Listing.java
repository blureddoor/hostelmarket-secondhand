package com.hostelmarket.secondhand.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Listing {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String image;
    private Double price;
    @ManyToOne
    private User owner;

    // Más adelante: precio, estado, fecha, imágenes...
}
