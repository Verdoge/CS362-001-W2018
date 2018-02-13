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
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import java.util.EmptyStackException;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	       TimeTable timeTable=new TimeTable();

	        GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
	        GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
         // create another appointment
         int startHour=16;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=8;
		 int startYear=2018;
		 String title="Visit";
		 String description="Visiting my parents!";
         Appt appt = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                description);
         LinkedList<Appt> listAppts = new LinkedList<Appt>();
        int[] recurDaysArr=new int [7];
        appt.setRecurrence( recurDaysArr, 4, 1, 3);
		assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
		listAppts.add(appt);
		assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());

        listAppts.add(appt);

        assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
        assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
        assertTrue(appt.isRecurring());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour=16;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=8;
		 int startYear=2018;
		 String title="Visit";
		 String description="Visiting my parents!";
         Appt appt = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                description);
        int[] recurDaysArr=null;
        appt.setRecurrence( recurDaysArr, 0, 0, 0);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
        listAppts.add(appt);
        TimeTable timeTable=new TimeTable();
        GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
        GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
        assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
	 }
	 @Test
	  public void test03()  throws Throwable  {
		 int startHour=16;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=8;
		 int startYear=2018;
		 String title="Visit";
		 String description="Visiting my parents!";
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
               description);
       int[] recurDaysArr=null;
       appt.setRecurrence( recurDaysArr, 0, 0, 0);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
       listAppts.add(appt);
       TimeTable timeTable=new TimeTable();
       GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
       GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
       assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
       assertEquals("[	 --- 8/15/2018 --- \n" +
       		" --- -------- Appointments ------------ --- \n" +
       		"	8/15/2018 at 4:30pm ,Visit, Visiting my parents!\n" +
       		" \n" +
       		"]", timeTable.getApptRange(listAppts, today, tomorrow).toString());
	 }

	 @Test
	  public void test04()  throws Throwable  {
        int startHour=16;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=8;
		 int startYear=2018;
		 String title="Visit";
		 String description="Visiting my parents!";
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
               description);
       int[] recurDaysArr={2,3,4};
       appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
       listAppts.add(appt);
		 Appt appt2 = new Appt(20,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	     int[] recurDaysArr2={1,3,4};
	     appt2.setRecurrence( recurDaysArr2, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 listAppts.add(appt2);
		 Appt appt3 = new Appt(14,
		          startMinute ,
		          startDay ,
		          1 ,
		          startYear ,
		          title,
		         description);
		 appt3.setRecurrence( recurDaysArr2, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 listAppts.add(appt3);
       TimeTable timeTable=new TimeTable();
       GregorianCalendar today = new GregorianCalendar(2018, 1, 15);
       GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
       assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
	 }

	 @Test
	  public void test05()  throws Throwable  {
		 int startHour=16;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=8;
		 int startYear=2018;
		 String title="Visit";
		 String description="Visiting my parents!";
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
               description);
       int[] recurDaysArr={2,3,4};
       appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
       listAppts.add(appt);
       TimeTable timeTable=new TimeTable();
       GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
       GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
		 int pv[] = {1, 0};
	 }

//add more unit tests as you needed
}
