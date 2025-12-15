package RelojDigital;

public class Alarma{

    private int hora;
    private int minuto;
    private String mensaje;
    private boolean activa;

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Alarma(int h, int m, String msg) {
        hora = h;
        minuto = m;
        mensaje = msg;
        activa = true;
    }

    public Alarma() {
        hora = 0;
        minuto = 0;
        mensaje = "";
        activa = false;
    }

    public boolean coincide(int h, int m) {
        return (hora == h && minuto == m)?true:false;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d - %s%s",
            hora, minuto, mensaje, activa ? "" : " (off)");
    }

    
    
}