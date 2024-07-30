package hotel;

public class HabitacionEstandar extends Habitacion {
    private Boolean tieneBalcon;
    private Boolean vista;
    private Boolean incluyeDesayuno;
    private Boolean tvPorCable;

    public HabitacionEstandar(Integer numero, Integer capacidad, Double precioPorNoche,
                              Boolean tieneBalcon, Boolean vista, Boolean incluyeDesayuno, Boolean tvPorCable) {
        super(numero, capacidad, precioPorNoche);
        this.tieneBalcon = tieneBalcon;
        this.vista = vista;
        this.incluyeDesayuno = incluyeDesayuno;
        this.tvPorCable = tvPorCable;
    }

    public Boolean TieneBalcon() {
        return tieneBalcon;
    }

    public void setTieneBalcon(Boolean tieneBalcon) {
        this.tieneBalcon = tieneBalcon;
    }

    public Boolean Vista() {
        return vista;
    }

    public void setVista(Boolean vista) {
        this.vista = vista;
    }

    public Boolean IncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(Boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }

    public boolean TvPorCable() {
        return tvPorCable;
    }

    public void setTvPorCable(Boolean tvPorCable) {
        this.tvPorCable = tvPorCable;
    }
}


