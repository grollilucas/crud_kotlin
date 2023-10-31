package br.upf.biblioteca.converter

import br.upf.biblioteca.dtos.LivroDTO
import br.upf.biblioteca.dtos.LivroResponseDTO
import br.upf.biblioteca.model.Livro
import org.springframework.stereotype.Component

@Component
class LivroConverter {
    fun toLivro(dto: LivroDTO): Livro{
        return Livro(
            nome = dto.nome,
            autor = dto.autor
        )
    }

    fun toLivroResponseDTO(livro: Livro): LivroResponseDTO{
        return LivroResponseDTO(
            id = livro.id,
            nome = livro.nome,
            autor = livro.autor
        )
    }
}