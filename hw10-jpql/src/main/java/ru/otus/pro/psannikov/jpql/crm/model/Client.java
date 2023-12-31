package ru.otus.pro.psannikov.jpql.crm.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client implements Cloneable {

    @Id
    @SequenceGenerator(name = "client_gen", sequenceName = "client_seq",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "addres_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "client_id")
    private List<Phone> phones;

    public Client(String name, Address addres, List<Phone> phones) {
        this.name = name;
        this.address = addres;
        this.phones = phones;
    }

    public Client(Long id, String name, Address addres, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.address = addres;
        this.phones = phones;
    }

    @Override
    public Client clone() {
        return new Client(this.id, this.name, this.address, this.phones);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addres='" + address + '\'' +
                ", phones='" + phones + '\'' +
                '}';
    }
}
