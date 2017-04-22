package com.javacents.socialsignin;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.SignInAdapter;

import com.javacents.socialsignin.infrastructure.repository.UserRepository;
import com.javacents.socialsignin.socialutils.PostSocialSignInAdapter;
import com.javacents.socialsignin.socialutils.SocialImplicitSignUp;

@Configuration
public class SocialConfig extends SocialConfigurerAdapter{
	@Autowired
	private Environment environment;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public SignInAdapter signInAdapter() {
		return new PostSocialSignInAdapter(userRepository);
	}
	
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator, Encryptors.noOpText());
		repository.setConnectionSignUp(new SocialImplicitSignUp(userRepository));
		return repository;
	}
}