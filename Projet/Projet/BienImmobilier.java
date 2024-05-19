//made by Billal
public class BienImmobilier 
{
  String Wilaya;
  String Commune;
  String Localisation; //Adresse exacte

  String Type; // Villa - Appartement - Local - Terrain - Hangar
  String TypeApparetement; // Simple - Duplex - Penthouse
  int Superficie; // en m²
  int NombrePièces;
  int Etage;

  Boolean Gaz, Electricité, Eau, Meublé, Garage, Jardin, Terasse;

  String VLE; // Vente - Location - Echange
  int Prix; // en DA

  int ConditionP; // entre 2 et 9  (on peut les additionner)
                  // 2 = Promesse de vente possible    3 = Crédit bancaire possible    4 = Paiement par tranches possible
  String ConditionPaiement;

  String Description;



// CONSTRCUTORS
public BienImmobilier(){}
public BienImmobilier( String Wilaya, String Commune, String Localisation, String Type, String TypeApparetement, int Superficie, int NombrePièces, int Etage, Boolean Gaz, Boolean Electricité, Boolean Eau, Boolean Meublé, Boolean Garage, Boolean Jardin, Boolean Terasse, String VLE,  int Prix,  int ConditionP, String Description) 
{
          this.Wilaya = Wilaya;
          
          this.Commune = Commune;
          
          this.Localisation = Localisation;
          
          this.Type = Type;

          this.TypeApparetement = TypeApparetement;
          
          this.Superficie = Superficie;
          
          this.NombrePièces = NombrePièces;
          
          this.Etage = Etage;
          
          this.Gaz = Gaz;
          
          this.Electricité = Electricité;
          
          this.Eau = Eau;
          
          this.Meublé = Meublé;
          
          this.Garage = Garage;
          
          this.Jardin = Jardin;
          
          this.Terasse = Terasse;
          
          this.VLE = VLE;
        
          this.Prix = Prix;
          
          this.ConditionP = ConditionP;
          
          this.Description = Description;

          switch (ConditionP) {
            case 2 -> ConditionPaiement = "Promesse de vente possible";
            
            case 3 -> ConditionPaiement = "Crédit bancaire possible";
            
            case 4 -> ConditionPaiement = "Paiement par tranches possible";
            
            case 5 -> ConditionPaiement = "Promesse de vente possible" + "Crédit bancaire possible";
            
            case 6 -> ConditionPaiement = "Promesse de vente possible" + "Paiement par tranches possible";
            
            case 7 -> ConditionPaiement = "Paiement par tranches possible" + "Crédit bancaire possible";
            
            case 9 -> ConditionPaiement = "Promesse de vente possible" + "Crédit bancaire possible" + "Paiement par tranches possible";
            
            default -> {
            }
        }
      }


// SETTERS
public void setWilaya(String wilaya) {
    Wilaya = wilaya;
}

public void setCommune(String commune) {
    Commune = commune;
}

public void setLocalisation(String localisation) {
    Localisation = localisation;
}

public void setType(String type) {
    Type = type;
}

public void setTypeApparetement(String typeApparetement) {
    TypeApparetement = typeApparetement;
}

public void setSuperficie(int superficie) {
    Superficie = superficie;
}

public void setNombrePièces(int nombrePièces) {
    NombrePièces = nombrePièces;
}

public void setEtage(int etage) {
    Etage = etage;
}

public void setGaz(Boolean gaz) {
    Gaz = gaz;
}

public void setElectricité(Boolean electricité) {
    Electricité = electricité;
}

public void setEau(Boolean eau) {
    Eau = eau;
}

public void setMeublé(Boolean meublé) {
    Meublé = meublé;
}

public void setGarage(Boolean garage) {
    Garage = garage;
}

public void setJardin(Boolean jardin) {
    Jardin = jardin;
}

public void setTerasse(Boolean terasse) {
    Terasse = terasse;
}

public void setVLE(String vLE) {
    VLE = vLE;
}

public void setPrix(int prix) {
    Prix = prix;
}

public void setConditionP(int conditionP) {
    ConditionP = conditionP;
}

public void setDescription(String description) {
    Description = description;
}



// GETTERS
public String getWilaya() {
    return Wilaya;
}

public String getCommune() {
    return Commune;
}

public String getLocalisation() {
    return Localisation;
}

public String getType() {
    return Type;
}

public String getTypeApparetement() {
    return TypeApparetement;
}

public int getSuperficie() {
    return Superficie;
}

public int getNombrePièces() {
    return NombrePièces;
}

public int getEtage() {
    return Etage;
}

public Boolean getGaz() {
    return Gaz;
}

public Boolean getElectricité() {
    return Electricité;
}

public Boolean getEau() {
    return Eau;
}

public Boolean getMeublé() {
    return Meublé;
}

public Boolean getGarage() {
    return Garage;
}

public Boolean getJardin() {
    return Jardin;
}

public Boolean getTerasse() {
    return Terasse;
}

public String getVLE() {
    return VLE;
}

public int getPrix() {
    return Prix;
}

public int getConditionP() {
    return ConditionP;
}

public String getConditionPaiement() {
    return ConditionPaiement;
}

public String getDescription() {
    return Description;
}
  
}

