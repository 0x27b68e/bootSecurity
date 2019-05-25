package com.quan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quan.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User name not found");
		}
		UserDetailsImpl detailsImpl = new UserDetailsImpl(user);
		System.out.println(detailsImpl.isAccountNonLocked());
		System.out.println(detailsImpl.getPassword());
		System.out.println(detailsImpl.getUsername());
		System.out.println("Authority...");
		detailsImpl.getAuthorities().iterator().forEachRemaining(action -> System.out.println(action.getAuthority()));
		return detailsImpl;
	} 

}
