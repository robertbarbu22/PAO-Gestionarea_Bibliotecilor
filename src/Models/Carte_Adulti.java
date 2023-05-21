package Models;

import Constants.Tip_Coperta;

public class Carte_Adulti extends Carte {

    private String gen;
    private Boolean are_restictie_de_varsta;

    public Carte_Adulti(  String titlu, String autor, Tip_Coperta tip_coperta, int nr_pagini, int an_aparitie, Boolean e_imprumutata, String gen, Boolean are_restictie_de_varsta) {
        super( titlu, autor, tip_coperta, nr_pagini, an_aparitie, e_imprumutata);
        this.gen = gen;
        this.are_restictie_de_varsta = are_restictie_de_varsta;
    }

    public String getGen() {
        return gen;
    }

    public Boolean getAre_restictie_de_varsta() {
        return are_restictie_de_varsta;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public void setAre_restictie_de_varsta(Boolean are_restictie_de_varsta) {
        this.are_restictie_de_varsta = are_restictie_de_varsta;
    }

    @Override

    public String toString() {
        return "Carte_Adulti{" + "id=" + id + ", titlu=" + titlu + ", autor=" + autor + ", tip_coperta=" + tip_coperta + ", nr_pagini=" + nr_pagini + ", an_aparitie=" + an_aparitie + ", e_imprumutata=" + e_imprumutata + ", gen=" + gen + ", are_restictie_de_varsta=" + are_restictie_de_varsta + '}';
    }
}
