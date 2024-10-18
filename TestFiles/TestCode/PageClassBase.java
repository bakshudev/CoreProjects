public abstract class PageClassBase extends POMBase {

	public PageClassBase(WebDriver driver, TestReport testReport)
	{
		super(driver,testReport);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getPageSource()
	{
		return driver.getPageSource();
	}
	
	public String getWindowHandle()
	{
		return driver.getWindowHandle();
	}
}
