package RatMaze;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MainView extends JPanel {

    /////////////////////////////////////////////////////////////////////////////Home needs
    private JLabel welcome = new JLabel("Welcome");
    private JLabel dimensionLabel = new JLabel("Enter dimensions of the maze: ");
    private JLabel noteLabel = new JLabel("(If dimensions are N*N, only enter N)");
    private JTextField dimensionsField = new JTextField();
    private JButton buildItButton = new JButton("Build it!");
    private int dimensions;

    private onButtonClick click = new onButtonClick();

    public MainView() {
        /////////////////////////////////////////////////////////////////////////Home panel content
        this.setLayout(null);
        this.setBackground(new Color(115, 194, 251));
        this.add(welcome);
        this.add(dimensionLabel);
        this.add(noteLabel);
        this.add(dimensionsField);
        this.add(buildItButton);

        welcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        dimensionLabel.setFont(new Font("", Font.ITALIC, 25));
        noteLabel.setFont(new Font("", Font.ITALIC, 14));
        dimensionsField.setFont(new Font("", Font.PLAIN, 20));
        buildItButton.setFont(new Font("", Font.ITALIC, 25));

        welcome.setBounds(290, 50, 170, 50);
        dimensionLabel.setBounds(220, 200, 350, 30);
        noteLabel.setBounds(250, 235, 350, 30);
        dimensionsField.setBounds(300, 300, 150, 30);
        buildItButton.setBounds(300, 400, 150, 50);

        buildItButton.setBackground(new Color(33, 33, 33));
        buildItButton.setForeground(new Color(255, 255, 255));

        buildItButton.addActionListener(click);
        ///border
        TitledBorder border = new TitledBorder("start page");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.WHITE);
        border.setTitleFont(new Font("", Font.BOLD, 15));
        this.setBorder(border);
    }

    private class onButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /////////////////////////////////////////////////////////////////////Home PAGE BUTTONS
            if (e.getSource() == buildItButton) {
                try {
                    if (!dimensionsField.getText().isEmpty()) {
                        dimensions = Integer.parseInt(dimensionsField.getText());
                        if (dimensions>=3)
                        {
                            MainView.this.removeAll();
                            revalidate();
                            repaint();
                            new GridFrame(dimensions);
                            JFrame terminate = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                            terminate.dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Dimensions must be 3 or more!");

                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Enter dimensions first!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }
}
