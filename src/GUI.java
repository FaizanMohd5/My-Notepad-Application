import javax.swing.*;

public class GUI {
    JFrame frame;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, colorMenu;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
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
        iNew = new JMenuItem("New");
        fileMenu.add(iNew);
        iOpen = new JMenuItem("Open");
        fileMenu.add(iOpen);
        iSave = new JMenuItem("Save");
        fileMenu.add(iSave);
        iSaveAs = new JMenuItem("Save As");
        fileMenu.add(iSaveAs);
        iExit = new JMenuItem("Exit");
        fileMenu.add(iExit);

        menuBar.add(editMenu);
        menuBar.add(colorMenu);
        menuBar.add(formatMenu);
    }
}
