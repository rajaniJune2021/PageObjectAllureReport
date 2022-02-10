package commonUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerUtility implements IRetryAnalyzer {

    int maximumWRetryLimit =5;
    int count=0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<maximumWRetryLimit){
            count++;
            return true;
        }
        return false;
    }
}
