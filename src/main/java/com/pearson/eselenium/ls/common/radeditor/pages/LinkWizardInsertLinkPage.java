package com.pearson.eselenium.ls.common.radeditor.pages;


import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * 
 * @author monica.anand This is the Page Object for Insert Link Screen
 * 
 */
public class LinkWizardInsertLinkPage extends BasePageObject {

    /* Elements */
    private UIElement btnContinue = createElement(UIType.Css, "input[value='Continue >'] ");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel'] ");
    private UIElement btnradInsertImage = createElement(UIType.ID, "insertimage");
    private UIElement btnradCourseRadio = createElement(UIType.ID, "course");
    private UIElement btnradCourseContent = createElement(UIType.ID, "coursecontent");
    private UIElement btnradWebsite = createElement(UIType.ID, "website");
    private UIElement lnkInsert = createElement(
            UIType.Xpath,
            "//div[@id='RadText']//table[contains(@id,'TextWrapper')]//td[@class='reToolCell']//ul//li[@role='presentation']/a/span[@class='LinkWizardInsertLink']");
    private UIElement divTitle = createElement(UIType.Css, ".tablehead");
    private UIElement btnradAddLink = createElement(
            UIType.Xpath,
            "//table[@role='presentation']/tbody/tr[td/label[contains(text(),'{1}')]]/td[1]");
    private UIElement lblOption = createElement(UIType.Xpath, "//label[contains(text(),'{1}')]");
    private UIElement btnRadio = createElement(
            UIType.Xpath,
            "//tr[td[label[contains(text(),'{1}')]]]/td/input[@type='radio']");
    private UIElement lblSelectTypeOfLink = createElement(
            UIType.Xpath,
            "//td[@class='innercontenttable']/table/tbody/tr/td[1]");
    private UIElement radContentFile = createElement(UIType.ID, "linkfile");

	/* Constants */
    private static final String LINK_TO_CONTENT_OR_FILES = "Link to Content or Files";
    private static final String INSERT_AN_IMAGE = "Insert an Image";
    private static final String LINK_TO_A_WEBSITE = "Link to a Website";
    private static final String LINK_TO_A_COURSE_TOOL = "Link to a Course Tool";
    private static final String LINK_TO_A_COURSE_CONTENT = "Link to Course Content";
    private static final String VALIGNATTRIBUTE = "valign";
    private static final String TOP = "top";
    boolean flag = false;
    boolean flag2 = false;
    private String strLocation1 = null;
    private String strLocation2 = null;
    private String strLocation3 = null;
    private String strLocation4 = null;
    private String strLocation5 = null;
    private String strLocation6 = null;
    private String strResult = null;
    private int size = 0;
    private int eleright1 = 0;
    private int formRight1 = 0;
    private int formLeft1 = 0;
    private int formTop1 = 0;
    private int formBottom1 = 0;
    private int elebottom1 = 0;
    private int width1 = 0;
    private int height1 = 0;
    private int right2 = 0;
    private int left2 = 0;
    /* Constructor */
    public LinkWizardInsertLinkPage(UIDriver uidriver) {
        super(uidriver);
        pageTitle = "LinkWizardInsertLinkPage";
        logInstruction("LOG INSTRUCTION: ## LinkWizardInsertLinkPage ### ");
    }

