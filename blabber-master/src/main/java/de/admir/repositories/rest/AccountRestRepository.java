package de.admir.repositories.rest;

import de.admir.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
public interface AccountRestRepository extends JpaRepository<Account, String> {

    @Override
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'RIGHT_MODIFY_ACCOUNT_' + #account.id)")
    <A extends Account> A save(@Param("blog") A account);
}
