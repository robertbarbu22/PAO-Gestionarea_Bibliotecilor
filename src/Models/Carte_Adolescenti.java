package Models;

import Constants.Tip_Coperta;

public class Carte_Adolescenti extends Carte {

    private Boolean e_science_fiction;
    private Boolean e_romantic;
    private Boolean e_drama;
    private Boolean e_horror;

    public Carte_Adolescenti( String titlu, String autor, Tip_Coperta tip_coperta, int nr_pagini, int an_aparitie, Boolean e_imprumutata, Boolean e_science_fiction, Boolean e_romantic, Boolean e_drama, Boolean e_horror) {
        super( titlu, autor, tip_coperta, nr_pagini, an_aparitie, e_imprumutata);
        this.e_science_fiction = e_science_fiction;
        this.e_romantic = e_romantic;
        this.e_drama = e_drama;
        this.e_horror = e_horror;
    }

    public Boolean getE_science_fiction() {
        return e_science_fiction;
    }

    public Boolean getE_romantic() {
        return e_romantic;
    }

    public Boolean getE_drama() {
        return e_drama;
    }

    public Boolean getE_horror() {
        return e_horror;
    }

    public void setE_science_fiction(Boolean e_science_fiction) {
        this.e_science_fiction = e_science_fiction;
    }

    public void setE_romantic(Boolean e_romantic) {
        this.e_romantic = e_romantic;
    }

    public void setE_drama(Boolean e_drama) {
        this.e_drama = e_drama;
    }

    public void setE_horror(Boolean e_horror) {
        this.e_horror = e_horror;
    }

    @Override

    public String toString() {

        return "Carte_Adolescenti{" + "id=" + id + ", titlu=" + titlu + ", autor=" + autor + ", tip_coperta=" + tip_coperta + ", nr_pagini=" + nr_pagini + ", an_aparitie=" + an_aparitie + ", e_imprumutata=" + e_imprumutata + ", e_science_fiction=" + e_science_fiction + ", e_romantic=" + e_romantic + ", e_drama=" + e_drama + ", e_horror=" + e_horror + '}';
    }

}
