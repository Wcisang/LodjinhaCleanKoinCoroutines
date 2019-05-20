package br.com.wcisang.domain.repository

import br.com.wcisang.domain.model.Banner

interface BannerRepository {

    suspend fun getBanners() : List<Banner>
}