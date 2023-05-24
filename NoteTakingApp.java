import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NoteTakingApp extends JFrame implements ActionListener {
    private JTextArea noteArea;
    private JFileChooser fileChooser;

    public NoteTakingApp() {
        super("Note Taking App");

        // Create the text area for the note
        noteArea = new JTextArea(20, 40);

        // Create the menu bar and menus
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        // Create the file menu items
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(this);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(this);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(this);

        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        saveAsMenuItem.addActionListener(this);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);

        // Add the file menu items to the file menu
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Add the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Add the text area to the frame
        add(new JScrollPane(noteArea), BorderLayout.CENTER);

        // Create the file chooser
        fileChooser = new JFileChooser();

        // Set the size and make the frame visible
        setSize(500, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("New")) {
            noteArea.setText("");
        } else if (command.equals("Open")) {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getName();
                setTitle(fileName);
                // TODO: Load the file contents into the note area
            }
        } else if (command.equals("Save")) {
            // TODO: Save the note to the current file
        } else if (command.equals("Save As")) {
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getName();
                setTitle(fileName);
                // TODO: Save the note to the selected file
            }
        } else if (command.equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new NoteTakingApp();
    }
}
