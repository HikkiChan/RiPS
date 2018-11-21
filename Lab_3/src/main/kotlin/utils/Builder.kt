package utils

import entities.*

fun buildTextString(text: Text): String {
    val result = StringBuilder()
    for (part in text.parts) {
        result.append(buildTextPartString(part))
    }
    return result.toString()
}

private fun buildTextPartString(part: TextPart): String {
    val result = StringBuilder()
    when (part) {
        is Sentence -> for (sentencePart in part.parts) {
            result.append(buildSentencePartString(sentencePart))
        }
        is Code -> {
            result.append(" ${part.content}")
        }
        else -> throw IllegalArgumentException("Wrong TextPart type!")
    }
    return result.toString()
}

private fun buildSentencePartString(part: SentencePart) = when (part) {
    is Word -> " ${part.word}"
    is PunctuationMark -> part.mark.toString()
    else -> throw IllegalArgumentException("Wrong SentencePart type!")
}