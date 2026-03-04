package Crud.Buissines.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "resposta_tb"
)
@AllArgsConstructor
@NoArgsConstructor
public class Resposta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long Id_resposta;

    @NotNull
    @Getter
    @Setter
    private String mensagem;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @Getter
    @Setter
    @NotNull
    private Boolean solution;


}
