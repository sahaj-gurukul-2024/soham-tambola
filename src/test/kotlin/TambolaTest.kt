import org.example.Tambola
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class TambolaTest {
    @Test
    fun `the number announced should get marked as true in the ticket`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        val announcedNumber = 80
        tambola.markNumber(ticket, announcedNumber)
        tambola.checkMarked(ticket, announcedNumber)

        assertTrue(tambola.checkMarked(ticket, announcedNumber))
    }

    @Test
    fun `check if top row claim is valid`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        tambola.markNumber(ticket, 90)
        tambola.markNumber(ticket, 4)
        tambola.markNumber(ticket, 46)
        tambola.markNumber(ticket, 63)
        tambola.markNumber(ticket, 89)
        tambola.markNumber(ticket, 16)
        tambola.markNumber(ticket, 76)
        tambola.markNumber(ticket, 48)

        val lastAnnouncedNumber = 48

        val claim = tambola.validClaim("Top Row", ticket, lastAnnouncedNumber)

        assertTrue(claim == "Accepted")
    }

    fun `check if bottom row claim is valid`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        tambola.markNumber(ticket, 90)
        tambola.markNumber(ticket, 4)
        tambola.markNumber(ticket, 46)
        tambola.markNumber(ticket, 63)
        tambola.markNumber(ticket, 89)
        tambola.markNumber(ticket, 16)
        tambola.markNumber(ticket, 76)
        tambola.markNumber(ticket, 48)

        val lastAnnouncedNumber = 48

        val claim = tambola.validClaim("Top Row", ticket, lastAnnouncedNumber)

        assertTrue(claim == "Accepted")
    }

}