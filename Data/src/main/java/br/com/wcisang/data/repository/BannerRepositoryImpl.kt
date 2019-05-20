package br.com.wcisang.data.repository

import br.com.wcisang.data.remote.source.banner.BannerRemoteDataSource
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.repository.BannerRepository

class BannerRepositoryImpl (
    var bannerRemoteDataSource: BannerRemoteDataSource
): BannerRepository {

    override suspend fun getBanners(): List<Banner> {
        return bannerRemoteDataSource.getBanners()
    }

}