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

public class MainFrame extends JFrame {
    public static final String PROGRAM_TITLE = "Sales Tracker";

    public static final String NEW_BUTTON_TEXT = "New";
    public static final String EDIT_BUTTON_TEXT = "Edit";
    public static final String DELETE_BUTTON_TEXT = "Delete";
    public static final String SEARCH_BUTTON_TEXT = "Search";
    public static final String VIEW_BUTTON_TEXT = "View";
    public static final String REPORTS_BUTTON_TEXT = "Reports";
		
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;

    private JPanel westButtonPanel, tablePanel, navigationPanel, salesPanel, inventoryPanel;
    private JTabbedPane tabbedPane; 
    private JComboBox ledgerSelect;
    private JButton newButton, editButton, deleteButton, searchButton, viewButton, reportsButton;


    public MainFrame(){
        super();
        this.setSize(WIDTH, HEIGHT);
        this.setTitle(PROGRAM_TITLE);
        this.setLocation(500, 350);
        this.setLayout(new BorderLayout());
        westPanelInit();
        tablePanelInit();
        navigationPanelInit();
        this.addWindowListener(new WindowAdapter() { 
                @Override
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            });
    }

    public void westPanelInit(){
        westButtonPanel = new JPanel();
        westButtonPanel.setLayout(new GridLayout(6,1));
        this.add(westButtonPanel, BorderLayout.WEST);

        viewButton = new JButton(VIEW_BUTTON_TEXT);
        westButtonPanel.add(viewButton);

        editButton = new JButton(EDIT_BUTTON_TEXT);
        westButtonPanel.add(editButton);

        newButton = new JButton(NEW_BUTTON_TEXT);
        westButtonPanel.add(newButton);        

        deleteButton = new JButton(DELETE_BUTTON_TEXT);
        westButtonPanel.add(deleteButton);

        searchButton = new JButton(SEARCH_BUTTON_TEXT);
        westButtonPanel.add(searchButton);

        reportsButton = new JButton(REPORTS_BUTTON_TEXT);
        westButtonPanel.add(reportsButton);

    }
    public void navigationPanelInit(){
        String[] array = { "Ledger1", "Ledger2", "Ledger3"};
        navigationPanel = new JPanel();
        navigationPanel.setLayout(new BorderLayout()); 

        ledgerSelect = new JComboBox(array);

        navigationPanel.add(ledgerSelect, BorderLayout.CENTER);

        this.add(navigationPanel, BorderLayout.NORTH);


    } 
    public void tablePanelInit(){
        tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);        

        salesPanel = new JPanel();
        tabbedPane.addTab("Sales",salesPanel);

        inventoryPanel = new JPanel();
        tabbedPane.addTab("Inventory",inventoryPanel);

        this.add(tabbedPane, BorderLayout.CENTER);
    }


}