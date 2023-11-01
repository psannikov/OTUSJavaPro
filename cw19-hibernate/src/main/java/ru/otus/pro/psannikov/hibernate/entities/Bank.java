package ru.otus.pro.psannikov.hibernate.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city", nullable = false)
    private City city;

    @OneToMany(mappedBy="bank")
    private Set<Account> accounts;

    @JoinTable(name="bank_customer", joinColumns=@JoinColumn(name="bank"), inverseJoinColumns=@JoinColumn(name="customer"))
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Customer> customers;



}