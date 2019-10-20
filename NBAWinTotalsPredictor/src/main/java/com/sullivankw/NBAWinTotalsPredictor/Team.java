package com.sullivankw.NBAWinTotalsPredictor;

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
    NO,
    NY,
    OKC,
    ORL,
    PHI,
    PHO,
    POR,
    SAC,
    SA,
    TOR,
    UTH,
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

    public static Team findByTeam(String teamName) {
        for (Team team : Team.values()) {
            if (teamName.equalsIgnoreCase(team.name())) {
                return team;
            }
        }
        return null;
    }


}
