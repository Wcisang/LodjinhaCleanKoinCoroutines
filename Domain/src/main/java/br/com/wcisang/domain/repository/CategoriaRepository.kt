package br.com.wcisang.domain.repository

import br.com.wcisang.domain.model.Categoria
import kotlinx.coroutines.Deferred

interface CategoriaRepository {

    suspend fun getCategorias() : List<Categoria>
}