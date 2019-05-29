package br.com.wcisang.lodjinhacleankoincoroutines.ui.home

import br.com.wcisang.domain.interactor.banner.GetBannersUseCase
import br.com.wcisang.domain.interactor.categoria.GetCategoriasUseCase
import br.com.wcisang.domain.interactor.product.GetProdutosBestSellersUseCase
import br.com.wcisang.lodjinhacleankoincoroutines.CoroutinesTestRule
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.*
import org.junit.Rule
import org.junit.Test


class HomeViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    var getBanners = mock<GetBannersUseCase>()
    var getCategorias = mock<GetCategoriasUseCase>()
    var getBestSellers = mock<GetProdutosBestSellersUseCase>()
    var viewModel = HomeViewModel(getBanners, getCategorias, getBestSellers)

    @Test
    fun getBannersExecutesUseCase() {
        viewModel.getBanners()
        runBlocking {
            verify(getBanners, times(1)).execute(eq(null))
        }
    }

    @Test
    fun getCategoriasExecutesUseCase() {
        viewModel.getCategorias()
        runBlocking {
            verify(getCategorias, times(1)).execute(eq(null))
        }
    }

    @Test
    fun getBestSellersExecutesUseCase() {
        viewModel.getBestSellers()
        runBlocking {
            verify(getCategorias, times(1)).execute(eq(null))
        }
    }

}