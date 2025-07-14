	    @AfterMethod
	    public synchronized void extentReportAfterMethod(ITestResult result) throws IOException {
	        if (result.getStatus() != ITestResult.SUCCESS)
	        	// Fail the erTest when TestNG test result is not success
//	            erTest.fail(result.getThrowable(), 
//									MediaEntityBuilder
//									.createScreenCaptureFromPath(getTestFailureScreenshot(result))
//									.build());
	        	erTest.fail(result.getThrowable());	         
	        else
	        	// Pass the erTest when TestNG test result is success
	           erTest.pass("TEST PASSED");
	        
	        extentReport.flush();
	    }


//		public String getTestFailureScreenshot(ITestResult result) throws IOException
//		{
//			String testFailureScreenshotPath = null;
//			if (result.getStatus() == ITestResult.FAILURE)
//			{
//				// Gives path like TestFailureScreenshots\com.company.tests.HomePageTest.testPageTitle.png
//				testFailureScreenshotPath = "TestFailureScreenshots/" 
//														+ this.getClass().getName() // full class name - com.company.tests.HomePageTest
//														+ "." 
//														+ result.getName() // test method name - testPageTitle
//														+ ".png";
//				
//				// Files, Paths classes are provided by java.nio.file package
//				// Create the directory if doesn't exist
//				if(Files.notExists(Paths.get("TestFailureScreenshots")))
//				{
//					Files.createDirectory(Paths.get("TestFailureScreenshots"));
//				}
//				
//				// Delete the old file if exists
//				Files.deleteIfExists(Paths.get(testFailureScreenshotPath));
//				
//				// Create new test failure screenshot file
//				WebDriverUtil.getScreenshot(driver, testFailureScreenshotPath);
//			}
//			return testFailureScreenshotPath;
//		}

public static void getScreenshot(WebDriver driver, String filePath) throws IOException
	{
		File imgFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(imgFile.toPath(), Paths.get(filePath));
	}

