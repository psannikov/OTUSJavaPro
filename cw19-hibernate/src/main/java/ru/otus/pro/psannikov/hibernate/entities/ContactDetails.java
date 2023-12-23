package ru.otus.pro.psannikov.hibernate.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactDetails {

    private String phone;

    private String address;

    private String siteUrl;

}