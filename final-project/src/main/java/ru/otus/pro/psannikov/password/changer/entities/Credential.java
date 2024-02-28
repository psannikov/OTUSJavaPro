package ru.otus.pro.psannikov.password.changer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credentials")
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "description")
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "information_system_id", unique = true, nullable = false)
    private InformationSystem informationSystem;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "responsible_person_id", unique = true, nullable = false)
    private ResponsiblePerson responsiblePerson;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_status_id", unique = true, nullable = false)
    private TaskStatus taskStatus;
}
