package br.com.marcelowacha.repository.index;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import br.com.marcelowacha.domain.User;

@Repository
public interface UserSearchRepository extends ElasticsearchRepository<User, Long> {

}