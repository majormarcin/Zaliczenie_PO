package marcin;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
public class GUI extends JFrame {

	private JTextField x1,x2,x3,y1,y2,y3;
	private JLabel info= new JLabel(" Info ");
	public String txt="";
	//deklaracja pozycji w menu przed listenerem ktory wymaga obiektu
	private JMenuItem Zamknij;
	private JMenuItem Zapisz;
	//listener dla eventu klikniecia pozycji w menu
	private ActionListener al = new ActionListener(){
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == Zamknij)
	dispose();//zamkniecie programu
	else if(e.getSource() == Zapisz)
		zapis(txt);
		}
	};

	//zapis z wyborem miejsca 
	public void zapis(String text) {
			    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("D:/"));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
	            fw.write(text.toString());
	            fw.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	// zapis bez wyboru do pliku 
//	public static void zapis(String text) 
//			throws IOException
//			{
//			  File file = new File ("punkty.txt");
//			  BufferedWriter out = new BufferedWriter(new FileWriter(file)); 
//			  out.write(text);
//			 
//			  System.out.println(text);
//			  out.close();
//			}
	
	//klasa z neta ale świetnie działa jako Listener :D
	class MyDocumentListener implements DocumentListener {
	    public void insertUpdate(DocumentEvent e) {	    	
	    	punkt();
	    }
	    public void removeUpdate(DocumentEvent e) {
	    	punkt();
	    }
	    public void changedUpdate(DocumentEvent e) {
	        //Plain text components do not fire these events
	    	punkt();
	    }
	}
	int delta;
	public void punkt(){
		//wywala bledy ale dizala
		delta = Integer.parseInt(x1.getText())*Integer.parseInt(y2.getText()) + Integer.parseInt(x2.getText())*Integer.parseInt(y3.getText()) + Integer.parseInt(x3.getText())*Integer.parseInt(y1.getText()) - Integer.parseInt(x3.getText())*Integer.parseInt(y2.getText()) - Integer.parseInt(x1.getText())*Integer.parseInt(y3.getText()) - Integer.parseInt(x2.getText())*Integer.parseInt(y1.getText()); 
        if(delta == 0){
        	info.setText("(" + x1.getText() + "," + y1.getText() + ")   (" + x2.getText() + "," + y2.getText() + ")   (" + x3.getText() + "," + y3.getText() + ")   Punkty są współliniowe");
        	this.txt="(" + x1.getText() + "," + y1.getText() + ")   (" + x2.getText() + "," + y2.getText() + ")   (" + x3.getText() + "," + y3.getText() + ")   Punkty sa wspolliniowe";
        }
        else{
        	info.setText("(" + x1.getText() + "," + y1.getText() + ")   (" + x2.getText() + "," + y2.getText() + ")   (" + x3.getText() + "," + y3.getText() + ")   Punkty nie są współliniowe");
        	this.txt="(" + x1.getText() + "," + y1.getText() + ")   (" + x2.getText() + "," + y2.getText() + ")   (" + x3.getText() + "," + y3.getText() + ")   Punkty nie sa wspolliniowe";
        }
		//info.setText(txt+" P1 ("+x1.getText()+","+y1.getText()+") "+" P2 ("+x2.getText()+","+y2.getText()+") "+" P3 ("+x3.getText()+","+y3.getText()+") ");
		//this.txt=" P1 ("+x1.getText()+","+y1.getText()+") "+" P2 ("+x2.getText()+","+y2.getText()+") "+" P3 ("+x3.getText()+","+y3.getText()+") ";
	}

	public GUI() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		//zablokowane zeby layout nie wyglądal brzydnko
		setResizable(false);
		//tytul okna
		setTitle("Marcin Zelkowski");
		//jego rozmiar(szer,wys)
		setSize(520, 700);
		setVisible(true);
		//deklaracja obiektu menu
		JMenuBar mb = new JMenuBar();	
		//deklaracja pierwszego obiektu w menu
		JMenu menu1 = new JMenu("Plik");	
		//dodanie tego obiektu do menu 
		mb.add(menu1);	
		//deklaracja pozycji w menu
		//on wymaga listenera dla eventu wiec byl zadeklarowany wczesniej
		Zapisz = new JMenuItem("Zapisz");
		Zamknij = new JMenuItem("Zamknij");
		//dodanie 
		menu1.add(Zapisz);
		menu1.add(Zamknij);
		setJMenuBar(mb);//pojawianie menu
		Zapisz.addActionListener(al);
		Zamknij.addActionListener(al);
		
		//koniec menu początek pól
		 
		//pola na dane są zadeklarowane wcześniej ale i tak wymagają stworzenia ich jako obiekty
		x1 = new JTextField();
		x2 = new JTextField();
		x3 = new JTextField();
		//x1.addActionListener(new MyTextActionListener());  
		//x1.getDocument().putProperty("owner", x1);
		
		y1 = new JTextField();
		y2 = new JTextField();
		y3 = new JTextField();
		//listenery dla zmian w polach
		x1.getDocument().addDocumentListener(new MyDocumentListener());
		x2.getDocument().addDocumentListener(new MyDocumentListener());
		x3.getDocument().addDocumentListener(new MyDocumentListener());
		y1.getDocument().addDocumentListener(new MyDocumentListener());
		y2.getDocument().addDocumentListener(new MyDocumentListener());
		y3.getDocument().addDocumentListener(new MyDocumentListener());
				
		//układanie  pól na formie
		//(od lewej , od góry, szerokość ,wysokość)
		x1.setBounds(50, 50, 50, 20);
		x2.setBounds(200, 50, 50, 20);
		x3.setBounds(350, 50, 50, 20);
		
		y1.setBounds(100, 50, 50, 20);
		y2.setBounds(250, 50, 50, 20);
		y3.setBounds(400, 50, 50, 20);
			
		//dodanie pól
		add(x1);
		add(y1);
		add(x2);
		add(y2);
		add(x3);
		add(y3);
		
		JLabel p1= new JLabel(" P1 (x,y)");
		JLabel p2= new JLabel(" P2 (x,y)");
		JLabel p3= new JLabel(" P3 (x,y)");
					
		p1.setBounds(40, 20, 120, 60);
		p1.setVerticalAlignment(JLabel.TOP);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p2.setBounds(190, 20, 120, 60);
		p2.setVerticalAlignment(JLabel.TOP);
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setBounds(340, 20, 120, 60);
		p3.setVerticalAlignment(JLabel.TOP);
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		info.setBounds(40, 100, 420, 180);
		info.setVerticalAlignment(JLabel.TOP);
		info.setBorder(BorderFactory.createLineBorder(Color.black));
		add(p1);
		add(p2);
		add(p3);
		add(info);
		
		JComponent canvas = new JComponent() {
	        public void paintComponent(Graphics g) {
	            //ustala kolor markera
	            g.setColor(Color.WHITE);
	            //g.fillRect(0, 0, getWidth(), getHeight());
	            g.setColor(Color.BLACK); 
	            g.drawLine(0, 150, 500, 150);//x
	            g.drawLine(250, 0, 250, 300);//y
	            //strzałki osi
	            //y
	            g.drawLine(250, 0, 240, 10);
	            g.drawLine(250, 0, 260, 10);
	            //x
	            g.drawLine(490, 150, 480, 160);
	            g.drawLine(480, 140, 490, 150);
	            //podziałka
	            for (int i=10;i<=300;i=i+10) {
	            	g.drawLine(247, i, 253, i);//2
	            	if ((i % 50) == 0) {
	            		g.drawLine(245, i, 255, i);//2
	            	}
	            }
	            for (int i=10;i<=500;i=i+10) {
	            	g.drawLine(i, 147, i, 153);//x
	            	if ((i % 50) == 0) {
	            		g.drawLine(i, 145, i, 155);//x
	            	}
	            }
	            g.setColor(Color.RED);
	            //g.drawOval(25, 5, 5, 5);
	        };
	    };
	    int pkt;
	    Component canvas2 = new Component() {
	    	public void paintComponent2(Graphics g, int ws1,int ws2) {
	            g.setColor(Color.RED);
	            g.drawOval(ws1, ws2, 5, 5);
	        };
		};
	    canvas.setBounds(10, 300, 490, 300);//dorysowuje canva
		add(canvas);
		canvas2.setBounds(10, 300, 490, 300);//dorysowuje canva
		add(canvas2);
		}
		public int wspolrzedne(int liczba) {
			if(liczba>=0) {
				return 250+liczba;
			}
			return liczba; 
		}
}
