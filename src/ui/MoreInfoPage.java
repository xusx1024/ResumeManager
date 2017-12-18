package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * 关于
 * 
 * @author sxx.xu
 *
 */
public class MoreInfoPage extends ParentJPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoreInfoPage() {
		JButton about = new JButton("关于");
		Box hbox0 = Box.createHorizontalBox();
		hbox0.add(about);
		hbox0.add(Box.createHorizontalStrut(kvSpace));

		add(hbox0, BorderLayout.CENTER);

		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), "版权所有,保留一切权利.");
			}
		});

	}

}
