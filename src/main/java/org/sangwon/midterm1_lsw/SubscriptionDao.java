package org.sangwon.midterm1_lsw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionDao {
	static final String ADD_SUBSCRIPTION = "INSERT subscription(userId, name, channelId, title) VALUES(?,?,?,?)";
	static final String DELETE_SUBSCRIPTION = "DELETE FROM subscription WHERE (userId, channelId)=(?,?)";
	static final String LIST_SUBSCRIPTION = "select channelId, title from subscription where userId=?";

	@Autowired
	JdbcTemplate jdbctemplate;

	RowMapper<Subscription> subscriptionRowMapper = new BeanPropertyRowMapper<>(Subscription.class);

	public int addSubscription(Subscription subscription) {
		return jdbctemplate.update(ADD_SUBSCRIPTION, subscription.getUserId(), subscription.getName(),
				subscription.getChannelId(), subscription.getTitle());
	}

	public int deleteSubscription(Subscription subscription) {
		return jdbctemplate.update(DELETE_SUBSCRIPTION, subscription.getUserId(), subscription.getChannelId());
	}

	public List<Subscription> listSubscription(String userId) {
		return jdbctemplate.query(LIST_SUBSCRIPTION, subscriptionRowMapper, userId);
	}

}
