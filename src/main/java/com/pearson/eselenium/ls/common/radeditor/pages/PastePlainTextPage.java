package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class PastePlainTextPage extends BasePageObject {

    public PastePlainTextPage(UIDriver driver) {
        super(driver);

    }

    private UIElement areapasteasplain = createElement(UIType.Css, "#holder");
    private UIElement btnpaste = createElement(UIType.Css, "#InsertButton");
    private String browser=System.getProperty("brower.NAME");
    /**
     * This Method will check Whether Plain text Paste functionality is working or not
     * 
     * @return boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isPastePlainText() throws Exception {
        boolean flag = false;
        String data = null;
        try {
            uiDriver.getUIWindowLocator().switchToNewWindow();
            data = uiDriver.getTitle();
            if (data.contains("Paste Plain Text"))
                flag = true;
            uiDriver.close();
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception(
                    " NOT ABLE TO GET THE PLAIN TEXT PASTE  \n METHOD :  isPastePlainText");
        }
        return flag;

    }

    public void pasteAsPlainText(String text) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : PASTING AS PLAIN TEXT ");
            if(browser.equalsIgnoreCase("InternetExplorer")){
            	logInstruction("LOG INSTRUCTION: PASTED IN IE.");
            	uiDriver.getUIWindowLocator().switchToFirstWindow();
            }else{
            uiDriver.getUIWindowLocator().switchToNewWindow();
            uiDriver.waitToBeDisplayed(areapasteasplain, waitTime);
            areapasteasplain.sendKeys(text);
            uiDriver.waitToBeDisplayed(btnpaste, waitTime);
            btnpaste.clickNoWait();
            uiDriver.close();
            uiDriver.getUIWindowLocator().switchToFirstWindow();
            }

        } catch (Exception e) {
            throw new Exception("NOT ABLE TO GET THE TEXT AREA \n METHOD : pasteAsPlainText");
        }
    }
}
