package it.sincon.p2_presentazione_istanze_v2.springconfigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public RestTemplate restTemplate() {
       return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
       return new ObjectMapper();
    }

   //  @Bean
   //  public LoginVM SigeoAdministrator(@Value("${application.administrator.username}") String username,
   //                                    @Value("${application.administrator.password}") String password) {
   //      LoginVM loginDTO = new LoginVM();
   //      loginDTO.setUsername(username);
   //      loginDTO.setPassword(password);
   //      loginDTO.setRememberMe(true);
   //      return loginDTO;
   //  }
    

}
