package br.com.wcisang.domain.interactor.product

import br.com.wcisang.domain.interactor.UseCase
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository

open class GetProdutosBestSellersUseCase (
    var produtoRepository: ProdutoRepository
): UseCase<List<Produto>, Nothing?>(){


    override suspend fun executeOnBackground(params: Nothing?): List<Produto> {
        return produtoRepository.getBestSellers()
    }

}