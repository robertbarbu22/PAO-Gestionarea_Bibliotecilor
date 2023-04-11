import java.util.ArrayList;
import java.util.SortedSet;

import Carti.Carte_Adolescenti;
import Carti.Carte_Adulti;
import Carti.Carte_Copii;
import Persoane.Angajat;
import Persoane.Cititor;
import Utile.Tip_Coperta;
import Persoane.Bibliotecar;
import Persoane.Paznic;
import Utile.Tura;
import Carti.Carte;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca1 = new Biblioteca("Biblioteca Matei Basarab ", "Bucuresti, Strada Izvoarelor, numarul 4", new ArrayList<>(), new ArrayList<>(), new TreeSet<>());

        Angajat angajat1 = new Bibliotecar ("Popescu", "Ion", 30, 4, true, true);
        biblioteca1.add_angajat(angajat1);

        Angajat angajat2 = new Bibliotecar("Ionescu", "Maria", 25, 3, true, false);
        biblioteca1.add_angajat(angajat2);

        Angajat angajat3 = new Paznic ("Iftimi", "Andrei", 40, 5, Tura.PRIMA);
        biblioteca1.add_angajat(angajat3);

        Angajat angajat4 = new Paznic ("Ionescu", "Rares", 35, 4, Tura.A_DOUA);
        biblioteca1.add_angajat(angajat4);

        Angajat angajat5 = new Paznic ("Berbecaru", "Radu", 30, 3, Tura.A_TREIA);
        biblioteca1.add_angajat(angajat5);


        biblioteca1.afiseaza_angajati();

        System.out.println(" ");

        biblioteca1.remove_angajat(angajat1);

        biblioteca1.afiseaza_angajati();

        System.out.println(" ");

        biblioteca1.calculeaza_salariu_angajat(angajat2);
        biblioteca1.calculeaza_salariu_angajat(angajat3);
        biblioteca1.calculeaza_salariu_angajat(angajat4);
        biblioteca1.calculeaza_salariu_angajat(angajat5);

        System.out.println(" ");

        Carte carte1 = new Carte_Adulti(100, "Eat, pray, love", "Elizabeth Gilbert", Tip_Coperta.DURA, 500, 2005, true, "Dragoste", false);
        Carte carte2 = new Carte_Adolescenti(101, "Twilight", "Stephenie Meyer", Tip_Coperta.CARTONATA, 300, 2005, false, true, true, true, true);
        Carte carte3 = new Carte_Copii(102, "Invatam Abecedarul", "Maria Popescu", Tip_Coperta.NORMALA, 30, 2000, false, "5-7 ani", false);
        Carte carte4 = new Carte_Copii(103, "Invatam sa coloram", "Maria Popescu", Tip_Coperta.NORMALA, 20, 2014, false, "2-5 ani", true);

        biblioteca1.add_carte(carte1);
        biblioteca1.add_carte(carte2);
        biblioteca1.add_carte(carte3);
        biblioteca1.add_carte(carte4);

        biblioteca1.afiseaza_carti();

        biblioteca1.remove_carte(carte4);

        System.out.println(" ");

        biblioteca1.afiseaza_carti();

        System.out.println(" ");

        biblioteca1.cost_inlocuire_carte(carte1);
        biblioteca1.cost_inlocuire_carte(carte2);
        biblioteca1.cost_inlocuire_carte(carte3);

        System.out.println(" ");

        Cititor cititor1 = new Cititor("Popa", "Ioana", 20, "Valea Lunga 49, Bucuresti", "0754938504", 4, carte1 );
        Cititor cititor2 = new Cititor("Matei", "Andrei", 25, "Valea Cascadelor 49, Bucuresti", "0754938594", 2, null );
        Cititor cititor3 = new Cititor("Stanciu", "Alexandra", 30, "Bd. Grigorescu, 24, Bucuresti", "0754938599", 0, null );
        Cititor cititor4 = new Cititor("Ilie", "Rares", 35, "Bd. Iuliu Maniu, 24, Bucuresti", "0754933399", 10, null );

        biblioteca1.add_cititor(cititor1);
        biblioteca1.add_cititor(cititor2);
        biblioteca1.add_cititor(cititor3);
        biblioteca1.add_cititor(cititor4);

        biblioteca1.afiseaza_cititori();

        biblioteca1.remove_cititor(cititor4);

        System.out.println(" ");

        biblioteca1.afiseaza_cititori();

        System.out.println(" ");

        biblioteca1.imprumuta_carte(cititor1, carte2);

        System.out.println(" ");

        biblioteca1.imprumuta_carte(cititor2, carte2);

        System.out.println(" ");

        biblioteca1.imprumuta_carte(cititor2, carte3);

        System.out.println(" ");

        biblioteca1.inapoiere_carte(cititor1, carte2);

        System.out.println(" ");

        biblioteca1.inapoiere_carte(cititor1, carte2);


    }
}