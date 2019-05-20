package br.com.wcisang.data.remote.source.product

import br.com.wcisang.domain.model.Produto

interface ProdutoRemoteDataSource {

    suspend fun getBestSellers() : List<Produto>
    suspend fun getProductList(categoryId: Int) : List<Produto>
    suspend fun getProductDetail(productId: Int) : Produto
    suspend fun reserveProduct(productId: Int)
}