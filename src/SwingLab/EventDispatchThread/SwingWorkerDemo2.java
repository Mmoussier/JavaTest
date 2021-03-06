package SwingLab.EventDispatchThread;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SwingWorkerDemo2 {
    static int count = 0;
    static JButton bouton = new JButton("Pause");
    public static void main(String[] args){

        JFrame fen = new JFrame("EDT");
        fen.getContentPane().add(bouton);
        fen.setSize(300, 100);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.setLocationRelativeTo(null);
        fen.setVisible(true);
        updateBouton();

        System.out.println("Reprise du thread principal");
    }

    public static void updateBouton(){
        // Worker générique <Type1, Type2>
        // Type1 : type de la valeur de retour de doInBackground
        // Type2 : type de la valeur de retour intermédiaire (méthode publish)
        SwingWorker sw = new SwingWorker<Integer, String>(){
            protected Integer doInBackground() throws Exception {
                int i;
                for(i = 0; i < 5; i++){
                    try {
                        //On change la propriété d'état
                        setProgress(i);
                        //On publie un résultat intermédiaire (suivant le Type2 du SwingWorker)
                        publish("Tour de boucle N° " + (i+1));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return i; // résultat suivant le Type1 du SwingWorker
            }

            public void done(){
                if(SwingUtilities.isEventDispatchThread())
                    System.out.println("Dans l'EDT ! ");
                try {
                    //On utilise la méthode get() pour récupérer le résultat
                    //de la méthode doInBackground()
                    bouton.setText("Traitement terminé au bout de "+get()+" fois !");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            //La méthode gérant les résultats intermédiaires
            public void process(List<String> list){
                for(String str : list)
                    System.out.println(str);
            }
        };
        //On écoute le changement de valeur pour la propriété
        sw.addPropertyChangeListener(new PropertyChangeListener(){
            //Méthode de l'interface
            public void propertyChange(PropertyChangeEvent event) {
                //On vérifie tout de même le nom de la propriété
                if("progress".equals(event.getPropertyName())){
                    if(SwingUtilities.isEventDispatchThread())
                        System.out.println("Dans le listener donc dans l'EDT ! ");
                    //On récupère sa nouvelle valeur
                    bouton.setText("Pause " + (Integer) event.getNewValue());
                }
            }
        });
        //On lance le SwingWorker
        sw.execute();
    }
}
