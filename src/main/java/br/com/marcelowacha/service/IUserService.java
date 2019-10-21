package br.com.marcelowacha.service;

import java.util.List;

import br.com.marcelowacha.domain.User;

public interface IUserService {
	
	User salvar(User user);
	List<User> listar();
	User buscarPorId(Long id);
	void excluir(User user);

}
