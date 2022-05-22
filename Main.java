import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.net.URI;

class App extends JFrame implements ActionListener, MouseListener, KeyListener{
    int SCREEN_WIDTH = 1000, SCREEN_HEIGHT = 700, valx, valy;
    int MENU_BUTTON_SIZE = 60, activity_attribute=0;
    JPanel MenuBox, ACTIVITY_AREA, Fill_Line, LineA, LineB, LineC, LineD, BOX_CHOOSE, Tab1, Tab2, Tab3, PText, PBinary, FillA, FillB, van1;
    JButton QC, CWS, ED, EXT,SUP, Convert, ConeA, ConeB, ConeC, ConeD, ConsButt, swapButt, ConvertButt;
    String bean = "base10";
    JLabel LabelA, LabelB, LabelC, LabelD, ToLabel, CText,CBinary;
    JTextField Base2F,Base8F,Base10F,Base16F,SCAN_INPUT, JTF;
    JTextArea NTXT, txt, bnry;
    JScrollPane  NSP, scroll, scrll;
    JComboBox box1, box2;

    App(){
        this.setTitle("BODH -C (Beta A016)");
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        MenuBox = new JPanel();
        MenuBox.setBounds(0,0,MENU_BUTTON_SIZE,SCREEN_HEIGHT);
        MenuBox.setBackground(Color.decode("#202225"));
        MenuBox.setLayout(null);
        this.add(MenuBox);

        QC = new JButton("QC");
        QC.setBounds(2,2,MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
        QC.setBackground(Color.decode("#36383f"));
        QC.setForeground(Color.white);
        QC.setFocusable(false);
        QC.addActionListener(this);
        QC.addMouseListener(this);
        MenuBox.add(QC);

        CWS = new JButton("C/S");
        CWS.setBounds(2,2+MENU_BUTTON_SIZE, MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
        CWS.setBackground(Color.decode("#36383f"));
        CWS.setForeground(Color.white);
        CWS.setFocusable(false);
        CWS.addActionListener(this);
        CWS.addMouseListener(this);
        MenuBox.add(CWS);

        ED = new JButton("E/D");
        ED.setBounds(2,2+(MENU_BUTTON_SIZE*2), MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
        ED.setBackground(Color.decode("#36383f"));
        ED.setForeground(Color.white);
        ED.setFocusable(false);
        ED.addActionListener(this);
        ED.addMouseListener(this);
        MenuBox.add(ED);

        SUP = new JButton("S");
        SUP.setBounds(2,SCREEN_HEIGHT-(MENU_BUTTON_SIZE*2)+(MENU_BUTTON_SIZE/2)-6 - MENU_BUTTON_SIZE, MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
        SUP.setBackground(Color.decode("#36383f"));
        SUP.setForeground(Color.white);
        SUP.setFocusable(false);
        SUP.addActionListener(this);
        SUP.addMouseListener(this);
        MenuBox.add(SUP);

        EXT = new JButton("X");
        EXT.setBounds(2,SCREEN_HEIGHT-(MENU_BUTTON_SIZE*2)+(MENU_BUTTON_SIZE/2)-6,MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
        EXT.setBackground(Color.red);
        EXT.setForeground(Color.white);
        EXT.setFocusable(false);
        EXT.addActionListener(this);
        EXT.addMouseListener(this);
        MenuBox.add(EXT);

        ACTIVITY_AREA = new JPanel();
        ACTIVITY_AREA.setBounds(MENU_BUTTON_SIZE,0,SCREEN_WIDTH-MENU_BUTTON_SIZE,SCREEN_HEIGHT);
        ACTIVITY_AREA.setBackground(Color.decode("#36383f"));
        ACTIVITY_AREA.setLayout(null);
        this.add(ACTIVITY_AREA);
        set_val();
        set_activity();
        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==QC){
            QC.setBounds(2-2,2-2,MENU_BUTTON_SIZE-4+4, MENU_BUTTON_SIZE-4+4);
            QC.setBackground(Color.decode("#7300f2"));
        }
        else if (e.getSource()==CWS) {
            CWS.setBounds(2-2,2+MENU_BUTTON_SIZE-2, MENU_BUTTON_SIZE-4+4, MENU_BUTTON_SIZE-4+4);
            CWS.setBackground(Color.decode("#7300f2"));
        }
        else if (e.getSource()==ED) {
            ED.setBounds(2-2,2+(MENU_BUTTON_SIZE*2)-2, MENU_BUTTON_SIZE-4+4, MENU_BUTTON_SIZE-4+4);
            ED.setBackground(Color.decode("#7300f2"));
        }
        else if (e.getSource()==SUP) {
            SUP.setBounds(2-2,SCREEN_HEIGHT-(MENU_BUTTON_SIZE*2)+(MENU_BUTTON_SIZE/2)-6 - MENU_BUTTON_SIZE-2, MENU_BUTTON_SIZE-4+4, MENU_BUTTON_SIZE-4+4);
            SUP.setBackground(Color.decode("#7300f2"));
        }
        else if (e.getSource()==EXT) {
            EXT.setBounds(2-2,SCREEN_HEIGHT-(MENU_BUTTON_SIZE*2)+(MENU_BUTTON_SIZE/2)-6-2,MENU_BUTTON_SIZE-4+4, MENU_BUTTON_SIZE-4+4);
        }
        else if (e.getSource()==Convert) {
            //Convert.setBounds(SCREEN_WIDTH-60-100-5+5,7-7,100,30+20);
            Convert.setBackground(Color.decode("#7300f2"));
        }
        else if (e.getSource()==ConeA) {
            ConeA.setBackground(Color.decode("#7300f2"));
        }
        else if (e.getSource()==ConeB) {
            ConeB.setBackground(Color.decode("#7300f2"));
        }
        else if (e.getSource()==ConeC) {
            ConeC.setBackground(Color.decode("#7300f2"));
        }
        else if (e.getSource()==ConeD) {
            ConeD.setBackground(Color.decode("#7300f2"));
        }
		else if (e.getSource()==ConsButt) {
			ConsButt.setBackground(Color.decode("#7300f2"));
		}
		else if(e.getSource()==swapButt){
			swapButt.setBackground(Color.decode("#7300f2"));
		}
		else if (e.getSource()==ConvertButt) {
			ConvertButt.setBackground(Color.decode("#7300f2"));
		}
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==QC){
            QC.setBounds(2,2,MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
            QC.setBackground(Color.decode("#36383f"));
            set_val();
        }
        else if (e.getSource()==CWS) {
            CWS.setBounds(2,2+MENU_BUTTON_SIZE, MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
            CWS.setBackground(Color.decode("#36383f"));
            set_val();
        }
        else if (e.getSource()==ED) {
            ED.setBounds(2,2+(MENU_BUTTON_SIZE*2), MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
            ED.setBackground(Color.decode("#36383f"));
            set_val();
        }
        else if (e.getSource()==SUP) {
            SUP.setBounds(2,SCREEN_HEIGHT-(MENU_BUTTON_SIZE*2)+(MENU_BUTTON_SIZE/2)-6 - MENU_BUTTON_SIZE, MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
            SUP.setBackground(Color.decode("#36383f"));
            set_val();
        }
        else if (e.getSource()==EXT) {
            EXT.setBounds(2,SCREEN_HEIGHT-(MENU_BUTTON_SIZE*2)+(MENU_BUTTON_SIZE/2)-6,MENU_BUTTON_SIZE-4, MENU_BUTTON_SIZE-4);
            set_val();
        }
        else if (e.getSource()==Convert) {
            Convert.setBounds(SCREEN_WIDTH-60-100-5,7,100,30);
            Convert.setBackground(Color.decode("#36383f"));
        }
		else if (e.getSource()==ConsButt) {
			ConsButt.setBounds(SCREEN_WIDTH-60-100-5,7,100,30);
			ConsButt.setBackground(Color.decode("#36383f"));
		}
        else if (e.getSource()==ConeA) {
            if (bean.equals("base2")) {
                ConeA.setBackground(Color.decode("#7300f2"));
                /*ConeB.setBackground(Color.decode("#36383f"));
                ConeC.setBackground(Color.decode("#36383f"));
                ConeD.setBackground(Color.decode("#36383f"));*/
            }
            else{
                ConeA.setBackground(Color.decode("#36383f"));
            }
        }
        else if (e.getSource()==ConeB) {
            if (bean.equals("base8")) {
                //ConeA.setBackground(Color.decode("#36383f"));
                ConeB.setBackground(Color.decode("#7300f2"));
                //ConeC.setBackground(Color.decode("#36383f"));
                //ConeD.setBackground(Color.decode("#36383f"));
            }
            else{
                ConeB.setBackground(Color.decode("#36383f"));
            }
        }
        else if (e.getSource()==ConeC) {
            if (bean.equals("base10")) {
                //ConeA.setBackground(Color.decode("#36383f"));
                ConeC.setBackground(Color.decode("#7300f2"));
                //ConeB.setBackground(Color.decode("#36383f"));
                //ConeD.setBackground(Color.decode("#36383f"));
            }
            else{
                ConeC.setBackground(Color.decode("#36383f"));
            }
        }
        else if (e.getSource()==ConeD) {
            if (bean.equals("base16")) {
                //ConeA.setBackground(Color.decode("#36383f"));
                ConeD.setBackground(Color.decode("#7300f2"));
                //ConeB.setBackground(Color.decode("#36383f"));
                //ConeC.setBackground(Color.decode("#36383f"));
            }
            else{
                ConeD.setBackground(Color.decode("#36383f"));
            }
        }
		else if(e.getSource()==swapButt){
			swapButt.setBackground(Color.decode("#36383f"));
		}
		else if (e.getSource()==ConvertButt) {
			ConvertButt.setBackground(Color.decode("#36383f"));
		}
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()==Convert) {
            Convert.setBounds(SCREEN_WIDTH-60-100-5+5,7-7,100,30+20);
        }
		else if (e.getSource()==ConsButt) {
			ConsButt.setBounds(SCREEN_WIDTH-60-100-5+5,7-7,100,30+20);
		}
        else if (e.getSource()==ConeA) {
            ConeA.setBounds(0,0,100,50);
        }
        else if (e.getSource()==ConeB) {
            ConeB.setBounds(100+5,0,100,50);
        }
        else if (e.getSource()==ConeC) {
            ConeC.setBounds(100+5+100+5,0,100,50);
        }
        else if (e.getSource()==ConeD) {
            ConeD.setBounds(100+5+100+5+100+5,0,100,50);
        }
		else if(e.getSource()==swapButt){
			swapButt.setBounds(SCREEN_WIDTH-60-100-5-100-5-5,0,100,50);
		}
		else if (e.getSource()==ConvertButt) {
			ConvertButt.setBounds(SCREEN_WIDTH-60-100-5-5,0,100,50);
		}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource()==Convert) {
            Convert.setBounds(SCREEN_WIDTH-60-100-5,7,100,30);
        }
		else if(e.getSource()==ConsButt) {
            ConsButt.setBounds(SCREEN_WIDTH-60-100-5,7,100,30);
        }
        else if (e.getSource()==ConeA) {
            ConeA.setBounds(5,10,100,30);
        }
        else if(e.getSource()==ConeB){
            ConeB.setBounds(5+100+5,10,100,30);
        }
        else if(e.getSource()==ConeC){
            ConeC.setBounds(5+100+5+100+5,10,100,30);
        }
        else if (e.getSource()==ConeD) {
            ConeD.setBounds(5+100+5+100+5+100+5,10,100,30);
        }
		else if(e.getSource()==swapButt){
			swapButt.setBounds(SCREEN_WIDTH-60-100-5-100-5,7,100,30);
		}
		else if (e.getSource()==ConvertButt) {
			ConvertButt.setBounds(SCREEN_WIDTH-60-100-5,7,100,30);
		}
    }

	public void translate(){
		if(valx==1 && valy==2){
			String s = txt.getText();
			byte[] bytes = s.getBytes();
			StringBuilder binary = new StringBuilder();
			for (byte b : bytes){
				int val = b;
				for(int i = 0;i<8;i++){
					binary.append((val & 128)==0 ? 0 : 1);
					val <<= 1;
				}
				binary.append(' ');
			}
			bnry.setText(""+binary+"");
		}
		else if(valx==2 && valy==1){
				String input = bnry.getText();
				
				String raw = Arrays.stream(input.split(" "))
					.map(binary -> Integer.parseInt(binary, 2))
					.map(Character::toString)
					.collect(Collectors.joining()); // cut the space
				txt.setText(""+raw+"");		
		}	
	}

	public void convv(){
		NTXT.setText("");
		if(box1.getSelectedItem()==box2.getSelectedItem()){
			NTXT.setText("Converting to itself is equals to itself!");
			
		}
		else if(box1.getSelectedItem()=="Decimal" && box2.getSelectedItem()=="Binary"){//Decimal to Binary
			try{
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				String binary = Integer.toBinaryString(val);
				NTXT.append("d\t|q\t|r");
				
				int d = val*2;
				int q = val;
				int r = 0;
				int eQ = 0;
				
				while(q>1){
					d = d/2;
					r = q%2;
					q = q/2;
					NTXT.append("\n"+d + "/2\t|" + q + "\t|" + r );
					eQ = q;
				}
				NTXT.append("\n\t\t|"+eQ);
				NTXT.append("\nDecimal: " +val);
				NTXT.append("\nBinary: " + binary);										
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");
				JOptionPane.showMessageDialog(null, "Invalid Input!");
			}
		}
		//Decimal to Octal
		else if(box1.getSelectedItem()=="Decimal" && box2.getSelectedItem()=="Octal"){
			try{
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				String octal = Integer.toOctalString(val);
				NTXT.append("d\t|q\t|r");
				
				int d = val*8;
				int q = val;
				int r = 0;
				int eQ = 0;
				
				while(q>1){
					d = d/8;
					r = q%8;
					q = q/8;
					NTXT.append("\n"+d + "/8\t|" + q + "\t|" + r );
					eQ = q;
				}
				NTXT.append("\n\t\t|"+eQ);
				NTXT.append("\nDecimal: " +val);
				NTXT.append("\nOctal: " + octal);										
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");
			}				
		}
		else if(box1.getSelectedItem()=="Decimal" && box2.getSelectedItem()=="Hex"){
			try{
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				String hex = Integer.toHexString(val).toUpperCase();
				NTXT.append("d\t|q\t|r");
				
				int d = val*16;
				int q = val;
				int r = 0;
				int eQ = 0;
				
				while(q>1){
					d = d/16;
					r = q%16;
					q = q/16;
					NTXT.append("\n"+d + "/16\t|" + q + "\t|" + r );
					eQ = q;
				}
				NTXT.append("\n\t\t|"+eQ);
				NTXT.append("\nDecimal: " +val);
				NTXT.append("\nOctal: " + hex);										
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");
			}				
		}
		//Decimal to all is done
		
		//Binary to Decimal
		else if (box1.getSelectedItem()=="Binary" && box2.getSelectedItem()=="Decimal"){
			try{
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				
				int dNum = val;
				int reverse = 0;
				int i = -1;

				while(val>0){
					reverse = val%10;
					val = val/10;
					i++;
					Double ans;

					ans = Math.pow(reverse*2, i);
					if (reverse==0 || reverse==0.0) {
					ans=0.0;
					}

					NTXT.append(reverse + "x2^" + i + " = " + Math.round(ans)+"\n");
				}
				String temp = Integer.toString(dNum);
				NTXT.append("\nBinary: " + dNum);
				NTXT.append("\nDecimal: " + Integer.parseInt(temp, 2));
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");
			}
		}
		//Binary to Octal
		else if (box1.getSelectedItem()=="Binary" && box2.getSelectedItem()=="Octal"){
			try{
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				NTXT.append("--> Convert it to Decimal First:\n");
				int dNum = val;
				int reverse = 0;
				int i = -1;

				while(val>0){
					reverse = val%10;
					val = val/10;
					i++;
					Double ans;

					ans = Math.pow(reverse*2, i);
					if (reverse==0 || reverse==0.0) {
					ans=0.0;
					}

					NTXT.append(reverse + "x2^" + i + " = " + Math.round(ans)+"\n");
				}
				String temp = Integer.toString(dNum);
				NTXT.append("\nBinary: " + dNum);
				NTXT.append("\nDecimal: " + Integer.parseInt(temp, 2));
				NTXT.append("\n\n-->> Now Convert it to Octal:\n");
				
				int newVal = Integer.parseInt(temp,2);
				int d = newVal*8;//divident
				int q = newVal; //quotient
				int r = 0; //reminder
				int eQ = 0;//the last quotient

				while(q>1){
					d = d/8;
					r = q%8;
					q = q/8;
					NTXT.append(d + "/8\t|" + q + "\t|" + r +"\n");
					eQ = q;
				}
				NTXT.append("\t\t|"+eQ);
				NTXT.append("\nDecimal: "  + newVal);
				NTXT.append("\nOctal: " + Integer.toOctalString(newVal));
				
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");
			}
		}			
		//Binary to Hex
		else if (box1.getSelectedItem()=="Binary" && box2.getSelectedItem()=="Hex"){
			try{
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				NTXT.append("--> Convert it to Decimal First:\n");
				int dNum = val;
				int reverse = 0;
				int i = -1;

				while(val>0){
					reverse = val%10;
					val = val/10;
					i++;
					Double ans;

					ans = Math.pow(reverse*2, i);
					if (reverse==0 || reverse==0.0) {
					ans=0.0;
					}

					NTXT.append(reverse + "x2^" + i + " = " + Math.round(ans)+"\n");
				}
				String temp = Integer.toString(dNum);
				NTXT.append("\nBinary: " + dNum);
				NTXT.append("\nDecimal: " + Integer.parseInt(temp, 2));
				NTXT.append("\n\n--> Now Convert it to Hex:\n");
				
				int newVal = Integer.parseInt(temp,2);
				int d = newVal*16;//divident
				int q = newVal; //quotient
				int r = 0; //reminder
				int eQ = 0;//the last quotient

				while(q>1){
					d = d/16;
					r = q%16;
					q = q/16;
					NTXT.append(d + "/16\t|" + q + "\t|" + r +"\n");
					eQ = q;
				}
				NTXT.append("\t\t|"+eQ);
				NTXT.append("\nDecimal: "  + newVal);
				NTXT.append("\nHex: " + Integer.toHexString(newVal).toUpperCase());
				
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");
			}
		}			
		//Octal to Decimal
		else if(box1.getSelectedItem()=="Octal" && box2.getSelectedItem()=="Decimal"){
			try{
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				int dNum = val;
				int reverse = 0;
				int i = -1;

				while(val>0){
					reverse = val%10;
					val = val/10;
					i++;
					Double ans;      
					double power = Math.pow(8, i);
					ans = reverse*power;

					NTXT.append(reverse + "x8^" + i + " = " + Math.round(ans)+"\n");
				}
				String temp = Integer.toString(dNum);
				NTXT.append("\nOctal: " + dNum);
				NTXT.append("\nDecimal: " + Integer.parseInt(temp, 8));					
			}
			
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");				
			}
		}
		//Octal to Binary
		else if(box1.getSelectedItem()=="Octal" && box2.getSelectedItem()=="Binary"){
			try{
				NTXT.append("--> Convert it to Decimal First:\n");
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				int dNum = val;
				int reverse = 0;
				int i = -1;

				while(val>0){
					reverse = val%10;
					val = val/10;
					i++;
					Double ans;
					double power = Math.pow(8, i);
					ans = reverse*power;
					
					NTXT.append(reverse + "x8^" + i + " = " + Math.round(ans)+"\n");
				}
				String temp = Integer.toString(dNum);

				NTXT.append("\nOctal: " + dNum);
				NTXT.append("\nDecimal: " + Integer.parseInt(temp, 8));	
				
				NTXT.append("\n\n--> Now Convert it to Binary:");	
				int newVal = Integer.parseInt(temp, 8);	
				NTXT.append("\nd\t|q\t|r\n");
				int d = newVal*2;//divident
				int q = newVal; //quotient
				int r = 0; //reminder
				int eQ = 0;//the last quotient

				while(q>1){
					d = d/2;
					r = q%2;
					q = q/2;
					NTXT.append(d + "/2\t|" + q + "\t|" + r +"\n");
					eQ = q;
				}
				NTXT.append("\t\t|"+eQ);
				NTXT.append("\n\nDecimal: "  + newVal);
				NTXT.append("\nBinary: " + Integer.toBinaryString(newVal));					
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");					
			}				
		}
		//Octal to Hex
		else if(box1.getSelectedItem()=="Octal" && box2.getSelectedItem()=="Hex"){
			try{
				NTXT.append("--> Convert it to Decimal First:\n");
				String guru = JTF.getText();
				int val = Integer.parseInt(guru);
				int dNum = val;
				int reverse = 0;
				int i = -1;

				while(val>0){
					reverse = val%10;
					val = val/10;
					i++;
					Double ans;
					double power = Math.pow(8, i);
					ans = reverse*power;
					
					NTXT.append(reverse + "x8^" + i + " = " + Math.round(ans)+"\n");
				}
				String temp = Integer.toString(dNum);

				NTXT.append("\nOctal: " + dNum);
				NTXT.append("\nDecimal: " + Integer.parseInt(temp, 8));	
				
				NTXT.append("\n\n--> Now Convert it to Hex:");	
				int newVal = Integer.parseInt(temp, 8);	
				NTXT.append("\nd\t|q\t|r\n");
				int d = newVal*2;//divident
				int q = newVal; //quotient
				int r = 0; //reminder
				int eQ = 0;//the last quotient

				while(q>1){
					d = d/16;
					r = q%16;
					q = q/16;
					NTXT.append(d + "/16\t|" + q + "\t|" + r +"\n");
					eQ = q;
				}
				NTXT.append("\t\t|"+eQ);
				NTXT.append("\n\nDecimal: "  + newVal);
				NTXT.append("\nHex: " + Integer.toHexString(newVal).toUpperCase());
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");					
			}				
		}
		
		//Hex to Decimal
		else if(box1.getSelectedItem()=="Hex" && box2.getSelectedItem()=="Decimal"){
			try{
				String guru = JTF.getText().toLowerCase();
				String val = guru;
				int amount = 0-1;
				long total = 0;

				for(int i=val.length()-1;i>=0;i--)
					{
					char s2 = val.charAt(i);
					if (s2=='a'){
						String s3 = String.valueOf(s2);
						s3 = "10";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*10;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='b'){
						String s3 = String.valueOf(s2);
						s3 = "11";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*11;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='c'){
						String s3 = String.valueOf(s2);
						s3 = "12";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*12;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='d'){
						String s3 = String.valueOf(s2);
						s3 = "13";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*13;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='e'){
						String s3 = String.valueOf(s2);
						s3 = "14";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*14;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss + "\n");
					}
					else if (s2=='f'){
						String s3 = String.valueOf(s2);
						s3 = "15";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*15;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else{
						String s3 = String.valueOf(s2);
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*Integer.parseInt(s3);
						total = total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss + "\n");
					}  
				}
				JTF.setText(guru.toUpperCase());
				NTXT.append("\nHex: " + val.toUpperCase());
				NTXT.append("\nDecimal: "+total);

			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");					
			}				
		}			
		//Hex to Binary
		else if(box1.getSelectedItem()=="Hex" && box2.getSelectedItem()=="Binary"){
			try{
				String guru = JTF.getText().toLowerCase();
				String val = guru;
				int amount = 0-1;
				long total = 0;
				NTXT.append("--> Convert it to Decimal First:\n");
				for(int i=val.length()-1;i>=0;i--)
					{
					char s2 = val.charAt(i);
					if (s2=='a'){
						String s3 = String.valueOf(s2);
						s3 = "10";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*10;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='b'){
						String s3 = String.valueOf(s2);
						s3 = "11";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*11;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='c'){
						String s3 = String.valueOf(s2);
						s3 = "12";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*12;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='d'){
						String s3 = String.valueOf(s2);
						s3 = "13";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*13;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='e'){
						String s3 = String.valueOf(s2);
						s3 = "14";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*14;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss + "\n");
					}
					else if (s2=='f'){
						String s3 = String.valueOf(s2);
						s3 = "15";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*15;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else{
						String s3 = String.valueOf(s2);
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*Integer.parseInt(s3);
						total = total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss + "\n");
					}  
				}
				JTF.setText(guru.toUpperCase());
				NTXT.append("\nHex: " + val.toUpperCase());
				NTXT.append("\nDecimal: "+total);
				
				NTXT.append("\n\n--> Now Convert it to Binary:");
				int newVal = (int)total;	
				NTXT.append("\nd\t|q\t|r\n");
				int d = newVal*2;//divident
				int q = newVal; //quotient
				int r = 0; //reminder
				int eQ = 0;//the last quotient

				while(q>1){
					d = d/2;
					r = q%2;
					q = q/2;
					NTXT.append(d + "/2\t|" + q + "\t|" + r +"\n");
					eQ = q;
				}
				NTXT.append("\t\t|"+eQ);
				NTXT.append("\n\nDecimal: "  + newVal);
				NTXT.append("\nBinary: " + Integer.toBinaryString(newVal));					
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");					
			}				
		}
		//Hex to Octal
		else if(box1.getSelectedItem()=="Hex" && box2.getSelectedItem()=="Octal"){
			try{
				String guru = JTF.getText().toLowerCase();
				String val = guru;
				int amount = 0-1;
				long total = 0;
				NTXT.append("--> Convert it to Decimal First:\n");
				for(int i=val.length()-1;i>=0;i--)
					{
					char s2 = val.charAt(i);
					if (s2=='a'){
						String s3 = String.valueOf(s2);
						s3 = "10";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*10;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='b'){
						String s3 = String.valueOf(s2);
						s3 = "11";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*11;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='c'){
						String s3 = String.valueOf(s2);
						s3 = "12";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*12;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='d'){
						String s3 = String.valueOf(s2);
						s3 = "13";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*13;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else if (s2=='e'){
						String s3 = String.valueOf(s2);
						s3 = "14";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*14;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss + "\n");
					}
					else if (s2=='f'){
						String s3 = String.valueOf(s2);
						s3 = "15";
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*15;
						total=total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss+"\n");
					}
					else{
						String s3 = String.valueOf(s2);
						amount++;
						Double ans = Math.pow(16, amount);
						Long anss = Math.round(ans)*Integer.parseInt(s3);
						total = total+anss;
						NTXT.append(s3+"x16^"+amount+"="+anss + "\n");
					}  
				}
				JTF.setText(guru.toUpperCase());
				NTXT.append("\nHex: " + val.toUpperCase());
				NTXT.append("\nDecimal: "+total);
				
				NTXT.append("\n\n--> Now Convert it to Octal:");
				int newVal = (int)total;	
				NTXT.append("\nd\t|q\t|r\n");
				int d = newVal*8;//divident
				int q = newVal; //quotient
				int r = 0; //reminder
				int eQ = 0;//the last quotient

				while(q>1){
					d = d/8;
					r = q%8;
					q = q/8;
					NTXT.append(d + "/8\t|" + q + "\t|" + r +"\n");
					eQ = q;
				}
				NTXT.append("\t\t|"+eQ);
				NTXT.append("\n\nDecimal: "  + newVal);
				NTXT.append("\nOctal: " + Integer.toOctalString(newVal));					
			}
			catch(Exception g){
				NTXT.setText("Invalid Input!");				
				JOptionPane.showMessageDialog(null, "Invalid Input!");					
			}				
		}
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==EXT) {
            System.exit(0);
        }
        else if (e.getSource()==QC) {
            activity_attribute = 0;
            set_val();
            set_activity();
        }
        else if (e.getSource()==CWS) {
            activity_attribute = 1;
            set_val();
            set_activity();
        }
        else if (e.getSource()==ED) {
            activity_attribute = 2;
            set_val();
            set_activity();
        }
        else if (e.getSource()==SUP) {
            //activity_attribute = 3;
            //set_val();
            //set_activity();
			try{
				Desktop go = Desktop.getDesktop();
				go.browse(new URI("https://owlucid.github.io/"));
			}
			catch(Exception g){
			JOptionPane.showMessageDialog(null, "Something went wrong!");					
			}
        }
        else if (e.getSource()==ConeA) {
            bean = "base2";
            toggle_it("base2");
        }
        else if (e.getSource()==ConeB) {
            bean = "base8";
            toggle_it("base8");
        }
        else if (e.getSource()==ConeC) {
            bean = "base10";
            toggle_it("base10");
        }
        else if (e.getSource()==ConeD) {
            bean = "base16";
            toggle_it("base16");
        }
        else if (e.getSource()==Convert) {
            convert_it();
        }
        else if(e.getSource()==swapButt){
			int tempz;			
			tempz = valx;
			valx = valy;
			valy = tempz;
			
			if(valx==1 && valy==2){
				txt.setEditable(true);
				bnry.setEditable(false);
				Tab2.setBounds((SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,35,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,100+500-50+25+3+2+2);		
				Tab1.setBounds(0,35,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,100+500-50+25+3+2+2);	

			}
			else if(valx==2 && valy==1){
				txt.setEditable(false);
				bnry.setEditable(true);			
				Tab1.setBounds((SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,35,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,100+500-50+25+3+2+2);
				Tab2.setBounds(0,35,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,100+500-50+25+3+2+2);				
			}												
		}	
		else if(e.getSource()==ConvertButt){			
			translate();
		}	
        else if(e.getSource()==ConsButt){
			convv();
		}
    }

    public void toggle_it(String ben){
        clear_it();
        if (ben.equals("base2")) {
            ConeA.setBackground(Color.decode("#7300f2"));
            ConeB.setBackground(Color.decode("#36383f"));
            ConeC.setBackground(Color.decode("#36383f"));
            ConeD.setBackground(Color.decode("#36383f"));
            //System.out.println(bean);
        }
        else if (ben.equals("base8")) {
            ConeB.setBackground(Color.decode("#7300f2"));
            ConeA.setBackground(Color.decode("#36383f"));
            ConeC.setBackground(Color.decode("#36383f"));
            ConeD.setBackground(Color.decode("#36383f"));
            //System.out.println(bean);
        }
        else if (ben.equals("base10")) {
            ConeC.setBackground(Color.decode("#7300f2"));
            ConeA.setBackground(Color.decode("#36383f"));
            ConeB.setBackground(Color.decode("#36383f"));
            ConeD.setBackground(Color.decode("#36383f"));
            //System.out.println(bean);
        }
        else if (ben.equals("base16")) {
            ConeD.setBackground(Color.decode("#7300f2"));
            ConeA.setBackground(Color.decode("#36383f"));
            ConeC.setBackground(Color.decode("#36383f"));
            ConeB.setBackground(Color.decode("#36383f"));
            //System.out.println(bean);
        }
    }
    public void clear_it(){
        SCAN_INPUT.setText("");
        Base2F.setText("");
        Base8F.setText("");
        Base10F.setText("");
        Base16F.setText("");
    }

    public void convert_it(){
        System.out.println(bean);
        if (bean.equals("base2")) {
            try {
                String var = SCAN_INPUT.getText();
                int dNum = Integer.parseInt(var);
                String temp = Integer.toString(dNum);

                int Decimal = Integer.parseInt(temp,2);

				//Binary to Decimal
				Base10F.setText(""+Decimal+"");
				//Binary to Octal
				Base8F.setText(""+Integer.toOctalString(Decimal)+"");
						
				//Binary to Hex
				Base16F.setText(""+Integer.toHexString(Decimal).toUpperCase()+"");

                Base2F.setText(var);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        }
        if (bean.equals("base8")) {
            try {
                String var = SCAN_INPUT.getText();
                int dNum = Integer.parseInt(var);
                String temp = Integer.toString(dNum);

                int Decimal = Integer.parseInt(temp, 8);

                Base2F.setText(""+Integer.toBinaryString(Decimal)+"");

				//Binary to Decimal
				Base10F.setText(""+Decimal+"");
				//Binary to Octal
				Base8F.setText(""+Integer.toOctalString(Decimal)+"");
						
				//Binary to Hex
				Base16F.setText(""+Integer.toHexString(Decimal).toUpperCase()+"");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        }
        if (bean.equals("base10")) {
            try {
                String var = SCAN_INPUT.getText();
                int dNum = Integer.parseInt(var);
                String temp = Integer.toString(dNum);

                int Decimal = Integer.parseInt(temp);

                Base2F.setText(""+Integer.toBinaryString(Decimal)+"");

				//Binary to Decimal
				Base10F.setText(""+Decimal+"");
				//Binary to Octal
				Base8F.setText(""+Integer.toOctalString(Decimal)+"");
						
				//Binary to Hex
				Base16F.setText(""+Integer.toHexString(Decimal).toUpperCase()+"");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        }
        if (bean.equals("base16")) {
            try {
                String val = SCAN_INPUT.getText();

                int amount = 0-1;
                long total = 0;
                
                for(int i = val.length()-1;i>=0;i--){
                    char s2 = val.charAt(i);
                    if (s2=='a'){
                        String s3 = String.valueOf(s2);
                        s3 = "10";
                        amount++;
                        Double ans = Math.pow(16,amount);
                        Long anss = Math.round(ans)*10;
                        total=total+anss;
                    }
                    else if (s2=='b'){
                        String s3 = String.valueOf(s2);
                        s3 = "11";
                        amount++;
                        Double ans = Math.pow(16,amount);
                        Long anss = Math.round(ans)*11;
                        total=total+anss;
                    }	
                    else if (s2=='c'){
                        String s3 = String.valueOf(s2);
                        s3 = "12";
                        amount++;
                        Double ans = Math.pow(16,amount);
                        Long anss = Math.round(ans)*12;
                        total=total+anss;
                    }		
                    else if (s2=='d'){
                        String s3 = String.valueOf(s2);
                        s3 = "13";
                        amount++;
                        Double ans = Math.pow(16,amount);
                        Long anss = Math.round(ans)*13;
                        total=total+anss;
                    }	
                    else if (s2=='e'){
                        String s3 = String.valueOf(s2);
                        s3 = "14";
                        amount++;
                        Double ans = Math.pow(16,amount);
                        Long anss = Math.round(ans)*14;
                        total=total+anss;
                    }					
                    else if (s2=='f'){
                        String s3 = String.valueOf(s2);
                        s3 = "15";
                        amount++;
                        Double ans = Math.pow(16,amount);
                        Long anss = Math.round(ans)*15;
                        total=total+anss;
                    }
                    
                    else{
                        String s3 = String.valueOf(s2);
                        amount++;
                        Double ans = Math.pow(16,amount);
                        Long anss = Math.round(ans)*Integer.parseInt(s3);
                        total = total+anss;
                    }
                    int totals = (int)total;

                    Base10F.setText(""+total+"");
                    Base8F.setText(""+Integer.toOctalString(totals)+"");
                    Base2F.setText(""+Integer.toBinaryString(totals)+"");
                    Base16F.setText(""+val.toUpperCase()+"");
                }
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Input!");
            }
        }
    }

    public void set_val(){
        if (activity_attribute==0) {
            QC.setBackground(Color.decode("#7300f2"));
            CWS.setBackground(Color.decode("#36383f"));
            ED.setBackground(Color.decode("#36383f"));
            SUP.setBackground(Color.decode("#36383f"));
        }
        else if (activity_attribute==1) {
            CWS.setBackground(Color.decode("#7300f2"));
            QC.setBackground(Color.decode("#36383f"));
            ED.setBackground(Color.decode("#36383f"));
            SUP.setBackground(Color.decode("#36383f"));
        }
        else if (activity_attribute==2) {
            ED.setBackground(Color.decode("#7300f2"));
            QC.setBackground(Color.decode("#36383f"));
            CWS.setBackground(Color.decode("#36383f"));
            SUP.setBackground(Color.decode("#36383f"));
        }
        else if (activity_attribute==3) {
            SUP.setBackground(Color.decode("#7300f2"));
            ED.setBackground(Color.decode("#36383f"));
            CWS.setBackground(Color.decode("#36383f"));
            QC.setBackground(Color.decode("#36383f"));
        }
    }
    public void cleanup (){
        ACTIVITY_AREA.removeAll();
        ACTIVITY_AREA.repaint();
    }
    public void universal_line(){
        Fill_Line = new JPanel();
        Fill_Line.setBounds(0,30,1000-60,2);
        Fill_Line.setBackground(Color.black);
        ACTIVITY_AREA.add(Fill_Line);
    }
    public void set_activity(){
        if (activity_attribute==0) {
            cleanup();
            LabelA = new JLabel("Quick Convert");
            LabelA.setForeground(Color.white);
            LabelA.setBounds(0,0,200,30);
            ACTIVITY_AREA.add(LabelA);

            universal_line();

            JLabel BaseA = new JLabel("Base 2 - Binary");
            BaseA.setBounds((1000-60)/2-50,85,107,30);
            BaseA.setForeground(Color.white);
            BaseA.setBackground(Color.decode("#36383f"));
            BaseA.setOpaque(true);
            ACTIVITY_AREA.add(BaseA);

            LineA = new JPanel();
            LineA.setBounds(0,100,SCREEN_WIDTH-MENU_BUTTON_SIZE, 2);
            LineA.setBackground(Color.white);
            ACTIVITY_AREA.add(LineA);

            JLabel BaseB = new JLabel("Base 8 - Octal");
            BaseB.setBounds((1000-60)/2-50,100+85,100,30);
            BaseB.setForeground(Color.white);
            BaseB.setBackground(Color.decode("#36383f"));
            BaseB.setOpaque(true);
            ACTIVITY_AREA.add(BaseB);

            LineB = new JPanel();
            LineB.setBounds(0,100*2,SCREEN_WIDTH-MENU_BUTTON_SIZE, 2);
            LineB.setBackground(Color.white);
            ACTIVITY_AREA.add(LineB);

            JLabel BaseC = new JLabel("Base 10 - Decimal");
            BaseC.setBounds((1000-75)/2-50,185+100,130-3,30);
            BaseC.setForeground(Color.white);
            BaseC.setBackground(Color.decode("#36383f"));
            BaseC.setOpaque(true);
            ACTIVITY_AREA.add(BaseC);

            LineC = new JPanel();
            LineC.setBounds(0,100*3,SCREEN_WIDTH-MENU_BUTTON_SIZE, 2);
            LineC.setBackground(Color.white);
            ACTIVITY_AREA.add(LineC);

            JLabel BaseD = new JLabel("Base 16 - Hex");
            BaseD.setBounds((1000-75)/2-50,285+100,100-3,30);
            BaseD.setForeground(Color.white);
            BaseD.setBackground(Color.decode("#36383f"));
            BaseD.setOpaque(true);
            ACTIVITY_AREA.add(BaseD);

            LineD = new JPanel();
            LineD.setBounds(0,100*4,SCREEN_WIDTH-MENU_BUTTON_SIZE, 2);
            LineD.setBackground(Color.white);
            ACTIVITY_AREA.add(LineD);

            Base2F = new JTextField();
            Base2F.setBounds(5,100+10+10,SCREEN_WIDTH-200-5-5-100+30+100+5 +60+50-5-5,30);
            Base2F.setBackground(Color.decode("#36383f"));//(Color.decode("#40434b"));
            Base2F.setForeground(Color.white);
            Base2F.setCaretColor(Color.WHITE);
            Base2F.setEditable(false);
            //Base2F.setBorder(null);
            ACTIVITY_AREA.add(Base2F);

            Base8F = new JTextField();
            Base8F.setBounds(5,100+100+10+10,SCREEN_WIDTH-200-5-5-100+30+100+5 +60+50-5-5,30);
            Base8F.setBackground(Color.decode("#36383f"));//(Color.decode("#40434b"));
            Base8F.setForeground(Color.white);
            Base8F.setCaretColor(Color.WHITE);
            Base8F.setEditable(false);
            //Base8F.setBorder(null);
            ACTIVITY_AREA.add(Base8F);

            Base10F = new JTextField();
            Base10F.setBounds(5,300+10+10,SCREEN_WIDTH-200-5-5-100+30+100+5 +60+50-5-5,30);
            Base10F.setBackground(Color.decode("#36383f"));//(Color.decode("#40434b"));
            Base10F.setForeground(Color.white);
            Base10F.setCaretColor(Color.WHITE);
            Base10F.setEditable(false);
            //Base10F.setBorder(null);
            ACTIVITY_AREA.add(Base10F);

            Base16F = new JTextField();
            Base16F.setBounds(5,400+10+10,SCREEN_WIDTH-200-5-5-100+30+100+5 +60+50-5-5,30);
            Base16F.setBackground(Color.decode("#36383f"));//(Color.decode("#40434b"));
            Base16F.setForeground(Color.white);
            Base16F.setCaretColor(Color.WHITE);
            Base16F.setEditable(false);
            //Base16F.setBorder(null);
            ACTIVITY_AREA.add(Base16F);

            JPanel SCAN_BOX = new JPanel();
            SCAN_BOX.setBounds(0,700-90+10,1000-60,50);
            SCAN_BOX.setBackground(Color.black);
            SCAN_BOX.setLayout(null);
            ACTIVITY_AREA.add(SCAN_BOX);

            /*
            BaseX = new JButton("Base 10");
            BaseX.setBounds(5,7,100,30);
            BaseX.setFocusable(false);
            BaseX.setBackground(Color.decode("#36383f"));
            BaseX.setForeground(Color.white);
            BaseX.addActionListener(this);
            BaseX.addMouseListener(this);
            SCAN_BOX.add(BaseX);
            */
            SCAN_INPUT = new JTextField("10");
            SCAN_INPUT.setBounds(5,7, SCREEN_WIDTH-200-5-5-100+30+100+5,30);
            SCAN_INPUT.setBackground(Color.decode("#40434b"));
            SCAN_INPUT.setForeground(Color.white);
            SCAN_INPUT.setCaretColor(Color.WHITE);
            SCAN_BOX.add(SCAN_INPUT);

			convert_it();

            Convert = new JButton("Convert");
            Convert.setBounds(SCREEN_WIDTH-60-100-5,7,100,30);
            Convert.setBackground(Color.decode("#36383f"));
            Convert.setForeground(Color.white);
            Convert.setFocusable(false);
            Convert.addKeyListener(this);
            Convert.addActionListener(this);
            Convert.addMouseListener(this);
            SCAN_BOX.add(Convert);

            BOX_CHOOSE = new JPanel();
            BOX_CHOOSE.setBounds(0,700-90+10-50,1000-60,50);
            BOX_CHOOSE.setBackground(Color.decode("#141414"));
            BOX_CHOOSE.setLayout(null);

            ACTIVITY_AREA.add(BOX_CHOOSE);

            ConeA = new JButton("Base 2");
            ConeA.setBackground(Color.decode("#36383f"));
            ConeA.setForeground(Color.white);
            ConeA.setBounds(5,10,100,30);
            ConeA.setFocusable(false);
            ConeA.addMouseListener(this);
            ConeA.addKeyListener(this);
            ConeA.addActionListener(this);
            BOX_CHOOSE.add(ConeA);

            ConeB = new JButton("Base 8");
            ConeB.setBackground(Color.decode("#36383f"));
            ConeB.setForeground(Color.white);
            ConeB.setBounds(5+100+5,10,100,30);
            ConeB.setFocusable(false);
            ConeB.addMouseListener(this);
            ConeB.addKeyListener(this);
            ConeB.addActionListener(this);
            BOX_CHOOSE.add(ConeB);

            ConeC = new JButton("Base 10");
            ConeC.setBackground(Color.decode("#7300f2"));
            ConeC.setForeground(Color.white);
            ConeC.setBounds(5+100+5+100+5,10,100,30);
            ConeC.setFocusable(false);
            ConeC.addMouseListener(this);
            ConeC.addKeyListener(this);
            ConeC.addActionListener(this);
            BOX_CHOOSE.add(ConeC);

            ConeD = new JButton("Base 16");
            ConeD.setBackground(Color.decode("#36383f"));
            ConeD.setForeground(Color.white);
            ConeD.setBounds(5+100+5+100+5+100+5,10,100,30);
            ConeD.setFocusable(false);
            ConeD.addMouseListener(this);
            ConeD.addKeyListener(this);
            ConeD.addActionListener(this);
            BOX_CHOOSE.add(ConeD);            
        }
        else if (activity_attribute==1) {
            cleanup();
            LabelB = new JLabel("Convert with Solution");
            LabelB.setForeground(Color.white);
            LabelB.setBounds(0,0,200,30);
            ACTIVITY_AREA.add(LabelB);

            universal_line();

			van1 = new JPanel();
			van1.setBackground(Color.BLACK);
			van1.setBounds(0,700-90+10,1000-60,50);
			van1.setLayout(null);
			ACTIVITY_AREA.add(van1);

			JPanel van2 = new JPanel();
			van2.setBounds(0,700-90+10-50,1000-60,50);
			van2.setBackground(Color.decode("#141414"));
			van2.setLayout(null);
			ACTIVITY_AREA.add(van2);

            String [] cons = {"Binary","Octal", "Decimal", "Hex"};
			box1 = new JComboBox(cons);
			box1.setBounds(5,10,100,30);
			box1.setSelectedIndex(2);
			box1.setBackground(Color.decode("#36383f"));
			box1.setForeground(Color.white);
			//box1.setFont(new Font("Arial", Font.PLAIN, 30));
		    van2.add(box1);
			
			//To Label
			ToLabel = new JLabel("To");
			ToLabel.setBounds(5+100+5,10,100,30);
			ToLabel.setForeground(Color.white);
			//ToLabel.setFont(new Font("Arial", Font.PLAIN, 30));
			van2.add(ToLabel);
			
			box2 = new JComboBox(cons);
			box2.setBounds(5+100+5+20,10,100,30);
			//box2.setFont(new Font("Arial", Font.PLAIN, 30));
			box2.setSelectedIndex(0);
			box2.setBackground(Color.decode("#36383f"));
			box2.setForeground(Color.white);
			van2.add(box2);	
				
			//TextField
			JTF = new JTextField("10");
			//SCREEN_HEIGHT-30-25-10-5-5
			JTF.setBounds(5,7, SCREEN_WIDTH-200-5-5-100+30+100+5,30);
			JTF.setBackground(Color.decode("#40434b"));
			JTF.setForeground(Color.white);
			JTF.setCaretColor(Color.WHITE);
			//JTF.setFont(new Font("Arial", Font.PLAIN, 30));
			van1.add(JTF);

			//convv();

			//Convert Button
			ConsButt = new JButton("Solve");	
			ConsButt.setBounds(SCREEN_WIDTH-60-100-5,7,100,30);
			ConsButt.setBackground(Color.decode("#36383f"));
			ConsButt.setForeground(Color.white);
			ConsButt.setFocusable(false);
			//ConsButt.setFont(new Font("Arial", Font.PLAIN, 30));
			ConsButt.addActionListener(this);
			ConsButt.addMouseListener(this);
			van1.add(ConsButt);
			
			//Text Area
			NTXT = new JTextArea(" ", 0, 0);
			NTXT.setBounds(20, 100, 300, 300);  
			NTXT.setBackground(Color.decode("#36383f"));
			NTXT.setForeground(Color.white);
			//NTXT.setFont(new Font("Calibri", Font.BOLD, 25));
			NTXT.setText("");
			NTXT.setEditable(false);
			
			//Scroller		
			NSP = new JScrollPane(NTXT);
			NSP.setBounds(5,35,SCREEN_WIDTH-MENU_BUTTON_SIZE-10,600-50-10-10);
			ACTIVITY_AREA.add(NSP);

			convv();
        }
        else if (activity_attribute==2) {
            cleanup();
            LabelC = new JLabel("Encrypt and Decrypt");
            LabelC.setForeground(Color.white);
            LabelC.setBounds(0,0,200,30);
            ACTIVITY_AREA.add(LabelC);

            Tab1 = new JPanel();
			Tab1.setBackground(Color.decode("#2f3136"));
			Tab1.setBounds(0,35,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,100+500-50+25+3+2+2);
			Tab1.setLayout(null);
			ACTIVITY_AREA.add(Tab1);
			
			Tab2 = new JPanel();
			Tab2.setBackground(Color.decode("#202225"));			
			Tab2.setBounds((SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,35,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,100+500-50+25+3+2+2);
			Tab2.setLayout(null);
			ACTIVITY_AREA.add(Tab2);
			
			Tab3 = new JPanel();
			Tab3.setBackground(Color.black);
			Tab3.setBounds(0,700-90+10,1000-60,50);		
			ACTIVITY_AREA.add(Tab3);
			
			//Value Setter
			valx = 1;
			valy = 2;
			
			//Text Label	
			CText = new JLabel("Text");
			CText.setBounds(0,0,100,30);
			CText.setForeground(Color.white);
			//CText.setFont(new Font("Calibri", Font.BOLD, 30));
			Tab1.add(CText);
			
			//Text Section
			PText = new JPanel(new BorderLayout());
			PText.setBounds(0,0+30,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,100+614-100+2);
			PText.setBackground(Color.RED);
			PText.setLayout(null);
			PText.setPreferredSize(new Dimension(360,200));
			Tab1.add(PText);
			
			txt = new JTextArea("",0,0);
			txt.setBounds(20, 100, 300, 300);  
			//txt.setFont(new Font("Calibri", Font.BOLD, 25));
			txt.setBackground(Color.decode("#36383f"));
			txt.setForeground(Color.white);
			txt.setLineWrap(true);
			txt.setText("Text converts to binary");
			
			scroll = new JScrollPane(txt);
			scroll.setBounds(0,0,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,579);
			PText.add(scroll);			
			
			//Binary Label
			CBinary = new JLabel("Binary");
			CBinary.setBounds(0,0,100,30);
			CBinary.setForeground(Color.white);
			//CBinary.setFont(new Font("Calibri", Font.BOLD, 30));
			Tab2.add(CBinary);					
			
			//Scroller2
			//Text Area Binary
			PBinary = new JPanel(new BorderLayout());
			PBinary.setBounds(0,0+30,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,100+614-100+2);
			PBinary.setBackground(Color.RED);
			PBinary.setLayout(null);
			PBinary.setPreferredSize(new Dimension(360,200));
			Tab2.add(PBinary);
			
			bnry = new JTextArea(" ",0,0);
			bnry.setBounds(20, 100, 300, 300);  
			//bnry.setFont(new Font("Calibri", Font.BOLD, 25));  
			bnry.setBackground(Color.decode("#36383f"));
			bnry.setForeground(Color.white);
			bnry.setLineWrap(true);
			bnry.setText("");  
			
			scrll = new JScrollPane(bnry);
			scrll.setBounds(0,0,(SCREEN_WIDTH-MENU_BUTTON_SIZE)/2,579);
			PBinary.add(scrll);				
						
			//Swap
			swapButt = new JButton("Swap");
			//swapButt.setFont(new Font("Arial", Font.PLAIN,25));
			swapButt.setBounds(SCREEN_WIDTH-60-100-5-100-5,7,100,30);
			swapButt.setBackground(Color.decode("#36383f"));
			swapButt.setForeground(Color.white);
			swapButt.setFocusable(false);
			swapButt.addActionListener(this);
			swapButt.addMouseListener(this);
			Tab3.add(swapButt);
			
			//Un-nessessary line
			FillA = new JPanel();
			FillA.setBounds(720,0,2,50);
			FillA.setBackground(Color.white);
			Tab3.add(FillA);
			
			//Un-nessessary line
			FillB = new JPanel();
			FillB.setBounds(120,0,2,50);
			FillB.setBackground(Color.BLACK);
			//Tab3.add(FillB);			
			
			//Convert
			ConvertButt = new JButton("Convert");
			//ConvertButt.setFont(new Font("Arial", Font.PLAIN,25));
			ConvertButt.setBounds(SCREEN_WIDTH-60-100-5,7,100,30);
			ConvertButt.setFocusable(false);
			ConvertButt.addActionListener(this);
			ConvertButt.setBackground(Color.decode("#36383f"));
			ConvertButt.setForeground(Color.white);
			ConvertButt.addMouseListener(this);
			Tab3.add(ConvertButt);
			
			//default
			txt.setEditable(true);
			bnry.setEditable(false);

            universal_line();

			translate();
        }
        else if (activity_attribute==3) {
            cleanup();
            LabelD = new JLabel("Support");
            LabelD.setForeground(Color.white);
            LabelD.setBounds(0,0,200,30);
            ACTIVITY_AREA.add(LabelD);

            universal_line();
        }
    }
}

class BODH {
    public static void main(String[] args) {
        new App();
    }
}
