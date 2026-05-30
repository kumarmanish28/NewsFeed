package com.mktech.newsfeed.articles

import com.mktech.newsfeed.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())
    val articlesState: StateFlow<ArticlesState>
        get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            _articlesState.emit(ArticlesState(loading = true))
            val fetchArticles = fetchArticles()
            delay(3000)
            _articlesState.emit(ArticlesState(articles = fetchArticles))
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(

        Article(
            title = "Google I/O 2026 Highlights AI Innovations",
            desc = "Google announced major Gemini AI upgrades, Android XR developments, and next-generation AI tools for developers.",
            date = "30 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1573804633927-bfcbcd909acd"
        ),

        Article(
            title = "Android 16 Brings New Security Features",
            desc = "Android 16 introduces advanced privacy controls, anti-theft protection, and improved system performance.",
            date = "29 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1607252650355-f7fd0460ccdb"
        ),

        Article(
            title = "OpenAI Expands AI Coding Capabilities",
            desc = "New AI coding tools are helping developers write, debug, and optimize applications faster than ever.",
            date = "28 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1516321318423-f06f85e504b3"
        ),

        Article(
            title = "SpaceX Successfully Deploys Satellites",
            desc = "SpaceX completed another satellite launch mission to improve global internet connectivity.",
            date = "27 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1517976547714-720226b864c1"
        ),

        Article(
            title = "Global AI Market Continues Rapid Growth",
            desc = "Businesses worldwide are investing heavily in AI technologies and automation solutions.",
            date = "26 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1485827404703-89b55fcc595e"
        ),

        Article(
            title = "India Accelerates Nationwide 5G Expansion",
            desc = "Telecom companies continue deploying 5G infrastructure across major cities and rural regions.",
            date = "25 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1526378722484-bd91ca387e72"
        ),

        Article(
            title = "Scientists Reveal New Battery Technology",
            desc = "Researchers developed a battery capable of faster charging and significantly longer lifespan.",
            date = "24 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1593941707882-a5bac6861d75"
        ),

        Article(
            title = "Cybersecurity Experts Warn About New Threats",
            desc = "Security specialists recommend stronger authentication and regular software updates.",
            date = "23 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1563013544-824ae1b704d3"
        ),

        Article(
            title = "Electric Vehicles Gain Massive Adoption",
            desc = "Automobile manufacturers continue expanding EV production to meet rising demand.",
            date = "22 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1553440569-bcc63803a83d"
        ),

        Article(
            title = "Jetpack Compose Dominates Android Development",
            desc = "More Android developers are moving toward Compose for modern declarative UI development.",
            date = "21 May 2026",
            imageUrl = "https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c"
        )
    )

}