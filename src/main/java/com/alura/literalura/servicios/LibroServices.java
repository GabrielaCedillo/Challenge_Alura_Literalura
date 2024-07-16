package com.alura.literalura.servicios;

import com.alura.literalura.modelos.Libro;
import com.alura.literalura.repositorio.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LibroServices {
    @Autowired
    public ILibroRepository libroRepository;
    public List<String> obtenerIdiomasDistintos(){
        return libroRepository.findDistinctIdiomas();
    }
    public List<Libro> obtenerLibrosPorIdioma(String idioma){
        return libroRepository.findByIdioma(idioma);
    }
}
