package com.soccer.teams.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "team")
public class Team {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String name;
        @Version
        private Integer version;
        @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
        private List<Integer> players;
        private Integer playedGames;
        private Integer wonMatches;
        private Integer drawMatches;
        private Integer lostMatches;
        private Integer goalsInFavor;
        private Integer goalsAgainst;
        private Integer yellowCards;
        private Integer redCards;

        private Date joinDate;
        private Date leftDate;
}
