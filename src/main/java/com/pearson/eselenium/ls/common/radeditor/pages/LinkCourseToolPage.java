package com.pearson.eselenium.ls.common.radeditor.pages;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Point;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to LinkCourseTool Page
 * 
 * @author Pratush.Manglik
 */
public class LinkCourseToolPage extends BasePageObject {

    /* UIElement declarations for the add topic page */

    private UIElement lblHeaderTitle = createElement(UIType.Css, ".headertitle");
    private UIElement lblTextTitle = createElement(
            UIType.Css,
            ".innercontenttable>table>tbody>tr>td>label");
    private UIElement txtTitle = createElement(UIType.Css, "#linkTitle");
    private UIElement lblErrorMessage = createElement(UIType.Css, ".inlineerror>table>tbody>tr>td");
    private UIElement btnBack = createElement(UIType.Xpath, "//input[contains(@value,'Back')]");
    private UIElement btnAdd = createElement(UIType.Xpath, "//input[contains(@value,'Add Link')]");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[contains(@value,'Cancel')]");
    private UIElement btnradValue = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/parent::td/preceding-sibling::td/input[@type='radio']");
    private UIElements lblText = createElements(
            UIType.Xpath,
            "//td[@class='innercontenttable']/table/tbody/tr/td[1]");
    private UIElement btnRadio = createElement(
            UIType.Xpath,
            "//tr[td[label[contains(text(),'{1}')]]]/td/input");
    private UIElement btnGradebookRadio = createElement(
            UIType.Xpath,
            "//tr[td[label[contains(text(),'Gradebook')]]]/td/input[@checked]");
    private UIElement txtInstructionalText = createElement(
            UIType.Xpath,
            "//tbody/tr[4]//td[span[@class='redtext']]");

    /*Variables*/
	private static final String YELLOW = "yellow";
    private static final String CLASSATTRIBUTE = "class";
    private static final String REQUIREDATTRIBUTE = "required";
    boolean flag = false;
    private String strResult = null;
    List<UIElement> listOfLabelElements = new ArrayList<UIElement>();
    List<UIElement> listOfLabelElements1 = new ArrayList<UIElement>();
    
