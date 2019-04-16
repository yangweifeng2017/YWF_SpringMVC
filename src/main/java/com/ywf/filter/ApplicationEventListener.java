package com.ywf.filter;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import com.easou.bi.angela_client.AngelaClient;

@SuppressWarnings("rawtypes")
public class ApplicationEventListener implements ApplicationListener {
	private static final Logger logger = Logger.getLogger(ApplicationEventListener.class);

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextClosedEvent) {
			AngelaClient.close();
			logger.info("服务器容器关闭，RedisService连接关闭");
		}
	}

}
