
package testjavafunctionality;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author MOF
 */
public class TestJavaFunctionality {

    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Prime Num");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 250);
        
        Container container = frame.getContentPane();
        
        
        JPanel panel = new JPanel();
        
        
        
        JTextField text = new JTextField();
        text.setColumns(10);
        panel.add(text);
        
        JButton button = new JButton("Test the number");
        panel.add(button);
        
        
        JLabel label = new JLabel("Please type a number and wait.");
        panel.add(label);
        
        JProgressBar bar = new JProgressBar();
        bar.setValue(0);
        panel.add(bar);
        
        
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String thetext = text.getText();
                Integer num = Integer.parseInt(thetext);
                
                //TestJavaFunctionality.AHeavyProcess(num, bar, label);
                Thread t = new Thread(new ExampleClass(num, bar, label));
                t.start();
            }
        });
        
        
        
        
        container.add(panel);
        
        frame.setVisible(true);
    }
    
    
    
    
    
    public static void AHeavyProcess(int n, JProgressBar bar, JLabel label)
    {
        label.setText("Processing...");
        for(int i = 0; i < n; i++)
        {
            int progress = (int)((i*1.0f/n)*100.0f);
            bar.setValue(progress);
            System.out.println("val: "+progress);
            
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(TestJavaFunctionality.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        bar.setValue(100);
        label.setText("Done!");
    }
    
}






class ExampleClass implements Runnable {  
  
    @Override  
    public void run() {  
        TestJavaFunctionality.AHeavyProcess(n, bar, label);
    }  
    
    
    int n;
    JProgressBar bar;
    JLabel label;
    
    public ExampleClass(int n_, JProgressBar bar_, JLabel label_)
    {
        n = n_;
        bar = bar_;
        label = label_;
    }
   
}
