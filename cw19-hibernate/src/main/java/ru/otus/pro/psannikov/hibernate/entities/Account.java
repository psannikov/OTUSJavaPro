package ru.otus.pro.psannikov.hibernate.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import ru.otus.pro.psannikov.hibernate.enums.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false, unique = true, columnDefinition = "date default now()")
    private LocalDate created;

    @Column(nullable = false, columnDefinition = "double precision default 0")
    private BigDecimal balance;

    @Column(nullable = false, columnDefinition = "varchar default 'USD'")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean closed;

    @ManyToOne
    @JoinColumn(name = "bank")
    private Bank bank;

}