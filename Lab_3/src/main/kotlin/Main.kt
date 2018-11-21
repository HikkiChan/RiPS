import entities.Text
import utils.*
import java.io.File
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger

object Main {
    private var logger: Logger? = null

    @JvmStatic
    fun main(args: Array<String>) {
        logger = Logger.getLogger("Lab3")
        val file = File("textForLab3.txt")
        val text: Text?

        try {
            val stringOfFile = file.readText()
            if (stringOfFile == "") {
                logger?.log(Level.SEVERE, "File is empty")
                return
            }
            text = parseForText(stringOfFile)
        } catch (error: Throwable) {
            logger?.log(Level.SEVERE, error.message)
            return
        }

        val locale = Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build()
        val res: ResourceBundle?

        try {
            res = ResourceBundle.getBundle("language", locale)
        } catch (error: Throwable) {
            logger?.log(Level.SEVERE, error.message)
            return
        }

        println(res.getString("text_default"))
        println(buildTextString(text))
        println(res.getString("text_formatted"))
        println(buildTextString(Text(sortSentences(text))))
        println(res.getString("search_word"))
        println(searchWord(text))
    }
}