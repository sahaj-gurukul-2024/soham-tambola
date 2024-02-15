import org.example.Tambola
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TambolaTest {
    @Test
    fun `Top Row validation for acceptance claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("4, 16, 17, 63, 48, 76".split(", "))

        val claim = "Top Row"
        assertTrue(tambola.validate(ticket, numberAnnounced, claim))
    }

    @Test
    fun `Top Row validation for rejection claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("4, 16, 17, 63, 48, 76, 12".split(", "))

        val claim = "Top Row"
        assertFalse(tambola.validate(ticket, numberAnnounced, claim))
    }


    @Test
    fun `Bottom Row validation for acceptance claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("9, 16, 17, 56, 48, 83, 25, 64".split(", "))

        val claim = "Bottom Row"
        assertTrue(tambola.validate(ticket, numberAnnounced, claim))
    }

    @Test
    fun `Bottom Row validation for rejection claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("9, 16, 17, 56, 48, 83, 25, 56, 43".split(", "))

        val claim = "Bottom Row"
        assertFalse(tambola.validate(ticket, numberAnnounced, claim))
    }

    @Test
    fun `Early Five validation for acceptance claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("9, 54, 17, 64, 83, 12, 25, 52".split(", "))

        val claim = "Early Five"
        assertTrue(tambola.validate(ticket, numberAnnounced, claim))
    }

    @Test
    fun `Early Five validation for rejection claim`(){
        val tambola = Tambola()

        val ticket = ArrayList<ArrayList<String>>()
        ticket.add("4,16,_,_,48,_,63,76,_".split(',') as ArrayList<String>)
        ticket.add("7,_,23,38,_,52,_,_,80".split(',') as ArrayList<String>)
        ticket.add("9,_,25,_,_,56,64,_,83".split(',') as ArrayList<String>)

        val numberAnnounced = ArrayList<String>("9, 54, 17, 64, 83, 12, 25, 52, 67".split(", "))

        val claim = "Early Five"
        assertFalse(tambola.validate(ticket, numberAnnounced, claim))
    }
}