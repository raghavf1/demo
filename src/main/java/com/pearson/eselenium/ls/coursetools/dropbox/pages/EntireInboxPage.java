package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EntireInboxPage extends BasePageObject{
	
	/* Elements */
	private UIElement studentlink=createElement(UIType.Xpath,"//form[@id='EntireInbox']//table[4]//td[3]/a[1]");
	private UIElement outbox=createElement(UIType.LinkText,"Outbox");
	private UIElement BasketIbox=createElement(UIType.LinkText, "Baskets");

	/* Constructor */
	public EntireInboxPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## Entire Inbox Page ##");
	}

	
	public DropboxInboxPage clickStudentlink() throws Exception{
		try{
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(studentlink, waitTime);
			studentlink.clickAndWait(waitTime);
		}catch(Exception e){
			throw new Exception("Unable to click the stuedent link"+e.getLocalizedMessage());
		}return new DropboxInboxPage(uiDriver);
	}
	
	
	public DropboxInboxPage clickOutboxlink() throws Exception{
		try{
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(outbox, waitTime);
			outbox.clickAndWait(waitTime);
		}catch(Exception e){
			throw new Exception("Unable to click the stuedent link"+e.getLocalizedMessage());
		}return new DropboxInboxPage(uiDriver);
	}
	
	
	public BasketHomePage clickBasket() throws Exception{
		try{
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(BasketIbox, waitTime);
			BasketIbox.clickAndWait(waitTime);
		}catch(Exception e){
			throw new Exception("Unable to click the stuedent link"+e.getLocalizedMessage());
		}return new BasketHomePage(uiDriver);
	}
	
	
}
