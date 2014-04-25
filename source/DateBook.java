//Alex Yao Yang
//Lam Ka Yan
//P02
//Project #5 Java Date Book
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date.*;
import java.util.Calendar.*;
import java.text.*;

public class DateBook extends JFrame {
	
	JLabel nu,su,m,tu,w,th,f,sa,wn1,wn2,wn3,wn4,wn5,wn6,date,month,e1,e2,e3,e4,e5,e6,popUpEvent,popUpApp,lblLoc,lblTime,lblSub,nub;//From n~sa are the labels for days of week. wn1~wn5 are the week numbers.
	JPanel main,smain,p1,p2,p3,p4,p5,popUp1,popUp2,popUp3;//All panels
	JTextField popUptf,popUptf2,subject,location;
	JComboBox cb,cb1;//For ComboBox
	JButton temp,CONFIRM,CLEAR;
	JFrame popUpWin,newDates;
	JSpinner sp1,sp2;
	String a,hour,min,s;
	int i,x,hr,mn,one;
	String[] months = {"Select Month","January","February","March","April","May","June","July","August","September","October","November","December"};//Months For ComboBox
	String[] years = {"2008","2009","2010"};//Year numbers
	String[] strHour = new String[50];
	String[] strMin = new String[100];
	String[] app=new String[9999];

