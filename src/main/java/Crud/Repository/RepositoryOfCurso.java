package Crud.Repository;

import Crud.Buissines.Models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface RepositoryOfCurso extends JpaRepository<Curso, Long> {
   Optional<Curso> findByNomecurso(String nomecurso);


}
