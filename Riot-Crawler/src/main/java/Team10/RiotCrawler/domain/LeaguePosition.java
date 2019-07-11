package Team10.RiotCrawler.domain;

import lombok.Data;

@Data
public class LeaguePosition {
    private String queueType;
    private String summonerName;
    private boolean hotStreak;
    private MiniSeriesDTO miniSeries;
    private int wins;
    private boolean veteran;
    private int losses;
    private String rank;
    private String tier;
    private boolean inactive;
    private boolean freshBlood;
    private String leagueId;
    private String summonerId;
    private int leaguePoints;

    @Data
    public class MiniSeriesDTO{
        private String progress;
        private int losses;
        private int target;
        private int wins;
    }
}
