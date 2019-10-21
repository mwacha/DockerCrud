package br.com.marcelowacha.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcelowacha.domain.User;
import br.com.marcelowacha.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private IUserService userService;

	@RequestMapping(value="/alterar",	method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody ResponseEntity <User> atualizar(@RequestBody User user,HttpServletRequest httpServletRequest){
		
		user = userService.salvar(user);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}	
	
	@RequestMapping(value="/incluir", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity <User> incluir(@RequestBody User user,
			HttpServletRequest httpServletRequest){
		
		user = userService.salvar(user);
				
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)	
	public @ResponseBody  ResponseEntity <List<User>> listar(HttpServletRequest httpServletRequest){
		
		List<User> users = userService.listar();
				
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value="/buscarPorId/{id}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity <User> buscarPorId(@PathVariable Long id, HttpServletRequest httpServletRequest){
		
		User user = userService.buscarPorId(id);
				
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
