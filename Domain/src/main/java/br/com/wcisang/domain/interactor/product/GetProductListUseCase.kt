package br.com.wcisang.domain.interactor.product

import br.com.wcisang.domain.interactor.UseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository

class GetProductListUseCase constructor(
    val produtoRepository: ProdutoRepository
): UseCase<List<Produto>, GetProductListUseCase.Params>(){


    override suspend fun executeOnBackground(params: Params?): List<Produto> {
        if (params == null) throw IllegalArgumentException("params cannot be null")
        return produtoRepository.getProductList(params.categoryId)
    }

    data class Params constructor(val categoryId: Int) {
        companion object {
            fun forProducts(categoryId: Int) : Params {
                return Params(categoryId)
            }
        }
    }
}