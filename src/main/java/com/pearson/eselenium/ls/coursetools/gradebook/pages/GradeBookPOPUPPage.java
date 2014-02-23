package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;

public class GradeBookPOPUPPage extends BasePageObject {

    public GradeBookPOPUPPage(UIDriver driver) {
        super(driver);
    }

    private UIElement clickSubmitAssign;
    private UIElement clickRespondButton;
    private VisualEditor visualEditor;
    private String ToolID = "RadeEntryText";
    private String frameID = "RadeEntryText_contentIframe";

    public VisualEditor getVisualEditor() {
        return visualEditor;
    }

    public void clickSubmitassginment() throws Exception {
        try {
            uiDriver.switchTo().frame("generalBottomFrame");
            clickSubmitAssign.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: UNABLE TO CLICK ON SUBMIT BUTTON");
        }
    }

    public GradeBookPOPUPPage clickRespondAndSubmitLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: clicking on Respond link");
            uiDriver.switchTo().frame("generalBottomFrame");
            clickRespondButton.clickAndWait(waitTime);
        } catch (Exception e) {
            logInstruction("LOG INSTRUCTION: unable to get the respond link");
        }
        return this;
    }

}
