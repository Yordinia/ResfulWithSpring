package com.restwithspring.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("end")
public class EndStep extends Step{
    private String message;
}
