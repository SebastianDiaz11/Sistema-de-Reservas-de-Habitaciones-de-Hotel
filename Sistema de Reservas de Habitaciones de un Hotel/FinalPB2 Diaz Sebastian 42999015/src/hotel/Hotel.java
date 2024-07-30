package hotel;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Reservable {
    private HashMap<Integer, Habitacion> inventarioHabitaciones;
    private List<Reserva> reservas;

    public Hotel() {
        this.inventarioHabitaciones = new HashMap<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        inventarioHabitaciones.put(habitacion.getNumero(), habitacion);
    }

    public HashMap<Integer, Habitacion> getInventarioHabitaciones() {
        return inventarioHabitaciones;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public void realizarReserva(String nombreCliente, String documentoIdentidad, Integer numeroHabitacion, LocalDate fechaInicio, LocalDate fechaFin) throws HabitacionInexistenteException, HabitacionOcupadaException {
        Habitacion habitacion = inventarioHabitaciones.get(numeroHabitacion);
        if (habitacion == null) {
            throw new HabitacionInexistenteException("La habitación no existe.");
        }
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getNumero() == numeroHabitacion && reserva.getFechaInicio().isBefore(fechaFin) && reserva.getFechaFin().isAfter(fechaInicio)) {
                throw new HabitacionOcupadaException("La habitación está ocupada.");
            }
        }
        Reserva nuevaReserva = new Reserva(nombreCliente, documentoIdentidad, habitacion, fechaInicio, fechaFin);
        reservas.add(nuevaReserva);
    }

    @Override
    public void cancelarReserva(Integer numeroHabitacion) throws HabitacionInexistenteException {
        Reserva reservaACancelar = null;
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getNumero() == numeroHabitacion) {
                reservaACancelar = reserva;
                break;
            }
        }
        if (reservaACancelar == null) {
            throw new HabitacionInexistenteException("La habitación no existe.");
        }
        reservas.remove(reservaACancelar);
    }
}


