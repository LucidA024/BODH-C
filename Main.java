import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.net.URI;

class AppFrame extends JFrame implements ActionListener, MouseListener{
//////////////////////////////////////////////////////////////////////////////////
JPanel MenuPan, LineFill1, WBoard;
JLabel MenuLab, EELab, BoardM, BoardS, BoardMSW;
JButton QCButt, CWCButt, EDButt, ATButt, ExButt, WEButt;

//RadioButton With Label
ButtonGroup RBODH;
JRadioButton RBinary, ROctal, RDecimal, RHex;
//Then TextFiled
JTextField TBinary, TOctal, TDecimal, THex;

String defaultColor = "#f2f2f2";
String chosenColor = "#1a1a1a";

//Message Section
//Quick Convert
//Choose
JLabel QCLabel, MLabel;

//Convert Button
JButton ConButton;

//Con Config
int ConSet = 0;

JPanel Tab1;
JPanel Tab2;
JPanel Tab3;

JLabel CText;
JPanel PText;

JTextArea txt;

JScrollPane scroll;

JLabel CBinary;

JPanel PBinary;

JTextArea bnry;

JScrollPane scrll;

JButton swapButt;
JPanel FillA;
JPanel FillB;
JButton ConvertButt;

int valx = 1;
int valy = 2;

JLabel CWCLabel;
JComboBox box1;
JLabel ToLabel;
JComboBox box2;
JTextField JTF;
JButton	ConsButt;
JTextArea NTXT;
JScrollPane NSP;


//////////////////////////////////////////////////////////////////////////////////
	AppFrame(){
		this.setTitle("BODH -C Desktop Edition (Beta-A010)");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);

		
		//Menu Panel
		MenuPan = new JPanel();
		MenuPan.setBounds(700,0,300,700);
		MenuPan.setBackground(Color.decode("#666666"));
		MenuPan.setLayout(null);
		//Label
		MenuLab = new JLabel("Menu");
		MenuLab.setFont(new Font("Calibri", Font.BOLD, 60));
		MenuLab.setForeground(Color.BLACK);
		MenuLab.setBounds(75,10,300,60);
		MenuPan.add(MenuLab);
		this.add(MenuPan);
		
		//Line Filler
		LineFill1 = new JPanel();
		LineFill1.setBackground(Color.BLACK);
		LineFill1.setBounds(0,70,300,3);
		MenuPan.add(LineFill1);
		
		//Quick Convert
		QCButt = new JButton("Quick Convert");
		QCButt.setBounds(0,83,300,47);
		QCButt.setFont(new Font("Serif", Font.PLAIN, 24));
		QCButt.setFocusable(false);		
		MenuPan.add(QCButt);
		QCButt.addActionListener(this);
		
		//Convert With Solution
		CWCButt = new JButton("Convert W/ Solution");
		CWCButt.setBounds(0,133,300,47);
		CWCButt.setFont(new Font("Serif", Font.PLAIN, 24));
		CWCButt.setFocusable(false);		
		MenuPan.add(CWCButt);	
		CWCButt.addActionListener(this);	

		//Encrypt and Decrypt - Swappable -Savable as TXT
		EDButt = new JButton("Encrypt/Decrypt");
		EDButt.setBounds(0,183,300,47);
		EDButt.setFont(new Font("Serif", Font.PLAIN, 24));
		EDButt.setFocusable(false);
		EDButt.addActionListener(this);		
		MenuPan.add(EDButt);		
		
		//Show ASCII
		ATButt = new JButton("ASCII Table");
		ATButt.setBounds(0,233,300,47);
		ATButt.setFont(new Font("Serif", Font.PLAIN, 24));
		ATButt.setFocusable(false);		
		MenuPan.add(ATButt);		
		ATButt.addActionListener(this);		
		
