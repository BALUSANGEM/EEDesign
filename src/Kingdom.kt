class Kingdom(val name: String, val emblem: String, val rulerName: String = "") {

    val allies = ArrayList<Kingdom>()
    var alligienceTo: Kingdom? = null

    fun sendMessage(message: Message) {

    }

    fun receiveMessage(message: Message) {

    }

    fun onAllegianceMadeBy(kingdom: Kingdom) {

    }
}