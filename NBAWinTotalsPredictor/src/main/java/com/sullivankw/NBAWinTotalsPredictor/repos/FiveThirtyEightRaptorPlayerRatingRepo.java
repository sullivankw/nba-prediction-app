package com.sullivankw.NBAWinTotalsPredictor.repos;

import com.sullivankw.NBAWinTotalsPredictor.entities.FiveThirtyEightRaptorPlayerRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiveThirtyEightRaptorPlayerRatingRepo extends JpaRepository<FiveThirtyEightRaptorPlayerRating,Integer> {
}
