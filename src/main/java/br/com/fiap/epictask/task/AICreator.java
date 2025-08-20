package br.com.fiap.epictask.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AICreator {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{AICreator.name.notblank}")
    @Size(min = 3, max = 40, message = "{AICreator.name.size}")
    private String name;

    @NotBlank(message = "{AICreator.spacies.notblank}")
    private String species;

    @Min(value = 1, message = "{AICreator.startingLevel.min}")
    @Max(value = 100, message = "{AICreator.startingLevel.max}")
    private int startingLevel;

    @NotBlank(message = "{AICreator.specialAbility.notblank}")
    @Size(min = 3, max = 60, message = "{AICreator.specialAbility.size}")
    private String specialAbility;


    @Size(min = 3, max = 280, message = "{AICreator.bio.size}")
    private String bio;

    @PastOrPresent
    private DateFormat creationDate;


}
