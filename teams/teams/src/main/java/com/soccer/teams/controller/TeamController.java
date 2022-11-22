package com.soccer.teams.controller;

import com.soccer.teams.entities.Team;
import com.soccer.teams.externalentities.Player;
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

    @PostMapping("/")
    public Team saveTeam(@RequestBody Team team)
    {
        log.info("saving info");
        return teamService.saveTeam(team);
    }
    @GetMapping("/{teamID}")
    public Team findTeam(@PathVariable("teamID") String teamID)
    {
      return teamService.getTeamById(Integer.valueOf(teamID));
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
    public List<Team> getAllTeams()
    {
        return teamService.listAllTeams();
    }

    @DeleteMapping("/{teamID}")
    public List<Team> deleteATeam(@PathVariable("teamID") int teamID)
    {
        teamService.deleteTeam(teamID);
        return teamService.listAllTeams();
    }
    @PutMapping("/editTeam/")
    public Team findTeam(@RequestBody Team team)
    {
        if(teamService.getTeamById(team.getId())!=null)
        {
            team = teamService.saveTeam(team);
        }
        return team;
    }

}
