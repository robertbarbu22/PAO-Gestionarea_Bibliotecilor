package Service;
import Constants.Tip_Coperta;
import Models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.SortedSet;


public class ServiceCarteCSV {
    private static ServiceCarteCSV instance;

    private ServiceCarteCSV() {
    }

    public static ServiceCarteCSV getInstance() {
        if (instance == null)
            instance = new ServiceCarteCSV();

        return instance;
    }

    private void createFile(String fileName){

        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Eroare la crearea fisierului " + fileName);
        }

    }

    public void writeToFile() {
        try{
        createFile("src\\Files\\Carti_Adolescenti.csv");
        createFile("src\\Files\\Carti_Adulti.csv");
        createFile("src\\Files\\Carti_Copii.csv");




            BufferedWriter writerCartiAdolescenti = new BufferedWriter(new FileWriter("src\\Files\\Carti_Adolescenti.csv", true));
            BufferedWriter writerCartiAdulti = new BufferedWriter(new FileWriter("src\\Files\\Carti_Adulti.csv", true));
            BufferedWriter writerCartiCopii = new BufferedWriter(new FileWriter("src\\Files\\Carti_Copii.csv", true));


        ArrayList<Biblioteca> biblioteci = ServiceBiblioteca.getInstance().getBiblioteci();


        for (int i = 0; i < biblioteci.size(); i++) {
            SortedSet<Carte> carti = biblioteci.get(i).getCarti();
            for (Carte c : carti) {
                if (c.getClass() == Carte_Adolescenti.class) {
                    writerCartiAdolescenti.write((i + 1) + ", " + c.getId() + ", " +
                            c.getTitlu() + ", " +
                            c.getAutor() + ", " +
                            c.getTip_Coperta() + ", " +
                            c.getNr_Pagini() + ", " +
                            c.getAn_Aparitie() + ", " +
                            c.getE_imprumutata() + ", " +
                            ((Carte_Adolescenti) c).getE_science_fiction() + ", " +
                            ((Carte_Adolescenti) c).getE_romantic() + ", " +
                            ((Carte_Adolescenti) c).getE_drama() + ", " +
                            ((Carte_Adolescenti) c).getE_horror() + "\n");
                }
                if (c.getClass() == Carte_Adulti.class) {

                    writerCartiAdulti.write((i + 1) + ", " + c.getId() + ", " +
                            c.getTitlu() + ", " +
                            c.getAutor() + ", " +
                            c.getTip_Coperta() + ", " +
                            c.getNr_Pagini() + ", " +
                            c.getAn_Aparitie() + ", " +
                            c.getE_imprumutata() + ", " +
                            ((Carte_Adulti) c).getAre_restictie_de_varsta() + ", " +
                            ((Carte_Adulti) c).getGen() + ", " + "\n");
                }
                if(c.getClass() == Carte_Copii.class) {
                    writerCartiCopii.write((i + 1) + ", " + c.getId() + ", " +
                            c.getTitlu() + ", " +
                            c.getAutor() + ", " +
                            c.getTip_Coperta() + ", " +
                            c.getNr_Pagini() + ", " +
                            c.getAn_Aparitie() + ", " +
                            c.getE_imprumutata() + ", " +
                            ((Carte_Copii) c).getVarsta_recomandata() + ", " +
                            ((Carte_Copii) c).getDe_colorat() + "\n");
                }
                }
            }


        writerCartiAdolescenti.close();
        writerCartiAdulti.close();
        writerCartiCopii.close();

    }
        catch (IOException e) {
        System.out.println("Eroare la scrierea in fisierul CSV");
    }

    }
    public void readFromCSV() {
        try {
            String[] files = new String[]{"src\\Files\\Carti_Adolescenti.csv", "src\\Files\\Carti_Adulti.csv", "src\\Files\\Carti_Copii.csv"};

            for (String file : files) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String input;

                while ((input = reader.readLine()) != null) {
                    String[] infoCarte = input.split(",");

                    int id_carte = Integer.parseInt(infoCarte[1].trim());
                    String titlu = infoCarte[2].trim();
                    String autor = infoCarte[3].trim();
                    Tip_Coperta tip_coperta = Tip_Coperta.valueOf(infoCarte[4].trim());
                    int nr_pagini = Integer.parseInt(infoCarte[5].trim());
                    int an_aparitie = Integer.parseInt(infoCarte[6].trim());
                    boolean e_imprumutata = Boolean.parseBoolean(infoCarte[7].trim());



                    switch (file) {
                        case "src\\Files\\Carti_Adolescenti.csv" -> {
                            boolean e_science_fiction = Boolean.parseBoolean(infoCarte[8].trim());
                            boolean e_romantic = Boolean.parseBoolean(infoCarte[9].trim());
                            boolean e_drama = Boolean.parseBoolean(infoCarte[10].trim());
                            boolean e_horror = Boolean.parseBoolean(infoCarte[11].trim());

                            Carte_Adolescenti carte = new Carte_Adolescenti(titlu, autor, tip_coperta, nr_pagini, an_aparitie, e_imprumutata, e_science_fiction, e_romantic, e_drama, e_horror);
                            ServiceBiblioteca.getInstance().add_carte(Integer.parseInt(infoCarte[0].trim()),carte);
                        }
                        case "src\\Files\\Carti_Adulti.csv"-> {
                            boolean are_restricte_de_varsta = Boolean.parseBoolean(infoCarte[9].trim());
                            String gen = infoCarte[8].trim();

                            Carte_Adulti carte = new Carte_Adulti(titlu, autor, tip_coperta, nr_pagini, an_aparitie, e_imprumutata, gen, are_restricte_de_varsta);
                            ServiceBiblioteca.getInstance().add_carte(Integer.parseInt(infoCarte[0].trim()),carte);

                        }
                        case "src\\Files\\Carti_Copii.csv" -> {
                            String varsta_recomandata = infoCarte[8].trim();
                            boolean de_colorat = Boolean.parseBoolean(infoCarte[9].trim());

                            Carte_Copii carte = new Carte_Copii(titlu, autor, tip_coperta, nr_pagini, an_aparitie, e_imprumutata, varsta_recomandata, de_colorat);
                            ServiceBiblioteca.getInstance().add_carte(Integer.parseInt(infoCarte[0].trim()),carte);
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println( "Fisierul CSV nu a fost gasit.");
        }
        catch (IOException e) {
            System.out.println("Eroare la citirea din fisierul CSV");
        }
    }
}
