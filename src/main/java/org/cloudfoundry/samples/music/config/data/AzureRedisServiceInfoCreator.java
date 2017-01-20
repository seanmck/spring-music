package org.cloudfoundry.samples.music.config.data;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

public class AzureRedisServiceInfoCreator extends CloudFoundryServiceInfoCreator<AzureRedisServiceInfo> {

	public AzureRedisServiceInfoCreator() {
		super(new Tags(), "");
	}

	public AzureRedisServiceInfoCreator(Tags tags, String[] uriSchemes) {
		super(tags, uriSchemes);
	}

	@Override
	public AzureRedisServiceInfo createServiceInfo(Map<String, Object> config) {
		
		
		  Map<String, Object> configParams = getCredentials(config);
		
		  String hostname = (String) configParams.get("hostname"); 
		  String name = (String) configParams.get("name"); 
		  Integer port = (Integer)configParams.get("port"); 
		  String primaryKey = (String)configParams.get("primaryKey"); 
		  String secondaryKey = (String)configParams.get("secondaryKey"); 
		  Integer sslPort = (Integer)configParams.get("sslPort");
		  
		  
		  return new AzureRedisServiceInfo(hostname, name, port, primaryKey,
		  secondaryKey, sslPort);

	}

	@Override
	public boolean accept(Map<String, Object> config) {

		Map<String, Object> configParams = getCredentials(config);

		boolean retVal = false;
		
		System.out.println("**************************");
		System.out.println("in the accept method of AzureRedisServiceInfoCreator");
		
		if (configParams.containsKey("hostname")) {
			String host = (String) configParams.get("hostname");
			retVal = host.contains("redis.cache.windows.net");
		}
		
		System.out.println("retVal = " + retVal);
		
		return retVal;
		
		  
		 
	}

}
