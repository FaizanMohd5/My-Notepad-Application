import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileFunction {
    GUI gui;
    String fileName;
    String fileAddress;
    public FileFunction(GUI gui){
        this.gui = gui;
    }
    public void newFile(){
        gui.textArea.setText("");
        gui.frame.setTitle("New");
    }
    public void openFile(){
        FileDialog fileDialog = new FileDialog(gui.frame, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);
        //load content of the file
        if(fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.frame.setTitle(fileName);
        }
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");
            String line = null;
            while((line = bufferedReader.readLine())!=null){
                gui.textArea.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File Not Opened");
        }
    }
    public void saveFile(){
        FileDialog fileDialog = new FileDialog(gui.frame, "Save", FileDialog.SAVE);
    }
}
