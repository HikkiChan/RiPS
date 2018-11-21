package entities

class Word(var word: String) : SentencePart() {

    override fun toString() = word
}