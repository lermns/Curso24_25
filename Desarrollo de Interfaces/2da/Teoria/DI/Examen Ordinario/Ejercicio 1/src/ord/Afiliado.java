
package ord;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PedroBorreganBurgos
 */

public class Afiliado {
    
    public static final ArrayList<Afiliado> listaAfiliados = new ArrayList<Afiliado>();
    
    private String nick;
    private int clave;
    private String email;
    private int CP;
    private String situacion;
    private int donacion;
    private String pago;
    private String notificaciones;
    
    public Afiliado(String nick, int clave, String email, int CP, String situacion, int donacion, String pago, String notificaciones) {
        setNick(nick);
        setClave(clave);
        setEmail(email);
        setCP(CP);
        setSituacion(situacion);
        setDonacion(donacion);
        setPago(pago);
        setNotificaciones(notificaciones);
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public int getDonacion() {
        return donacion;
    }

    public void setDonacion(int donacion) {
        this.donacion = donacion;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(String notificaciones) {
        this.notificaciones = notificaciones;
    }

    /*@Override
    public String toString() {
        return "Afiliado{" + "nick=" + nick + ", clave=" + clave + ", email=" + email + ", CP=" + CP + ", situacion=" + situacion + ", donacion=" + donacion + ", pago=" + pago + ", notificaciones=" + notificaciones + '}';
    }*/
}
