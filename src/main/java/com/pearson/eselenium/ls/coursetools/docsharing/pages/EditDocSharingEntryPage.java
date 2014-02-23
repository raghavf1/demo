package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import java.io.File;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.eselenium.utils.FileIOUtils;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains the method related to EditDocSharingEntryPage
 * 
 * @author saurabh.jain1
 * 
 */
public class EditDocSharingEntryPage extends BasePageObject {

    /* UIElement declarations for the EditDocSharingEntryPage page */
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[@value = 'Cancel']");
    private UIElement btnSaveChanges = createElement(UIType.Css, "input[value='Save Changes']");
    private UIElement txtOwner = createElement(UIType.ID, "SubmitterDisplayName");
    private UIElement btnBrowse = createElement(UIType.ID, "ReplaceWithFile");
    private UIElement txtDescriptionContents = createElement(UIType.Css, "#FileDescription");
    private UIElement lblTitle = createElement(UIType.Css, ".tablehead");
    private UIElement radLabel = createElement(
            UIType.Xpath,
            "//input[@checked='']/following-sibling::label");
    private UIElement radSelect = createElement(
            UIType.Xpath,
            "//label[contains(text(),'{1}')]/preceding-sibling::input[1]");
    private UIElements radioList = createElements(UIType.Xpath, "//input[@id='shareStatus']");
    private UIElement radbtn = createElement(UIType.Xpath, "//label[contains(text(),'{1}')]");
    private UIElement lblerrormsg = createElement(UIType.Css, ".inlineerror>table>tbody>tr");

    private UIElement lbllabel = createElement(UIType.Xpath, "//td/label[contains(text(),'{1}')]");
    private UIElement chkUnzip = createElement(UIType.ID, "unzipFile");
    private UIElement radInstructorOnly = createElement(
            UIType.Xpath,
            "//fieldset[label[contains(text(),'{1}')]]//input[1]");
    private UIElement radEntireClass = createElement(
            UIType.Xpath,
            "//fieldset[label[contains(text(),'{1}')]]//input[2]");
    
    /* Variables*/
    
    private String strFileName;
    private String strValueOwner = "";
    private String strDescription = "";
    private String strTitle = "";
    private String strLabelRad = "";
    private String strTextCaption = null;
    private String strErrorMessage ;
    private String strAttributeValueOwner = null;
    private String strAttributeValueDescription = null;
    String ischecked ;
    List<UIElement> radioButtons;
    
