package com.soccer.teams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("version")
    private Integer version;

    @JsonProperty("teamID")
    private Integer teamID;

    @JsonProperty("number")
    private String number;

    @JsonProperty("name")
    private String name;

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("age")
    private String age;

    @JsonProperty("scoredGoalsInTournament")
    private int scoredGoalsInTournament;

    @JsonProperty("joinDate")
    private Date joinDate;

    @JsonProperty("leftDate")
    private Date leftDate;
}