package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of Grade Detail View Page Follow the below steps
 * to navigate the page: Login as prof Click on the Course Select Author Tab Select Gradebook tab in
 * toolbar Click any row in "Course Weighted Average To Date"
 * 
 * @author sumanth.sv
 * 
 */

public class CourseGradeDetailViewPage extends BasePageObject {

    /* Constructor */
    public CourseGradeDetailViewPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Grade Detail View Page ##");
    }

    /* Elements */
    private UIElement chkShareGradeWithStudent = createElement(
            UIType.Css,
            ".innercontenttable [type='checkbox']");
    private UIElement txtLetterGrade = createElement(UIType.Css, ".innercontenttable [type='text']");
    private UIElement txtEntryContent = createElement(UIType.Css, "#RadeEntryText_contentIframe");
    private UIElement btnSave = createElement(UIType.Css, "#save");
    private UIElement btnSaveAndNext = createElement(UIType.Css, "#saveAndNextButton");
    private UIElement btnSaveAndClose = createElement(UIType.Css, "#SaveAndClose");
    private UIElement btnCancel = createElement(UIType.Css, "#button9");

    private String radeditorframeid = "RadeEntryText_contentIframe";
    private String radeditoetoolid = "RadeEntryText";
    private VisualEditor radEditor = new VisualEditor(uiDriver, radeditoetoolid, radeditorframeid, radeditoetoolid);

    public VisualEditor getVisualEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return radEditor;
    }

    /**
     * Method helps to check Share Grade With Student Check box
     * 
     * @author Sumanth SV
     * @return GradeDetailViewPage
     * @throws Exception
     */
    public CourseGradeDetailViewPage checkShareGradeWithStudentCheckbox() throws Exception {
        logInstruction("LOG INSTRUCTION: Check Share and Grade With Student Checkbox");
        try {
            checkOrUncheckCheckBox(chkShareGradeWithStudent, true);
            logInstruction("LOG INSTRUCTION: Checked Share and Grade With Student Checkbox");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE CHECKBOX 'SHARE GRADE WITH STUDENT'" + "\n METHOD:checkShareGradeWithStudent:\n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * Method helps to uncheck Share Grade With Student Check box
     * 
     * @author Sumanth SV
     * @return GradeDetailViewPage
     * @throws Exception
     */
    public CourseGradeDetailViewPage unCheckShareGradeWithStudentCheckbox() throws Exception {
        try {
            checkOrUncheckCheckBox(chkShareGradeWithStudent, false);
            logInstruction("LOG INSTRUCTION: unChecked Share and Grade With Student");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN UNCHECKING THE 'SHARE GRADE WITH STUDENT' CHECKBOX" + "\n METHOD:unCheckShareGradeWithStudent:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to set Letter Grade
     * 
     * @param letterGradeTxt
     * @author Sumanth SV
     * @return GradeDetailViewPage
     */
    public CourseGradeDetailViewPage setLetterGradeText(String letterGradeTxt) {
        try {
            uiDriver.waitToBeDisplayed(txtLetterGrade, waitTime);
            txtLetterGrade.clearAndSendKeys(letterGradeTxt);
            logInstruction("LOG INSTRUCTION: letterGrade is entered");
        } catch (Exception e) {
            logInstruction("ISSUES IN ENTERING THE 'GRADE TEXT'" + "\n METHOD:setLetterGradeText :\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to set Text Content
     * 
     * @param textContenttextContent
     * @author Sumanth SV
     * @return GradeDetailViewPage
     * @throws Exception
     */
    public CourseGradeDetailViewPage setTextContentText(String textContent) throws Exception {
        try {
            uiDriver.waitToBeDisplayed(txtEntryContent, waitTime);
            txtEntryContent.clearAndSendKeys(textContent);
            logInstruction("LOG INSTRUCTION: Text Content is entered");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN 'ENTERING TEXT CONTENT'" + "\n METHOD:setTextContentText:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click Save Button
     * 
     * @author Sumanth SV
     * @return GradeDetailViewPage
     * @throws Exception
     */
    public CourseGradeDetailViewPage clickSaveButton() throws Exception {
        try {
            uiDriver.waitToBeDisplayed(btnSave, waitTime);
            btnSave.click();
            uiDriver.switchTo().alert().accept();
            logInstruction("LOG INSTRUCTION: saveButton button is clicked");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'SAVE' BUTTON" + "\n METHOD:clickSaveButton:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click Save And Next Button
     * 
     * @author Sumanth SV
     * @return
     * @throws Exception
     */
    public void clickSaveAndNextButton() throws Exception {
        try {
            uiDriver.waitToBeDisplayed(btnSaveAndNext, waitTime);
            btnSaveAndNext.click();
            logInstruction("LOG INSTRUCTION: saveAndNextButton button is clicked");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'SAVE AND NEXT' BUTTON" + "\n METHOD:clickSaveAndNextButton:\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to click Save And Close Button
     * 
     * @author Sumanth SV
     * @return
     * @throws Exception
     */
    public void clickSaveAndCloseButton() throws Exception {
        try {
            logInstruction("clicking the save and close button");
            uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
            btnSaveAndClose.click();
            logInstruction("LOG INSTRUCTION: saveAndClose button is clicked");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'SAVE AND CLOSE' BUTTON" + "\n METHOD:clickSaveAndCloseButton:\n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to click Cancel Button
     * 
     * @author Sumanth SV
     * @return MyGradeBookPage
     */
    public MyGradeBookPage clickCancelButton() throws Exception {
        try {
        	frameSwitch.switchToNewWindowTopFrame();          
            btnCancel.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: Cancel button is clicked");
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'CANCEL' BUTTON" + "\n METHOD:clickCancelButton:\n" + e
                            .getLocalizedMessage());
        }
        return new MyGradeBookPage(uiDriver);
    }

    /**
     * Method helps to check Or Uncheck CheckBox
     * 
     * @author Sumanth SV
     * @return
     * @throws Exception
     */
    private CourseGradeDetailViewPage checkOrUncheckCheckBox(
            UIElement eleCheckBox,
            boolean checkOrunCheck) throws Exception {
        try {
            uiDriver.waitToBeDisplayed(eleCheckBox, waitTime);

            if (eleCheckBox.isSelected() && checkOrunCheck) {} else {
                eleCheckBox.click();
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'CHECKBOX" + "\n METHOD:checkOrUncheckCheckBox:\n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Method helps to get Letter Grade Text
     * 
     * @author Sumanth SV
     * @return Letter Grade Text
     * @throws Exception
     */
    public String getLetterGradeText() throws Exception {
        String text = null;
        try {
            uiDriver.waitToBeDisplayed(txtLetterGrade, waitTime);
            logInstruction("LOG INSTRUCTION: letterGrade value is returned");
            text = txtLetterGrade.getAttribute("value");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN 'GETTING THE TEXT'" + "\n METHOD:getLetterGradeText:\n" + e
                            .getLocalizedMessage());
        }
        return text;

    }

    /**
     * Method helps to get Text Content
     * 
     * @author Sumanth SV
     * @return Text Content
     * @throws Exception
     */
    public String getTextContent() throws Exception {
        String text = null;
        try {
            uiDriver.waitToBeDisplayed(txtEntryContent, waitTime);
            logInstruction("LOG INSTRUCTION: entryTextContent value is returned");
            text = txtEntryContent.getAttribute("value");
        } catch (Exception e) {
            throw new Exception("ISSUE IN 'GETTING THE TEXT'" + "\n METHOD:getTextContent:\n" + e
                    .getLocalizedMessage());
        }
        return text;
    }

    /**
     * Method helps to check whether Share Grade With Student Check box is Checked Or UnChecked
     * 
     * @author Sumanth SV
     * @return true if Checked
     * @return false if Checked
     */
    public boolean isShareGradeWithStudentChecked() throws Exception {
        boolean flag = false;
        try {
            uiDriver.waitToBeDisplayed(chkShareGradeWithStudent, waitTime);
            logInstruction("LOG INSTRUCTION: return the status of Share and Grade With Student");
            flag = chkShareGradeWithStudent.isSelected();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN 'CHECKING THE CHECKBOX'" + "\n METHOD:getTextContent:\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify rad editor.
     * 
     * @return
     * @throws Exception
     * @author Suchi.Singh
     */
    public boolean isRadEditorDisplayed() throws Exception {
        boolean flag = false;
        logInstruction("LOG INSTRUCTION:VERIFIYING RAD EDITOR");
        try {

            if (radEditor != null) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING RAD EDITOR ." + "\n METHOD : isRadEditorDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to verify Alternative Editor Present or not..
     * 
     * 
     * @return boolean
     * @throws Exception
     * @author suchi.singh
     */
    public boolean isEditorSwitchDisplayed() throws Exception {
        boolean flag = false;
        logInstruction("LOG INSTRUCTION: ALTERNATIVE EDITOR PRESENT OR NOT...");
        try {
            flag = false;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION." + "\n METHOD : isEditorSwitchDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
    /**
     * Method helps to Enter grade
     * 
     * @category Service level method
     * @return boolean
     * @throws Exception
     * @author Kiran.Kumar
     */
    public GradebookHomePage enterGradePionts(String letterGrade,boolean clickcheckbox) throws Exception{
    	try {
			logInstruction("LOGINSTRUCTION:ENTERING GRADES IN REQUIRED FIELDS");
			frameSwitch.switchToNewWindowTopFrame();
			txtLetterGrade.clearAndSendKeys(letterGrade);
			if(clickcheckbox==true && !chkShareGradeWithStudent.isSelected()){
				logInstruction("LOGINSTRUCTION :CHECKBOX IS SELECTED");
			}else{
				chkShareGradeWithStudent.clickNoWait();
			}
			

			frameSwitch.switchtopGeneralFrame();
			btnSaveAndClose.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE GRADES"+"\n METHOD:enterGradePionts \n");
		}
		return new GradebookHomePage(uiDriver);
    }
    
    
    
}
