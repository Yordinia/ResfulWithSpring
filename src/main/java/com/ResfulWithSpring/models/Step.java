package com.ResfulWithSpring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Setter @Getter
@DiscriminatorColumn(name = "step_type")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String description;
    @ManyToOne(optional = false)
    private Flow flow;
}
