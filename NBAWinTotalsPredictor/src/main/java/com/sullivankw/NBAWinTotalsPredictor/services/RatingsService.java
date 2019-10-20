package com.sullivankw.NBAWinTotalsPredictor.services;

public interface RatingsService {

    /**
     * Considering top 10 players as rotation players
     * **/
    Double getProjectedTotalWarUsingOnlyRotationPlayers(String team);
    int getProjectedWinTotals(String team);
    double getStrengthOfSchedule(String team);
}
