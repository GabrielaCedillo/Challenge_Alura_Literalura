package com.alura.literalura.servicios;

import com.alura.literalura.modelos.Autor;
import com.alura.literalura.repositorio.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AutorServices {
    @Autowired
    private IAutorRepository autorRepository;
    public List<Autor> getAutoresVivosPorAno(int year){
        return autorRepository.findAutorByFecha(year);
    }
    //Mandamos a llamar al metodo findAutorByFecha que busca y devuelve una lista de autores con fecha de defunción  posterior al año especificado y  fecha de nacimiento es anterior

}
