package divyansh.tech.kdrama.home.datamodels

data class Drama(
    val title: String,
    val url: String,
    val imageUrl: String
)

data class MetaDrama(
    val title: String,
    val url: String,
    val imageUrl: String,
    val episodeNumber: String,
    val updatedTime: String
)
