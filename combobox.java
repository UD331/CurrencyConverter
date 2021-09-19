import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class combobox extends JFrame{

    DecimalFormat f = new DecimalFormat("##.##");

    double total = 0;
    String[] currencies = {"Choose currency"};
    public static JComboBox<String> cbox1;
    public static JComboBox<String> cbox2;
    JButton exchange;
    JButton reset;
    JButton add1;
    JLabel amount = new JLabel("Amount of money to be converted: ");
    JLabel amount1 = new JLabel("Amount of money after conversion: ");
    JLabel bill = new JLabel("CURRENCY CONVERTER");

    combobox() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        Font font = new Font(null, Font.BOLD, 20);
        JTextField numbertochange1 = new JTextField();
        JTextField convertednum = new JTextField();
        numbertochange1.setBounds(400, 100, 100, 30);
        convertednum.setBounds(400, 200, 100, 30);
        convertednum.setFont(font);
        numbertochange1.setFont(font);
        this.add(convertednum);
        this.add(numbertochange1);

        //bill text
        bill.setBounds(300, 10, 500, 30);
        bill.setFont(font);
        this.add(bill);

        //first text
        amount.setBounds(10, 100, 350, 30);
        amount.setFont(font);
        this.add(amount);

        //second text
        amount1.setBounds(10, 200, 350, 30);
        amount1.setFont(font);
        this.add(amount1);

        // create the first combo box
        cbox1 = new JComboBox<>(currencies);
        Rectangle r = new Rectangle(200, 30);
        cbox1.setBounds(r);
        cbox1.setLocation(550, 100);
        cbox1.setFocusable(false);
        cbox1.addActionListener(e -> {
            if (e.getSource() == cbox1) {
                String currencynow = (String) cbox1.getSelectedItem();
                if (!currencynow.equals("Choose currency")) {
                    GettingData.currencyFrom = currencynow;
                }
            }
        });

        // create the second combo box
        cbox2 = new JComboBox<>(currencies);

        cbox2.setBounds(550, 200, 200, 30);
        cbox2.setFocusable(false);
        cbox2.addActionListener(e -> {
            if (e.getSource() == cbox2) {
                String currencynow = (String) cbox2.getSelectedItem();
                if (!currencynow.equals("Choose currency")) {
                    GettingData.currencyTo = currencynow;
                }
            }
        });
        addcurrencies ad = new addcurrencies();
        try {
            ad.additem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.add(cbox1);
        this.add(cbox2);

        // create exchange button
        exchange = new JButton("Exchange");
        exchange.setBounds(400, 300, 100, 50);
        exchange.setFocusable(false);
        this.add(exchange);
        //catch event when click button
        exchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exchange) {
                    double money = Double.parseDouble(numbertochange1.getText());
                    GettingData.moneyInitialized = money;
                    GettingData.action = true;
                    GettingData obj = new GettingData();
                    try {
                        obj.getData();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    double rate = obj.exchangeRate();
                    money *= rate;
                    convertednum.setText(String.valueOf(f.format(money)));
                    GettingData.action = false;
                }
            }
        });

        // create reset button
        reset = new JButton("Reset");
        reset.setBounds(550, 300, 100, 50);
        reset.setFocusable(false);
        this.add(reset);
        // catch event
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == reset) {
                    numbertochange1.setText("");
                    convertednum.setText("");
                    cbox1.setSelectedIndex(0);
                    cbox2.setSelectedIndex(0);
                }
            }
        });

        this.setLayout(null);
        this.setSize(800, 500);
        this.setVisible(true);
    }
}

