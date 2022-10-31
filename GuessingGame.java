package NumberGuess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.Font;
import java.awt.Color;
//import java.awt.image.*;
    @SuppressWarnings("serial")
	class Test extends JFrame {
    int Guesses = 1;
    private int n;  
    private JTextField In;   
    private JLabel prompt;
    private JLabel message1;   
    private JLabel message2; 
    private JLabel message3;
    private JLabel message4;
    private JLabel random1 = new JLabel("");
    private JButton Check;
    private JButton Restart;  
   
    
     
    public Test() {
        super("Guessing Game");
        Border loweredbevel = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        Border raisedbevel = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Color custo1 = new Color(245,222,179);
        Color custo2 = new Color(119,136,153);
        Color custo3 = new Color(128,128,0);
        getContentPane().setLayout(null);  
        prompt = new JLabel("1.2.3.",SwingConstants.CENTER);
        prompt.setBounds(250,0,500,100);
        prompt.setFont(new Font("Tahoma", Font.PLAIN, 85));
        prompt.setForeground(Color.yellow);
        add(prompt);
        In = new JTextField(10); 
        In.setBackground(null);
        In.setBounds(250,110,500,40);
        add(In);
        message1 = new JLabel("",SwingConstants.CENTER);
        message1.setOpaque(true);
        message1.setBackground(custo1);
        message1.setForeground(custo3);
        message1.setBorder(loweredbevel);
        message1.setBounds(250,170,500,40);
        add(message1);
        message2= new JLabel("",SwingConstants.CENTER);
        message2.setOpaque(true);
        message2.setForeground(null);
        message2.setBorder(loweredbevel);
        message2.setBounds(250,290,500,40);
        add(message2);
        message3 = new JLabel("",SwingConstants.CENTER);
        message3.setOpaque(true);
        message3.setBackground(null);
        message3.setBorder(loweredbevel);
        message3.setBounds(250,325,500,40);
        add(message3);
        message4 = new JLabel("",SwingConstants.CENTER);
        message4.setOpaque(true);
        message4.setBackground(null);
        message4.setBorder(loweredbevel);
        message4.setBounds(250,360,500,40);
        add(message4);
        Check = new JButton("Check Me"); 
        Check.setBackground(custo2);
        Check.setForeground(Color.WHITE);
        Check.setBorder(raisedbevel);
        Check.setBounds(390,230,100,40);
        add(Check);
        Restart = new JButton("Restart"); 
        Restart.setBounds(500,230,100,40);
        Restart.setBackground(Color.WHITE);
        add(Restart);
        
        Random generator = new Random();
        n = generator.nextInt(101);
        
        Restart.addActionListener(
        new ActionListener()  
                {
                    public void actionPerformed(ActionEvent e) {
 
                        In.setText("");
                        Random generator = new Random();
                        n = generator.nextInt(101);
                        random1.setText("" + n);
                        SwingUtilities.updateComponentTreeUI(random1);
                        message1.setText("");
                        message2.setText("");
                        message3.setText("");
                        message4.setText("");
                        In.setEditable(true);
                        Guesses = 0;
                        Guesses++;
                    }   
               } );
        
        theGame();  
    }  
     
    public void theGame() {
 
     
    	
    	Check.addActionListener(
    			new ActionListener() 
    	{
        public void actionPerformed(ActionEvent e) {
 
        	int Guess;
            // JTextField In= (JTextField)e.getSource(); 	 
            Guess = Integer.parseInt(In.getText());
           
     	
            if (Guess > n) {
                message1.setText("Your guess is too high.");
                SwingUtilities.updateComponentTreeUI(message1);
 
            }
            if (Guess < n) {
 
                message1.setText("Your guess is too low.");
                SwingUtilities.updateComponentTreeUI(message1);
 
            }             
            if (Guess == n) {
                message1.setText("Your guess is correct!");
                SwingUtilities.updateComponentTreeUI(message1);
                In.setEditable(false);
 
            }
         
         
           
           
             message2.setText("You guessed " + Guess);
             message3.setText("You guessed " + Guess);
             message4.setText("You guessed " + Guess);
            }
          
            
            
            
        });
    } }                
public class GuessingGame{
    public static void main(String args[]) throws Exception {
        Test play= new Test();
        play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        play.setSize(1000, 600);
        play.getContentPane().setLayout(null);
        play.setVisible(true);
    }


}