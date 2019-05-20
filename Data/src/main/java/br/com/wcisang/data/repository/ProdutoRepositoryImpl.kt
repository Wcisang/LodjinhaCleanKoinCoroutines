package br.com.wcisang.data.repository

import br.com.wcisang.data.remote.source.product.ProdutoRemoteDataSource
import br.com.wcisang.domain.model.Produto
import br.com.wcisang.domain.repository.ProdutoRepository

class ProdutoRepositoryImpl (
    var produtoRemoteDataSource: ProdutoRemoteDataSource
): ProdutoRepository {


    override suspend fun reserveProduct(productId: Int) {
        return produtoRemoteDataSource.reserveProduct(productId)
    }

    override suspend fun getProductDetail(productId: Int): Produto {
        return produtoRemoteDataSource.getProductDetail(productId)
    }

    override suspend fun getProductList(categoryId: Int): List<Produto> {
        return produtoRemoteDataSource.getProductList(categoryId)
    }

    override suspend fun getBestSellers(): List<Produto> {
        return produtoRemoteDataSource.getBestSellers()
    }
}