package Crud.ModelsAndDTO;

import jakarta.validation.constraints.NotNull;

public record TopicoDTOPUT(
        @NotNull
                            Long id,
                            String titulo,
                            String corpo,
                            String autor,
                            Boolean status,
                            String nomecurso,
                            String categoria
) {
}
