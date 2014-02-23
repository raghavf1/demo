package com.pearson.eselenium.ls.contentitems.textmultimedia.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.eselenium.ls.common.pages.RadEditorSwitchPlainOrVisual;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class TextMultimediaHomePage extends BasePageObject {

    /* Elements */
    private UIElement btnContent = createElement(
            UIType.Xpath,
            "//div[@id='contentMenu']//a[contains(.,'Content')]");
    private UIElement btnToolBox = createElement(
            UIType.Xpath,
            "//div[@id='contentMenu']//a[contains(.,'Toolbox')]");
    private UIElement txtRadEditor = createElement(UIType.Xpath, "//body");
    private UIElement btnSaveChanges = createElement(UIType.Xpath, "//table//tr[1]//td[2]//input");
    private UIElement txtEditor = createElement(UIType.Xpath, "//a[contains(.,'{1}')]");
    private UIElement txtPageHeader = createElement(UIType.Css, ".pageTitle");
    private UIElement txtTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lblPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lblHeader = createElement(UIType.Css, ".tablehead");
    private UIElement lblTitle = createElement(UIType.Xpath, "//div[@class='pageTitle']");

    /* Variables and Objects */
    private static final String strCourseHomeTextMultimediaToolId = "RadeEntryText";
    private static final String strCourseHomeTextMultimediaFrameId = "RadeEntryText_contentIframe";
    private String strAlertMsg = null;
    private static final String strVisualEditorLink = "RadeEntryText_visualEditor";
    private static final String strPlainTextEditorLink = "RadeEntryText_simpleEditor";

    private VisualEditor objTextMultimediaRadEditor = new VisualEditor(
            uiDriver,
            strCourseHomeTextMultimediaToolId,
            strCourseHomeTextMultimediaFrameId,strCourseHomeTextMultimediaToolId);
    private PlainTextEditor objTextMultimediaPlainEditor = new PlainTextEditor(uiDriver);
    private RadEditorSwitchPlainOrVisual objRadSwitch = new RadEditorSwitchPlainOrVisual(
            uiDriver,
            strVisualEditorLink,
            strPlainTextEditorLink);
    
    boolean flag =  false;
    private String strResult = null;
    String strTitle;
    String strTableHeader;
    String strTemp;

    /* Constructor */
    public TextMultimediaHomePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Text MultimediaHome Page ##");
    }

    /**
     * This Method will return the instance of VisualEditor
     * 
     * @return:NextAuthorHomePage
     * @author
     * @throws Exception 
     */
    public VisualEditor getVisualEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return objTextMultimediaRadEditor;
    }

    /**
     * This Method will return the instance of PlainTextEditor
     * 
     * @return:PlainTextEditor
     * @author
     */
    public PlainTextEditor getPlainTextEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return objTextMultimediaPlainEditor;
    }

    /**
     * This Method will return the instance of RadEditorSwitchPlainOrVisual
     * 
     * @return:RadEditorSwitchPlainOrVisual
     * @author
     */
    public RadEditorSwitchPlainOrVisual getRadSwitch() throws Exception {
    	frameSwitch.switchToFrameContent();
        return objRadSwitch;
    }

    /**
     * This method helps to get the alert text
     * 
     * @author Soundarya
     * @return String
     * @throws Exception
     */
    public String getAlert() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET THE ALERT TEXT");
            strResult = uiDriver.getUIAlert().getAlertMessage();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'Alert Text' \n METHOD: getAlert \n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method helps to accept the alert
     * 
     * @author Soundarya
     * @throws Exception
     */
    public void acceptAlert() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ACCEPT THE ALERT");
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception("ISSUE IN 'Accepting The Alert' \n METHOD: acceptAlert \n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * This method helps to check is Added Content Displayed
     * 
     * @author ashish.juyal
     * @param String 
     * @return TextMultimediaHomePage
     * @throws Exception
     * 
     */

    public TextMultimediaHomePage isAddedContentDisplayed(String strContentName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECK IS ADDED CONTENT DISPLAYED");
            frameSwitch.switchToFrameContent();
            if (!btnContent.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Content Button' DOES NOT EXISTS");
            }

            btnContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Added Content' \n METHOD: isAddedContentDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click click on the content button
     * 
     * @author ashish.juyal
     * @return TextMultimediaHomePage
     * @throws Exception
     * 
     */

    public TextMultimediaHomePage clickContentButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE CONTENT BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnContent.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Content Button' DOES NOT EXISTS");
            }

            btnContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Content Button' \n METHOD: clickContentButton \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on the toolbox button
     * 
     * @author ashish.juyal
     * @return  TextMultimediaToolboxPage
     * @throws Exception
     * 
     */
    public TextMultimediaToolboxPage clickToolboxButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON THE TOOLBOX BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnToolBox.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Toolbox Button' DOES NOT EXISTS");
            }

            btnToolBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Toolbox Button' \n METHOD: clickToolboxButton \n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaToolboxPage(uiDriver);
    }

    /**
     * This method helps in writing contents in rad editor
     * 
     * @author ashish.juyal
     * @param String
     * @return TextMultimediaHomePage
     * @throws Exception
     */

    public TextMultimediaHomePage enterContentInRadEditor(String strContent) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTERING CONTENTS IN RAD EDITOR");
            frameSwitch.switchToRadeEntryTextcontentIframe();
            if (!txtRadEditor.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Radeditor' DOES NOT EXISTS");
            }

            txtRadEditor.sendKeys(strContent);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN ENTERING 'Content In RadEditor' \n METHOD: enterContentInRadEditor \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on the saveChanges button
     * 
     * @author ashish.juyal
     * @return TextMultimediaHomePage
     * @throws Exception
     */

    public TextMultimediaHomePage clickSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING SAVE CHANGES BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnSaveChanges.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Save Changes Button' DOES NOT EXISTS");
            }

            btnSaveChanges.clickAndWait(waitTime);
            strAlertMsg = uiDriver.getUIAlert().acceptAlertIfPresentAndGetMessage();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Save Changes Button' \n METHOD: clickSaveChangesButton \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * This method helps to identify whether the rad editor is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */
    public boolean isRadEditorDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE RAD EDITOR");
            frameSwitch.switchToRadeEntryTextcontentIframe();
            if (!txtRadEditor.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Radeditor' DOES NOT EXISTS");
            }
            flag = txtRadEditor.isDisplayed();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VRIFYING THE 'Rad Editor' \n METHOD: isRadEditorDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps to find the Visual Editor or Plain text editor is displayed or not is
     * displayed or not
     * 
     * @author ashish.juyal
     * @param String 
     * @return boolean
     * @throws Exception
     */
    public boolean isEditorDisplayed(String strName) throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE VISUAL EDITOR");
            frameSwitch.switchToFrameContent();
            txtEditor.replaceValues(strName);
            if (!txtEditor.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Editor' DOES NOT EXISTS");
            }
            flag = txtEditor.isDisplayed();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Editor' \n METHOD: isEditorDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method will get page header
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     * @category MileStone2
     */
    public String getPageHeader() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING PAGE HEADER");
            frameSwitch.switchToFrameContent();
            if (!txtPageHeader.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Page Header' DOES NOT EXISTS");
            }

            strResult = txtPageHeader.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Page Header' \n METHOD: getPageHeader \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to verify the existence of the alert
     * @author Suchi.Singh
     * @return boolean
     * 
     * @throws Exception
     */

    public boolean isAlertPresent() throws Exception {
        flag = false;
        try {
            if (strAlertMsg != null)
                flag = true;
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERIFYING THE 'Alert' \n METHOD: isAlertPresent \n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * @category milestone 2 Methods helps to get header title
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */

    public String getPageTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : GET PAGE TITLE");
            frameSwitch.switchToFrameContent();
            strResult = txtTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'Page Title' \n METHOD: getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Methods helps to get page title from Text Multimedia page
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return String
     */

    public String getTextMultimediaPageTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING PAGE TITLE");
            frameSwitch.switchToFrameContent();
            strResult = lblPageTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Text Multimedia Page Title' \n METHOD: getTextMultimediaPageTitle \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Methods helps to get header title from Text Multimedia page
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return String
     */

    public String getHeaderTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToFrameContent();
            strResult = lblHeader.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Header Title' \n METHOD: getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method is used to get the table header text
     * 
     * @category Milestone 2
     * @author monica.anand
     * @return String
     * @throws Exception
     */

    public String getHeader() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR THE TABLE HEADER");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblTitle, waitTime);
            strResult = lblTitle.getText();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE 'Header' \n METHOD: getHeader \n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * @category Milestone2 Method is used to get alert message after clicking save changes
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
	public String getAlertMessageAfterClickingSaveChanges() throws Exception {
		try {
			strResult = null;
			logInstruction("LOG INSTRUCTION : GET ALERT MESSAGE ON CLICKING SAVE CHANGES BUTTON");
			frameSwitch.switchToFrameContent();
			if (!btnSaveChanges.isDisplayedAfterWaiting(waitTime)) {
				throw new Exception("'Save Changes Button' DOES NOT EXISTS");
			}

			btnSaveChanges.clickAndWait(waitTime);
			strResult = uiDriver.getUIAlert().getAlertMessage();
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
            throw new Exception("ISSUE IN GETTING ALERT MESSAGE AFTER CLICKING SAVE CHANGES \n METHOD: getAlertMessageAfterClickingSaveChanges \n" + e
                    .getLocalizedMessage());
        }
		return strResult;
	}
    
    
    /**
     * This Method is used to enter contents in RAD editor and clicking on Save changes button
     * @author Chaitali
     * @param String
     * @return  TextMultimediaHomePage
     * @throws Exception
     */
	public TextMultimediaHomePage addRadContent(String strContent)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING CONTENTS IN RAD EDITOR");
			frameSwitch.switchToRadeEntryTextcontentIframe();
			if (StringUtils.isNotBlank(strContent)) {

				getVisualEditor().enterText(strContent);
				logInstruction("LOG INSTRUCTION: CLICKING SAVE CHANGES BUTTON");
				frameSwitch.switchToFrameContent();

				if (!btnSaveChanges.isDisplayedAfterWaiting(waitTime)) {
					throw new Exception("'Save Changes Button' DOES NOT EXISTS");
				}
				btnSaveChanges.clickAndWait(waitTime);
				strAlertMsg = uiDriver.getUIAlert()
						.acceptAlertIfPresentAndGetMessage();
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN ENTERING 'Content In RadEditor' \n METHOD: addRadContent \n"
							+ e.getLocalizedMessage());
		}
		return this;

	}
}
