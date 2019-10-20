package com.sullivankw.NBAWinTotalsPredictor.entities;

import com.sullivankw.NBAWinTotalsPredictor.Team;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "team_schedule")
public class TeamSchedule {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "team")
    @Enumerated(EnumType.STRING)
    private Team team;

    @Column(name = "game_time")
    private Date gameTime;

    @Column(name = "opponent")
    @Nullable
    private String opponent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    public Date getGameTime() {
        return gameTime;
    }

    public void setGameTime(Date gameTime) {
        this.gameTime = gameTime;
    }

    @Nullable
    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(@Nullable String opponent) {
        this.opponent = opponent;
    }
}
