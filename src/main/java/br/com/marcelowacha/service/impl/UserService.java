package br.com.marcelowacha.service.impl;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.marcelowacha.domain.User;
import br.com.marcelowacha.repository.UserRepository;
import br.com.marcelowacha.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)	
	public User salvar(User user) {	
		User entity = repository.save(user);
		return entity;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)	
	public List<User> listar() {
		return IteratorUtils.toList(repository.findAll().iterator());		
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)	
	public User buscarPorId(Long id) {	
		return repository.findById(id).get();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor=Exception.class)	
	public void excluir(User user) {
		repository.delete(user);		
	}

}