    /**
     * This method is used to click on continue button to navigate to Link to a Course Content Page
     * 
     * @author monica.anand
     * @return LinkCourseContentPage
     * @throws Exception
     */
    public LinkCourseContentPage clickContinueButtonToLinkToCourseContent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CONTINUE BUTTON TO NAVIGATE TO LINK TO A CORSE CONTENT PAGE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnContinue, waitTime);
            btnContinue.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CONTINUE BUTTON" + "\n METHOD:'clickContinueButtonToLinkToCourseContent' " + e
                            .getLocalizedMessage());
        }
        return new LinkCourseContentPage(uiDriver);
    }

    /**
     * This method is used to click on continue button to navigate to Link to a Course Tool Page
     * 
     * @author monica.anand
     * @return LinkCourseToolPage
     * @throws Exception
     */
    public LinkCourseToolPage clickContinueButtonToLinkToCourseTool() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CONTINUE BUTTON TO NAVIGATE TO LINK TO COURSE TOOL PAGE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnContinue, waitTime);
            btnContinue.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CONTINUE BUTTON" + "\n METHOD : 'clickContinueButtonToLinkToCourseTool'" + e
                            .getLocalizedMessage());
        }
        return new LinkCourseToolPage(uiDriver);
    }

    /**
     * This method is used to click on continue button to navigate to Link to a Website Page
     * 
     * @author monica.anand
     * @return LinkWebsitePage
     * @throws Exception
     * 
     * 
     */
    public LinkWebsitePage clickContinueButtonToLinkToAWebsite() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CONTINUE BUTTON TO NAVIGATE TO LINK TO A WEBSITE PAGE");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnContinue, waitTime);
            btnContinue.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CONTINUE BUTTON " + "\nMETHOD : clickContinueButtonToLinkToAWebsite" + e
                            .getLocalizedMessage());
        }
        return new LinkWebsitePage(uiDriver);
    }

    /**
     * This method is used to click on continue button to navigate to Insert an Image Page
     * 
     * @author monica.anand
     * @return LinkWizardUploadImagePage
     * @throws Exception
     * 
     * 
     */
    public LinkWizardUploadImagePage clickContinueButtonToInsertAnImage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CONTINUE BUTTON TO NAVIGATE TO LINKWIZARDUPLOADIMAGE PAGE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnContinue, waitTime);
            btnContinue.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CONTINUE BUTTON" + "\n METHOD :clickContinueButtonToInsertAnImage " + e
                            .getLocalizedMessage());
        }
        return new LinkWizardUploadImagePage(uiDriver);
    }

    /**
     * This method is used to click on continue button to navigate to Link To Content Or Files Page
     * 
     * @author monica.anand
     * @return LinkWizardUploadContentPage
     * @throws Exception
     * 
     * 
     */
    public LinkWizardUploadContentPage clickContinueButtonToLinkToContent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CONTINUE BUTTON TO NAVIGATE TO LINK TO CONTENT OR FILES PAGE ");
            frameSwitch.switchToAddLinkFrame();
            btnContinue.isDisplayedAfterWaiting(waitTime);
            btnContinue.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CONTINUE BUTTON" + "\n METHOD : clickContinueButtonToLinkToContent " + e
                            .getLocalizedMessage());
        }
        return new LinkWizardUploadContentPage(uiDriver);
    }

    /**
     * This method is used to click on Cancel Button
     * 
     * @author monica.anand
     * 
     * @throws Exception
     * 
     */

    public void clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CANCEL BUTTON IN  ADD LINK PAGE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickNoWait();
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CANCEL BUTTON " + "\nMETHOD : clickCancelButton" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This method is used to click on Insert Image Radio Button
     * 
     * @author monica.anand
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     * 
     */

    public LinkWizardInsertLinkPage clickInsertImageRadioButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING INSERT IMAGE RADIO BUTTON ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnradInsertImage, waitTime);
            btnradInsertImage.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON INSERT IMAGE" + "\n METHOD :clickInsertImageRadioButton " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on Link To a Website radio button
     * 
     * @author monica.anand
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     * 
     */
    public LinkWizardInsertLinkPage clickLinkToAWebsite() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICKING LINK TO A WEBSITE RADIO BUTTON IN  ADD LINK PAGE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnradWebsite, waitTime);
            btnradWebsite.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON LINK TO A WEBSITE RADIO BUTTON " + "\nMETHOD: clickLinkToAWebsite" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on Link To A Course Tool radio button
     * 
     * @author monica.anand
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     * 
     */
    public LinkWizardInsertLinkPage clickLinkToACourseTool() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING LINK TO A COURSE TOOL RADIO BUTTON IN  ADD LINK PAGE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnradCourseRadio, waitTime);
            btnradCourseRadio.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON LINK TO A COURSE TOOL RADIO BUTTON IN  ADD LINK PAGE " + "\nMETHOD : clickLinkToACourseTool " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click link to a course content radio button
     * 
     * @author monica.anand
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     */
    public LinkWizardInsertLinkPage clickLinkToCourseContent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING LINK TO COURSE CONTENT IN  ADD LINK PAGE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnradCourseContent, waitTime);
            btnradCourseContent.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON LINK TO COURSE CONTENT RADIO BUTTON IN  ADD LINK PAGE " + "\nMETHOD : clickLinkToCourseContent " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on link to wizard insert link
     * 
     * @author monica.anand
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     */
    public LinkWizardInsertLinkPage clickLinkWizardInsertLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING LINK TO WIZARD INSERT  IN  ADD LINK PAGE ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkInsert, waitTime);
            lnkInsert.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON LINK TO WIZARD INSERT  IN  ADD LINK PAGE" + "\n METHOD : clickLinkWizardInsertLink" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to get the Page title
     * 
     * @author monica.anand
     * @return string
     * @throws Exception
     */
    public String getPageTitle() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY PAGE TITLE ");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(divTitle, waitTime);
            strResult = divTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY PAGE TITLE" + "\nMETHOD : getPageTitle" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to click radio buttons on add link page
     * 
     * @author monica.anand
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     */
    public LinkWizardInsertLinkPage clickRadioButton(String strLinkto) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT RADIO BUTTON ");
            frameSwitch.switchToAddLinkFrame();
            btnradAddLink.replaceValues(strLinkto);
            btnradAddLink.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE RADIO BUTTON " + "\nMETHOD : clickRadioButton" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to check if a selected radio button option is present
     * 
     * @author monica.anand
     * @return boolean throws Exception
     */
    public boolean isLabelDisplayed(String strLabel) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING IF A PARTICULAR RADIO BUTTON OPTION IS DISPLAYED");
            frameSwitch.switchToAddLinkFrame();
            lblOption.replaceValues(strLabel);
            flag = lblOption.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("LABEL IS NOT DISPLAYED " + "\nMETHOD :  isLabelDisplayed" + e
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

    /**
     * Method will click on the text of specified option
     * 
     * @author Praveen.Maled
     * @param Option
     * @return LinkWizardInsertLinkPage
     * @throws Exception
     * @category Milestone 2
     */
    public LinkWizardInsertLinkPage clickOnOptionText(String strOption) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON TEXT OF SPECIFIED OPTION ");
            if (StringUtils.isNotBlank(strOption)) {
                frameSwitch.switchToAddLinkFrame();
                lblOption.replaceValues(strOption);
                lblOption.isDisplayedAfterWaiting(waitTime);
                lblOption.clickNoWait();
            } else {
                // if(StringUtils.isNotBlank(option))
                throw new Exception("PROVIDED OPTION IS NULL");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON TEXT OF SPEIFIED OPTION" + "\nMETHOD:  clickOnOptionText" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will return the total number of radio buttons selected in page we are not able to get
     * selected radio buttons text hence calling is option selected method 5 times
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isSelectedOptionsMoreThanOne() throws Exception {
        flag = false;
        size = 0;
        try {
            logInstruction("LOG INSTRUCTION: VERIFY RADIO BUTTON IS SELECTED FOR SPECIFIED OPTION ");
            frameSwitch.switchToAddLinkFrame();
            if (isOptionSelected(LINK_TO_CONTENT_OR_FILES)) {
                size++;
            }
            if (isOptionSelected(INSERT_AN_IMAGE)) {
                size++;
            }
            if (isOptionSelected(LINK_TO_A_WEBSITE)) {
                size++;
            }
            if (isOptionSelected(LINK_TO_A_COURSE_TOOL)) {
                size++;
            }
            if (isOptionSelected(LINK_TO_A_COURSE_CONTENT)) {
                size++;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY SELECTED RADIO BUTTON " + "\nMETHOD: getNumberOfSelectedOptions" + e
                            .getLocalizedMessage());
        }
        if (size > 1) {
            flag = true;
        }
        else{
        	flag=false;
        }        
        return flag;
    }

    /**
     * Method will verify radio button for specified option
     * 
     * @author Praveen.Maled
     * @param option
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isRadioButtonPresentForOption(String strOption) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING RADIO BUTTON FOR SPECIFIED OPTION ");
            if (StringUtils.isNotBlank(strOption)) {
                frameSwitch.switchToAddLinkFrame();
                btnRadio.replaceValues(strOption);
                flag = btnRadio.isDisplayedAfterWaiting(waitTime);
            } else {
                // if(StringUtils.isNotBlank(option))
                logInstruction("LOG INSTRUCTION: Provided option is NULL");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO VERIFY RADIO BUTTON FOR SPEIFIED OPTION " + "\n METHOD: isRadioButtonPresentForOption" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify 'Select type of link' label is top left side
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isSelectTypeOfLinkisTopLeftSide() throws Exception {
        flag = false;
        flag2 = false;
        strLocation1 = null;
        strLocation2 = null;
        strLocation3 = null;
        left2 = 0;
        formRight1 = 0;
        formLeft1 = 0;
        width1 = 0;
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR LABLE 'SELECT TYPE OF LINK' IS AT TOP LEFT SIDE OR NOT");
            frameSwitch.switchToAddLinkFrame();
            if (TOP.equalsIgnoreCase(lblSelectTypeOfLink.getAttribute(VALIGNATTRIBUTE)))
                flag = true;

            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName('td')[3].getBoundingClientRect().right");
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName('form')[0].getBoundingClientRect().right");
            strLocation3 = uiDriver
                    .executeScript("return document.getElementsByTagName('form')[0].getBoundingClientRect().left");

            left2 = Integer.parseInt(strLocation1);
            formRight1 = Integer.parseInt(strLocation2);
            formLeft1 = Integer.parseInt(strLocation3);
            width1 = formRight1 - formLeft1;
            if (((width1 / 2) > left2) && flag)
                flag2 = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:UNABLE TO CHECK POSITIONING OF LABEL" + "\n METHOD: isSelectTypeOfLinkisTopLeftSide" + e
                            .getLocalizedMessage());
        }
        return flag2;
    }

    /**
     * Method will verify continue button is bottom right side
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isContinueButtonAtBottomRightSide() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        strLocation3 = null;
        strLocation4 = null;
        strLocation5 = null;
        strLocation6 = null;
        eleright1 = 0;
        formRight1 = 0;
        formLeft1 = 0;
        formTop1 = 0;
        formBottom1 = 0;
        elebottom1 = 0;
        width1 = 0;
        height1 = 0;
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR CONTINUE BUTTON IS BOTTOM RIGHT SIDE OR NOT");
            frameSwitch.switchToAddLinkFrame();
            strLocation4 = uiDriver
                    .executeScript("return document.getElementsByTagName('input')[5].getBoundingClientRect().right");
            strLocation5 = uiDriver
                    .executeScript("return document.getElementsByTagName('form')[0].getBoundingClientRect().right");
            strLocation6 = uiDriver
                    .executeScript("return document.getElementsByTagName('form')[0].getBoundingClientRect().left");
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName('form')[0].getBoundingClientRect().top");
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName('form')[0].getBoundingClientRect().bottom");
            strLocation3 = uiDriver
                    .executeScript("return document.getElementsByTagName('input')[5].getBoundingClientRect().bottom");

            eleright1 = Integer.parseInt(strLocation4);
            formRight1 = Integer.parseInt(strLocation5);
            formLeft1 = Integer.parseInt(strLocation6);
            formTop1 = Integer.parseInt(strLocation1);
            formBottom1 = Integer.parseInt(strLocation2);
            elebottom1 = Integer.parseInt(strLocation3);
            width1 = formRight1 - formLeft1;
            height1 = formBottom1 - formTop1;
            if ((width1 / 2) < eleright1 && (height1 / 2) < elebottom1)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:UNABLE TO CHECK POSITIONING OF BUTTONS " + "\nMETHOD :isContinueButtonAtBottomRightSide " + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will verify cancel button is right to continue button
     * 
     * @author Praveen.Maled
     * @return boolean
     * @throws Exception
     * @category Milestone 2
     */
    public boolean isCancelButtonAtRightOfContinueButton() throws Exception {
        flag = false;
        strLocation1 = null;
        strLocation2 = null;
        right2 = 0;
        left2 = 0;
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR CANCEL BUTTON IS RIGHT SIDE OF THE CONTINUE BUTTON");
            frameSwitch.switchToAddLinkFrame();
            strLocation1 = uiDriver
                    .executeScript("return document.getElementsByTagName('input')[5].getBoundingClientRect().right");
            strLocation2 = uiDriver
                    .executeScript("return document.getElementsByTagName('input')[6].getBoundingClientRect().left");
            right2 = Integer.parseInt(strLocation1);
            left2 = Integer.parseInt(strLocation2);
            if (left2 > right2)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:UNABLE TO CHECK POSITIONING OF BUTTONS " + "\nMETHOD : isCancelButtonAtRightOfContinueButton" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     *      * Method helps to switch to add to link page      *       * @author Usha      * @return
     * LinkWizardInsertLinkPage      * @throws Exception      
     */
    public LinkWizardInsertLinkPage switchToAddLinkPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO ADDLINK PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH THE WINDOW " + "\nMETHID : switchToAddLinkPage" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will switch to LinkWebsite page
     * 
     * @return
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public LinkWebsitePage switchToLinkWebsitePage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING TO LINK WEBSITE PAGE ");
            uiDriver.getUIWindowLocator().switchToNewWindow();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET THE LINK WEBSITE PAGE " + "\n METHOD : switchToLinkWebsitePage");

        }
        return new LinkWebsitePage(uiDriver);
    }

    /**
     * Method will click on radio button of Link to Content or Files
     * 
     * @author Praveen.Maled
     * @return {@link LinkWizardInsertLinkPage}
     * @throws Exception
     * @category Milestone 2
     */
    public LinkWizardInsertLinkPage clickContentFileRadioButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CONTENT FILE OPTION RADIO BUTTON");
            frameSwitch.switchToAddLinkFrame();
            radContentFile.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON CONTENT FILE OPTION RADIO BUTTON" + "\nMETHOD:clickContentFileRadioButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
    
    
    /**
     * Method will navigate to the specified option page
     * @author Praveen.Maled
     * @param strOption
     * @throws Exception
     * @category Milestone 2
     */
    public Object navigateToSelectedOption(String strOption) throws Exception {
    	try {
            if (StringUtils.isNotBlank(strOption)) {
            	logInstruction("LOG INSTRUCTION: CLICKING ON TEXT OF SPECIFIED OPTION ");
                frameSwitch.switchToAddLinkFrame();
                lblOption.replaceValues(strOption);
                lblOption.isDisplayedAfterWaiting(waitTime);
                logInstruction("LOG INSTRUCTION: CLICKING CONTINUE BUTTON");
                lblOption.clickNoWait();
                btnContinue.clickAndWait(waitTime);

            if(LINK_TO_CONTENT_OR_FILES.equalsIgnoreCase(strOption))
            	return new LinkWizardUploadContentPage(uiDriver); 
                else
                    if (INSERT_AN_IMAGE.equalsIgnoreCase(strOption))
            	return new LinkWizardUploadImagePage(uiDriver);
                    else
                        if (LINK_TO_A_WEBSITE.equalsIgnoreCase(strOption))
            	return new LinkWebsitePage(uiDriver); 
                        else
                            if (LINK_TO_A_COURSE_TOOL.equalsIgnoreCase(strOption))
            	return new LinkCourseToolPage(uiDriver); 
                            else
                                if (LINK_TO_A_COURSE_CONTENT.equalsIgnoreCase(strOption))
            	return new LinkCourseContentPage(uiDriver); 
            else 
            	return this;
            } else {
                throw new Exception(
                        "PROVIDED OPTION IS NULL" + "\nMETHOD: navigateToSelectedOption");
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN NAVIGATING TO SPECIFIED PAGE" + "\nMETHOD:navigateToSelectedOption\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * this Method will verify Add Link page 
     * @return boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isAddALink() throws Exception{
    	try {
    		logInstruction("LOG INSTRCUTION: VERIFYING ADD LINK PAGE ");
    		uiDriver.switchTo().defaultContent();
    		uiDriver.getUIFrameLocator().selectFrame("popupcontent");
    		if(divTitle.getText().contains("Add a Link"))
    			return true;
			
		} catch (Exception e) {
			logInstruction("LOG INSTRUCTION: NOT ABLE TO GET THE ADD LINK \n METHOD: isAddALink");
		}
    	return false;
    }
	

}
