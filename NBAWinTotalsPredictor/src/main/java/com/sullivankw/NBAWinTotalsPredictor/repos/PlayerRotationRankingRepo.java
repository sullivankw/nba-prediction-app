package com.sullivankw.NBAWinTotalsPredictor.repos;

import com.sullivankw.NBAWinTotalsPredictor.DepthChartPosition;
import com.sullivankw.NBAWinTotalsPredictor.Team;
import com.sullivankw.NBAWinTotalsPredictor.entities.PlayerRotationRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRotationRankingRepo extends JpaRepository<PlayerRotationRanking,Integer> {

//    @Query("select p from PlayerRotationRanking p where p.team = :team and (p.position = :pos1 OR p.position = :pos2 OR " +
//            "p.position = :pos3 OR p.position = :pos4 OR p.position = :pos5)")
//    List<PlayerRotationRanking> getPlayersByTeamAndRotations(@Param("team") Team team, @Param("pos1") DepthChartPosition pos1,
//                                                           @Param("pos2") DepthChartPosition pos2, @Param("pos3") DepthChartPosition pos3,
//                                                           @Param("pos4") DepthChartPosition pos4, @Param("pos5") DepthChartPosition pos5);

//    @Query("select p from PlayerRotationRanking p where p.team = :team and (p.teamImportance = 1 OR p.teamImportance = 2 OR " +
//            "p.teamImportance = 4 OR p.teamImportance = 5 OR p.teamImportance = 6 OR p.teamImportance = 7 OR p.teamImportance = 8 " +
//            "OR p.teamImportance = 9 OR p.teamImportance = 10)")
//    List<PlayerRotationRanking> getRotationsPlayersPerTeam(@Param("team") Team team);

}
