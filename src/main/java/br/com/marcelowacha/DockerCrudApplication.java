package br.com.marcelowacha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.marcelowacha.repository.data")
@EnableElasticsearchRepositories("br.com.marcelowacha.repository.index")
public class DockerCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerCrudApplication.class, args);
	}

}
