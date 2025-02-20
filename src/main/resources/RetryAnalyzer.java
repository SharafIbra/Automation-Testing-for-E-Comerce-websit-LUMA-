package apiAutomationTest.Basics;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import java.util.Arrays;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 2; // Configurable retry count
    private static final long SLEEP_DURATION = 2 * 60 * 1000; // 2 minutes

    @Override
    public boolean retry(ITestResult result) {
        Throwable throwable = result.getThrowable();
        if (throwable != null && shouldRetry(throwable)) {
            if (retryCount < MAX_RETRY_COUNT) {
                retryCount++;
                return true;
            } else {
                try {
                    System.out.println("Retries exhausted. Sleeping for 2 minutes before final retry.");
                    Thread.sleep(SLEEP_DURATION);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                retryCount = 0; // Reset counter after sleep
                return true; // Final retry attempt after sleep
            }
        }
        return false;
    }

    private boolean shouldRetry(Throwable throwable) {
        return Arrays.asList(
                "java.net.ConnectException",
                "com.jcraft.jsch.JSchException",
                "java.sql.SQLRecoverableException",
                "java.net.NoRouteToHostException",
                "java.net.SocketException"
        ).stream().anyMatch(exception -> throwable.toString().contains(exception));
    }
}
