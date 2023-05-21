package Service;

import Models.Angajat;
import Models.Biblioteca;
import Models.Carte;

import java.util.ArrayList;

public class ServiceBiblioteca {
    private static ServiceBiblioteca instance;
    private final ArrayList<Biblioteca> biblioteci = new ArrayList<>();

    private ServiceBiblioteca() {
    }

    public static ServiceBiblioteca getInstance() {
        if (instance == null)
            instance = new ServiceBiblioteca();

        return instance;
    }

    public ArrayList<Biblioteca> getBiblioteci() {
        return biblioteci;
    }

    public void add_carte(int id_biblioteca, Carte carte) {
        biblioteci.get(id_biblioteca).add_carte(carte);
    }

    public void add_angajat(int id_biblioteca, Angajat angajat) {
        biblioteci.get(id_biblioteca).add_angajat(angajat);
    }

}
