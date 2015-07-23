/*
import com.relevantcodes.extentreports.*;

public class reports {
    // *REQUIRED
    // put this in every class 
    // * Main.class will become TheClassName.class
    static final ExtentReports extent = ExtentReports.get(reports.class); 

    public static void main(String[] args) {
        extent.init("C:\\Extent.html", true);

        // *REQUIRED
        // startTest( testName )
        //    creates a toggle for the given test, adds all log events under it    
        extent.startTest("Main");

        // log(logStatus, stepName, details)
        extent.log(LogStatus.PASS, "StepName", "PASS Details"); 

        // log(LogStatus, details)
        extent.log(LogStatus.INFO, "This step shows usage of log(logStatus, details)");

        // report with snapshot
        // log(logStatus, stepName, details, screenCapturePath)
        extent.log(LogStatus.INFO, "Image", "Image example:", "C:\\img.png");

        // only report a snapshot, without status
        extent.attachScreenshot("pathtoImg.png", "This step attaches a screenshot without status.");

        // end test
        extent.endTest();
    }
}
*/