package com.sullivankw.NBAWinTotalsPredictor.repos;

import com.sullivankw.NBAWinTotalsPredictor.entities.TeamSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamScheduleRepo extends JpaRepository<TeamSchedule,Integer> {

    TeamSchedule getOneByGameTime(String gameTime);
}
