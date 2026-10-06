package com.vcb.common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory

public class BaseKeyword {

	public static FailureHandling defaultFailureHandling = RunConfiguration.getDefaultFailureHandling()
	/**
	 * Exception Handling
	 * */
	@Keyword
	public static void handleError(String message, FailureHandling flowControl){
		if(!flowControl)
			throw new StepFailedException(message)

		switch(flowControl){
			case FailureHandling.STOP_ON_FAILURE:
				WebUIKeyword.takeScreenshot()
				KeywordUtil.markFailed(message)
				throw new Exception(message)
				break
			case FailureHandling.CONTINUE_ON_FAILURE:
				KeywordUtil.markFailed(message)
				break
			case FailureHandling.OPTIONAL:
				KeywordUtil.markWarning(message)
				break
			default:
				KeywordUtil.markFailedAndStop(message)
				break
		}
	}

	@Keyword
	public static void handleError(Exception ex, FailureHandling flowControl = defaultFailureHandling){
		handleError(ex.message, flowControl)
	}

	/**
	 * Log Info
	 * */
	@Keyword
	public static void info(message){
		KeywordUtil.logInfo(message)
	}

	@Keyword
	public static void markPassed(message){
		KeywordUtil.markPassed(message)
	}

	@Keyword
	public static boolean runFromTestCloud() {
		Map<String, Object> references = RunConfiguration.getDriverPreferencesProperties()

		String driverName = references.keySet()[0]
		Map refInfo = references.getAt(driverName)
		Map options = refInfo.getAt("katalon:option") ?: refInfo.getAt("katalon:options")
		boolean runFromTestCloud = options?.getAt("runFromTestCloud")
		boolean runKRE = options?.getAt("organizationId")
		return runFromTestCloud || runKRE
	}

	/**
	 * Connects to an already running Chrome instance using the Chrome DevTools Protocol (CDP).
	 *
	 * This method allows interaction with a running Chrome browser instance by specifying its remote debugging port.
	 * It uses Katalon's ChromeDriver to establish the connection and updates Katalon's WebDriver instance to use the new driver.
	 *
	 * @param port The port of the running Chrome instance (default: 9222).
	 * @return A WebDriver instance connected to the running Chrome instance.
	 */
	@Keyword
	public static WebDriver connectToRunningClient(int port = 9222) {
		// Get path to Katalon's chromedriver
		String chromeDriverPath = DriverFactory.getChromeDriverPath()

		// Set up the chromedriver path
		System.setProperty("webdriver.chrome.driver", chromeDriverPath)

		// Set the host and port of the running chrome instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*")
		options.setExperimentalOption("debuggerAddress", "localhost:$port")

		// Create the chromedriver
		WebDriver driver = new ChromeDriver(options)

		// Change Katalon's default chromedriver to this one
		DriverFactory.changeWebDriver(driver)

		return driver
	}

	@Keyword
	public static void setFailureHandling(String flowControl){
		switch(flowControl) {
			case 'STOP':
				this.defaultFailureHandling = FailureHandling.STOP_ON_FAILURE
				break
			case 'CONTINUE':
				this.defaultFailureHandling = FailureHandling.CONTINUE_ON_FAILURE
				break
			case 'OPTION':
				this.defaultFailureHandling = FailureHandling.OPTIONAL
				break
			default:
				this.defaultFailureHandling = RunConfiguration.getDefaultFailureHandling()
				break
		}
	}
}

public enum FlowControlEnum{
	STOP, CONTINUE, OPTION
}

public enum PlatformEnum{
	WEBSITE, MOBILE
}