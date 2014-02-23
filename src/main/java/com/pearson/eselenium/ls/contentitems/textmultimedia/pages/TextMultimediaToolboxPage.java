package com.pearson.eselenium.ls.contentitems.textmultimedia.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class TextMultimediaToolboxPage extends BasePageObject {

    /* Elements */
    private UIElement lblEditSchedule = createElement(
            UIType.Xpath,
            "//td[@width='35%']/following-sibling::td");
    private UIElement lnkEditSchedule = createElement(
            UIType.Xpath,
            "//a[contains(.,'Edit Schedule')]");
    private UIElement drpAssignment = createElement(
            UIType.Xpath,
            "//table[@class='innercontenttable']//td//select");
    private UIElement btnDelete = createElement(UIType.Xpath, "//a[contains(text(),'Delete {1}')]");
    private UIElement btnSaveChanges = createElement(UIType.Css, "input[value='Save Changes']");
    private UIElement chkHideFormStudents = createElement(UIType.ID, "isHidden");
    private UIElement btnMove = createElement(UIType.Xpath, "//a[contains(text(),'Move')]");
    private UIElement lnkDeleteItemWithDropboxBasket = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Delete {1}')]");
    private UIElement lblPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lblHeader = createElement(UIType.Css, ".tablehead");

    private UIElement lnkDelete = createElement(UIType.Xpath, "//a[contains(text(),'Delete')]");
    private String strResult = null;
    
    /* Constructor */
    public TextMultimediaToolboxPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## TextMultimediaToolbox Page ##");
    }

    /**
     * method helps to select value from drpdwn
     * 
     * @author kiran kumar
     * @param String
     * @throws Exception
     * @returns TextMultimediaToolboxPage
     */

    public TextMultimediaToolboxPage selectAssigntodrpDwn(String strValue) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT ASSIGNMENT DROP DOWN ITEM");
            frameSwitch.switchToFrameContent();
            drpAssignment.selectByVisibleText(strValue);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING 'Assignment Dropdown Item' \n METHOD: selectAssigntodrpDwn \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method helps to click on delete
     * 
     * @author kiran kumar
     * @param String
     * @throws Exception
     * @returns DeleteTextMultimediaItemPage
     */
    public DeleteTextMultimediaItemPage clickOnDelete(String strItemName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE LINK");
            frameSwitch.switchToFrameContent();
            btnDelete.replaceValues(strItemName);
            if (!btnDelete.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Delete Button' DOES NOT EXISTS");
            }

            btnDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Delete Button' \n METHOD: clickOnDelete \n" + e
                            .getLocalizedMessage());
        }
        return new DeleteTextMultimediaItemPage(uiDriver);
    }

    /**
     * method helps to click save changes
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns TextMultimediaToolboxPage
     */
    public TextMultimediaToolboxPage clickSavechangesBtn() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON SAVE CHANGES BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnSaveChanges.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'SaveChanges Button' DOES NOT EXISTS");
            }

            btnSaveChanges.clickAndWait(waitTime);
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Savechanges Button' \n METHOD: clickSavechangesBtn \n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * method helps to click check box
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns TextMultimediaToolboxPage
     */

    public TextMultimediaToolboxPage clickHideStudentchkBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON HIDE FROM STUDENT CHECK BOX");
            frameSwitch.switchToFrameContent();
            chkHideFormStudents.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Hide From Students Check Box' \n METHOD: clickHideStudentchkBox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method helps to click on move
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns MoveTextMultimediaItemPage
     */

    public MoveTextMultimediaItemPage clickOnMove() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK ON MOVE LINK");
            frameSwitch.switchToFrameContent();
            btnMove.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING ON 'Move Link' \n METHOD: clickOnMove \n" + e
                    .getLocalizedMessage());
        }
        return new MoveTextMultimediaItemPage(uiDriver);
    }

    /**
     * @category Milestone 2 Method is used to click on Edit Schedule link
     * @author Pratush.Manglik
     * @return TextMultimediaEditSchedulePage
     * @throws Exception
     */
    public TextMultimediaEditSchedulePage clickEditScheduleLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK EDIT SCHEDULE LINK");
            frameSwitch.switchToFrameContent();
            if (!lnkEditSchedule.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Edit Schedule Link' DOES NOT EXISTS");
            }

            lnkEditSchedule.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Edit Schedule Link' \n METHOD: clickEditScheduleLink \n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2 Method is used to get message adjacent to Edit Schedule Link
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getMessageDisplayedNextToEditSchedule() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION : get message adjacent to Edit Schedule Link");
            frameSwitch.switchToFrameContent();
            if (!lblEditSchedule.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Edit Schedule Lable' DOES NOT EXISTS");
            }
            strResult = lblEditSchedule.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'Message Displayed Next To EditSchedule' \n METHOD: getMessageDisplayedNextToEditSchedule \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * method helps to click on delete link for the items with dropbox basket
     * 
     * @author Sumanth SV
     * @category Milestone 2
     * @param String
     * @throws Exception
     * @returns DeleteTextMultimediaItemPage
     */
    public DeleteTextMultimediaItemPage clickOnDeleteItemsWithDropboxBasket(String strItemName)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE LINK");
            frameSwitch.switchToFrameContent();
            lnkDeleteItemWithDropboxBasket.replaceValues(strItemName);
            if (!lnkDeleteItemWithDropboxBasket.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Delete Link' DOES NOT EXISTS");
            }

            lnkDeleteItemWithDropboxBasket.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Delete Link' \n METHOD: clickOnDeleteItemsWithDropboxBasket \n" + e
                            .getLocalizedMessage());
        }
        return new DeleteTextMultimediaItemPage(uiDriver);
    }

    /**
     * this method get the page title
     * 
     * @return String
     * @category Milestone2
     * @throws Exception
     * @author amit.deshmukh
     */
    public String getPageTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING PAGE TITLE");
            frameSwitch.switchToFrameContent();
            if (!lblPageTitle.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Page Title Lable' DOES NOT EXISTS");
            }
            strResult = lblPageTitle.getText().trim();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'Page Title' \n METHOD: getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * this method get the header title
     * 
     * @return String
     * @category Milestone2
     * @throws Exception
     * @author amit.deshmukh
     */
    public String getHeaderTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE");
            frameSwitch.switchToFrameContent();
            if (!lblHeader.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Header Title Lable' DOES NOT EXISTS");
            }
            strResult = lblHeader.getText().trim();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'Header Title' \n METHOD: getHeaderTitle \n" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * Method helps to click on delete
     * 
     * @author kiran kumar
     * @throws Exception
     * @returns DeleteTextMultimediaItemPage
     */
    public DeleteTextMultimediaItemPage clickOnDelete() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON DELETE LINK");
            frameSwitch.switchToFrameContent();
            lnkDelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON delete" + "\n METHOD: clickOnDelete \n" + e
                    .getLocalizedMessage());
        }
        return new DeleteTextMultimediaItemPage(uiDriver);
    }
    
    /**
     * Method helps to select Assignment to the specified one and checks hide from student option based on user requirement 
     * 
     * @author Chaitali
     * @param String
     * @param boolean
     * @return TextMultimediaToolboxPage
     * @throws Exception
     */
    public TextMultimediaToolboxPage selectAssignmentTo(String strValue, boolean flagSelectHideChkBox)
            throws Exception {
    	  try {
              logInstruction("LOG INSTRUCTION: SELECTING ASSIGNMENT DROP DOWN ITEM");
              if(StringUtils.isNotBlank(strValue)){
	              frameSwitch.switchToFrameContent();
	              drpAssignment.selectByVisibleText(strValue);
                if (flagSelectHideChkBox) {
		              logInstruction("LOG INSTRUCTION: CLICKING ON HIDE FROM STUDENT CHECK BOX");
		              chkHideFormStudents.clickAndWait(waitTime);
	    		  }
	    		   logInstruction("LOG INSTRUCTION: CLICKING ON SAVE CHANGES BUTTON");
	               btnSaveChanges.clickAndWait(waitTime);
	               uiDriver.getUIAlert().acceptAlertIfPresent();
              }
	        } catch (Exception e) {
              throw new Exception(
                      "ISSUE IN SELECTING 'Assignment Dropdown Item' \n METHOD: selectAssignmentTo \n" + e
                              .getLocalizedMessage());
          }
          return this;
    }

    /**
     * This method is used to click the check box
     * 
     * @return:TextMultimediaEditSchedulePage
     * @author Ganapati
     * @throws Exception
     */
    public TextMultimediaEditSchedulePage switchToNewWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHTONEWWINDOW");
            frameSwitch.switchToFrameContent();
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO NEW WINDOW" + "\n  switchToNewWindow()\n" + e
                    .getLocalizedMessage());
        }
        return new TextMultimediaEditSchedulePage(uiDriver);
    }

}
