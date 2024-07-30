package hotel;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class HotelTest {
    private Hotel hotel;

    @Before
    public void setUp() {
        hotel = new Hotel();
    }

    @Test
    public void testAgregarHabitacionEstandar() {
        HabitacionEstandar habitacion = new HabitacionEstandar(101, 2, 100.0, true, true, true, true);
        hotel.agregarHabitacion(habitacion);
        assertEquals(habitacion, hotel.getInventarioHabitaciones().get(101));
    }

    @Test
    public void testRealizarReservaEnHabitacionEstandarDisponible() throws Exception {
        HabitacionEstandar habitacion = new HabitacionEstandar(101, 2, 100.0, true, true, true, true);
        hotel.agregarHabitacion(habitacion);
        hotel.realizarReserva("Sebastian Diaz", "42999015", 101, LocalDate.now(), LocalDate.now().plusDays(1));
        assertEquals(1, hotel.getReservas().size());
        Reserva reserva = hotel.getReservas().get(0);
        assertEquals("Sebastian Diaz", reserva.getNombreCliente());
        assertEquals("42999015", reserva.getDocumentoIdentidad());
        assertEquals(habitacion, reserva.getHabitacion());
    }

    @Test
    public void testCancelarReserva() throws Exception {
        HabitacionEstandar habitacion = new HabitacionEstandar(101, 2, 100.0, true, true, true, true);
        hotel.agregarHabitacion(habitacion);
        hotel.realizarReserva("Sebastian Diaz", "42999015", 101, LocalDate.now(), LocalDate.now().plusDays(1));
        hotel.cancelarReserva(101);
        assertEquals(0, hotel.getReservas().size());
    }

    @Test(expected = HabitacionInexistenteException.class)
    public void testIntentarReservarHabitacionInexistente() throws Exception {
        hotel.realizarReserva("Sebastian Diaz", "42999015", 999, LocalDate.now(), LocalDate.now().plusDays(1));
    }

    @Test(expected = HabitacionOcupadaException.class)
    public void testIntentarReservarHabitacionOcupada() throws Exception {
        HabitacionEstandar habitacion = new HabitacionEstandar(101, 2, 100.0, true, true, true, true);
        hotel.agregarHabitacion(habitacion);
        hotel.realizarReserva("Sebastian Diaz", "42999015", 101, LocalDate.now(), LocalDate.now().plusDays(1));
        hotel.realizarReserva("Thais Mairotti", "87654321", 101, LocalDate.now(), LocalDate.now().plusDays(1));
    }

    @Test
    public void testAgregarSuiteYRealizarReserva() throws Exception {
        Suite suite = new Suite(201, 4, 200.0, 50.0, true, true, "Sala de estar", 2);
        hotel.agregarHabitacion(suite);
        hotel.realizarReserva("Thais Mairotti", "87654321", 201, LocalDate.now(), LocalDate.now().plusDays(2));
        assertEquals(1, hotel.getReservas().size());
        Reserva reserva = hotel.getReservas().get(0);
        assertEquals("Thais Mairotti", reserva.getNombreCliente());
        assertEquals("87654321", reserva.getDocumentoIdentidad());
        assertEquals(suite, reserva.getHabitacion());
    }

    @Test
    public void VerificarAtributosEspecificosHabitacionEstandar() {
        HabitacionEstandar habitacion = new HabitacionEstandar(101, 2, 100.0, true, true, true, true);
        hotel.agregarHabitacion(habitacion);
        HabitacionEstandar recuperada = (HabitacionEstandar) hotel.getInventarioHabitaciones().get(101);
        assertTrue(recuperada.TieneBalcon());
        assertTrue(recuperada.Vista());
        assertTrue(recuperada.IncluyeDesayuno());
        assertTrue(recuperada.TvPorCable());
    }

    @Test
    public void VerificarAtributosEspecificosSuite() {
        Suite suite = new Suite(201, 4, 200.0, 50.0, true, true, "Sala de estar", 2);
        hotel.agregarHabitacion(suite);
        Suite recuperada = (Suite) hotel.getInventarioHabitaciones().get(201);
        assertEquals(50.0, recuperada.getTamano(), 0.01);
        assertTrue(recuperada.TieneJacuzzi());
        assertTrue(recuperada.ServicioDeMayordomo());
        assertEquals("Sala de estar", recuperada.getZonaDeEstar());
        assertEquals(2, recuperada.getNumeroDeHabitaciones());
    }
}


