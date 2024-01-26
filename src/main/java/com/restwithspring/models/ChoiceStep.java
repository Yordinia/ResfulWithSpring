package com.restwithspring.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("choice")
@Setter
@Getter
public class ChoiceStep extends Step{
    private String condition;
    private String trueStep;
    private String falseStep;
}
