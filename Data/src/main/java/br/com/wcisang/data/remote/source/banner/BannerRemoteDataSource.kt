package br.com.wcisang.data.remote.source.banner

import br.com.wcisang.data.remote.response.BannerResponse
import br.com.wcisang.domain.model.Banner
import kotlinx.coroutines.Deferred

interface BannerRemoteDataSource {

    suspend fun getBanners() : List<Banner>
}