import common.Message
import org.junit.Assert
import org.junit.Test

class KingdomTest {

    @Test
    fun whenSendingThisMessageTheyBecomeAlliesSoItShouldReturnTrue() {
        val senderKingdom = Kingdom("first", "emb", "one")
        val recieverKingdom = Kingdom("second", "lem", "two")
        senderKingdom.sendMessage(Message(senderKingdom, recieverKingdom, "lem"))
        Assert.assertEquals(true, senderKingdom.allies.contains(recieverKingdom))
    }

    @Test
    fun whenSendingThisMessageTheyWillNotBecomeAlliesSoItShouldReturnFalse() {
        val senderKingdom = Kingdom("first", "emb", "one")
        val recieverKingdom = Kingdom("second", "lem", "two")
        senderKingdom.sendMessage(Message(senderKingdom, recieverKingdom, "emb"))
        Assert.assertEquals(false, senderKingdom.allies.contains(recieverKingdom))
    }

    @Test
    fun whenIsCompetingToBeRulerValuesChangesThenAlliesListShouldBecomeEmpty() {
        val kingdom = Kingdom("first", "emb", "one")
        kingdom.isCompetingToBeRuler = true
        Assert.assertEquals(0, kingdom.allies.size)
    }

    @Test
    fun whenIsCompetingToBeRulerValuesChangesThenAlliegienceToShouldBecomeNull() {
        val kingdom = Kingdom("first", "emb", "one")
        kingdom.isCompetingToBeRuler = true
        Assert.assertEquals(null, kingdom.alligienceTo)
    }


    @Test
    fun whenThisMessageRecievedItShouldBecomeAllyToSender() {
        val senderKingdom = Kingdom("first", "emb", "one")
        val receiverkingdom = Kingdom("second", "lem", "two")
        receiverkingdom.receiveMessage(Message(senderKingdom, receiverkingdom, "lem"))
        Assert.assertEquals(senderKingdom, receiverkingdom.alligienceTo)
    }

    @Test
    fun whenThisMessageRecievedItShouldNotBecomeAllyToSender() {
        val senderKingdom = Kingdom("first", "emb", "one")
        val receiverkingdom = Kingdom("second", "lem", "two")
        receiverkingdom.receiveMessage(Message(senderKingdom, receiverkingdom, "emb"))
        Assert.assertNotEquals(senderKingdom, receiverkingdom.alligienceTo)
    }

    @Test
    fun whenSuccessMessageRecievedSecondTimeItShouldNotBecomeAllyToSender() {
        val senderKingdom = Kingdom("first", "emb", "one")
        val receiverkingdom = Kingdom("second", "lem", "two")
        receiverkingdom.receiveMessage(Message(senderKingdom, receiverkingdom, "lem"))

        val secondSenderKingdom = Kingdom("third", "emblem", "three")
        receiverkingdom.receiveMessage(Message(secondSenderKingdom, receiverkingdom, "lem"))
        Assert.assertNotEquals(secondSenderKingdom, receiverkingdom.alligienceTo)
    }


}