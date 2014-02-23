package com.pearson.eselenium.ls.contentitems.textmultimedia.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class MoveTextMultimediaItemPage extends BasePageObject {

    /* Elements */
    private UIElement drpSelectMoveTo = createElement(UIType.ID, "moveToUnitSubId");
    private UIElement btnDrpSaveChanges = createElement(UIType.Css, "input[value='Save Changes']");
    private UIElement lblHeader = createElement(UIType.Xpath, "//h2[1]/div");
    private UIElement txtMoveOrder = createElement(
            UIType.Xpath,
            "//td[contains(text(),'{1}')]/following-sibling::td/input[1]");
    private UIElement btnReorderSaveChanges = createElement(
            UIType.Css,
            "input[onclick='javascript:btnSaveChangesReorder_onclick()']");
    private UIElement lblHeaderTitle = createElement(UIType.Xpath, "//h2[2]/div");
    private UIElement btnCancel = createElement(
            UIType.Xpath,
            "//form/table[1]//tbody/tr[4]/td/input[2]");

    private boolean flag = false;
    private String strResult = null;
    
    /* Constructor */
    public MoveTextMultimediaItemPage(UIDriver driver) {
        super(driver);
        pageTitle = "Move";
        logInstruction("LOG INSTRUCTION: ## MoveTextMultimediaItem Page ##");
    }

    /**
     * This methods helps to select the dropdown value from move to
     * @return MoveTextMultimediaItemPage
     * @param String
     * @author ashish.juyal
     * @throws Exception
     */

    public MoveTextMultimediaItemPage selectValueFromMoveTo(String strCourseName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECT THE VALUE FROM THE MOVE TO DROPDOWN LIST");
            frameSwitch.switchToFrameContent();
            if (!drpSelectMoveTo.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Move To Dropdown' DOES NOT EXISTS");
            }
            drpSelectMoveTo.selectByVisibleText(strCourseName);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING VALUE FROM 'Move To Dropdown' \n METHOD:selectValueFromMoveTo \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on save changes present on the top
     * 
     * @author kiran.kumar
     * @return TextMultimediaToolboxPage
     * @throws Exception
     */
    public TextMultimediaToolboxPage clickSavebuttonForDropdown() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnDrpSaveChanges.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Dropdown Save Button' DOES NOT EXISTS");
            }
            btnDrpSaveChanges.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Dropdown Save Button' \n METHOD:clickSavebuttonForDropdown \n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaToolboxPage(uiDriver);
    }

    /**
     * This method verifies the header title of the move
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */

    public boolean isMovePageDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING THE HEADER OF THE MOVE PAGE");
            frameSwitch.switchToFrameContent();
            flag =  lblHeader.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Header' OF THE MOVE PAGE \n METHOD:isMovePageDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method returns the header title of the move
     * 
     * @author ashish.juyal
     * @return String
     * @throws Exception
     */

    public String getMovePageTitle() throws Exception {
    	strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING THE HEADER OF THE MOVE PAGE");
            frameSwitch.switchToFrameContent();

            if (!lblHeader.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Header' DOES NOT EXISTS");
            }
            strResult = lblHeader.getText();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Header' OF THE MOVE PAGE \n METHOD: getMovePageTitle \n" + e
                            .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method used to enter order number
     * 
     * @author kiran.kumar
     * @param String ,  String
     * @return MoveTextMultimediaItemPage
     * @throws Exception
     */
    public MoveTextMultimediaItemPage setOrdernumber(String strOrderNumber, String strItemName)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: ENTER THE ITEM TO NUMBER");
            frameSwitch.switchToFrameContent();
            txtMoveOrder.replaceValues(strItemName);

            if (!txtMoveOrder.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Move Order' TEXT BOX DOES NOT EXISTS");
            }
            txtMoveOrder.clearAndSendKeys(strOrderNumber);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SETTING THE OREDER NUMBER TO 'Move Order'\n METHOD:setOrdernumber \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on save changes
     * 
     * @author kiran.kumar
     * @return TextMultimediaToolboxPage
     * @throws Exception
     */
    public TextMultimediaToolboxPage clickReorderSavebutton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnReorderSaveChanges.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Re Order Save Button' DOES NOT EXISTS");
            }
            btnReorderSaveChanges.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Re Order Save Button'\n METHOD:clickReorderSavebutton \n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaToolboxPage(uiDriver);
    }

    /**
     * This method used to get order number
     * 
     * @author kiran.kumar
     * @param String
     * @return String
     * @throws Exception
     */
    public String getOrdernumber(String strItemName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: FETCHING THE ITEM TO NUMBER");
            frameSwitch.switchToFrameContent();
            txtMoveOrder.replaceValues(strItemName);

            if (!txtMoveOrder.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Move Order' TEXT BOX DOES NOT EXISTS");
            }

            return txtMoveOrder.getValue();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE OREDER NUMBER FROM 'Move Order'\n METHOD:getOrdernumber \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to verify whether Header Title Is Displayed Or Not
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return boolean
     * @throws Exception
     */

    public boolean isHeaderTitleDisplayed() throws Exception {
    	flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING FOR THE HEADER OF THE MOVE PAGE");
            frameSwitch.switchToFrameContent();
            flag =  lblHeaderTitle.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Header Title'\n METHOD:isHeaderTitleDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method helps to click on Cancel
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @throws Exception
     * @returns TextMultimediaToolboxPage
     */
    public TextMultimediaToolboxPage clickOnCancel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnCancel.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("'Cancel Button' DOES NOT EXISTS");
            }
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Cancel Button' \n METHOD:clickOnCancel \n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaToolboxPage(uiDriver);
    }

    /**
     * This methods helps to enter order for items and click on Save Changes button
     * 
     * @author Chaitali
     * @param String : Content Item
     * 		  String : orderNumber
     * @return MoveTextMultimediaItemPage
     * @throws Exception
     */

    public TextMultimediaToolboxPage reOrderForItem(String strContentItem,int intOrderNumber) throws Exception {
    	try {
        	 logInstruction("LOG INSTRUCTION: ENTER THE ITEM TO NUMBER");
			if (StringUtils.isNotBlank(strContentItem)) {
				frameSwitch.switchToFrameContent();
				txtMoveOrder.replaceValues(strContentItem);
				if (!txtMoveOrder.isDisplayedAfterWaiting(waitTime)) {
					throw new Exception("'Move Order' TEXT BOX DOES NOT EXISTS");
				}
				txtMoveOrder.clearAndSendKeys("" + intOrderNumber);
				logInstruction("LOG INSTRUCTION: CLICKING ON SAVE BUTTON");
				if (!btnReorderSaveChanges.isDisplayedAfterWaiting(waitTime)) {
					throw new Exception(
							"'Re Order Save Button' DOES NOT EXISTS");
				}
				btnReorderSaveChanges.clickAndWait(waitTime);
             }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN REORDERING \n METHOD:reOrderForItem \n" + e
                            .getLocalizedMessage());
        }
        return new TextMultimediaToolboxPage(uiDriver);
    }
}
