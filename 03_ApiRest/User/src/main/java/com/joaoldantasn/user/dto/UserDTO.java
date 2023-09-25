package com.joaoldantasn.user.dto;

import java.time.LocalDate;

import com.joaoldantasn.user.entities.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class UserDTO {
	
	private Long id;
	@NotBlank(message = "Campo requerido")
	private String name;
	private String cpf;
	private Double income;
	@PastOrPresent(message = "Datas futuras são inválidas")
	private LocalDate birthDate;
	private Integer children;
	
	public UserDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}
	
	
	
}
