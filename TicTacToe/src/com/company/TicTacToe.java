package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel text_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textfeild=new JLabel();
    JButton[] Buttons=new JButton[9];
    boolean player1;
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfeild.setBackground(new Color(25,25,25));
        textfeild.setForeground((new Color(25,255,0)));
        textfeild.setFont(new Font("INK FREE",Font.BOLD,75));
        textfeild.setHorizontalAlignment(JLabel.CENTER);
        textfeild.setText("TIC-TAC-TOE");
        textfeild.setOpaque(true);

        text_panel.setLayout(new BorderLayout());
        text_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for (int i = 0; i < 9; i++) {
            Buttons[i]=new JButton();
            button_panel.add(Buttons[i]);
            Buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            Buttons[i].setFocusable(false);
            Buttons[i].addActionListener(this);

        }

        text_panel.add(textfeild);
        frame.add(text_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstturn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource()==Buttons[i]){
                if(player1){
                    if(Buttons[i].getText()==""){
                        Buttons[i].setForeground(new Color(150,10,10));
                        Buttons[i].setText("X");
                        player1=false;
                        textfeild.setText("O Turn");
                        check();
                    }
                }
                else{
                    if(Buttons[i].getText()==""){
                        Buttons[i].setForeground(new Color(10,10,155));
                        Buttons[i].setText("Y");
                        player1=true;
                        textfeild.setText("X Turn");
                        check();
                    }
                }
            }
        }

    }
    public void firstturn()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            player1=true;
            textfeild.setText("X turn");
        }
        else{
            player1=false;
            textfeild.setText("O turn");
        }
    }
    public void check(){
        if((Buttons[0].getText()=="X")&&(Buttons[1].getText()=="X")&&(Buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((Buttons[3].getText()=="X")&&(Buttons[4].getText()=="X")&&(Buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if((Buttons[6].getText()=="X")&&(Buttons[7].getText()=="X")&&(Buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if((Buttons[0].getText()=="X")&&(Buttons[3].getText()=="X")&&(Buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if((Buttons[1].getText()=="X")&&(Buttons[4].getText()=="X")&&(Buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((Buttons[2].getText()=="X")&&(Buttons[5].getText()=="X")&&(Buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((Buttons[0].getText()=="X")&&(Buttons[4].getText()=="X")&&(Buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((Buttons[2].getText()=="X")&&(Buttons[4].getText()=="X")&&(Buttons[6].getText()=="X")){
            xWins(2,4,6);
        }
        if((Buttons[0].getText()=="Y")&&(Buttons[1].getText()=="Y")&&(Buttons[2].getText()=="Y")){
            oWins(0,1,2);
        }
        if((Buttons[3].getText()=="Y")&&(Buttons[4].getText()=="Y")&&(Buttons[5].getText()=="Y")){
            oWins(3,4,5);
        }
        if((Buttons[6].getText()=="Y")&&(Buttons[7].getText()=="Y")&&(Buttons[8].getText()=="Y")){
            oWins(6,7,8);
        }
        if((Buttons[0].getText()=="Y")&&(Buttons[3].getText()=="Y")&&(Buttons[6].getText()=="Y")){
            oWins(0,3,6);
        }
        if((Buttons[1].getText()=="Y")&&(Buttons[4].getText()=="Y")&&(Buttons[7].getText()=="Y")){
            oWins(1,4,7);
        }
        if((Buttons[2].getText()=="Y")&&(Buttons[5].getText()=="Y")&&(Buttons[8].getText()=="Y")){
            oWins(2,5,8);
        }
        if((Buttons[0].getText()=="Y")&&(Buttons[4].getText()=="Y")&&(Buttons[8].getText()=="Y")){
            oWins(0,4,8);
        }
        if((Buttons[2].getText()=="Y")&&(Buttons[4].getText()=="Y")&&(Buttons[6].getText()=="Y")){
            oWins(2,4,6);
        }
    }
    public void xWins(int a,int b,int c){
        Buttons[a].setBackground(Color.GREEN);
        Buttons[b].setBackground(Color.GREEN);
        Buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            Buttons[i].setEnabled(false);
        }
        textfeild.setText("X wins");
    }
    public void oWins(int a,int b,int c){
        Buttons[a].setBackground(Color.GREEN);
        Buttons[b].setBackground(Color.GREEN);
        Buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            Buttons[i].setEnabled(false);
        }
        textfeild.setText("O wins");
    }
}
