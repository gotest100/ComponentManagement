package masterSpringMvc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;


@Component
public class TweetService {
	public static Random rand = new Random();

	public List<Tweet> getTweeters() {
		List<Tweet> tweets = new ArrayList<Tweet>();
		String[] userList = new String[] {"Tom", "Jerry", "Nina", "Michelle", "Chris"};
		String[] tweeters = new String[] {
			"TDD is necessary in the project? @TDD",
			"Why security is important to the company, anyone knows how to use metasploits?",
			"Penaration test? Black box or white box?",
			"Blockchain is the most popular matters in IT field, you have to face it. @IBM",
			"Michelle, human resource associate, a pretty girl."
		};
		
		for(int i = 0; i < userList.length; i++) {
			Tweet tweet = new Tweet((long)i, "ID: " + i, tweeters[i], new Date(), userList[i], userList[i], (long)i, (long)i, "", "");
			tweets.add(tweet);
		}
		
		return tweets;
	}
}
