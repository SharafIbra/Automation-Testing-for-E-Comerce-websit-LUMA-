package utilsFiles;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordFailure {

    private WebDriver driver;

    public RecordFailure(WebDriver driver) {
        this.driver = driver;
    }

    public void recordFailure(ITestResult result, String directoryPath) {
        // Create a timestamp for the screenshot file and log entry
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Create a file name for the screenshot
        String fileName = result.getName() + "_" + timestamp + ".png";

        // Create the full path for the screenshot
        File destFile = new File(directoryPath + File.separator + fileName);

        // Capture the screenshot and save it to the specified path
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile, destFile);
            System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }

        // Create a log entry for the failure
        String logMessage = "Test failed: " + result.getName() + " at " + timestamp + "\n"
                + "Reason: " + result.getThrowable().getMessage() + "\n"
                + "Screenshot: " + destFile.getAbsolutePath() + "\n";

        // Save the log entry to a log file
        File logFile = new File(directoryPath + File.separator + "test-failure-log.txt");
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(logMessage);
            writer.write("-------------------------------------------------\n");
            System.out.println("Log saved to: " + logFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save log: " + e.getMessage());
        }
    }

    public void takeScreenshot(ITestResult result , String directoryPath) {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        // Define base screenshot directory

        // Determine the subdirectory based on the test result status
        String subDirectory = result.isSuccess() ? "PassedTests\\" : "FailedTests\\";

        // Construct the full path to the directory where the screenshot will be saved
        String screenshotDirectory = directoryPath + subDirectory;
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = result.getMethod().getMethodName() + "_" +timestamp + ".png";
        File destinationPath = new File(screenshotDirectory + screenshotName);

        try {
            // Ensure the directory exists
            destinationPath.getParentFile().mkdirs();

            // Move the screenshot file to the destination
            Files.move(screenshot.toPath().toFile(), destinationPath.toPath().toFile());
            System.out.println("Screenshot saved to: " + destinationPath.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
