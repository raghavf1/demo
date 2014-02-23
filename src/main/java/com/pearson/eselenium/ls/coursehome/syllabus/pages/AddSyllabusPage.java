package com.pearson.eselenium.ls.coursehome.syllabus.pages;

import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.eselenium.ls.common.pages.RadEditorSwitchPlainOrVisual;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to Add Syllabus page
 * 
 * @author monica.anand
 * 
 */
public class AddSyllabusPage extends BasePageObject {

    /* UIElement declarations for the add Syllabus page */
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
	   
    private UIElement txtTitle = createElement(UIType.ID, "Title");
    private UIElement lblHeader = createElement(UIType.Css, ".tablehead");
    private UIElement btnAddItem = createElement(UIType.ID, "saveButton1");
    private UIElement btnCancel = createElement(UIType.ID, "cancelButton1");
    private UIElement txtEditor = createElement(UIType.Xpath, "//html//body");
    private UIElements btnAddItemButton = createElements(UIType.Css, "input[type=" + "button" + "]");

    private UIElement btnAddItemCaption = createElement(UIType.Css, "#saveButton1");
    private UIElement btnCancelCaption = createElement(UIType.Css, "#cancelButton1");
    private UIElement lblIsTitle = createElement(
            UIType.Css,
            ".innercontenttable>table>tbody>tr>td>label");
    private UIElement txtIsTextboxPresent = createElement(UIType.Css, "#Title");
    private String radeditorframeid = "RadeEntryText_contentIframe";
    private String radeditoetoolid = "RadeEntryText";
    private String radeditoeFooterid = "RadeEntryText_ModesWrapper";
    private String visualEditorLink = "RadeEntryText_visualEditor";
    private String plainTextEditorLink = "RadeEntryText_simpleEditor";
    private String errorMsg = null;
    private UIElement MsgErrorTitle = createElement(
            UIType.Xpath,
            "//table//tr/td/table[1]//tr/td[2]/table//tr/td[2]");

    private PlainTextEditor plainEditor = new PlainTextEditor(uiDriver);
    private RadEditorSwitchPlainOrVisual radSwitch = new RadEditorSwitchPlainOrVisual(
            uiDriver,
            visualEditorLink,
            plainTextEditorLink);
    private VisualEditor radEditor = new VisualEditor(uiDriver, radeditoetoolid, radeditorframeid,radeditoeFooterid);
    private UIElement spnMandatoryField = createElement(
            UIType.Xpath,
            "//table[2]/tbody/tr/td[1]/span");
    private UIElement txterrormessage = createElement(
            UIType.Xpath,
            "//td[@class='inlineerror']//tbody/tr/td[2]");

    private boolean flag = false;
    private int count = 0;
    private String data = null;

    // RadEditorSwitchPlainOrVisual contentRadEditor = new
    // RadEditorSwitchPlainOrVisual(uiDriver);

