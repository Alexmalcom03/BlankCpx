package com.BlankCpx.cpx;

import com.BlankCpx.cpx.models.Users;
import com.BlankCpx.cpx.repositories.UserRepository;
import com.BlankCpx.cpx.security.PasswordEncoderUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class CpxApplicationTests {

    @Autowired
    private UserRepository userRepository;
    


    
    
    @Test
     public void testCreateUser() {
        // Crea un usuario
        Users user = new Users();
        user.setName("Malcom");
        user.setPaternalSurname("Prado");
        user.setMaternalSurname("Vazquez");
        user.setEmail("user@example.com");
        user.setPassword("password");
        user.setToken("");
        Users retorno = userRepository.save(user);
       

        
        assertTrue(retorno.getId().equals(retorno.getId()));
    }


}
