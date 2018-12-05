package com.tamdongtam.java.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamdongtam.java.model.Contact;


public interface ContactService extends JpaRepository<Contact, Long> {

}
