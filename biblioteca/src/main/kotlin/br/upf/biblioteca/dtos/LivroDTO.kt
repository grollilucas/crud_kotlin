package br.upf.biblioteca.dtos

import jakarta.validation.constraints.NotEmpty

data class LivroDTO (
    @field:NotEmpty(message = "NOME do livro não pode ficar em branco!")
    val nome: String,
    @field:NotEmpty(message = "AUTOR não pode ficar em branco!")
    val autor: String
)