package br.com.wcisang.data.remote.source.category

import br.com.wcisang.domain.model.Categoria
import kotlinx.coroutines.Deferred

interface CategoriaRemoteDataSource {

    suspend fun getCategorias() : List<Categoria>
}