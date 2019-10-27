package com.sullivankw.NBAWinTotalsPredictor.entities;

import com.sullivankw.NBAWinTotalsPredictor.DepthChartPosition;
import com.sullivankw.NBAWinTotalsPredictor.Status;
import com.sullivankw.NBAWinTotalsPredictor.Team;
import com.sullivankw.NBAWinTotalsPredictor.TeamRole;

import javax.persistence.*;

@Entity
@Table(name = "player_rotation_ranking")
public class PlayerRotationRanking {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "team")
    @Enumerated(EnumType.STRING)
    private Team team;

    @Column(name = "team_role")
    @Enumerated(EnumType.STRING)
    private TeamRole teamRole;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private DepthChartPosition depthChartPosition;

    //1-10 consider in rotation
    @Column(name = "team_importance")
    private int teamImportance;

    @Column(name = "games_to_play")
    private int gamesToPlay;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public PlayerRotationRanking(Team team, String[] row) {
        setTeam(team);
        int position = 0;
        for (String value : row) {
            switch (position) {
                case 0:
                    DepthChartPosition depthChartPosition = DepthChartPosition.getEnumByName(value);
                    setDepthChartPosition(depthChartPosition);
                    setTeamRole(depthChartPosition.getTeamRole());
                    break;
                case 1:
                    setPlayerName(value);
                    break;
                case 2:
                    setGamesToPlay(Integer.valueOf(value));
                    break;
                case 3:
                    setTeamImportance(Integer.valueOf(value));
                case 4:
                    setStatus(value);
                default:
                    break;
            }
            position++;
        }
    }

    public PlayerRotationRanking() {

    }

    public TeamRole getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(TeamRole teamRole) {
        this.teamRole = teamRole;
    }

    public DepthChartPosition getDepthChartPosition() {
        return depthChartPosition;
    }

    public void setDepthChartPosition(DepthChartPosition depthChartPosition) {
        this.depthChartPosition = depthChartPosition;
    }

    public int getTeamImportance() {
        return teamImportance;
    }

    public void setTeamImportance(int teamImportance) {
        this.teamImportance = teamImportance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String value) {
        if (value.equals("I")) {
            this.status = Status.INJURED;
        } else {
            this.status = Status.AVAILABLE;
        }

    }

    public int getGamesToPlay() {
        return gamesToPlay;
    }

    public void setGamesToPlay(int gamesToPlay) {
        this.gamesToPlay = gamesToPlay;
    }
}
