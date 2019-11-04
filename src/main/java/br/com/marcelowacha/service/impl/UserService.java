package br.com.marcelowacha.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcelowacha.domain.User;
import br.com.marcelowacha.repository.data.UserRepository;
import br.com.marcelowacha.repository.index.UserSearchRepository;
import br.com.marcelowacha.service.IUserService;

@Service
public class UserService implements IUserService {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Value("${elasticsearch.index.name}")
	private String indexName;
	
	@Value("${elasticsearch.user.type}")	
	private String userTypeName;
	
	@Autowired
	private ElasticsearchRestTemplate esTemplate;

	@Autowired
	private UserSearchRepository searchRepository;

	@Autowired
	private UserRepository repository;

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public User salvar(User user) {		
		User entity = repository.save(user);
		
		
		if(entity != null) {
			searchRepository.save(entity);
		}
		
		return entity;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> listar() {
		 SearchQuery getAllQuery = new NativeSearchQueryBuilder()
	                .withQuery(matchAllQuery()).build();
	        return esTemplate.queryForList(getAllQuery, User.class);		
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User buscarPorId(Long id) {
		return searchRepository.findById(id).get();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void excluir(User user) {
		repository.delete(user);
		searchRepository.delete(user);
	}

}
