package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class PasteFromWordPage extends BasePageObject {

    public PasteFromWordPage(UIDriver driver) {
        super(driver);
        logInstruction("######## PasteFromWordPage #########");

    }

    private UIElement areapasteText = createElement(UIType.Xpath, "//html");
    private UIElement btnclickPasteButton = createElement(
            UIType.Css,
            "#dialogControl>table>tbody>tr:nth-of-type(2)>td>a:nth-of-type(1)>button");

    /**
     * @author Suchi.Singh
     * @return PasteFromWordPage
     * @throws Exception
     *             This method will paste text into text field.
     */
    public PasteFromWordPage pasteTextIntoTextField(String text) throws Exception {
        try {
            logInstruction("LOG INSTRUICTION : PASTE THE TEXT INTO TEXT AREA");

            uiDriver.waitToBeDisplayed(areapasteText, waitTime);
            areapasteText.sendKeys(text);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO PASTE DATA INTO TEXT FIELD \n METHOD : pasteTextIntoTextField" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * @author Suchi.Singh
     * @return PasteFromWordPage
     * @throws Exception
     *             This method will click on paste button.
     */
    public PasteFromWordPage clickOnPasteButton() throws Exception {
        try {
            logInstruction("LOG INSTRUICTION :CLICK ON PASTE BUTTON");

            uiDriver.waitToBeDisplayed(btnclickPasteButton, waitTime);
            btnclickPasteButton.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON PASTE BUTTON \n METHOD :clickOnPasteButton " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This Method will check Whether Word Paste functionality is working or not
     * 
     * @return boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isPasteAsWord() throws Exception {
        boolean flag = false;
        String data = null;
        try {
            uiDriver.getUIWindowLocator().switchToNewWindow();
            data = uiDriver.getTitle();
            if (data.contains("Paste from Word"))
                flag = true;
            uiDriver.close();
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception("NOT ABLE TO GET THE WORD PASTE  \n METHOD :isPasteAsWord  ");
        }
        return flag;

    }

}
