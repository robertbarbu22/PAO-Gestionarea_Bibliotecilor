package Models;

import Models.Carte;

public class Cititor {

    private String nume;
    private String prenume;
    private int varsta;
    private String adresa;
    private String telefon;
    private int nr_imprumuturi;
    private Carte carte_imprumutata;

    public Cititor(String nume, String prenume, int varsta, String adresa, String telefon, int nr_imprumuturi , Carte carte_imprumutata) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.adresa = adresa;
        this.telefon = telefon;
        this.nr_imprumuturi = nr_imprumuturi;
        this.carte_imprumutata = carte_imprumutata;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Carte getCarte_imprumutata() {
        return carte_imprumutata;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getNr_imprumuturi() {
        return nr_imprumuturi;
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

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setNr_imprumuturi(int nr_imprumuturi) {
        this.nr_imprumuturi = nr_imprumuturi;
    }

    public void setCarte_imprumutata(Carte carte_imprumutata) {
        this.carte_imprumutata = carte_imprumutata;
    }


}
