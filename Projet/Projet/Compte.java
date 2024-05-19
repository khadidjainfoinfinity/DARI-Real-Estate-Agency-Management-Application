//made by Billal
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Compte {
    int ID;
    String Type1; // Agent / Client
    String Type2; // Si Type1 = Client alors Acheteur / Locataire / Vendeur / Bailleur
    String Nom;
    String Prénom;
    String Sexe;
    LocalDate DateNaissance;
    int Age;

    int[] annonceID = new int[100]; // les ID des annonces que l'utilisateur a liké


    //CONSTRUCTOR
    public Compte(int ID, String Type1, String Type2, String Nom, String Prénom, String Sexe, LocalDate DateNaissance) 
    {
        this.ID = ID;
        this.Type1 = Type1;
        if (Type1.equals("Client")) {this.Type2 = Type2;} else {this.Type2 = null;}
        this.Nom = Nom;
        this.Prénom = Prénom;
        this.Sexe = Sexe;
        this.DateNaissance = DateNaissance;
        this.Age = Period.between(DateNaissance, LocalDate.now()).getYears();
    }

    // GETTERS
    public int getID() {
        return ID;
    }

    public String getType1() {
        return Type1;
    }

    public String getType2() {
        return Type2;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrénom() {
        return Prénom;
    }

    public String getSexe() {
        return Sexe;
    }

    public LocalDate getDateNaissance() {
        return DateNaissance;
    }

    public int getAge() {
        return Age;
    }

    public int[] getAnnonceID() {
        return annonceID;
    }

    //SETTERS
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setType1(String Type1) {
        this.Type1 = Type1;
    }

    public void setType2(String Type2) {
        this.Type2 = Type2;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrénom(String Prénom) {
        this.Prénom = Prénom;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public void setDateNaissance(LocalDate DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public void setAnnonceID(int[] annonceID) {
        this.annonceID = annonceID;
    }

    // Méthode pour créer un nouveau compte dans la base de données
    public void créerCompte() {
        Compte compte = new Compte (ID, Type1, Type2, Nom, Prénom, Sexe, DateNaissance);

        // Connexion à la base de données
        String url = "jdbc:mysql://mysql-2ea2fb0b-poo-42cc.h.aivencloud.com:23764/defaultdb";
        String user = "avnadmin";
        String password = "AVNS_kUewPuEAByr2oiDcj8t";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Préparation de la requête SQL pour l'insertion
            String query = "INSERT INTO Compte (ID, Type1, Type2, Nom, Prénom, Sexe, DateNaissance, Age) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                // Définition des paramètres de la requête
                pst.setInt(1, compte.getID());
                pst.setString(2, compte.getType1());
                pst.setString(3, compte.getType2());
                pst.setString(4, compte.getNom());
                pst.setString(5, compte.getPrénom());
                pst.setString(6, compte.getSexe());
                pst.setDate(7, java.sql.Date.valueOf(compte.getDateNaissance()));
                pst.setInt(8, getAge());

                // Exécution de la requête
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les exceptions (journalisation, etc.)
        }
    }

    // Méthode pour supprimer un compte de la base de données
    public void supprimerCompte(int idCompte) {
        // Connexion à la base de données
        String url = "jdbc:mysql://mysql-2ea2fb0b-poo-42cc.h.aivencloud.com:23764/defaultdb";
        String user = "avnadmin";
        String password = "AVNS_kUewPuEAByr2oiDcj8t";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Préparation de la requête SQL pour la suppression
            String query = "DELETE FROM Compte WHERE ID = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                // Définition du paramètre de la requête
                pst.setInt(1, idCompte);

                // Exécution de la requête
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les exceptions (journalisation, etc.)
        }
    }

    public void ajouterAnnonceID(int idCompte, int nouvelID) {
        // Connexion à la base de données
        String url = "jdbc:mysql://mysql-2ea2fb0b-poo-42cc.h.aivencloud.com:23764/defaultdb";
        String user = "avnadmin";
        String password = "AVNS_kUewPuEAByr2oiDcj8t";
        
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Récupération de la liste actuelle des IDs d'annonce pour le compte donné
            List<Integer> idsAnnoncesActuels = obtenirAnnoncesID(idCompte, con);
            
            // Ajout du nouvel ID à la liste
            idsAnnoncesActuels.add(nouvelID);
            
            // Mise à jour de la liste des IDs d'annonce dans la base de données
            mettreAJourAnnoncesID(idCompte, idsAnnoncesActuels, con);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les exceptions (journalisation, etc.)
        }
    }

    public void supprimerAnnonceID(int idCompte, int idAnnonce) {
        // Connexion à la base de données
        String url = "jdbc:mysql://mysql-2ea2fb0b-poo-42cc.h.aivencloud.com:23764/defaultdb";
        String user = "avnadmin";
        String password = "AVNS_kUewPuEAByr2oiDcj8t";
        
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Récupération de la liste actuelle des IDs d'annonce pour le compte donné
            List<Integer> idsAnnoncesActuels = obtenirAnnoncesID(idCompte, con);
            
            // Suppression de l'ID de la liste
            if (idsAnnoncesActuels.contains(idAnnonce)) {
                idsAnnoncesActuels.remove((Integer) idAnnonce); // Convertir en Integer pour supprimer par valeur
                
                // Décalage des cases à gauche pour éviter les vides dans le tableau
                for (int i = 0; i < idsAnnoncesActuels.size(); i++) {
                    if (idsAnnoncesActuels.get(i) == null) {
                        // Trouvé une case vide, décaler les éléments suivants d'une position vers la gauche
                        for (int j = i; j < idsAnnoncesActuels.size() - 1; j++) {
                            idsAnnoncesActuels.set(j, idsAnnoncesActuels.get(j + 1));
                        }
                        // Supprimer la dernière case qui est désormais vide
                        idsAnnoncesActuels.remove(idsAnnoncesActuels.size() - 1);
                    }
                }
            }
            
            // Mise à jour de la liste des IDs d'annonce dans la base de données
            mettreAJourAnnoncesID(idCompte, idsAnnoncesActuels, con);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les exceptions (journalisation, etc.)
        }
    }
    

    // Méthode pour obtenir la liste des IDs d'annonce actuels pour un compte donné
    private List<Integer> obtenirAnnoncesID(int idCompte, Connection con) throws SQLException {
        List<Integer> idsAnnonces = new ArrayList<>();
        String query = "SELECT annonceID FROM Compte WHERE ID = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, idCompte);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    idsAnnonces.add(rs.getInt("annonceID"));
                }
            }
        }
        return idsAnnonces;
    }

    // Méthode pour mettre à jour la liste des IDs d'annonce dans la base de données
    private void mettreAJourAnnoncesID(int idCompte, List<Integer> nouveauxIDs, Connection con) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (int id : nouveauxIDs) {
            sb.append(id).append(",");
        }
        // Supprimer la virgule finale
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String query = "UPDATE Compte SET annonceID = ? WHERE ID = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, sb.toString());
            pst.setInt(2, idCompte);
            pst.executeUpdate();
        }
    }

}
