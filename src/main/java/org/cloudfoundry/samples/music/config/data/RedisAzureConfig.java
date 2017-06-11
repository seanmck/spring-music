package org.cloudfoundry.samples.music.config.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudException;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.JedisShardInfo;

@Configuration
@Profile("azureredis-cloud")
public class RedisAzureConfig {
	
	@Autowired(required=false)
	Cloud cloud;
	
	@Bean
    public RedisConnectionFactory redisConnection() {
		
		
		List<ServiceInfo> serviceInfos = getCloud().getServiceInfos();
		
		String host = "";
		int port = 1;
		String key = "";
		
		if (serviceInfos.size() == 1) {
			AzureRedisServiceInfo info = (AzureRedisServiceInfo) serviceInfos.get(0);
			
			host = info.getHostname();
			port = info.getPort();
			key = info.getPrimaryKey();
			
			System.out.println("*************************");
			System.out.println("hostname = " + host);
			System.out.println("port = " + port);
			System.out.println("primaryKey = " + key);
			System.out.println("*************************");
			System.out.println("");
		}
		
		JedisShardInfo shardInfo = new JedisShardInfo(host, port);
	    shardInfo.setPassword(key); /* Use your access key. */
	    
		
        return new JedisConnectionFactory(shardInfo);
    }
	
	private Cloud getCloud() {
        try {
            CloudFactory cloudFactory = new CloudFactory();
            return cloudFactory.getCloud();
        } catch (CloudException ce) {
            return null;
        }
    }
	
}