	String[] sub= new String[9999];
	String[] loc= new String[9999];
	String[] saveHour = new String[9999];
	String[] saveMin = new String[9999];
    public DateBook() {
    
    setTitle("Java Date Book");//Title
    setLocation(100,100);
    setSize(500,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    
    main = new JPanel();//Main for Titled Border and every other thing.
    main.setBorder(BorderFactory.createTitledBorder("Date"));
    main.setLayout(new BorderLayout(10,10));//For spaces between panels.
    
    p1 = new JPanel();//Combo Box and Spinner.
    p1.setLayout(new GridLayout(1,2));
    cb = new JComboBox(months);//Creating and Adding of String into ComboBox
    cb.addActionListener(new cblisten());
    
    cb1 = new JComboBox(years);//Creating a new Combo Box and adding years array into Combo Box
    cb1.addActionListener(new cblisten());
    
    p1.add(cb);
    p1.add(cb1);

    smain = new JPanel();//Submain, For the main part of the calender.
    smain.setLayout(new BorderLayout());
    smain.setBorder(BorderFactory.createLoweredBevelBorder());//The effect of the calender.
    smain.setBackground(Color.RED);
    
    p2 = new JPanel();//For names of days of weeks.
    p2.setLayout(new GridLayout(1,8,20,0));
    p2.setBackground(Color.pink);
    
    p3 = new JPanel();//For Week Numbers.
    p3.setLayout(new GridLayout(6,1));
    p3.setBackground(Color.pink);
    
    p4 = new JPanel();//Panel at bottom telling month and date
    p4.setLayout(new GridLayout(1,5));
    date = new JLabel("   Today: "+getDate(new Locale("en","US")));//For showing today's date.
    month = new JLabel("    Month Selected: None");
    p4.add(date);
    p4.add(month);
    
    p5 = new JPanel();//Welcome Screen
    p5.setLayout(new GridLayout(5,7));
    Font f = new Font("Helvetica",Font.BOLD|Font.ITALIC, 42);
    e1 = new JLabel("WELCOME TO ALEX",JLabel.CENTER);
    e2 = new JLabel("AND KAYAN'S",JLabel.CENTER);
    e3 = new JLabel("CALENDER! =)",JLabel.CENTER);
    e5 = new JLabel("Please Select a Year and Month to Start.",JLabel.CENTER);
    e4 = new JLabel("Today's Date is Shown Below.",JLabel.CENTER);
    e1.setFont(f);
    e1.setForeground(Color.RED);
    e2.setFont(f);
    e2.setForeground(Color.GREEN);
    e3.setFont(f);
    e3.setForeground(Color.BLUE);
    p5.add(e5);
    p5.add(e1);
    p5.add(e2);
    p5.add(e3);
    p5.add(e4);
    
    smain.add(p5,"Center");    
    smain.add(p4,"South");
    smain.add(p2,"North");
    smain.add(p3,"West");
    main.add(p1,"North");
    main.add(smain,"Center");
    add(main);
    
    setVisible(true);

    }
	public class cblisten implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			int n = cb.getSelectedIndex();
			int k = cb1.getSelectedIndex();
			//System.out.println(n);
			//System.out.println(k);
			
			if(n!=0)
			{
			newDates = new JFrame();
    
   	       	newDates.setTitle("Java Date Book");
           	newDates.setSize(500,500);
           	//newDates.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           	newDates.setLocation(100,100);
           	newDates.setLayout(new BorderLayout());
           
           	main = new JPanel();//Main for Titled Border and every other thing.
    		main.setBorder(BorderFactory.createTitledBorder("Date"));
    		main.setLayout(new BorderLayout(10,10));//For spaces between panels.
    		
    		p1 = new JPanel();//Combo Box and Spinner.
    		p1.setLayout(new GridLayout(1,2));
    		cb = new JComboBox(months);//Creating and Adding of String into ComboBox
    		cb.addActionListener(new cblisten());
    		
    		cb1 = new JComboBox(years);//Creating a new Combo Box and adding years array into Combo Box
    		cb1.addActionListener(new cblisten());
    
    		p1.add(cb);
    		p1.add(cb1);
		
    		smain = new JPanel();//Submain, For the main part of the calender.
    		smain.setLayout(new BorderLayout());
    		smain.setBorder(BorderFactory.createLoweredBevelBorder());//The effect of the calender.
		    
    		p2 = new JPanel();//For names of days of weeks.
    		p2.setLayout(new GridLayout(1,8,20,0));
    		p2.setBackground(Color.pink);
    		nu = new JLabel("");
    		su = new JLabel("S");
    		m = new JLabel("M");
    		tu = new JLabel("T");
    		w = new JLabel("W");
    		th = new JLabel("T");
    		f = new JLabel("F");
    		sa = new JLabel("S");
    		p2.add(nu);
    		p2.add(su);
    		p2.add(m);
    		p2.add(tu);
    		p2.add(w);
    		p2.add(th);
    		p2.add(f);
    		p2.add(sa);
    		
    		p3 = new JPanel();//For Week Numbers.
    		p3.setLayout(new GridLayout(6,1));
    		p3.setBackground(Color.pink);
    		wn1 = new JLabel("          ");
    		wn2 = new JLabel("          ");
    		wn3 = new JLabel("          ");
    		wn4 = new JLabel("          ");
    		wn5 = new JLabel("          ");
    		wn6 = new JLabel("          ");
    		p3.add(wn1);
    		p3.add(wn2);
    		p3.add(wn3);
    		p3.add(wn4);
    		p3.add(wn5);
    		p3.add(wn6);
		    
    		p4 = new JPanel();
    		p4.setLayout(new GridLayout(1,5));
    		date = new JLabel("   Today: "+getDate(new Locale("en","US")));//For showing today's date.
    		p4.add(date);
    		
    		p5 = new JPanel();
    		p5.setLayout(new GridLayout(5,7));
		    
		    if(k==0)//Year 2008
		    {//dispose();
		    if(n==1)//Jan
		    {String s ="January";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<2;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=1;}
		    
		    else if(n==2)//Feb
		    {String s ="February";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<30;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=2;}
		    
		    else if(n==3)//Mar
		    {String s ="March";month = new JLabel("Month Selected: "+s);p4.add(month);
		    p5.setLayout(new GridLayout(6,7));
		    for(i=0;i<6;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=3;}
		    
		    else if(n==4)//April
		    {String s ="April";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<2;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=4;}
		    
		    else if(n==5)//May
		    {String s ="May";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<4;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=5;}
		    
		    else if(n==6)//June
		    {String s ="June";month = new JLabel("Month Selected: "+s);p4.add(month);
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=6;
    		JLabel e1 = new JLabel("");p5.add(e1);}
		    
		    else if(n==7)//July
		    {String s ="July";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<2;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=7;}
		    
		    else if(n==8)//August
		    {String s ="August";month = new JLabel("Month Selected: "+s);p4.add(month);
		    p5.setLayout(new GridLayout(6,7));
		    for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=8;
 			JLabel e1 = new JLabel("");p5.add(e1);}
		    
		    else if(n==9)//Sept
		    {String s ="September";month = new JLabel("Month Selected: "+s);p4.add(month);
		    JLabel e1 = new JLabel("");p5.add(e1);
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=9;}
		    
		    else if(n==10)//Oct
		    {String s ="October";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<3;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=10;}
		    
		    else if(n==11)//Nov
		    {String s ="November";month = new JLabel("Month Selected: "+s);p4.add(month);
		    p5.setLayout(new GridLayout(6,7));
		    for(i=0;i<6;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=11;
    		JLabel e1 = new JLabel("");p5.add(e1);}
		    
		    else if(n==12)//Dec
		    {String s ="December";month = new JLabel("Month Selected: "+s);p4.add(month);
		    JLabel e1 = new JLabel("");p5.add(e1);
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}one=12;}}
    		
    		else if(k==1)//Year 2009
		    {cb1.setSelectedIndex(1);
		    dispose();
		  	if(n==1)//Jan
		    {one=13;
		    String s ="January";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<4;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    if(n==2)//Feb
		    {one=14;
		    String s ="February";month = new JLabel("Month Selected: "+s);p4.add(month);
    		for(i=1;i<29;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}
    		for(i=0;i<6;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}}
		    
		    else if(n==3)//Mar
		    {one=15;
		    	String s ="March";month = new JLabel("Month Selected: "+s);p4.add(month);
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==4)//April
		    {one=16;
		    	String s ="April";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<3;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==5)//May
		    {one=17;
		    	String s ="May";month = new JLabel("Month Selected: "+s);p4.add(month);
		    p5.setLayout(new GridLayout(6,7));
		    for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}
    		for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}}
		    
		    else if(n==6)//June
		    {one=18;
		    	String s ="June";month = new JLabel("Month Selected: "+s);p4.add(month);
		    JLabel e1 = new JLabel("");p5.add(e1);
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==7)//July
		    {one=19;
		    	String s ="July";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<3;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==8)//August
		    {one=20;
		    	String s ="August";month = new JLabel("Month Selected: "+s);p4.add(month);
		    p5.setLayout(new GridLayout(6,7));
		    for(i=0;i<6;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==9)//Sept
		    {one=21;
		    	String s ="September";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<2;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==10)//Oct
		    {one=22;
		    	String s ="October";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<4;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==11)//Nov
		    {one=23;
		    	String s ="November";month = new JLabel("Month Selected: "+s);p4.add(month);
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}
    		JLabel e1 = new JLabel("");p5.add(e1);}
		    
		    else if(n==12)//Dec
		    {one=24;String s ="December";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<2;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}}
    		
    		else if(k==2)//Year 2010
		    {cb1.setSelectedIndex(2);
		    dispose();
		  	if(n==1)//Jan
		    {one=25;
		    String s ="January";month = new JLabel("Month Selected: "+s);p4.add(month);
		    p5.setLayout(new GridLayout(6,7));
		    for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}
    		for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}}
		    
		    if(n==2)//Feb
		    {one=26;
		    String s ="February";month = new JLabel("Month Selected: "+s);p4.add(month);
		    JLabel e1 = new JLabel("");p5.add(e1);
    		for(i=1;i<29;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}
    		for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}}
		    
