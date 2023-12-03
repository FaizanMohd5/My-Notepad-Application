import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    JFrame frame;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, colorMenu;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    FileFunction fileFunction = new FileFunction(this);
    public GUI(){
        createGUI();
        createTextArea();
        createMenuBar();
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
                break;
            }
        }
    }
}
