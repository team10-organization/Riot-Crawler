package Team10.RiotCrawler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotController
{
    @Autowired
    RiotService riotService;

    @GetMapping("/riot-crawler/leagueposition/{summonername}")
    public LeaguePosition getLeaguePosition(String summonerName)
    {
        return riotService.getLeaguePositionBySummonerName(summonerName);
    }

}
