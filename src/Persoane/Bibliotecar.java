package Persoane;

public class Bibliotecar extends Angajat{

    private Boolean calificare_in_domeniu;
    private Boolean calificare_office;

    public Bibliotecar(String nume, String prenume, int varsta , int ani_vechime, Boolean calificare_in_domeniu, Boolean calificare_office) {
        super(nume, prenume, varsta, ani_vechime);
        this.calificare_in_domeniu = calificare_in_domeniu;
        this.calificare_office = calificare_office;
    }

    public Boolean getCalificare_in_domeniu() {
        return calificare_in_domeniu;
    }

    public Boolean getCalificare_office() {
        return calificare_office;
    }

    public void setCalificare_in_domeniu(Boolean calificare_in_domeniu) {
        this.calificare_in_domeniu = calificare_in_domeniu;
    }

    public void setCalificare_office(Boolean calificare_office) {
        this.calificare_office = calificare_office;
    }

    @Override

    public String toString() {
        return "Bibliotecar{" + "nume=" + nume + ", prenume=" + prenume + ", varsta=" + varsta + ", ani_vechime=" + ani_vechime + ", calificare_in_domeniu=" + calificare_in_domeniu + ", calificare_office=" + calificare_office + '}';
    }
}
