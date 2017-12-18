package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 修改,删除简历
 * 
 * @author sxx.xu
 *
 */
public class UpdatePage extends ParentJPanel {

	private static final long serialVersionUID = 1L;

	public UpdatePage(String s) {

		JLabel nameKey = new JLabel("姓    名:");
		JTextField nameValue = new JTextField(textLen);
		JButton update = new JButton(s);

		Box hbox0 = Box.createHorizontalBox();
		hbox0.add(nameKey);
		hbox0.add(Box.createHorizontalStrut(kvSpace));
		hbox0.add(nameValue);
		hbox0.add(Box.createHorizontalStrut(itemHSpace));
		hbox0.add(update);

		Box vbox = Box.createVerticalBox();
		vbox.add(hbox0);
		vbox.add(Box.createVerticalStrut(itemVSpace));

		add(vbox, BorderLayout.CENTER);

		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ("修改".equals(s)) {
					JOptionPane.showMessageDialog(getParent(), "修改:" + nameValue.getText());
				} else if ("删除".equals(s)) {
					JOptionPane.showMessageDialog(getParent(), "删除:" + nameValue.getText());
				}
			}
		});
	}

}
