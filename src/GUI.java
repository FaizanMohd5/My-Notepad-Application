import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    JFrame frame;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, colorMenu;
    //File menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    //Format menu
    JMenuItem iWordWrap;
    JMenu fontMenu, fontSizeMenu;
    JMenuItem iFontArial, iFontCSMS, iFontTMR, iFontSize8, iFontSize12, iFontSize16, iFontSize24, iFontSize28;
    FileFunction fileFunction = new FileFunction(this);
    FormatFunction formatFunction = new FormatFunction(this);
    public GUI(){
        createGUI();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();

        frame.setVisible(true);

    }
    public void createGUI(){
        frame = new JFrame("Notepad");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void createTextArea(){
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        colorMenu = new JMenu("Color");
        formatMenu = new JMenu("Format");

        frame.setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(colorMenu);
        menuBar.add(formatMenu);
    }
    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        fileMenu.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        fileMenu.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        fileMenu.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        fileMenu.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        fileMenu.add(iExit);
    }
    public void createFormatMenu(){
        iWordWrap = new JMenuItem("Word Wrap");
        iWordWrap.addActionListener(this);
        iWordWrap.setActionCommand("Word Wrap");
        formatMenu.add(iWordWrap);

        fontMenu = new JMenu("Font");
        formatMenu.add(fontMenu);

        fontSizeMenu = new JMenu("Font Size");
        formatMenu.add(fontSizeMenu);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        fontMenu.add(iFontArial);

        iFontCSMS = new JMenuItem("CSMS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("CSMS");
        fontMenu.add(iFontCSMS);

        iFontTMR = new JMenuItem("TMR");
        iFontTMR.addActionListener(this);
        iFontTMR.setActionCommand("TMR");
        fontMenu.add(iFontTMR);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("8");
        fontSizeMenu.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");
        fontSizeMenu.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");
        fontSizeMenu.add(iFontSize16);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("24");
        fontSizeMenu.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("28");
        fontSizeMenu.add(iFontSize28);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New" -> {
                fileFunction.newFile();
                break;
            }
            case "Open" -> {
                fileFunction.openFile();
                break;
            }
            case "Save" -> {
                fileFunction.saveFile();
                break;
            }
            case "Save As" -> {
                fileFunction.saveAsFile();
                break;
            }
            case "Exit" -> {
                fileFunction.exit();
                break;
            }
        }
    }
}
