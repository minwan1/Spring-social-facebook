package com.javacents.socialsignin.socialutils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import com.javacents.socialsignin.infrastructure.repository.UserRepository;
import com.javacents.socialsignin.model.User;

public class PostSocialSignInAdapter implements SignInAdapter {
	private UserRepository userRepository;

	@Inject
	public PostSocialSignInAdapter(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
		UserProfile profile = connection.fetchUserProfile();
		User user = userRepository.findByEmail(profile.getEmail());
		HttpServletRequest req = ((ServletWebRequest) request).getRequest();
		req.getSession().setAttribute("loggedUser", user);
		return null; // will return to postSignInUrl
	}

}
