package com.pearson.eselenium.ls.common.pages;

import com.pearson.test.eselenium.framework.core.UIDriver;

/**
 * This page is used to open pages which are not related to Application / Testing areas.
 * 
 * @author Praveen
 */
public class ThirdPartyPage extends BasePageObject {
	
	/* Variables */
	private String strURL="";

	/* Constructor */
	public ThirdPartyPage(UIDriver uiDriver) throws Exception {
		super(uiDriver);
        pageTitle = "ThirdPartyPage";
        logInstruction("LOG INSTRUCTION: ## ThirdPartyPage ##");
	}

	/**
     * Method will get the "Third party page" URL
	 * 
	 * @author Praveen.Maled
	 * @return String
	 * @throws Exception
	 * @category  Milestone 2
	 */
	public String getCurrentURL() throws Exception{
		strURL="";
		try{
			logInstruction("LOG INSTRUCTION: GETTING URL OF THE PAGE");
			strURL=	uiDriver.getCurrentUrl();
		}catch(Exception e){
            throw new Exception("ISSUE IN GETTING THE PAGE URL" + "\nMETHOD:getCurrentURL \n" + e
                    .getLocalizedMessage());
		}
		return strURL;
	}

    /**
     * Method will switch to Third party page
     * 
     * @author Praveen.Maled
     * @return ThirdPartyPage
     * @throws Exception
     * @category Milestone 2
     */
    public ThirdPartyPage switchToThirdPartyPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO 'Third party page'");
            uiDriver.getUIWindowLocator().switchToNewWindow();
            /*
             * List<String> windows = new ArrayList<String>();
             * windows.addAll(uiDriver.getWindowHandles());
             * uiDriver.switchTo().window(windows.get(1));
             */
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SWITCHING THE WINDOW TO 'Third party page'" + "\nMETHOD:switchToThirdPartyPage \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will close the "Third party page" and switch's to main window
     * 
     * @author Praveen.Maled
     * @return void
     * @throws Exception
     * @category Milestone 2
     */
    public void closeThirdPartyPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLOSING 'Third party page'");
            uiDriver.close();
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLOSING 'Third party page'" + "\nMETHOD:closeThirdPartyPage \n" + e
                            .getLocalizedMessage());
        }
    }


	
}
