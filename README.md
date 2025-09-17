
FileHandle Java GUI Application

A simple Java Swing-based GUI application for performing basic file handling operations. This project provides an easy-to-use interface to open, read, write, and modify file content without relying on a console menu.

✨ Features

✅ Open File – Select a file using a file chooser dialog

✅ Write to File – Overwrite file content with the editor text

✅ Read File – Load file content into the text editor

✅ Modify Content – Replace specific words in the file

✅ Exit – Close the application safely

🛠 How It Works

The application uses a Swing GUI (JFrame, JButton, JTextArea) to interact with the user.

A JTextArea allows typing or viewing file content.

File operations are handled through a separate FileOperations utility class.

The application is modular, split into:

AppLauncher.java → Main entry point

FileHandleGUI.java → GUI (Swing components)

FileOperations.java → File handling logic

Libraries Used

javax.swing → GUI components

java.io → File read/write operations

java.nio.file → Modify file content

🚀 Prerequisites

Java Development Kit (JDK) 8 or above

Any IDE (IntelliJ, Eclipse, NetBeans) or terminal to compile and run

▶️ Running the Application

Compile the project:
