package Carti;

import Utile.Tip_Coperta;
public abstract class Carte {

    protected int id;
    protected String titlu;
    protected String autor;
    protected Tip_Coperta tip_coperta;
    protected int nr_pagini;
    protected int an_aparitie;
    protected Boolean e_imprumutata;

    public Carte (int id, String titlu, String autor, Tip_Coperta tip_coperta, int nr_pagini, int an_aparitie, Boolean e_imprumutata) {
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
        this.tip_coperta = tip_coperta;
        this.nr_pagini = nr_pagini;
        this.an_aparitie = an_aparitie;
        this.e_imprumutata = e_imprumutata;
    }

    public int getId() {
        return id;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public Tip_Coperta getTip_Coperta() {
        return tip_coperta;
    }

    public int getNr_Pagini() {
        return nr_pagini;
    }

    public int getAn_Aparitie() {
        return an_aparitie;
    }

    public Boolean getE_imprumutata() {
        return e_imprumutata;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTip_Coperta(Tip_Coperta tip_coperta) {
        this.tip_coperta = tip_coperta;
    }

    public void setNr_Pagini(int nr_pagini) {
        this.nr_pagini = nr_pagini;
    }

    public void setAn_Aparitie(int an_aparitie) {
        this.an_aparitie = an_aparitie;
    }

    public void setE_imprumutata(Boolean e_imprumuata) {
        this.e_imprumutata = e_imprumuata;
    }


}
