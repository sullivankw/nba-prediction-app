package com.sullivankw.NBAWinTotalsPredictor.entities;

import com.sullivankw.NBAWinTotalsPredictor.FileType;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "raptor_ratings")
public class FiveThirtyEightRaptorPlayerRating {

    // todo all this needs to be nullable so i can insert projections for rookies
    //also better off creating whole new entry for 2020 rather than attaching as teams switched

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "player_name")
    private String playerName;
    @Column(name = "player_id")
    @Nullable
    private String playerID;
    @Column(name = "season")
    private String season;
    @Column(name = "season_type")
    private String seasonType;
    @Column(name = "team")
    private String team;
    @Column(name = "poss")
    @Nullable
    private Integer poss;
    @Column(name = "mp")
    @Nullable
    private Integer mp;
    @Column(name = "raptor_box_offense")
    @Nullable
    private Double raptorBoxOffense;
    @Column(name = "raptor_box_defense")
    @Nullable
    private Double raptorBoxDefense;
    @Column(name = "raptor_box_total")
    @Nullable
    private Double raptorBoxTotal;
    @Column(name = "raptor_onoff_offense")
    @Nullable
    private Double raptorOnOffense;
    @Column(name = "raptor_onoff_defense")
    @Nullable
    private Double raptorOnOffDefense;
    @Column(name = "raptor_onoff_total")
    @Nullable
    private Double raptorOnOffTotal;
    @Column(name = "raptor_offense")
    @Nullable
    private Double raptorOffense;
    @Column(name = "raptor_defense")
    @Nullable
    private Double raptorDefense;
    @Column(name = "raptor_total")
    @Nullable
    private Double raptorTotal;
    @Column(name = "war_total")
    @Nullable
    private Double warTotal;
    @Column(name = "war_reg_season")
    private Double warRegSeason;
    @Column(name = "war_playoffs")
    @Nullable
    private Double warPlayoffs;
    @Column(name = "predator_offense")
    @Nullable
    private Double predatorOffense;
    @Column(name = "predator_defense")
    @Nullable
    private Double predatorDefense;
    @Column(name = "predator_total")
    @Nullable
    private Double predatorTotal;
    @Column(name = "pace_impact")
    @Nullable
    private Double paceImpact;
    @Column(name = "war_total_per_82_reg")
    @Nullable
    private Double warTotalPer82;
    @Column(name = "raptor_total_plus_minus_reg")
    @Nullable
    private Double raptorTotalPlusMinusReg;

    //insert into raptor_ratings (player_name, season, season_type, team, war_reg_season) values ('Aaron Gordon', '2020', 'RS', 'ORL', 9.9);

    public FiveThirtyEightRaptorPlayerRating() {

    }

    public FiveThirtyEightRaptorPlayerRating(String[] row, FileType fileType) {
        int position = 0;
        if (fileType.equals(FileType.CSV_PLAYER_RATINGS)) {
            for (String value : row) {
                switch (position) {
                    case 0:
                        setPlayerName(value);
                        break;
                    case 1:
                        setPlayerID(value);
                        break;
                    case 2:
                        setSeason(value);
                        break;
                    case 3:
                        setSeasonType(value);
                        break;
                    case 4:
                        setTeam(value);
                        break;
                    case 5:
                        setPoss(Integer.valueOf(value));
                        break;
                    case 6:
                        setMp(Integer.valueOf(value));
                        break;
                    case 7:
                        setRaptorBoxOffense(Double.valueOf(value));
                        break;
                    case 8:
                        setRaptorBoxDefense(Double.valueOf(value));
                        break;
                    case 9:
                        setRaptorBoxTotal(Double.valueOf(value));
                        break;
                    case 10:
                        setRaptorOnOffense(Double.valueOf(value));
                        break;
                    case 11:
                        setRaptorOnOffDefense(Double.valueOf(value));
                        break;
                    case 12:
                        setRaptorOnOffTotal(Double.valueOf(value));
                        break;
                    case 13:
                        setRaptorOffense(Double.valueOf(value));
                        break;
                    case 14:
                        setRaptorDefense(Double.valueOf(value));
                        break;
                    case 15:
                        setRaptorTotal(Double.valueOf(value));
                        break;
                    case 16:
                        setWarTotal(Double.valueOf(value));
                        break;
                    case 17:
                        setWarRegSeason(Double.valueOf(value));
                        break;
                    case 18:
                        setWarPlayoffs(Double.valueOf(value));
                        break;
                    case 19:
                        setPredatorOffense(Double.valueOf(value));
                        break;
                    case 20:
                        setPredatorDefense(Double.valueOf(value));
                        break;
                    case 21:
                        setPredatorTotal(Double.valueOf(value));
                        break;
                    case 22:
                        setPaceImpact(Double.valueOf(value));
                        break;
                    default:
                        break;
                }
                position++;
            }

        } else if (fileType.equals(FileType.CSV_2020_PLAYER_PROJECTIONS)) {
            //player_name,war_total_per_82_reg,raptor_total_plus_minus_reg,team,season
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
                        setTeam(value);
                    case 4:
                        setSeason(value);
                        break;

                        default:
                            break;

                }
                position++;

            }

        }
    }

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

    @Nullable
    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(@Nullable String playerID) {
        this.playerID = playerID;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Nullable
    public Integer getPoss() {
        return poss;
    }

    public void setPoss(@Nullable Integer poss) {
        this.poss = poss;
    }

    @Nullable
    public Integer getMp() {
        return mp;
    }

    public void setMp(@Nullable Integer mp) {
        this.mp = mp;
    }

    @Nullable
    public Double getRaptorBoxOffense() {
        return raptorBoxOffense;
    }

    public void setRaptorBoxOffense(@Nullable Double raptorBoxOffense) {
        this.raptorBoxOffense = raptorBoxOffense;
    }

    @Nullable
    public Double getRaptorBoxDefense() {
        return raptorBoxDefense;
    }

    public void setRaptorBoxDefense(@Nullable Double raptorBoxDefense) {
        this.raptorBoxDefense = raptorBoxDefense;
    }

    @Nullable
    public Double getRaptorBoxTotal() {
        return raptorBoxTotal;
    }

    public void setRaptorBoxTotal(@Nullable Double raptorBoxTotal) {
        this.raptorBoxTotal = raptorBoxTotal;
    }

    @Nullable
    public Double getRaptorOnOffense() {
        return raptorOnOffense;
    }

    public void setRaptorOnOffense(@Nullable Double raptorOnOffense) {
        this.raptorOnOffense = raptorOnOffense;
    }

    @Nullable
    public Double getRaptorOnOffDefense() {
        return raptorOnOffDefense;
    }

    public void setRaptorOnOffDefense(@Nullable Double raptorOnOffDefense) {
        this.raptorOnOffDefense = raptorOnOffDefense;
    }

    @Nullable
    public Double getRaptorOnOffTotal() {
        return raptorOnOffTotal;
    }

    public void setRaptorOnOffTotal(@Nullable Double raptorOnOffTotal) {
        this.raptorOnOffTotal = raptorOnOffTotal;
    }

    @Nullable
    public Double getRaptorOffense() {
        return raptorOffense;
    }

    public void setRaptorOffense(@Nullable Double raptorOffense) {
        this.raptorOffense = raptorOffense;
    }

    @Nullable
    public Double getRaptorDefense() {
        return raptorDefense;
    }

    public void setRaptorDefense(@Nullable Double raptorDefense) {
        this.raptorDefense = raptorDefense;
    }

    @Nullable
    public Double getRaptorTotal() {
        return raptorTotal;
    }

    public void setRaptorTotal(@Nullable Double raptorTotal) {
        this.raptorTotal = raptorTotal;
    }

    @Nullable
    public Double getWarTotal() {
        return warTotal;
    }

    public void setWarTotal(@Nullable Double warTotal) {
        this.warTotal = warTotal;
    }

    public Double getWarRegSeason() {
        return warRegSeason;
    }

    public void setWarRegSeason(Double warRegSeason) {
        this.warRegSeason = warRegSeason;
    }

    @Nullable
    public Double getWarPlayoffs() {
        return warPlayoffs;
    }

    public void setWarPlayoffs(@Nullable Double warPlayoffs) {
        this.warPlayoffs = warPlayoffs;
    }

    @Nullable
    public Double getPredatorOffense() {
        return predatorOffense;
    }

    public void setPredatorOffense(@Nullable Double predatorOffense) {
        this.predatorOffense = predatorOffense;
    }

    @Nullable
    public Double getPredatorDefense() {
        return predatorDefense;
    }

    public void setPredatorDefense(@Nullable Double predatorDefense) {
        this.predatorDefense = predatorDefense;
    }

    @Nullable
    public Double getPredatorTotal() {
        return predatorTotal;
    }

    public void setPredatorTotal(@Nullable Double predatorTotal) {
        this.predatorTotal = predatorTotal;
    }

    @Nullable
    public Double getPaceImpact() {
        return paceImpact;
    }

    public void setPaceImpact(@Nullable Double paceImpact) {
        this.paceImpact = paceImpact;
    }

    @Nullable
    public Double getWarTotalPer82() {
        return warTotalPer82;
    }

    public void setWarTotalPer82(@Nullable Double warTotalPer82) {
        this.warTotalPer82 = warTotalPer82;
    }

    @Nullable
    public Double getRaptorTotalPlusMinusReg() {
        return raptorTotalPlusMinusReg;
    }

    public void setRaptorTotalPlusMinusReg(@Nullable Double raptorTotalPlusMinusReg) {
        this.raptorTotalPlusMinusReg = raptorTotalPlusMinusReg;
    }
}
