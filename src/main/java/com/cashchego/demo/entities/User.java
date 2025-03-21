package com.cashchego.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codUser;
	private String name;
	private String email;
	private String phone;
	private String adress;
	private String password;

	
	@OneToMany(mappedBy = "client")
	private List<Transaction> transactions = new ArrayList<>();
	
	@OneToMany(mappedBy = "client")
	private List<Report> reports = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	public User() {
		super();
	}

	public User(Long id, String codUser, String name, String email, String phone, String adress,
			String password) {
		super();
		this.id = id;
		this.codUser = codUser;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.password = password;
	}
	
	public User(Long id, String codUser, String name, String email, String phone, String adress,
			String password, Company company) {
		super();
		this.id = id;
		this.codUser = codUser;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.password = password;
		this.company = company;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodUser() {
		return codUser;
	}

	public void setCodUser(String codUser) {
		this.codUser = codUser;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
