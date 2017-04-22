package com.javacents.socialsignin.socialutils;

import java.util.UUID;

import org.springframework.social.connect.Connection;

import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import com.javacents.socialsignin.infrastructure.repository.UserRepository;
import com.javacents.socialsignin.model.User;

public class SocialImplicitSignUp implements ConnectionSignUp {
	private UserRepository userRepository;
	
	public SocialImplicitSignUp(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public String execute(Connection<?> connection) {
		UserProfile profile = connection.fetchUserProfile();
		User user = new User(profile.getFirstName() + " " + profile.getLastName(), profile.getEmail(), "N/A",
				connection.getImageUrl());
		userRepository.save(user);
		return user.getEmail();
	}
	
}
