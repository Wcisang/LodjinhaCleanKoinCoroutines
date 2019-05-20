package br.com.wcisang.lodjinhacleankoincoroutines.di

import br.com.wcisang.data.remote.service.LodjinhaServiceFactory
import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSource
import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSourceImpl
import br.com.wcisang.data.remote.source.category.CategoriaRemoteDataSource
import br.com.wcisang.data.remote.source.category.CategoriaRemoteDataSourceImpl
import br.com.wcisang.data.remote.source.product.ProdutoRemoteDataSource
import br.com.wcisang.data.remote.source.product.ProdutoRemoteDataSourceImpl
import br.com.wcisang.data.repository.BannerRepositoryImpl
import br.com.wcisang.data.repository.CategoriaRepositoryImpl
import br.com.wcisang.data.repository.ProdutoRepositoryImpl
import br.com.wcisang.domain.interactor.banner.GetBannersUseCase
import br.com.wcisang.domain.interactor.categoria.GetCategoriasUseCase
import br.com.wcisang.domain.interactor.product.GetProductDetailUseCase
import br.com.wcisang.domain.interactor.product.GetProductListUseCase
import br.com.wcisang.domain.interactor.product.GetProdutosBestSellersUseCase
import br.com.wcisang.domain.interactor.product.ReserveProductUseCase
import br.com.wcisang.domain.repository.BannerRepository
import br.com.wcisang.domain.repository.CategoriaRepository
import br.com.wcisang.domain.repository.ProdutoRepository
import br.com.wcisang.lodjinhacleankoincoroutines.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { HomeViewModel(get(), get(), get()) }
}

val repositoryModule : Module = module {
    single<BannerRepository> { BannerRepositoryImpl(get()) }
    single<CategoriaRepository> { CategoriaRepositoryImpl(get()) }
    single<ProdutoRepository> { ProdutoRepositoryImpl(get()) }
}

val useCaseModule : Module = module {
    factory { GetBannersUseCase(get()) }
    factory { GetCategoriasUseCase(get()) }
    factory { GetProductDetailUseCase(get()) }
    factory { GetProductListUseCase(get()) }
    factory { GetProdutosBestSellersUseCase(get()) }
    factory { ReserveProductUseCase(get()) }
}

val dataSourceModule : Module = module {
    single<BannerRemoteDataSource> { BannerRemoteDataSourceImpl(get()) }
    single<CategoriaRemoteDataSource> { CategoriaRemoteDataSourceImpl(get()) }
    single<ProdutoRemoteDataSource> { ProdutoRemoteDataSourceImpl(get()) }
}

val networkModule : Module = module {
    single { LodjinhaServiceFactory.makeLodjinhaService() }
}

