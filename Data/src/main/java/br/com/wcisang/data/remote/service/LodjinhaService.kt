package br.com.wcisang.data.remote.service

import br.com.wcisang.data.remote.response.*
import br.com.wcisang.domain.model.Produto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LodjinhaService {

    @GET("/banner")
    suspend fun getBanners(): BannerResponse

    @GET("/categoria")
    suspend fun getCategorias(): CategoriasResponse

    @GET("/produto/maisvendidos")
    suspend fun getBestSellingProducts(): ProdutoBestSellersResponse

    @GET("/produto")
    suspend fun getProducts(
        @Query("categoriaId") categoryId: Int
    ): ProductsResponse

    @GET("/produto/{produtoId}")
    suspend fun getProductDetail(@Path("produtoId") productId: Int): Produto

    @POST("/produto/{produtoId}")
    suspend fun reserveProduct(@Path("produtoId") productId: Int)
}