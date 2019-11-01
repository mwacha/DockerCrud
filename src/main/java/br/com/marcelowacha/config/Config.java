package br.com.marcelowacha.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "br.com.marcelowacha.repository")
@ComponentScan(basePackages = { "br.com.marcelowacha.service" })
public class Config {
 
	 @Value("${elasticsearch.host:localhost}") 
	    public String host;
	    @Value("${elasticsearch.port:9300}") 
	    public int port;
 
    @Bean
    public Client client() {
        Settings elasticsearchSettings = Settings.builder()
          .put("client.transport.sniff", true)
         // .put("path.home", elasticsearchHome)
          //.put("cluster.name", clusterName)
          .build();
        TransportClient client = new PreBuiltTransportClient(elasticsearchSettings);
        try{
        	client.addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
 
 /*   @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }*/
    
    
  
    
    

}