		//Website
		WEButt = new JButton("Support!");
		WEButt.setBounds(0,615-47-3,300,47);
		WEButt.setFont(new Font("Serif", Font.PLAIN, 24));
		WEButt.setFocusable(false);		
		MenuPan.add(WEButt);	
		WEButt.addActionListener(this);		
				
		//Exit
		ExButt = new JButton("Exit");
		ExButt.setBounds(0,615,300,47);
		ExButt.setFont(new Font("Serif", Font.PLAIN, 24));
		ExButt.setFocusable(false);	
		ExButt.addActionListener(this);	
		MenuPan.add(ExButt);				

//////////////////////////////////////////////////////////////////////////////////		

		WBoard = new JPanel();
		WBoard.setBounds(0,0,700,700);
		WBoard.setBackground(Color.decode("#a6a6a6"));		
		this.add(WBoard);		
		WBoard.setLayout(null);
		
		//The Useless Part
		//Activity Area
		BoardM = new JLabel("Activity Area");//Large Font
		BoardM.setBounds(75,250,800,100);
		BoardM.setFont(new Font("Calibri", Font.BOLD, 100));
		WBoard.add(BoardM);		
		//Please Select from the menu panel to get started
		BoardS = new JLabel("Please Choose from the MENU to get started ->");
		BoardS.setFont(new Font("Calibri", Font.PLAIN, 30));
		BoardS.setBounds(55,325,800,50);
		WBoard.add(BoardS);
		
		//Note: Message!
		BoardMSW = new JLabel("This App is still Under Development! You May Experience some"+ 			" issues!");
		BoardMSW.setBounds(82,630,800,50);
		WBoard.add(BoardMSW);
		
