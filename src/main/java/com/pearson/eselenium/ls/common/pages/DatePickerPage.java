package com.pearson.eselenium.ls.common.pages;

import org.openqa.selenium.By;

import com.pearson.eselenium.ls.contentitems.textmultimedia.pages.TextMultimediaEditSchedulePage;
import com.pearson.eselenium.ls.coursetools.courseadmin.pages.CourseAdminCourseSchedulerPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of DatePicker page
 * Follow the below steps to navigate the page:
 * Login as prof
 * Click on the Course
 * Select Author Tab
 * Click CourseHome in navigation tree
 * Click AddAnnoncement link
 * Click Start/End Date Icon
 * @author Chaitali
 */
public class DatePickerPage extends BasePageObject {

    /* Elements */
    private UIElements dates = createElements(UIType.Css, "#Calendar1>tbody>tr>td>a");
    private UIElement nextMonth = createElement(
            UIType.Css,
            ".tablehead>tbody>tr>td:nth-of-type(3)>a");
    private UIElement monthYear = createElement(UIType.Css, ".tablehead>tbody>tr>td:nth-of-type(2)");
    private UIElement previousMonth = createElement(
            UIType.Css,
            ".tablehead>tbody>tr>td:nth-of-type(1)>a");
    private UIElement Cancel = createElement(UIType.Xpath, "//a[contains(.,'Cancel')]");
    private UIElement parentElement = null;
    
    /* Variables */
    String selectedMonthYear = "";
    private String dateCellStyle = null;

   /* Constructor */
    public DatePickerPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## Date Picker Page ##");
    }

    /**
     * Method helps to select date
     * 
     * @author Chaitali
     * @param String Date
     * @return DatePickerPage
     * @throws Exception
     */
    public DatePickerPage selectDate(String Date) throws Exception {
        try {
            frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(dates.getUIElementByText(Date), waitTime);
            dates.getUIElementByText(Date).clickNoWait();
            logInstruction("LOG INSTRUCTION: SELECTED GIVEN DATE");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT DATE \n METHOD :selectDate");
        }
        return this;
    }

    /**
     * Method helps to select Next Month
     * 
     * @author Chaitali
     * @return String
     * @throws Exception
     */
    public String selectNextMonth() throws Exception {
        try {
            frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(nextMonth, waitTime);
            nextMonth.clickNoWait();
            uiDriver.waitToBeDisplayed(monthYear, waitTime);
            selectedMonthYear = monthYear.getText();
            logInstruction("LOG INSTRUCTION: SELECTED NEXT MONTH");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT NEXT MONTH \n METHOD :selectNextMonth");
        }
        return selectedMonthYear;
    }

    /**
     * 
     * Method helps to select Previous Month
     * 
     * @author Chaitali
     * @return String selected month and year
     * @throws Exception
     */
    public String selectPrevMonth() throws Exception {
        try {
            frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(previousMonth, waitTime);
            previousMonth.clickNoWait();
            uiDriver.waitToBeDisplayed(monthYear, waitTime);
            selectedMonthYear = monthYear.getText();
            logInstruction("LOG INSTRUCTION: SELECTED PREVIOUS MONTH");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT THE PREVIOUS MONTH \n METHOD:selectPrevMonth");
        }
        return selectedMonthYear;
    }

    /**
     * Method helps to click cancel button
     * 
     * @author Chaitali
     * @return void
     * @throws Exception
     */
    public void clickCancelButton() throws Exception {
        try {
            // frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(Cancel, waitTime);
            Cancel.clickAndWait(waitTime);

            uiDriver.getUIWindowLocator().switchToFirstWindow();
            logInstruction("LOG INSTRUCTION: CLICKED ON CANCEL BUTTON");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON CANCEL BUTTON \n METHOD :clickCancelButton");
        }

    }

    /**
     * Method helps to get selected month and year
     * 
     * @author Chaitali
     * @return String
     * @return selected month and year
     * @throws Exception
     */
    public String getSelectedMonthNYear() throws Exception {
        try {
            frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(monthYear, waitTime);
            selectedMonthYear = monthYear.getText();
            logInstruction("LOG INSTRUCTION: GOT SELECTED MONTH AND YEAR");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET SELECTED MONTH AND YEAR \n METHOD :getSelectedMonthNYear");
        }
        return selectedMonthYear;
    }

    /**
     * Method helps to verify focused date
     * 
     * @author Chaitali
     * @param String date
     * @throws Exception
     * @returns boolean true if date is focused false if date not focused
     */
    public boolean verifyFocusOnDate(String date) throws Exception {
        try {
            frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(dates.getUIElementByIndex(0), waitTime);
            // get parent element
            parentElement = dates.getUIElementByText(date).findUIElement(By.xpath(".."));
            dateCellStyle = parentElement.getAttribute("style");
            dateCellStyle = dateCellStyle.toLowerCase();
            // if style does not contains 'background-color:white' then the date
            // is
            // focused
            if (!(dateCellStyle.contains("background-color:white")))
                return true;
            else
                return false;
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY FOCUS OF THE CURRENT SELECTED DATE \n METHOD :verifyFocusOnDate" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * Method helps to select date
     * 
     * @author Mamatha
     * @param String
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     */
    public TextMultimediaEditSchedulePage selectDateForTextMultiMediaEditScheduler(String Date)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT DATE");

            uiDriver.waitToBeDisplayed(dates.getUIElementByText(Date), waitTime);
            dates.getUIElementByText(Date).clickNoWait();
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT DATE \n METHOD :selectDateForTextMultiMediaEditScheduler" + e
                    .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * Method helps to select date
     * 
     * @author Mamatha
     * @return CourseAdminCourseSchedulerPage
     * @throws Exception
     */
    public CourseAdminCourseSchedulerPage selectDateForCourseScheduler(String Date)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT DATE");
            frameSwitch.switchToDatePickerPage();
            uiDriver.waitToBeDisplayed(dates.getUIElementByText(Date), waitTime);
            dates.getUIElementByText(Date).click();
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT DATE \n METHOD :selectDate" + e
                    .getLocalizedMessage());
        }
        return new CourseAdminCourseSchedulerPage(uiDriver);
    }

}
