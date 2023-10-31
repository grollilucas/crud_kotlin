package br.upf.biblioteca.repository

import br.upf.biblioteca.model.Autor
import br.upf.biblioteca.model.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AutorRepository: JpaRepository<Autor, Long> {

}