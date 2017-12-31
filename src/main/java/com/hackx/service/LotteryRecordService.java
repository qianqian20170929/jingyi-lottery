package com.hackx.service;

import com.hackx.entity.LotteryRecordEntity;

import java.util.Optional;

/**
 * Created by 曹磊(Hackx) on 30/12/2017.
 * Email: caolei@mobike.com
 */
public interface LotteryRecordService {

    LotteryRecordEntity save(LotteryRecordEntity lotteryRecordEntity);

    Optional<LotteryRecordEntity> findByLotteryIssue(Integer lotteryIssue);

}
