package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods of Assignment Page. Navigation --> 1) Login as Prof/Admin 2) Select Course
 * 3) Click 'Dropbox' 4) Click 'Basket' Tab
 * 
 * @author soundarya
 * @modifiedBy Vivek.Singh -- as per code review comments by Lanka Pearson
 * **/
public class BasketHomePage extends BasePageObject {

    /* Elements */
    private UIElement txtContentItem = createElement(
            UIType.Xpath,
            "//form/table//tr//td/table//tr//th/a[contains(.,'{1}')]");
    private UIElement listOfBasket = createElement(UIType.Xpath, "//table/tbody/tr[2]//th//a");
    private UIElement lnkSelectBasket = createElement(UIType.Css, "a[title='{1}']");
    private UIElement tabInboxView = createElement(
            UIType.Xpath,
            "//table[2]/tbody/tr/td[2][@class='tableheadtabON'][contains(text(),'Inbox')]");
    private UIElement tabOutboxView = createElement(
            UIType.Xpath,
            "//td[@class='tableheadtabON'][contains(text(),'Outbox')]");
    private UIElement lnkStudentName = createElement(
            UIType.Xpath,
            "//td[@class='threadborder']//a[contains(text(),'{1}')]");
    private UIElement lnkInbox = createElement(UIType.Css, "a[title='Inbox']");
    private UIElement lnkOutbox = createElement(UIType.Css, "a[title='Outbox']");
    private UIElement lnkNoSubmissions = createElement(UIType.Css, "a[title='No Submissions']");
    private UIElements lstAttachedFiles = createElements(
            UIType.Xpath,
            "//a[@href[contains(.,'DownloadAttachment')]]/img");
    private UIElement imgAttachedFile = createElement(
            UIType.Xpath,
            "//a[@href[contains(.,'DownloadAttachment')]]/img[@title='{1}']");
 	private UIElement txtNumericGrade=createElement(UIType.Xpath, "//td[a[contains(text(),'{1}')]]/following-sibling::td[3]/input");
    private UIElement btnSave=createElement(UIType.Css, "#save");
    private UIElement txtLetterGrade=createElement(UIType.Xpath, "//td[a[contains(text(),'{1}')]]/following-sibling::td[4]/input");
    private UIElement chkReturn=createElement(UIType.Xpath, "//td[a[contains(text(),'{1}')]]/following-sibling::td[5]/input");
    private boolean flag = false;
    private List<UIElement> list = null;
    private int intTotlaList = 0;

    /* Constructor */
    public BasketHomePage(UIDriver driver) {
        super(driver);
        pageTitle = "Basket Home";
        logInstruction("LOG INSTRUCTION: ## BasketHomePage ##");
    }

