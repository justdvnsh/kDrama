package divyansh.tech.kdrama.home.datamodels

import divyansh.tech.kdrama.home.HomeViewModel

data class HomeCustomResponseModel(
    val list: ArrayList<DramaResponse>
)

data class DramaResponse(
    val type: HomeViewModel.HomeResponseType,
    val items: ArrayList<Drama>
)