package SwingLab.Layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by morgannm on 01/10/2016.
 */
public class LayoutTest2 extends JFrame {
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel titre;
    private JList solutionsList;
    private Vector<EstimateSolution> solutions;
    private JLabel progression;
    private JScrollPane listScrollPane;
    private JTextArea solutionDetail;

    public LayoutTest2() {
        super("Calcul devis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Init();
        titre.setText("Devis : ");
    }

    private void Init() {
        setSize(1200,600);
        setLocationRelativeTo(null); // centrer la fenêtre

        // Définition des éléments d'interfaces de la fenêtre
        topPanel = new JPanel();
        titre = new JLabel("");
        topPanel.add(titre);
        add(topPanel, BorderLayout.PAGE_START);

        bottomPanel = new JPanel();
        progression = new JLabel("Calcul en cours...");
        bottomPanel.add(progression);
        add(bottomPanel,BorderLayout.SOUTH);

        // Liste des solutions sur la gauche de la fenêtre
        solutions = new Vector<>();
        for(int i=0;i<10;i++) {
            EstimateSolution sol = new EstimateSolution();
            sol.Description = "Solution n°" + i;
            solutions.add(sol);
        }
        solutionsList = new JList(solutions);
        solutionsList.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // marge à l'intérieur de la liste
        listScrollPane = new JScrollPane(solutionsList);
        listScrollPane.setBorder(BorderFactory.createEmptyBorder(0,5,0,5)); // espace à l'extérieur
        add(listScrollPane, BorderLayout.LINE_START);

        // Détail solution : reste de l'espace disponible au centre et à droite
        solutionDetail = new JTextArea(8,40);
        JScrollPane areaScrollPane = new JScrollPane(solutionDetail);
        areaScrollPane.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Détail de la solution"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                        areaScrollPane.getBorder()));
        add(areaScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void displayMessage(String Message) {
        progression.setText(Message);
        //System.out.println(Message);
    }

    public static void main(String[] arguments) {
        LayoutTest2 lt = new LayoutTest2();
    }

    public class EstimateSolution {
        public String Description;
        public String toString() {
            return Description;
        }
    }
}

