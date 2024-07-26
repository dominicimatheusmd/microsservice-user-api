package br.com.business.project.javamicrosservice.controller;


import br.com.business.project.javamicrosservice.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public static List<UserDTO> users = new ArrayList<UserDTO>();


    @PostConstruct
    public void initiateList(){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Carlos Eduardo");
        userDTO.setCpf("695319421355");
        userDTO.setTelefone("114697238540");
        userDTO.setEndereco("Rua das vertentes");
        userDTO.setEmail("carlos.eduardo@gmail.com");
        userDTO.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Bruno Henrique");
        userDTO2.setCpf("695459421366");
        userDTO2.setTelefone("114697236540");
        userDTO2.setEndereco("Rua das alegrias");
        userDTO2.setEmail("bruno.henrique@gmail.com");
        userDTO2.setDataCadastro(LocalDateTime.now());

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Gabriel Barbosa");
        userDTO3.setCpf("695459421366");
        userDTO3.setEmail("gabriel.barbosa@gmail.com");
        userDTO3.setEndereco("Rua dos pindamonhagabos");
        userDTO3.setTelefone("14968421683546");
        userDTO3.setDataCadastro(LocalDateTime.now());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);
    }

    @GetMapping("/{cpf}")
    public UserDTO getUser(@PathVariable String cpf){
        return users.stream().filter(userDTO -> userDTO.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("User not found"));
    }
    @GetMapping
    public List<UserDTO> getUsers(){
        return users;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO insert(@RequestBody @Valid UserDTO userDTO){
        userDTO.setDataCadastro(LocalDateTime.now());
        users.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean deleteUser(@PathVariable String cpf){
        return users.removeIf(userDTO -> userDTO.getCpf().equals(cpf));
    }

}
