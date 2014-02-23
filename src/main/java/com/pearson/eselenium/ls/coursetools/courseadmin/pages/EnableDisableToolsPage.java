package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This Class contains all methods related to the EnableDisablePage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class EnableDisableToolsPage extends BasePageObject {

    /* UI element declarations for EnableDisablepage */

    private UIElement radEnableDisable = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']//tbody//tr[th[contains(.,'{1}')]]//td[label[contains(.,'{2}')]]//input");
    private UIElement btnSaveChanges = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Save')]");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[contains(@value,'Cancel')]");
    private UIElements lblToolNames = createElements(UIType.Xpath, "//th[@class='toolboxitem']");
    private UIElement lblenable = createElement(
            UIType.Xpath,
            "//th[contains(text(),'{1}')]/following-sibling::td[1]/label");
    private UIElement lbldisable = createElement(
            UIType.Xpath,
            "//th[contains(text(),'{1}')]/following-sibling::td[2]/label");
    private UIElement lbltool = createElement(UIType.Xpath, "//th[contains(text(),'{1}')]");
    private UIElement txtinstructional = createElement(
            UIType.Xpath,
            "//th[contains(text(),'{1}')]/following-sibling::td[3]");
    private UIElement txtHeader = createElement(UIType.Css, ".tablehead");
    /*variables*/
    private boolean flag = false;
    private String strText = null;
    
    /* constructor */
    public EnableDisableToolsPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## EnableDiablePage ##");
    }

    /**
     * This method is used to select enable or disable options as per Course tools
     * 
     * @author Pratush.Manglik
     * @param toolName
     * @param option
     * @return EnableDisablepage
     * @throws Exception
     */
    public EnableDisableToolsPage selectEnableDisableRadioButton(String toolName, String option)
            throws Exception {
        logInstruction("LOG INSTRUCTION:SELECT ENABLE OR DISABLE AS PER DIFFERENT COURSE TOOLS");
        try {
            frameSwitch.switchToFrameContent();
            radEnableDisable.replaceValues(toolName, option);
            uiDriver.waitToBeDisplayed(radEnableDisable, waitTime);
            radEnableDisable.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON'enable/disable radio options'" + "\n METHOD:selectEnableDisableRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This Method is used to click on Save Changes button
     * 
     * @author Pratush.Manglik
     * @return CourseAdminPage
     * @throws Exception
     */
    public CourseAdminPage clickSaveChanges() throws Exception {
        logInstruction("LOG INSTRUCTION:CLICK ON SAVE CHANGES BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
            btnSaveChanges.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Save Changes Button'" + "\n METHOD:clickSaveChanges \n" + e
                            .getLocalizedMessage());

        }
        return new CourseAdminPage(uiDriver);
    }

    /**
     * This Method is used to click on Cancel button
     * 
     * @author Pratush.Manglik
     * @return CourseAdminPage
     * @throws Exception
     */
    public CourseAdminPage clickCancel() throws Exception {
        logInstruction("LOG INSTRUCTION:CLICK ON CANCEL BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON  'Cancel  button'" + "\n METHOD:clickCancel \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminPage(uiDriver);

    }

    /**
     * This Method is used to check enable link
     * 
     * @category Milestone 2
     * @param enter
     *            tool name
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isEnableLabelPresent(String toolName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR ENABLE LABEL");
            frameSwitch.switchToFrameContent();
            lblenable.replaceValues(toolName);
            return lblenable.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'enablelabel'" + "\n METHOD:isEnableLabelPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This Method is used to check disable label
     * 
     * @category Milestone 2
     * @param enter
     *            tool name
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isDisableLabelPresent(String toolName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR DISABLE LABEL");
            frameSwitch.switchToFrameContent();
            lbldisable.replaceValues(toolName);
            return lbldisable.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'disablelabel'" + "\n METHOD:isDisableLabelPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This Method is used to check tool label
     * 
     * @category Milestone 2
     * @param enter
     *            tool name
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isToolLabelPresent(String toolName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR TOOL NAME PRESENT");
            frameSwitch.switchToFrameContent();
            lbltool.replaceValues(toolName);
            return lbltool.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'toollabel'" + "\n METHOD:isToolLabelPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This Method is used verify the instructional text present for the tool
     * 
     * @category Milestone 2
     * @param enter
     *            tool name
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */

    public boolean isInstructionalTxtPresentForTool(String toolName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE INSTRUCTIONAL TEXT");
            frameSwitch.switchToFrameContent();
            txtinstructional.replaceValues(toolName);
            return txtinstructional.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'InstructionalText'" + "\n METHOD:isInstructionalTxtPresentForTool \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This Method is used get the instructional text present for the tool
     * 
     * @category Milestone 2
     * @param enter
     *            tool name
     * @author kiran.kumar
     * @return String
     * @throws Exception
     */

    public String getInstructionalTxt(String toolName) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE INSTRUCTIONAL TEXT");
            frameSwitch.switchToFrameContent();
            txtinstructional.replaceValues(toolName);
            uiDriver.waitToBeDisplayed(txtinstructional, waitTime);
            strText = txtinstructional.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'instructional text'" + "\n METHOD:getInstructionalTxt \n" + e
                            .getLocalizedMessage());
        }
        return strText;
    }

    /**
     * This Method is used get the header or page title
     * 
     * @category Milestone 2
     * @param enter
     *            tool name
     * @author kiran.kumar
     * @return String
     * @throws Exception
     */

    public String getHeaderTitle() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE HEADER TEXT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeader, waitTime);
            strText = txtHeader.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'header text'" + "\n METHOD:getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return strText;
    }

    /**
     * This Method is used to verify the radio button
     * 
     * @category Milestone 2
     * @param enter
     *            tool name
     * @author kiran.kumar
     * @return String
     * @throws Exception
     */
    public boolean isEnableDisableRadioButtonSelected(String toolName, String option)
            throws Exception {
       
        logInstruction("LOG INSTRUCTION:VERIFY THE RADIO BUTTON ");
        try {
            frameSwitch.switchToFrameContent();
            radEnableDisable.replaceValues(toolName, option);
            uiDriver.waitToBeDisplayed(radEnableDisable, waitTime);
            flag = radEnableDisable.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'enable/disable radio options'" + "\n METHOD:isEnableDisableRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This Method is used to verify cancel button
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelBtnPresent() throws Exception {
     
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING THE CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            flag = btnCancel.isEnabled();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'cancelbutton'" + "\n METHOD:isCancelBtnPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This Method is used to verify save button
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveChangeBtnPresent() throws Exception {
      
        try {
            logInstruction("LOG INSTRUCTION :VERIFYING THE SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            flag = btnSaveChanges.isEnabled();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'savebutton'" + "\n METHOD:isSaveChangeBtnPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Method will verify if course tool is displayed
     * 
     * @author monica.anand
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isCourseToolDisplayed(String courseTool) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION : VERIFY IF COURSE TOOL IS DISPLAYED");
            if (StringUtils.isNotBlank(courseTool) && lblToolNames.areAllPresent()) {
                frameSwitch.switchToAddLinkFrame();
                List<UIElement> listOfLabelElements = lblToolNames.getUIElementsList();
                for (UIElement element : listOfLabelElements) {
                    if (element.getText().contains(courseTool)) {
                        flag = true;
                        break;
                    }
                }
            } else
                // if(StringUtils.isNotBlank(label) && lblText.areAllPresent())
                logInstruction("LOG INSTRUCTION : EITHER PROVIDED LABEL IS NULL OR NOT FINDING ELEMENTS IN THE PAGE");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'course tool'" + "\n METHOD:isCourseToolDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

}
