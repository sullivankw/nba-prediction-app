package com.sullivankw.NBAWinTotalsPredictor.services;

public interface RatingsService {

    /**
     * provide how deep of rotation you want to consider
     * **/
    Double getProjectedTotalWarUsingRotationPlayers(String team, int rotationDepth);
    /**
     * provide how deep of rotation you want to consider
     * **/
    Double getProjectedRaptorTotalPlusMinusRegUsingRotationPlayers(String team, int rotationDepth);
    int getProjectedWinTotals(String team);
    double getStrengthOfSchedule(String team);
}
