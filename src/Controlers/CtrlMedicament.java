package Controlers;

import Entities.Consultation;
import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> GetAllMedicamentsByIdConsultations(int idConsultation)
    {
            ArrayList<Medicament> lesMedicaments = new ArrayList<>();
            try {
                ps = cnx.prepareStatement("SELECT idMedoc, nomMedoc, prixMedoc from medicament inner join prescrire on medicament.idMedoc = prescrire.numMedoc inner join consultation on prescrire.numConsult = consultation.idConsult where idConsult = ?");
                ps.setInt(1, idConsultation);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Medicament medicament = new Medicament(rs.getInt("idMedoc"), rs.getString("nomMedoc"),rs.getInt("prixMedoc"));
                    lesMedicaments.add(medicament);
                }
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lesMedicaments;
    }
    public ArrayList<Medicament> getAllMedicaments()
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT idMedoc, nomMedoc, prixMedoc, quantite from medicament inner join prescrire on medicament.idMedoc = prescrire.numMedoc");
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicament medicament = new Medicament(rs.getInt("idMedoc"), rs.getString("nomMedoc"),rs.getInt("prixMedoc"));
                lesMedicaments.add(medicament);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }
}
