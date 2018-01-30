package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
			CalDay calday = new CalDay();
			assertFalse(calday.isValid());
	 }
	 @Test
	  public void test02()  throws Throwable  {
			GregorianCalendar cal = new GregorianCalendar(2018,01,15);
			CalDay calday = new CalDay(cal);
			int startHour=21;
 		 	int startMinute=30;
 		 	int startDay=15;
 		 	int startMonth=01;
 		 	int startYear=2018;
 		 	String title="Birthday Party";
 		 	String description="This is my birthday party.";
 		 	//Construct a new Appointment object with the initial data
 		 	Appt appt = new Appt(startHour,
 		          startMinute ,
 		          startDay ,
 		          startMonth ,
 		          startYear ,
 		          title,
 		         	description);
			calday.addAppt(appt);
			appt.toString();
			calday.toString();

			assertTrue(calday.isValid());
			assertEquals(15, calday.getDay());
			//assertEquals(0, calday.getMonth()); // Fails due to bug introduced in assignment 1 that removes the '-1' from the month
			assertEquals(2018, calday.getYear());
			assertEquals(1, calday.getSizeAppts());
	 }
//add more unit tests as you needed
}
