package com.ResfulWithSpring.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("echo")
@Setter
@Getter
public class EchoStep extends Step{
    private String message;
}
