package br.com.wcisang.domain.interactor.product

import br.com.wcisang.domain.interactor.UseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository

open class GetProductDetailUseCase (
    val produtoRepository: ProdutoRepository
): UseCase<Produto, GetProductDetailUseCase.Params>() {

    override suspend fun executeOnBackground(params: Params?): Produto {
        if (params == null) throw IllegalArgumentException("params cannot be null")
        return produtoRepository.getProductDetail(params.productId)
    }

    data class Params constructor(val productId : Int){
        companion object {
           fun forProject(productId: Int) : Params {
               return Params(productId)
           }
        }
    }
}