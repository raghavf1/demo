package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.utils.AutoITMethods;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

public class PasteAsHtmlPage extends BasePageObject {

	public PasteAsHtmlPage(UIDriver driver) {
		super(driver);
	}

	private UIElement areatext=createElement(UIType.Xpath, "//html/body");
	private UIElement btninsert=createElement(UIType.Xpath, "//div[@id='initializer']//button[@id='InsertButton']");

	/**
	 * This Method will check Whether HTML Paste functionality is working or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isPasteAsHTML() throws Exception {
		boolean flag = false;
		String data = null;
		try {
			uiDriver.getUIWindowLocator().switchToNewWindow();
			data = uiDriver.getTitle();
			if (data.contains("Paste As Html"))
				flag = true;
			uiDriver.close();
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception(
					" NOT ABLE TO GET THE HTML PASTE \n METHOD :  isPasteAsHTML ");
		}
		return flag;

	}
	
	/**
	 * This Method will check Whether HTML Paste functionality is working or not
	 * 
	 * @param String
	 * @return PasteAsHtmlPage
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public PasteAsHtmlPage pasteAsHTML(String text) throws Exception {
		try {
			logInstruction("LOG INSTRCUTION : PASTING HTML TEXT");
			if(getBrowser().equals(Browser.INTERNETEXPLORER)){
            	AutoITMethods autoit=new AutoITMethods();
            	autoit.handleClipboardAccessPopUp("Allow access");
            	uiDriver.getUIWindowLocator().switchToFirstWindow();
            }else{
			uiDriver.getUIWindowLocator().switchToNewWindow();
			uiDriver.getUIFrameLocator().selectFrame("holder");
			uiDriver.waitToBeDisplayed(areatext, waitTime);
			areatext.sendKeys(text);
            }

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TEXT AREA \n METHOD :pasteAsHTML");
		}
		return this;

	}

	/**
	 * This Method will check Whether HTML Paste functionality is working or not
	 * 
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void clickPaste() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION :CLICKING ON PASTE BUTTON");
			if(getBrowser().equals(Browser.INTERNETEXPLORER)){
				logInstruction("NO CLICK PASTE BUTTON FOR IE.");
			}else{
			uiDriver.switchTo().defaultContent();
			uiDriver.waitToBeDisplayed(btninsert, waitTime);
			btninsert.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();
			}
		} catch (Exception e) {
			logInstruction("UNABLE TO CLICK ON PASTE BUTTON \n METHOD :clickPaste ");
		}
	}

}