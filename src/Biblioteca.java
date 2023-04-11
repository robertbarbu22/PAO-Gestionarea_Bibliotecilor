import java.util.ArrayList;
import Carti.Carte;
import Persoane.Angajat;
import Persoane.Cititor;
import java.util.SortedSet;
import Utile.Tip_Coperta;
import Persoane.Bibliotecar;
import Persoane.Paznic;
import Utile.Tura;


public class Biblioteca {

    private String nume;
    private String adresa;
    private SortedSet<Carte> carti;
    private ArrayList<Cititor> cititori;
    private ArrayList<Angajat> angajati;

    public Biblioteca(String nume, String adresa, SortedSet<Carte> carti, ArrayList<Cititor> cititori, ArrayList<Angajat> angajati) {
        this.nume = nume;
        this.adresa = adresa;
        this.carti = carti;
        this.cititori = cititori;
        this.angajati = angajati;
    }

    public void add_carte(Carte carte){
        carti.add(carte);
    }

    public void remove_carte(Carte carte){
        try {
            carti.remove(carte);
        } catch (Exception e) {
            System.out.println("Cartea nu exista in biblioteca!");
        }
    }

    public void afiseaza_carti(){
        System.out.println("Cartile din biblioteca sunt: ");
        for (Carte carte : carti) {
            System.out.println("Titlu: " + carte.getTitlu() );
        }
    }

    public void cost_inlocuire_carte(Carte carte){
        int cost = 0;
        cost = carte.getNr_Pagini() / 15;
        if( carte.getTip_Coperta() == Tip_Coperta.DURA)
            cost += 10;
        else if( carte.getTip_Coperta() == Tip_Coperta.NORMALA)
            cost += 3;
        else if( carte.getTip_Coperta() == Tip_Coperta.CARTONATA)
            cost += 7;

        System.out.println("Costul inlocuirii cartii este: " + cost);
    }

    public void add_angajat(Angajat angajat){
        angajati.add(angajat);
    }

    public void remove_angajat(Angajat angajat){
        try {
            angajati.remove(angajat);
        } catch (Exception e) {
            System.out.println("Angajatul nu exista in biblioteca!");
        }
    }

    public void afiseaza_angajati(){
        System.out.println("Angajatii bibliotecii sunt: ");
        for (Angajat angajat : angajati) {
            System.out.println("Nume: " + angajat.getNume() + " Prenume: " + angajat.getPrenume() + " Functie: " + angajat.getClass().getSimpleName() );
        }
    }

    public void calculeaza_salariu_angajat(Angajat angajat){
        int salariu = 0;
        if (angajat instanceof Bibliotecar){
            salariu = 2000;
            if (((Bibliotecar) angajat).getCalificare_in_domeniu() == true)
                salariu += 500;
            if (((Bibliotecar) angajat).getCalificare_office() == true)
                salariu += 500;
        }

        else if (angajat instanceof Paznic){
            salariu = 1500;
            if (((Paznic) angajat).getTura() == Tura.PRIMA)
                salariu += 700;
            else if (((Paznic) angajat).getTura() == Tura.A_DOUA)
                salariu += 500;
            else if (((Paznic) angajat).getTura() == Tura.A_TREIA)
                salariu += 1000;
        }

        System.out.println("Salariul angajatului " + angajat.getNume()+ " " + angajat.getPrenume() + " este: " + salariu);
    }

    public void add_cititor(Cititor cititor){
        cititori.add(cititor);
    }

    public void remove_cititor(Cititor cititor){
        try {
            cititori.remove(cititor);
        } catch (Exception e) {
            System.out.println("Cititorul nu exista in biblioteca!");
        }
    }

    public void afiseaza_cititori(){
        System.out.println("Cititorii bibliotecii sunt: ");
        for (Cititor cititor : cititori) {
            System.out.println("Nume: " + cititor.getNume() + " Prenume: " + cititor.getPrenume());
        }
    }

    public void imprumuta_carte(Cititor cititor, Carte carte) {
        if (carte.getE_imprumutata() == true ){
            System.out.println("Cartea a fost imprumutata deja!");
        }
        else if (cititor.getCarte_imprumutata() != null){
            System.out.println("Cititorul nu mai poate imprumuta carti deoarece are deja imprumutata cartea " +  cititor.getCarte_imprumutata().getTitlu() + "!");
        }
        else {
            carte.setE_imprumutata(true);
            cititor.setNr_imprumuturi(cititor.getNr_imprumuturi() + 1);
            cititor.setCarte_imprumutata(carte);
            System.out.println("Cartea a fost imprumutata cu succes!");
        }

    }

    public void inapoiere_carte(Cititor cititor, Carte carte) {
        if (carte.getE_imprumutata() == false) {
            System.out.println("Cartea nu a fost imprumutata!");
        }
        else {
            carte.setE_imprumutata(false);
            cititor.setCarte_imprumutata(null);
            System.out.println("Cartea a fost returnata cu succes!");
        }

    }



}
