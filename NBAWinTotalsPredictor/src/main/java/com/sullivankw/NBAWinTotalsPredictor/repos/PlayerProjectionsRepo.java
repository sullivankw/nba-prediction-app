package com.sullivankw.NBAWinTotalsPredictor.repos;

import com.sullivankw.NBAWinTotalsPredictor.entities.PlayerProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerProjectionsRepo extends JpaRepository<PlayerProjections, Integer> {

}
