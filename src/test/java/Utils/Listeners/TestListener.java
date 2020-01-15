package Utils.Listeners;

import Tests.BaseTest;
import Utils.Log;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info("Test Method Success: "+geTestMethodName(iTestResult));
        iTestResult.getMethod().getMethodName();

        saveTestRes(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.error(saveTextLog("Test Method Failed: "+geTestMethodName(iTestResult)));
        saveTestRes(iTestResult);
        Throwable throwable = iTestResult.getThrowable();
        if (throwable != null){ Log.error(saveTextLog(throwable.toString())); }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.warn(saveTextLog("Test Method: "+geTestMethodName(iTestResult)+" Skipped"));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.warn(saveTextLog("Test Method Failed but it is in defined success ratio: "+geTestMethodName(iTestResult)));
        saveTestRes(iTestResult);
        //Save log on allure
        Throwable throwable = iTestResult.getThrowable();
        if (throwable != null){
            Log.error(saveTextLog(geTestMethodName(iTestResult)+" Failed \n"+throwable.toString()));
        }
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.startLog(iTestContext.getClass().getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
       Log.endLog(iTestContext.getClass().getName());
    }

    public void saveTestRes(ITestResult iTestResult){
        //Get the driver from BaseTest and assign to local webdriver variable
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        //Save Screenshoot
        if(driver instanceof WebDriver){
            Log.info("Screenshoot captured from test case: "+geTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }
    }

    @Attachment(value = "Page Screenshot", type = "png")
    public byte[] saveScreenshotPNG(WebDriver driver){
    return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    private static String geTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    private static void updateTestData(String testName,String testData){

    }
}
