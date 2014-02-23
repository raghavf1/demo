package com.pearson.eselenium.ls.coursehome.syllabus.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Syllabus Home Page
 * 
 * @author Kapil
 * @date Nov 7, 2013
 */
public class SyllabusHomePage extends BasePageObject {

    /* Elements */
    private UIElement lnkInstructoInformation=createElement(UIType.Css, "a[title='Instructor Information']");
    private UIElement imgDeleteIcon=createElement(UIType.Xpath, "//td[a[contains(text(),'{1}')]]/following-sibling::td/a/img");
    private UIElement lnkSyllabusItemname=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']//tr//td[a[contains(.,'{1}')]]/a");
    private UIElement btnSave=createElement(UIType.Css, "#submit1");
    private UIElement btnAdd=createElement(UIType.Xpath, "//table//td[2]//input[@class='buttontd']");
    private UIElement msgHeaderTitle=createElement(UIType.Xpath,"//h2/div");
    private UIElement msgSampleSyllabusTitle=createElement(UIType.Xpath, "//table[2]//tbody//tr[1]//td");
    private UIElement msgSampleSyllabusContentText=createElement(UIType.Xpath, "//table[2]/tbody/tr[2]/td");
    private UIElement imgSampleSyllabusContent=createElement(UIType.Xpath, "//table[@role='presentation']//tr//img");
    private UIElement msgPageHeading=createElement(UIType.Xpath, "/html/body/h1/div");
    private boolean isComposeTextItemSelected;
    private UIElement clickAddButton=createElement(UIType.Xpath,"//table//td[2]//input[@class='buttontd']");
    private UIElement  selectUploadRadio=createElement(UIType.Css,"#upload");
    // private UIElement checktext;
    // private UIElement checktitle;
    private UIElement msgInline=createElement(UIType.Xpath, "//td[@class='inlineerror']//tbody//td[2]");
    private UIElement lnkCheckUploadFile=createElement(UIType.Xpath, "html/body/div[1]/p");
    private UIElement imgVisible=createElement(UIType.Css,"html>body>table>tbody>tr>td>img");
    
    private UIElement msgOrderNo=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']//table//td//a[text()='{1}']/ancestor-or-self::tr//input[3]");
    private UIElement radCourseItem=createElement(UIType.Css, "#compose");
    private UIElement radMsWordDocument=createElement(UIType.Css, "#upload");
    // private UIElement radioButtonLabelComposeTextOrMicrosoftMsg;
    // private UIElement syllabusItemTableElementsHeadding;
    private UIElement msgSyllabusTableOrderColoumHeadding=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']/table//th[contains(text(),'Order')]");
    private UIElement msgOrderColumn=createElement(UIType.Xpath, "//td[@class='dkgraybackground']");
    private UIElement msgSyllabusTableSyllabusItemsColoumHeadding=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']/table//th[contains(text(),'Syllabus Items')]");
    private UIElement msgSyllabusTableDeleteColoumHeadding=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']/table//th[contains(text(),'Delete')]");
    private UIElement msgSyllabusItemColoumnCount=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']/table//tr[1]");
   // private UIElement syllabusItemDeleteTableHeaddinMsg=createElement(uiType, value);
    // private UIElement syllabusItemTableHeaddinMsg;
    private UIElement msgUploadMsWord=createElement(UIType.Xpath, "//table[@role='presentation']//tr//img");
    private UIElement selectComposeRadio=createElement(UIType.Xpath,"//td//label[contains(text(),'Compose Text Item')]");
    private UIElement msgSampleSyllabusTableHeading=createElement(UIType.Xpath, "html/body/table[2]/tbody/tr[1]/td");
    private UIElement msgInstructorMessage=createElement(UIType.Xpath, "html/body/table[2]/tbody/tr[2]/td");
    private UIElement imgSyllabus=createElement(UIType.Xpath, "//table[@role='presentation']//tr//img");
    private UIElement lnkAddedSyllabusItem=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']//table//td//a[text()='{1}']");
    private UIElement txtAssociatedSyllabusItem=createElement(UIType.Xpath, "//table[@role='presentation']//tr//img");
    private UIElement msgSyllabusOrderNumber=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']//table//td//a[text()='{1}']/ancestor-or-self::tr//input[3]");
    private UIElement lnkSyllabusMicrosoftWordUpload=createElement(UIType.Xpath, "//table[2]//tr[2]/td[1]/a");
    private UIElement radUpload=createElement(UIType.Css, "#upload");
    private UIElement radCompose=createElement(UIType.Css, "#compose");
    private UIElements msgVerifyColoumn=createElements(UIType.Xpath, "//*[@id='frmSyllabusView']/table/tbody/tr[1]/th");
    private UIElement lblMicrosoftMsg=createElement(UIType.Xpath, "//*[@id='frmSyllabusView']/table/tbody/tr[1]/th");
    private UIElement lblComposeText=createElement(UIType.Xpath, "//td[@class='dkgraytext']//label[1]");
    private UIElement lblUploadCaption=createElement(UIType.Css, "label[for="+"upload"+"]");
    private UIElement msgCoversationFailMessage=createElement(UIType.Xpath, "//form[@id='frmSyllabusView']/table[2]/tbody/tr[2]/td[1]");
    private boolean flag = false;
private UIElement syllabusContentItem=createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElements lblSyllabuslist=createElements(UIType.Xpath, "//form[@id='frmSyllabusView']/table/tbody//tr/td[2]/a");
    
