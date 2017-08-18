import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class DisplayTable extends JPanel {
    private JLabel[] rowHeaders;

    public DisplayTable(String[] rowHeaders){
        super();


    }

    private void setRowHeaders(JLabel[] rowHeaders){
        rowHeaders = new JLabel[rowHeaders.length];
    }
    public void addTotals(String[] totalsList,  String[] tatalsValues){

    }
}