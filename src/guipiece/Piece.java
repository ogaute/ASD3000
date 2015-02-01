package guipiece;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Piece extends JPanel{

	public Piece() {
		super();
		ImageIcon icon = new ImageIcon("exit.png");
		JLabel label = new JLabel(icon);
		add(label);
	}

}
