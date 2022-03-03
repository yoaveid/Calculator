import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class Calculator implements ActionListener {
	
	enum Operators{
		ADD,SUB,MUL,DIV,SQRT,POWER,PRECENT,SIN,COS,TAN,OPENֹ_PAERNTHESIS, CLOSE_PAERNTHESIS,NUMBER,PI,E,START, LN, LOG
	}
	JFrame frame;
	static JTextField textfield;
	JButton[] buttonNumbers = new JButton[10];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton , clrButton, negButton, preButton, powButton,powByTwoButton,
	piButton,eButton,factorialButoon,sqrtButton,openParButton,closeParButton;
	JButton radButton,degree,shift,sin,ln,cos,log,tan;
	
	JPanel Numberspanel, functionPanel;
	Font myFont = new Font("Ink Pink", Font.BOLD,25);
	static double result = 0;
	static boolean rad = true;
	static LinkedList <Double> numbers  = new LinkedList<Double>();
	static LinkedList <Operators> operators  = new LinkedList<Operators>();
	static LinkedList <Integer> connectNumAndOp  = new LinkedList<Integer>();

	public Calculator() {
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(775, 575);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50,25,405,50);
		textfield.setFont(myFont);
		textfield.setEditable(true);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("De");
		clrButton = new JButton("Clear");
		negButton = new JButton("(+\\-)");
		preButton = new JButton("%");
		powButton = new JButton("x^y");
		powByTwoButton = new JButton("x^2");
		sqrtButton = new JButton("√x");
		openParButton = new JButton("(");
		closeParButton = new JButton(")");
		factorialButoon = new  JButton("x!");
		piButton = new JButton("π");
		eButton = new JButton("e");
		radButton = new JButton("rad");
		degree = new JButton("deg");
		shift = new JButton("shift");
		sin = new  JButton("sin");
		ln = new JButton("ln");
		cos = new JButton("cos");
		log = new JButton("log");
		tan = new JButton("tan");

		JButton[] functionButtons = {addButton,subButton,mulButton,divButton,decButton, 
				equButton, delButton , clrButton, negButton, preButton, powButton,powByTwoButton,
				piButton,eButton,factorialButoon,sqrtButton,openParButton,closeParButton,
				radButton,degree,shift,sin,ln,cos,log,tan};

		for(int i = 0; i< functionButtons.length; i ++ )
		{
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i = 0; i< buttonNumbers.length; i ++ )
		{
			buttonNumbers[i] = new JButton(String.valueOf(i));
			buttonNumbers[i].addActionListener(this);
			buttonNumbers[i].setFont(myFont);
			buttonNumbers[i].setFocusable(false);
		}
		radButton.setBackground(new Color( 75,  205 ,52 ));
		clrButton.setBounds(50, 410, 325, 50);

		Numberspanel = new JPanel();
		functionPanel = new JPanel();
		Numberspanel.setBounds(50, 100, 325, 300);
		Numberspanel.setLayout(new GridLayout(5, 4, 5, 5));
		functionPanel.setBounds(400, 100, 325, 300);
		functionPanel.setLayout(new GridLayout(5, 5, 5, 5));
		Numberspanel.add(openParButton);
		Numberspanel.add(closeParButton);
		Numberspanel.add(preButton);
		Numberspanel.add(delButton);
		Numberspanel.add(buttonNumbers[7]);	
		Numberspanel.add(buttonNumbers[8]);	
		Numberspanel.add(buttonNumbers[9]);
		Numberspanel.add(addButton);
		Numberspanel.add(buttonNumbers[4]);	
		Numberspanel.add(buttonNumbers[5]);	
		Numberspanel.add(buttonNumbers[6]);	
		Numberspanel.add(subButton);
		Numberspanel.add(buttonNumbers[1]);	
		Numberspanel.add(buttonNumbers[2]);	
		Numberspanel.add(buttonNumbers[3]);	
		Numberspanel.add(mulButton);
		Numberspanel.add(decButton);
		Numberspanel.add(buttonNumbers[0]);	
		Numberspanel.add(equButton);
		Numberspanel.add(divButton);

		functionPanel.add(negButton);
		functionPanel.add(radButton);
		functionPanel.add(degree);
		functionPanel.add(piButton);
		functionPanel.add(eButton);
		functionPanel.add(shift);
		functionPanel.add(sin);
		functionPanel.add(cos);
		functionPanel.add(tan);
		functionPanel.add(log);
		functionPanel.add(ln);
		functionPanel.add(factorialButoon);
		functionPanel.add(powByTwoButton);
		functionPanel.add(powButton);
		functionPanel.add(sqrtButton);

		frame.add(Numberspanel);
		frame.add(functionPanel);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
	
		Calculator calc = new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i =0 ;i < buttonNumbers.length; i++ )
		{
			if(e.getSource() == buttonNumbers[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {

			textfield.setText(textfield.getText().concat("+"));
		}
		if(e.getSource() == subButton) {
			textfield.setText(textfield.getText().concat("-"));
		}
		if(e.getSource() == mulButton) {
			textfield.setText(textfield.getText().concat("*"));
		}
		if(e.getSource() == divButton) {
			textfield.setText(textfield.getText().concat("/"));
		}
		if(e.getSource() == powByTwoButton) {
			textfield.setText(textfield.getText().concat("^(2)"));
		}
		if(e.getSource() == powButton) {
			textfield.setText(textfield.getText().concat("^("));
		}
		if(e.getSource() == sqrtButton) {
			textfield.setText(textfield.getText().concat("√("));
		}
		if(e.getSource() == preButton) {
			textfield.setText(textfield.getText().concat("%"));
		}
		if(e.getSource() == eButton) {
			textfield.setText(textfield.getText().concat("e"));
		}
		if(e.getSource() == piButton) {
			textfield.setText(textfield.getText().concat("π"));
		}
		if(e.getSource() == sin) {
			textfield.setText(textfield.getText().concat("sin("));
		}
		if(e.getSource() == cos) {
			textfield.setText(textfield.getText().concat("cos("));
		}
		if(e.getSource() == tan) {
			textfield.setText(textfield.getText().concat("tan("));
		}
		if(e.getSource() == ln) {
			textfield.setText(textfield.getText().concat("ln("));
		}
		if(e.getSource() == log) {
			textfield.setText(textfield.getText().concat("log("));
		}
		if(e.getSource() == openParButton) {
			textfield.setText(textfield.getText().concat("("));
		}
		if(e.getSource() == closeParButton) {
			textfield.setText(textfield.getText().concat(")"));
		}
		if(e.getSource() == radButton) {
			rad = true;
			radButton.setBackground(new Color( 75,  205 ,52 ));
			degree.setBackground(null);
		}
		if(e.getSource() == degree) {
			rad = false;
			degree.setBackground(new Color( 75,  205 ,52 ));
			radButton.setBackground(null);
		}
		if(e.getSource() == equButton) {
			try {
				interpretExercise(textfield.getText());
				getResult(0,operators.size(),0);
				result = numbers.get(0) ;
				textfield.setText(String.valueOf(result));
			} catch (Exception e2) {
				// TODO: handle exception
			}
			numbers.clear();
			operators.clear();

		}
		if(e.getSource() == clrButton) {
			textfield.setText("");
			operators.clear();
			numbers.clear();
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			if(string.length() == 0)
				return;
			textfield.setText("");
			for(int i= 0; i < string.length()-1; i++) {
				textfield.setText(textfield.getText()+ string.charAt(i));
			}			
		}
		if(e.getSource() == negButton) {
			String ex = textfield.getText();
			if(ex.length() == 0)
				return;
			Operators last = Operators.START;
			double temp = 0;
			for (int i = ex.length() -1; i >=0 ; i--) {
				if(Character.isDigit(ex.charAt(i)) || (ex.charAt(i) == '.'))
				{
					last = Operators.NUMBER;
					continue;

				}
				else
					if(last == Operators.START)
						return;
					else if(ex.charAt(i) == '-')
					{
						temp = Double.parseDouble(ex.substring(i,ex.length()));
						temp = temp * -1;
						textfield.setText(textfield.getText().substring(0, i).concat(String.valueOf(temp)));
						return;
					}
					else
					{
						temp = Double.parseDouble(ex.substring(i+1,ex.length()));
						temp = temp * -1;
						textfield.setText(textfield.getText().substring(0, i+1).concat(String.valueOf(temp)));
						return;

					}
				}	
				temp = Double.parseDouble(ex.substring(0,ex.length()));
				temp = temp * -1;
				textfield.setText(String.valueOf(temp));		
		}
	}
	public static void getResult(int start,int end, int numberStart) throws IndexOutOfBoundsException {

		if(start == end)
			return;
		double temp = 0;
		for (int j =end -1;  j >= start; j--) {
			switch(operators.get(j))
			{
				case OPENֹ_PAERNTHESIS :
					int count =0;
					boolean exist = false;
					for (int k = j+1; k < end; k++) {
						
						if(operators.get(k) == Operators.CLOSE_PAERNTHESIS && count == 0)
							{
								operators.remove(k);
								operators.remove(j);
								connectNumAndOp.remove(k);
								connectNumAndOp.remove(j);
								while (j >= connectNumAndOp.size()) {
									j--;
									
								}
								getResult(j, k-1,connectNumAndOp.get(j));
								end = Math.min(end,operators.size());
								exist = true;
								break;
							}
						
						else if(operators.get(k) == Operators.CLOSE_PAERNTHESIS)
							count --;
						else if(operators.get(k) == Operators.OPENֹ_PAERNTHESIS)
							count ++;
					}
					if(!exist)
					{
						operators.remove(j);
						connectNumAndOp.remove(j);
						getResult(j, end-1,connectNumAndOp.get(j-1));
						end = operators.size();
					}
			}
		}
		int i = numberStart;
		for (int j=start; i < numbers.size() && j < end; j++,i++) {
			switch(operators.get(j))
			{
				case LN :
					numbers.set(i, Math.log(numbers.get(i)));
					connectNumAndOp.remove(j);

					operators.remove(j--);
					i--;
					end--;
				break;
				case LOG :
					numbers.set(i, Math.log10(numbers.get(i)));
					connectNumAndOp.remove(j);

					operators.remove(j--);
					i--;
					end--;
				break;
			}
		}
		i = numberStart;

		for (int j=start; i < numbers.size() && j < end; j++,i++) {
			switch(operators.get(j))
			{
				case SIN :
					if(rad)
						temp = Math.sin(numbers.get(i));
					else
						temp = Math.sin(numbers.get(i) * Math.PI / 180);
					numbers.set(i, temp);
					connectNumAndOp.remove(j);
					operators.remove(j--);
					i--;
					end--;		
				break;
				case COS :
					if(rad)
						temp = Math.cos(numbers.get(i));
					else
						temp = Math.cos(numbers.get(i) * Math.PI / 180);
					numbers.set(i, temp);
					connectNumAndOp.remove(j);
					operators.remove(j--);
					i--;
					end--;
					break;
				case TAN :
					if(rad)
						temp = Math.tan(numbers.get(i));
					else
						temp = Math.tan(numbers.get(i) * Math.PI / 180);
					numbers.set(i, temp);

					connectNumAndOp.remove(j);
					operators.remove(j--);
					i--;
					end--;
					break;
			}
		}
		i = numberStart;

		for (int j=start; i < numbers.size() && j < end; j++,i++) {
			switch(operators.get(j))
			{
				case POWER :
					temp = Math.pow(numbers.get(i),numbers.get(i+1));
					numbers.set(i+1, temp);
					numbers.remove(i);
					updateConnect(j);

					connectNumAndOp.remove(j);
					operators.remove(j--);
					i--;
					end--;
				break;
				case SQRT :
					temp = Math.sqrt(numbers.get(i));
					numbers.set(i, temp);
					updateConnect(j);
					connectNumAndOp.remove(j);

					operators.remove(j--);
					i--;
					end--;
					break;
				case PRECENT :
					numbers.set(i, numbers.get(i)/100);
					updateConnect(j);
					connectNumAndOp.remove(j);

					operators.remove(j--);
					end--;
					i--;
					break;
			}
		}
		i = numberStart;

		temp = numbers.get(i);
		i++;
		for (int j=start; i < numbers.size() && j < end; j++, i++) {
			switch(operators.get(j))
			{
				case MUL :
					temp *=  numbers.get(i);
					numbers.remove(i--);
					numbers.set(i, temp);
					updateConnect(j);
					connectNumAndOp.remove(j);

					operators.remove(j--);
					end--;
					break;
				case DIV :
					temp  /= numbers.get(i);
					numbers.remove(i--);
					numbers.set(i, temp);
					updateConnect(j);
					connectNumAndOp.remove(j);

					operators.remove(j--);
					end--;

					break;
			}
			temp = numbers.get(i);
		}
		i = numberStart;
		result = numbers.get(i);
		i++;
		for (int j=start; i < numbers.size() && j < end; i++,j++) {
			switch(operators.get(j))
			{
				case ADD :
					result += numbers.get(i);
					numbers.remove(i--);
					numbers.set(i, result);	
					updateConnect(j);
					connectNumAndOp.remove(j);

					operators.remove(j--);
					end--;
					break;
				case SUB :
					result -= numbers.get(i);
					numbers.remove(i--);
					numbers.set(i, result);
					updateConnect(j);
					connectNumAndOp.remove(j);

					operators.remove(j--);
					break;
			}
			result = numbers.get(i);

		}
	}

	public static void interpretExercise(String ex) {
		int firstCurrDig = 0;
		Operators last = Operators.START;
		boolean minus = false;
		for (int i = 0; i <= ex.length(); i++) {
			if(i == ex.length())
			{
				if(last == Operators.NUMBER)
					numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));	
				break;
			}
			if(Character.isDigit(ex.charAt(i)) || ex.charAt(i) == '.')
			{		
				if(last != Operators.NUMBER && last != Operators.START )
					if (minus) {
						firstCurrDig = i-1 ; 
					}
					else
						firstCurrDig = i;
				if(last == Operators.CLOSE_PAERNTHESIS)
				{
					operators.add(Operators.MUL);
					getConnect(Operators.MUL);

				}
				last = Operators.NUMBER;
				minus = false;
			}
			switch (ex.charAt(i)){
				case '+': {
					operators.add(Operators.ADD);
					
					if(last == Operators.NUMBER)
						numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
					getConnect(Operators.ADD);
					last = Operators.ADD;
					break;
				}
				case '-': {
					if(last != Operators.NUMBER && last != Operators.CLOSE_PAERNTHESIS&& last != Operators.PRECENT)
					{	
						minus = true;
						last = Operators.SUB;
						continue;
					}
					operators.add(Operators.SUB);
					if(last == Operators.NUMBER)
						numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
					getConnect(Operators.SUB);

					last = Operators.SUB;
					break;
				}
				case '*': {
					operators.add(Operators.MUL);
					if(last == Operators.NUMBER)
						numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
					getConnect(Operators.MUL);
					last = Operators.MUL;
					break;
				}
				case '/': {
					operators.add(Operators.DIV);
					if(last == Operators.NUMBER)
						numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
					getConnect(Operators.DIV);
					last = Operators.DIV;
					break;
				}
				case '%': {
					operators.add(Operators.PRECENT);
					if(last == Operators.NUMBER)
						numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
					getConnect(Operators.PRECENT);
					last = Operators.PRECENT;
					break;
				}
				case '^': {
					if(last == Operators.NUMBER)
						numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
					operators.add(Operators.POWER);
					getConnect(Operators.POWER);
					last = Operators.POWER;
					break;
				}
				case '√': {
					addMul(last,ex,firstCurrDig,i);
					operators.add(Operators.SQRT);
					last = Operators.SQRT;
					break;
				}
				case 'π':
				{
					addMul(last,ex,firstCurrDig,i);
					if(minus)
						numbers.add(Math.PI * -1);
					else
						numbers.add(Math.PI );
					last = Operators.PI;
					minus = false;
					break;
				}
				case 'e':
				{
					addMul(last,ex,firstCurrDig,i);
					if(minus)
						numbers.add(Math.E * -1);
					else
						numbers.add(Math.E );
					last = Operators.E;
					minus = false;
					break;
				}
				case 's':
				{
					addMul(last,ex,firstCurrDig,i);
					operators.add(Operators.SIN);
					getConnect(Operators.SIN);
					last = Operators.SIN;
					i +=2;
					break;
				}
				case 'c':
				{
					addMul(last,ex,firstCurrDig,i);
					operators.add(Operators.COS);
					getConnect(Operators.COS);
					last = Operators.COS;
					i +=2;
					break;
				}
				case 't':
				{
					addMul(last,ex,firstCurrDig,i);
					operators.add(Operators.TAN);
					getConnect(Operators.TAN);
					last = Operators.TAN;
					i +=2;
					break;
				}
				case 'l':
				{
					addMul(last,ex,firstCurrDig,i);
					if(ex.charAt(i+1) == 'n')
					{
						operators.add(Operators.LN);
						last = Operators.LN;
						getConnect(Operators.LN);
						i++;
					}
					else
					{
						operators.add(Operators.LOG);
						last = Operators.LOG;
						getConnect(Operators.LOG);
						i+=2;
					}
					break;
				}
				case ')': {
					operators.add(Operators.CLOSE_PAERNTHESIS);
					if(last == Operators.NUMBER)
						numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
					last = Operators.CLOSE_PAERNTHESIS;
					getConnect(Operators.CLOSE_PAERNTHESIS);
					break;
				}
				case '(': {
					if(last == Operators.NUMBER)
					{
						numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
						operators.add(Operators.MUL);
						getConnect(Operators.MUL);
					}
					operators.add(Operators.OPENֹ_PAERNTHESIS);
					getConnect(Operators.OPENֹ_PAERNTHESIS);
					last = Operators.OPENֹ_PAERNTHESIS;
					break;
				}
			}
		}
	}
	private static void getConnect(Operators curr) {

		Operators [] oneOperand = {Operators.OPENֹ_PAERNTHESIS,Operators.CLOSE_PAERNTHESIS
				,Operators.SIN,Operators.SQRT,Operators.COS,Operators.TAN,Operators.LN,Operators.LOG} ;
		for (int i = 0; i < oneOperand.length; i++) {
			if( curr == oneOperand[i])
			{
				connectNumAndOp.add(numbers.size());
				return;
			}
		}
		connectNumAndOp.add(numbers.size()-1);

	}
	private static void updateConnect(int start) {
		
		for (int i = start +1 ; i < connectNumAndOp.size(); i++) {
			connectNumAndOp.set(i, connectNumAndOp.get(i)-1);
		}

	}
	private static void addMul(Calculator.Operators last, String ex, int firstCurrDig, int i) {
		if(last == Operators.NUMBER)
		{
			numbers.add(Double.parseDouble(ex.substring(firstCurrDig,i)));
			operators.add(Operators.MUL);
			getConnect(Operators.MUL);
		}
		else if(last == Operators.CLOSE_PAERNTHESIS)
			{
				operators.add(Operators.MUL);
				getConnect(Operators.MUL);
			}
	}
}
