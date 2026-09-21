package ru.gr05506.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BadLibraryWindow extends JFrame {
    private JTextField tfAuthor = new JTextField();
    private JTextField tfTitle = new JTextField();
    private JTextField tfYear = new JTextField();
    private JTextField tfDop = new JTextField();
    private JButton btnAdd = new JButton();
    private JTextArea txtArea = new JTextArea();
    private JPanel panel = new JPanel();
    private List<String> list = new ArrayList<>();
    public BadLibraryWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600,400));

        btnAdd.setText("Добавить");
        btnAdd.addActionListener(e -> {
            String txtAuthor = tfAuthor.getText();
            String txtTitle = tfTitle.getText();
            String txtYear = tfYear.getText();
            String txtDop = tfDop.getText();
            if(txtAuthor == null || txtAuthor.isBlank()){
             JOptionPane.showMessageDialog(this, "Введите имя Автора хорошего");
            return;
            }
            if(txtTitle == null || txtTitle.isBlank()){
                JOptionPane.showMessageDialog(this, "Введите название замечательной книги");
                return;
            }
            if(txtYear == null || txtYear.isBlank()){
                JOptionPane.showMessageDialog(this, "Введите год издания");
                return;
            }
            list.add(txtAuthor + " " + txtTitle + " " + txtYear + " " + txtDop);
            txtArea.setText("");
            for (var el : list){
                txtArea.append(el + "\n");
            }
        });
        GroupLayout gl = new GroupLayout(panel);
        panel.setLayout(gl);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addGroup(gl.createParallelGroup()
                        .addComponent(tfAuthor)
                        .addComponent(tfTitle)
                        .addComponent(tfYear)
                        .addComponent(tfDop)
                )
                .addGap(8)
                .addComponent(btnAdd)
                .addGap(8)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addGroup(gl.createParallelGroup()
                        .addGroup(gl.createSequentialGroup()
                                .addComponent(tfAuthor)
                                .addGap(8)
                                .addComponent(tfTitle)
                                .addGap(8)
                                .addComponent(tfYear)
                                .addGap(8)
                                .addComponent(tfDop)
                        )
                        .addComponent(btnAdd)
                )
                .addGap(8)
        );

        add(panel,BorderLayout.NORTH);
        add(new JScrollPane(txtArea),BorderLayout.CENTER);
    }

}
