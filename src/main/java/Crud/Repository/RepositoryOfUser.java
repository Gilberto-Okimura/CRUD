package Crud.Repository;

import Crud.Buissines.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOfUser extends JpaRepository<Usuario, Long> {
}
