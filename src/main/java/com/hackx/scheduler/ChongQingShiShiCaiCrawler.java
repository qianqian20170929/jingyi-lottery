package com.hackx.scheduler;

import com.hackx.entity.LotteryRecordEntity;
import com.hackx.service.LotteryRecordService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 曹磊(Hackx) on 30/12/2017.
 * Email: caolei@mobike.com
 */
@Component
public class ChongQingShiShiCaiCrawler {

    private static final Logger logger = LoggerFactory.getLogger(ChongQingShiShiCaiCrawler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

    /* TODO 改成可配置，防止站点挂掉不能及时返回数据*/
    private String targetUrl = "http://www.cqcp.net/game/ssc/";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    LotteryRecordService lotteryRecordService;


    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void retrieveLotteryResult() {
        String response = this.restTemplate.getForObject(targetUrl, String.class);
        try {
            Map<String, String> lotteryResult = parseLotteryResult(response);
            for (Map.Entry<String, String> entry : lotteryResult.entrySet()) {
                if (!lotteryRecordService.findByLotteryIssue(Integer.valueOf(entry.getKey())).isPresent()) {
                    LotteryRecordEntity lotteryRecordEntity = new LotteryRecordEntity();
                    lotteryRecordEntity.setLotteryTime(new Date());
                    lotteryRecordEntity.setLotteryIssue(Integer.valueOf(entry.getKey()));
                    lotteryRecordEntity.setLotteryNum(entry.getValue());
                    lotteryRecordService.save(lotteryRecordEntity);
                }
            }
        } catch (Exception e) {
            logger.error("error occur when retrieveLotteryResult");
        }
    }

    private Map<String, String> parseLotteryResult(String pageSource) {
        Map<String, String> lotteryResultMap = new HashMap<>();
        try {
            Elements ulEles = Jsoup.parse(pageSource).getElementById("openlist").getElementsByTag("ul");
            Element ulEle = ulEles.get(1);
            Elements liEles = ulEle.getElementsByTag("li");
            String issue = liEles.get(0).text();
            String num = liEles.get(1).text();
            lotteryResultMap.put(issue, num);
        } catch (Exception e) {
            logger.error("error occur when parseLotteryResult");
        }
        return lotteryResultMap;
    }
}
