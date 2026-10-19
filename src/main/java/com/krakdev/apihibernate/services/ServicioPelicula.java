package com.krakdev.apihibernate.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakdev.apihibernate.entidades.Pelicula;
import com.krakdev.apihibernate.repository.PeliculaRepository;

@Service
public class ServicioPelicula {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public Pelicula crear(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<Pelicula> listar() {
        return peliculaRepository.findAll();
    }

    public Pelicula buscarPorId(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula actualizar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public boolean eliminar(Long id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Pelicula> buscarPorGenero(String genero) {
        return peliculaRepository.findByGenero(genero);
    }

    public List<Pelicula> buscarPorDisponible(boolean disponible) {
        return peliculaRepository.findByDisponible(disponible);
    }
}