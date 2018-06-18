package marcin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PierwszaAplikacja  {
	
	
	
		public static void main(String args[]) {

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
				new GUI();
				}
				});
		}
		
		
}
