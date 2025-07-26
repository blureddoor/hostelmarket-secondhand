package com.hostelmarket.secondhand.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url; // O nombre de archivo

    @ManyToOne
    private Listing listing;
}
