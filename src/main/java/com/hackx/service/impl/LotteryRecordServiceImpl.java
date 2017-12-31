package com.hackx.service.impl;

import com.hackx.entity.LotteryRecordEntity;
import com.hackx.repository.LotteryRecordRepository;
import com.hackx.service.LotteryRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by 曹磊(Hackx) on 30/12/2017.
 * Email: caolei@mobike.com
 */
@Service
public class LotteryRecordServiceImpl implements LotteryRecordService {

    @Resource
    LotteryRecordRepository lotteryRecordRepository;

    @Override
    public LotteryRecordEntity save(LotteryRecordEntity lotteryRecordEntity) {
        return lotteryRecordRepository.save(lotteryRecordEntity);
    }

    @Override
    public Optional<LotteryRecordEntity> findByLotteryIssue(Integer lotteryIssue) {
        return lotteryRecordRepository.findByLotteryIssue(lotteryIssue);
    }
}
