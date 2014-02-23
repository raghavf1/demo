package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class GradebookPointsWebliography extends BasePageObject {

	private String RadEditorframeid = "RadeEntryText_contentIframe";
	private String RadEditortoolid = "RadeEntryText";
	private VisualEditor visualeditor = new VisualEditor(uiDriver,
			RadEditortoolid, RadEditorframeid, RadEditortoolid);
	private UIElement SaveAndCloseButton = createElement(UIType.Xpath,
			"//input[@id='Button3']");

	public VisualEditor getVisualEditor() {
		return visualeditor;
	}

	public GradebookPointsWebliography(UIDriver uiDriver) {
		super(uiDriver);

	}

	public MyGradeBookPage clickSaveandCloseButton() throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:Clicking the save and close button");
			frameSwitch.switchtopGeneralFrame();
			List<String> windows = new ArrayList<String>();
			windows.addAll(uiDriver.getWindowHandles());
			SaveAndCloseButton.click();
			uiDriver.switchTo().window(windows.get(0));
		} catch (Exception e) {
			throw new Exception(
					"LOGINSTRUCTION:ISSUE IN CLICKING THJE SAVE AND CLOSE BUTTON"
							+ "\n METHOD:clickSaveandCloseButton:\n"
							+ e.getLocalizedMessage());
		}
		return new MyGradeBookPage(uiDriver);
	}

	public void switchtoWindow() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SWITCHING THE WINDOW TO LINKCOURSE TOOL PAGE METHOD:switchToWindow");
			frameSwitch.switchtopGeneralFrame();
			List<String> windows = new ArrayList<String>();
			windows.addAll(uiDriver.getWindowHandles());
			uiDriver.switchTo().window(windows.get(1));
		} catch (Exception e) {
			throw new Exception("UNABLE TO SWITCH ON WINDOW"
					+ e.getLocalizedMessage());
		}
	}

}
