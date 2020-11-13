package net.originmobi.pdv.settings;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

/**
 * @author jonathas.assuncao on 12/11/2020
 * @project pdv
 */
//@TestConfiguration
public class AuthenticationTestBuilder {
//
//  @Bean
//  @Primary
//  public UserDetailsService userDetailsService() {
//
//
//    userDetailsService()
//    User managerUser = new UserImpl("Manager User", "manager@company.com", "password");
//    UserActive manager = new UserActive(managerUser, Arrays.asList(
//        new SimpleGrantedAuthority("ROLE_MANAGER"),
//        new SimpleGrantedAuthority("PERM_FOO_READ"),
//        new SimpleGrantedAuthority("PERM_FOO_WRITE"),
//        new SimpleGrantedAuthority("PERM_FOO_MANAGE")
//    ));
//
//    return new InMemoryUserDetailsManager(Arrays.asList(common, manager));
//  }
}
