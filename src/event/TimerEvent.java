package event;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;
import javafx.scene.text.Text;

public class TimerEvent extends TimerTask {
	private static Text timeText = (Text) Main.getFXMLNamespace().get("timeText");
	private static Timer timer;
	private static Calendar calendar;
	private static SimpleDateFormat dateFormat;

	@Override
	public void run() {
		calendar.add(Calendar.SECOND, 1);

		timeText.setText(dateFormat.format(calendar.getTime()));
	}
	
	public static void startTime() {
		timer = new Timer();
		calendar = new GregorianCalendar(0, 0, 0, 0, 0, 0);
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		timer.schedule(new TimerEvent(), 0, 1000);
	}
	
	public static void stopTime() {
		timer.cancel();
	}
}
