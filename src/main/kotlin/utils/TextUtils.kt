package utils

import entities.*

fun sortSentences(text: Text) = deleteCode(text).apply {
    sortBy { it.parts.size }
}

fun searchWord(text: Text): String {
    val clearedByCode = deleteCode(text)
    val firstSentence = deleteMarks(clearedByCode[0])
    val otherSentencesWords = ArrayList<String>().apply {
        for (i in (1..(clearedByCode.size - 1))) {
            addAll(deleteMarks(clearedByCode[i]))
        }
    }

    return searchWordEngine(firstSentence, otherSentencesWords)
}

fun searchWordEngine(firstSentence: ArrayList<String>, otherSentences: ArrayList<String>): String {

    for (wordCount in (1..(firstSentence.size - 1))) {
        if (!otherSentences.contains(firstSentence[wordCount])) {
            return firstSentence[wordCount]
        }
    }
    return "Not Found!"
}

private fun deleteCode(text: Text) = ArrayList<Sentence>().apply {
    for (part in text.parts) {
        if (part is Sentence) {
            add(part)
        }
    }
}

private fun deleteMarks(sentence: Sentence) = ArrayList<String>().apply {
    for (word in sentence.parts) {
        if (word is Word) {
            add(word.toString())
        }
    }
}
