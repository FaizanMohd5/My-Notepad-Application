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
    }
    public void createGUI(){
        frame = new JFrame("Notepad");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        frame.add(textArea);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        colorMenu = new JMenu("Color");
        formatMenu = new JMenu("Format");

        frame.add(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(colorMenu);
        menuBar.add(formatMenu);
    }
}
