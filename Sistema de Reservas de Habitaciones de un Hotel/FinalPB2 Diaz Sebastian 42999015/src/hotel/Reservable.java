package hotel;

import java.time.LocalDate;

public interface Reservable {
    void realizarReserva(String nombreCliente, String documentoIdentidad, Integer numeroHabitacion, LocalDate fechaInicio, LocalDate fechaFin) throws HabitacionInexistenteException, HabitacionOcupadaException;
    void cancelarReserva(Integer numeroHabitacion) throws HabitacionInexistenteException;
}

