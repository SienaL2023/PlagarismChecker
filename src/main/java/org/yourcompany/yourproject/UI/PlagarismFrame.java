package org.yourcompany.yourproject.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.yourcompany.yourproject.algorithm.CosineSimilarity;
import org.yourcompany.yourproject.algorithm.JaccardSimilarity;
import org.yourcompany.yourproject.algorithm.SimilarityAlgorithm;
import org.yourcompany.yourproject.algorithm.TFIDFSimilarity;
import org.yourcompany.yourproject.engine.SimilarityEngine;
import org.yourcompany.yourproject.util.TextLoader;

public class PlagarismFrame extends JFrame{
    // GUI for the project

    private JTextArea textArea1 = new JTextArea();
    private JTextArea textArea2 = new JTextArea();
    private JLabel resultLabel = new JLabel("Similarity: --%");

    // make drop down menu
    private JComboBox<String> algorithmBox = new JComboBox<>(new String[]{
        "Jaccard","Cosine", "TF-IDF"
    });
    SimilarityEngine engine = new SimilarityEngine();

    public PlagarismFrame(){
        // GUI Window
        setTitle("Plagarism Checker");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create top panel
        add(buildTopPanel(), BorderLayout.NORTH);
        add(buildCenterPanel(), BorderLayout.CENTER);
        add(buildBottomPanel(), BorderLayout.SOUTH);
    }

    // ----- UI BUILDERS -----
    private JPanel buildTopPanel(){ 
        // 2 buttons for uploading text1 and text2 and drop down menu for choosing alg
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton load1 = new JButton("Load File 1");
        JButton load2 = new JButton("Load File 2");

        load1.addActionListener(e -> {
            try {
                loadFile(textArea1);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        load2.addActionListener(e -> {
            try {
                loadFile(textArea2);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        panel.add(load1);
        panel.add(load2);
        panel.add(new JLabel("Algorithms:"));
        panel.add(algorithmBox);

        return panel;
    }

    private JPanel buildCenterPanel(){
        JPanel panel = new JPanel(new GridLayout(1,2,10,10));

        textArea1.setBorder(BorderFactory.createTitledBorder("Document 1"));
        textArea2.setBorder(BorderFactory.createTitledBorder("Document 2"));

        panel.add(new JScrollPane(textArea1));
        panel.add(new JScrollPane(textArea2));

        return panel;
    }

    private JPanel buildBottomPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        JButton compare = new JButton("Compare!");

        
        compare.addActionListener(e -> {
            try {
                compareFiles();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        panel.add(compare, BorderLayout.WEST);
        panel.add(resultLabel, BorderLayout.CENTER);
        return panel;
    }

    // BUTTON LOGIC
    private void loadFile(JTextArea target) throws IOException{
        JFileChooser chooser = new JFileChooser();
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            target.setText(TextLoader.load(file.getPath()));
        }
    }

    private void compareFiles(){

        String text1 = textArea1.getText();
        String text2 = textArea2.getText();
        SimilarityAlgorithm algo = null;

        switch ((String) algorithmBox.getSelectedItem()){
            case "Cosine":
                algo = new CosineSimilarity();
                break;
            case "TF-IDF":
                algo = new TFIDFSimilarity();
                break;
            case "Jaccard":
                algo = new JaccardSimilarity();
                break;
            default:
                algo = null;
        }

        double score = engine.compute(text1, text2, algo);
        resultLabel.setText(String.format("Similarity: %.2f%%", score *100));
    }
}
