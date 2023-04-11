# PAO-Gestionarea_Bibliotecilor

Acesta este un proiect care are ca scop gestionarea mai multor biblioteci, fiecare continand angajati, carti si cititori. Toate actiunile si tipurile de obiecte pot fi observate si testate in main.

## Actiuni/Interogari

- add_carte (adauga o carte in biblioteca)
- remove_carte (elimina o carte din biblioteca)
- afiseaza_carti (afiseaza toate cartile existente in biblioteca)
- cost_inlocuire_carte (calculeaza un cost estimativ pentru inlocuirea unei carti)
- add_angajat (adauga un angajat in biblioteca)
- remove_angajat (elimina un angajat din biblioteca)
- afiseaza_angajati (afiseaza toti angajatii bibliotecii)
- calculeaza_salariu_angajat (calculeaza salariul unui angajat pe baza mai multor factori)
- add_cititor (adauga un cititor in biblioteca)
- remove_cititor (elimina un cititor din biblioteca)
- afiseaza_cititori (afiseaza toti cititorii inscrisi la biblioteca)
- imprumuta_carte (ajuta la evidenta cartilor pentru a nu mai fi imprumutate, dar si la evidenta cititorului pentru a nu mai putea imprumuta pana nu returneaza)
- inapoiere_carte (ajuta la evidenta cartilor pentru a putea fi imprumutate, dar si la evidenta cui a returnat pentru a mai putea imprumuta)
- schimba_de_tura (schimba turele a doi paznici)
- top_3_cititori (afiseaza primii 3 cititori ca si carti imprumutate)
- angajatul_cu_cea_mai_mare_vechime (returneaza angajatul care lucreaza de cel mai mult timp la biblioteca)

## Obiecte/Clase

- Carte
  - Carte_Adulti
  - Carte_Adolescenti
  - Carte_Copii
- Angajat
  - Bibliotecar
  - Paznic
- Cititor
- Clase tip Enum ( Tip_Coperta, Tura)
- Biblioteca
- Main

