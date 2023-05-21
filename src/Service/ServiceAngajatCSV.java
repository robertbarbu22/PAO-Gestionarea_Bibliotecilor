package Service;
import Constants.Tip_Coperta;
import Models.*;
import Constants.Tura;
import java.io.*;
import java.util.ArrayList;
import java.util.SortedSet;
public class ServiceAngajatCSV {
    private static ServiceAngajatCSV instance;

    private ServiceAngajatCSV() {
    }

    public static ServiceAngajatCSV getInstance() {
        if (instance == null)
            instance = new ServiceAngajatCSV();

        return instance;
    }

    private void createFile(String fileName) {

        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Eroare la crearea fisierului " + fileName);
        }

    }

    public void writeToFile() {
        try {
            createFile("src\\Files\\Bibliotecari.csv");
            createFile("src\\Files\\Paznici.csv");


            BufferedWriter writerBibliotecari = new BufferedWriter(new FileWriter("src\\Files\\Bibliotecari.csv", true));
            BufferedWriter writerPaznici = new BufferedWriter(new FileWriter("src\\Files\\Paznici.csv", true));


            ArrayList<Biblioteca> biblioteci = ServiceBiblioteca.getInstance().getBiblioteci();


            for (int i = 0; i < biblioteci.size(); i++) {
                ArrayList<Angajat> angajati = biblioteci.get(i).getAngajati();
                for (Angajat a : angajati) {
                    if (a.getClass() == Bibliotecar.class) {
                        writerBibliotecari.write((i + 1) + ", " +
                                a.getNume() + ", " +
                                a.getPrenume() + ", " +
                                a.getVarsta() + ", " +
                                a.getAni_vechime() + ", " +
                                ((Bibliotecar) a).getCalificare_in_domeniu() + ", " +
                                ((Bibliotecar) a).getCalificare_office() + "\n");
                    }
                    if (a.getClass() == Paznic.class) {
                        writerPaznici.write((i + 1) + ", " +
                                a.getNume() + ", " +
                                a.getPrenume() + ", " +
                                a.getVarsta() + ", " +
                                a.getAni_vechime() + ", " +
                                ((Paznic) a).getTura() + "\n");
                    }
                }
            }


            writerBibliotecari.close();
            writerPaznici.close();

        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisierul CSV");
        }

    }

    public void readFromCSV() {
        try {
            String[] files = new String[]{"src\\Files\\Bibliotecari.csv", "src\\Files\\Paznici.csv"};

            for (String file : files) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String input;

                while ((input = reader.readLine()) != null) {
                    String[] infoCarte = input.split(",");

                    String nume = infoCarte[1].trim();
                    String prenume = infoCarte[2].trim();
                    int varsta = Integer.parseInt(infoCarte[3].trim());
                    int ani_vechime = Integer.parseInt(infoCarte[4].trim());


                    switch (file) {
                        case "src\\Files\\Bibliotecari.csv" -> {

                            Boolean calificare_in_domeniu = Boolean.parseBoolean(infoCarte[5].trim());
                            Boolean calificare_office = Boolean.parseBoolean(infoCarte[6].trim());

                            Bibliotecar bibliotecar = new Bibliotecar(nume, prenume, varsta, ani_vechime, calificare_in_domeniu, calificare_office);
                            ServiceBiblioteca.getInstance().add_angajat(Integer.parseInt(infoCarte[0].trim()), bibliotecar);
                        }
                        case "src\\Files\\Paznici.csv" -> {

                            Tura tura = Tura.valueOf(infoCarte[5].trim());

                            Paznic paznic = new Paznic(nume, prenume, varsta, ani_vechime, tura);
                            ServiceBiblioteca.getInstance().add_angajat(Integer.parseInt(infoCarte[0].trim()), paznic);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul CSV nu a fost gasit.");
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisierul CSV");
        }

    }
}
