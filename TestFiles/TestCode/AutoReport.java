public class AutoReport {
	
	private static ExtentTest extentTest;
	
	public static void setExtentTest(ExtentTest extentTest) {
		AutoReport.extentTest = extentTest;
	}
	
	public static void log(Status status, String details)
	{
		extentTest.log(status, details);
		System.out.println(status.name() + ": " + details);
	}
	
	public static void log(Status status, Throwable t)
	{
		extentTest.log(status, t);
		System.out.println(status.name() + ": " + t);
	}
	
	public static void log(Status status, String details, Media media)
	{
		extentTest.log(status, details,media);
		System.out.println(status.name() + ": " + details);
		System.out.println(status.name() + " Media: " + media);
	}
	
	public static void log(Status status, Throwable t, Media media)
	{
		extentTest.log(status, t, media);
		System.out.println(status.name() + ": " + t);
		System.out.println(status.name() + " Media: " + media);
	}
	
	@Deprecated
	public void tempLog(Status status, String details){
		log(status,details);
	}
	
	@Deprecated
	public void tempLog(Status status, Throwable t){
		log(status,t);
	}
}
