package Objects.Decorator.Patisserie.Couche;

import Objects.Decorator.Patisserie.Patisserie;

public class CoucheChocolat extends Couche {
    public CoucheChocolat(Patisserie p) {
        super(p);
        this.nom = "\t- Une couche de chocolat.\n";
    }
}
