package br.com.business.project.javamicrosservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "O nome é obrigatório!")
    private String nome;
    @NotBlank(message = "O CPF é obrigatório!")
    private String cpf;
    private String endereco;
    private String telefone;
    @NotBlank(message = "O E-mail é obrigatório!")
    private String email;
    private LocalDateTime dataCadastro;
}
