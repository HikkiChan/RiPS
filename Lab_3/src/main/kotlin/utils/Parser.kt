package utils

import entities.*

private const val TEXT_PART_SPLITTER = "(?<=[A-Za-zА-Яа-я0-9]([.?!]))\\s+(?=[A-ZА-Я])"
private const val CODE_BLOCK_PATTERN = "Code:.*"
private const val SENTENCE_PART_SPLITTER = "(?<!^)\\b"
private const val PUNCTUATION_MARK_PATTERN = "[\\p{Punct}\\s]+"

fun parseForText(string: String): Text {
    val textParts = ArrayList<TextPart>()
    for (str in string.replace("\\s+", " ").split(TEXT_PART_SPLITTER.toRegex())) {
        if (str.matches(CODE_BLOCK_PATTERN.toRegex())) {
            textParts.add(Code(str))
        } else {
            textParts.add(parseForSentence(str))
        }
    }
    return Text(textParts)
}

private fun parseForSentence(string: String): Sentence {
    val sentenceParts = ArrayList<SentencePart>()
    for (str in string.split(SENTENCE_PART_SPLITTER.toRegex())) {
        if (str.matches(PUNCTUATION_MARK_PATTERN.toRegex())) {
            if (str[0] != ' ') {
                sentenceParts.add(PunctuationMark(str[0]))
            }
        } else {
            sentenceParts.add(Word(str))
        }
    }
    return Sentence(sentenceParts)
}