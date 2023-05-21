package Models;

import Constants.Tip_Coperta;

public class Carte_Copii extends Carte {
    private String varsta_recomandata;
    private Boolean de_colorat;

    public Carte_Copii( String titlu, String autor, Tip_Coperta tip_coperta, int nr_pagini, int an_aparitie, Boolean e_imprumutata, String varsta_recomandata, Boolean de_colorat) {
        super( titlu, autor, tip_coperta, nr_pagini, an_aparitie, e_imprumutata);
        this.varsta_recomandata = varsta_recomandata;
        this.de_colorat = de_colorat;
    }

    public String getVarsta_recomandata() {
        return varsta_recomandata;
    }

    public Boolean getDe_colorat() {
        return de_colorat;
    }

    public void setVarsta_recomandata(String varsta_recomandata) {
        this.varsta_recomandata = varsta_recomandata;
    }

    public void setDe_colorat(Boolean de_colorat) {
        this.de_colorat = de_colorat;
    }

    @Override

    public String toString() {
        return "Carte_Copii{" + "id=" + id + ", titlu=" + titlu + ", autor=" + autor + ", tip_coperta=" + tip_coperta + ", nr_pagini=" + nr_pagini + ", an_aparitie=" + an_aparitie + ", e_imprumutata=" + e_imprumutata + ", varsta_recomandata=" + varsta_recomandata + ", de_colorat=" + de_colorat + '}';
    }
}
