package br.com.wcisang.data.repository

import br.com.wcisang.data.remote.source.category.CategoriaRemoteDataSource
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.repository.CategoriaRepository
import kotlinx.coroutines.Deferred


class CategoriaRepositoryImpl (
    var categoriaRemoteDataSource: CategoriaRemoteDataSource
): CategoriaRepository {


    override suspend fun getCategorias(): List<Categoria> {
        return categoriaRemoteDataSource.getCategorias()
    }
}