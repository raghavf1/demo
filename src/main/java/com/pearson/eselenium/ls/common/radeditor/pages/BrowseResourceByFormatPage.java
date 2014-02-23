package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all methods related to BrowseResourceByFormatPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class BrowseResourceByFormatPage extends BasePageObject {

	/* Elements */
	private UIElement lnkImages = createElement(UIType.Xpath,
			"//a[text()='Images']");
	private UIElement lnkVideo = createElement(UIType.Xpath,
			"//a[text()='Video']");
	private UIElement lnkDocuments = createElement(UIType.Xpath,
			"//a[text()='Documents']");
	private UIElement lnkOthers = createElement(UIType.Xpath,
			"//a[text()='Other']");

	/* Constructor */
	public BrowseResourceByFormatPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION : ### BrowseResourceByFormatPage ###");
	}

	/**
	 * Method helps to switch the window
	 * 
	 * @author Pratush.Manglik
	 * @throws Exception
	 */
	public void switchToWindow() throws Exception {
		try {
			uiDriver.getUIWindowLocator().switchToNewWindow();
			logInstruction("LOG INSTRUCTION : SWITCHED THE WINDOW TO LINKCOURSE TOOL PAGE");
		} catch (Exception e) {
			throw new Exception("UNABLE TO SWITCH THE WINDOW \n METHOD:switchToWindow"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method is used to click on Images link
	 * 
	 * @author Pratush.Manglik
	 * @return EquellaImagesPage
	 * @throws Exception
	 */
	public EquellaImagesPage selectImages() throws Exception {
		try {
			frameSwitch.switchToAddLinkFrame();
			uiDriver.waitToBeDisplayed(lnkImages, waitTime);
			lnkImages.clickNoWait();
			logInstruction("LOG INSTRUCTION : CLICKED ON IMAGES LINK");
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON IMAGES LINK \n METHOD:selectImages"
					+ e.getLocalizedMessage());
		}
		return new EquellaImagesPage(uiDriver);
	}

	/**
	 * This method is used to click on Video link
	 * 
	 * @author Pratush.Manglik
	 * @return EquellaVideoPage
	 * @throws Exception
	 */
	public EquellaVideoPage selectVideo() throws Exception {
		try {
			frameSwitch.switchToAddLinkFrame();
			uiDriver.waitToBeDisplayed(lnkVideo, waitTime);
			lnkVideo.clickNoWait();
			logInstruction("LOG INSTRUCTION : CLICKED ON VIDEO LINK");
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON VIDEO LINK \n METHOD:selectVideo"
					+ e.getLocalizedMessage());
		}
		return new EquellaVideoPage(uiDriver);
	}

	/**
	 * This method is used to click on Documents link
	 * 
	 * @author Pratush.Manglik
	 * @return EquellaDocumentPage
	 * @throws Exception
	 */
	public EquellaDocumentPage selectDocuments() throws Exception {
		try {
			frameSwitch.switchToAddLinkFrame();
			uiDriver.waitToBeDisplayed(lnkDocuments, waitTime);
			lnkDocuments.clickNoWait();
			logInstruction("LOG INSTRUCTION : CLICKED ON DOCUMENTS LINK");
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON DOCUMENTS LINK \n METHOD:selectDocuments"
					+ e.getLocalizedMessage());
		}
		return new EquellaDocumentPage(uiDriver);
	}

	/**
	 * This method is used to click on Documents link
	 * 
	 * @author Pratush.Manglik
	 * @return EquellaDocumentPage
	 * @throws Exception
	 */
	public EquellaDocumentPage selectOthers() throws Exception {
		try {
			frameSwitch.switchToAddLinkFrame();
			uiDriver.waitToBeDisplayed(lnkOthers, waitTime);
			lnkOthers.clickNoWait();
			logInstruction("LOG INSTRUCTION : CLICKED ON OTHERS LINK");
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON OTHERS LINK \n METHOD:selectOthers"
					+ e.getLocalizedMessage());
		}
		return new EquellaDocumentPage(uiDriver);
	}

}
