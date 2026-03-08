package Crud.Buissines.Config;

import Crud.Buissines.Models.Usuario;
import Crud.ModelsAndDTO.USUARIODTO;
import Crud.Repository.RepositoryOfUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class ControllerUsers {
    @Autowired
    private RepositoryOfUser repositoryOfUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<String> cadastrarUser(@Valid @RequestBody USUARIODTO USER){

        Usuario usuario = new Usuario();
        usuario.setNome(USER.nome());
        usuario.setEmail(USER.email());
        usuario.setSenha(passwordEncoder.encode(USER.senha()));

        if(repositoryOfUser.existsByEmail(USER.email())){
            return ResponseEntity
                    .badRequest()
                    .body("Esse Usuario ja existe");
        }

        repositoryOfUser.save(usuario);

        return ResponseEntity.status(201).body("Usuario criado com sucesso");
    }
}

