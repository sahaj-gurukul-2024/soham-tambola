import org.example.Tambola
import org.junit.jupiter.api.Test

class TambolaTest {
    @Test
    fun `the number announced should get marked as true in the ticket`() {
        val tambola = Tambola((mapOf(
            1 to listOf(Pair(4, false), Pair(16, false), Pair(48, false), Pair(63, false), Pair(76, false)),
            2 to listOf(Pair(7, false), Pair(23, false), Pair(38, false), Pair(52, false), Pair(80, false)),
            3 to listOf(Pair(9, false), Pair(25, false), Pair(56, false), Pair(64, false), Pair(83, false)),
        )))
        val ticket = tambola.getTicket()
        val announcedNumber = 4
        tambola.markNumber(ticket, announcedNumber)
        tambola.checkMarked(ticket, announcedNumber)
    }

    assertTrue(tambola.checkMarked(ticket, announcedNumber))
}