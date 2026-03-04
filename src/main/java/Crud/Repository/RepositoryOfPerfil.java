package Crud.Repository;

import Crud.Buissines.Models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOfPerfil extends JpaRepository<Perfil, Long> {
}
