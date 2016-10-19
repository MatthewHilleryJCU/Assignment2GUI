package com.codebind;

import javax.swing.*;
import java.awt.*;

/**
 * Created by matt on 18/10/2016.
 */
public class mainFrame extends JFrame{

    private DetailsPanel detailsPanel;

    public mainFrame (String title) {
        super(title);

        // Set layout manager
        setLayout(new BorderLayout());

        //Create Swing components
        final JTextArea textArea = new JTextArea();

        detailsPanel = new DetailsPanel();

        detailsPanel.addDetailListener(new DetailListener() {
            public void detailEventOccurred(DetailEvent event) {
                String text = event.getText();

                textArea.append(text);
            }
        });



        // Add swing components to content pane
        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.WEST);

        // Add behaviour

    }
}
