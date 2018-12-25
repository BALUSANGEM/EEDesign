package common

import goldencrown.GoldenCrownRulerDecidingAlgo
import org.junit.Assert
import org.junit.Test
import Kingdom
import kotlin.test.assertFailsWith

class SoutherosTest {
    @Test
    fun whenGiveThisKingdomNameAsInputIshouldGiveExpectedKingdom() {
        val southeros = Southeros()
        val kingdom = southeros.kingdomsList[0]
        Assert.assertEquals(kingdom, southeros.getKingdomByName("space"))
    }

    @Test
    fun whenGiveThisKingdomNameAsInputIshouldThrowException() {
        val southeros = Southeros()
        assertFailsWith(KingdomNotFoundException::class) {
            southeros.getKingdomByName("spac")
        }
    }

    @Test
    fun whenGiveThisRulerNameAsInputIshouldGiveExpectedKingdom() {
        val southeros = Southeros()
        val kingdom = southeros.kingdomsList[0]
        Assert.assertEquals(kingdom, southeros.getKingdomByRulerName("Shan"))
    }

    @Test
    fun whenGiveThisRulerNameAsInputIshouldThrowException() {
        val southeros = Southeros()
        assertFailsWith(KingdomNotFoundException::class) {
            southeros.getKingdomByRulerName("spac")
        }
    }

    @Test
    fun whenUsingThisStrategyItShouldGiveNull() {
        val southeros = Southeros()
        val firstKingdom = southeros.kingdomsList[0]
        firstKingdom.allies.add(Kingdom("name1", "emblem", "ruler"))
        val rulerKingdom = southeros.getRulerKingdom(GoldenCrownRulerDecidingAlgo())
        Assert.assertEquals(null, rulerKingdom)
    }

    @Test
    fun whenUsingThisStrategyItShouldGiveExpectedRulerKingdom() {
        val southeros = Southeros()
        val firstKingdom = southeros.kingdomsList[0]
        firstKingdom.allies.add(Kingdom("name1", "emblem", "ruler"))
        firstKingdom.allies.add(Kingdom("name2", "emblem", "ruler"))
        firstKingdom.allies.add(Kingdom("name3", "emblem", "ruler"))
        val rulerKingdom = southeros.getRulerKingdom(GoldenCrownRulerDecidingAlgo())
        Assert.assertEquals(firstKingdom, rulerKingdom)
    }

}