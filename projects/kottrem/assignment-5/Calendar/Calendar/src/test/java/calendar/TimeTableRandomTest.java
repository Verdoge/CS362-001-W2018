package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS = 100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random) {
		String[] methodArray = new String[]{"setTitle", "setRecurrence"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}

	/**
	 * Returns random hour, minute, day, month, year
	 */
	public static String RandomGetMethod(Random random) {
		String[] methodArray = new String[]{"startHour", "startMinute", "startDay", "startMonth", "startYear"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n]; // return the method name
	}

	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random) {
		int[] RecurArray = new int[]{Appt.RECUR_BY_WEEKLY, Appt.RECUR_BY_MONTHLY, Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n]; // return the value of the  appointments to recur
	}

	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random) {
		int[] RecurArray = new int[]{Appt.RECUR_NUMBER_FOREVER, Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n]; // return appointments to recur forever or Never recur
	}

	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */
	@Test
	public void radnomtest() throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		TimeTable Random = new TimeTable();
		GregorianCalendar RandomCal = new GregorianCalendar();
		CalDay calday = new CalDay(RandomCal);

		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {



				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);

				int startHour = ValuesGenerator.RandInt(random);
				int startMinute = ValuesGenerator.RandInt(random);
				int startDay = ValuesGenerator.RandInt(random);
				;
				int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear = ValuesGenerator.RandInt(random);
				String title = "Birthday Party";
				String description = "This is my birthday party.";

				int randomDay = ValuesGenerator.getRandomIntBetween(random,1, 31);
				int randomDayTwo = ValuesGenerator.getRandomIntBetween(random, 1, 31);

				int RandomMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int RandomMonthTwo = ValuesGenerator.getRandomIntBetween(random, 1, 11);

				int RandomYearTwo = ValuesGenerator.getRandomIntBetween(random, 2010, 2020);

				GregorianCalendar next = new GregorianCalendar(startYear, RandomMonth, randomDay);
				GregorianCalendar prev = new GregorianCalendar(RandomYearTwo, RandomMonthTwo, randomDayTwo);

				//Construct a new Appointment object
				Appt appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description);
				if(!appt.getValid())continue;
				Appt appt1 = new Appt(-1, 61, 52, 06, 2018, title, description);
				Appt appt2 = new Appt (startHour, startMinute, startDay, startMonth, startYear, title, description);

				LinkedList<Appt> appts = new LinkedList<Appt>();
				appts.add(appt);
				appts.add(appt1);
				appts.add(appt2);

				Random.getApptRange(appts, next, prev);

				Random.deleteAppt(appts, appt);
				Random.deleteAppt(appts, appt1);
				Random.deleteAppt(appts,appt2);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing...");
	}

	@Test
	public void randomtest01() throws Throwable { //Deleting null

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		TimeTable Random = new TimeTable();
		GregorianCalendar RandomCal = new GregorianCalendar();
		CalDay calday = new CalDay(RandomCal);

		System.out.println("Start testing...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				LinkedList<Appt> apptsNull = null;

				Random.deleteAppt(apptsNull, null);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}
		} catch (NullPointerException e) {

		}

		System.out.println("Done testing...");


	}

	@Test
	public void randomtest02() throws Throwable {



	}


}