    /**
     * This method will check content item is displayed
     * 
     * @author soundarya
     * @param String
     *            -contentItem
     * @return boolean
     * @throws Exception
     * 
     **/
    public boolean isContentItemDisplayed(String strContentItem) throws Exception {
        flag = false;
        try {
            if (StringUtils.isNotBlank(strContentItem)) {
            logInstruction("LOG INSTRUCTION: IS SELECT CONTENT ITEM  " + strContentItem + "DISPLAYED.");
            frameSwitch.switchToFrameContent();
            txtContentItem.replaceValues(strContentItem);
                flag = txtContentItem.isDisplayedAfterWaiting(waitTime);
            } else
                throw new Exception("PARAMETERS ARE BLANK. \nMETHOD: isContentItemDisplayed \n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK CONTENT ITEM  " + strContentItem + "DISPLAYED. \nMETHOD: isContentItemDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will select content item. Navigates to {@link BasketInboxPage}
     * 
     * @author soundarya
     * @param String
     *            -assignment
     * @return {@link BasketInboxPage}
     * @throws Exception
     **/
    public BasketInboxPage clickContentItem(String strContentItem) throws Exception {

        try {
            if (StringUtils.isNotBlank(strContentItem)) {
            logInstruction("LOG INSTRUCTION: CLICK CONTENT ITEM  " + strContentItem + "DISPLAYED");
            frameSwitch.switchToFrameContent();
            txtContentItem.replaceValues(strContentItem);
            uiDriver.waitToBeDisplayed(txtContentItem, waitTime);
            txtContentItem.clickAndWait(waitTime);
            } else
                throw new Exception("PARAMETERS ARE BLANK. \nMETHOD: clickContentItem \n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK CONTENT ITEM" + strContentItem + "DISPLAYED. \nMETHOD: clickContentItem.\n" + e
                            .getLocalizedMessage());
        }
        return new BasketInboxPage(uiDriver);
    }

    /**
     * Method help to check whether list of basket displayed or not.
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return boolean true-if basket contains items false if basket is empty
     * @throws Exception
     */
    public boolean isListOfBasketDisplayed() throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION:CHECKING FOR LIST OF 'Basket' DISPLAYED OR NOT");
            frameSwitch.switchToFrameContent();
            flag = listOfBasket.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO FIND LIST OF 'Basket'. \nMETHOD: isListOfBasketDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will select a particular Dropbox basket on BasketHomePage Page. Navigates to
     * {@link BasketHomePage}.
     * 
     * @author Vivek.Singh
     * @param String
     *            basketName
     * @return {@link BasketHomePage}
     * @throws Exception
     * **/
    public BasketHomePage clickBasket(String strBasketName) throws Exception {
        try {
            if (StringUtils.isNotBlank(strBasketName)) {
                logInstruction("LOG INSTRUCTION: SELECTING " + strBasketName + " BASKET.");
            frameSwitch.switchToFrameContent();
                lnkSelectBasket.replaceValues(strBasketName);
            uiDriver.waitToBeDisplayed(lnkSelectBasket, waitTime);
            lnkSelectBasket.clickAndWait(waitTime);
            } else
                throw new Exception("PARAMETERS ARE BLANK. \nMETHOD: clickBasket \n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT " + strBasketName + " BASKET.\nMETHOD: clickBasket.\n" + e
                            .getLocalizedMessage());
        }
        return new BasketHomePage(uiDriver);
    }

    /**
     * Method help to check whether 'Inbox' view displayed
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return boolean true if 'Inbox' view displayed, false if 'Inbox' view not displayed
     * @throws Exception
     */
    public boolean isInboxViewDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR 'Inbox' VIEW DISPLAYED OR NOT");
            frameSwitch.switchToFrameContent();
            flag = tabInboxView.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:UNABLE TO DISPLAY 'Inbox' VIEW. \nMETHOD: isInboxViewDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method help to check whether 'Outbox' view displayed
     * 
     * @category MileStone2
     * @author Vivek.Singh
     * @return boolean true if 'Inbox' view displayed, false if 'Inbox' view not displayed
     * @throws Exception
     */
    public boolean isOutboxViewDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:CHECKING FOR 'Outbox' VIEW DISPLAYED OR NOT");
            frameSwitch.switchToFrameContent();
            flag = tabOutboxView.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:UNABLE TO DISPLAY 'Outbox' VIEW. \nMETHOD: isOutboxViewDisplayed.\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method help to click on 'Students' name link. Navigates to {@link DropboxInboxPage}.
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return {@link DropboxInboxPage}
     * @param {@link String} -- studName
     * @throws Exception
     */
    public DropboxInboxPage clickStudentName(String strStudName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON " + strStudName + " LINK");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strStudName)) {
                lnkStudentName.replaceValues(strStudName);
                if (lnkStudentName.isDisplayedAfterWaiting(waitTime)) {
                	if(getBrowser().equals(Browser.INTERNETEXPLORER))
                		lnkStudentName.clickByJavascript();
                	else
                    lnkStudentName.clickAndWait(waitTime);
                    uiDriver.getUIWindowLocator().switchToNewWindow();
                    logInstruction("LOG INSTRUCTION: SUCCESSFULLY CLICKED ON " + strStudName + " LINK");
                } else
                    logInstruction("LOG INSTRUCTION: " + strStudName + " WITH LINK NOT DISPLAYED.");
            } else {
                throw new Exception("STUDENT NAME IS BLANK.\nMETHOD: clickStudentName.\n");
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON " + strStudName + " LINK. \nMETHOD: clickStudentName.\n" + e
                            .getLocalizedMessage());
        }
        return new DropboxInboxPage(uiDriver);
    }

    /**
     * This method will enter Grade in In Grade Text box
     * @param StudName
     * @param Marks Grade which you wamt to enter
     * @return
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public BasketHomePage enterNumericGrade(String strStudName, String strMarks) throws Exception {
    	try {
            if (StringUtils.isNotBlank(strStudName) && StringUtils.isNotBlank(strMarks)) {
    		logInstruction("LOG INSTRCUTION : ENTERING GRADE ");
    		frameSwitch.switchToFrameContent();
                txtNumericGrade.replaceValues(strStudName);
    		uiDriver.waitToBeDisplayed(txtNumericGrade, waitTime);
                txtNumericGrade.clearAndSendKeys(strMarks);
            } else
                throw new Exception("PARAMETERS ARE BLANK. \nMETHOD: enterNumericGrade\n");
		} catch (Exception e) {
            throw new Exception("UNABLE TO ENTER THE MARKS \n METHOD:enterNumericGrade.\n");
		}
    	return this;
    }
 /**
     * Methods helps to click on inbox link
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return BasketHomePage
     * @throws Exception
     */
    public BasketHomePage clickOnInbox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON INBOX LINK");
            frameSwitch.switchToFrameContent();
            if (lnkInbox.isDisplayedAfterWaiting(waitTime)) {
            	if(getBrowser().equals(Browser.INTERNETEXPLORER))
            		lnkInbox.clickByJavascript();
            	else
                lnkInbox.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON INBOX LINK");
            } else
                throw new Exception("INBOX LINK NOT DISPLAYED.\n METHOD: clickOnInbox.\n");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON INBOX LINK. \n METHOD: clickOnInbox.\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }
    /**
     * This Method will click on Save  changes button
     * @return {@link DropboxPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public BasketHomePage clickSaveChangesButton() throws Exception{
    	try {
    		logInstruction("LOG INSTRCUTION: CLICKING ON SAVE BUTTON");
    		frameSwitch.switchToFrameContent();
    		uiDriver.waitToBeDisplayed(btnSave,waitTime);
    		btnSave.clickAndWait(waitTime);
			
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON SAVE BUTTON \n METHOD: clickSaveButton");
		}
    	return new BasketHomePage(uiDriver);
    }

	/**
     * Methods helps to click on outbox link
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return DropboxPage
     * @throws Exception
     */
    public BasketHomePage clickOnOutbox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON OUTBOX LINK");
            frameSwitch.switchToFrameContent();
            if (lnkOutbox.isDisplayedAfterWaiting(waitTime)) {
            	if(getBrowser().equals(Browser.INTERNETEXPLORER))
            		lnkOutbox.clickByJavascript();
            	else
                lnkOutbox.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON OUTBOX LINK");
            } else
                throw new Exception("OUTBOX LINK NOT DISPLAYED.\n METHOD: clickOnOutbox.\n");
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON OUTBOX LINK \n METHOD: clickOnOutbox.\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to click on no submissions
     * 
     * @category MileStone2
     * @author Chaitali.Barhate
     * @return DropboxPage
     * @throws Exception
     */
    public BasketHomePage clickOnNoSubmissions() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON NOSUBMISSIONS LINK");
            frameSwitch.switchToFrameContent();
            if (lnkNoSubmissions.isDisplayedAfterWaiting(waitTime)) {
                lnkNoSubmissions.clickAndWait(waitTime);
                logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON NOSUBMISSIONS LINK");
            } else
                throw new Exception(
                        "NOSUBMISSIONS LINK NOT DISPLAYED.\n METHOD: clickOnNoSubmissions.\n");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON NOSUBMISSIONS LINK \n METHOD: clickOnNoSubmissions.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method checks if file is attached or not
     * 
     * @return boolean
     * @author chaitali
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public BasketHomePage enterLetterGrade(String strStudName, String strGrade) throws Exception {
    	try {
            if (StringUtils.isNotBlank(strStudName) && StringUtils.isNotBlank(strGrade)) {
    		logInstruction("LOG INSTRCUTION : ENTERING GRADE ");
    		frameSwitch.switchToFrameContent();
                txtLetterGrade.replaceValues(strStudName);
    		uiDriver.waitToBeDisplayed(txtNumericGrade, waitTime);
                txtLetterGrade.clearAndSendKeys(strGrade);
            } else
                throw new Exception("PARAMETERS ARE NOT PROVIDED. \nMETHOD: enterLetterGrade \n");
		} catch (Exception e) {
            throw new Exception("UNABLE TO ENTER THE MARKS \n METHOD: enterLetterGrade \n");
		}
    	return this;
    }


