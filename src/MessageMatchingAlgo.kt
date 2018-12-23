class MessageMatchingAlgo {

    fun isMessageMatchingWithEmblem(message: String, emblem: String): Boolean {

        val messageUnqueCharacterCounter = getUniqueCharactersAndItsCountAsHashMap(message)
        val emblemUnqueCharacterCounter = getUniqueCharactersAndItsCountAsHashMap(emblem)

        return emblemUnqueCharacterCounter.all {
            val character = it.key
            val countInEmblem = it.value

            if (messageUnqueCharacterCounter.containsKey(character)) {
                val countInMessage = messageUnqueCharacterCounter[character]!!
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