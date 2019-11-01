package br.com.marcelowacha.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name="users")
@Document(indexName = "my_index", type = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -4755435530979850934L;
	/*int indexWithoutRefresh = 1;
	int index = 0;
	int refresh = 1;*/
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Calendar created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_at")
	private Calendar updated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public Calendar getUpdated() {
		return updated;
	}

	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}
	
}
