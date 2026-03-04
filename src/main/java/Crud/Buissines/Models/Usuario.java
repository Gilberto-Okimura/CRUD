package Crud.Buissines.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_tb")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long usuarioid;

    @Getter
    @Setter
    @NotNull
    private String nome;

    @Getter
    @Setter
    @NotNull
    private  String email;

    @Getter
    @Setter
    @NotNull
    private  String senha;

    @Getter
    @Setter
    @NotNull
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Perfil> perfis;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<Perfil> perfisList = new ArrayList<>();


}
