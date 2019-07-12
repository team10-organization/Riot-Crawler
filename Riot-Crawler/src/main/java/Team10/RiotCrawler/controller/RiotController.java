package Team10.RiotCrawler.controller;


import Team10.RiotCrawler.domain.LeaguePosition;
import Team10.RiotCrawler.domain.SummonerInfo;
import Team10.RiotCrawler.service.RiotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class RiotController
{
    @Autowired
    RiotService riotService;

    // LeaguePosition을 return
    @GetMapping("/riot-crawler/leagueposition/{summonerName}")
    public Set<LeaguePosition> getLeaguePosition(@PathVariable String summonerName)
    {
        return riotService.getLeaguePositionBySummonerName(summonerName); // LeaguePosition을 리턴
    }
}
