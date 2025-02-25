package org.example;

import org.example.controller.dump;

import javax.swing.*;
import java.awt.*;

public class FrameApp extends JFrame {
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
    String [] colunas = {"Ação", "ArrayList", "LinkedList", "Vencedora"};


    public FrameApp() {
        super("Resultados");
    }

    public void criaJanela(){

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(getDados(), colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setVisible(true);
    }

    private Object[][] getDados() {
        dump dump = new dump();

        return dump.retornaDados();
    }
}
