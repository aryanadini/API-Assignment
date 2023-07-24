package com.springboot.app;

import javax.swing.text.PasswordView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String b) {
		this.password = b;
	}
	private String password; // Store hashed password here
    private String email;
    private String contactNumber;
    private String fullName;
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setPassword(boolean equals) {
		// TODO Auto-generated method stub
		
	}

    // Constructors, getters, and setters
}


    

