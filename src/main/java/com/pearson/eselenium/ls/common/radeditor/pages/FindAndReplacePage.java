package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class FindAndReplacePage extends BasePageObject {

	/* Elements */
	private UIElement findtextbox=createElement(UIType.ID, "find");
	private UIElement findbutton=createElement(UIType.ID, "FindButton");
	private UIElement closebutton=createElement(UIType.ID, "CloseButton");;
	private UIElement matchcasecheckbox=createElement(UIType.ID, "_rfdSkinnedmatchCaseFind");
	private UIElement replacetab=createElement(UIType.Xpath, "//span[contains(text(),'Replace')]");
	private UIElement replacetabfindtextbox=createElement(UIType.ID, "rFind");
	private UIElement replacetext=createElement(UIType.ID, "rReplace");
	private UIElement findnextbutton=createElement(UIType.ID, "rFindButton");
	private UIElement replacebutton=createElement(UIType.ID, "ReplaceButton");
	private UIElement replacetabclosebutton=createElement(UIType.ID, "CloseButton");

	/* Constructor */
	public FindAndReplacePage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## FIND AND REPLACE PAGE ## ");
	}

	/**
	 * This method helps to enter text in find box
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public FindAndReplacePage enterText(String text) throws Exception {
		try {
		 logInstruction("LOG INSTRUCTION:ENTERING THE TEXT IN THE FIND TEXT BOX"+"/n"+"METHOD:enterText");
		  	uiDriver.getUIWindowLocator().switchToNewWindow();
			uiDriver.waitToBeDisplayed(findtextbox, waitTime);
			findtextbox.sendKeys(text);
		} catch (Exception e) {
		 throw new Exception("UNABLE TO ENTER TEXT"+e.getLocalizedMessage());
	 }return this;
	}

	/**
	 * This method helps to click the find button
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public void clickFindButton() throws Exception {
		try {
		 logInstruction("LOG INSTRUCTION:CLICKING THE FIND BUTTON"+"METHOD:clickFindButton");
		 	uiDriver.switchTo().defaultContent();
			uiDriver.waitToBeDisplayed(findbutton, waitTime);
			findbutton.clickNoWait();
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
		 throw new Exception("UNABLE TO CLICK THE FIND BUTTON"+e.getLocalizedMessage());
		}
	}

	/**
	 * This method helps to click the close button
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public void clickCloseButton() throws Exception {
		try {
 		 logInstruction("LOG INSTRUCTION:CLICKING THE CLOSE BUTTON"
 				 +"METHOD:clickCloseButton");
 		 	uiDriver.switchTo().defaultContent();
			uiDriver.waitToBeDisplayed(closebutton, waitTime);
			closebutton.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();

		} catch (Exception e) {
 		throw new Exception("UNABLE TO CLICK THE CLOSE BUTTON"+e.getLocalizedMessage());
		}
	}

	/**
	 * This method helps to click the match case checkbox
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public void clickMatchCaseCheckbox() throws Exception {
		try {
  		 logInstruction("LOG INSTRUCTION:CLICKING THE MATCH CASE CHECKBOX BUTTON METHOD:clickMatchCaseCheckbox");
			uiDriver.waitToBeDisplayed(matchcasecheckbox, waitTime);
  		 matchcasecheckbox.clickNoWait();

		} catch (Exception e) {
  		 throw new Exception("UNABLE TO CLICK THE MATCHCASE CHECK BOX"+e.getLocalizedMessage());
		}
	}

	/**
	 * This method helps to click the replace tab
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public void clickReplaceTab() throws Exception {
		try {
   		 logInstruction("LOG INSTRUCTION:CLICKING THE MATCH CASE CHECKBOX BUTTON METHOD:clickReplaceTab");
   		 	uiDriver.switchTo().defaultContent();
			uiDriver.waitToBeDisplayed(replacetab, waitTime);
			replacetab.clickNoWait();

		} catch (Exception e) {
   		 throw new Exception("UNABLE TO CLICK THE REPLACE TAB"+e.getLocalizedMessage());
		}
	}

	/**
	 * This method helps to enter the text in replace tab find text box
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public FindAndReplacePage enterRplacetabFindTextbox(String text)
			throws Exception {
		try {
    		 logInstruction("LOG INSTRUCTION:ENTERING THE TEXT IN THE REPLACE TAB FIND TEXT BOX METHOD:enterRplacetabFindTextbox");
    		 uiDriver.switchTo().defaultContent();
			uiDriver.waitToBeDisplayed(replacetabfindtextbox, waitTime);
			replacetabfindtextbox.clearAndSendKeys(text);
		} catch (Exception e) {
    		 throw new Exception("UNABLE TO ENTER TEXT"+e.getLocalizedMessage());
    	 }return this;
	}

	/**
	 * This method helps to enter the text in replace tab replace with text box
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */

	public FindAndReplacePage enterRplacetabReplaceextbox(String text)
			throws Exception {
		try {
    		 logInstruction("LOG INSTRCUTION: ENTERING THE TEXT IN THE REPLACE TAB REPLACE WITH TEXT BOX METHOD:enterRplacetabReplaceextbox");
			uiDriver.waitToBeDisplayed(replacetext, waitTime);
			replacetext.sendKeys(text);
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
    		 throw new Exception("UNABLE TO ENTER TEXT"+e.getLocalizedMessage());
    	 }return this;
	}

	/**
	 * This method help to click the find next button
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public void clickFindnextButton() throws Exception {
		try {
		  logInstruction("LOG INSTRUCTION:CLICKING THE FIND NEXT BUTTON METHOD:clickFindnextButton");
			uiDriver.waitToBeDisplayed(findnextbutton, waitTime);
			findnextbutton.clickNoWait();
		} catch (Exception e) {
			throw new Exception("unable to click the find next button"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method help to click the replace button
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public FindAndReplacePage clickReplaceButton() throws Exception {
		try {
		  logInstruction("LOG INSTRCUTION: CLICKING THE REPLACE  BUTTON METHOD:clickReplaceButton");
		  	uiDriver.switchTo().defaultContent();
			uiDriver.waitToBeDisplayed(replacebutton, waitTime);
			replacebutton.clickNoWait();
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
		  throw new Exception("UNABLE TO CLICK THE FIND NEXT BUTTON"+e.getLocalizedMessage()) ;
		}
		return this;
	}

	/**
	 * This method help to click the close button in replace tab
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public void clickReplaceTabCloseButton() throws Exception {
		try {
		  logInstruction("LOG INSTRUCTION:CLICKING THE CLOSE  BUTTON METHOD:clickReplaceTabCloseButton ");
			uiDriver.waitToBeDisplayed(replacetabclosebutton, waitTime);
			replacetabclosebutton.clickNoWait();
		} catch (Exception e) {
		  throw new Exception("UNABLE TO CLICK THE CLOSE BUTTON"+e.getLocalizedMessage()) ;
		}
	}
	
	public boolean isFindAndReplacePageDisplayed() throws Exception{
		boolean flag=false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING FIND AND REPLACE PAGE ");
			uiDriver.getUIWindowLocator().switchToNewWindow();
			if(findbutton.isDisplayedAfterWaiting(waitTime)){
			flag= true;
			}
			uiDriver.close();
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("UNABLE TO FIND THE FIND AND REPLACE BUTTION ");
		}
		uiDriver.getUIWindowLocator().switchToFirstWindow();
		return flag;
	}
	
	/**
     * Method helps to find the specified key
     * 
     * @author Praveen.Maled
     * @param strKey
     * @throws Exception
     * @category Milestone 2
     */
    public void findKey(String strKey) throws Exception{
    	 try {
             logInstruction("LOG INSTRUCTION:ENTERING THE TEXT IN THE FIND TEXT BOX AND FINDING THE KEY" );
             uiDriver.getUIWindowLocator().switchToNewWindow();
             uiDriver.waitToBeDisplayed(findtextbox, waitTime);
             findtextbox.sendKeys(strKey);
             logInstruction("LOG INSTRUCTION:CLICKING THE FIND BUTTON");
             uiDriver.waitToBeDisplayed(findbutton, waitTime);
             findbutton.clickNoWait();
             uiDriver.getUIAlert().acceptAlertIfPresent();
         } catch (Exception e) {
             throw new Exception("ISSUE IN FINDING KEY"+"\nMETHOD:findKey\n" + e.getLocalizedMessage());
         }
    }
}
