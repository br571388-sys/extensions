import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class KartoonProvider : MainAPI() {
    override var mainUrl = "https://kartoons.me"
    override var name = "Kartoons"
    override val hasMainPage = true
    override var lang = "hi"
    override val supportedTypes = setOf(TvType.Cartoon, TvType.Anime)

    override suspend fun search(query: String): List<SearchResponse> {
        val searchUrl = "$mainUrl/?s=$query"
        val document = app.get(searchUrl).document
        val results = ArrayList<SearchResponse>()

        document.select("article, .result-item").forEach { element ->
            val title = element.selectFirst("h2, .title, .post-title")?.text() ?: return@forEach
            val url = element.selectFirst("a")?.attr("href") ?: return@forEach
            val poster = element.selectFirst("img")?.attr("src")

            results.add(
                newMovieSearchResponse(title, url, TvType.Cartoon) {
                    this.posterUrl = poster
                }
            )
        }
        return results
    }

    override suspend fun load(url: String): LoadResponse {
        val document = app.get(url).document
        
        val title = document.selectFirst("h1, .entry-title")?.text() ?: "No Title"
        val poster = document.selectFirst("img.wp-post-image")?.attr("src")
        val plot = document.selectFirst(".description, .entry-content p")?.text()

        return newMovieLoadResponse(title, url, TvType.Cartoon, url) {
            this.posterUrl = poster
            this.plot = plot
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        callback: (ExtractorLink) -> Unit,
        subtitleCallback: (SubtitleFile) -> Unit
    ): Boolean {
        val document = app.get(data).document
        
        document.select("iframe").forEach { iframe ->
            val videoUrl = iframe.attr("src")
            loadExtractor(videoUrl, data, subtitleCallback, callback)
        }
        return true
    }
}
