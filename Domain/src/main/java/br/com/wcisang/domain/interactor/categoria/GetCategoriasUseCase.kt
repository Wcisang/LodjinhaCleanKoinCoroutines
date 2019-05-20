package br.com.wcisang.domain.interactor.categoria

import br.com.wcisang.domain.interactor.UseCase
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.repository.CategoriaRepository

open class GetCategoriasUseCase (
    private val categoriaRepository: CategoriaRepository
) : UseCase<List<Categoria>, Nothing?>() {

    override suspend fun executeOnBackground(params: Nothing?): List<Categoria> {
        return categoriaRepository.getCategorias()
    }

}