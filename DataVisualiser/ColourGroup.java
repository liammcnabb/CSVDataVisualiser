/**
*	@file ColourGroup.java
*	@author Chris Jenkins
*	@date 11 April 2013
*	@see ColourSelector, GUI
*	@brief ColourGroup generates the colour schemes for each chart.
*
*	ColourGroup generates a colour then it returns the colour.
*/

import java.util.Random;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class ColourGroup {
	/** 
	 * The constructor for ColourGroup
	 */
	public ColourGroup(){
	}
	
	/** 
	 * The constructor for ColourGroup with four parameters
	 * @param Reds, Blues, Greens, size, RedVal, GreVal, BluVal
	 */
	public ColourGroup(int[] Reds, int[] Blues, int[] Greens, int size,
			int RedVal, int GreVal, int BluVal){       
		SetRed(Reds);
		SetBlue(Blues);
		SetGreen(Greens);
		SetSize(size);
		SetRedVal(RedVal);
		SetBluVal(BluVal);
		SetGreVal(GreVal);
	}
	
	/**
	 * GetBlue - integer array that returns the int array Blue
	 * @return Blue
	 */
	public static int[] GetBlue(){
		return Blue;
	}
	
	/**
	 * GetBluVal - integer that returns the integer m_BluVal 
	 * @return m_BluVal
	 */
	public static int GetBluVal(){
		return m_BluVal;
	}
	
	/**
	* This method returns the colour, dependent on which 
	* string has been passed to this class.
	*
	* @param group is the string which corresponds to one 
	* of the colour schemes in this class.
	*
	* @return the colour which corresponds to the string passed.
	*/			
	public static Color GetColour(String group) {
		if (group.equals(WARM)) return Warm();
		if (group.equals(RANDOM)) return Random();
		if (group.equals(COLD)) return Cool();
		if (group.equals(KIWI)) return Kiwi();
		if (group.equals(GRAPE)) return Grape();
		if (group.equals(CUSTOM)) return Custom();
		
		return Color.BLACK;
	}
	
	/**
	 * GetGreen - integer array that returns the int array Green
	 * @return Green
	 */
	public static int[] GetGreen(){
		return Green;
	}
	
	/**
	 * GetGreVal - integer that returns the integer m_GreVal
	 * @return m_GreVal
	 */
	public static int GetGreVal(){
		return m_GreVal;
	}
	
	/**
	 * GetRed - integer array that returns the int array Red
	 * @return Red
	 */
	public static int[] GetRed(){
		return Red;
	}
	
	/**
	 * GetRedVal - integer that returns the integer m_RedVal
	 * @return m_RedVal
	 */
	public static int GetRedVal(){
		return m_RedVal;
	}
	
	/**
	 * GetSize - integer that returns the value entered by the user 
	 * @return m_Size
	 */
	public static int GetSize() {
		return m_Size;
	}
	
	/**
	 * SetBlue - method that sets and checks the int array Blue
	 * @param Blues
	 */
	public static void SetBlue(int[] Blues){
		boolean test = true;

		/*if the value is between 0 and 15 then it is valid otherwise 
		 * the value is output*/
		for(int i = 0; i < Blues.length; i++) {
			if(Blues[i] > MAX_SIZE && Blues[i] < 0){
				System.err.println("***Warning ColourGroup::" + "SetBlue()" + 
			"The Value at position " + i + " is not valid");
			}else System.out.println("ColourGroup::" + "SetBlue()" + 
			"The value at position " + i + " is set to "+ Blues[i]);
		}
		
		Blue = new int[Blues.length];
		/*if the value is less than 0 then it is too small*/
		if((Blue.length < 0)&&(test)){
			System.err.println("***Warning ColourGroup::"+
			"SetBlue()" +
			"Blues array is too small");
		}
		/* If the value is more than 15 then it is too big*/
		else if((Blue.length > 15)&&(test)){
			System.err.println("***Warning ColourGroup::"+
			"SetBlue()" +
			"Blues array is too big");
		}
		/* If the value is between 0 and 15 then is is accepted*/
		else if((Blue.length > 0) && (Blue.length <= 15)){
			System.out.println("ColourGroup::"+
			"SetBlue()" +
			"Blues is value:" + Blues.length);
			Blue = Blues;
		}
	}	
	
	/**
	 * SetBluVal - Sets the value of m_BluVal
	 * @param value
	 */
	public static void SetBluVal(int value){
		m_BluVal = value;
	}
	
	/**
	 * SetGreen - method that sets and check int array Green
	 * @param Greens
	 */
	public static void SetGreen(int[] Greens){
		boolean test = true;

		/*if the value is between 0 and 15 then it is valid otherwise 
		 * the value is output*/
		for(int i = 0; i < Greens.length; i++) {
			if(Greens[i] > MAX_SIZE && Greens[i] < 0){
				System.err.println("ColourGroup::" + "SetGreen()" + 
			"The Value at position " + i + " is not valid");
			}else System.out.println("ColourGroup::" + "SetGreen()" + 
			"The value at position " + i + " is set to "+ Greens[i]);
		}
		
		Green = new int[Greens.length];
		/* If the value is less than 0 then it too small*/
		if((Green.length < 0)&&(test)){
			System.err.println("***Warning ColourGroup::"+
			"SetGreen()" +
			"Greens array is too small");
		}
		/* If the value is more than 15 then it is too big*/
		else if((Green.length > 15)&&(test)){
			System.err.println("***Warning ColourGroup::"+
			"SetGreens()" +
			"Greens array is too big");
		}
		/* If the value is between 0 and 15 then is is accepted*/
		else if((Green.length > 0) && (Greens.length <= 15)){
			System.out.println("ColourGroup::"+
			"SetGreen()" +
			"Greens is value:" + Greens.length);
			Green = Greens;
		}
	}
	
	/**
	 * SetGreVal - sets the value of m_GreVal
	 * @param value
	 */
	public static void SetGreVal(int value){
		m_GreVal = value;
	}
	
	/**
	 * SetRed - method that sets and check the int array Red
	 * @param Reds
	 */
	public static void SetRed(int[] Reds){
		boolean test = true;
		
		
		/*if the value is between 0 and 15 then it is valid 
		 * otherwise the value is output*/
		for(int i = 0; i < Reds.length; i++) {
			if(Reds[i] > MAX_SIZE && Reds[i] < 0){
				System.err.println("***Warning ColourGroup::" + "SetRed()" + 
			"The Value at position " + i + " is not valid");
			}else System.out.println("ColourGroup::" + "SetRed()" + 
			"The value at position " + i + " is set to "+ Reds[i]);
		}
		
		Red = new int[Reds.length];
		
		/*if the value is less than 0 then it is too small*/
		if((Red.length < 0)&&(test)){
			System.err.println("***Warning ColourGroup::"+
			"SetRed()" +
			"Reds array is too small");
		}
		/*If the value is more than 15 then it is too big*/
		else if((Red.length > 15)&&(test)){
			System.err.println("***Warning ColourGroup::"+
			"SetRed()" +
			"Reds array is too big");
		}
		/*If the value is between 0 and 15 then it is accepted*/
		else if((Red.length > 0) && (Red.length <= 15)){
			System.out.println("ColourGroup::"+
			"SetRed()" +
			"Reds is value:" + Reds.length);
			Red = Reds;
		}
	}
	
	/**
	 * SetRedVal - sets the value of m_RedVal
	 * @param value
	 */
	public static void SetRedVal(int value){
		m_RedVal = value;
	}
	
	/**
	 * SetSize - Sets and checks size
	 * @param size
	 */
	public static void SetSize(int size) {
		boolean test = true;

		/* If the value entered is more than 15 then it is too big*/
		if((size > MAX_SIZE)&&(test)){
			System.err.println("***Warning ColourGroup::"+
			"SetSize()" +
			"Size is too big to be a colour");
			JOptionPane.showMessageDialog(null, 
			"You entered a number greater than 15, " +
			"The number of colours has been set to 10 for you.", 
			"Too many colours!", JOptionPane.ERROR_MESSAGE);
			m_Size = 10;
		}
		/*if the value entered is less than 0 then it is too small*/
		else if ((size < 0)&&(test)){
			System.err.println("***Warning ColourGroup::"+
					"SetSize()" +
					"Size is too small to be a colour");
			JOptionPane.showMessageDialog(null, 
					"You entered a number less than 0, " +
					"The number of colours has been set to 1 for you.", 
					"Too few colours!", JOptionPane.ERROR_MESSAGE);
					m_Size = 1;
		}
		/*otherwise the value is output and assigned to m_Size*/
		else {
			System.out.println("ColourGroup::"+
			"SetSize()" +
			"Size is value:" + size);
			m_Size = size;
		}
	}
	
	/** 
	 * The main contains three sets of tests of the input 
	 * into ColourGroup's parameters 
	 */
	public static void main(String[] args){
		boolean test = true;
		if(test == true){
			int[] good1 = {200, 201, 202};
			int[] good2 = {200, 201, 202};
			int[] good3 = {200, 201, 202};
			int good4 = 5;
			int[] bad1 = {-1,-2,-3};
			int[] bad2 = {-1,-2,-3};
			int[] bad3 = {-1,-2,-3};
			int bad4 = -4;
			int[] empty1 = { };
			int[] empty2 = { };
			int[] empty3 = { };
		
			/*An instance of ColourGroup with expected data*/
			ColourGroup good = new ColourGroup(good1,good2,good3,good4,
					good1[1],good2[1],good3[1]);
			/*An instance of ColourGroup with values that are not usable*/
			ColourGroup bad = new ColourGroup(bad1,bad2,bad3,bad4,bad1[1],
					bad2[1],bad3[1]);
			/*An instance of ColourGroup with values that are empty*/
			ColourGroup empty = new ColourGroup(empty1,empty2,empty3,bad4,
					bad4,bad4,bad4);
		}
	}
	
	/**
	* This method returns the colour, generated 
	* from a "cool" set of rgb values
	*
	* @return the colour which corresponds to the generated rgb values.
	*/		
	public static Color Cool() {
	
		int m_ColourRand = m_Rand.nextInt(3);
		
		if (m_ColourRand == 0) {
			SetRedVal(m_Rand.nextInt(30));
			SetGreVal(m_Rand.nextInt(114));
			SetBluVal(m_Rand.nextInt(127)+126);
		} else if (m_ColourRand == 1) {
			SetRedVal(m_Rand.nextInt(155));
			SetGreVal(m_Rand.nextInt(155)+100);
			SetBluVal(m_Rand.nextInt(50));
		} else if (m_ColourRand == 2) {
			SetRedVal(m_Rand.nextInt(100)+86);
			SetGreVal(m_Rand.nextInt(115));
			SetBluVal(m_Rand.nextInt(100)+155);
		}
		Color CoolColour = new Color(GetRedVal(), GetGreVal(), GetBluVal());

		return CoolColour;
	}
	
	/**
	* This method returns the colour scheme "Custom", 
	* generated from user selected values
	*
	* @return the colour which corresponds to the generated rgb values.
	*/
	private static Color Custom() {
		
		int m_ColourRand = m_Rand.nextInt(m_Size);
		int[] red = GetRed();	
		SetRedVal(red[m_ColourRand]);
		int[] blue = GetBlue();	
		SetBluVal(blue[m_ColourRand]);
		int[] green = GetGreen();
		SetGreVal(green[m_ColourRand]);	
		
		Color CustomColour = new Color(GetRedVal(), GetGreVal(), GetBluVal());
		
		return CustomColour;
	}
	
	/**
	* This method returns the colour scheme "Grape", generated 
	* from a set of rgb values
	* 
	* @return the colour which corresponds to the generated rgb values.
	*/
	private static Color Grape(){
	int m_ColourRand = m_Rand.nextInt(3);	 
		if (m_ColourRand == 0) {
			SetRedVal(m_Rand.nextInt(100));
			SetGreVal(m_Rand.nextInt(20));
			SetBluVal(m_Rand.nextInt(255));
		} else if (m_ColourRand == 1) {
			SetRedVal(m_Rand.nextInt(240));
			SetGreVal(m_Rand.nextInt(15));
			SetBluVal(m_Rand.nextInt(190));
		} else if (m_ColourRand == 2) {
			SetRedVal(m_Rand.nextInt(20));
			SetGreVal(m_Rand.nextInt(20));
			SetBluVal(m_Rand.nextInt(255));
		}
		Color BlueColour = new Color(GetRedVal(), GetGreVal(), GetBluVal());
		
		return BlueColour;
	}
	
	/**
	* This method returns the colour scheme "Kiwi", 
	* generated from a set of rgb values
	*
	* @return the colour which corresponds to the generated rgb values.
	*/
	private static Color Kiwi(){
	int m_ColourRand = m_Rand.nextInt(3);	 
		if (m_ColourRand == 0) {
			SetRedVal(20);
			SetGreVal(255);
			SetBluVal(20);
		} else if (m_ColourRand == 1) {
			SetRedVal(130);
			SetGreVal(150);
			SetBluVal(30);
		} else if (m_ColourRand == 2) {
			SetRedVal(30);
			SetGreVal(150);
			SetBluVal(110);
		}
		Color GreenColour = new Color(GetRedVal(), GetGreVal(), GetBluVal());
		
		return GreenColour;
	}
	
	/**
	* This method returns the colour, generated 
	* from a random set of rgb values
	*
	* @return the colour which corresponds to the generated rgb values.
	*/	
	private static Color Random() {
		SetRedVal(m_Rand.nextInt(255));
		SetGreVal(m_Rand.nextInt(255));
		SetBluVal(m_Rand.nextInt(255));
		
		Color RandomColour = new Color(GetRedVal(), GetGreVal(), GetBluVal());
		
		return RandomColour;
	}

	/**
	* This method returns the colour, generated 
	* from a "warm" set of rgb values
	*
	* @return the colour which corresponds to the generated rgb values.
	*/	
	private static Color Warm() {	
		int ColourRand = m_Rand.nextInt(3);	 
		if (ColourRand == 0) {
			SetRedVal(m_Rand.nextInt(127)+126);
			SetGreVal(m_Rand.nextInt(42));
			SetBluVal(m_Rand.nextInt(60));
		} else if (ColourRand == 1) {
			SetRedVal(m_Rand.nextInt(40)+215);
			SetGreVal(m_Rand.nextInt(65)+100);
			SetBluVal(0);
		} else if (ColourRand == 2) {
			SetRedVal(m_Rand.nextInt(40)+215);
			SetGreVal(m_Rand.nextInt(40)+215);
			SetBluVal(0);
		}
		Color WarmColour = new Color(GetRedVal(), m_GreVal, m_BluVal);
		
		return WarmColour;
	}
	
	/*string taken in from GUI which relates to the Warm colour scheme*/
	public static final String	WARM = "C_WARM";
	/*string taken in from GUI which relates to the Random colour scheme*/
	public static final String	RANDOM = "C_RANDOM";
	/*string taken in from GUI which relates to the Cold colour scheme*/
	public static final String	COLD = "C_COLD";
	/*string taken in from GUI which relates to the Kiwi colour scheme*/
	public static final String	KIWI = "C_KIWI";
	/*string taken in from GUI which relates to the Grape colour scheme*/
	public static final String	GRAPE = "C_GRAPE";
	/*string taken in from GUI which relates to the Custom colour scheme*/
	public static final String  CUSTOM = "C_CUSTOM";
	
	/*The values in which the values of red, blue and green are stored*/
	private static int m_RedVal = 0;
	private static int m_GreVal = 0;
	private static int m_BluVal = 0;
	
	/*The array that stores the Red value*/
	private static int[] Red;
	/*The array that stores the Green value*/
	private static int[] Green;
	/*The array that stores the Blue value*/
	private static int[] Blue;
	
	/*A random value which is used to generate random colours*/
	private static Random m_Rand = new Random();
	
	/*The number of colours in Custom defined by the user*/
    private static int m_Size;
    
    /*The maximum that size supports*/
    private static int MAX_SIZE = 15;
    
}