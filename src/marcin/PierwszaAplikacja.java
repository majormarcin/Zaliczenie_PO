package marcin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PierwszaAplikacja extends JFrame {
	
	
	
	private JTextField x1;
	private JTextField x2;
	private JTextField x3;
	private JTextField y1;
	private JTextField y2;
	private JTextField y3;

	//deklaracja pozycji w menu przed listenerem kt�ry wymaga obiektu
	private JMenuItem Zamknij;
	
	//listener dla eventu klikni�cia pozycji w menu
	private ActionListener al = new ActionListener(){
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == Zamknij)
	dispose();//zamkni�cie programu
	}
	};

	public PierwszaAplikacja() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		//tytu� okna
		setTitle("Marcin Zelkowski");
		//jego rozmiar(szer,wys)
		setSize(600, 800);
		
		setVisible(true);
		//deklaracja obiektu menu
		JMenuBar mb = new JMenuBar();
		
		//deklaracja pierwszego obiektu w menu
		JMenu menu1 = new JMenu("Plik");
		
		//dodanie tego obiektu do menu 
		mb.add(menu1);
		
		//deklaracja pozycji w menu
		JMenuItem menuItem11 = new JMenuItem("Zapisz");//
		Zamknij = new JMenuItem("Zamknij");//on wymaga listenera dla eventu wi�c by� zadeklarowany wcze�niej
		
		menu1.add(menuItem11);//dodanie 
		menu1.add(Zamknij);
		setJMenuBar(mb);//pojawianie menu
		
		
		Zamknij.addActionListener(al);
		//koniec menu pocz�tek p�l
		
		
		//pola na dane s� zadeklarowane wcze�niej ale i tak wymagaj� stworzenia ich jako obiekty
		x1 = new JTextField("x");
		x2 = new JTextField();
		x3 = new JTextField();
		
		y1 = new JTextField("y");
		y2 = new JTextField();
		y3 = new JTextField();
		
		//uk�adanie  p�l na formie
		//(od lewej , od g�ry, szeroko�� ,wysoko��)
		x1.setBounds(50, 50, 50, 20);
		x2.setBounds(200, 50, 50, 20);
		x3.setBounds(350, 50, 50, 20);
		
		y1.setBounds(100, 50, 50, 20);
		y2.setBounds(250, 50, 50, 20);
		y3.setBounds(400, 50, 50, 20);
		
		
		//fofanie p�l
		add(x1);
		add(y1);
		add(x2);
		add(y2);
		add(x3);
		add(y3);
		
		JLabel p1= new JLabel(" Punkt 1");
		JLabel p2= new JLabel(" Punkt 2");
		JLabel p3= new JLabel(" Punkt 3");
		
		
		p1.setBounds(40, 20, 120, 60);
		p1.setVerticalAlignment(JLabel.TOP);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p2.setBounds(190, 20, 120, 60);
		p2.setVerticalAlignment(JLabel.TOP);
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setBounds(340, 20, 120, 60);
		p3.setVerticalAlignment(JLabel.TOP);
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		add(p1);
		add(p2);
		add(p3);
		
		}
		
		public static void main(String args[]) {

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new PierwszaAplikacja();
				}
				});
		}
}
