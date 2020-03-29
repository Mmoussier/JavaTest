package SwingLab.JDialog.OpenClassRooms;

public class Personnage {
    private String nom, sexe, age, cheveux, taille;

    public Personnage(){}
    public Personnage(String nom, String sexe, String age, String cheveux, String taille){
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.cheveux = cheveux;
        this.taille = taille;
    }

    public String toString(){
        String str;
        if(this.nom != null && this.sexe != null && this.taille != null && this.age != null && this.cheveux != null){
            str = "Description de l'objet Personnage";
            str += "Nom : " + this.nom + "\n";
            str += "Sexe : " + this.sexe + "\n";
            str += "Age : " + this.age + "\n";
            str += "Cheveux : " + this.cheveux + "\n";
            str += "Taille : " + this.taille + "\n";
        }
        else{
            str = "Aucune information !";
        }
        return str;
    }
}

