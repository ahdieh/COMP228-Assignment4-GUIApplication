
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.ImageIcon;


public class CalculateGPA extends JFrame implements ActionListener {
	
	// PRIVATE INSTANCE VARIABLES +++++++++++++++++++++++++++++++
	private JPanel _contentPane;	// JPanel Container
	private JLabel _imageLabel;
	private JLabel _label;
	private JLabel _messageLabel;
	private JLabel _creditHourLabel;
	private JTextField _creditHourTextField;
	private JButton _calculateBtn;
	private JLabel _currentGPALabel;
	private JTextField _currentGPATextField;
	private JLabel _numCoursesLabel;
	private JComboBox<String> _coursesComboBox;
	
	private Border _redBorder, _blackBorder;
	private JScrollPane _coursesScrollPane;
	private JPanel _coursesPanel;
	
	private ArrayList<JTextField> _coursesArrayList;
	private ArrayList<JComboBox<String>> _creditHourComboBox;
	private ArrayList<JComboBox<String>> _gradeComboBox;
	
	// the options of combo boxes
	private String[] _numCourses = {"0","1","2","3","4","5","6","7","8","9","10"};
	private String[] _creditHourList = {"1","2","3","4"};
	private String[] _gradeList = {"90 -100%  A+","80 - 89%  A","75 - 79%  B+","70 - 74%  B","65 - 69%  C+","60 - 64%  C","55 - 59%  D+","50 - 54%  D","0 - 49%  F"};
	private double[] _gradePoints = {4.5,4,3.5,3,2.5,2,1.5,1,0};
	
	private ArrayList<String> _gradeListArray;
	
	
	private GridBagLayout _gridBagLayout;

	
	
	// PUBLIC PROPERTIES +++++++++++++++++++++++++++++++++++++++++
	public JLabel getMessageLabel() {
		return this._messageLabel;
	}

	public void setMessageLabel(JLabel messageLabel) {
		this._contentPane.remove(this._messageLabel);
		this._messageLabel = messageLabel;
		this._addMessageLabel();
	}

	// CONSTRUCTOR METHOD +++++++++++++++++++++++++++++++++++++++
	public CalculateGPA() {
		this._initialize();
		this._setupBorders();
		this._addUIComponents();
		
		// Register event handler for Action Listeners
		this._creditHourTextField.addActionListener(this);
		
		this._calculateBtn.addActionListener(this);
		
		this._currentGPATextField.addActionListener(this);
		
		this._coursesComboBox.addActionListener(this);
	}
	
