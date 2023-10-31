package br.upf.biblioteca.service

import br.upf.biblioteca.converter.LivroConverter
import br.upf.biblioteca.dtos.LivroDTO
import br.upf.biblioteca.dtos.LivroResponseDTO
import br.upf.biblioteca.exceptions.NotFoundException
import br.upf.biblioteca.model.Livro
import br.upf.biblioteca.repository.LivroRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


private const val LIVRO_NOT_FOUND_MESSAGE = "Livro não encontrado!"

@Service
class LivroService (private val repository: LivroRepository,
    private val converter: LivroConverter, ){



    fun listar(
        nomeEvento: String?,
        paginacao: Pageable): Page<LivroResponseDTO> {
        val eventos = if (nomeEvento == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeEvento, paginacao)
        }
        return eventos
            .map(converter::toLivroResponseDTO)
    }

    fun buscarPorId(id: Long): LivroResponseDTO{
        val livro = repository.findById(id)
            .orElseThrow{NotFoundException(LIVRO_NOT_FOUND_MESSAGE)}
        return converter.toLivroResponseDTO(livro)
    }

    fun cadastrar(dto: LivroDTO):LivroResponseDTO {
        return converter.toLivroResponseDTO(
            repository.save(converter.toLivro(dto)))

    }

    fun atualizar(id: Long, dto: LivroDTO):LivroResponseDTO {
        val livro = repository.findById(id)
            .orElseThrow { NotFoundException(LIVRO_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                autor = dto.autor
            )
        return converter.toLivroResponseDTO(repository.save(livro))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

}