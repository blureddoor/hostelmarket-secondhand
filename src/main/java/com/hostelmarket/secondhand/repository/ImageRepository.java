package com.hostelmarket.secondhand.repository;

import com.hostelmarket.secondhand.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
