package com.pearson.eselenium.ls.common.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.drivers.UIAlert;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This Page contains all the methods for the UserProfilePage
 * 
 * @author krishna.kulkarni
 * @param uiDriver
 */
public class UserProfilePage extends BasePageObject {

	/* Elements */
	private UIElement drpUserLanguage = createElement(UIType.Css,
			"#localeDropdown");
	private UIElement clicksavechanges = createElement(UIType.Css,
			"#saveChanges");
	private UIElement drptimeZone = createElement(UIType.ID, "timezoneDropdown");
	
	/* Variables */
	private String alertMessage;
	private boolean alertPresent = false;
	private boolean status = false;

	/* Constructor */
	public UserProfilePage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ##  User Profile Page  ##");
	}

	/**
	 * Method helps to select the language drop down
	 * 
	 * @author krishna.kulkarni
	 * @param String
	 *            languageName
	 * @return UserProfilePage
	 * @throws Exception
	 */
	public UserProfilePage selectLanguageDropDown(String languageName)
			throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			Select dropList = new Select(drpUserLanguage);
			List<WebElement> optionsList = dropList.getOptions();
			if (optionsList.size() > 0) {
				for (int i = 0; i < optionsList.size(); i++) {
					if (optionsList.get(i).getText()
							.equalsIgnoreCase(languageName)) {
						dropList.selectByVisibleText(languageName);
					}
				}
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO SELECT ON THE LANGUAGE \n METHOD :selectLanguageDropDown");
		}
		return new UserProfilePage(uiDriver);
	}

	/**
	 * Method helps to click on Save Changes
	 * 
	 * @author Amit.Deshmukh s
	 * @return UserProfilePage
	 * @throws Exception
	 */
	public UserProfilePage clickSaveChanges() throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(clicksavechanges, waitTime);
			clicksavechanges.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED SAVE CHANGES BUTTON");
			alertMessage = uiDriver.getUIAlert().getAlertMessage();
			if (UIAlert.NO_ALERT_FOUND != null) {
				alertPresent = true;
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK SAVE CHANGES \n METHOD :clickSaveChanges"
							+ e.getLocalizedMessage());
		}

		return this;

	}

	/**
	 * method will select the time zone from the drop down
	 * 
	 * @author Praveen.Maled
	 * @param String
	 *            - timeZone
	 * @return UserProfilePage
	 * @throws Exception
	 */
	public UserProfilePage selectTimeZoneDropDown(String timeZone)
			throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			drptimeZone.isDisplayedAfterWaiting(waitTime);
			Select dropList = new Select(drptimeZone);
			dropList.selectByVisibleText(timeZone);
			logInstruction("LOG INSTRUCTION: SELECTED TIMEZONE IN USER SETTING");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO SELECT ON THE TIMEZONE \n METHOD :selectTimeZoneDropDown"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method will check whether alert is present or not
	 * 
	 * @return Boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isAlertPresent() throws Exception {
		return alertPresent;
	}

	/**
	 * Method helps to get alert
	 * 
	 * @author soundarya
	 * @return String
	 * @throws Exception
	 */
	public String getAlertMessage() throws Exception {
		return alertMessage;
	}

	/**
	 * Method helps to hadle alert
	 * 
	 * @author soundarya
	 * @Param String
	 * @return void
	 * @throws Exception
	 */
	public void handleAlert(String choice) throws Exception {
		try {
			if (choice == "accept") {
				uiDriver.getUIAlert().acceptAlertIfPresent();
				logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
			} else if (choice == "dismiss") {
				uiDriver.getUIAlert().dismissAlertIfPresent();
				logInstruction("LOG INSTRUCTION: DISMISSED ALERT");
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO HADLE \n METHOD :handleAlert"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to Verify whether Time Zone Handling is present
	 * 
	 * @category Milestone2
	 * @author Raghav
	 * @return Boolean
	 * @throws Exception
	 * 
	 */

	public boolean isTimeZoneHandlingPresent() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:VERIFYING THE TIME ZONE");
			frameSwitch.switchToFrameContent();
			return drptimeZone.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFIYING THE 'time' ZONE HANDLING"
					+ "\n METHOD:isTimeZoneHandlingPresent \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to Verify the Locale Selected is English
	 * 
	 * @category Milestone2
	 * @author Raghav
	 * @return Boolean
	 * @throws Exception
	 * 
	 */
	public boolean isLocaleSelected() throws Exception {
		status = false;
		try {
			logInstruction("LOG INSTRUCTION:VERIFYING THE LOCALE");
			frameSwitch.switchToFrameContent();
			drpUserLanguage.selectByVisibleText("English (United States)");
			status = true;
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFIYING THE 'locale'"
					+ "\n METHOD:isLocaleSelected \n" + e.getLocalizedMessage());
		}
		return status;
	}

	/**
	 * This is Service level method to Modify User Profile Page settings
	 * 
	 * @author Kapil
	 * @param String language
	 * @param String timeZone
	 * @return UserProfilePage
	 * @throws Exception
	 */
	public UserProfilePage changeUserSettings(String strLanguage, String... strTimeZone) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			Select languageDropdownList = new Select(drpUserLanguage);
			List<WebElement> optionsList = languageDropdownList.getOptions();
			if (optionsList.size() > 0) {
				for (int i = 0; i < optionsList.size(); i++) {
					if (optionsList.get(i).getText()
							.equalsIgnoreCase(strLanguage)) {
						languageDropdownList.selectByVisibleText(strLanguage);
					}
				}
			}
			logInstruction("LOG INSTRUCTION: SELECTED LANGUAGE IN USER SETTING");
			if(strTimeZone.length>0){
				drptimeZone.isDisplayedAfterWaiting(waitTime);
				Select timezoneDropdownList = new Select(drptimeZone);
				timezoneDropdownList.selectByVisibleText(strTimeZone[0]);
				logInstruction("LOG INSTRUCTION: SELECTED TIMEZONE IN USER SETTING");
			}
			uiDriver.waitToBeDisplayed(clicksavechanges, waitTime);
			clicksavechanges.clickNoWait();
			logInstruction("LOG INSTRUCTION: CLICKED SAVE CHANGES BUTTON");
			uiDriver.getUIAlert().acceptAlertIfPresent();
			logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
		} catch (Exception e) {
			throw new Exception("ISSUE IN UPDATING THE 'User Settings'"
					+ "\n METHOD: changeUserSettings \n" + e.getLocalizedMessage());
		}
		return this;
	}
}
