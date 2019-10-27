package com.sullivankw.NBAWinTotalsPredictor.services;

import org.springframework.stereotype.Service;


@Service
public class RatingsServiceImpl implements RatingsService {


    @Override
    public Double getProjectedTotalWarUsingRotationPlayers(String team, int rotationDepth) {
        return null;
    }

    @Override
    public Double getProjectedRaptorTotalPlusMinusRegUsingRotationPlayers(String team, int rotationDepth) {
        return null;
    }

    @Override
    public int getProjectedWinTotals(String team) {
        return 0;
    }

    @Override
    public double getStrengthOfSchedule(String team) {
        return 0;
    }
}
