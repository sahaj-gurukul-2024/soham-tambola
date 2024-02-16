import org.example.Tambola
import org.example.TambolaTicket
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TambolaTest {

    @Test
    fun `should accept if the top row claim is valid`(){
        val tambola = Tambola()
        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(4, 16, 17, 63, 48, 76)

        assertTrue(tambola.rowValidation(ticket, numberAnnounced, 1))
    }

    @Test
    fun `should reject if the top row claim is invalid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(4, 16, 17, 63, 48, 76, 12)

        assertFalse(tambola.rowValidation(ticket, numberAnnounced, 1))
    }

    @Test
    fun `should accept if the middle row validation is valid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(7, 23, 52, 38, 80)

        assertTrue(tambola.rowValidation(ticket, numberAnnounced, 2))
    }

    @Test
    fun `should reject if the middle row validation is invalid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(7, 23, 52, 38, 80, 12, 25, 67)

        assertFalse(tambola.rowValidation(ticket, numberAnnounced, 1))
    }

    @Test
    fun `should accept if the bottom row claim is valid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(9, 16, 17, 56, 48, 83, 25, 64)

        assertTrue(tambola.rowValidation(ticket, numberAnnounced, 3))
    }

    @Test
    fun `should reject if the bottom row claim is invalid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(9, 16, 17, 56, 48, 83, 25, 56, 43)

        assertFalse(tambola.rowValidation(ticket, numberAnnounced, 2))
    }

    @Test
    fun `should accept if the early five claim is valid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(9, 54, 17, 64, 83, 12, 25, 52)

        assertTrue(tambola.earlyFiveValidation(ticket, numberAnnounced))
    }

    @Test
    fun `should reject if the early five claim is invalid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(9, 54, 17, 64, 83, 12, 25, 52, 67)

        assertFalse(tambola.earlyFiveValidation(ticket, numberAnnounced))
    }

    @Test
    fun `should accept if the full house validation is valid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(4, 16, 63, 76, 80, 12, 25, 52, 48, 7, 23, 38, 9, 56, 64, 83)

        assertTrue(tambola.fullHouseValidation(ticket, numberAnnounced))
    }

    @Test
    fun `should reject if the full house validation claim is invalid`(){
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(4, 16, 63, 76, 80, 12, 25, 52, 48, 7, 23, 38, 80, 9, 56, 64, 83, 10)

        assertFalse(tambola.fullHouseValidation(ticket, numberAnnounced))
    }

    @Test
    fun `should reject when claim is unregistered` () {
        val tambola = Tambola()

        val ticket = TambolaTicket(
            arrayOf(4, 16, 48, 63, 76),
            arrayOf(7, 23, 38, 52, 80),
            arrayOf(9, 25, 56, 64, 83),
        )

        val numberAnnounced = arrayListOf(4, 16, 63, 76, 80, 12, 25, 52, 48, 7, 23, 38, 80, 9, 56, 64, 83, 10)

        assertFalse(tambola.validateTicket(ticket, numberAnnounced, "ERROR"))
    }
}