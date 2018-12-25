import common.Southeros
import org.junit.Assert
import org.junit.Test

class SoutherosExtensionsTest {
    @Test
    fun whenPassingThisListShouldReturnTrue() {
        Assert.assertEquals(true, Southeros().kingdomsExistInSoutheros(listOf("Air", "Ice")))
    }

    @Test
    fun whenPassingThisListShouldReturnFalse() {
        Assert.assertEquals(false, Southeros().kingdomsExistInSoutheros(listOf("Ship")))
    }

    @Test
    fun whenPassingEmptyListShouldReturnFalse() {
        Assert.assertEquals(false, Southeros().kingdomsExistInSoutheros(listOf()))
    }
}