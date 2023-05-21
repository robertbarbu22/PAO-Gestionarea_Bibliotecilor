package Models;

import java.util.ArrayList;
import Models.Carte;
import Models.Angajat;
import Models.Cititor;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;
import Constants.Tip_Coperta;
import Models.Bibliotecar;
import Models.Paznic;
import Constants.Tura;
import Service.ServiceAuditCSV;


public class Biblioteca {

    private String nume;
    private String adresa;
    private SortedSet<Carte> carti;
    private ArrayList<Cititor> cititori;
    private static ArrayList<Angajat> angajati;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public SortedSet<Carte> getCarti() {
        return carti;
    }

    public void setCarti(SortedSet<Carte> carti) {
        this.carti = carti;
    }

    public ArrayList<Cititor> getCititori() {
        return cititori;
    }

    public void setCititori(ArrayList<Cititor> cititori) {
        this.cititori = cititori;
    }

    public static ArrayList<Angajat> getAngajati() {
        return angajati;
    }

    public void setAngajati(ArrayList<Angajat> angajati) {
        this.angajati = angajati;
    }

    public Biblioteca(String nume, String adresa, SortedSet<Carte> carti, ArrayList<Cititor> cititori, ArrayList<Angajat> angajati) {
        this.nume = nume;
        this.adresa = adresa;
        this.carti = carti;
        this.cititori = cititori;
        this.angajati = angajati;
    }

    public void add_carte(Carte carte){
        carti.add(carte);
        ServiceAuditCSV.getInstance().writeToFile("Adaugare carte " + carte.getTitlu() );
    }

    public void remove_carte(Carte carte){
        try {
            carti.remove(carte);
        } catch (Exception e) {
            System.out.println("Cartea nu exista in biblioteca!");
        }
        ServiceAuditCSV.getInstance().writeToFile("Stergere carte " + carte.getTitlu() );
    }

    public void afiseaza_carti(){
        System.out.println("Cartile din biblioteca sunt: ");
        for (Carte carte : carti) {
            System.out.println("Titlu: " + carte.getTitlu() );
        }
        ServiceAuditCSV.getInstance().writeToFile("Afisare carti");
    }

    public void cost_inlocuire_carte(Carte carte){
        int ok = 0;
        for (Carte carte1 : carti) {
            if(carte1.getTitlu().equals(carte.getTitlu()) && carte1.getAutor().equals(carte.getAutor()) && carte1.getNr_Pagini() == carte.getNr_Pagini() && carte1.getTip_Coperta() == carte.getTip_Coperta()){
                ok = 1;
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
            if (ok == 0)
                System.out.println("Cartea nu exista in biblioteca!");
        }
        ServiceAuditCSV.getInstance().writeToFile("Calculare cost inlocuire carte " + carte.getTitlu() );

    }

    public void add_angajat(Angajat angajat){
        angajati.add(angajat);
        ServiceAuditCSV.getInstance().writeToFile("Adaugare angajat " + angajat.getNume() + " " + angajat.getPrenume());
    }

    public void remove_angajat(Angajat angajat){
        try {
            angajati.remove(angajat);
        } catch (Exception e) {
            System.out.println("Angajatul nu exista in biblioteca!");
        }
        ServiceAuditCSV.getInstance().writeToFile("Stergere angajat " + angajat.getNume() + " " + angajat.getPrenume());
    }

    public void afiseaza_angajati(){
        System.out.println("Angajatii bibliotecii sunt: ");
        for (Angajat angajat : angajati) {
            System.out.println("Nume: " + angajat.getNume() + " Prenume: " + angajat.getPrenume() + " Functie: " + angajat.getClass().getSimpleName() );
        }
        ServiceAuditCSV.getInstance().writeToFile("Afisare angajati");
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
        ServiceAuditCSV.getInstance().writeToFile("Calculare salariu angajat " + angajat.getNume() + " " + angajat.getPrenume());
    }

    public void add_cititor(Cititor cititor){
        cititori.add(cititor);
        ServiceAuditCSV.getInstance().writeToFile("Adaugare cititor " + cititor.getNume() + " " + cititor.getPrenume() );
    }

    public void remove_cititor(Cititor cititor){
        try {
            cititori.remove(cititor);
        } catch (Exception e) {
            System.out.println("Cititorul nu exista in biblioteca!");
        }
        ServiceAuditCSV.getInstance().writeToFile("Stergere cititor " + cititor.getNume() + " " + cititor.getPrenume() );
    }

    public void afiseaza_cititori(){
        System.out.println("Cititorii bibliotecii sunt: ");
        for (Cititor cititor : cititori) {
            System.out.println("Nume: " + cititor.getNume() + " Prenume: " + cititor.getPrenume());
        }
        ServiceAuditCSV.getInstance().writeToFile("Afisare cititori");
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
        ServiceAuditCSV.getInstance().writeToFile("Imprumutare carte " + carte.getTitlu() + " cititorului " + cititor.getNume() + " " + cititor.getPrenume() );

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
        ServiceAuditCSV.getInstance().writeToFile("Returnare carte " + carte.getTitlu() + " de la cititorul " + cititor.getNume() + " " + cititor.getPrenume() );

    }

    public void schimb_de_tura(Paznic paznic, Paznic paznic2){
        Tura tura = paznic.getTura();
        paznic.setTura(paznic2.getTura());
        paznic2.setTura(tura);

        System.out.println("Paznicul " + paznic.getNume() + " " + paznic.getPrenume() + " are tura " + paznic.getTura() + ", iar paznicul " + paznic2.getNume() + " " + paznic2.getPrenume() + " are tura " + paznic2.getTura());
        ServiceAuditCSV.getInstance().writeToFile("Schimb de tura intre paznicul " + paznic.getNume() + " " + paznic.getPrenume() + " si paznicul " + paznic2.getNume() + " " + paznic2.getPrenume() );
    }

    public void top_3_cititori(){
        Collections.sort(cititori, new Comparator<Cititor>() {
            @Override
            public int compare(Cititor o1, Cititor o2) {
                return o2.getNr_imprumuturi() - o1.getNr_imprumuturi();
            }
        });

        System.out.println("Top 3 cititori: ");
        for (int i = 0; i < 3; i++) {
            System.out.println( cititori.get(i).getNume() + " " + cititori.get(i).getPrenume() + "/ Numar imprumuturi: " + cititori.get(i).getNr_imprumuturi());
        }

        ServiceAuditCSV.getInstance().writeToFile("Afisare top 3 cititori");
    }


    public void angajatul_cu_cea_mai_mare_vechime(){
        Collections.sort(angajati, new Comparator<Angajat>() {
            @Override
            public int compare(Angajat o1, Angajat o2) {
                return o2.getAni_vechime() - o1.getAni_vechime();
            }
        });

        System.out.println("Angajatul cu cea mai mare vechime este: ");
        System.out.println( angajati.get(0).getNume() + " " + angajati.get(0).getPrenume() + "/ Ani vechime: " + angajati.get(0).getAni_vechime());

        ServiceAuditCSV.getInstance().writeToFile("Afisare angajat cu cea mai mare vechime");
    }



}
