package com.github.melodyjoke.ideapluginlearning02toolwindow;

import javax.swing.*;
import java.io.File;

public class SettingUI {

    private JPanel mainPanel;

    private JPanel settingPanel;

    private JLabel urlLabel;

    private JButton urlButton;

    private JTextField urlTextField;

    public SettingUI() {
        urlButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.showOpenDialog(settingPanel);

            File file = fileChooser.getSelectedFile();
            urlTextField.setText(file.getPath());
        });
    }

    public JComponent getComponent() {
        return mainPanel;
    }

    public JTextField getUrlTextField() {
        return urlTextField;
    }
}
