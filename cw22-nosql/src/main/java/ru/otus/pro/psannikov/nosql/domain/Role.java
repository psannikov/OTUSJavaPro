package ru.otus.pro.psannikov.nosql.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

import java.util.Collection;

@Getter
@Setter
@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type = "ACTED_IN")
public class Role {

    @Id
    @GeneratedValue
    Long id;
    private Collection<String> roles;
    @StartNode
    private Person person;
    @EndNode
    private Movie movie;

}
