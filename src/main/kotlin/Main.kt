import entities.Text
import utils.*
import java.io.File
import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val text = parseForText(File("textForLab3.txt").readText())
        val locale = Locale.Builder().setLanguage("en")
                .setRegion("US")
                .build()
        val res = ResourceBundle.getBundle("language", locale)
        println(res.getString("text_default"))
        println(buildTextString(text))
        println(res.getString("text_formatted"))
        println(buildTextString(Text(sortSentences(text))))
        println(res.getString("search_word"))
        println(searchWord(text))
    }
}