import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class Ebill extends JFrame {
    private JPanel Main;
    private JTextField txtCid;
    private JTextField txtUnit;
    private JTextField txtName;
    private JTextArea ELECTRICITYBILL;
    private JButton Button;
    private JButton printButton;
    private JLabel imageLogo;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Ebill");
        frame.setContentPane(new Ebill().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public Ebill() {

        Button.addActionListener(new ActionListener() {
      //Printing the bill in the right side:
            public void print(){
                String cName = txtName.getText();
                String cId = txtCid.getText();
                String cunit=txtUnit.getText();

                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"\n");
                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"************************************************"+"\n\n");
                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"          Electricity Billing System"+"\n\n");
                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"          Customer Name:"+cName+"\n\n");
                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"          Customer Id:"+cId+"\n\n");
                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"          Unit charge:"+cunit+"\n\n");
                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"          Amount:"+total_amount+"\n\n");
                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"          Thank you From TNEB"+"\n\n");
                ELECTRICITYBILL.setText(ELECTRICITYBILL.getText()+"************************************************");
            }
//            @Override
            String cId,cName;
            double charge,total_amount;
            int count;
            public void actionPerformed(ActionEvent e) {
              cName = txtName.getText();
              cId = txtCid.getText();
              count = Integer.parseInt(txtUnit.getText());

              if(count>=100 && count<500){
                  charge = 1.00;
              }
              else if(count>=500 && count<600){
                   charge = 1.80;
                }
              else if(count>=600&& count<700){
                  charge = 3.60;
                }
              else if(count>=700 && count<800){
                  charge = 4.00;
              }
              else if(count>=800){
                  charge = 4.80;
              }
              else{
                  charge = 0.00;
              }

              total_amount = charge * count;
              print();
            }


        });
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ELECTRICITYBILL.print();
                } catch (PrinterException printerException) {
                    printerException.printStackTrace();
                }
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
       imageLogo = new JLabel(new ImageIcon("image.png"));
    }
}
