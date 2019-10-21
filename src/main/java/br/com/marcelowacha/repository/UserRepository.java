package br.com.marcelowacha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.marcelowacha.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}