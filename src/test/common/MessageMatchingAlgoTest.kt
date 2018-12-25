package common

import org.junit.Assert
import org.junit.Test

class MessageMatchingAlgoTest {
    @Test
    fun whenGiveTheseInputsItShouldReturnTrue() {
        val messageMatchingAlgo = MessageMatchingAlgo("osdfwsdaflsadfsaf", "owl")
        Assert.assertEquals(true, messageMatchingAlgo.isAlly())
    }

    @Test
    fun whenGiveTheseInputsItShouldReturnFalse() {
        val messageMatchingAlgo = MessageMatchingAlgo("sdafsaffwsdfaflsdfasf", "owl")
        Assert.assertEquals(false, messageMatchingAlgo.isAlly())
    }
}