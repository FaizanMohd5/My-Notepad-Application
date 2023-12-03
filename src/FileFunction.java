import java.awt.*;
import java.io.*;

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
        //save overwrites the existing file. ie modifies the same file.
        FileDialog fileDialog = new FileDialog(gui.frame, "Save", FileDialog.SAVE);
        // Code was removed
    }
    public void saveAsFile(){
        FileDialog fileDialog = new FileDialog(gui.frame, "Save As", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if(fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.frame.setTitle(fileName);
        }
        try{
            FileWriter fileWriter = new FileWriter(fileAddress + fileName);
            fileWriter.write(gui.textArea.getText());
            gui.frame.setTitle(fileName);
        } catch (Exception e){
            System.out.println("Something wrong in save as method");
        }
    }
}