    /* Constructor */
    public AddSyllabusPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## AddSyllabusPage ##");

    }

    public VisualEditor getVisualEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return radEditor;
    }

    public PlainTextEditor getPlainTextEditor() throws Exception {
            return plainEditor;
    }

    public RadEditorSwitchPlainOrVisual getRadSwitch() throws Exception {
    	frameSwitch.switchToFrameContent();
        return radSwitch;
    }

    /**
     * This method is used to enter the title
     * 
     * @author Soundarya
     * @param description
     * @return AddSyllabusPage
     * @throws Exception
     */
    public String getErrorTitle() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: DONT ENTER TITLE GET ERROR MESSAGE ");
            frameSwitch.switchToFrameContent();
            if (MsgErrorTitle.isDisplayedAfterWaiting())
                errorMsg = MsgErrorTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN ENTERTING 'DONT ENTER TITLE GET ERROR MESSAGE'" + "\n METHOD: enterTitle \n" + e
                            .getLocalizedMessage());
        }
        return errorMsg;
    }

    /**
     * This method is used to enter the title
     * 
     * @author monica.anand
     * @param description
     * @return AddSyllabusPage
     * @throws Exception
     */
    public AddSyllabusPage enterTitle(String description) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: INSIDE ENTER TITLE METHOD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            txtTitle.clearAndSendKeys(description);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN ENTERTING 'Title'" + "\n METHOD: enterTitle \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to get the header title
     * 
     * @author monica.anand
     * @return String
     * @throws Exception
     */
    public String getHeaderTitle() throws Exception {
        String header = "";
        try {
            logInstruction("LOG INSTRUCTION: INSIDE GET HEADER TITLE METHOD ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeader, waitTime);
            header = lblHeader.getText();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN GETTING ' Headder Title'" + "\n METHOD: getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return header;
    }

    /**
     * This method is used to click on add item button
     * 
     * @author monica.anand
     * @return Object
     * @throws Exception
     */
    public Object clickAddItemButton() throws Exception {
    	try {
            logInstruction("LOG INSTRUCTION: INSIDE CLICK ADD ITEM METHOD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAddItem, waitTime);
            btnAddItem.clickAndWait(waitTime);
            if (getErrorMessage()==null) {
                return new SyllabusHomePage(uiDriver);
            }
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CLICKING ON 'Add Item Button'" + "\n METHOD: clickAddItemButton \n" + e
                            .getLocalizedMessage());
        }
        return new AddSyllabusPage(uiDriver);
    }

    /**
     * This method is used to click on cancel button
     * 
     * @author monica.anand
     * @return SyllabusHomePage
     * @throws Exception
     */
    public SyllabusHomePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: INSIDE CLICK CANCEL BUTTON METHOD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.click();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CLICKING ON 'Cancel Button'" + "\n METHOD: clickAddItemButton \n" + e
                            .getLocalizedMessage());
        }
        return new SyllabusHomePage(uiDriver);
    }

    // /**
    // * This method is used to enter text in the rad editor
    // *
    // * @param String
    // * - text
    // * @return AddSyllabusPage
    // * @throws Exception
    // * @author monica.anand
    // */
    // public AddSyllabusPage enterText(String text) throws Exception {
    // try {
    // /*logInstruction("LOG INSTRUCTION: Inside enter Text  method");
    //
    // logInstruction("LOG INSTRUCTION: Inside enter Text  method");
    // frameSwitch.switchToRadeEntryTextcontentIframe();
    // uiDriver.waitToBeDisplayed(txteditor, waitTime);
    // txteditor.sendKeys(text);*/
    //
    // frameSwitch.switchToFrameContent();
    //
    // visualEditor.clickRadEditorIcon(
    // VisualEditorElementsEnum.MOVE_FOCUS_TO_TEXT_EDITOR,
    // contentRadEditorTableId);
    // uiDriver.sendKeysToBrowser(text);
    //
    // } catch (Exception e) {
    // throw new Exception("unable to type data in rad editor" + e.getLocalizedMessage());
    // }
    // return this;
    // }

    /**
     * This Function will count total number of AddItem Button on the Page. If button Count is 2 it
     * will Return true else False.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isAddItemButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Inside Is Add Item Button Present Method");
            frameSwitch.switchToFrameContent();
            List<UIElement> listOfUI = btnAddItemButton.getUIElementsList();
            for (UIElement uiElement : listOfUI) {
                uiDriver.waitToBeDisplayed(uiElement, waitTime);
                if (uiElement.getAttribute("value").equals("Add Item")) {
                    count++;
                }
            }
            if (count == 2)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CLICKING ON 'Cancel Button'" + "\n METHOD: clickAddItemButton \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /***
     * This function will count total number of Cancel button on the Page. If count i 2 it function
     * will return true else false.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isCancelButtonPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: INSIDE IS CANCEL ITEM BUTTON PRESENT METHOD");
            frameSwitch.switchToFrameContent();
            List<UIElement> listOfUI = btnAddItemButton.getUIElementsList();
            for (UIElement uiElement : listOfUI) {
                uiDriver.waitToBeDisplayed(uiElement, waitTime);
                if (uiElement.getAttribute("value").equals("Cancel")) {
                    count++;
                }
            }
            if (count == 2)
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CHECKING 'Cancel Button' PRESENT" + "\n METHOD: isCancelButtonPresent \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This function will give you the Caption of AddItem button
     * 
     * @return String - CaptionText
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getCaptionOfAddItemButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: INSIDE GET CAPTION OF ADD ITEM BUTTON METHOD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnAddItemCaption, waitTime);
            data = btnAddItemCaption.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CHECKING 'Caption Of Add Item Button' PRESENT" + "\n METHOD: getCaptionOfAddItemButton \n" + e
                            .getLocalizedMessage());
        }
        return data;
    }

    /**
     * This function will give you the Caption of Cancel button
     * 
     * @return String - captionText
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public String getCaptionOfCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: INSIDE GET CAPTION OF CANCEL  BUTTON METHOD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancelCaption, waitTime);
            data = btnCancelCaption.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CHECKING 'Caption Of Cancel Button' PRESENT" + "\n METHOD: getCaptionOfCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return data;
    }

    /**
     * This function will retrun true if title Label is found on the page.False when not found.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isTitlePresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: INSIDE IS TITLE PRESENT METHOD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblIsTitle, waitTime);

            if (lblIsTitle.getText().equals("Title:"))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CHECKING 'Title Present' PRESENT" + "\n METHOD: isTitlePresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This function will return true if there is text box asociated with the Title label.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */

    public boolean isTextBoxPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: INSIDE IS TEXT BOX PRESENT METHOD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtIsTextboxPresent, waitTime);
            if (txtIsTextboxPresent.isPresent())
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CHECKING 'Text Box Present' PRESENT" + "\n METHOD: isTextBoxPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    // /**
    // * Method helps to click on the link Wizard Icon
    // *
    // * @author ganapati.bhat
    // * @return LinkWizardInsertLinkPage
    // * @throws Exception
    // */
    // public LinkWizardInsertLinkPage clickLinkWizardInsertLink() throws Exception {
    // try {
    // frameSwitch.switchToFrameContent();
    // visualEditor.clickLinkWizardInsertLink(contentRadEditorTableId);
    //
    // } catch (Exception e) {
    // throw new Exception("Unable to click on the link wizard Insert Link" + e
    // .getLocalizedMessage());
    // }
    // return new LinkWizardInsertLinkPage(uiDriver);
    // }

    /**
     * This Method will check whether "*indicate mandatory Field" is present in Add Syllabus Item
     * Page.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isMandatoryfieldDisplayed() throws Exception {
        boolean flag = false;
        try {

            logInstruction("LOG INSTRUCTION: CHECKING FOR MANDATORY FIELD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(spnMandatoryField, waitTime);
            if (spnMandatoryField.isPresent())
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CHECKING 'Mandatory field Displayed' PRESENT" + "\n METHOD: isMandatoryfieldDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method checks whether the RadEditor is displayed or not
     * 
     * @author ashish.juyal
     * @throws Exception
     */

    public boolean isRadEditorDisplayed() throws Exception {
        boolean flag = false;
        try {
            logInstruction("CHECKING FOR THE RAD EDITOR");
            frameSwitch.switchToRadeEntryTextcontentIframe();
            uiDriver.waitToBeDisplayed(txtEditor, waitTime);
            flag = txtEditor.isDisplayed();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CHECKING 'Rad Editor Displayed' PRESENT" + "\n METHOD: isRadEditorDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

   

    /*
     * This method helps to get the error message when the add item buttoni pressed withouth
     * enetering the title
     * 
     * @author:ashish.juyal
     * 
     * @return:String
     */
    public String getErrorMessage() throws Exception {

        try {
            frameSwitch.switchToFrameContent();
           // uiDriver.waitToBeDisplayed(txterrormessage, waitTime);
            if(txterrormessage.isDisplayedAfterWaiting())
            {
            errorMsg = txterrormessage.getText();
            }
            else
            {
            	errorMsg=null;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Error' MESSAGE" + "\n METHOD:getErrorMessage\n" + e
                            .getLocalizedMessage());
        }
        return errorMsg;
    }

    /**
     * @author saurabh.jain1
     * @return String - title content
     * @throws Exception
     *             Method for verifying title content.
     */
    public String getTitleContent() throws Exception {
        String contentTitle;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING TITLE CONTENT");
            frameSwitch.switchToFrameContent();
         //   uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            contentTitle = txtTitle.getAttribute("value").trim();
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN GETTING 'Title Content'" + "\n METHOD: getTitleContent \n" + e
                            .getLocalizedMessage());
        }
        return contentTitle;
    }
	/**
	 * This is Service level method to Add Syllabus. This method will return SyllabusHomePage if title and content are not null, else will return AddSyllabusPage
	 * 
	 * @author Kapil
	 * @param title
	 * @param content
	 * @return Object
	 */
	public Object addSyllabus(String title, String content)
			throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			txtTitle.clearAndSendKeys(title);
			logInstruction("LOG INSTRUCTION: ADDED TITLE");
			getVisualEditor().enterText(content);
			logInstruction("LOG INSTRUCTION: ADDED CONTENT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAddItem, waitTime);
			btnAddItem.click();
			logInstruction("LOG INSTRUCTION: CLICKED ON 'Add Item' BUTTON");
			if(title == null || content == null) {
				return new AddSyllabusPage(uiDriver);
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN ADDING SYLLABUS ITEM"
					+ "\n METHOD:addSyllabus\n" + e.getLocalizedMessage());
		}
		return new SyllabusHomePage(uiDriver);
	}
}
