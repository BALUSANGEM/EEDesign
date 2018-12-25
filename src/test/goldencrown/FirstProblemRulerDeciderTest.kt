package goldencrown

import org.junit.Assert
import org.junit.Test
import Kingdom

class FirstProblemRulerDeciderTest {
    @Test
    fun whenGivenThisInputListItShouldReturnNull() {
        val firstProblemRulerDecider = FirstProblemRulerDecider()
        val listOfKingdom = listOf(
                Kingdom("first", "emblem1", "ruler1"),
                Kingdom("second", "emblem2", "ruler2"),
                Kingdom("third", "emblem3", "ruler3"),
                Kingdom("fourth", "emble4", "ruler4"),
                Kingdom("fifth", "emblem5", "ruler5")
        )
        Assert.assertEquals(null, firstProblemRulerDecider.getRulerKingdom(listOfKingdom))
    }

    @Test
    fun whenGivenThisInputListItShouldReturnExpectedOutput() {
        val firstProblemRulerDecider = FirstProblemRulerDecider()
        val listOfKingdom = listOf(
                Kingdom("first", "emblem1", "ruler1"),
                Kingdom("second", "emblem2", "ruler2"),
                Kingdom("third", "emblem3", "ruler3"),
                Kingdom("fourth", "emble4", "ruler4"),
                Kingdom("fifth", "emblem5", "ruler5")
        )

        val expectedKingdom = listOfKingdom[2]
        expectedKingdom.allies.add(listOfKingdom[0])
        expectedKingdom.allies.add(listOfKingdom[1])
        expectedKingdom.allies.add(listOfKingdom[3])
        expectedKingdom.allies.add(listOfKingdom[4])
        Assert.assertEquals(expectedKingdom, firstProblemRulerDecider.getRulerKingdom(listOfKingdom))
    }
}