		this.setVisible(true);				
//////////////////////////////////////////////////////////////////////////////////				
	}


	@Override
	public void actionPerformed(ActionEvent a){
		if (a.getSource()==ExButt){
			System.exit(0);
		}
		else if (a.getSource()==QCButt){
			ConSet = 0;
			WBoard.removeAll();
			WBoard.repaint();
			
			QCLabel = new JLabel("Quick Convert!");
			QCLabel.setFont(new Font("Calibi", Font.BOLD, 75));
			QCLabel.setBounds(30,100+50,1000,80);
			WBoard.add(QCLabel);
			
			MLabel = new JLabel("Please Choose Among the Following Options to Get"+ 			" Started!");
			MLabel.setBounds(130,180+50,500,30);
			WBoard.add(MLabel);


			//Lazy Configurations
			int Rlength = 150;
			int Rheight = 30;
			
			int left = 70;
			int Tlong = 400;			
			
			int gap = 210+50;
			
			int fontSize = 25;

			//Binary Section
			RBinary = new JRadioButton("Binary");
			RBinary.setFont(new Font("Serif", Font.PLAIN, 30));
			RBinary.setBounds(left,gap,Rlength,Rheight);
			RBinary.addActionListener(this);
			RBinary.setFocusable(false);
			
			TBinary = new JTextField();
			TBinary.setFont(new Font("Serif", Font.PLAIN, fontSize));
			TBinary.setBounds(left+Rlength,gap,Tlong,Rheight);
			
			//Octal Section
			gap = gap+30+5;
			ROctal = new JRadioButton("Octal");
			ROctal.setFont(new Font("Serif", Font.PLAIN, 30));	
			ROctal.setBounds(left,gap,Rlength,30);
			ROctal.addActionListener(this);
			ROctal.setFocusable(false);
			
			TOctal = new JTextField();
			TOctal.setFont(new Font("Serif", Font.PLAIN, fontSize));
			TOctal.setBounds(left+Rlength,gap,Tlong,Rheight);
			
			//Decimal Section	
			gap = gap+30+5;				
			RDecimal = new JRadioButton("Decimal");
			RDecimal.setFont(new Font("Serif", Font.PLAIN, 30));
			RDecimal.setBounds(left,gap,Rlength,30);
			RDecimal.addActionListener(this);
			RDecimal.setFocusable(false);
			
			TDecimal = new JTextField();
			TDecimal.setFont(new Font("Serif", Font.PLAIN, fontSize));
			TDecimal.setBounds(left+Rlength,gap,Tlong,Rheight);
			
			//Hex Section
			gap = gap+30+5;			
			RHex = new JRadioButton("Hex");
			RHex.setFont(new Font("Serif", Font.PLAIN, 30));
			RHex.setBounds(left,gap,Rlength,Rheight);
			RHex.addActionListener(this);
			RHex.setFocusable(false);
			
			THex = new JTextField();
			THex.setFont(new Font("Serif", Font.PLAIN, fontSize));
			THex.setBounds(left+Rlength,gap,Tlong,Rheight);			

			RBinary.setBackground(Color.decode(defaultColor));
			ROctal.setBackground(Color.decode(defaultColor));
			RDecimal.setBackground(Color.decode(defaultColor));
			RHex.setBackground(Color.decode(defaultColor));	
			
			RBinary.setForeground(Color.BLACK);
			ROctal.setForeground(Color.BLACK);
			RDecimal.setForeground(Color.BLACK);
			RHex.setForeground(Color.BLACK);
			
			RBODH = new ButtonGroup();			
			RBODH.add(RBinary);
			RBODH.add(ROctal);
			RBODH.add(RDecimal);
			RBODH.add(RHex);
			
			WBoard.add(RBinary);
			WBoard.add(ROctal);
			WBoard.add(RDecimal);
			WBoard.add(RHex);
			
			WBoard.add(TBinary);
			WBoard.add(TOctal);
			WBoard.add(TDecimal);
			WBoard.add(THex);
			
			TBinary.setEditable(false);
			TOctal.setEditable(false);
			TDecimal.setEditable(false);
			THex.setEditable(false);
			
			ConButton = new JButton("Convert Now!");
			ConButton.setFont(new Font("Verdana", Font.PLAIN, 50));
			ConButton.setBounds(left,gap+30+5,550,60);
			ConButton.setFocusable(false);
			ConButton.addActionListener(this);
			WBoard.add(ConButton);
		}
		//#e6e6e6 default color
		else if(a.getSource() == RBinary){	
			ConSet = 1;		
			RBinary.setBackground(Color.decode(chosenColor));
			ROctal.setBackground(Color.decode(defaultColor));
			RDecimal.setBackground(Color.decode(defaultColor));
			RHex.setBackground(Color.decode(defaultColor));
			
			RBinary.setForeground(Color.WHITE);
			ROctal.setForeground(Color.BLACK);
			RDecimal.setForeground(Color.BLACK);
			RHex.setForeground(Color.BLACK);
			
			TBinary.setEditable(true);
			TOctal.setEditable(false);
			TDecimal.setEditable(false);
			THex.setEditable(false);
			
			TBinary.setText("");
			TOctal.setText("");
			TDecimal.setText("");
			THex.setText("");
									
		}
		else if(a.getSource()==ROctal){
			ConSet = 2;
			RBinary.setBackground(Color.decode(defaultColor));
			ROctal.setBackground(Color.decode(chosenColor));
			RDecimal.setBackground(Color.decode(defaultColor));
			RHex.setBackground(Color.decode(defaultColor));		
			
			RBinary.setForeground(Color.BLACK);
			ROctal.setForeground(Color.WHITE);
			RDecimal.setForeground(Color.BLACK);
			RHex.setForeground(Color.BLACK);
			
			TBinary.setEditable(false);
			TOctal.setEditable(true);
			TDecimal.setEditable(false);
			THex.setEditable(false);
			
			TBinary.setText("");
			TOctal.setText("");
			TDecimal.setText("");
			THex.setText("");
										
		}
		else if(a.getSource()==RDecimal){
			ConSet = 3;
			RBinary.setBackground(Color.decode(defaultColor));
			ROctal.setBackground(Color.decode(defaultColor));
			RDecimal.setBackground(Color.decode(chosenColor));
			RHex.setBackground(Color.decode(defaultColor));		
			
			RBinary.setForeground(Color.BLACK);
			ROctal.setForeground(Color.BLACK);
			RDecimal.setForeground(Color.WHITE);
			RHex.setForeground(Color.BLACK);
			
			TBinary.setEditable(false);
			TOctal.setEditable(false);
			TDecimal.setEditable(true);
			THex.setEditable(false);
			
			TBinary.setText("");
			TOctal.setText("");
			TDecimal.setText("");
			THex.setText("");		
		}
		else if(a.getSource()==RHex){
			ConSet = 4;
			RBinary.setBackground(Color.decode(defaultColor));
			ROctal.setBackground(Color.decode(defaultColor));
			RDecimal.setBackground(Color.decode(defaultColor));
			RHex.setBackground(Color.decode(chosenColor));		
			
			RBinary.setForeground(Color.BLACK);
			ROctal.setForeground(Color.BLACK);
			RDecimal.setForeground(Color.BLACK);
			RHex.setForeground(Color.WHITE);
			
			TBinary.setEditable(false);
			TOctal.setEditable(false);
			TDecimal.setEditable(false);
			THex.setEditable(true);
			
			TBinary.setText("");
			TOctal.setText("");
			TDecimal.setText("");
			THex.setText("");		
		}
		else if (a.getSource()==ConButton){
			//System.out.println(ConSet);
			
			try{
				//Binary to All
				if(ConSet==1){
					try{			
						String var = TBinary.getText();
						int dNum = Integer.parseInt(var);			
						String temp = Integer.toString(dNum);
						
						int Decimal = Integer.parseInt(temp,2);
												
						//Binary to Decimal
						TDecimal.setText(""+Decimal+"");
						//Binary to Octal
						TOctal.setText(""+Integer.toOctalString(Decimal)+"");
						
						//Binary to Hex
						THex.setText(""+Integer.toHexString(Decimal).toUpperCase()+"");
					}
					catch(Exception g){
						JOptionPane.showMessageDialog(null, "Invalid Input!");
					}

				}				
				//Octal to All
				else if(ConSet==2){
					try{
						String var = TOctal.getText();
						int dNum = Integer.parseInt(var);
						String temp = Integer.toString(dNum);						
						int Decimal = Integer.parseInt(temp, 8);						
						TDecimal.setText(""+Decimal+"");
						TBinary.setText(""+Integer.toBinaryString(Decimal)+"");
						THex.setText(""+Integer.toHexString(Decimal).toUpperCase()+"");
						
					}
					catch(Exception g){
						JOptionPane.showMessageDialog(null, "Invalid Input!");					
					}
				}				
				//Decimal to All
				else if(ConSet==3){
					try{
						String var = TDecimal.getText();
						int Decimal = Integer.parseInt(var);
						
						TBinary.setText(""+Integer.toBinaryString(Decimal)+"");
						TOctal.setText(""+Integer.toOctalString(Decimal)+"");
						THex.setText(""+Integer.toHexString(Decimal).toUpperCase()+"");					
					}
					catch(Exception g){
						JOptionPane.showMessageDialog(null, "Invalid Input!");					
					}					

				}
				//Hex to All
				else if(ConSet==4){
					try{
						String val = THex.getText();
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
																																					
							TDecimal.setText(""+total+"");
							TOctal.setText(""+Integer.toOctalString(totals)+"");
							TBinary.setText(""+Integer.toBinaryString(totals)+"");
							THex.setText(""+val.toUpperCase()+"");
						}
						
					}
					catch(Exception g){
						JOptionPane.showMessageDialog(null, "Invalid Input!");					
					}
				}
				else if(ConSet==0){
					JOptionPane.showMessageDialog(null, "Please Choose Something");

				}
			}
			
			catch(Exception g){
				JOptionPane.showMessageDialog(null, "Please Choose Something");
			}
		}
		else if(a.getSource()==CWCButt){
			WBoard.removeAll();
			WBoard.repaint();
			
			//Convert W/ Solution
			CWCLabel  = new JLabel("Convert w/ Solution");
			CWCLabel.setBounds(55,100,1000,70);
			CWCLabel.setFont(new Font("Calibri", Font.BOLD, 70));
			WBoard.add(CWCLabel);
			
			String [] cons = {"Binary","Octal", "Decimal", "Hex"};
			box1 = new JComboBox(cons);
			box1.setBounds(75,165,200,35);
			box1.setSelectedIndex(2);
			box1.setFont(new Font("Arial", Font.PLAIN, 30));
			WBoard.add(box1);
			
			//To Label
			ToLabel = new JLabel("To");
			ToLabel.setBounds(325,165,1000,30);
			ToLabel.setFont(new Font("Arial", Font.PLAIN, 30));
			WBoard.add(ToLabel);
			
			box2 = new JComboBox(cons);
			box2.setBounds(415,165,200,35);
			box2.setFont(new Font("Arial", Font.PLAIN, 30));
			box2.setSelectedIndex(0);
			WBoard.add(box2);	
				
			//TextField
			JTF = new JTextField();
			JTF.setBounds(75,203,425,35);
			JTF.setFont(new Font("Arial", Font.PLAIN, 30));
			WBoard.add(JTF);

			//Convert Button
			ConsButt = new JButton("Solve");	
			ConsButt.setBounds(425+75,203,113,35);
			ConsButt.setFocusable(false);
			ConsButt.setFont(new Font("Arial", Font.PLAIN, 30));
			ConsButt.addActionListener(this);
			WBoard.add(ConsButt);
			
			//Text Area
			NTXT = new JTextArea(" ", 0, 0);
			NTXT.setBounds(20, 100, 300, 300);  
			NTXT.setFont(new Font("Calibri", Font.BOLD, 25));
			NTXT.setText("");
			NTXT.setEditable(false);
			
			//Scroller		
			NSP = new JScrollPane(NTXT);
			NSP.setBounds(75,250,425+113,390);
			WBoard.add(NSP);
		}
		else if(a.getSource()==ConsButt){
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
			
		else if(a.getSource()==EDButt){
			WBoard.removeAll();
			WBoard.repaint();
			WBoard.setLayout(null);

			
			Tab1 = new JPanel();
			Tab1.setBackground(Color.decode("#999999"));
			Tab1.setBounds(0,0,350,100+617-100+2);
			WBoard.add(Tab1);
			
			Tab2 = new JPanel();
			Tab2.setBackground(Color.decode("#737373"));			
			Tab2.setBounds(350,0,350,100+617-100+2);
			WBoard.add(Tab2);
			
			Tab3 = new JPanel();
			Tab3.setBackground(Color.decode("#4d4d4d"));
			Tab3.setBounds(0,618,800,50);			
			WBoard.add(Tab3);
			
			//Value Setter
			valx = 1;
			valy = 2;
			
			//Text Label	
			CText = new JLabel("Text");
			CText.setBounds(10,3,100,40);
			CText.setFont(new Font("Calibri", Font.BOLD, 30));
			Tab1.add(CText);
			
			//Text Section
			PText = new JPanel(new BorderLayout());
			PText.setBounds(0,40,400,100+614-100+2);
			PText.setBackground(Color.RED);
			PText.setLayout(null);
			PText.setPreferredSize(new Dimension(360,200));
			Tab1.add(PText);
			
			txt = new JTextArea(" ",0,0);
			txt.setBounds(20, 100, 300, 300);  
			txt.setFont(new Font("Calibri", Font.BOLD, 25));  
			txt.setLineWrap(true);
			txt.setText("");
			
			scroll = new JScrollPane(txt);
			scroll.setBounds(0,0,350,579);
			PText.add(scroll);			
			
			//Binary Label
			CBinary = new JLabel("Binary");
			CBinary.setBounds(10,3,100,40);
			CBinary.setFont(new Font("Calibri", Font.BOLD, 30));
			Tab2.add(CBinary);					
			
			//Scroller2
			//Text Area Binary
			PBinary = new JPanel(new BorderLayout());
			PBinary.setBounds(0,40,400,100+614-100+2);
			PBinary.setBackground(Color.RED);
			PBinary.setLayout(null);
			PBinary.setPreferredSize(new Dimension(360,200));
			Tab2.add(PBinary);
			
			bnry = new JTextArea(" ",0,0);
			bnry.setBounds(20, 100, 300, 300);  
			bnry.setFont(new Font("Calibri", Font.BOLD, 25));  
			bnry.setLineWrap(true);
			bnry.setText("");  
			
			scrll = new JScrollPane(bnry);
			scrll.setBounds(0,0,350,579);
			PBinary.add(scrll);				
						
			//Swap
			swapButt = new JButton("Swap");
			swapButt.setFont(new Font("Arial", Font.PLAIN,25));
			swapButt.setBounds(10,7,100,35);
			swapButt.setFocusable(false);
			swapButt.addActionListener(this);
			Tab3.add(swapButt);
			
			//Un-nessessary line
			FillA = new JPanel();
			FillA.setBounds(480,0,2,50);
			FillA.setBackground(Color.BLACK);
			Tab3.add(FillA);
			
			//Un-nessessary line
			FillB = new JPanel();
			FillB.setBounds(120,0,2,50);
			FillB.setBackground(Color.BLACK);
			Tab3.add(FillB);			
			
			//Convert
			ConvertButt = new JButton("Convert");
			ConvertButt.setFont(new Font("Arial", Font.PLAIN,25));
			ConvertButt.setBounds(490,7,200,35);
			ConvertButt.setFocusable(false);
			ConvertButt.addActionListener(this);
			Tab3.add(ConvertButt);
			
			//default
			txt.setEditable(true);
			bnry.setEditable(false);			
		}
		else if(a.getSource()==swapButt){
			int tempz;			
			tempz = valx;
			valx = valy;
			valy = tempz;
			
			if(valx==1 && valy==2){
				txt.setEditable(true);
				bnry.setEditable(false);
				Tab1.setBounds(0,0,350,100+617-100+2);			
				Tab2.setBounds(350,0,350,100+617-100+2);		
			}
			else if(valx==2 && valy==1){
				txt.setEditable(false);
				bnry.setEditable(true);			
				Tab2.setBounds(0,0,350,100+617-100+2);			
				Tab1.setBounds(350,0,350,100+617-100+2);								
			}												
		}	
		else if(a.getSource()==ConvertButt){			
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
		
		else if(a.getSource()==ATButt){
			WBoard.removeAll();
			WBoard.repaint();	
			
			//Label to set ASCII Table
			JLabel ASCIITAB = new JLabel("ASCII Table");
			ASCIITAB.setBounds(130,100,1000,100);
			ASCIITAB.setFont(new Font("Calibri", Font.BOLD,100));
			WBoard.add(ASCIITAB);
			
			
			String data1 [][] = {
				{"Character","Binary"},
				{"space","00100000"},
				{"!","00100001"},
				{""+'"'+"","00100010"},
				{"#","00100011"},
				{"$","00100100"},
				{"%","00100101"},
				{"&","00100110"},
				{"'","00100111"},
				{"(","00101000"},
				{")","00101001"},
				{"*","00101010"},
				{"+","00101011"},
				{",","00101100"},
				{"-","00101101"},
				{".","00101110"},
				{"/","00101111"},
				{"0","00110000"},
				{"1","00110001"},
				{"2","00110010"},
				{"3","00110011"},
				{"4","00110100"},
				{"5","00110101"},
				{"6","00110110"},
				{"7","00110111"},
				{"8","00111000"},
				{"9","00111001"},
				{":","00111010"},
				{";","00111011"},
				{"<","00111100"},
			};
			
			String [][] data2 = {
				{"Character","Binary"},			
				{"=","00111101"},				
				{">","00111110"},
				{"?","00111111"},
				{"@","01000000"},
				{"A","01000001"},
				{"B","01000010"},
				{"C","01000011"},
				{"D","01000100"},
				{"E","01000101"},
				{"F","01000110"},
				{"G","01000111"},
				{"H","01001000"},
				{"I","01001001"},
				{"J","01001010"},
				{"K","01001011"},
				{"L","01001100"},
				{"M","01001101"},
				{"N","01001110"},
				{"O","01001111"},
				{"P","01010000"},
				{"Q","01010001"},
				{"R","01010010"},
				{"S","01010011"},
				{"T","01010100"},
				{"U","01010101"},
				{"V","01010110"},
				{"W","01010111"},
				{"X","01011000"},
				{"Y","01011001"},
			};
			String [][] data3 = {
				{"Character","Binary"},					
				{"Z","01011010"},
				{"[","01011011"},
				{"\\","01011100"},
				{"]","01011101"},
				{"^","01011110"},
				{"_","01011111"},
				{"`","01100000"},
				{"a","01100001"},
				{"b","01100010"},
				{"c","01100011"},
				{"e","01100101"},
				{"f","01100110"},
				{"h","01101000"},
				{"i","01101001"},
				{"j","01101010"},
				{"k","01101011"},
				{"l","01101100"},
				{"m","01101101"},
				{"n","01101110"},
				{"o","01101111"},
				{"p","01110000"},
				{"q","01110001"},
				{"r","01110010"},
				{"s","01110011"},
				{"t","01110100"},
				{"u","01110101"},
				{"v","01110110"},
				{"w","01110111"},
				{"x","01111000"},
			};	
			String [][] data4 = {	
				{"Character","Binary"},				
				{"y","01111001"},
				{"z","01111010"},
				{"{","01111011"},
				{"|","01111100"},
				{"}","01111101"},
				{"~","01111110"},
			};
			String column [] = 
				{"Morning", "Noon"};
			
			//The Table
			int x = 50;
			
			JTable Table1 = new JTable(data1,column);
			Table1.setBounds(x,180,150,500);
			Table1.setEnabled(false);   
			WBoard.add(Table1);
			
			x = x+150+3;
			JTable Table2 = new JTable(data2, column);
			Table2.setBounds(x,180,150,500);
			Table2.setEnabled(false);   
			WBoard.add(Table2);

			x = x+150+6;			
			JTable Table3 = new JTable(data3, column);
			Table3.setBounds(x,180,150,500);
			Table3.setEnabled(false);   
			WBoard.add(Table3);

			x = x+150+9;			
			JTable Table4 = new JTable(data4, column);
			Table4.setBounds(x,180,150,500);
			Table4.setEnabled(false);   
			WBoard.add(Table4);			
			
		}
		else if(a.getSource()==WEButt){
			try{
				Desktop go = Desktop.getDesktop();
				go.browse(new URI("http://lucidowl.c1.biz/"));
			}
			catch(Exception g){
			JOptionPane.showMessageDialog(null, "Something went wrong!");					
			}
		}		
		
		
	}
	@Override
	public void mouseClicked(MouseEvent b){
	
	}
	@Override
	public void mouseEntered(MouseEvent c){
	
	}
	@Override
	public void mouseExited(MouseEvent d){
	
	}
	@Override
	public void mousePressed(MouseEvent e){
	
	}
	@Override
	public void mouseReleased(MouseEvent f){
	
	}


}

class App{
	public static void main(String [] args){
		new AppFrame();
	}
}
