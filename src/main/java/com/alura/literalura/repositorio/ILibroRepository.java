package com.alura.literalura.repositorio;

import com.alura.literalura.modelos.Autor;
import com.alura.literalura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ILibroRepository extends JpaRepository<Libro,Long> {
    //Metodos CRUD
    //Metodos personalizamos, top 10 descargas, idioma, encontrar libro, por su titulo, id, autor, etc.
    List<String> findDistinctIdiomaBy();

    @Query("SELECT l FROM Libro l ORDER BY l.totalDeDescargas DESC LIMIT 10")
    List<Libro> findTop10Descargados();

    @Query("SELECT l FROM Libro l WHERE l.titulo = :title")
    Optional<Libro> findByTitulo(String title);

    Optional<Libro> findById(long id);
    List<Libro> findByAutorIdAutor(Long idAutor);

    Optional<Libro> findLibroByTitulo(String titulo);

    @Query("SELECT DISTINCT l.idioma FROM Libro l")
    List<String> findDistinctIdiomas();

    @Query("SELECT l FROM Libro l WHERE l.idioma = :language")
    List<Libro> findByIdioma(String language);

    @Query("SELECT l FROM Libro l WHERE l.autor = :autor")
    List<Libro> findLibrosByAutor(Autor autor);
}


