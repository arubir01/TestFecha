package es.unileon.prg.date;

import java.util.Random;

/*
*Clase Date para la practica7
*author
*
*/
public class Date {

	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throws DateException
		{
		this.year = year;
		this.setMonth(month);
		this.setDay(day);
		}
	
	
	public Date (Date today) throws DateException
	{ 
		 this.day = today.getDay();
		 this.month = today.getMonth();
		 this.year = today.getYear();
	}

public Date() throws DateException{
	 this.day = 1;
	 this.month = 1;
	 this.year = 2017;
	}


public int getYear() {
	
	return this.year;
}

public int getMonth() {
	
	return this.month;
}

public int getDay() {
	
	return this.day;
}


public String getMonthsLeft() throws DateException 
{
	Date aDay = new Date();
	StringBuilder string = new StringBuilder();
	
	for(int n = this.month + 1; n <= 12; n++)
	{
	try {
		aDay.setMonth(n);
	} catch (DateException e) {
	}
	string.append(aDay.getMonthName());
	string.append(" ");
}
return string.toString();	
}

public String getDaysLeftOfMonth() 
{
	try {
		Date aDay = new Date(day,month,year);
	} catch (DateException e) {
	}
	StringBuilder string2 = new StringBuilder();
	
	for(int m = this.day + 1; m <= this.daysOfMonth(); m++)
	{
	
	string2.append(m);
	string2.append("/");
	string2.append(month);
	string2.append("/");
	string2.append(year);
	string2.append(" ");
}
return string2.toString();
}

public int numRandomTriesEqualDate()
{	
	Random numero = new Random(System.currentTimeMillis());
	Date newDate;
	int attempts = 0;
	boolean ender = false;
	do
	{
		try
		{
			newDate = new Date(numero.nextInt(31),numero.nextInt(31),this.year);
			if (isSameDate(newDate) == false)
			{
			attempts++;
			}	
			else
			{
			ender = true;
			}
		}
		catch(DateException e)
		{
		attempts++;	
		}
	}	
while(ender == false);
return attempts;		
}

public String getMonthsSameDays() throws DateException 
{
	StringBuilder string3 = new StringBuilder();
	for(int m = 0; m <= 12; m++)
	{
	if(daysOfMonth() == this.daysOfMonth())
{
	string3.append(getMonthName());
	string3.append(" ");
}
}
	return string3.toString();
}

public int daysPast()
{
	int daysNumbers = this.day;
	
	for(int n = 0; n < this.month; n++)
{
	daysNumbers += this.daysOfMonth();
}	
	return daysNumbers;
}

public String dayOfWeek(int day)
{
	
	String week = " ";
	day = this.day + this.daysOfMonth();
	day = day % 7;
	switch(this.day)
{
	case 1:
		week = "Monday";
		break;
	case 2: 
		week = "Tuesday";
		break;
	case 3:
		week = "Wednesday";
		break;
	case 4: 
		week = "Thursday";
		break;
	case 5: 
		week = "Friday";
		break;
	case 6: 
		week = "Saturday";
		break;
	case 7: 
		week = "Sunday";
		break;

}
	return week;
}	
public boolean isSameDate(Date anotherDate)
{
	return ((isSameDay(anotherDate)) && (isSameMonth(anotherDate)) && (isSameYear(anotherDate)));
}

public boolean isSameDay(Date anotherDate)
{
	if (this.day == anotherDate.getDay())
			{
		return true;
			}
	else
	{
		return false;
	}
}

public boolean isSameMonth(Date anotherDate)
{
	if(this.month == anotherDate.getMonth())
	{
		return true;
			}
	else
	{
		return false;
	}
}

public boolean isSameYear(Date anotherDate)
{
	if(this.year == anotherDate.getYear())
	{
		return true;
			}
	else
	{
		return false;
	}
}


public int daysOfMonth()
	{
	int number = 0;
	switch (this.month) {
	case 1: //next
	case 3: //next
	case 5: //next
	case 7://next
	case 8: //next
	case 10: //next
	case 12: 
	number = 31;
	break;
	case 4: //next
	case 6: //next
	case 9: //next
	case 11: number = 30;
	break;
	case 2:
	number = 28;
	break;
	}
	return number;
	}

public String getMonthName()
	{
	String mes = "";
	switch (this.month) {
	case 1: mes = "January";
	break;
	case 2: mes = "February";
	break;
	case 3: mes = "March";
	break;
	case 4: mes = "April";
	break;
	case 5: mes = "May";
	break;
	case 6: mes = "June";
	break;
	case 7: mes = "July";
	break;
	case 8: mes = "August";
	break;
	case 9: mes = "September";
	break;
	case 10: mes = "October";
	break;
	case 11: mes = "November";
	break;
	case 12: mes = "December";
	break;
	}
	return mes;
	}

public String getSeasonName()
	{
	String estacion = "";
	switch (this.month) {
	case 12://next
	case 1: //next
	case 2: estacion = "Winter";
	break;
	case 3: //next
	case 4: //next
	case 5: estacion = "Spring";
	break;
	case 6: //next
	case 7: //next
	case 8: estacion = "Summer";
	break;
	case 9: //next 
	case 10: //next
	case 11: estacion = "Autumn";
	break;
	}
	return estacion;
	}

public void setMonth(int month) throws DateException
	{
	if (month < 1 || month > 12) {
			throw new DateException("Mes " + month + " no valido" +
					" Valores posibles entre 1 y" + getMonth() + ".");
		} 
		else{
			this.month = month;
		}
}

public void setDay(int day) throws DateException
	{
	if (day < 1 || day > this.daysOfMonth()) {
			throw new DateException("Dia " + day + " no valido" +
					" Valores posibles entre 1 y" + this.daysOfMonth() + ".");
		} else {
			this.day = day;
		}
}
public void setYear(int year) throws DateException {
	    if (year < 1 ) {
		throw new DateException("Año " + year + " no valido" +
				" Valores posibles solo positivos" + ".");
	} else {
		this.year = year;
	}	
	
}
public Date tomorrow()  {
	try {
		Date tomorrow = new Date(day,month,year);
		day = day + 1;
		if( day > this.daysOfMonth())
		{
		month = month + 1;
		day = 1;
		if(month > 12)
			{
			year = year + 1;
			month = 1;
			}
}
		} 
		catch (DateException e) 
			{
				}
			return tomorrow();
	
}
/*
*Boolean para is same tal
*return (this._month == month)
*/




/**
 *Clase setMonth, setea el atributo de clase_month
*@param month
*return void
*/
@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year ;
}






}
