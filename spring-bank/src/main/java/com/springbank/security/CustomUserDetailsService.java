package com.springbank.security;

import com.springbank.domain.AccountHolder;
import com.springbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountHolder accountHolder = userRepository.findByUsername(username);
        if (accountHolder != null) {
            return new CustomUserDetails(accountHolder);
        }
        throw new UsernameNotFoundException(username);
    }
}
