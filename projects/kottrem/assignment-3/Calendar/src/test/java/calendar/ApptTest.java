package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
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

		 //run the setters for this class
		 appt.setStartHour(23);
		 appt.setStartMinute(59);
		 appt.setStartDay(10);
		 appt.setStartMonth(02);
		 appt.setStartYear(1999);

		 //use null titles and descriptions
		 appt.setTitle(null);
		 appt.setDescription(null);

		 //assertions
		 assertEquals(23, appt.getStartHour());
		 assertEquals(59, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(02, appt.getStartMonth());
		 assertEquals(1999, appt.getStartYear());
		 assertEquals("", appt.getTitle());
		 assertEquals("", appt.getDescription());
	 }

	 @Test
	 public void test03() throws Throwable{
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

		 //Attempt invalid values
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 appt.setStartHour(10);
		 assertTrue(appt.getValid());

		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(65);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(20);
		 assertTrue(appt.getValid());

//		 appt.setStartDay(-10);
//		 assertFalse(appt.getValid());
//		 appt.setStartDay(31);
//		 assertFalse(appt.getValid());
//		 appt.setStartDay(10);
//		 assertTrue(appt.getValid());
	 }

	 @Test
	 public void test04() throws Throwable {
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

		 //set recurrence
		 appt.setRecurrence(null, 2, 5, 3);

		 //assertions
		 assertEquals(3, appt.getRecurNumber());
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(0,appt.getRecurDays().length);
		 assertEquals(5, appt.getRecurIncrement());
		 assertTrue(appt.isRecurring());
	 }

	 @Test
	 public void test05() throws Throwable {
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

		 assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());

		 appt.setStartMinute(80);
		 assertEquals(null, appt.toString());
	 }

	 //new stuff for mutation testing
	@Test
	 public void isValidTest() throws Throwable {
		int startHour=23;
		int startMinute=59;
		int startDay=31;
		int startMonth=12;
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

		assertTrue(appt.getValid());

		appt.setStartHour(00);
		appt.setStartMinute(00);
		appt.setStartMonth(01);
		appt.setStartDay(01);

		assertTrue(appt.getValid());
	 }

	 @Test
	public void settersTest() throws Throwable {
		 int startHour=23;
		 int startMinute=59;
		 int startDay=31;
		 int startMonth=12;
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

		 assertTrue(appt.getValid());

		 appt.setStartHour(30);
		 assertFalse(appt.getValid());
		 appt.setStartHour(10);

		 appt.setStartDay(40);
		 assertFalse(appt.getValid());
	 }

	 @Test
	public void representationAppTest() throws Throwable {
		 int startHour=11;
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

		 assertEquals("\t1/15/2018 at 11:30am ,Birthday Party, This is my birthday party.\n", appt.toString());

	 }

	 @Test
	public void compareToTest() throws Throwable {
		 int startHour=11;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		 //Construct a new Appointment object with the initial data
		 Appt appt1 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 Appt appt2 = new Appt(startHour,
				 startMinute+1 ,
				 startDay+1,
				 startMonth+1,
				 startYear+1,
				 title,
				 description);

		 Appt appt3 = new Appt(startHour,
				 startMinute+2,
				 startDay+2,
				 startMonth+2,
				 startYear+2,
				 title,
				 description);

		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 listAppts.add(appt1);
		 listAppts.add(appt2);

		 Collections.sort(listAppts);

		 assertEquals(appt1, listAppts.get(0));
		 assertEquals(appt2, listAppts.get(1));
		 assertEquals(appt2, listAppts.get(2));
		 assertEquals(appt3, listAppts.get(3));

		 appt2.setStartMinute(startMinute+2);
		 appt2.setStartHour(startHour+3);
		 appt2.setStartDay(startDay+4);
		 appt2.setStartMonth(startMonth+5);
		 appt2.setStartYear(startYear+6);
		 assertEquals(-20, appt1.compareTo(appt2));
		 assertEquals(20, appt2.compareTo(appt1));
	 }
}
