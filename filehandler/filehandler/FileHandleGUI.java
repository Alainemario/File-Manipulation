package filehandler;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileHandleGUI extends JFrame {

    private JTextArea textArea;
    private JFileChooser fileChooser;
    private File selectedFile;

    public FileHandleGUI() {
        setTitle("File Handler");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        fileChooser = new JFileChooser();

        JButton openBtn = new JButton("Open File");
        JButton writeBtn = new JButton("Write");
        JButton readBtn = new JButton("Read");
        JButton modifyBtn = new JButton("Modify");
        JButton exitBtn = new JButton("Exit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openBtn);
        buttonPanel.add(writeBtn);
        buttonPanel.add(readBtn);
        buttonPanel.add(modifyBtn);
        buttonPanel.add(exitBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listeners
        openBtn.addActionListener(e -> openFile());
        writeBtn.addActionListener(e -> {
            if (checkFileSelected())
                FileOperations.writeToFile(selectedFile, textArea.getText());
        });
        readBtn.addActionListener(e -> {
            if (checkFileSelected())
                textArea.setText(FileOperations.readFromFile(selectedFile));
        });
        modifyBtn.addActionListener(e -> {
            if (checkFileSelected()) {
                String oldWord = JOptionPane.showInputDialog(this, "Enter word to replace:");
                String newWord = JOptionPane.showInputDialog(this, "Enter new word:");
                FileOperations.modifyFileContent(selectedFile, oldWord, newWord);
            }
        });
        exitBtn.addActionListener(e -> System.exit(0));
    }

    private void openFile() {
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this,
                    "Selected file: " + selectedFile.getAbsolutePath());
        }
    }

    private boolean checkFileSelected() {
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this,
                    "No file selected. Please open a file first.");
            return false;
        }
        return true;
    }
}
