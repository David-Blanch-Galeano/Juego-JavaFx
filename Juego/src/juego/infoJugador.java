package juego;

import java.util.Objects;

public class infoJugador {
    
    String nombreGanador, nombrePerdedor, nombrePelea;
    int jugadorGanador;

    public infoJugador(String nombreGanador, String nombrePelea, int jugadorGanador) {
        this.nombreGanador = nombreGanador;
        this.nombrePelea = nombrePelea;
        this.jugadorGanador = jugadorGanador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nombreGanador);
        hash = 37 * hash + Objects.hashCode(this.nombrePelea);
        hash = 37 * hash + this.jugadorGanador;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final infoJugador other = (infoJugador) obj;
        if (this.jugadorGanador != other.jugadorGanador) {
            return false;
        }
        if (!Objects.equals(this.nombreGanador, other.nombreGanador)) {
            return false;
        }
        if (!Objects.equals(this.nombrePelea, other.nombrePelea)) {
            return false;
        }
        return true;
    }

    
    
    public String getNombreGanador() {
        return nombreGanador;
    }

    public void setNombreGanador(String nombreGanador) {
        this.nombreGanador = nombreGanador;
    }

    public String getNombrePerdedor() {
        return nombrePerdedor;
    }

    public void setNombrePerdedor(String nombrePerdedor) {
        this.nombrePerdedor = nombrePerdedor;
    }

    public String getNombrePelea() {
        return nombrePelea;
    }

    public void setNombrePelea(String nombrePelea) {
        this.nombrePelea = nombrePelea;
    }

    public int getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(int jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }
    
    
    
}
