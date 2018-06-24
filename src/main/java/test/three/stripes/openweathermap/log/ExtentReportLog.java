package test.three.stripes.openweathermap.log;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class ExtentReportLog {

    public static ExtentTest logger;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;

    public static void initReport(){

        htmlReporter = new ExtentHtmlReporter("./ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setDocumentTitle("Three Stripes challenge");
        htmlReporter.config().setReportName("API Open Weather Automation");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

    }

    public static void initTestMethod(Method method){
        logger = extent.createTest(method.getName());
    }

    public static void setStatus(ITestResult result){

        if(result.getStatus() == ITestResult.SUCCESS){
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - PASSED", ExtentColor.GREEN));
        }else if(result.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - FAILED", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ " - FAILED", ExtentColor.RED));
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - SKIPPED", ExtentColor.ORANGE));
        }
    }

    public static void flushReport(){
        extent.flush();
    }
}
