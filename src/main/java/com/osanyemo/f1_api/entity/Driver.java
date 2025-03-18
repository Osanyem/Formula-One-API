package com.osanyemo.f1_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String nationality;

    private LocalDate dob;

    private Integer number;

//  TV display code e.g., HAM for Lewis Hamilton, ALB for Alex Albon
    private String code;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team currentTeam;
}
