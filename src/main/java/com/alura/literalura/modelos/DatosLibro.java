package com.alura.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibro(@JsonAlias("id") int idLibro,
                         @JsonAlias("title") String titulo,
                         @JsonAlias("download_count") Integer totalDeDescargas) {
}
