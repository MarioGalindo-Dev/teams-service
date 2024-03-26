package com.soccer.teams.externalentities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private Integer id;
    private Integer version;
    private Integer teamID;
    private String number;
    private String name;
    private Date dateOfBirth;
    private String age;
    private int scoredGoalsInTournament;
    private Date joinDate;
    private Date leftDate;
}
