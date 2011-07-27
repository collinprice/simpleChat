package simpleChat.gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import simpleChat.client.ChatClient;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ChatBox extends javax.swing.JFrame {

	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private static JTextArea textWindow;
	private JButton submitButton;
	private JTextField inputWindow;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private static String user = "Wally";
	private static ChatClient chatter;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		if (args.length > 0) {
			user = args[0];
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ChatBox inst = new ChatBox();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				
				chatter = new ChatClient(user,textWindow);
				
			}
		});
	}
	
	public ChatBox() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				inputWindow = new JTextField();
				getContentPane().add(inputWindow, BorderLayout.WEST);
				inputWindow.setPreferredSize(new java.awt.Dimension(305, 28));
			}
			{
				submitButton = new JButton();
				getContentPane().add(submitButton, BorderLayout.EAST);
				submitButton.setText("Submit");
				submitButton.setPreferredSize(new java.awt.Dimension(77, 34));
				submitButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						submitButtonMouseClicked(evt);
					}
				});
			}
			{
				textWindow = new JTextArea();
				textWindow.setPreferredSize(new java.awt.Dimension(384, 199));
				JScrollPane scrollPane = new JScrollPane(textWindow);
				scrollPane.setAutoscrolls(true);
				getContentPane().add(scrollPane, BorderLayout.NORTH);
				
				textWindow.setEditable(false);
			}
			setSize(400, 300);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("New");
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Open");
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Save As ...");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void submitButtonMouseClicked(MouseEvent evt) {
		chatter.sendMessage(inputWindow.getText());
		textWindow.setCaretPosition(textWindow.getDocument().getLength());
		inputWindow.setText("");
		inputWindow.requestFocus();
		
	}

}
