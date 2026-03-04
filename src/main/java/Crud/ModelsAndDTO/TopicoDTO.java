package Crud.ModelsAndDTO;

public record TopicoDTO(
        Long id,
        String titulo,
        String corpo,
        String autor,
        Boolean status,
        String nomecurso,
        String categoria

) {}