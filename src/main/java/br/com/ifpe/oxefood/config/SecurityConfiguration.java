package br.com.ifpe.oxefood.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.ifpe.oxefood.modelo.acesso.Perfil;
//import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.seguranca.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthenticationFilter, AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    // Cai em prova => securityFilterChain ( <= É nessa funcão que eu vou liberar todas as rotas públicas da minha aplicação)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(c -> c.disable())
            .authorizeHttpRequests(authorize -> authorize

// Para liberar as rotas publicas do meu projeto! 
// Para cada linha abaixo é uma rota que estarei liberando do Tipo (GET|POST|DELETE)
                .requestMatchers(HttpMethod.GET, "/api/produto").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/produto/*").permitAll() // Se a rota recebe um parâmetro, utilizasse " * " no lugar do ("/{id}") do Produto Controler
                .requestMatchers(HttpMethod.DELETE, "/api/cliente/*").permitAll() // * quando recebe o ("/{id}") do Cliente Controler

                .requestMatchers(HttpMethod.POST, "/api/cliente").permitAll() //permitAll() Cadastra um cliente sem estar logado!
                .requestMatchers(HttpMethod.POST, "/api/funcionario").permitAll() //permitAll() Cadastra um funcionario sem estar logado!
                .requestMatchers(HttpMethod.POST, "/api/auth").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/produto/").hasAnyAuthority(
                   Perfil.ROLE_CLIENTE,
                   Perfil.ROLE_FUNCIONARIO_ADMIN,
                   Perfil.ROLE_FUNCIONARIO_USER) //Consulta de produto

                .requestMatchers(HttpMethod.GET, "/api-docs/*").permitAll()
                .requestMatchers(HttpMethod.GET, "/swagger-ui/*").permitAll()

                //.requestMatchers(HttpMethod.GET, "/api/produto/").hasAnyAuthority(
                  //Perfil.ROLE_CLIENTE,
                   //Perfil.ROLE_FUNCIONARIO_ADMIN,
                   //Perfil.ROLE_FUNCIONARIO_USER) //Consulta de produto     
                   
                //.requestMatchers(HttpMethod.POST, "/api/produto").hasAnyAuthority(
                   //Perfil.ROLE_FUNCIONARIO_ADMIN,
                   //Perfil.ROLE_FUNCIONARIO_USER) //Cadastro de produto

               .requestMatchers(HttpMethod.PUT, "/api/produto/*").hasAnyAuthority(
                   Perfil.ROLE_FUNCIONARIO_ADMIN,
                   Perfil.ROLE_FUNCIONARIO_USER) //Alteração de produto
                  
               .requestMatchers(HttpMethod.DELETE, "/api/produto/*").hasAnyAuthority(
                   Perfil.ROLE_FUNCIONARIO_ADMIN) //Exclusão de produto

                .requestMatchers(HttpMethod.DELETE, "/api/entregador/*").hasAnyAuthority(
                    Perfil.ROLE_FUNCIONARIO_USER) //Exclusão de produto

                .anyRequest().authenticated()

            )
            .sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )            
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);
    
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);    
        return source;
    }
}
