package Personaje;

public class Personaje {
    
    public int vida, danio, evasion, probCritico, defensa;
    public String nombre;

    public Personaje(String nombre, int vida, int danio, int evasion, int probCritico, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.danio = danio;
        this.evasion = evasion;
        this.probCritico = probCritico;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public int getProbCritico() {
        return probCritico;
    }

    public void setProbCritico(int probCritico) {
        this.probCritico = probCritico;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

}
