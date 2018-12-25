package secondproblem

import common.Message
import java.util.*

class HighPriest {

    private val pickedMessagesList = ArrayList<Message>()
    fun pickMessagesFromBallet(ballot: Ballot) {
        pickedMessagesList.clear()

        val allMessages = ballot.messages
        while (true) {
            val message = allMessages[Random().nextInt(allMessages.size)]
            if (!pickedMessagesList.contains(message)) {
                pickedMessagesList.add(message)
            }
            if (pickedMessagesList.size >= 6) {
                break
            }
        }

    }

    fun sendMessagesToPickedKingdoms() {
        pickedMessagesList.forEach { message ->
            message.receiver.receiveMessage(message)
        }
    }
}