	 /**
     * This method checks if file is attached or not
     * 
     * @return boolean
     * @author chaitali
     * @throws Exception
     */
    public boolean isFileAttachedDisplayed(String strNameOfFile) throws Exception {
        flag = false;
        try {

            logInstruction("LOG INSTRUCTION: CHECKING SELECTED FILE ATTACHED OR NOT");
            frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strNameOfFile)) {
                list = lstAttachedFiles.getUIElementsList();
                intTotlaList = list.size();
                for (int i = 0; i < intTotlaList; i++) {
                    if (list.get(i).getAttribute("title").equals(strNameOfFile)) {
                        flag = true;
                        break;
                    }
                    uiDriver.sleep(1000, "Unable to get title in IE.");
                }
            } else {
                logInstruction("LOG INSTRUCTION: FILE NAME BLANK");
                flag = false;
            }
        } catch (Exception e) {
            logInstruction(e.getMessage());
            throw new Exception("NOT ABLE TO FIND ATTACHED FILE \n METHOD:isFileAttachedDisplayed");
        }
        return flag;
    }
    /**
     * This Methdo will check the Return chck box
     * @return {@link BasketHomePage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public BasketHomePage selectReturnCheckbox(String strStudname) throws Exception {
    	try {
    		logInstruction("LOG INSTRCUTION : CHECKING CHECKBOX");
    		frameSwitch.switchToFrameContent();
            chkReturn.replaceValues(strStudname);
    		uiDriver.waitToBeDisplayed(chkReturn, waitTime);
    		chkReturn.clickAndWait(waitTime);
			
		} catch (Exception e) {
			throw new Exception("UNABLE TO CHECK THE CHECKBOX \n METHOD: selectReturnCheckbox ");
		}
    	return this;
    }


    /**
     * Method helps to click on files attached in outbox or inbox view.
     * 
     * @author Vivek.Singh
     * @param String
     * @return {@link BasketHomePage}
     * @throws Exception
     * **/
    public BasketHomePage clickOnFile(String strFileName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING SELECTED FILE TO DOWNLOAD.");
            frameSwitch.switchToFrameContent();
            imgAttachedFile.replaceValues(strFileName);
            uiDriver.waitToBeDisplayed(imgAttachedFile, waitTime);
            if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
                imgAttachedFile.clickByJavascript();
            } else
                imgAttachedFile.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON FILE: " + strFileName + ".\nMETHOD: clickOnFile.\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }
}
