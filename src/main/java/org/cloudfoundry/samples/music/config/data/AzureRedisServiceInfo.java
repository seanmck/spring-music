package org.cloudfoundry.samples.music.config.data;

import org.springframework.cloud.service.BaseServiceInfo;

public class AzureRedisServiceInfo extends BaseServiceInfo {

	String hostname;
	String name;
	int port;
	String primaryKey;
	String secondaryKey;
	int sslPort;
	
	public AzureRedisServiceInfo(String hostname, String name, int port, String primaryKey, String secondaryKey, int sslPort) {
		
		super(name);		
		this.hostname = hostname;
		this.name = name;
		this.port = port;
		this.primaryKey = primaryKey;
		this.secondaryKey = secondaryKey;
		this.sslPort = sslPort;
		
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getSecondaryKey() {
		return secondaryKey;
	}

	public void setSecondaryKey(String secondaryKey) {
		this.secondaryKey = secondaryKey;
	}

	public int getSslPort() {
		return sslPort;
	}

	public void setSslPort(int sslPort) {
		this.sslPort = sslPort;
	}

	

	
	
}
