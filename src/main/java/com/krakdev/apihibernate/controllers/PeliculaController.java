package com.krakdev.apihibernate.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krakdev.apihibernate.entidades.Pelicula;
import com.krakdev.apihibernate.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private ServicioPelicula servicioPelicula;

    @PostMapping
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula pelicula) {
        Pelicula nueva = servicioPelicula.crear(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @GetMapping
    public ResponseEntity<List<Pelicula>> listar() {
        List<Pelicula> lista = servicioPelicula.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPorId(@PathVariable Long id) {
        Pelicula p = servicioPelicula.buscarPorId(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        pelicula.setId(id);
        Pelicula actualizada = servicioPelicula.actualizar(pelicula);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        boolean eliminado = servicioPelicula.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok("Película eliminada con éxito");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Película no encontrada");
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Pelicula>> buscarPorGenero(@RequestParam String genero) {
        List<Pelicula> lista = servicioPelicula.buscarPorGenero(genero);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/disponible")
    public ResponseEntity<List<Pelicula>> buscarPorDisponible(@RequestParam boolean disponible) {
        List<Pelicula> lista = servicioPelicula.buscarPorDisponible(disponible);
        return ResponseEntity.ok(lista);
    }
}