/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Exceptions.MissingRightParenthesisException;
import Objetos.CharArray;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author luisl
 */
public class PrincipalFrame extends JFrame{
    
    private JPanel input;
    private JPanel keyboard;
    private JPanel output;
    private JPanel buttons;
    
    private TitledBorder tinput;
    private TitledBorder toutput;
    
    private JButton ac;
    private JButton del;
    private JButton A;
    private JButton B;
    private JButton C;
    private JButton D;
    private JButton E;
    private JButton F;
    private JButton addition;
    private JButton division;
    private JButton multiplication;
    private JButton substraction;
    private JButton power;
    private JButton equals;
    private JButton p1;
    private JButton p2;
    
    private CharArray operation;
    
    private JLabel jtaOperation;
    private JLabel jtaResult;
    
    public PrincipalFrame(){
        super("Calculadora Polaca");
        super.setSize(450,600);
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/icono.png")).getImage());
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tinput = new TitledBorder(new EtchedBorder(),"Input");
        toutput = new TitledBorder(new EtchedBorder(),"Output");
        
        jtaOperation = new JLabel();
        jtaResult = new JLabel();
        
        operation = new CharArray();
        
        input = new JPanel();
        input.setBorder(tinput);
        
        input.setBackground(Color.LIGHT_GRAY);
        input.setPreferredSize(new Dimension(0,100));
        super.add(input,BorderLayout.NORTH);//----------------------------------Esta parte agrega la pantalla input
        input.add(jtaOperation);
        
        keyboard = new JPanel(new BorderLayout());
        output = new JPanel();
        output.setBorder(toutput);
        output.setBackground(Color.LIGHT_GRAY);
        output.setPreferredSize(new Dimension(0,100));
        output.add(jtaResult);
        
        keyboard.add(output,BorderLayout.NORTH);//------------------------------Esta parte agrega la pantalla output
        
        buttons = new JPanel(new GridLayout(4,4));//----------------------------La matriz donde se van a agregar los botones
        
        ac = new JButton("AC");//-----------------------------------------------Inicialización de los botones
        ac.setFont(new Font("Candara",1,35));
        ac.setBackground(new Color(180,0,0));
        
        del = new JButton("DEL");
        del.setFont(new Font("Candara",1,35));
        del.setBackground(new Color(180,0,0));
        
        A = new JButton("A");
        A.setFont(new Font("Candara",1,35));
        A.setBackground(Color.LIGHT_GRAY);
        
        B = new JButton("B");
        B.setFont(new Font("Candara",1,35));
        B.setBackground(Color.LIGHT_GRAY);
        
        C = new JButton("C");
        C.setFont(new Font("Candara",1,35));
        C.setBackground(Color.LIGHT_GRAY);
        
        D = new JButton("D");
        D.setFont(new Font("Candara",1,35));
        D.setBackground(Color.LIGHT_GRAY);
        
        E = new JButton("E");
        E.setFont(new Font("Candara",1,35));
        E.setBackground(Color.LIGHT_GRAY);
        
        F = new JButton("F");
        F.setFont(new Font("Candara",1,35));
        F.setBackground(Color.LIGHT_GRAY);
        
        addition = new JButton("+");
        addition.setFont(new Font("Candara",1,35));
        addition.setBackground(Color.DARK_GRAY);
        addition.setForeground(Color.white);
        
        division = new JButton("/");
        division.setFont(new Font("Candara",1,35));
        division.setBackground(Color.DARK_GRAY);
        division.setForeground(Color.white);
        
        multiplication = new JButton("*");
        multiplication.setFont(new Font("Candara",1,35));
        multiplication.setBackground(Color.DARK_GRAY);
        multiplication.setForeground(Color.white);
        
        substraction = new JButton("-");
        substraction.setFont(new Font("Candara",1,35));
        substraction.setBackground(Color.DARK_GRAY);
        substraction.setForeground(Color.white);
        
        power = new JButton("^");
        power.setFont(new Font("Candara",1,35));
        power.setBackground(Color.DARK_GRAY);
        power.setForeground(Color.white);
        
        equals = new JButton("=");
        equals.setFont(new Font("Candara",1,35));
        equals.setBackground(new Color(180,0,0));
        
        p1 = new JButton("(");
        p1.setFont(new Font("Candara",1,35));
        p1.setBackground(Color.DARK_GRAY);
        p1.setForeground(Color.white);
        
        p2 = new JButton(")");
        p2.setFont(new Font("Candara",1,35));
        p2.setBackground(Color.DARK_GRAY);
        p2.setForeground(Color.white);
        
        buttons.add(ac);//------------------------------------------------------añadiendo los botones a la matriz
        buttons.add(del);
        buttons.add(p1);
        buttons.add(p2);
        buttons.add(A);
        buttons.add(B);
        buttons.add(C);
        buttons.add(addition);
        buttons.add(D);
        buttons.add(E);
        buttons.add(F);
        buttons.add(substraction);
        buttons.add(multiplication);
        buttons.add(division);
        buttons.add(power);
        buttons.add(equals);
        
        keyboard.add(buttons,BorderLayout.CENTER);
        
        
        super.add(keyboard,BorderLayout.CENTER);//------------------------------Esta línea agrega el teclado y pantalla output a la ventana principal
        
        p1.addActionListener(new ActionListener() {//---------------------------Se describe la función del botón de (
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('(');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        //----------------------------------------------------------------------Aquí se describen las funciones que cada tecla tiene
        
        p2.addActionListener(new ActionListener() {//---------------------------Se describe la función del botón de (
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding(')');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('A');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('B');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('C');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('D');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('E');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        F.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('F');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('+');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('/');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('*');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        substraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('-');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        power.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.adding('^');
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
        });
        
        del.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.removeLast();
                jtaOperation.setText(operation.convertString());
                jtaOperation.setFont(new Font("Eras Light ITC",1,35));
            }
            
        });
        
        ac.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                operation.removeAll();
                jtaOperation.setText(operation.convertString());
                jtaResult.setText("");
            }
        });
        
        equals.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //operation.removeAll();
                if( operation.isCorrect()){
                 jtaResult.setText(operation.shuntingYard());
                 jtaResult.setFont(new Font("Eras Light ITC",1,35));   
                }else{
                    try{
                        throw new MissingRightParenthesisException();
                    }catch(MissingRightParenthesisException ex){
                        error1(ex);
                    }
                }
            }
        });
    }
    
    public void error1(MissingRightParenthesisException ex){
        JOptionPane.showMessageDialog(this,"Falta un paréntesis.","Error!",JOptionPane.ERROR_MESSAGE);
    }
    
    //public void error2( )
}