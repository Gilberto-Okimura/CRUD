package Crud.Buissines.Config;

import Crud.Buissines.Models.Curso;
import Crud.Buissines.Models.Topico;
import Crud.ModelsAndDTO.TopicoDTO;
import Crud.ModelsAndDTO.TopicoDTOPUT;
import Crud.Repository.RepositoryOfCurso;
import Crud.Repository.RepositoryOfTopic;
import Crud.Repository.RepositoryOfUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/topicos")
public class Controller {
   @Autowired
   private  RepositoryOfUser repositoryOfUser;
   @Autowired
   private RepositoryOfTopic repositoryOfTopic;
@Autowired
private RepositoryOfCurso repositoryOfCurso;

    @PostMapping
    @Transactional
    public ResponseEntity<String> CadastrarTopico(@Valid @RequestBody TopicoDTO topicoDTO){

        Curso curso = new Curso();
        curso.setNomecurso(topicoDTO.nomecurso());
        curso.setCategoria(topicoDTO.categoria());

        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.titulo());
        topico.setCorpo(topicoDTO.corpo());
        topico.setAutor_nome(topicoDTO.autor());
        topico.setStatus(topicoDTO.status());
        topico.setCurso(curso);


        if (repositoryOfTopic.
                existsByTituloAndCorpo(topicoDTO.titulo(), topicoDTO.corpo())){

            return ResponseEntity
                    .badRequest()
                    .body("Esse topico ja existe");
        }


        repositoryOfCurso.save(curso);
        repositoryOfTopic.save(topico);

//       if(repositoryOfUser)){
//          throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//          "Erro: Este tópico já existe!");
//      }
//
        return ResponseEntity.status(201).body("Tópico criado com sucesso");
    };

    @GetMapping
    public  List<TopicoDTO> topicoDTOList(){
        return repositoryOfTopic.listarTopicosComCurso()
                .stream()
                .toList();
    }

    @GetMapping("{idtopico}")

    public  List<TopicoDTO> topicoDTOListComid(@PathVariable Long idtopico){
        return repositoryOfTopic.findById(idtopico)
                .stream()
                .map(topico -> new TopicoDTO
                        (topico.getIdtopico(),         // Aqui foi pego o id e com o id, feito um mapeamento apra que ele podesse pegar a classe toda ou seja
                                                        //ele pega o topico id, e depois mapea com essas classes.
                                topico.getTitulo(),
                                topico.getCorpo(),
                                topico.getAutor_nome(),
                                topico.getStatus(),
                                topico.getCurso().getNomecurso(),
                                topico.getCategoria()

                ))
                .toList();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<String>atualizar(@Valid @RequestBody TopicoDTOPUT topicoDTOPUT, @PathVariable Long id){
        var ofTopicById = repositoryOfTopic.findById(id);
        ofTopicById.ifPresent(save -> save.putInfo(topicoDTOPUT));
        return ResponseEntity.ok("Dados atualizados com sucesso!");


    }
}


