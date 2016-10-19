package com.codebind;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by matt on 18/10/2016.
 */
public class DetailsPanel extends JPanel{

    private EventListenerList listenerList = new EventListenerList();

    public DetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);

        setBorder(BorderFactory. createTitledBorder("Game Details"));

        JLabel nameLabel = new JLabel("Name: ");
        JLabel numPlayersLabel = new JLabel("Number of players: ");

        final JTextField nameField = new JTextField(10);
        final JTextField numPlayersField = new JTextField(10);

        JButton addBtn = new JButton("New Game");

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();

                String text = "Hello " + name + "\n Your cards are: \n Card 1 \n Card 2 \n Card 3 \n Card 4 \n Card 5 \n Card 6 \n Card 7";

                fireDetailEvent(new DetailEvent(this, text));
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // First Column
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        add(nameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(numPlayersLabel, gc);

        // Second Column
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        gc.gridy = 0;
        add(nameField, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(numPlayersField, gc);

        // Final Row
        gc.weighty = 10;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 1;
        gc.gridy =2;
        add(addBtn, gc);


    }

    public void fireDetailEvent(DetailEvent event){
        Object[] listeners = listenerList.getListenerList();

        for(int i=0; i < listeners.length; i += 2) {
            if (listeners[i] == DetailListener.class) {
                ((DetailListener)listeners[i+1]).detailEventOccurred(event);
            }
        }
    }

    public void addDetailListener(DetailListener listener){
        listenerList.add(DetailListener.class, listener);

    }

    public void removeDetailListener(DetailListener listener){
        listenerList.remove(DetailListener.class, listener);

    }
}
