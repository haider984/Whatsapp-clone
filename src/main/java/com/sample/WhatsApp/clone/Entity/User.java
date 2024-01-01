package com.sample.WhatsApp.clone.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password; // encrypted
    private String phone;
    @Lob
    @Column(length = 16777215) // For LONGBLOB
    private byte[] blobData; //profile picture

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(
//            name = "contact_id",
//            nullable = false,
//            foreignKey = @ForeignKey(name = "FK_CONTACT_ID_USER")
//    )
//    private List<Contact> contacts; // one-to-many mapping

    // One User has Many Contacts
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Contact> contacts = new ArrayList<>(); // one-to-many mapping

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Contact> contacts;

    public User(Long id, String name, String email, String password, String phone, byte[] blobData, List<Contact> contacts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.blobData = blobData;
        this.contacts = contacts;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getBlobData() {
        return blobData;
    }

    public void setBlobData(byte[] blobData) {
        this.blobData = blobData;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}

