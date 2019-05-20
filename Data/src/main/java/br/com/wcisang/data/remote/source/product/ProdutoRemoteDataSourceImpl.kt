package br.com.wcisang.data.remote.source.product

import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.domain.model.Produto
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader

class ProdutoRemoteDataSourceImpl (
    val lodjinhaService: LodjinhaService
) : ProdutoRemoteDataSource{

    override suspend fun reserveProduct(productId: Int) {
        return lodjinhaService.reserveProduct(productId)
    }


    override suspend fun getProductDetail(productId: Int): Produto {
        return lodjinhaService.getProductDetail(productId)
    }

    override suspend fun getBestSellers(): List<Produto> {
        return lodjinhaService
            .getBestSellingProducts().data
    }

    override suspend fun getProductList(categoryId: Int): List<Produto> {
        return lodjinhaService.getProducts(categoryId).data
    }
}