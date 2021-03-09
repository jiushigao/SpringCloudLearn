package com.example.springcloudsecurity.config;

import com.example.springcloudsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//方法级别的保护
/**括号里面有以下参数可选
 * prePostEnabled：Spring Security 的 Pre 和 Post 注解是否可用，即 @PreAuthorize 和 @PostAuthorize 是否可用
 * secureEnabled: Spring Security 的 @Secured 注解是否可用
 * jsr250Enabled: Spring Security 对 JSR-250 的注解是否可用
 *
 * @PreAuthorize 在方法执行前进行权限验证
 * @PostAuthorize 在方法执行后进行权限验证
 *
 * 例： @PreAuthorize("hasRole('ADMIN')")  ==  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
 * @PreAuthorize("hasAnyRole('ADMIN','USER')") == @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("jie").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN","USER");
          auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**","/index").permitAll().
                antMatchers("/user/**").hasRole("USER").
                antMatchers("/blogs/**").hasRole("USER").
                and().formLogin().loginPage("/login").failureUrl("/login-error").
                and().exceptionHandling().accessDeniedPage("/401");
                http.logout().logoutSuccessUrl("/");
    }
}
