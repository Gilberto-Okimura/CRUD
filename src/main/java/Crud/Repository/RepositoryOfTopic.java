package Crud.Repository;

import Crud.Buissines.Models.Curso;
import Crud.Buissines.Models.Topico;
import Crud.ModelsAndDTO.CursoDTO;
import Crud.ModelsAndDTO.TopicoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface RepositoryOfTopic extends JpaRepository<Topico, Long> {

    boolean existsByTituloAndCorpo(String titulo, String corpo);

    @Query("""
       SELECT new Crud.ModelsAndDTO.TopicoDTO(
            t.idtopico,
            t.titulo,
            t.corpo,
            t.autor_nome,
            t.status,
            t.curso.nomecurso,
            t.categoria
       )
       FROM Topico t
    """)
    List<TopicoDTO> listarTopicosComCurso();


}