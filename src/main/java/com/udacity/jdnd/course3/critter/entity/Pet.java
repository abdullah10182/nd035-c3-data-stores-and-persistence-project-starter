package com.udacity.jdnd.course3.critter.entity;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

import com.udacity.jdnd.course3.critter.pet.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "pet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue
    private long id;

    private PetType type;

    private String name;
    private LocalDate birthDate;
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Customer owner;

    @ManyToMany(mappedBy = "scheduledPets")
    private Set<Schedule> schedules;
}