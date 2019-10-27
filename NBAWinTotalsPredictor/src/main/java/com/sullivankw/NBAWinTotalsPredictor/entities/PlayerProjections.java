package com.sullivankw.NBAWinTotalsPredictor.entities;

import com.sullivankw.NBAWinTotalsPredictor.Team;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "player_projections")
public class PlayerProjections {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "war_total_per_82_reg")
    @Nullable
    private Double warTotalPer82;
    @Column(name = "raptor_total_plus_minus_reg")
    @Nullable
    private Double raptorTotalPlusMinusReg;
    @Column(name = "player_name")
    @Nullable
    private String playerName;
    @Column(name = "team")
    @Nullable
    @Enumerated(EnumType.STRING)
    private Team team;

    public PlayerProjections(String[] row) {
        int position = 0;
        for (String value : row) {
            switch (position) {
                case 0:
                    setPlayerName(value);
                    break;
                case 1:
                    setWarTotalPer82(Double.valueOf(value));
                    break;
                case 2:
                    setRaptorTotalPlusMinusReg(Double.valueOf(value));
                case 3:
                    setTeam(Team.getEnumByName(value));
                default:
                    break;
            }
            position++;
        }
    }

    public PlayerProjections() {
        }

        public Integer getId () {
            return id;
        }

        public void setId (Integer id){
            this.id = id;
        }

        @Nullable
        public Double getWarTotalPer82 () {
            return warTotalPer82;
        }

        public void setWarTotalPer82 (@Nullable Double warTotalPer82){
            this.warTotalPer82 = warTotalPer82;
        }

        @Nullable
        public Double getRaptorTotalPlusMinusReg () {
            return raptorTotalPlusMinusReg;
        }

        public void setRaptorTotalPlusMinusReg (@Nullable Double raptorTotalPlusMinusReg){
            this.raptorTotalPlusMinusReg = raptorTotalPlusMinusReg;
        }

        @Nullable
        public String getPlayerName () {
            return playerName;
        }

        public void setPlayerName (@Nullable String playerName){
            this.playerName = playerName;
        }

    @Nullable
    public Team getTeam() {
        return team;
    }

    public void setTeam(@Nullable Team team) {
        this.team = team;
    }
}
