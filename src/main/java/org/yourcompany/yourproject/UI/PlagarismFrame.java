package org.yourcompany.yourproject.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlagarismFrame extends JFrame{
    // GUI for the project

    // make drop down menu
    private JComboBox<String> algorithmBox = new JComboBox<>(new String[]{
        "Jaccard","Cosine", "TF-IDF"
    });

    public PlagarismFrame(){
        // GUI Window
        setTitle("Plagarism Checker");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // create top panel
        add(buildTopPanel(), BorderLayout.NORTH);
    }

    // ----- UI BUILDERS -----
    private JPanel buildTopPanel(){ 
        // 2 buttons for uploading text1 and text2 and drop down menu for choosing alg
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton load1 = new JButton("Load File 1");
        JButton load2 = new JButton("Load File 2");

        panel.add(load1);
        panel.add(load2);
        panel.add(new JLabel("Algorithms"));
        panel.add(algorithmBox);

        return panel;
    }
}
