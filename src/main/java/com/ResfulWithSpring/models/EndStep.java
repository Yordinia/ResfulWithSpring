package com.ResfulWithSpring.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("end")
@Setter
@Getter
public class EndStep extends Step{
    private String message;
}
