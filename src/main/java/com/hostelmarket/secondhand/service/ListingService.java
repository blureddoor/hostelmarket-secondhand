package com.hostelmarket.secondhand.service;

import com.hostelmarket.secondhand.model.Listing;
import com.hostelmarket.secondhand.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ListingService {

    private final Map<Long, Listing> listings = new HashMap<>();
    private long nextId = 1;
    @Autowired
    public ListingService(UserService userService) {
        User user = userService.findAll().isEmpty()
            ? userService.save(new User(null, "Leo", "leo@email.com"))
            : userService.findAll().get(0);
        // Datos de ejemplo
        save(new Listing(null, "Horno industrial", "Horno para panadería, muy poco uso", "horno.jpg", 500.0, user));
        save(new Listing(null, "Lavavajillas", "Lavavajillas profesional usado", "lavavajillas.jpg", 500.0, user));
    }

    public List<Listing> findAll() {
        return new ArrayList<>(listings.values());
    }

    public Listing findById(Long id) {
        return listings.get(id);
    }

    public Listing save(Listing listing) {
        if (listing.getId() == null) {
            listing.setId(nextId++);
        }
        listings.put(listing.getId(), listing);
        return listing;
    }

    public void deleteById(Long id) {
        listings.remove(id);
    }
}
