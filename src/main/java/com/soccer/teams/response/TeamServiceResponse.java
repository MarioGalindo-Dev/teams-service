package com.soccer.teams.response;

import com.soccer.teams.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamServiceResponse {
    private int id;
    private String Message;
    private String Status;
    private Team team;
    private List<Team> teams;
}
