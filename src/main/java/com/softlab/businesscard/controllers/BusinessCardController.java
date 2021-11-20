package com.softlab.businesscard.controllers;

import com.softlab.businesscard.expections.BusinessCardNotFoundExpection;
import com.softlab.businesscard.models.BusinessCard;
import com.softlab.businesscard.repository.BusinessCardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/businessCard")
public class BusinessCardController {
    private final BusinessCardRepository repository;

    BusinessCardController(BusinessCardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<BusinessCard> all(HttpSession session) {
        List<String> msgs = (List<String>) session.getAttribute("MY_MESSAGES");
        if(msgs == null) {
            msgs = new ArrayList<>();
        }

        return repository.findAll();
    }

    @GetMapping("{id}")
    BusinessCard one(@PathVariable Long id, HttpServletRequest request) {
        List<String> msgs = (List<String>) request.getSession().getAttribute("MY_MESSAGES");
        if(msgs == null) {
            msgs = new ArrayList<>();
            request.getSession().setAttribute("MY_MESSAGES", msgs);
        }
        return repository.findById(id)
                .orElseThrow(() -> new BusinessCardNotFoundExpection(id));
    }
}
