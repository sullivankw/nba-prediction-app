package com.sullivankw.NBAWinTotalsPredictor.services;

import com.sullivankw.NBAWinTotalsPredictor.DepthChartPosition;
import com.sullivankw.NBAWinTotalsPredictor.Team;
import com.sullivankw.NBAWinTotalsPredictor.entities.PlayerRotationRanking;
//import com.sullivankw.NBAWinTotalsPredictor.repos.PlayerRotationRankingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectionsServiceImpl implements ProjectionsService {

//    @Autowired
//    private PlayerRotationRankingRepo playerRotationRankingRepo;

    @Override
    public int getWinsByTeam(String team) {
        Team teamAsEnum = Team.getEnumByName(team);
        Assert.notNull(teamAsEnum, "Team must exist");

//        List<PlayerRotationRanking> starters = playerRotationRankingRepo.getPlayersByTeamAndRotations(teamAsEnum,
//                DepthChartPosition.PG1, DepthChartPosition.SG1,
//                DepthChartPosition.SF1, DepthChartPosition.PF1, DepthChartPosition.C1);
//
//        List<PlayerRotationRanking> secondString =
//        playerRotationRankingRepo.getPlayersByTeamAndRotations(teamAsEnum,
//                DepthChartPosition.PG2, DepthChartPosition.SG2,
//                DepthChartPosition.SF2, DepthChartPosition.PF2, DepthChartPosition.C2);
//
//        List<PlayerRotationRanking> thirdString =
//        playerRotationRankingRepo.getPlayersByTeamAndRotations(teamAsEnum,
//                DepthChartPosition.PG3, DepthChartPosition.SG3,
//                DepthChartPosition.SF3, DepthChartPosition.PF3, DepthChartPosition.C3);


  //      List<PlayerRotationRanking> players = playerRotationRankingRepo.getRotationsPlayersPerTeam(teamAsEnum);


        return 0;
    }
}
