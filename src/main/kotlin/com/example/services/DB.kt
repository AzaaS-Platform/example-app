package com.example.services

import com.example.data.Article
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class DB {
    val articles: MutableList<Article> = mutableListOf()

    val nextIndex: Int
        get() = articles.size + 1

    init {
        articles.add(
            Article(
                nextIndex,
                "Lorem ipsum",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ut quam eu metus auctor cursus. Duis porttitor lectus ante, vel rhoncus ligula dictum quis. Integer eu libero sed nibh fringilla sollicitudin dapibus vitae orci.",
                true
            )
        )
        articles.add(
            Article(
                nextIndex,
                "Nullam lacinia nunc",
                "Nullam lacinia nunc vel turpis ullamcorper, et mattis nibh volutpat. Maecenas eu lacinia turpis, commodo vestibulum dui. Praesent sollicitudin magna eget dui pretium, ac vestibulum neque sollicitudin. Sed vel massa pulvinar, tincidunt nisi sed, eleifend lorem.",
                true
            )
        )
        articles.add(
            Article(
                nextIndex,
                "Proin a sem quis massa sollicitudin interdum.",
                "Aliquam lacinia mi sapien, pulvinar consequat neque pretium quis. Praesent sem ex, tincidunt at dapibus sed, tempor at tortor. Ut tempus lectus vel dolor vulputate, non pharetra arcu tincidunt. Nulla facilisis, magna vel rutrum bibendum, lectus sapien porta orci, quis tempus augue tellus nec tellus."
            )
        )
        articles.add(
            Article(
                nextIndex,
                "Curabitur sollicitudin",
                "Curabitur sollicitudin, ipsum facilisis varius gravida, ante massa rutrum nunc, ut consequat neque diam a ligula. Etiam sem enim, consequat vitae sodales id, posuere et velit. Etiam eleifend erat metus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed massa diam, pellentesque ut aliquam id, pellentesque non ipsum.",
                true
            )
        )
        articles.add(
            Article(
                nextIndex,
                "Pellentesque eu sapien",
                "Pellentesque eu sapien eget libero posuere volutpat sit amet eget nibh. Vivamus venenatis rhoncus massa in convallis. Nulla facilisi. Ut malesuada ligula a lacus consequat varius. Mauris non fringilla tellus. Donec auctor id diam nec tempus. Sed auctor nunc lorem, non ullamcorper erat pharetra non.",
                true
            )
        )
    }

    fun getArticle(id: Int): Article {
        return articles.find { it.id == id } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found")
    }

    fun addArticle(article: Article) {
        articles.add(article)
    }

    fun removeArticle(id: Int) {
        articles.removeAll { it.id == id }
    }
}