package filehandler;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class FileOperations {

    public static void writeToFile(File file, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
            JOptionPane.showMessageDialog(null, "File written successfully.");
        } catch (IOException e) {
            showError(e);
        }
    }

    public static String readFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            JOptionPane.showMessageDialog(null, "File read successfully.");
        } catch (IOException e) {
            showError(e);
        }
        return sb.toString();
    }

    public static void modifyFileContent(File file, String oldWord, String newWord) {
        try {
            Path path = file.toPath();
            String content = new String(Files.readAllBytes(path));
            content = content.replaceAll(oldWord, newWord);
            Files.write(path, content.getBytes());
            JOptionPane.showMessageDialog(null, "File content modified.");
        } catch (IOException e) {
            showError(e);
        }
    }

    private static void showError(IOException e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
