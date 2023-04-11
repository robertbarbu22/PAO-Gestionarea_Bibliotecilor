package Persoane;

import Utile.Tura;

public class Paznic extends Angajat{

    private Tura tura;

    public Paznic(String nume, String prenume, int varsta, int ani_vechime, Tura tura) {
        super(nume, prenume, varsta, ani_vechime);
        this.tura = tura;
    }

    public Tura getTura() {
        return tura;
    }

    public void setTura(Tura tura) {
        this.tura = tura;
    }

    @Override

    public String toString() {
        return "Paznic{" + "nume=" + nume + ", prenume=" + prenume + ", varsta=" + varsta + ", ani_vechime=" + ani_vechime + ", tura=" + tura + '}';
    }


}
