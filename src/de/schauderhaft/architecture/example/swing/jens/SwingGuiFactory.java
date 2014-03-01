package de.schauderhaft.architecture.example.swing.jens;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import de.schauderhaft.architecture.example.CrosswordGame;

public class SwingGuiFactory implements GuiFactory {

    @Override
    public void create(CrosswordGame game) {
        JFrame main = new JFrame("Crossword Game");
        Container contentPane = main.getContentPane();
        addComponents(contentPane, game);
        main.pack();
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    private void addComponents(Container contentPane, final CrosswordGame game) {
        final JTextField textbox = new JTextField(20);
        JButton submit = new JButton("Submit");
        final ScoreBoardBuilder scoreBoardBuilder = new ScoreBoardBuilder();

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                scoreBoardBuilder.getApi().setValue(
                        game.submit(textbox.getText()));
            }
        });

        contentPane.setLayout(new FlowLayout());
        contentPane.add(textbox);
        contentPane.add(submit);
        contentPane.add(scoreBoardBuilder.getComponent());
    }
}
