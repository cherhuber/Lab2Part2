/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2part2;


import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author cherylann.huber329
 */
public class Dec2Bin extends JFrame implements ActionListener{
    //public static final int WIDTH = 300;
    //public static final int HEIGHT = 200;
    private JLabel lblInField = new JLabel("Enter a non-negative decimal number");
    private JTextField inField = new JTextField("Dec Number here",30);
    private JLabel lblOutField = new JLabel("The equivalent binary number is:");
    private JTextField outField = new JTextField("Bin Number here",30);
    
    public Dec2Bin(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT,2,2));
        JPanel inPanel =new JPanel(new GridLayout(1,2));
        JPanel outPanel =new JPanel(new GridLayout(2,1));
        
        
        JButton jbtConvert = new JButton("Convert");
        jbtConvert.addActionListener(this);
        JButton jbtClear = new JButton("Clear");
        jbtClear.addActionListener(this);
        JButton jbtExit = new JButton("Exit");
        jbtExit.addActionListener(this);
        
        p1.add(jbtConvert);
        p1.add(jbtClear);
        p1.add(jbtExit);
        inPanel.add(lblInField);
        inPanel.add(inField);
        outPanel.add(lblOutField);
        outPanel.add(outField);
        
        
        contentPane.add(inPanel,BorderLayout.NORTH);
        contentPane.add(outPanel,BorderLayout.CENTER);
        contentPane.add(p1,BorderLayout.SOUTH);        
        
        
    }
    
     public void integerToByte(double input, JTextField o)
    {
        //number = Double.doubleToLongBits(input);
        int bits = (int)input;
        o.setText(Integer.toBinaryString(bits));
    }
     private void displayNumberError(String m){
         inField.setText("**" + m + " Try again.**");
         inField.setBackground(Color.red);
     }
    @Override public void actionPerformed(ActionEvent e) //throws NumberException
    {
        if(e.getActionCommand().equals("Convert")){
            try{
                double num = Double.parseDouble(inField.getText());
                if(num < 0){
                    displayNumberError("Negative decimal number.");
                }//if
                else{
                    integerToByte(num,outField);
                    inField.setBackground(Color.white);
                }//else
            }catch (NumberFormatException err){
                displayNumberError("Not a valid number.");
            }//catch
            
        }
        else if(e.getActionCommand().equals("Clear")){
            inField.setText("");
            outField.setText("");
            inField.setBackground(Color.white);
        }
        else if(e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
    }
     public static void main(String[] args)
     {
        JFrame frame = new Dec2Bin();
        frame.setTitle("Decimal To Binary Converter");
        frame.setSize(600,150);
        frame.setLocationRelativeTo(null);//center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
     }

   
}
