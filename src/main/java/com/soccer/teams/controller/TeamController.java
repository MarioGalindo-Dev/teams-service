package com.soccer.teams.controller;

import com.soccer.teams.entities.Team;
import com.soccer.teams.externalentities.Player;
import com.soccer.teams.response.TeamServiceResponse;
import com.soccer.teams.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@Slf4j
public class TeamController {
    @Autowired
    private TeamService teamService;
    private TeamServiceResponse teamServiceResponse;
    @PostMapping("/")
    public TeamServiceResponse saveTeam(@RequestBody Team team)
    {
        log.info("saving info");
        teamServiceResponse = new TeamServiceResponse();
        teamServiceResponse.setTeam(teamService.saveTeam(team));
        return teamServiceResponse;
    }
    @GetMapping("/{teamID}")
    public TeamServiceResponse findTeam(@PathVariable("teamID") String teamID)
    {
            teamServiceResponse = new TeamServiceResponse();
            teamServiceResponse.setTeam(teamService.getTeamById(Integer.valueOf(teamID)));
            return teamServiceResponse;
    }
    @PutMapping("/addPlayerToTeam/")
    public boolean addPlayerToTeam(@RequestBody Player player)
    {
        var team= teamService.getTeamById(player.getTeamID());
        team.getPlayers().add(player.getId());
        teamService.saveTeam(team);
        return true;
    }

    @GetMapping("/getAllTeams/")
    public TeamServiceResponse getAllTeams()
    {
        teamServiceResponse = new TeamServiceResponse();
        teamServiceResponse.setTeams(teamService.listAllTeams());
        teamServiceResponse.setStatus("Success");
        return teamServiceResponse;
    }

    @DeleteMapping("/{teamID}")
    public TeamServiceResponse deleteATeam(@PathVariable("teamID") int teamID)
    {
        teamService.deleteTeam(teamID);
        teamServiceResponse = new TeamServiceResponse();
        teamServiceResponse.setTeams(teamService.listAllTeams());
        return teamServiceResponse;
    }
    @PutMapping("/editTeam/")
    public TeamServiceResponse findTeam(@RequestBody Team team)
    {
        if(teamService.getTeamById(team.getId())!=null)
        {
            teamServiceResponse = new TeamServiceResponse();
            teamServiceResponse.setTeam(teamService.saveTeam(team));
        }
        return teamServiceResponse;
    }

}
