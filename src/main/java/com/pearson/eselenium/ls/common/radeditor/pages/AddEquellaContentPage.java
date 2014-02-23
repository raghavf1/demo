package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.contentitems.unit.pages.UnitIntroductionPage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddEquellaContentPage extends BasePageObject {
	public AddEquellaContentPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("## AddEquellaContent Page ##");
	}	

	private UIElement clickCancel = createElement(UIType.Xpath,
			"//input[@value='Cancel']");
	private UIElement btnRadio = createElement(UIType.Xpath,
			"//input[@id='linkType']");
	private UIElement divConnecttoEquella = createElement(UIType.Xpath,
			"{//div[@class='tablehead']");
	
	private boolean flag = false;
	private String data = null;

	/**
	 * Method helps to click on cancel button
	 * 
	 * @return UnitIntroductionPage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public UnitIntroductionPage clickCancelButton() throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(clickCancel, waitTime);
			clickCancel.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK DeleteContentAndResponses Button \n METHOD:clickCancelButton" + e
                    .getLocalizedMessage());
		}
		return new UnitIntroductionPage(uiDriver);
	}

	/**
	 * Method helps to verify link to file radio button is selected.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isLinkToFilesSelectedByDefault() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY LINK TO FILE IS SELECTED");
			frameSwitch.switchToAddLinkFrame();
			if (btnRadio.isSelected()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("RADIO BUTTON IS NOT SELECTED BY DEFAULT \n METHOD:isLinkToFilesSelectedByDefault"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check whether Equella Link is working or not
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isConnectToEquella() throws Exception {
		flag = false;		
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR CONNECT TO EQUELLA");
			// List<String>windowhandle=new ArrayList<String>();
			// windowhandle= (List<String>) uiDriver.getWindowHandles();
			// uiDriver.switchTo().window(windowhandle.get(1));
			uiDriver.getUIWindowLocator().switchToNewWindow();
			uiDriver.getUIFrameLocator().selectFrame("popupcontent");
			uiDriver.waitToBeDisplayed(divConnecttoEquella, waitTime);
			data = divConnecttoEquella.getText().trim();
			if (data.equals("Add Content from Equella"))
				flag = true;
			uiDriver.close();
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE CONNECT TO EQUELLA \n METHOD :isConnectToEquella");
		}
		return flag;
	}
}
