package generic;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class RESULT  implements ITestListener, IAutoConst  {
	public static int passCount=0,failCount=0;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		failCount++;
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Utility.writeResulttoXL(SUMMARY_PATH, "sheet1", passCount, failCount);
	}
}