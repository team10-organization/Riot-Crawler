package Team10.RiotCrawler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiotController
{
    @Autowired
    RiotService riotService;

    @GetMapping("/riot-crawler/encryptedid/{summonername}")
    public String getEncryptedId(String summonername)
    {
        return riotservice.get(summonername);
    }


    @GetMapping("/riot-crawler/leagueposition/{encryptedid}")
    public LeaguePosition getLeaguePosition(String encryptedid)
    {
        return riotservice.getleaguepositionbysummonername(encryptedid);
    }

}
