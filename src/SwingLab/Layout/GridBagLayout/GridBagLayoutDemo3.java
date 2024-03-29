package SwingLab.Layout.GridBagLayout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo3 extends JFrame {
    public GridBagLayoutDemo3() {
        super("GridBagLayoutDemo3");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridBagLayout());

        JLabel serveurLabel = new JLabel("Serveur : ");
        JLabel uriLabel = new JLabel("URI : ");
        JComboBox serveursCourss = new JComboBox();
        serveursCourss.addItem("(aucun)");
        serveursCourss.addItem("Boursier.com");
        serveursCourss.addItem("Sicav Online");
        JTextField uriTextField = new JTextField("");
        JButton btnExecuter = new JButton("Exécuter");

        GridBagConstraints gbc = new GridBagConstraints();

        // Colonne 0 : Libellés
        gbc.gridwidth = gbc.gridheight=1;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0.2; // 20% de la largeur totale pour les libellés
        gbc.anchor = GridBagConstraints.LINE_START; // sinon le label se trouve au centre de la cellule
        gbc.insets = new Insets(5, 5, 0, 0);
        northPanel.add(serveurLabel,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth = gbc.gridheight=1;
        gbc.insets = new Insets(5, 5, 0, 0);
        northPanel.add(uriLabel,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth = gbc.gridheight=1;
        gbc.insets = new Insets(5, 5, 0, 0);
        northPanel.add(new JLabel("Port"),gbc);

        // Colonne 1 : zones de saisie
        // Type de serveur
        gbc.gridx=1;
        gbc.weightx=.8; // 80% de la largeur totale pour les contrôles de saisie
        gbc.gridy=0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;   // pour que la combo soit étendue sur toute la largeur disponible
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 0, 0, 5);
        northPanel.add(serveursCourss,gbc);

        // URI
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // la zone de saisie sera étendue sur toute la largeur
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 0, 0, 5);
        northPanel.add(uriTextField,gbc);

        // Port
        gbc.gridx=1;
        gbc.gridy=2;
        JTextField portTextField = new JTextField(6);
        gbc.fill = GridBagConstraints.NONE; // le TextField aura la largeur définie dans son constructeur
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 0, 0, 5);
        northPanel.add(portTextField,gbc);

        // Ligne 4 : bouton Exécuter
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.LINE_END; // sinon le label se trouve au centre de la cellule
        gbc.insets = new Insets(5, 0, 0, 5);
        northPanel.add(btnExecuter,gbc);

        add(northPanel,BorderLayout.NORTH);

        JLabel infoLabel = new JLabel("Formulaire de saisie avec zones de saisie sur 80% de la largeur");
        infoLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        add(infoLabel,BorderLayout.SOUTH);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        GridBagLayoutDemo3 gridBagLayoutDemo3 = new GridBagLayoutDemo3();
    }
}
