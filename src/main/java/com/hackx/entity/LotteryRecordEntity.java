package com.hackx.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 曹磊(Hackx) on 30/12/2017.
 * Email: caolei@mobike.com
 */
@Data
@Entity
@Table(name = "lottery_record")
public class LotteryRecordEntity implements Serializable {

    private static final long serialVersionUID = -3879124682668184839L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "lottery_time")
    private Date lotteryTime;


    @Column(name = "lottery_issue")
    private Integer lotteryIssue;


    @Column(name = "lottery_num")
    private String lotteryNum;

}
