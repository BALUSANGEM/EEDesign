package common

class MessageMatchingAlgo(private val message: String, private val emblem: String) : AllyStrategy {

    override fun isAlly() = isMessageMatchingWithEmblem(message, emblem)

    private fun isMessageMatchingWithEmblem(message: String, emblem: String): Boolean {

        val messageUniqueCharacterCounter = getUniqueCharactersAndItsCountAsHashMap(message)
        val emblemUniqueCharacterCounter = getUniqueCharactersAndItsCountAsHashMap(emblem)

        return emblemUniqueCharacterCounter.all {
            val character = it.key
            val countInEmblem = it.value

            if (messageUniqueCharacterCounter.containsKey(character)) {
                val countInMessage = messageUniqueCharacterCounter[character]!!
                countInMessage >= countInEmblem
            } else {
                false
            }
        }

    }

    private fun getUniqueCharactersAndItsCountAsHashMap(string: String): HashMap<Char, Int> {
        val charAndItsCountHashMap = HashMap<Char, Int>()
        string.toLowerCase().forEach {
            if (charAndItsCountHashMap.containsKey(it)) {
                charAndItsCountHashMap[it] = charAndItsCountHashMap[it]!!.plus(1)
            } else {
                charAndItsCountHashMap[it] = 1
            }
        }
        return charAndItsCountHashMap
    }

}