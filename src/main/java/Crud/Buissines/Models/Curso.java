package Crud.Buissines.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Curso")
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcurso;

    @Getter
    @Setter
    @NotBlank(message = "cursO sem nome?")
   private String nomecurso;

    @Getter
    @Setter
    @NotNull
    private String categoria;


    @OneToMany(mappedBy = "curso")
    private List<Topico> topico = new ArrayList<>();


}
