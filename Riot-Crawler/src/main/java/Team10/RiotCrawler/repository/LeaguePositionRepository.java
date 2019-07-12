package Team10.RiotCrawler.repository;

import Team10.RiotCrawler.domain.LeaguePosition;
import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


import java.util.Iterator;
import java.util.Set;


@Repository
public class LeaguePositionRepository
{
    @Autowired
    MongoTemplate mongoTemplate;

    public LeaguePosition findLeaguePosition(String encryptedId)
    {
        Query query = Query.query(Criteria.where("summonerId").is(encryptedId));

        return mongoTemplate.findOne(query, LeaguePosition.class);

    }

    public void insertLeaguePosition(Set<LeaguePosition> leaguePositionSet)
    {

        LeaguePosition leaguePosition = new LeaguePosition();
        Iterator<LeaguePosition> iter = leaguePositionSet.iterator();

        mongoTemplate.insert(leaguePositionSet, LeaguePosition.class);

    }

    public void updateLeaguePosition(LeaguePosition leaguePosition) {


        mongoTemplate.update(LeaguePosition.class);



    }

}
