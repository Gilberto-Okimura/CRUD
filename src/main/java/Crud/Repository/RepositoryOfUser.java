package Crud.Repository;

import Crud.Buissines.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface RepositoryOfUser extends JpaRepository<Usuario, Long> {

    Boolean existsByEmail(String Email);
    UserDetails findByEmail(String email);

}
