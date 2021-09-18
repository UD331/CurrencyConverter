import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class combobox extends JFrame{
    JComboBox<String> cbox1;
    JComboBox<String> cbox2;
    JButton exchange;
    JButton reset;
    JLabel amount = new JLabel("Amount of money want to convert: ");
    JLabel amount1 = new JLabel("Amount of money after converted: ");

    combobox(){


        //create frame
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        Font font = new Font(null,Font.BOLD,20);
        JTextField numbertochange1 = new JTextField();
        numbertochange1.setBounds(400,100,100,30);
        numbertochange1.setFont(font);
        this.add(numbertochange1);

        //first text
        amount.setBounds(10,100,350,30);
        amount.setFont(font);
        this.add(amount);

        //second text
        amount1.setBounds(10,200,350,30);
        amount1.setFont(font);
        this.add(amount1);

        // create the first combo box
        String[] currencies = {"Choose currency","USD", "Euro", "Pound"};
        cbox1 = new JComboBox<>(currencies);
        Rectangle r = new Rectangle(200,30);
        cbox1.setBounds(r);
        cbox1.setLocation(550,100);
        this.add(cbox1);
        cbox1.addActionListener(e -> {
            if(e.getSource()==cbox1){
                String currencynow = (String) cbox1.getSelectedItem();
                if (!currencynow.equals("Choose currency")){
                    System.out.println(currencynow);
                }
            }
        });

        // create the second combo box
        cbox2 = new JComboBox<>(currencies);
        this.add(cbox2);
        cbox2.setBounds(550,200,200,30);
        cbox2.addActionListener(e -> {
            if(e.getSource()==cbox2){
                String currencynow = (String) cbox2.getSelectedItem();
                if (!currencynow.equals("Choose currency")){
                    System.out.println(currencynow);
                }
            }
        });

        // create exchange button
        exchange = new JButton("Exchange");
        exchange.setBounds(400,300,100,50);
        exchange.setFocusable(false);
        this.add(exchange);

        //catch event when click button
        exchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==exchange) {
                    float money = Float.parseFloat(numbertochange1.getText());
                    System.out.printf("%.2f \n", money);
                }
            }
        });

        // create reset button
        reset = new JButton("Reset");
        reset.setBounds(550,300,100,50);
        reset.setFocusable(false);
        this.add(reset);
        // catch event
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==reset) {
                    numbertochange1.setText("");
                }
            }
        });

        this.setLayout(null);
        this.setSize(800,500);
        this.setVisible(true);
    }
}
