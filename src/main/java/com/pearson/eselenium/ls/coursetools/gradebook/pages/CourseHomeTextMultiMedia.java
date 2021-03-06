package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class CourseHomeTextMultiMedia extends BasePageObject {

	/**
	 * Elements
	 */
	private String radframeid = "RadCourseText_contentIframe";
	private String radtoolid = "RadeEntryText";
	VisualEditor visualEditor = new VisualEditor(uiDriver, radtoolid,
			radframeid, radtoolid);
	private UIElement saveandclosebutton = createElement(UIType.ID, "Button3");

	public CourseHomeTextMultiMedia(UIDriver driver) {
		super(driver);
		logInstruction("LOG INSTRUCTION: ## CourseHomeTextMultiMedia ##");
	}

	public VisualEditor getVisualEditor() {
		return visualEditor;
	}

	/**
	 * This method helps to click the save and close button
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 * 
	 */

	public MyGradeBookPage clicksaveandcloseButton() throws Exception {
		try {
			logInstruction("clicking the save and close button");
			frameSwitch.switchtopGeneralFrame();
			uiDriver.waitToBeDisplayed(saveandclosebutton, waitTime);
			saveandclosebutton.click();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Save & Close'"
					+ "\n METHOD:clicksaveandcloseButton:\n"
					+ e.getLocalizedMessage());
		}
		return new MyGradeBookPage(uiDriver);
	}
}