	// PRIVATE METHODS +++++++++++++++++++++++++++++++++++++++++++
	private void _initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 619);
		this._contentPane = new JPanel();
		this._contentPane.setBackground(new Color(255, 239, 213));
		this._contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this._contentPane);
		// fill the _gradeListArray
		this._gradeListArray = new  ArrayList<String>();
		for(int i =0; i<this._gradeList.length;i++){
			
			this._gradeListArray.add(this._gradeList[i]);
		}
		
	}
	
	private void _setupBorders() {
		this._blackBorder = BorderFactory.createLineBorder(Color.black);
		this._redBorder = BorderFactory.createLineBorder(Color.red);
	}
	
	private void _addMessageLabel() {
		this._messageLabel.setBounds(15, 518, 225, 29);
		this._contentPane.add(this._messageLabel);
	}

	// Add the UI components to the contentPane
	private void _addUIComponents() {
		// Use Absolute Layout
		this._contentPane.setLayout(null);
		
		// Hello Label
		this._messageLabel =new JLabel("New label");
		_messageLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		_messageLabel.setBackground(new Color(255, 140, 0));
		this._addMessageLabel();
		
		// Name Label
		this._creditHourLabel = new JLabel("Credit hours earned:");
		this._creditHourLabel.setBounds(15, 78, 161, 30);
		this._contentPane.add(_creditHourLabel);
		
		// Name Text Field
		this._creditHourTextField = new JTextField();
		this._creditHourTextField.setBackground(new Color(154, 205, 50));
		this._creditHourTextField.setSelectedTextColor(new Color(245, 245, 220));
		this._creditHourTextField.setBounds(176, 78, 104, 30);
		this._creditHourTextField.setText("");
		this._creditHourTextField.setBorder(this._blackBorder);
		this._contentPane.add(this._creditHourTextField);
		
		// calculate button
		this._calculateBtn = new JButton("Calculate");
		this._calculateBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		this._calculateBtn.setBackground(new Color(107, 142, 35));
		this._calculateBtn.setBounds(393, 518, 149, 29);
		this._contentPane.add(this._calculateBtn);
		
		// Age label
		this._currentGPALabel = new JLabel("Current GPA:");
		this._currentGPALabel.setBounds(313, 78, 104, 30);
		this._contentPane.add(this._currentGPALabel);
		
		// Age text field
		this._currentGPATextField = new JTextField();
		this._currentGPATextField.setBackground(new Color(154, 205, 50));
		this._currentGPATextField.setSelectedTextColor(new Color(245, 245, 220));
		this._currentGPATextField.setBounds(422, 78, 130, 30);
		this._currentGPATextField.setBorder(this._blackBorder);
		this._contentPane.add(this._currentGPATextField);
		
		// Number of courses label
		this._numCoursesLabel = new JLabel("Number of courses:");
		this._numCoursesLabel.setBounds(329, 124, 149, 38);
		this._contentPane.add(this._numCoursesLabel);
		
		// Combo box
		this._coursesComboBox = new JComboBox<String>();
		this._coursesComboBox.setBackground(new Color(154, 205, 50));
		this._coursesComboBox.setModel(new DefaultComboBoxModel<String>(this._numCourses));
		this._coursesComboBox.setSelectedIndex(0);
		this._coursesComboBox.setBounds(488, 124, 64, 38);
		this._contentPane.add(this._coursesComboBox);
		
		// Add ScrollPane to contain the todoJPanel
		this._coursesScrollPane = new JScrollPane(this._coursesPanel);
		this._coursesScrollPane.setBounds(123, 178, 419, 133);
		this._coursesScrollPane.setPreferredSize(new Dimension(8, 8));
		//this._todoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this._coursesScrollPane.setAutoscrolls(true);
		
		
		
		// Add a JPanel called todoPanel as a container for our dynamic components
		this._coursesPanel = new JPanel();
		this._coursesPanel.setBackground(new Color(154, 205, 50));
		this._coursesPanel.setBounds(new Rectangle(0, 0, 0, 20));
		
		this._coursesScrollPane.setViewportView(this._coursesPanel);
		
		 //Define the GridBagLayout to be able to scroll our components
		 this._gridBagLayout = new GridBagLayout();
		
		// Set the coursesPanel to gridBagLayout
		this._coursesPanel.setLayout( this._gridBagLayout);
		
		this._contentPane.add(this._coursesScrollPane);
		
				
		// Link the CoursesCodeTextField to the coursesPanel
		this._coursesArrayList = new ArrayList<JTextField>();
		
		this._creditHourComboBox = new ArrayList<JComboBox<String>>();
		
		this._gradeComboBox = new ArrayList<JComboBox<String>>();
		
		this._messageLabel.setText("Your GPA is:");
		
		this._imageLabel = new JLabel("");
		this._imageLabel.setIcon(new ImageIcon("images\\CentennialCollege_Logo_RGB_horizontal.jpg"));
		this._imageLabel.setBounds(0, 0, 143, 46);
		this._contentPane.add(this._imageLabel);
		
		this._label = new JLabel("Enter the currentGPA and the credits you earned:");
		this._label.setBounds(185, 27, 357, 20);
		this._contentPane.add(this._label);
		
	}

	

	@Override
	public void actionPerformed(ActionEvent event) {
		int numCourses = this._coursesComboBox.getSelectedIndex();
				
		if(event.getSource() == this._coursesComboBox) {
			
			
			
			this._coursesPanel.removeAll();
			
			GridBagConstraints constraints = new GridBagConstraints();
			constraints.weightx = 0.5;
			constraints.fill = GridBagConstraints.BOTH;
			constraints.insets = new Insets(5, 5, 5, 5);
			

			for(int col=0; col<4;col++){
				constraints.gridx = col;

			switch(col){
			case 0:
				for (int row=0; row<numCourses; row++){
					constraints.gridy = row;
					JLabel numberLabel = new JLabel();
					numberLabel.setText(Integer.toString(row+1));
					numberLabel.setPreferredSize( new Dimension(20,25));
					numberLabel.setHorizontalTextPosition(0);
					this._coursesPanel.add(numberLabel,constraints);
				}

			break;
			case 1:
				for (int row=0; row<numCourses; row++){
					constraints.gridy = row;
					JTextField textField = new JTextField();
					textField.setPreferredSize( new Dimension(100,25));
					this._coursesArrayList.add(textField);
					
					this._coursesPanel.add(this._coursesArrayList.get(this._coursesArrayList.size()-1),constraints);
				}
				break;
			case 2:
				for (int row=0; row<numCourses; row++){
					constraints.gridy = row;
					JComboBox<String> comboBox = new JComboBox<String>();
					comboBox.setModel(new DefaultComboBoxModel<String>(this._creditHourList));
					comboBox.setPreferredSize( new Dimension(15,25));
					this._creditHourComboBox.add(comboBox);
					this._coursesPanel.add(this._creditHourComboBox.get(this._creditHourComboBox.size()-1), constraints);
				}
				break;
			case 3:
				for (int row=0; row<numCourses; row++){
					constraints.gridy = row;
					JComboBox<String> comboBox = new JComboBox<String>();
					comboBox.setModel(new DefaultComboBoxModel<String>(this._gradeList));
					comboBox.setPreferredSize( new Dimension(60,25));
					this._gradeComboBox.add(comboBox);
					this._coursesPanel.add(this._gradeComboBox.get(this._gradeComboBox.size()-1), constraints);
				}
				break;
			}

				
			}
			this._messageLabel.setText(numCourses + " Courses");
			
			constraints.gridy++;
			constraints.weighty =1;
			this._contentPane.add(this._coursesScrollPane);
			// Redraw the panel
				this._coursesPanel.revalidate();
				
		}
		if(event.getSource()==this._calculateBtn) {
			double[] grade = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
			double qualityPoint = 0;
			double credit =0;
			double GPA =0;
			double totalGPA = 0;
			double c = 0;
			double d = 0;

				for (int i = 0; i<numCourses; i++){
					
					grade[i]=this._gradePoints[this._gradeListArray.indexOf(this._gradeComboBox.get(i).getSelectedItem())];

					qualityPoint =Double.valueOf((String)this._creditHourComboBox.get(i).getSelectedItem())*grade[i] + qualityPoint;
					
					credit = credit + Double.valueOf((String)this._creditHourComboBox.get(i).getSelectedItem());
					
					GPA = qualityPoint / credit;
					 c = qualityPoint + (Double.parseDouble(this._currentGPATextField.getText()));
					 d = credit + Double.parseDouble(this._creditHourTextField.getText());
					totalGPA =(double)(c/d);
					 	
				}
				this._messageLabel.setText("Your GPA is: " + totalGPA);
				
				
			}
	 
	}
}
