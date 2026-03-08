package Crud.Buissines.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Perfil{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @JoinColumn(name = "perfil_id")
    Long perfil_id;

        @Getter
        @Setter
        @NotNull
        private String name;

    @OneToMany(mappedBy = "perfis")
    private List<Usuario> userlist  = new ArrayList<>();   ;

}
