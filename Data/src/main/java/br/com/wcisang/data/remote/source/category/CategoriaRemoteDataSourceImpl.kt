package br.com.wcisang.data.remote.source.category

import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.domain.model.Categoria

class CategoriaRemoteDataSourceImpl (
    var lodjinhaService: LodjinhaService
) : CategoriaRemoteDataSource {


    override suspend fun getCategorias(): List<Categoria> {
        return lodjinhaService.getCategorias().data
    }
}