    /* Constructor */
    public SyllabusHomePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Syllabus Home Page ##");
    }

    public enum SyllabusHomePageRadioButtons {
        COMPOSE_TEXT_ITEM, UPLOAD_MICROSOFT_WORD_DOCUMENT;
    }

    /**
     * This method helps to click the InstructorInformation link
     * 
     * @author ashish.juyal
     * @throws Exception
     * @return EditInstructorInformationPage
     */
    public EditInstructorInformationPage clickInstructorInformationLink() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING THE INSTRUCTOR INFORMATION LINK");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkInstructoInformation, waitTime);
            lnkInstructoInformation.click();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN ClICKING ON 'Instructor Information Link' LINK" + "\n METHOD:clickInstructorInformationLink \n" + e
                            .getLocalizedMessage());
        }
        return new EditInstructorInformationPage(uiDriver);
    }

    /**
     * This method helps to click on the delete icon py passing the arguement as the syllabus item
     * name
     * 
     * @return DeleteSyllabusPage
     * @author ashish.juyal
     * @throws Exception
     */

    public DeleteSyllabusPage clickSyllabusDeleteIcon(String syllabusItemname) throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING THE DELETE ICON");
        try {
            frameSwitch.switchToFrameContent();
            imgDeleteIcon.replaceValues(syllabusItemname);
            uiDriver.waitToBeDisplayed(imgDeleteIcon, waitTime);
            imgDeleteIcon.click();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN ClICKING ON 'Syllabus Delete Icon'" + "\n METHOD:clickSyllabusDeleteIcon \n" + e
                            .getLocalizedMessage());
        }
        return new DeleteSyllabusPage(uiDriver);
    }

    /**
     * This method check whether the particular syllabus item exist or not
     * 
     * @param String
     *            - syllabusname
     * @author ashish.juyal
     * @throws Exception
     * @return boolean
     * 
     */
    public boolean isSyllabusItemDisplayed(String syllabusItemName) throws Exception {

        logInstruction("LOG INSTRUCTION: CHECKING THE SYLLABUS ITEM NAME");
        try {
            frameSwitch.switchToFrameContent();
            lnkSyllabusItemname.replaceValues(syllabusItemName);
            flag = lnkSyllabusItemname.isPresent();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING ON 'Syllabus Item Displayed '" + "\n METHOD: isSyllabusItemDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to click the syllabus item based on the name passed in the argument
     * 
     * @param String
     *            - syllabusname
     * @author ashish.juyal
     * @throws Exception
     * @return EditSyllabusItemName
     */
    public EditSyllabusPage clickSyllabusItem(String syllabusItemName) throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING SYLLABUS ITEM");
        try {
            frameSwitch.switchToFrameContent();
            lnkSyllabusItemname.replaceValues(syllabusItemName);
            uiDriver.waitToBeDisplayed(lnkSyllabusItemname, waitTime);

            lnkSyllabusItemname.click();
            logInstruction("LOG INSTRUCTION: syllabus item clicked");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN ClICKING ON 'Syllabus Item '" + "\n METHOD: clickSyllabusItem \n" + e
                            .getLocalizedMessage());
        }
        return new EditSyllabusPage(uiDriver);
    }

    /**
     * this method helps to click on the save order button
     * 
     * @return SyllabusHomePage
     * @throws Exception
     * @author ashish.juyal
     */
    public SyllabusHomePage clickSaveOrderButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICKING THE ORDER BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSave, waitTime);
            btnSave.click();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN ClICKING ON 'Save Order Button '" + "\n METHOD: clickSaveOrderButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method for selectAddSyllabusItems
     * 
     * @author suchi.singh
     * @return SyllabusHomePage
     * @param SyllabusHomePageRadioButtons
     *            - selectRadio
     * @throws Exception
     */
    public SyllabusHomePage selectAddSyllabusItems(SyllabusHomePageRadioButtons selectRadio)
            throws Exception {
        try {
            switch (selectRadio) {
                case COMPOSE_TEXT_ITEM:
                    frameSwitch.switchToFrameContent();
                    uiDriver.waitToBeDisplayed(selectComposeRadio, waitTime);
                    selectComposeRadio.click();
                    isComposeTextItemSelected = true;
                    break;
                case UPLOAD_MICROSOFT_WORD_DOCUMENT:
                    frameSwitch.switchToFrameContent();
                    uiDriver.waitToBeDisplayed(selectUploadRadio, waitTime);
                    selectUploadRadio.click();
                    isComposeTextItemSelected = false;
                    break;
            }

        } catch (Exception e) {
            throw new Exception("Unable to select Add Syllabus Itemss" + e.getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method for clickAddButton after selecting compose item checkbox
     * 
     * @author suchi.singh
     * @return Object
     * @throws Exception
     */
    public Object clickAddButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Add Button is clicked");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(clickAddButton, waitTime);
            clickAddButton.click();
            uiDriver.getUIAlert().acceptAlertIfPresent();
            if (isComposeTextItemSelected) {
                return new AddSyllabusPage(uiDriver);
            }
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN ClICKING ON 'Add  Button'" + "\n METHOD: clickAddButton \n" + e
                            .getLocalizedMessage());
        }
        return new UploadSyllabusPage(uiDriver);
    }

    /**
     * Method for getHeaderTitle
     * 
     * @author suchi.singh
     * @return String - headertitle
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        String headerTitle = null;
        try {
            logInstruction("LOG INSTRUCTION: HEADER TITLE IS GOT");
            frameSwitch.switchToFrameContent();
            // changed
            headerTitle = msgHeaderTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Header Title'" + "\n METHOD: getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return headerTitle;
    }

    /**
     * Method for getSampleSyllabusTitle
     * 
     * @author suchi.singh
     * @return String - syllabus title
     * @throws Exception
     */
    public String getSampleSyllabusTitle() throws Exception {
        String sampleSyllabusTitle = null;
        try {
            logInstruction("LOG INSTRUCTION: SAMPLE SYLLABUS TITLE IS GOT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgSampleSyllabusTitle, waitTime);
            sampleSyllabusTitle = msgSampleSyllabusTitle.getText();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Sample Syllabus Title'" + "\n METHOD: getSampleSyllabusTitle \n" + e
                            .getLocalizedMessage());
        }
        return sampleSyllabusTitle;
    }

    /**
     * Method for getSampleSyllabusContent
     * 
     * @author suchi.singh
     * @return String - syllabuscontent
     * @throws Exception
     */
    public String getSampleSyllabusContent() throws Exception {
        String sampleSyllabusContent = null;
        try {
            logInstruction("LOG INSTRUCTION:  SAMPLE SYLLABUS CONTENT IS GOT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgSampleSyllabusContentText, waitTime);
            uiDriver.waitToBeDisplayed(imgSampleSyllabusContent, waitTime);
            sampleSyllabusContent = msgSampleSyllabusContentText.getText() + imgSampleSyllabusContent
                    .getAttribute("alt");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Sample Syllabus Content'" + "\n METHOD: getSampleSyllabusContent \n" + e
                            .getLocalizedMessage());
        }
        return sampleSyllabusContent;
    }

    /**
     * This method checks whether alert is present or not
     * 
     * @return boolean
     * @author ashish.juyal
     */
    public boolean isAlert() {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING TO ALERT");
            uiDriver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * Gets page heading
     * 
     * @return String - heading
     * @throws Exception
     * @author Kapil
     */
    public String getPageHeading() throws Exception {
        String heading = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING PAGE HEADING ");

            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgPageHeading, waitTime);
            heading = msgPageHeading.getText();

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Page Heading'" + "\n METHOD: getPageHeading \n" + e
                            .getLocalizedMessage());
        }
        return heading;
    }

    /**
     * This function will check whether Professor Image is visible/Available or not
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isProfImageVisible() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:PROF IMAGE IS VISIBLE ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(imgVisible, waitTime);
            if (imgVisible.isDisplayed())
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING ON 'Prof Image Visible '" + "\n METHOD: isProfImageVisible \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method get radio Button Label Compose Text
     * 
     * @param String
     *            - chocidforLeftOrRightLabelMsg
     * @author soundarya.B
     * @return String - msg
     * @throws Exception
     */
    public String getRadioButtonLabelComposeTextMsg() throws Exception {
        String msg = null;
        try {
            logInstruction("LOG INSTRUCTION: RADIO BUTTON LABEL COMPOSE TEXT ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblComposeText, waitTime);
            // changed
            msg = lblComposeText.getText().trim();
            logInstruction("LOG INSTRUCTION: sucsussfuly radio Button Label Compose Text ");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Radio Button Label Compose Text Msg'" + "\n METHOD: getRadioButtonLabelComposeTextMsg \n" + e
                            .getLocalizedMessage());
        }
        return msg;
    }

    /**
     * Method get radio Button Label Microsoft Msg
     * 
     * 
     * @author soundarya.B
     * @return String - msg
     * @throws Exception
     */
    public String getRadioButtonLabelMicrosoftMsg() throws Exception {
        String msg = null;
        try {
            logInstruction("LOG INSTRUCTION: RADIO BUTTON LABEL  MICROSOFT MSG");
            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(lblMicrosoftMsg, waitTime);
            msg = lblMicrosoftMsg.getText().trim();
            logInstruction("LOG INSTRUCTION: sucsussfuly radio Button Label  Microsoft Msg");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Radio Button Label Microsoft Msg'" + "\n METHOD: getRadioButtonLabelMicrosoftMsg \n" + e
                            .getLocalizedMessage());
        }
        return msg;
    }

    /**
     * Method check Compose Text Item is selected
     * 
     * @author soundarya.B
     * @return boolean
     * @throws Exception
     */
    public boolean isComposeTextItemRadioButtonSelected() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECK COMPOSE TEXT ITEM IS SELECTED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(radCourseItem, waitTime);
            flag = radCourseItem.isSelected();
            logInstruction("LOG INSTRUCTION: sucsussfuly check Compose Text Item is selected");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN SELECTING'Compose Text Item Radio Button Selected'" + "\n METHOD: isComposeTextItemRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method for check course item radio button is displayed
     * 
     * @author soundarya.B
     * @return boolean
     * @throws Exception
     */
    public boolean isCourseItemRadioButtonDisplayed() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECK UPLOADED MSWORD DOCUMENT RADIOBUTTONDISPLAYED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(radCourseItem, waitTime);
            if (radCourseItem.isDisplayed())
                flag = true;
            logInstruction("LOG INSTRUCTION: sucsussfuly Uploaded MSWord Document RadioButtonDisplayed");

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING ON 'Course Item Radio Button Displayed'" + "\n METHOD: isCourseItemRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method for check Uploaded MSWord Document RadioButtonDisplayed
     * 
     * @author soundarya.B
     * @return boolean
     * @throws Exception
     */
    public boolean isUploadedMSWordDocumentRadioButtonDisplayed() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECK UPLOADED MSWORD DOCUMENT RADIOBUTTONDISPLAYED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(radMsWordDocument, waitTime);
            if (radMsWordDocument.isDisplayed())
                flag = true;
            logInstruction("LOG INSTRUCTION: sucsussfuly Uploaded MSWord Document RadioButtonDisplayed");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING ON 'Uploaded MSWord Document Radio Button Displayed'" + "\n METHOD: isUploadedMSWordDocumentRadioButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method for get syllabus Item Table Column count
     * 
     * @author soundarya.B
     * @return List <WebElement>
     * @throws Exception
     */

    public List<WebElement> getsyllabusItemTableColoumns() throws Exception {
        List<WebElement> count;
        logInstruction("LOG INSTRUCTION:  GET SYLLABUS ITEM TABLE ELEMENTS HEADDING ");
        try {

            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgSyllabusItemColoumnCount, waitTime);
            count = msgSyllabusItemColoumnCount.findElements(By.tagName("th"));
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY GET SYLLABUS ITEM TABLE ELEMENTS HEADDING");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'syllabus Item Table Coloumns'" + "\n METHOD: getsyllabusItemTableColoumns \n" + e
                            .getLocalizedMessage());
        }
        return count;
    }

    /**
     * Method for get syllabus Item Table order Heading
     * 
     * @param String
     *            - heading
     * @author soundarya.B
     * @return String
     * @throws Exception
     */
    public String getsyllabusItemTableOrderHeadding() throws Exception {
        String syllabusItemheading = null;

        try {
            logInstruction("LOG INSTRUCTION:  get syllabus Item Table order Headding  ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgSyllabusTableOrderColoumHeadding, waitTime);

            syllabusItemheading = msgSyllabusTableOrderColoumHeadding.getText().trim();
            logInstruction("LOG INSTRUCTION: sucussfully get syllabus Item Table order Headding ");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Syllabus Item Table Order Headding'" + "\n METHOD: getsyllabusItemTableOrderHeadding \n" + e
                            .getLocalizedMessage());
        }
        return syllabusItemheading;
    }

    /**
     * Method for get syllabus Item Table SyllabusItems Heading
     * 
     * 
     * 
     * @author soundarya.B
     * @return String
     * @throws Exception
     */
    public String getSyllabusTableSyllabusItemsColoumHeadding() throws Exception {
        String syllabusItemheading = null;
        logInstruction("LOG INSTRUCTION:  GET SYLLABUS ITEM TABLE SYLLABUSITEMS HEADDING ");
        try {

            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(msgSyllabusTableSyllabusItemsColoumHeadding, waitTime);
            syllabusItemheading = msgSyllabusTableSyllabusItemsColoumHeadding.getText().trim();
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY GET SYLLABUS ITEM TABLE SYLLABUSITEMS HEADDING ");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Syllabus Table Syllabus Items Coloum Headding'" + "\n METHOD: getSyllabusTableSyllabusItemsColoumHeadding \n" + e
                            .getLocalizedMessage());
        }
        return syllabusItemheading;
    }

    /**
     * Method for get convesation fail msg
     * 
     * 
     * @author soundarya.B
     * @return String
     * @throws Exception
     */
    public String getConvesationFailMsg() throws Exception {
        String convesationMsg = null;
        String text[];
        try {
            logInstruction("LOG INSTRUCTION:  GET CONVESATION FAIL MSG  ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgCoversationFailMessage, waitTime);
            convesationMsg = msgCoversationFailMessage.getText();
            text = convesationMsg.split("Syllabus - Microsoft Word Upload ");
            text[1] = text[1].trim();
            logInstruction("LOG INSTRUCTION: sucussfully get convesation fail msg ");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  ' Convesation Fail Msg'" + "\n METHOD: getConvesationFailMsg \n" + e
                            .getLocalizedMessage());
        }
        return text[1];
    }

    /**
     * Method for get syllabus Item Table Delete Heading
     * 
     * 
     * 
     * @author soundarya.B
     * @return String
     * @throws Exception
     */
    public String getSyllabusTableDeleteColoumHeadding() throws Exception {
        String syllabusItemheading = null;
        logInstruction("LOG INSTRUCTION:  GET SYLLABUS ITEM TABLE DELETE HEADDING ");
        try {

            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(msgSyllabusTableDeleteColoumHeadding, waitTime);

            syllabusItemheading = msgSyllabusTableDeleteColoumHeadding.getText().trim();
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY GET SYLLABUS ITEM TABLE ORDER HEADDING ");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Syllabus Table Delete Coloum Headding'" + "\n METHOD: getSyllabusTableDeleteColoumHeadding \n" + e
                            .getLocalizedMessage());
        }
        return syllabusItemheading;
    }

    /**
     * Method for get Sample Syllabus Table Heading
     * 
     * @author soundarya.B
     * @return String - syllabusTableHeading
     * @throws Exception
     */
    public String getSampleSyllabusTableHeading() throws Exception {
        String syllabusTableHeading;
        try {
            logInstruction("LOG INSTRUCTION: GET SAMPLE SYLLABUS TABLE HEADING");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgSampleSyllabusTableHeading, waitTime);
            syllabusTableHeading = msgSampleSyllabusTableHeading.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Sample Syllabus Table Heading'" + "\n METHOD: getSampleSyllabusTableHeading \n" + e
                            .getLocalizedMessage());
        }
        return syllabusTableHeading;
    }

    /**
     * Method for get Uploaded MSWord Document Caption
     * 
     * 
     * @author soundarya.B
     * @return String - mswordCaption
     * @throws Exception
     */
    public String getUploadedMSWordDocumentradioCaption() throws Exception {
        String mswordCaption;
        try {
            logInstruction("LOG INSTRUCTION: GET UPLOADED MSWORD DOCUMENT CAPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgUploadMsWord, waitTime);
            mswordCaption = msgUploadMsWord.getAttribute("value");
            logInstruction("LOG INSTRUCTION: sucussfully get Uploaded MSWord Document Caption");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Uploaded MSWord Document Radio Caption'" + "\n METHOD: getUploadedMSWordDocumentradioCaption \n" + e
                            .getLocalizedMessage());
        }
        return mswordCaption;
    }

    /**
     * Method check is Syllabus Microsoft WordUpload Is A link
     * 
     * 
     * @author soundarya.B
     * @return String - mswordLink
     * @throws Exception
     */
    public String isSyllabusMicrosoftWordUploadIsAlink() throws Exception {
        String mswordLink = null;
        try {
            logInstruction("LOG INSTRUCTION: check is Syllabus Microsoft WordUpload Is A link");
            frameSwitch.switchToFrameContent();
            // uiDriver.waitToBeDisplayed(syllabusMicrosoftWordUploadlink, waitTime);
            if (lnkSyllabusMicrosoftWordUpload.isDisplayedAfterWaiting())
                mswordLink = lnkSyllabusMicrosoftWordUpload.getAttribute("href");
            logInstruction("LOG INSTRUCTION: sucussfully  Method check is Syllabus Microsoft WordUpload Is A link");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Syllabus Microsoft WordUpload Is A link'" + "\n METHOD: isSyllabusMicrosoftWordUploadIsAlink \n" + e
                            .getLocalizedMessage());
        }
        return mswordLink;
    }

    /**
     * Method for get caption for add button
     * 
     * @author soundarya.B
     * @return String - captionAdd
     * @throws Exception
     */
    public String getCaptionAddItem() throws Exception {
        String captionAdd;
        try {
            logInstruction("LOG INSTRUCTION: GETCAPTION FOR ADD BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAdd, waitTime);
            captionAdd = btnAdd.getAttribute("value").trim();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Caption Add Item'" + "\n METHOD: getCaptionAddItem \n" + e
                            .getLocalizedMessage());
        }
        return captionAdd;
    }

    /**
     * Method for check add button displayed
     * 
     * @author soundarya.B
     * @return boolean
     * @throws Exception
     */
    public boolean isAddbuttondisplayed() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECK ADD BUTTON DISPLAYED");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAdd, waitTime);
            flag = btnAdd.isDisplayed();
            logInstruction("LOG INSTRUCTION: sucussfully check add button displayed");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Add Button Displayed'" + "\n METHOD: isAddbuttondisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to check is Sample Syllabus Img Displayed
     * 
     * @author soundarya.B
     * @throws Exception
     * @return boolean
     */
    public boolean isSampleSyllabusImgDisplayed() throws Exception {

        logInstruction("LOG INSTRUCTION: CHECK IS SAMPLE SYLLABUS IMG DISPLAYED");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(imgSyllabus, waitTime);
            if (imgSyllabus.isDisplayed())
                flag = true;
            logInstruction("LOG INSTRUCTION: sucussfully check is Sample Syllabus Img Displayed");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Sample Syllabus Img Displayed'" + "\n METHOD: isSampleSyllabusImgDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to check Textbox Associated with Syllabus Items
     * 
     * @author soundarya.B.
     * @throws Exception
     * @Param String - Filename
     * @return boolean
     */
    public boolean isTextboxAssociatedwithSyllabusItems(String FileName) throws Exception {

        logInstruction("LOG INSTRUCTION: CHECK TEXTBOX ASSOCIATED WITH SYLLABUS ITEMS");
        try {
            frameSwitch.switchToFrameContent();
            txtAssociatedSyllabusItem.replaceValues(FileName);
            uiDriver.waitToBeDisplayed(txtAssociatedSyllabusItem, waitTime);
            if (txtAssociatedSyllabusItem.isDisplayed())
                flag = true;
            logInstruction("LOG INSTRUCTION: sucussfully check Textbox Associated with Syllabus Items");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Text Box Associated with Syllabus Items'" + "\n METHOD: isTextboxAssociatedwithSyllabusItems \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to get the Instructional Text
     * 
     * @author soundarya.B
     * @throws Exception
     * @return String - instructionText
     */
    public String getInstructionalText() throws Exception {
        String instructionText = null;
        logInstruction("LOG INSTRUCTION: GET THE INSTRUCTIONAL TEXT ");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgInstructorMessage, waitTime);
            instructionText = msgInstructorMessage.getText().trim();
            logInstruction("LOG INSTRUCTION: sucussfully get the Instructional Text ");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Instructional Text'" + "\n METHOD: getInstructionalText \n" + e
                            .getLocalizedMessage());
        }
        return instructionText;
    }

    /**
     * This method helps to check is Instructor Information link is displayed
     * 
     * @author soundarya.B
     * @throws Exception
     * @return boolean
     */
    public boolean isInformationlinkIsDisplayed() throws Exception {

        logInstruction("LOG INSTRUCTION: IS ISTRUCTOR INFORMATION LIN IS DISPLAYED");
        try {
            frameSwitch.switchToFrameContent();
            if (lnkInstructoInformation.isDisplayedAfterWaiting())
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Information link Is Displayed'" + "\n METHOD: isInformationlinkIsDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to check is Added Syllabus Items Are Links
     * 
     * @param String
     *            - itemName
     * @author soundarya.B
     * @throws Exception
     * @return boolean - addedSyllabusItemsLinks
     */
    public boolean isAddedSyllabusItemsAreLinks(String itemName) throws Exception {

        logInstruction("LOG INSTRUCTION: CHECK IS ADDED SYLLABUS ITEMS ARE LINKS");
        try {
            frameSwitch.switchToFrameContent();
            lnkAddedSyllabusItem.replaceValues(itemName);
            uiDriver.waitToBeDisplayed(lnkAddedSyllabusItem, waitTime);
            // changed
            if (lnkAddedSyllabusItem.isDisplayedAfterWaiting())
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Added Syllabus Items Are Links'" + "\n METHOD: isAddedSyllabusItemsAreLinks \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to check delete link is displayed
     * 
     * @author soundarya.B
     * @param String
     *            - syllabusItemname
     * @throws Exception
     * @return boolean
     */
    public boolean isDeleteLinkDisplayed(String syllabusItemname) throws Exception {
        logInstruction("LOG INSTRUCTION: DELETE LINK IS DISPLAYED");

        try {
            frameSwitch.switchToFrameContent();
            imgDeleteIcon.replaceValues(syllabusItemname);
            // changed
            if (imgDeleteIcon.isDisplayedAfterWaiting())
                flag = true;
            logInstruction("LOG INSTRUCTION: SUCUSSFULLY DELETE LINK IS DISPLAYED");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Delete Link Displayed'" + "\n METHOD: isDeleteLinkDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * this method helps to is SaveOrder Button Displayed
     * 
     * @throws Exception
     * @author soundarya.B
     * @return boolean
     */
    public boolean isSaveOrderButtonDisplayed() throws Exception {

        logInstruction("LOG INSTRUCTION: check the order button is displayed");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSave, waitTime);
            if (btnSave.isDisplayed())
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Save Order Button Displayed'" + "\n METHOD: isSaveOrderButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    // /**
    // * This method helps to check file exist
    // *
    // * @param String
    // * - filename
    // * @throws Exception
    // * @author Soundarya.B
    // * @return boolean
    // */
    // public boolean isFileExist(String filename) throws Exception {
    // boolean fileExist = false;
    // logInstruction("LOG INSTRUCTION: check the order button is displayed");
    // try {
    // frameSwitch.switchToFrameContent();
    // fileNameExistcheckMsg.replaceValues(filename);
    // if (fileNameExistcheckMsg.isDisplayed())
    // fileExist = true;
    // } catch (Exception e) {
    // throw new Exception("unable check the order button is displayed" + e
    // .getLocalizedMessage());
    // }
    // return fileExist;
    // }

    /**
     * This method helps to get the order number corresponding to the syllabus item name
     * 
     * @param String
     *            syllabusItemName
     * @author ashish.juyal
     * @return String - ordernumber
     * @throws Exception
     */

    public String getOrderNumber(String syllabusItemName) throws Exception {
        String orno = null;
        try {

            // changed orderno
            logInstruction("LOG INSTRUCTION: GETTING THE ORDER NO");
            frameSwitch.switchToFrameContent();
            msgOrderNo.replaceValues(syllabusItemName);
            uiDriver.waitToBeDisplayed(msgOrderNo, waitTime);
            orno = msgOrderNo.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Order Number'" + "\n METHOD: getOrderNumber \n" + e
                            .getLocalizedMessage());
        }
        return orno;
    }

    /**
     * This method helps to enter the order no corresponding the syllabus item name
     * 
     * @param String
     *            - syllabusItemName
     * @param String
     *            - ordernumber
     * @author ashish.juyal
     * @return SyllabusHomePage
     * @throws Exception
     */

    public SyllabusHomePage enterOrderNo(String syllabusItemName, String enterordeno)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE ORDER NO");
            frameSwitch.switchToFrameContent();
            msgOrderNo.replaceValues(syllabusItemName);
            uiDriver.waitToBeDisplayed(msgOrderNo, waitTime);
            msgOrderNo.sendKeys(Keys.CONTROL + "a");
            msgOrderNo.sendKeys(Keys.DELETE);
            msgOrderNo.sendKeys(enterordeno);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN ENTERING  'Order Number'" + "\n METHOD: enterOrderNo \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click the save button
     * 
     * @author soundarya.B
     * @return String
     * @throws Exception
     * @param String
     *            - syllabusItemName
     */
    public String getOrderOfTheSyllabusItems(String syllabusItemName) throws Exception {
        String orno = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE ORDER NO");
            frameSwitch.switchToFrameContent();
            msgSyllabusOrderNumber.replaceValues(syllabusItemName);
            // uiDriver.waitToBeDisplayed(orderno, waitTime);
            if (msgSyllabusOrderNumber.isDisplayedAfterWaiting()) {
                orno = msgSyllabusOrderNumber.getAttribute("value");
            }
            logInstruction("LOG INSTRUCTION:  sucussfully Getting the order no");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Order Of The Syllabus Items'" + "\n METHOD: getOrderOfTheSyllabusItems \n" + e
                            .getLocalizedMessage());
        }
        return orno;
    }

    /**
     * This method helps to click the save button
     * 
     * @author ashish.juyal
     * @throws Exception
     * @return SyllabusHomePage
     */
    public SyllabusHomePage clickSaveButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSave, waitTime);
            btnSave.click();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Save Button'" + "\n METHOD: clickSaveButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method clicks the alert box
     * 
     * @author ashish.juyal
     **/

    public void clickAlert() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE ALERT MESSAGE");
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CLICKING ON 'clickAlert'" + "\n METHOD: clickAlert \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This methods get the inline message after clicking the upload and convert file
     * 
     * @return String - infomesgtext
     * @author ashish.juyal
     * @throws Exception
     */

    public String getInformationMessage() throws Exception {
        String text = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING INLINE MESSAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgInline, waitTime);
            text = msgInline.getText();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Information Message'" + "\n METHOD: getInformationMessage \n" + e
                            .getLocalizedMessage());
        }
        return text;
    }

    /**
     * This Method will check content of the Uploaded file and verify uploaded file and shown file
     * are Same or not.
     * 
     * @param Data
     *            First Line of the content of the file which you have uploaded.
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isUploadedFileIsSame(String Data) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECKING FILE WHEATHER THEY ARE SAME OR NOT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkCheckUploadFile, waitTime);
            if (lnkCheckUploadFile.getText().contains(Data))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING  'Uploaded File Is Same'" + "\n METHOD: isUploadedFileIsSame \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will check if there are @ Radio buttons are Present or not on Syllabus HomePage
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isRadioButtonPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECKING ISRADIOBUTTONPRESENT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(radCompose, waitTime);
            uiDriver.waitToBeDisplayed(radUpload, waitTime);
            if (radCompose.isDisplayed() && radUpload.isDisplayed())
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING  'Radio Button Present'" + "\n METHOD: isRadioButtonPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will return the Caption of Compose text Item Radio Button
     * 
     * @return String - caption
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public String getCaptionOFComposeRadioBtn() throws Exception {
        String caption = null;

        try {
            logInstruction("LOG INSTRUCTION: GETTING CAPTION OF COMPOSE RADIO BTN");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblComposeText, waitTime);
            caption = lblComposeText.getText();

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING 'Caption OF Compose Radio Btn'" + "\n METHOD: getCaptionOFComposeRadioBtn \n" + e
                            .getLocalizedMessage());
        }
        return caption;
    }

    /**
     * This Method will Return Caption Of upload MicroSoft Word Doc radio Button
     * 
     * @return String - caption
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public String getCaptionOFUploadMicrosoftWordDoc() throws Exception {
        String caption = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING CAPTIONOFUPLOADMICROSOFTWORDDOC");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblUploadCaption, waitTime);
            caption = lblUploadCaption.getText();

        } catch (Exception e) {

            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING 'Caption OF Upload Micros of Word Doc'" + "\n METHOD: getCaptionOFUploadMicrosoftWordDoc \n" + e
                            .getLocalizedMessage());
        }
        return caption;
    }

    /**
     * This Method will give you the Caption Of Add button On Syllabus Home Page
     * 
     * @return String - caption
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getAddBtnCaption() throws Exception {
        String caption = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING ADD BTN CAPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAdd, waitTime);
            caption = btnAdd.getValue();

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING 'Add Btn Caption'" + "\n METHOD: getAddBtnCaption \n" + e
                            .getLocalizedMessage());
        }
        return caption;
    }

    /**
     * verify if add button is present
     * 
     * @return boolean
     * @throws Exception
     * @author Kapil
     */
    public boolean isAddButtonPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECKING ADD BUTTON PRESENT ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAdd, waitTime);
            if (btnAdd.isDisplayed())
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING 'Add Button Present'" + "\n METHOD: isAddButtonPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will check if there are 3 Coloum table is available or not.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isThreeColoumnTablePresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: GETTING COUNT OF COLOUMN TABLE");

            frameSwitch.switchToFrameContent();
            List<UIElement> element = msgVerifyColoumn.getUIElementsList();
            int size = element.size();
            if (size == 3)
                flag = true;
            else
                flag = false;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING 'Three Coloumn Table Present'" + "\n METHOD: isThreeColoumnTablePresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method will check if table has Order, Syllabus item, Delete coloumns Or not.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isTableHeadingPresent() throws Exception {
        String data = null;

        try {
            logInstruction("LOG INSTRUCTION: GETTING TABLE HEADING");

            frameSwitch.switchToFrameContent();
            List<UIElement> element = msgVerifyColoumn.getUIElementsList();
            for (UIElement ele : element) {
                uiDriver.waitToBeDisplayed(ele, waitTime);
                data = data + " " + ele.getText();

            }
            if (data.trim().contains("Order Syllabus Items Delete"))
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING 'Table Heading Present'" + "\n METHOD: isTableHeadingPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method check whether the order column is displayed or not
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public boolean isOrderColumnDisplayed() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE ORDER COLUMN");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgOrderColumn, waitTime);
            flag = msgOrderColumn.isDisplayed();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN CHECKING 'Order Column Displayed'" + "\n METHOD: isOrderColumnDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This methods gets the alert message
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public String getAlertMessage() throws Exception {
        String alertmessage = null;
        String textmessag = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE ALERT MESSAGE");
            alertmessage = uiDriver.switchTo().alert().getText();
            String[] trim = alertmessage.split(":");
            textmessag = trim[1];
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN GETTING 'AlertMessage'" + "\n METHOD: getAlertMessage \n" + e
                            .getLocalizedMessage());
        }
        return textmessag;
    }

    /**
     * This method helps to remove the number from the order no text box
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public SyllabusHomePage removeOrderNoFromTextBox(String syllabusItemName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE ORDER NO");
            frameSwitch.switchToFrameContent();
            msgOrderNo.replaceValues(syllabusItemName);
            uiDriver.waitToBeDisplayed(msgOrderNo, waitTime);
            msgOrderNo.sendKeys(Keys.CONTROL + "a");
            msgOrderNo.sendKeys(Keys.DELETE);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:ISSUE IN ENTERING OR REMOVEING 'Text In TextBox'" + "\n METHOD: removeOrderNoFromTextBox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

/**
     * This Method Returns the Syllabus Content Item List of Entries with LSAuto Prefix and Time Stamp Range Specified
     * 
     * @param 
     * @return
     * @throws Exception
     * @author Raghav S
     */
      public List<String> getSyllabusContentList() throws Exception {
		 List<String> syllabuscontentlist = new ArrayList<String>();
		try {
			logInstruction("LOGINSTRUCTION:GETTING SYLLABUS CONTENT LIST OF ENTRIES");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = lblSyllabuslist.getUIElementsList();
			for (int i = 0; i < elements.size(); i++) {
				if (StringUtils.isNotBlank(elements.get(i).getText())
				 && (elements.get(i).getText().trim().contains("LSAutoTest"))&& (cleanup.verifyOnedayTimeStamp(elements.get(i).getText().trim()))
) {
	
			syllabuscontentlist.add(elements.get(i).getText().trim());
				}
			}
		
		} catch (Exception e) {
			throw new Exception("ISSUE IN  GETTING 'syllabus' CONTENT ENTRIES"
					+ "\n METHOD:getSyllabusContentList \n"
					+ e.getLocalizedMessage());
		}

		return syllabuscontentlist;

	}
    

      /**
       * Method helps to verify Whether Syllabus Content Items are Present or not
       * 
       * @author Raghav
       * @return boolean
       * @throws Exception
       */
  	
  	
  	public boolean isSyllabusContentItemDeleted(String syllabusItemname) throws Exception
  	{
  		try{
  			logInstruction("LOGINSTRUCTION:VERIFYING SYLLABUS CONTENT ITEM IS PRESENT");
  			frameSwitch.switchToFrameContent();
  			syllabusContentItem.replaceValues(syllabusItemname);
  			return syllabusContentItem.isDisplayedAfterWaiting(waitTime);
  			
  		}catch(Exception e){
  			throw new Exception("ISSUE IN VERIFYING THE 'syllabus' ITEM NAME"+"\nMETHOD:isSyllabusContentItemDeleted\n"+e.getLocalizedMessage());
  			
  		}
  	}
    
}
