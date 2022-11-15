package Entities;

public class Consultation
{
    private int numero;
    private String date;
    private String nomPatient;
    private String nomMedecin;
    private double montant;

    public Consultation(){}

    public Consultation(int unNum,String uneDate, String unNomPat, String unNomMed)
    {
        numero = unNum;
        date = uneDate;
        nomPatient = unNomPat;
        nomMedecin = unNomMed;

    }

    public int getNumero() {
        return numero;
    }

    public String getDate() {
        return date;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public double getMontant() {
        return montant;
    }
}
