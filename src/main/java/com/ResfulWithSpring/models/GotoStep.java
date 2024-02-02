package com.ResfulWithSpring.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("goto")
public class GotoStep extends Step{
    private String gotoStepId;
}
