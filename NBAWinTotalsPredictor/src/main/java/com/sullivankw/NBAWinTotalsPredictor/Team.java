package com.sullivankw.NBAWinTotalsPredictor;

import java.util.ArrayList;
import java.util.List;

//note that the excel file uses a few non traditional team abbrev to correct for
public enum Team {
    ATL,
    BOS,
    BKN,
    CHA,
    CHI,
    CLE,
    DAL,
    DEN,
    DET,
    GSW,
    HOU,
    IND,
    LAC,
    LAL,
    MEM,
    MIA,
    MIL,
    MIN,
    NOP, //NOR
    NYK, //NY
    OKC,
    ORL,
    PHI,
    PHO,
    POR,
    SAC,
    SAS, //SA
    TOR,
    UTA, //UTH
    WAS;

    public static Team[] getTeams() {
        Team[] teams = new Team[30];
        int counter = 0;
        for (Team t : Team.values()) {
            teams[counter] = t;
            counter++;
        }
        return teams;
    }

    public static Team getEnumByName(String teamName) {
        for (Team team : Team.values()) {
            if (teamName.equalsIgnoreCase(team.name())) {
                return team;
            }
        }
        return null;
    }

    public static String getAlternativeTeamAbbrev(Team team) {
        List<Team> altTeams = new ArrayList<Team>(); {
            altTeams.add(NOP);
            altTeams.add(NYK);
            altTeams.add(SAS);
            altTeams.add(UTA);
        }
        for (Team t : altTeams) {
            if (t.name().equalsIgnoreCase(team.name())) {
                switch (team) {
                    case NOP:
                        return "NO";
                    case NYK:
                        return "NY";
                    case SAS:
                        return "SA";
                    case UTA:
                        return "UTH";
                        default:
                            break;
                }
            }
        }
        return null;
    }

}
