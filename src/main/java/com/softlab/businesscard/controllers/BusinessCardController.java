package com.softlab.businesscard.controllers;

import com.softlab.businesscard.expections.BusinessCardNotFoundExpection;
import com.softlab.businesscard.models.BusinessCard;
import com.softlab.businesscard.repository.BusinessCardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessCardController {
    private final BusinessCardRepository repository;

    BusinessCardController(BusinessCardRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/businessCard")
    List<BusinessCard> all() {
        return repository.findAll();
    }

    @GetMapping("/businessCard/{id}")
    BusinessCard one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new BusinessCardNotFoundExpection(id));
    }
}
