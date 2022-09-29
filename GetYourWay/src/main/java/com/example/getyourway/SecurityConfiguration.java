package com.example.getyourway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


//Sets up the ability to configure spring security
@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
    //Decides which URL paths should be secured and which should not 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Makes all http requests authenticated allows all users to /login all other requests will be redirected
        //to /login
        http
                .authorizeHttpRequests((authz) -> authz
                    .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                    .loginPage("/login")
                    .permitAll()
                );
                

            return http.build();

    }

    //This sets up a basic in memory user for testing this user can be replaced later with a database user
    @Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
            //This encoding method is not secure and should be changed or kept for a testing user
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

    /*
    This is the code the docs reccomends to connect users database to spring security using JDBC.
    For some reason first method throws up error: EmbeddedDatabase cannot be converted to type DataSource.
    Research more once database has been setup
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
            .build();
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        return users;
    }
    */

    
}