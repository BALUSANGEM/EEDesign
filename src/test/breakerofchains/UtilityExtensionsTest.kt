package breakerofchains

import org.junit.Test
import Kingdom
import org.junit.Assert

class UtilityExtensionsTest {

    @Test
    fun whenCalledWithThisListShouldReturnExpectedOutput() {
        val listOfKingdom = listOf(
                Kingdom("first", "emblem1", "ruler1"),
                Kingdom("second", "emblem2", "ruler2"),
                Kingdom("third", "emblem3", "ruler3"),
                Kingdom("fourth", "emble4", "ruler4"),
                Kingdom("fifth", "emblem5", "ruler5"),
                Kingdom("sixth", "emblem6", "ruler6")
        )

        listOfKingdom[0].allies.add(listOfKingdom[1])
        listOfKingdom[2].allies.add(listOfKingdom[3])
        listOfKingdom[4].allies.add(listOfKingdom[5])

        Assert.assertArrayEquals(
                arrayOf(listOfKingdom[0], listOfKingdom[2], listOfKingdom[4]),
                listOfKingdom.getKingdomsHavingMaximumAllies().toTypedArray())

    }
}