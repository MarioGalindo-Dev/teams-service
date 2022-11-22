package com.soccer.teams.services;

import com.soccer.teams.entities.Team;
import com.soccer.teams.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Team service implement.
 */
@Service
public class TeamService {
     @Autowired
     private TeamRepository teamRepository;
    private Integer id;

    public List<Team> listAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Integer id) {
        return teamRepository.findById(id).get();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

}
