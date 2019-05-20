package br.com.wcisang.domain.repository

import br.com.wcisang.domain.model.Produto
import kotlinx.coroutines.Deferred

interface ProdutoRepository {

    suspend fun getBestSellers() : List<Produto>

    suspend fun getProductList(categoryId: Int) : List<Produto>

    suspend fun getProductDetail(productId: Int) : Produto

    suspend fun reserveProduct(productId: Int)
}