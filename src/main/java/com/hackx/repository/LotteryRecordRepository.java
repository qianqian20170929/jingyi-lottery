package com.hackx.repository;

import com.hackx.entity.LotteryRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by 曹磊(Hackx) on 30/12/2017.
 * Email: caolei@mobike.com
 */
public interface LotteryRecordRepository extends JpaRepository<LotteryRecordEntity, Long> {

    LotteryRecordEntity save(LotteryRecordEntity lotteryRecordEntity);

    Optional<LotteryRecordEntity> findByLotteryIssue(Integer lotteryIssue);

}
