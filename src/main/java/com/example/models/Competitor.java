package com.example.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Competitor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "create_at", updatable = false)
    private Calendar createdAt;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Calendar updatedAt;

    private String name;
    private String surname;
    private int age;
    private String telephone;
    private String cellphone;
    private String address;
    private String city;
    private String country;
    private boolean winner;

    @Column(nullable = false)
    private String password;

    // Relación OneToMany con Producto (corregido)
    @OneToMany(mappedBy = "competitor", cascade = CascadeType.ALL)
    private List<Producto> productos;

    public Competitor() {
        this.productos = new ArrayList<Producto>();
    }

    public Competitor(String nameN, String surnameN, int ageN, String telephoneN, String cellphoneN,
                      String addressN, String cityN, String countryN, boolean winnerN, String passwordN) {
        this.name = nameN;
        this.surname = surnameN;
        this.age = ageN;
        this.telephone = telephoneN;
        this.cellphone = cellphoneN;
        this.address = addressN;
        this.city = cityN;
        this.country = countryN;
        this.winner = winnerN;
        this.password = passwordN;
        this.productos = new ArrayList<Producto>();
    }

    @PrePersist
    private void creationTimestamp() {
        this.createdAt = this.updatedAt = Calendar.getInstance();
    }

    @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }

    // Getters y Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getTelephone() { return telephone; }

    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getCellphone() { return cellphone; }

    public void setCellphone(String cellphone) { this.cellphone = cellphone; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public boolean isWinner() { return winner; }

    public void setWinner(boolean winner) { this.winner = winner; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<Producto> getProductos() { return productos; }

    public void setProductos(List<Producto> productos) { this.productos = productos; }
}
