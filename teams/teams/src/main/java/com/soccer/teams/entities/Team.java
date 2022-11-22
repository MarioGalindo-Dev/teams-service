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

        @Version
        private Integer version;
        @ElementCollection(targetClass = Integer.class)
        private List<Integer> players;
        private Integer playedGames;
        private Integer wonMatches;
        private Integer drawMatches;
        private Integer lostMatches;
        private Integer goalsInFavor;
        private Integer goalsAgainst;
        private Integer yellowCards;
        private Integer redCards;
        private String name;
        private Date joinDate;
        private Date leftDate;

      /*  @Override
        public int compareTo(Object team) {
                return this.wonMatches - ((Team)team).wonMatches;
        }*/
}
