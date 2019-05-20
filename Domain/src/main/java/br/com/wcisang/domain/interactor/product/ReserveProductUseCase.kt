package br.com.wcisang.domain.interactor.product

import br.com.wcisang.domain.interactor.CompletableUseCase
import br.com.wcisang.domain.repository.ProdutoRepository

open class ReserveProductUseCase (
    val productRepository: ProdutoRepository
): CompletableUseCase<ReserveProductUseCase.Params>(){

    override suspend fun executeCompletableOnBackground(params: Params?) {
        if (params == null) throw IllegalArgumentException("params cannot be null")
        productRepository.reserveProduct(params.productId)
    }

    data class Params constructor(var productId: Int) {
        companion object {
            fun forProject(productId: Int) : Params{
                return Params(productId)
            }
        }
    }
}