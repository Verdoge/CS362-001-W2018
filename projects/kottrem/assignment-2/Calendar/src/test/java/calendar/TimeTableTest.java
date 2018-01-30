package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
			LinkedList<Appt> listAppts = new LinkedList<Appt>();

			TimeTable timeTable=new TimeTable();
      LinkedList<CalDay> calDays = new LinkedList<CalDay>();

			GregorianCalendar today = new GregorianCalendar(2018,01,15);
			GregorianCalendar tomorrow = new GregorianCalendar(2018,01,16);

			calDays = new LinkedList<CalDay>();
			calDays = timeTable.getApptRange(listAppts, today, tomorrow);

			//everything above works

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
			assertEquals(null, timeTable.deleteAppt(listAppts, appt));
	 }
	 @Test
	  public void test02()  throws Throwable  {

	 }
//add more unit tests as you needed
}