	/*Constructor*/
	public LinkCourseToolPage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "LinkCourseToolPage";
        logInstruction("LOG INSTRUCTION: ## LinkCourseToolPage ##");
    }
    /**
     * Method helps to switch the window
     * 
     * @author Pratush.Manglik
     * @throws Exception
     */
    public void switchToWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO LINKCOURSE TOOL PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH THE WINDOW" + "\nMETHOD:switchToWindow\n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Method verifies whether Header Link is displayed
     * 
     * @author Pratush.Manglik
     * @return header
     * @throws Exception
     */
    public String getAddLinkHeader() throws Exception {

        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFICATION OF TITLE HEADER ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
            strResult = lblHeaderTitle.getText();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING ADD LINK HEADER" + "\nMETHOD :getAddLinkHeader \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method verifies whether Text Title is displayed
     * 
     * @author Pratush.Manglik
     * @return title
     * @throws Exception
     */
    public String getTextTitle() throws Exception {

        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFICATION OF TEXT FIELD TITLE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblTextTitle, waitTime);
            strResult = lblTextTitle.getText();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING TEXT TITLE" + "\n METHOD : getTextTitle\n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method verifies whether Text Field is displayed
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isTextBoxDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFICATION OF TEXT FIELD ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            flag = txtTitle.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "TEXT FIELD IS NOT DISPLAYED" + "\nMETHOD : isTextBoxDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to select the radio button
     * 
     * @author Pratush.Manglik
     * @param linkto
     * @return LinkCourseTool
     * @throws Exception
     */
    public LinkCourseToolPage selectRadioButton(String strLinkto) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: SELECTING A RADIO BUTTON");
            frameSwitch.switchToAddLinkFrame();

            btnradValue.replaceValues(strLinkto);
            btnradValue.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE RADIO BUTTON" + "\nMETHOD : selectRadioButton\n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * Method verifies whether error message is displayed
     * 
     * @author Pratush.Manglik
     * @return boolean
     * @throws Exception
     */
    public boolean isErrorMessageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFICATION OF ERROR MESSAGE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lblErrorMessage, waitTime);
            flag = lblErrorMessage.isDisplayedAfterWaiting();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING ERROR MESSAGE" + "\n METHOD: isErrorMessageDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method enters some value into the text field
     * 
     * @author Pratush.Manglik
     * @param String
     * @return LinkCourseTool
     * @throws Exception
     */
    public LinkCourseToolPage enterText(String strText) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: ENTERING SOME VALUE INTO THE TEXT FIELD");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            txtTitle.clearAndSendKeys(strText);
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER TEXT IN THE FIELD" + "\nMETHOD: enterText\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method is used to press the cancel button
     * 
     * @author Pratush.Manglik
     * @return
     * @throws Exception
     */
    public void clickCancelButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: METHOD IS USED TO CLICK THE CANCEL BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnCancel.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK CANCEL BUTTON" + "\nMETHOD: clickCancelButton\n" + e
                            .getLocalizedMessage());

        }

    }

    /**
     * Method is used to press Add Link Button
     * 
     * @author Pratush.Manglik
     * @return
     * @throws Exception
     */
    public void clickAddButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: METHOD IS USED TO CLICK ADD LINK BUTTON");
            frameSwitch.switchToAddLinkFrame();
            btnAdd.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ADD LINK BUTTON" + " \nMETHOD: clickAddButton\n " + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Method is used to press Back Link Button
     * 
     * @author Pratush.Manglik
     * @return LinkWizardnsertLink
     * @throws Exception
     */
    public LinkWizardInsertLinkPage clickBackButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: METHOD IS USED TO CLICK BACK BUTTON");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnBack, waitTime);
            btnBack.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK BACK BUTTON METHOD :clickBackButton" + e
                    .getLocalizedMessage());
        }
        return new LinkWizardInsertLinkPage(uiDriver);
    }

    /**
     * Method will get back ground color of "Text to display" input field
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public String getBackGroundColorOfTextToDisplayFieldTextBox() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET BACK GROUND COLOR OF 'TEXT TO DISPLAY' FIELD");
            frameSwitch.switchToAddLinkFrame();
            if (txtTitle.getAttribute(CLASSATTRIBUTE).contains(REQUIREDATTRIBUTE))
                strResult = YELLOW;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND BACK GROUND COLOR OF 'TEXT TO DISPLAY'  METHOD : getBackGroundColorOfTextToDisplayFieldTextBox" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will get entered text from the "Text to display" input field
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public String getTextToDisplayFieldContent() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET TEXT FROM 'TEXT TO DISPLAY' FIELD");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtTitle.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND TEXT  FOR 'TEXT TO DISPLAY' METHOD : getTextToDisplayFieldContent" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will check is "Add Link" button displayed or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isAddLinkButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING ADD LINK BUTTON PRESENT OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = btnAdd.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY ADD LINK BUTTON" + "\n METHOD :isAddLinkButtonDisplayed\n " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check is "Cancel" button displayed or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING 'Cancel' BUTTON PRESENT OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO VERIFY 'Cancel' BUTTON " + "\n METHOD : isCancelButtonDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will check is "Back" button displayed or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isBackButtonDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING 'Back' BUTTON PRESENT OR NOT ");
            frameSwitch.switchToAddLinkFrame();
            flag = btnBack.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY 'Back' BUTTON" + "\n METHOD : isBackButtonDisplayed\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify specified label is present or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isLabelDisplayed(String strLabel) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING SPECIFIED 'Label' IS PRESENT OR NOT");
            if (StringUtils.isNotBlank(strLabel) && lblText.areAllPresent()) {
                frameSwitch.switchToAddLinkFrame();
                listOfLabelElements = lblText.getUIElementsList();
                for (UIElement element : listOfLabelElements) {
                    if (element.getText().contains(strLabel)) {
                        flag = true;
                        break;
                    }
                }
            } else
                // if(StringUtils.isNotBlank(label) && lblText.areAllPresent())
                logInstruction("LOG INSTRUCTION : Either provided label is NULL or not finding elements in the page");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY TEXT TO DISPLAY LABEL" + "\n METHOD : isLabelDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify Astric symbol is present or not for specified label
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isAsteriskSymbolDisplayed(String strLabel) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY ASTRIC SYMBOL IS PRESENT OR NOT FOR SPECIFIED LABEL");
            if (StringUtils.isNotBlank(strLabel) && lblText.areAllPresent()) {
                frameSwitch.switchToAddLinkFrame();
                listOfLabelElements1 = lblText.getUIElementsList();
                for (UIElement element : listOfLabelElements1) {
                    if (element.getText().contains(strLabel) && element.getText().contains("*")) {
                        flag = true;
                        break;
                    }
                }
            } else
                // if(StringUtils.isNotBlank(label) && lblText.areAllPresent())
                logInstruction("LOG INSTRUCTION : EITHER PROVIDED LABEL IS NULL OR NOT FINDING ELEMENTS IN THE PAGE");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY TEXT TO DISPLAY LABEL" + "\n method :isAsteriskSymbolDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method will check radio button is displayed for specified course tool or not
     * 
     * @param courseTool
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isRadioOptionDisplayedForACourseTool(String strCourseTool) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING RADIO BUTTON IS DISPLAYED FOR SPECIFIED COURSE TOOL OR NOT");
            if (StringUtils.isNotBlank(strCourseTool)) {
                frameSwitch.switchToAddLinkFrame();
                btnRadio.replaceValues(strCourseTool);
                flag = btnRadio.isDisplayedAfterWaiting(waitTime);
            } else
                // if(StringUtils.isNotBlank(courseTool))
                logInstruction("LOG INSTRUCTION : PROVIDED COURSE TOOL IS NULL");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY RADIO BUTTON" + "\n method : isRadioOptionDisplayedForACourseTool\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify Grade book radio button is selected by default or not
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isGradebookOptionSelectedByDefault() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFY GRADEBOOK RADIO BUTTON IS SELECTED BY DEFAULT OR NOT");
            frameSwitch.switchToAddLinkFrame();
            flag = btnGradebookRadio.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY RADIO BUTTON" + "\n method :isGradebookOptionSelectedByDefaults\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will return the instructional text
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     * @category Milestone 2
     */
    public String getInstructionalMessage() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GETTING INSTRUCTIONAL TEXT");
            frameSwitch.switchToAddLinkFrame();
            strResult = txtInstructionalText.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET INSTRUCTIONAL TEXT" + e.getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method will check radio button is clickable or not
     * 
     * @author Praveen.Maled
     * @param course
     * @return
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isRadioButtonClickable(String strCourse) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING RADIO BUTTON IS CLICKABLE FOR SPECIFIED COURSE TOOL OR NOT");
            if (StringUtils.isNotBlank(strCourse)) {
                frameSwitch.switchToAddLinkFrame();
                btnRadio.replaceValues(strCourse);
                btnRadio.clickNoWait();
                if (btnRadio.isSelected())
                    flag = true;
            } else
                // if(StringUtils.isNotBlank(course))
                logInstruction("LOG INSTRUCTION : PROVIDED COURSE TOOL IS NULL");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY RADIO BUTTON CLICKABLE OR NOT" + "\n method : isRadioButtonClickable\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to verify whether Focus On "Text To Display" Field
     * 
     * @author Bharat.Goel
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isFocusOnTextToDisplayField() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : Checking If Focus On Text To Display Field ");
            frameSwitch.switchToAddLinkFrame();
            Point point = uiDriver.switchTo().activeElement().getLocation();
            txtTitle.isDisplayedAfterWaiting(waitTime);
            if (point.x == txtTitle.getLocation().x && point.y == txtTitle.getLocation().y)
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK  IF FOCUS IS ON TEXT TO DISPLAY FIELD" + "\nMETHOD:isFocusOnTextToDisplayField\n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will Verify radio button is selected for specified Option
     * 
     * @author Praveen.Maled
     * @param option
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isOptionSelected(String strOption) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY RADIO BUTTON IS SELECTED FOR SPECIFIED OPTION ");
            if (StringUtils.isNotBlank(strOption)) {
                frameSwitch.switchToAddLinkFrame();
                btnRadio.replaceValues(strOption);
                btnRadio.isDisplayedAfterWaiting(waitTime);
                flag = btnRadio.isSelected();
            } else {
                logInstruction("LOG INSTRUCTION: PROVIDED OPTION IS NULL");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY SELECTED RADIO BUTTON" + "\n METHOD: isOptionSelected" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
    
    /** Method will create Link from CourseTool Link page
     * @author Praveen.Maled
    * @param strTextToBeDisplay
    * @param strToolToLink
    * @throws Exception
    * @category Milestone 2
    */
    public void createCourseToolLink(String strTextToBeDisplay, String strToolToLink)
            throws Exception {
   	try {
   		if(StringUtils.isNotBlank(strTextToBeDisplay) && StringUtils.isNotBlank(strToolToLink)){
   			logInstruction("LOG INSTRUCTION: CREATING COURSETOOL LINK");
   			logInstruction("LOG INSTRUCTION: ENTER THE TEXT TO DISPLAY");
   			frameSwitch.switchToAddLinkFrame();
   			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
   			txtTitle.clearAndSendKeys(strTextToBeDisplay);
   			logInstruction("LOG INSTRUCTION: SELECTING RAIO BUTTON");
   			btnradValue.replaceValues(strToolToLink);
   			btnradValue.clickNoWait();
   			logInstruction("LOG INSTRUCTION: CLICKING ON ADD LINK");
   			btnAdd.clickAndWait(waitTime);
   			uiDriver.getUIWindowLocator().switchToFirstWindow();
   		}else
                throw new Exception(
                        "EITHER PROVIDED LINK TEXT OR TOOL IS NULL" + "\nMETHOD:createCourseToolLink\n");
       } catch (Exception e) {
           throw new Exception(
                   "ISSUE IN CREATING COURSETOOL LINK \nMETHOD : createCourseToolLink\n" + e
                           .getLocalizedMessage());
       }
   }
}