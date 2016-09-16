package com.springbank.security;

import com.springbank.domain.AccountHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails extends AccountHolder implements UserDetails {

    private AccountHolder accountHolder;

    public CustomUserDetails(AccountHolder accountHolder) {
        super(accountHolder.getUsername(), accountHolder.getPassword());
        this.accountHolder = accountHolder;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("ADMIN");
    }

    @Override
    public String getUsername() {
        return accountHolder.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
