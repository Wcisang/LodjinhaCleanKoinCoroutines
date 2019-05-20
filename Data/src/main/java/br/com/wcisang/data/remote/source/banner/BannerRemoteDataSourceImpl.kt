package br.com.wcisang.data.remote.source.banner

import br.com.wcisang.data.remote.service.LodjinhaService
import br.com.wcisang.domain.model.Banner

class BannerRemoteDataSourceImpl(
    var service: LodjinhaService
) : BannerRemoteDataSource {

    override suspend fun getBanners(): List<Banner> {
        return service.getBanners().data
    }
}