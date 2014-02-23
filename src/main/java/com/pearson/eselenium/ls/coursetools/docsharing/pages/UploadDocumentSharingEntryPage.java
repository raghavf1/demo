package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import java.io.File;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.eselenium.utils.FileIOUtils;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to UploadDocumentSharingEntry page
 * 
 * @author Usha
 * 
 */
public class UploadDocumentSharingEntryPage extends BasePageObject {

    /* UIElement declarations for the UploadDocumentSharingEntry page */

    private UIElement txtOwner = createElement(UIType.Css, "input#SubmitterDisplayName");
    private UIElement btnBrowse = createElement(UIType.ID, "dotNExTFile");
    private UIElement txtinlineError = createElement(UIType.Css, ".inlineerror");
    private UIElement txtinfoMessage = createElement(UIType.Css, ".inlinemessage2");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement chkUnzip = createElement(UIType.ID, "unzipFile");
    private UIElement btnUploadDocument = createElement(UIType.Css, "#btnUpload");
    private UIElement radInstructorOnly = createElement(
            UIType.Xpath,
            "//fieldset[label[contains(text(),'{1}')]]//input[1]");
    private UIElement radEntireClass = createElement(
            UIType.Xpath,
            "//fieldset[label[contains(text(),'{1}')]]//input[2]");
    private UIElement btnAddEntry = createElement(UIType.Css, "#AddEntry");
    private UIElement txtDescription = createElement(UIType.Css, "input[type='text']");
    private UIElement lbltxtpresent = createElement(UIType.Xpath, "//th[contains(text(),'{1}')]");
    private UIElement lblfilepresent = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]");
    private UIElement txtinstruction = createElement(
            UIType.Xpath,
            "//td[contains(text(),'Indicates')]");
    private UIElement txtDescriptionForFile = createElement(
            UIType.Xpath,
            "//td[label[contains(text(),'{1}')]]/following-sibling::td/input");
    private UIElement lblTitle = createElement(UIType.Css, ".tablehead");
    
    /* Variables*/
    
    private String strFileName;
    private String strOwner = "";
    private String strBrowser;
    private String strErrorMessage = "";
    private String strInfoMessage = "";
    private String strTitle = "";
    boolean flag = false;


    /* Constructor */
    public UploadDocumentSharingEntryPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## UploadDocumentSharingEntryPage ##");

    }

    /**
     * @author saurabh.jain1
     * @return
     * @throws Exception
     *             This method is for clicking Cancel button
     */

    public DocSharingPage clickCancelButton() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING CANCEL BUTTON" + "\nMETHOD:clickCancelButton\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * @author saurabh.jain1
     * @return
     * @throws Exception
     *             This method is for select the unzip checkbox.
     */
    public UploadDocumentSharingEntryPage selectUnzipCheckBox() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: SELECT THE UNZIP CHECKBOX");
            uiDriver.waitToBeDisplayed(chkUnzip, waitTime);
            chkUnzip.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'unzip' CHECKBOX" + "\nMETHOD:selectUnzipCheckBox\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method is used to click on upload document button
     * 
     * @author Pratush.Manglik
     * @return UploadDocumentSharingEntryPage
     * @throws Exception
     */
    public UploadDocumentSharingEntryPage clickUploadDocumentButton() throws Exception {

        logInstruction("LOG INSTRUCTION:CLICK ON UPLOAD DOCUMENT");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUploadDocument, waitTime);
            btnUploadDocument.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'upload' DOCUMENT" + "\nMETHOD:clickUploadDocumentButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to select the radio button
     * 
     * @author ganapati.bhat
     * @param option
     */

    public UploadDocumentSharingEntryPage selectShareFileWithOption(String option) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT THE OPTION TO SHARE");
            frameSwitch.switchToFrameContent();

            if (option.contains("Instructor")) {
                radInstructorOnly.replaceValues(option);
                uiDriver.waitToBeDisplayed(radInstructorOnly, waitTime);
                radInstructorOnly.clickAndWait(waitTime);

            } else
                if (option.contains("Entire")) {
                    radEntireClass.replaceValues(option);
                    uiDriver.waitToBeDisplayed(radEntireClass, waitTime);
                    radEntireClass.clickAndWait(waitTime);
                    logInstruction("LOG INSTRUCTION: Entire class radio button selected");
                }

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    "ISSUE IN SELECTING THE OPTION" + "\nMETHOD:selectShareFileWithOption\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @author usha method help to get Owner
     * @return
     * @throws Exception
     */
    public String getOwner() throws Exception {
       

        try {
            logInstruction("LOG INSTRUCTION: GETTING THE OWNER NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtOwner, waitTime);
            strOwner = txtOwner.getValue().trim();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE OWNER NAME" + "\nMETHOD:getOwner\n" + e
                    .getLocalizedMessage());
        }
        return strOwner;
    }

    /**
     * @author usha ,Method helps to enter Owner text
     * @param text
     * @return
     * @throws Exception
     */

    public UploadDocumentSharingEntryPage enterOwner(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING THE OWNER NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtOwner, waitTime);
            txtOwner.clearAndSendKeys(text);

        } catch (Exception e) {
            throw new Exception("ISSUE IN ENTERING THE 'owner' NAME" + "\nMETHOD:enterOwner\n" + e
                    .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method is used to click on browse button
     * 
     * @author monica.anand
     * @param path
     * @return UploadDocumentSharingEntryPage
     * @throws Exception
     */

    public UploadDocumentSharingEntryPage clickBrowseButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON BROWSE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
            if (getBrowser().equals(Browser.CHROME)) {
                btnBrowse.clickAndWait(waitTime);
            } else
                if (getBrowser().equals(Browser.FIREFOX)) {
                    btnBrowse.clickAndWait(waitTime);
                }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'browse' BUTTON" + "\nMETHOD:clickBrowseButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on browse button
     * 
     * @author monica.anand
     * @param path
     * @return UploadDocumentSharingEntryPage
     * @throws Exception
     */
    public UploadDocumentSharingEntryPage clickBrowseButton(String absoluteFilePath)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON BROWSE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
            btnBrowse.sendKeysToFileInput(absoluteFilePath);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'browse' BUTTON" + "\nMETHOD:clickBrowseButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to get the in line error message
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     */
    public String getErrorMessage() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE ERROR MESSAGE ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtinlineError, waitTime);
            strErrorMessage = txtinlineError.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'error' MESSAGE" + "\nMETHOD:getErrorMessage\n" + e
                            .getLocalizedMessage());
        }
        return strErrorMessage;
    }

    /**
     * This method is used to get the info
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     */
    public String getInfo() throws Exception {
      
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE INFO ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtinfoMessage, waitTime);
            strInfoMessage = txtinfoMessage.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'info'" + "\nMETHOD:getInfo\n" + e
                    .getLocalizedMessage());
        }
        return strInfoMessage;
    }

    /**
     * This method is used to return the title
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     */

    public String getHeaderTitle() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblTitle, waitTime);
            strTitle = lblTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'header' TITLE" + "\nMETHOD:getHeaderTitle\n" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * This method is used to click on AddEntry button
     * 
     * @author chaitali
     * @return DocSharingPage
     * @throws Exception
     */

    public DocSharingPage clickAddEntryButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON ADD ENTRY BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAddEntry, waitTime);
            btnAddEntry.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'add entry' BUTTON" + "\nMETHOD:clickAddEntryButton\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * This method is used to enter description
     * 
     * @author chaitali
     * @param String
     *            :Description to be written
     * @return UploadDocumentSharingEntryPage
     * @throws Exception
     */

    public UploadDocumentSharingEntryPage enterDescription(String desc) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENETERING THE DESCRIPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtDescription, waitTime);
            txtDescription.clearAndSendKeys(desc);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE 'description'" + "\nMETHOD:enterDescription\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to Verify whether a Radio Button is Present or not
     * 
     * @author Raghav S
     * @param option
     */

    public boolean isselectShareFileWithOptionRadioButtonPresent(String option) throws Exception {
    	
        
        try {
            logInstruction("LOG INSTRUCTION:VERFIYING THE RADIO BUTTON");
            frameSwitch.switchToFrameContent();

            if (option.contains("Instructor")) {
                radInstructorOnly.replaceValues(option);
                uiDriver.waitToBeDisplayed(radInstructorOnly, waitTime);
                if (radInstructorOnly.isDisplayedAfterWaiting(waitTime)) {
                	flag = true;
                }
            } else
                if (option.contains("Entire")) {
                    radEntireClass.replaceValues(option);
                    uiDriver.waitToBeDisplayed(radEntireClass, waitTime);
                    if (radEntireClass.isDisplayedAfterWaiting(waitTime)) {
                    	flag = true;
                    }
                }

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    "ISSUE IN VERIFYING 'radio' BUTTON" + "\nMETHOD:isselectShareFileWithOptionRadioButtonPresent\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to Verify whether a Radio Button is Present or not
     * 
     * @author Raghav S
     * @param option
     */

    public boolean isselectShareFileWithOptionRadioButtonSelected(String option) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:SELECTING THE RADIO BUTTON");
            frameSwitch.switchToFrameContent();

            if (option.contains("Instructor")) {
                radInstructorOnly.replaceValues(option);
                uiDriver.waitToBeDisplayed(radInstructorOnly, waitTime);
                if (radInstructorOnly.isSelected()) {
                    flag = true;
                }
            } else
                if (option.contains("Entire")) {
                    radEntireClass.replaceValues(option);
                    uiDriver.waitToBeDisplayed(radEntireClass, waitTime);
                    if (radEntireClass.isSelected()) {
                    	flag = true;
                    }
                }

        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception(
                    "ISSUE IN SELECTING THE 'radio BUTTON'" + "\nMETHOD:isselectShareFileWithOptionRadioButtonSelected\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method is used to click on upload document button
     * 
     * @category MileStone2
     * @author Raghav
     * @return UploadDocumentSharingEntryPage
     * @throws Exception
     */
    public boolean isUploadDocumentButtonPresent() throws Exception {

        logInstruction("LOG INSTRUCTION:VERFIYING UPLOAD DOCUMENT");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnUploadDocument, waitTime);
            return btnUploadDocument.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'upload' DOCUMENT" + "\nMETHOD:isUploadDocumentButtonPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method is used to Verify a whether a Label File Name is present or not
     * 
     * @category MileStone2
     * @author Raghav S
     * @return DocSharingPage
     * @throws Exception
     */

    public boolean isTextBoxPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERFIYING TEXTBOX");
            frameSwitch.switchToFrameContent();
            return txtDescription.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN VERFIYING 'textbox' " + "\nMETHOD:isTextBoxPresent\n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * This method is used to Verify a Cancel button is present or not
     * 
     * @category MileStone2
     * @author Raghav S
     * @return DocSharingPage
     * @throws Exception
     */

    public boolean isCancelButtonPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERFIYING CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            return btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'cancel' BUTTON" + "\nMETHOD:isCancelButtonPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method is used to Verify a AddEntry button is present or not
     * 
     * @category MileStone2
     * @author Raghav S
     * @return DocSharingPage
     * @throws Exception
     */

    public boolean isAddEntryButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERFIYING ADD ENTRY BUTTON");
            frameSwitch.switchToFrameContent();
            return btnAddEntry.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'addentry' BUTTON" + "\nMETHOD:isAddEntryButtonPresent\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method is used to Verify a whether a Label File Name is present or not
     * 
     * @category MileStone2
     * @author Raghav S
     * @return DocSharingPage
     * @throws Exception
     */

    public boolean isLabelFileNamePresent(String lblname) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERFIYING FILE LABEL");
            frameSwitch.switchToFrameContent();
            lbltxtpresent.replaceValues(lblname);
            return lbltxtpresent.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'label file' NAME" + "\nMETHOD:isLabelFileNamePresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method is used to Verify a whether a Label Name is present or not This method is used to
     * Verifies the Label of Instructor Only/Enire Class/Find a new File/Unzip/Owner
     * 
     * @param Instructor
     *            Only/Enire Class/Find a new File/Unzip/Owner
     * @category MileStone2
     * @author Raghav S
     * @return DocSharingPage
     * @throws Exception
     */

    public boolean isLabelNamePresent(String lblname) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:VERFIYING LABEL NAME");
            frameSwitch.switchToFrameContent();
            lblfilepresent.replaceValues(lblname);
            return lblfilepresent.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'label name' " + "\nMETHOD:isLabelNamePresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method is used to Verify a whether a Label File Name is present or not
     * 
     * @category MileStone2
     * @author Raghav S
     * @return DocSharingPage
     * @throws Exception
     */

    public boolean isInstrutionalTextPresent() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:VERFIYING INSTRUCTOR TEXT");
            frameSwitch.switchToFrameContent();
            return txtinstruction.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'instructional' TEXT" + "\nMETHOD:isInstrutionalTextPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to verify the instructor only radio button
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */

    public boolean isInstructorOnlyRadioButtonSelected() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING INSTRUCTOR RADIO BUTTON");
            frameSwitch.switchToFrameContent();
            radInstructorOnly.replaceValues("Instructor");
            radInstructorOnly.isDisplayedAfterWaiting(waitTime);
            return radInstructorOnly.isSelected();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'instructor' RADIO BUTTON" + "\nMETHOD:isInstructorOnlyRadioButtonSelected\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to verify the entire class radio button
     * 
     * @category Milestone 2
     * @return:boolean
     * @author:kiran.kumar
     * @throws Exception
     */
    public boolean isEntireClassRadioBtnSelected() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERFIYING ENTIRE CLASS RADIO BUTTON");
            frameSwitch.switchToFrameContent();
            radEntireClass.replaceValues("Entire");
            radEntireClass.isDisplayedAfterWaiting(waitTime);
            return radEntireClass.isSelected();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'entire class' RADIO BUTTON" + "\nMETHOD:isEntireClassRadioBtnSelected\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method to enter description for a file.
     * 
     * @category Milestone 2
     * @return:UploadDocumentSharingEntryPage
     * @author:kiran.kumar
     * @throws Exception
     */
    public UploadDocumentSharingEntryPage enterDescriptionForAFile(
            String filename,
            String description) throws Exception {
        try {

            logInstruction("LOG INSTRUCTION : ENTERING DESRIPTION");
            frameSwitch.switchToFrameContent();
            txtDescriptionForFile.replaceValues(filename);
            txtDescriptionForFile.isDisplayedAfterWaiting(waitTime);
            txtDescriptionForFile.clearAndSendKeys(description);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'description'" + "\nMETHOD:enterDescriptionForAFile\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }
    
    
  
    
    /** This method is helps to enter description and Click on Add Entry Button
     * @ServicelevelMethods
	*	@author Raghav 
     * @return
     * @throws Exception
     *             
     */
    public DocSharingPage enterDescriptionandClickAddEntry(String descriptionValue) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTERING DESC AND CLICK ON ADD ENTRY BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtDescription, waitTime);
            txtDescription.sendKeys(descriptionValue);
            uiDriver.waitToBeDisplayed(btnAddEntry, waitTime);
            btnAddEntry.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING AND CLICKING ON 'addentry' BUTTON" + "\n METHOD:clickAddEntryButton\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }
    
    
    /**
     * This is Handler method to UploadDocumentSharingEntryPage Document to use with Granular
     * Methods
     * 
     * @author Raghav S
     * @param path
     * @param strAction
     * @param strTag
     * @param boolRenameFile
     * @param boolAbsolutePath
     * @return UploadDocumentSharingEntryPage
     * @throws Exception
     */
     public UploadDocumentSharingEntryPage uploadFileHandler(String path,
                   String action, String tag, boolean renameFile) throws Exception {
    	
            try {
                   Browser browser = getBrowser();
                   AutoITMethods autoit = new AutoITMethods();
                   if (browser.equals(Browser.FIREFOX)
                                || browser.equals(Browser.CHROME)) {
                         clickBrowseButton();
                         strFileName= autoit.uploadFile(path, action, tag, renameFile);
                   } else if (browser.equals(Browser.INTERNETEXPLORER)) {
                	   String absolutePath = this.getClass().getResource(path).toString();
                       absolutePath = FileIOUtils.decodeToken(absolutePath.split("file:/")[1]);
                       if (renameFile) {
                           AutoITMethods objAutoITMethods = new AutoITMethods();

                           absolutePath = objAutoITMethods.renameUploadFileName(absolutePath, tag);
                       }
                       absolutePath = absolutePath.replaceAll("/", "\\\\");
                       File file = new File(absolutePath);
                       strFileName = file.getName();
                       clickBrowseButton(absolutePath);
                   } else {
                         throw new Exception("BROWSER IS NOT SUPPORTED");
                   }
            } catch (Exception e) {
                   throw new Exception(
                                "ISSUE IN UPLOAD FILE HANDLER FOR 'Uploading Syllabus Document'"
                                              + "\n METHOD: UploadFile \n"
                                              + e.getLocalizedMessage());
            }
            return this;
     }

     /**
      * Method will return the FileName created in UploadFIleMethod
      * 
      * @author Raghav S
      * @return strFileName
      */
     public String getFileName() {
         return strFileName;
     }
     
     /**
      * This is Service level method to Upload a Doc Sharing Document
      * 
       * @author Raghav
      * @param path
      *            of File
      * @return DocSharingPage
      */
      public DocSharingPage uploadDocSharingFile(String pathOfFile,
                    String action, String tag, boolean renameFile,String description) throws Exception {
             try {
                    Browser browser = getBrowser();
                              
                    AutoITMethods autoit = new AutoITMethods();
                    uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
                    if (browser.equals(Browser.FIREFOX)
                                 || browser.equals(Browser.CHROME)) {
                          btnBrowse.clickAndWait(waitTime);
                          autoit.uploadFile(pathOfFile, action, tag, renameFile);
                    } else if (browser.equals(Browser.INTERNETEXPLORER)) {
                          String absolutePath = this.getClass().getResource(pathOfFile)
                                        .toString();
                          absolutePath = absolutePath.split("file:/")[1];
                          absolutePath = absolutePath.replaceAll("/", "\\\\");
                          btnBrowse.sendKeysToFileInput(absolutePath);
                    } else {
                           throw new Exception("BROWSER IS NOT SUPPORTED");
                    }
                    uiDriver.waitToBeDisplayed(btnUploadDocument, waitTime);
                    btnUploadDocument.clickAndWait(waitTime);
                    uiDriver.waitToBeDisplayed(txtDescription, waitTime);
                    txtDescription.clearAndSendKeys(description);
                    uiDriver.waitToBeDisplayed(btnAddEntry, waitTime);
                    btnAddEntry.clickAndWait(waitTime);
                    
                 
                    logInstruction("LOG INSTRUCTION: DOCUMENT IS SUCCESSFULLY ADDED");
             } catch (Exception e) {
                    throw new Exception(
                                 "ISSUE IN UPLOAD SYLLABUS PAGE SERVICE LEVEL METHOD FOR 'Uploading Syllabus Document'"
                                               + "\n METHOD: uploadDocSharingFile \n"
                                               + e.getLocalizedMessage());
             }
             return new DocSharingPage(uiDriver);
      }
      
      
      

}
