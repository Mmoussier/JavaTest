package Objects.InterfaceDefault;

public class Alien implements Pondre, Mitose {
    @Override
    public void reproduire() {
        System.out.println("Je suis un alien et : ");
        Pondre.super.reproduire();
        Mitose.super.reproduire();
    }
}
