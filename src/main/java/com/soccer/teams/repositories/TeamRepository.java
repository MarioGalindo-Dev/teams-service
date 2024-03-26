package com.soccer.teams.repositories;

import com.soccer.teams.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {


    @Query(value = "SELECT * FROM team WHERE played_games > :playedGames", nativeQuery = true)
    List<Team> findTeamsWithMoreThanXPlayedGamesNativeSQL(@Param("playedGames") int x);

    public default List<Team> findTeamsWithMoreThanXPlayedGames(EntityManager em, int x) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Team> cq = cb.createQuery(Team.class);
        Root<Team> teamRoot = cq.from(Team.class);

        cq.select(teamRoot)
                .where(cb.greaterThan(teamRoot.get("playedGames"), x));

        TypedQuery<Team> query = em.createQuery(cq);
        return query.getResultList();
    }
    @Query("SELECT t FROM Team t WHERE t.playedGames > :playedGames")
    List<Team> findTeamsWithMoreThanXPlayedGamesJPQL(@Param("playedGames") int x);


}
