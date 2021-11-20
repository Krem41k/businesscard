package com.softlab.businesscard.expections;

public class BusinessCardNotFoundExpection extends RuntimeException{
    public BusinessCardNotFoundExpection(Long id) {
        super("Could not find employee " + id);
    }
}