    /* Constructor */
    public EditDocSharingEntryPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## EditDocSharingEntryPage ##");
    }

    /**
     * @author saurabh.jain1
     * @return
     * @throws Exception
     *             Method for clicking cancel button.
     */

    public DocSharingPage clickCancelButton() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING CANCEL BUTTON" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * Method is used to click on upload document button
     * 
     * @author Pratush.Manglik
     * @return DocSharingHomePage
     * @throws Exception
     */
    public DocSharingPage clickSaveChangesButton() throws Exception {
        logInstruction("LOG INSTRUCTION: CLICK ON SAVE CHANGES BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
            btnSaveChanges.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'save' CHANGES BUTTON" + "\nMETHOD:clickSaveChangesButton\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);

    }

    /**
     * @author usha , method help to get Owner text
     * @return
     * @throws Exception
     */
    public String getOwner() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE OWNER NAME");
            frameSwitch.switchToFrameContent();

            uiDriver.waitToBeDisplayed(txtOwner, waitTime);
            strValueOwner = txtOwner.getValue().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'owner' NAME " + "\nMETHOD:getOwner\n" + e
                    .getLocalizedMessage());
        }
        return strValueOwner;
    }

    /**
     * @author usha ,Method helps to enter Owner text
     * @param text
     * @return
     * @throws Exception
     */

    public EditDocSharingEntryPage enterOwner(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE OWNER NAME");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtOwner, waitTime);
            txtOwner.clearAndSendKeys(text);
        } catch (Exception e) {
            throw new Exception("ISSUE IN ENTERING 'owner'NAME" + "\nMETHOD:enterOwner\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on browse button
     * 
     * @category milestone2
     * @author kiran.kumar
     * @param path
     * @return UploadDocumentSharingEntryPage
     * @throws Exception
     */
    public EditDocSharingEntryPage clickBrowseButton(String absoluteFilePath) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE BROWSE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnBrowse, waitTime);
            btnBrowse.sendKeysToFileInput(absoluteFilePath);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON'browse button'" + "\n METHOD:clickBrowseButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on the browse button
     * 
     * @category milestone2
     * @author kiran.kumar
     * @return EditDocSharingEntryPage
     * @param path
     * @throws Exception
     * 
     */

    public EditDocSharingEntryPage clickBrowseButton() throws Exception {
        try {

            if (getBrowser().equals(Browser.CHROME)) {
                btnBrowse.clickAndWait(waitTime);
            } else
                if (getBrowser().equals(Browser.FIREFOX)) {
                    btnBrowse.clickByJavascript();
                }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON'browse button'" + "\n METHOD:clickBrowseButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to get the value entered in the description field
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     */

    public String getDescription() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE DESCRIPTION ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtDescriptionContents, waitTime);
            strDescription = txtDescriptionContents.getValue().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE DESCRIPTION" + "\nMETHOD:getDescription\n" + e
                            .getLocalizedMessage());
        }
        return strDescription;
    }

    /**
     * This method is used enter the value in the description field
     * 
     * @author monica.anand
     * @param description
     * @return EditDocSharingEntryPage
     * @throws Exception
     */
    public EditDocSharingEntryPage enterDescription(String description) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:ENTER THE DESCRIPTION");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtDescriptionContents, waitTime);
            txtDescriptionContents.clearAndSendKeys(description);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING THE DESCRIPTION" + "\nMETHOD:enterDescription\n" + e
                            .getLocalizedMessage());
        }
        return this;
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
            throw new Exception("ISSUE IN GETTING 'header' TITLE" + "METHOD:getHeaderTitle" + e
                    .getLocalizedMessage());
        }
        return strTitle;
    }

    /**
     * Method will return the label associated with the selected radio button
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     */
    public String getShareFileWithOption() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION: GETTING THE SHARE FILE OPTION");
            frameSwitch.switchToFrameContent();

           radioButtons = radioList.getUIElementsList();
            for (UIElement rad : radioButtons) {
                String ischecked = rad.getAttribute("checked");
                if (ischecked != null) {
                	strLabelRad = radLabel.getText();
                    break;
                }

            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'share file' OPTION" + "\nMETHOD:getShareFileWithOption\n" + e
                            .getLocalizedMessage());
        }
        return strLabelRad;
    }

    /**
     * Method will check the radio button
     * 
     * @author monica.anand
     * @return EditDocSharingEntryPage
     * @param String
     * @throws Exception
     */
    public EditDocSharingEntryPage selectShareFileWithOption(String radioButton) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECT SHARE FILE OPTION");
            frameSwitch.switchToFrameContent();
            radSelect.replaceValues(radioButton);
            ischecked = radSelect.getAttribute("checked");
            if (ischecked == null) {
                radSelect.clickAndWait(waitTime);
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING SHARE 'file' OPTION" + "\nMETHOD:selectShareFileWithOption\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to get Caption For Given Radio Button radio button- Instructor Only/Entire
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param radioButton
     * @return String
     * @throws Exception
     */

    public String getCaptionForRadioButton(String radioButton) throws Exception {

       
        try {

            logInstruction("LOG INSTRUCTION :GETTING THE CAPTION FROM RADIO BUTTON");
            frameSwitch.switchToFrameContent();
            radbtn.replaceValues(radioButton);
            uiDriver.waitToBeDisplayed(radbtn, waitTime);
            strTextCaption = radbtn.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'caption' VALUE" + "\nMETHOD:getCaptionForRadioButton\n" + e
                            .getLocalizedMessage());
        }
        return strTextCaption;
    }

    /**
     * Methods helps to determine whether Cancel Button is Dispalyed
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isCancelButtonDisplayed() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : VERIFIYING CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            return btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'cancel' BUTTON" + "\nMETHOD:isCancelButtonDisplayed\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether Save Changes Button is Displayed
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isSaveChangesDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : VERIFIYING SAVECHANGES BUTTON");
            frameSwitch.switchToFrameContent();
            return btnSaveChanges.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'savechanges' BUTTON" + "\nMETHOD:isSaveChangesDisplayed\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to determine whether Error Message is Displayed or not
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public String verifytheErrorMsginsrtuctionaltxt() throws Exception {
        
        try {

            logInstruction("LOG INSTRUCTION : GETTING THE ERROR MESSAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblerrormsg, waitTime);
            strErrorMessage = lblerrormsg.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'error' MESSAGE" + "\nMETHOD:verifytheErrorMsginsrtuctionaltxt\n" + e
                            .getLocalizedMessage());
        }
        return strErrorMessage;
    }

    /**
     * ,Method helps to get Attribute Value
     * 
     * @category MileStone2
     * @author Raghav
     * @param text
     * @return
     * @throws Exception
     */

    public String getOwnerAttributeValue() throws Exception {
      
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE OWNER ATTRIBUTE VALUE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtOwner, waitTime);
            strAttributeValueOwner = txtOwner.getAttribute("value").trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'owner'ATTRIBUTE VALUE" + "\nMETHOD:getOwnerAttributeValue\n" + e
                            .getLocalizedMessage());
        }
        return strAttributeValueOwner;
    }

    /**
     * This method is used get the Attribute value of description field
     * 
     * @author Raghav
     * @param
     * @return EditDocSharingEntryPage
     * @throws Exception
     */
    public String getEnterDescriptionAttributeValue() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE DESCRIPTION ATTRIBUTE VALUE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtDescriptionContents, waitTime);
            strAttributeValueDescription = txtDescriptionContents.getAttribute("value").trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'description attribute' VALUE" + "\nMETHOD:getEnterDescriptionAttributeValue\n" + e
                            .getLocalizedMessage());
        }
        return strAttributeValueDescription;
    }

    /**
     * Methods helps to verify label for : Replace file with ,Description,Owner
     * 
     * @author amit.deshmukh
     * @throws Exception
     * @category Milestone2
     */

    public boolean isLabelPresent(String label) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : VERIFYING LABEL");
            frameSwitch.switchToFrameContent();
            lbllabel.replaceValues(label);
            return lbllabel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERIFYING 'label'" + "\nMETHOD:isLabelPresent \n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to verify Browse Button
     * 
     * @author amit.deshmukh
     * @throws Exception
     * @category Milestone2
     */

    public boolean isBrowseButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING BROWSE BUTTON ");
            frameSwitch.switchToFrameContent();
            return btnBrowse.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN 'browse' BUTTON" + "\nMETHOD:isBrowseButtonPresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method Verify Text Box for Enter Description
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @throws Exception
     */
    public boolean isenterDescriptionTextBoxPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFY THE DESCRIPTION");
            frameSwitch.switchToFrameContent();
            return txtDescriptionContents.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE DESCRIPTION" + "\nMETHOD:isenterDescriptionTextBoxPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method is used for verifying the unzip checkbox.
     * 
     * @author amit.deshmukh
     * @return boolean
     * @category Milestone2
     * @throws Exception
     */
    public boolean isSelectUnzipCheckBoxDisplayed() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: VERIFY THE UNZIP CHECKBOX");
            return chkUnzip.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERFIYING 'unzip' CHECKBOX" + "\nMETHOD:isSelectUnzipCheckBoxDisplayed\n" + e
                            .getLocalizedMessage());
        }

    }
    /**
     * This method helps to editing a uploaded document.
     * @category Service level method.
     * @author kiran.kumar
     * @return boolean
     * @category Milestone2
     * @throws Exception
     */
    
	public DocSharingPage editUploadedFile(String selectOption,
			String description, String ownername) throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:EDITING A UPLOADED FILE IN DOCSHARING");
			frameSwitch.switchToFrameContent();
			radSelect.replaceValues(selectOption);
			radSelect.clickAndWait(waitTime);
			txtDescriptionContents.isDisplayedAfterWaiting(waitTime);
			txtDescriptionContents.clearAndSendKeys(description);
			txtOwner.isDisplayedAfterWaiting(waitTime);
			txtOwner.clearAndSendKeys(ownername);
			btnSaveChanges.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN EDITING THE UPLOADED DOCUMENT"
					+ "\n Method:editUploadedFile \n" + e.getLocalizedMessage());
		}
		return new DocSharingPage(uiDriver);
	}
    
	 /**
     * This is Handler method to UploadDocumentSharingEntryPage Document to use with Granular
     * Methods
     * 
     * @author KIRAN KUMAR
     * @param path
     * @param strAction
     * @param strTag
     * @param boolRenameFile
     * @param boolAbsolutePath
     * @return UploadDocumentSharingEntryPage
     * @throws Exception
     */
     public EditDocSharingEntryPage uploadFileHandler(String path,
                   String action, String tag, boolean renameFile) throws Exception {
    	
            try {
                   AutoITMethods autoit = new AutoITMethods();
                   if (getBrowser().equals(Browser.FIREFOX)
                                || getBrowser().equals(Browser.CHROME)) {
                         clickBrowseButton();
                         strFileName= autoit.uploadFile(path, action, tag, renameFile);
                   } else if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
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
      * @author KIRAN KUMAR
      * @return strFileName
      */
     public String getFileName() {
         return strFileName;
     }

}
