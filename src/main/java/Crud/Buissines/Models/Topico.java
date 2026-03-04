package Crud.Buissines.Models;

import Crud.ModelsAndDTO.TopicoDTOPUT;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "topicos"
)


public class Topico {

    @Id
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idtopico;

    @Setter
    @Getter
    @NotBlank
    @Column(name = "autornome")
    private String autor_nome;

    @Setter
    @Getter
    @NotBlank(message = "Titulo vazio, vai postar sobre nada?")
    private String titulo;

    @Setter
    @Getter
    private String corpo;


    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Getter
    @Setter
    Boolean status;

    @Getter
    @Setter
    String categoria;

    @Setter
    @Getter
   private LocalDate datalocal = LocalDate.now();

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas = new ArrayList<>();

    public void putInfo(@Valid TopicoDTOPUT topicoDTOPUT) {
        if (topicoDTOPUT.status() == true) {
            this.status = true;
        }
        if (topicoDTOPUT.autor() != null) {
            this.autor_nome = topicoDTOPUT.autor();
        }
        if (topicoDTOPUT.titulo() != null) {
            this.titulo = topicoDTOPUT.titulo();
        }
        if (topicoDTOPUT.corpo() != null) {
            this.corpo = topicoDTOPUT.corpo();
        }

        if (topicoDTOPUT.nomecurso() != null) {
            this.curso.setNomecurso(topicoDTOPUT.nomecurso());
        }
        if (topicoDTOPUT.nomecurso() != null || topicoDTOPUT.categoria() != null) {
            if (this.curso == null) {
                this.curso = new Curso();
            }
            if (topicoDTOPUT.nomecurso() != null) {
                this.curso.setNomecurso(topicoDTOPUT.nomecurso());
            }

            if (topicoDTOPUT.categoria() != null) {
                this.curso.setCategoria(topicoDTOPUT.categoria());
            }
        }
    }
}
