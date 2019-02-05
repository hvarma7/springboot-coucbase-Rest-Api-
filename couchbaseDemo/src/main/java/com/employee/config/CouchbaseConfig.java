package com.employee.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

@Component
//@PropertySource("/Users/hrishikeshvarma/config/application.properties")
class CouchbaseConfig {
	
	@Value("${couchbase.ip}")
	private String ip;
	
	@Value("${bucket.name}")
	private String bucket;
	
//	@Value("${spring.couchbase.}")
//	private String username;
	
	@Value("${bucket.password}")
	private String password;
	
	@Bean
	public Bucket getBucket() {
		Cluster cluster = CouchbaseCluster.create(this.ip);
		cluster.authenticate("hvarma", this.password);
		Bucket bucket = (Bucket) cluster.openBucket(this.bucket);
		return bucket;
	}
	
}