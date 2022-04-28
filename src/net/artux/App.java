package net.artux;

import javax.swing.*;

public class App {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());

        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
    }
}
