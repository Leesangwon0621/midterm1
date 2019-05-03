package org.sangwon.midterm1_lsw;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SubscriptionMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"subscription-context.xml");
		SubscriptionService subscriptionService = context
				.getBean("subscriptionService", SubscriptionService.class);

		subscriptionService.subscription();
		subscriptionService.listSubscriptions();
		context.close();

	}

}
