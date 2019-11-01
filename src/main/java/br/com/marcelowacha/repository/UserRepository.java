package br.com.marcelowacha.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.com.marcelowacha.domain.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {

}