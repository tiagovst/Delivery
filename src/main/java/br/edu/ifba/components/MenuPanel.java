package br.edu.ifba.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuPanel extends JPanel {
    private JList<String> menuList;
    private DefaultListModel<String> menuListModel;

    public MenuPanel() {
        setLayout(new BorderLayout());

        menuListModel = new DefaultListModel<>();
        menuList = new JList<>(menuListModel);
        menuList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        menuList.setVisibleRowCount(3);
        menuList.setFixedCellWidth(100);
        menuList.setFixedCellHeight(100);
        menuList.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(menuList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addItem(String item) {
        menuListModel.addElement(item);
    }

    @Override
    public Dimension getPreferredSize() {
        int width = (int) (menuList.getFixedCellWidth() * 3.5);
        int height = (int) (menuList.getFixedCellHeight() * 1.5);
        return new Dimension(width, height);
    }
}