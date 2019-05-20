package br.com.wcisang.domain.interactor.banner

import br.com.wcisang.domain.interactor.UseCase
import br.com.wcisang.domain.model.Banner
import br.com.wcisang.domain.repository.BannerRepository

open class GetBannersUseCase (
    var bannerRepository: BannerRepository
) : UseCase<List<Banner>, Nothing?>(){

    override suspend fun executeOnBackground(params: Nothing?): List<Banner> {
        return bannerRepository.getBanners()
    }

}