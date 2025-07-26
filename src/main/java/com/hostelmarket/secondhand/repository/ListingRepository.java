package com.hostelmarket.secondhand.repository;

import com.hostelmarket.secondhand.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}
