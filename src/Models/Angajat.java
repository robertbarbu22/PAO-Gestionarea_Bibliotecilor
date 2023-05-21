package Models;

public abstract class Angajat {

    protected String nume;
    protected String prenume;
    protected int varsta;
    protected int ani_vechime;

    public Angajat(String nume, String prenume, int varsta, int ani_vechime) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.ani_vechime = ani_vechime;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public int getAni_vechime() {
        return ani_vechime;
    }


    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setAni_vechime(int ani_vechime) {
        this.ani_vechime = ani_vechime;
    }



}