		    else if(n==3)//Mar
		    {one=27;
		    	String s ="March";month = new JLabel("Month Selected: "+s);p4.add(month);
    		JLabel temp1 = new JLabel("");p5.add(temp1);
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==4)//April
		    {one=28;
		    	String s ="April";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<4;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==5)//May
		    {one=29;
		    	String s ="May";month = new JLabel("Month Selected: "+s);p4.add(month);
		    p5.setLayout(new GridLayout(6,7));
		    for(i=0;i<6;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}
    		for(i=0;i<3;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}}
		    
		    else if(n==6)//June
		    {one=30;
		    	String s ="June";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<2;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==7)//July
		    {one=31;
		    	String s ="July";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<4;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==8)//August
		    {one=32;
		    	String s ="August";month = new JLabel("Month Selected: "+s);p4.add(month);
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==9)//Sept
		    {one=33;
		    	String s ="September";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<3;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==10)//Oct
		    {one=34;
		    	String s ="October";month = new JLabel("Month Selected: "+s);p4.add(month);
		    p5.setLayout(new GridLayout(6,7));
		    for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}
    		for(i=0;i<5;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}}
		    
		    else if(n==11)//Nov
		    {one=35;
		    	String s ="November";month = new JLabel("Month Selected: "+s);p4.add(month);
		    JLabel e1 = new JLabel("");p5.add(e1);
    		for(i=1;i<31;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}
		    
		    else if(n==12)//Dec
		    {one=36;
		    	String s ="December";month = new JLabel("Month Selected: "+s);p4.add(month);
		    for(i=0;i<3;i++)
    		{JLabel temp1 = new JLabel("");p5.add(temp1);}
    		for(i=1;i<32;i++)
    		{JButton temp = new JButton(""+i);temp.addActionListener(new blisten());p5.add(temp);}}}
    		
    		smain.add(p5,"Center");    
    		smain.add(p4,"South");
    		smain.add(p2,"North");
    		smain.add(p3,"West");
    		main.add(p1,"North");
    		main.add(smain,"Center");
    		newDates.add(main);
	
           	newDates.setVisible(true);
			}
			}
		}
	
	public class blisten implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		 popUpWin = new JFrame();
    
   	       popUpWin.setTitle("Java App Book");
           popUpWin.setSize(400,400);
           popUpWin.setLayout(new BorderLayout());
           
           popUpEvent=new JLabel("Day Selected : ");
           popUpApp=new JLabel("Appointment : ");
           popUp1=new JPanel();
           popUp2=new JPanel();
           popUp3=new JPanel();
           CONFIRM=new JButton("CONFIRM");
           CONFIRM.addActionListener(new ConfirmHandler());
           CLEAR=new JButton("CLEAR");
           CLEAR.addActionListener(new ClearHandler());
           subject=new JTextField(10);
           location=new JTextField(10);
           nub=new JLabel("");
           lblLoc=new JLabel("Location: ");
           lblSub=new JLabel("Subject: ");
           lblTime= new JLabel("Time : ");
           popUptf2=new JTextField(15);
           popUp1.setLayout(new GridLayout(2,1));
           popUp3.setLayout(new GridLayout(5,2));
           popUp2.setLayout(new FlowLayout());
           SpinnerModel timehour = new SpinnerListModel(strHour);
           SpinnerModel timemin = new SpinnerListModel(strMin);
 
             sp1= new JSpinner(timehour);
             sp2= new JSpinner(timemin);
           popUp1.add(popUpEvent);
          
           
           popUp3.add(lblSub);
           popUp3.add(subject);
           popUp3.add(lblLoc);
           popUp3.add(location);
           popUp3.add(popUpApp);
           popUp3.add(popUptf2);
           popUp3.add(lblTime);
           popUp3.add(sp1);
           popUp3.add(nub);
           popUp3.add(sp2);
           popUp2.add(CONFIRM);
           popUp2.add(CLEAR);
           
           popUpWin.add(popUp1,BorderLayout.NORTH);
           popUpWin.add(popUp3,BorderLayout.CENTER);
           popUpWin.add(popUp2,BorderLayout.SOUTH);
           
     
         a = e.getActionCommand();
         int no=Integer.parseInt(a);
    		
        popUptf2.setText(""+app[no]);
          popUpEvent.setText("Day Selected : "+a);
         popUpWin.pack();
         popUpWin.setVisible(true);
         
       
         
         for(int i=0;i<60;i++)
	{   
		String mins=i+" mins";
		strMin[i]=mins;
	}

	     for (int h=0;h<24;h++){
	     	String hours=h+" hours";
	     	strHour[h]=hours;
	     }
	
	     
	     if(one==1){no=no;
    			}
    		if(one==2){
    			no=no+31;
    			}
    		if(one==3){
    			no=no+60;
    			}
    		if(one==4){
    			no=no+91;
    			}
    		if(one==5){
    			no=no+121;
    			}
    		if(one==6){
    			no=no+152;
    			}
    		if(one==7){
    			no=no+182;
    			}
    		if(one==8){
    			no=no+213;
    			}
    		if(one==9){
    			no=no+243;
    			}
    		if(one==10){
    			no=no+274;
    			}
    		if(one==11){
    			no=no+304;
    			}
    		if(one==12){
    			no=no+335;
    			}
    		if(one==13){
    			no=no+366;
    		}
    		if(one==14){
    			no=no+397;
    		}	
    		if(one==15){
    			no=no+425;
    		}
    		if(one==16){
    			no=no+456;
    		}												
    		if(one==17){
    			no=no+486;
    		}	
    		if(one==18){
    			no=no+517;
    		}
    		if(one==19){
    			no=no+547;
    		}
    		if(one==20){
    			no=no+578;
    		}
    		if(one==21){
    			no=no+608;
    		}
    		if(one==22){
    			no=no+649;
    		}
    		if(one==23){
    			no=no+679;
    		}
    		if(one==24){
    			no=no+700;
    		}
    		if(one==25){
    			no=no+730;
    		}
    		if(one==26){
    			no=no+761;
    		}
    	    if(one==27){
    			no=no+791;
    		}
    		if(one==28){
    			no=no+822;
    		}
    		if(one==29){
    			no=no+852;
    		}
    		if(one==30){
    			no=no+883;
    		}
    		if(one==31){
    			no=no+913;
    		}
    		if(one==32){
    			no=no+944;
    		}
    		if(one==33){
    			no=no+974;
    		}
    		if(one==34){
    			no=no+1005;
    		}
    		if(one==35){
    			no=no+1035;
    		}
    		if(one==36){
    			no=no+1066;
    		}
    		if(one==37){
    			no=no+1096;
    		}
	    
	   		
	   		 if(app[no]==null){
        popUptf2.setText("");
    }
      else{  popUptf2.setText(""+app[no]);}
    if(sub[no]==null){
    	subject.setText("");
    }    
      else{  subject.setText(""+sub[no]);}
    if(loc[no]==null){
    	location.setText("");
    }
     else{  location.setText(""+loc[no]);}

	   sp1.setValue(saveHour[no]);
	   sp2.setValue(saveMin[no]);
	  
		}
	}
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        DateBook db = new DateBook();
    }
    public String getDate(Locale currentLocale)//For auto-update of dates.
    {
    	Date today = new Date();
    	DateFormat dateFormatter;
    	dateFormatter = DateFormat.getDateInstance(DateFormat.FULL, currentLocale);
    	String dateOut = dateFormatter.format(today);
    	return dateOut;
    }

    class ConfirmHandler implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		String b=popUptf2.getText();
    	 
    	   
    		int no=Integer.parseInt(a);
    
    		if(one==1){no=no;
    			}
    		if(one==2){
    			no=no+31;
    			}
    		if(one==3){
    			no=no+60;
    			}
    		if(one==4){
    			no=no+91;
    			}
    		if(one==5){
    			no=no+121;
    			}
    		if(one==6){
    			no=no+152;
    			}
    		if(one==7){
    			no=no+182;
    			}
    		if(one==8){
    			no=no+213;
    			}
    		if(one==9){
    			no=no+243;
    			}
    		if(one==10){
    			no=no+274;
    			}
    		if(one==11){
    			no=no+304;
    			}
    		if(one==12){
    			no=no+335;
    			}
    		if(one==13){
    			no=no+366;
    		}
    		if(one==14){
    			no=no+397;
    		}	
    		if(one==15){
    			no=no+425;
    		}
    		if(one==16){
    			no=no+456;
    		}												
    		if(one==17){
    			no=no+486;
    		}	
    		if(one==18){
    			no=no+517;
    		}
    		if(one==19){
    			no=no+547;
    		}
    		if(one==20){
    			no=no+578;
    		}
    		if(one==21){
    			no=no+608;
    		}
    		if(one==22){
    			no=no+649;
    		}
    		if(one==23){
    			no=no+679;
    		}
    		if(one==24){
    			no=no+700;
    		}
    		if(one==25){
    			no=no+730;
    		}
    		if(one==26){
    			no=no+761;
    		}
    	    if(one==27){
    			no=no+791;
    		}
    		if(one==28){
    			no=no+822;
    		}
    		if(one==29){
    			no=no+852;
    		}
    		if(one==30){
    			no=no+883;
    		}
    		if(one==31){
    			no=no+913;
    		}
    		if(one==32){
    			no=no+944;
    		}
    		if(one==33){
    			no=no+974;
    		}
    		if(one==34){
    			no=no+1005;
    		}
    		if(one==35){
    			no=no+1035;
    		}
    		if(one==36){
    			no=no+1066;
    		}
    		if(one==37){
    			no=no+1096;
    		}
    		
    		
    		app[no]=b;	
    		String locatea=location.getText();
    		loc[no]=locatea;
    		String subjecta=subject.getText();	
    		sub[no]=subjecta;
    		String n=(String)sp1.getValue();
    		for(int check=0;check<24;check++){
    			if(n==strHour[check])
    			{hr=check;}
    		}
    	saveHour[no]=strHour[hr];
    	String n2=(String)sp2.getValue();
    		for(int check1=0;check1<60;check1++){
    			if(n2==strMin[check1])
    			{mn=check1;}
    		}
    	saveMin[no]=strMin[mn];
    	
    String strMsg="Subject: "+sub[no]+"\nTime of Appointment: "+saveHour[no]+" and "+saveMin[no]+"\nLocation is "+loc[no]+"\nAppointment Details: "+app[no];
    	
    	
    	
    	JOptionPane.showMessageDialog(null,strMsg,"Appointments for the day",JOptionPane.PLAIN_MESSAGE);
    	}
    	
    }
    class ClearHandler implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		popUptf2.setText("");
        subject.setText("");
        location.setText("");
             
    		int no=Integer.parseInt(a);
    		
    		if(one==1){no=no;
    			}
    		if(one==2){
    			no=no+31;
    			}
    		if(one==3){
    			no=no+60;
    			}
    		if(one==4){
    			no=no+91;
    			}
    		if(one==5){
    			no=no+121;
    			}
    		if(one==6){
    			no=no+152;
    			}
    		if(one==7){
    			no=no+182;
    			}
    		if(one==8){
    			no=no+213;
    			}
    		if(one==9){
    			no=no+243;
    			}
    		if(one==10){
    			no=no+274;
    			}
    		if(one==11){
    			no=no+304;
    			}
    		if(one==12){
    			no=no+335;
    			}
    		if(one==13){
    			no=no+366;
    		}
    		if(one==14){
    			no=no+397;
    		}	
    		if(one==15){
    			no=no+425;
    		}
    		if(one==16){
    			no=no+456;
    		}												
    		if(one==17){
    			no=no+486;
    		}	
    		if(one==18){
    			no=no+517;
    		}
    		if(one==19){
    			no=no+547;
    		}
    		if(one==20){
    			no=no+578;
    		}
    		if(one==21){
    			no=no+608;
    		}
    		if(one==22){
    			no=no+649;
    		}
    		if(one==23){
    			no=no+679;
    		}
    		if(one==24){
    			no=no+700;
    		}
    		if(one==25){
    			no=no+730;
    		}
    		if(one==26){
    			no=no+761;
    		}
    	    if(one==27){
    			no=no+791;
    		}
    		if(one==28){
    			no=no+822;
    		}
    		if(one==29){
    			no=no+852;
    		}
    		if(one==30){
    			no=no+883;
    		}
    		if(one==31){
    			no=no+913;
    		}
    		if(one==32){
    			no=no+944;
    		}
    		if(one==33){
    			no=no+974;
    		}
    		if(one==34){
    			no=no+1005;
    		}
    		if(one==35){
    			no=no+1035;
    		}
    		if(one==36){
    			no=no+1066;
    		}
    		if(one==37){
    			no=no+1096;
    		}
    		
    		app[no]="";
    		loc[no]="";
    		sub[no]="";
    		saveHour[no]=strHour[0];
    		saveMin[no]=strMin[0];
    		System.out.println(saveHour[no]);
    	sp1.setValue(strHour[0]);
        sp2.setValue(strMin[0]);
    	}
    }
}