package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void test01()  throws Throwable  {

		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

		//constructor without values
		CalDay calday = new CalDay();
		assertFalse(calday.isValid());

		//constructor with values
		calday = new CalDay(today);
		assertTrue(calday.isValid());


	}
	@Test
	public void test02()  throws Throwable  {

		//initialize values
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday = new CalDay(today);


		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		calday.addAppt(appt1);
		assertEquals(1, calday.getSizeAppts());

		startYear = 2019;
		startHour = 10;
		Appt appt2 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		calday.addAppt(appt2);
		assertEquals(2, calday.getSizeAppts());

		startYear = 2019;
		startHour = 5;
		Appt appt3 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		calday.addAppt(appt3);
		assertEquals(3, calday.getSizeAppts());
	}

	@Test
	public void test03() throws Throwable {
		//initialize values
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday = new CalDay(today);


		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);


		calday.addAppt(appt1);
		String string = calday.toString();
		assertNotEquals(null, calday.toString());

		calday.addAppt(new Appt(startHour,
				80 ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description));
		assertEquals(string, calday.toString());
	}

	@Test
	public void test04() throws Throwable{
		//initialize values
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday = new CalDay(today);


		int startHour=26;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);


		calday.addAppt(appt1);
		assertFalse(appt1.getValid());


	}

	@Test
	public void test05() throws Throwable{
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday = new CalDay(today);

		int startHour=26;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		calday.addAppt(appt1);

		LinkedList<Appt> list = new LinkedList<Appt>();
		list.add(appt1);
		assertNotEquals(list.iterator(), calday.iterator());

		calday = new CalDay();
		assertEquals(null, calday.iterator());
		assertEquals("", calday.toString());
	}

	@Test
	public void test06() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH);
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday = new CalDay(today);

		assertEquals(thisYear, calday.getYear());
		assertEquals(thisMonth, calday.getMonth());
		assertEquals(thisDay, calday.getDay());
	}

	//Tests for mutations
	@Test
	public void addApptTest() throws Throwable {
		//initialize values
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday = new CalDay(today);

		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		Appt appt2 = new Appt(startHour+1,
				startMinute+1 ,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		Appt appt3 = new Appt(startHour+2,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		Appt appt4 = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);

		calday.addAppt(appt2);
		calday.addAppt(appt3);
		calday.addAppt(appt1);
		calday.addAppt(appt2);
		calday.addAppt(appt4);

		assertEquals(appt1, calday.getAppts().get(0));
		assertEquals(appt4, calday.getAppts().get(1));
		assertEquals(appt2, calday.getAppts().get(2));
		assertEquals(appt2, calday.getAppts().get(3));
		assertEquals(appt3, calday.getAppts().get(4));
	}

	@Test
	public void iteratorTest() throws Throwable {
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday1 = new CalDay(today);

		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		calday1.addAppt(appt1);

		assertEquals(calday1.iterator().next(), calday1.iterator().next());
		CalDay calday2 = new CalDay();
		assertEquals(null, calday2.iterator());



	}
}
