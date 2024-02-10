package com.ResfulWithSpring.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("goto")
public class GotoStep extends Step{
    private String gotoStepId;
}
