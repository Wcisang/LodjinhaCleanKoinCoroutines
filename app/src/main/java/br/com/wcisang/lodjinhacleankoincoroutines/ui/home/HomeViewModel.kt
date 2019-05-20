package br.com.wcisang.lodjinhacleankoincoroutines.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wcisang.domain.interactor.Resource
import br.com.wcisang.domain.interactor.banner.GetBannersUseCase
import br.com.wcisang.domain.interactor.categoria.GetCategoriasUseCase
import br.com.wcisang.domain.interactor.product.GetProdutosBestSellersUseCase
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.model.Categoria
import br.com.wcisang.domain.model.Produto
import kotlinx.coroutines.launch

class HomeViewModel (
    private var getBannersUseCase: GetBannersUseCase,
    private var getCategoriasUseCase: GetCategoriasUseCase,
    private var getProdutosBestSellersUseCase: GetProdutosBestSellersUseCase
): ViewModel(){

    var bannersLiveData = MutableLiveData<Resource<List<Banner>>>()
    var categoriaLiveData = MutableLiveData<Resource<List<Categoria>>>()
    var produtoLiveData = MutableLiveData<Resource<List<Produto>>>()

    fun getBanners() {
        bannersLiveData.postValue(Resource.loading())
        viewModelScope.launch {
            bannersLiveData.postValue(getBannersUseCase.execute())
        }
    }

    fun getCategorias() {
        categoriaLiveData.postValue(Resource.loading())
        viewModelScope.launch {
            categoriaLiveData.postValue(getCategoriasUseCase.execute())
        }
    }

    fun getBestSellers() {
        produtoLiveData.postValue(Resource.loading())
        viewModelScope.launch {
            produtoLiveData.postValue(getProdutosBestSellersUseCase.execute())
        }
    }

}