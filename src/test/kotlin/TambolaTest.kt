import org.example.Tambola
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
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
    fun `should accept if top row claim is valid`() {
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

        val claim = tambola.isValidClaim("Top Row", ticket, lastAnnouncedNumber)

        assertTrue("Accepted" == claim)
    }

    @Test
    fun `should reject if top row claim is invalid`() {
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
        tambola.markNumber(ticket, 59)

        val lastAnnouncedNumber = 59

        val claim = tambola.isValidClaim("Top Row", ticket, lastAnnouncedNumber)

        assertTrue("Rejected" == claim)
    }

    @Test
    fun `should accept if the bottom row claim is valid`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        tambola.markNumber(ticket, 9)
        tambola.markNumber(ticket, 25)
        tambola.markNumber(ticket, 26)
        tambola.markNumber(ticket, 27)
        tambola.markNumber(ticket, 56)
        tambola.markNumber(ticket, 64)
        tambola.markNumber(ticket, 83)

        val lastAnnouncedNumber = 83

        val claim = tambola.isValidClaim("Bottom Row", ticket, lastAnnouncedNumber)

        assertTrue("Accepted" == claim)
    }

    @Test
    fun `should reject if the bottom row claim is invalid`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        tambola.markNumber(ticket, 9)
        tambola.markNumber(ticket, 25)
        tambola.markNumber(ticket, 26)
        tambola.markNumber(ticket, 27)
        tambola.markNumber(ticket, 56)
        tambola.markNumber(ticket, 64)
        tambola.markNumber(ticket, 83)
        tambola.markNumber(ticket, 84)

        val lastAnnouncedNumber = 84

        val claim = tambola.isValidClaim("Bottom Row", ticket, lastAnnouncedNumber)

        assertTrue("Rejected" == claim)
    }

    @Test
    fun `should accept if the early five claim is valid`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        tambola.markNumber(ticket, 4)
        tambola.markNumber(ticket, 16)
        tambola.markNumber(ticket, 48)
        tambola.markNumber(ticket, 52)
        tambola.markNumber(ticket, 80)

        val lastAnnouncedNumber = 80

        val claim = tambola.isValidClaim("Early Five", ticket, lastAnnouncedNumber)

        assertTrue("Accepted" == claim)
    }

    @Test
    fun `should reject if the early five claim is invalid`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        tambola.markNumber(ticket, 4)
        tambola.markNumber(ticket, 16)
        tambola.markNumber(ticket, 48)
        tambola.markNumber(ticket, 52)
        tambola.markNumber(ticket, 80)
        tambola.markNumber(ticket, 81)
        val lastAnnouncedNumber = 81

        val claim = tambola.isValidClaim("Early Five", ticket, lastAnnouncedNumber)

        assertTrue("Rejected" == claim)
    }

    @Test
    fun `should accept if the full house claim is valid`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        tambola.markNumber(ticket, 4)
        tambola.markNumber(ticket, 16)
        tambola.markNumber(ticket, 48)
        tambola.markNumber(ticket, 63)
        tambola.markNumber(ticket, 76)
        tambola.markNumber(ticket, 7)
        tambola.markNumber(ticket, 23)
        tambola.markNumber(ticket, 38)
        tambola.markNumber(ticket, 52)
        tambola.markNumber(ticket, 80)
        tambola.markNumber(ticket, 9)
        tambola.markNumber(ticket, 25)
        tambola.markNumber(ticket, 56)
        tambola.markNumber(ticket, 64)
        tambola.markNumber(ticket, 83)

        val lastAnnouncedNumber = 83

        val claim = tambola.isValidClaim("Full House", ticket, lastAnnouncedNumber)

        assertEquals("Accepted", claim)
    }

    fun `should reject if the full house claim is invalid`() {
        val tambola = Tambola(
            (mutableMapOf(
                1 to mutableMapOf(4 to false, 16 to false, 48 to false, 63 to false, 76 to false),
                2 to mutableMapOf(7 to false, 23 to false, 38 to false, 52 to false, 80 to false),
                3 to mutableMapOf(9 to false, 25 to false, 56 to false, 64 to false, 83 to false),
            ))
        )
        val ticket = tambola.getTicket()
        tambola.markNumber(ticket, 4)
        tambola.markNumber(ticket, 16)
        tambola.markNumber(ticket, 48)
        tambola.markNumber(ticket, 63)
        tambola.markNumber(ticket, 76)
        tambola.markNumber(ticket, 7)
        tambola.markNumber(ticket, 23)
        tambola.markNumber(ticket, 38)
        tambola.markNumber(ticket, 52)
        tambola.markNumber(ticket, 80)
        tambola.markNumber(ticket, 9)
        tambola.markNumber(ticket, 25)
        tambola.markNumber(ticket, 56)
        tambola.markNumber(ticket, 64)
        tambola.markNumber(ticket, 83)
        tambola.markNumber(ticket, 89)

        val lastAnnouncedNumber = 83

        val claim = tambola.isValidClaim("Full House", ticket, lastAnnouncedNumber)

        assertEquals("Rejected", claim)
    }
}