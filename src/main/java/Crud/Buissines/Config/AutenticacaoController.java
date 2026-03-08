package Crud.Buissines.Config;

import Crud.Buissines.Models.DadosTokenjtwDTO;
import Crud.Buissines.Models.Usuario;
import Crud.Buissines.Security.TokenService;
import Crud.ModelsAndDTO.UserDTOFORAUTH;
import Crud.Repository.RepositoryOfUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private RepositoryOfUser repositoryOfUser;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarelogin(@RequestBody @Valid UserDTOFORAUTH auth) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(auth.email(), auth.senha());

            var authentication = manager.authenticate(authToken);

            var jwt = tokenService.gerartoken(auth.email());


            return ResponseEntity.ok(new DadosTokenjtwDTO(jwt));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
