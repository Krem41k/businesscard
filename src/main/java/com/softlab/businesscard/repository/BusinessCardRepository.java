package com.softlab.businesscard.repository;

import com.softlab.businesscard.models.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BusinessCardRepository extends JpaRepository<BusinessCard, Long> {

}
