package com.javacents.socialsignin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name", nullable = false, length = 128)
	private String name;
	@Column(name = "email", nullable = false, length = 128)
	private String email;
	@Column(name = "password", nullable = false, length = 64)
	private String passwordHash;
	@Column(name = "thumbnail_url")
	private String thumbnailUrl;

	public User(){
	}
	
	public User(String name, String email, String passwordHash, String thumbnailUrl) {
		super();
		this.name = name;
		this.email = email;
		this.passwordHash = passwordHash;
		this.thumbnailUrl = thumbnailUrl;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
}
