package com.hostelmarket.secondhand.controller;

import com.hostelmarket.secondhand.model.Listing;
import com.hostelmarket.secondhand.model.User;
import com.hostelmarket.secondhand.service.ListingService;
import com.hostelmarket.secondhand.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ListingWebController {

    @Autowired
    private ListingService listingService;
    @Autowired
    private UserService userService;

    // Listado de anuncios
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("listings", listingService.findAll());
        return "listings";
    }

    // Formulario nuevo anuncio
    @GetMapping("/listing/new")
    public String newListingForm(Model model) {
        model.addAttribute("title", "");
        model.addAttribute("description", "");
        model.addAttribute("price", "");
        model.addAttribute("image", "");
        model.addAttribute("error", null);
        return "new-listing";
    }

    // Procesa creación del anuncio
    @PostMapping("/listing/new")
    public String createListing(@ModelAttribute Listing listing, Model model) {
        // Validaciones
        if (listing.getTitle() == null || listing.getTitle().isBlank()) {
            model.addAttribute("title", listing.getTitle());
            model.addAttribute("description", listing.getDescription());
            model.addAttribute("price", listing.getPrice() == null ? "" : listing.getPrice());
            model.addAttribute("image", listing.getImage());
            model.addAttribute("error", "El título es obligatorio");
            return "new-listing";
        }
        if (listing.getDescription() == null || listing.getDescription().length() < 10) {
            model.addAttribute("title", listing.getTitle());
            model.addAttribute("description", listing.getDescription());
            model.addAttribute("price", listing.getPrice() == null ? "" : listing.getPrice());
            model.addAttribute("image", listing.getImage());
            model.addAttribute("error", "La descripción debe tener al menos 10 caracteres.");
            return "new-listing";
        }
        if (listing.getPrice() == null || listing.getPrice() < 0) {
            model.addAttribute("title", listing.getTitle());
            model.addAttribute("description", listing.getDescription());
            model.addAttribute("price", "");
            model.addAttribute("image", listing.getImage());
            model.addAttribute("error", "El precio debe ser un valor positivo.");
            return "new-listing";
        }
        if (listing.getImage() == null || listing.getImage().isBlank()) {
            model.addAttribute("title", listing.getTitle());
            model.addAttribute("description", listing.getDescription());
            model.addAttribute("price", listing.getPrice());
            model.addAttribute("image", listing.getImage());
            model.addAttribute("error", "La imagen es obligatoria.");
            return "new-listing";
        }
        if (!listing.getImage().matches(".*\\.(jpg|jpeg|png)$")) {
            model.addAttribute("title", listing.getTitle());
            model.addAttribute("description", listing.getDescription());
            model.addAttribute("price", listing.getPrice());
            model.addAttribute("image", listing.getImage());
            model.addAttribute("error", "La imagen debe ser un archivo JPG, JPEG o PNG.");
            return "new-listing";
        }
        listing.setOwner(userService.getLoggedUser());
        User user = userService.findAll().get(0);
        listing.setOwner(user);

        listingService.save(listing);
        return "redirect:/";
    }

    // Borra un anuncio
    @GetMapping("/listing/delete/{id}")
    public String deleteListing(@PathVariable Long id) {
        listingService.deleteById(id);
        return "redirect:/";
    }
}

