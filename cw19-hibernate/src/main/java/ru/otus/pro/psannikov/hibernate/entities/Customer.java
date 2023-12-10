package ru.otus.pro.psannikov.hibernate.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.otus.pro.psannikov.hibernate.enums.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", unique = true, nullable = false)
    private Email email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="bank_customer", joinColumns=@JoinColumn(name="customer"), inverseJoinColumns=@JoinColumn(name="bank"))
    private Set<Bank> banks;

    @ElementCollection
    @Column(name = "amount")
    @MapKeyColumn(name = "currency")
    @CollectionTable(name = "statement", joinColumns = { @JoinColumn(name = "customer") })
    private Map<Currency, BigDecimal> statement = new HashMap<>();

}