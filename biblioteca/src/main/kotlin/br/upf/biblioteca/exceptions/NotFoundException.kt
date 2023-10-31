package br.upf.biblioteca.exceptions

class NotFoundException (override val message: String)
    : RuntimeException()