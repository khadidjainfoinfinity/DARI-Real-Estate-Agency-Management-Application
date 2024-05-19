//made by Billal
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Annonce extends BienImmobilier{
    int ID;
    int Likes;
    int IdAgent;

    public Annonce(){}
    public Annonce (int ID, int Likes, int IdAgent, String Wilaya, String Commune, String Localisation, String Type, String TypeApparetement, int Superficie, int NombrePièces, int Etage, Boolean Gaz, Boolean Electricité, Boolean Eau, Boolean Meublé, Boolean Garage, Boolean Jardin, Boolean Terasse, String VLE,  int Prix,  int ConditionP, String Description)
    {
        super(Wilaya, Commune, Localisation, Type, TypeApparetement, Superficie, NombrePièces, Etage, Gaz, Electricité, Eau, Meublé, Garage, Jardin, Terasse, VLE,  Prix,  ConditionP, Description);
        this .IdAgent = IdAgent;
        this.ID = ID;
        this.Likes = Likes;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLikes(int Likes) {
        this.Likes = Likes;
    }

    public void setIdAgent(int IdAgent) {
        this.IdAgent = IdAgent;
    }


    public int getID() {
        return ID;
    }

    public int getLikes() {
        return Likes;
    }

    public int getIdAgent() {
        return IdAgent;
    }

    public void Créer (int ID, int Likes, int IdAgent, String Wilaya, String Commune, String Localisation, String Type, String TypeApparetement, int Superficie, int NombrePièces, int Etage, Boolean Gaz, Boolean Electricité, Boolean Eau, Boolean Meublé, Boolean Garage, Boolean Jardin, Boolean Terasse, String VLE,  int Prix,  int ConditionP, String Description){
        Annonce annonce = new Annonce (ID, Likes, IdAgent, Wilaya, Commune, Localisation, Type, TypeApparetement, Superficie, NombrePièces, Etage, Gaz, Electricité, Eau, Meublé, Garage, Jardin, Terasse, VLE,  Prix,  ConditionP, Description);
        
        // JDBC URL, username and password of MySQL server
        String url = "jdbc:mysql://mysql-2ea2fb0b-poo-42cc.h.aivencloud.com:23764/defaultdb";
        String user = "avnadmin";
        String password = "AVNS_kUewPuEAByr2oiDcj8t";

        // JDBC variables for opening and managing connection
        Connection con = null;
        PreparedStatement pst = null;

        String query = "INSERT INTO Annonce (id, likes, id_agent, wilaya, commune, localisation, type, type_appartement, superficie, nombre_pieces, etage, gaz, electricite, eau, meuble, garage, jardin, terasse, vle, prix, condition_p, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Establishing a connection
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement(query);

            // Setting the parameters
            pst.setInt(1, annonce.getID());
            pst.setInt(2, annonce.getLikes());
            pst.setInt(3, annonce.getIdAgent());
            pst.setString(4, annonce.getWilaya());
            pst.setString(5, annonce.getCommune());
            pst.setString(6, annonce.getLocalisation());
            pst.setString(7, annonce.getType());
            pst.setString(8, annonce.getTypeApparetement() != null ? annonce.getTypeApparetement() : null);
            pst.setInt(9, annonce.getSuperficie());
            pst.setInt(10, annonce.getNombrePièces());
            pst.setInt(11, annonce.getEtage());
            pst.setBoolean(12, annonce.getGaz());
            pst.setBoolean(13, annonce.getElectricité());
            pst.setBoolean(14, annonce.getEau());
            pst.setBoolean(15, annonce.getMeublé());
            pst.setBoolean(16, annonce.getGarage());
            pst.setBoolean(17, annonce.getJardin());
            pst.setBoolean(18, annonce.getTerasse());
            pst.setString(19, annonce.getVLE());
            pst.setInt(20, annonce.getPrix());
            pst.setInt(21, annonce.getConditionP());
            pst.setString(22, annonce.getDescription());

            // Executing the statement
            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



    public void Supprimer(int ID) {
        // JDBC URL, username and password of MySQL server
        String url = "jdbc:mysql://mysql-2ea2fb0b-poo-42cc.h.aivencloud.com:23764/defaultdb";
        String user = "avnadmin";
        String password = "AVNS_kUewPuEAByr2oiDcj8t";

        // JDBC variables for opening and managing connection
        Connection con = null;
        PreparedStatement pst = null;

        String query = "DELETE FROM Annonce WHERE ID = ?";

        try {
            // Establishing a connection
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement(query);

            // Setting the parameters
            pst.setInt(1, ID);

            // Executing the statement
            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void Assigner(int annonceID, int agentID) {
        // JDBC URL, username and password of MySQL server
        String url = "jdbc:mysql://mysql-2ea2fb0b-poo-42cc.h.aivencloud.com:23764/defaultdb";
        String user = "avnadmin";
        String password = "AVNS_kUewPuEAByr2oiDcj8t";

        // JDBC variables for opening and managing connection
        Connection con = null;
        PreparedStatement pst = null;

        String query = "UPDATE Annonce SET id_agent = ? WHERE id = ?";

        try {
            // Establishing a connection
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement(query);

            // Setting the parameters
            pst.setInt(1, agentID);
            pst.setInt(2, annonceID);

            // Executing the statement
            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}


