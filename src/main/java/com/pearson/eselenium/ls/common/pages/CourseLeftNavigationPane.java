package com.pearson.eselenium.ls.common.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.utils.DeleteItemsBean;
import com.pearson.eselenium.ls.contentitems.exams.pages.ExamHomePage;
import com.pearson.eselenium.ls.contentitems.exams.pages.ViewExamPage;
import com.pearson.eselenium.ls.contentitems.microsoftofficedocument.pages.MicrosoftOfficeDocumentHomePage;
import com.pearson.eselenium.ls.contentitems.textmultimedia.pages.TextMultimediaHomePage;
import com.pearson.eselenium.ls.contentitems.textmultimedia.student.pages.ViewTextMultiMediaPages;
import com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages.ThreadHomePage;
import com.pearson.eselenium.ls.contentitems.unit.microsoftofficedocument.pages.UnitHomePageForMicrosoftOfficeDocumentPage;
import com.pearson.eselenium.ls.contentitems.unit.pages.UnitHomePage;
import com.pearson.eselenium.ls.contentitems.unit.webcontent.pages.UnitHomePageForWebContent;
import com.pearson.eselenium.ls.contentitems.webcontent.pages.EditWebContentUploadPage;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.eselenium.ls.coursehome.syllabus.pages.SyllabusHomePage;
import com.pearson.eselenium.ls.coursehome.syllabus.student.pages.ViewSyllabusPage;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class is used to define the locator variables and methods for all the Navigation Tree on the
 * left of the application.
 * 
 * @author Kapil.Aare
 */
public class CourseLeftNavigationPane extends BasePieceObject {

    /* Elements */
    private UIElement btnTreeHideUnitsContents = createElement(UIType.Css, "#hleb-showhide");;
    private UIElement btnTreeLogout = createElement(
            UIType.Xpath,
            "//a[contains(@id,'hleb-logout')]");
    private UIElement btnTreeExitCourse = createElement(UIType.Css, "#hleb-exitcourse");
    private UIElement btnTreeUserProfile = createElement(UIType.Css, "#hleb-userprofile");
    private UIElement tabAuthor = createElement(UIType.Css, "a#AuthorTab");
    private UIElement tabCourse = createElement(UIType.Css, "a#CourseTab");
    private UIElement lstUnit = createElement(UIType.Xpath, "//a[@title='{1}']");
    private UIElement lstItem = createElement(
            UIType.Xpath,
            "//form[@id='Form1']//div[@id='fulltree']//a[contains(text(),'{1}')]");
    private UIElements lstAuthorTabUnits = createElements(
            UIType.Css,
            "#treediv div[class*='unitcontainer'] a");
    private UIElements lstAuthorTabContentItem = createElements(
            UIType.Xpath,
            "//div[@id='treediv']/div[{1}]/div/a");
    private UIElement lnkAuthorTabContentItem = createElement(
            UIType.Xpath,
            "//div[@class='Authortree']/div[//a[contains(text(),'{1}')]]/div[a[contains(text(),'{2}')]]/a");
    private UIElement lstAuthorTabContentItemUnit = createElement(
            UIType.Xpath,
            "//div[@id='treediv']/div[{1}]/div/a");
    private UIElement imgCollapseunit = createElement(
            UIType.Xpath,
            "//div[span[a[contains(text(),'{1}')]]]/following-sibling::div[1]/a/img");
    private UIElement lstitemclick = createElement(UIType.LinkText, "{1}");
	private UIElements lblleftnavigationpanelist = createElements(UIType.Xpath,
			"//form[@id='Form1']//div[@id='fulltree']//a");
    
	/* Variables */
	boolean status = false;
    boolean flag = false;
    private String data = "";
    private String title = null;  
    private int rowNumber = 0;
    private int orderNumber = 0;    
    private int length1 = 0;    

    /* Constructor */
    public CourseLeftNavigationPane(UIElement element) {
        super(element);
        logInstruction("LOG INSTRUCTION: ## Course Left Navigation Pane ##");
    }

    /* Constants */
    private static final String COURSE_HOME_ITEM = "coursehome";
    private static final String UNIT_ITEM = "html";
    private static final String UNIT_ITEM_MSOFFICEDOC = "msofficedoc";
    private static final String UNIT_ITEM_WEBCONTENT = "webupload";
    private static final String THREADED_DISCUSSION_ITEM = "thread";
    private static final String SYLLABUS_ITEM = "syllabus";
    private static final String TEXT_MULTIMEDIA_ITEM = "html";
    private static final String MICROSOFT_OFFICE_DOCUMENT_ITEM = "msofficedoc";
    private static final String EXAM_ITEM = "studentexam_v6";
    private static final String WEB_CONTENT_UPLOAD_ITEM = "webupload";
    private static final String EQUELLA_RESOURCE_ITEM = "equella_resource";
    private static final String COURSE_HOME = "coursehome";

    /**
     * This method will click on Hide Units and Contents icon in the Navigation Tree. HLEB Menu.
     * 
     * @author Kapil.Aare
     * @return void
     * @throws Exception
     */
    public void clickHideUnitsContents() throws Exception {
        try {
            frameSwitch.switchToTreePane();
            uiDriver.waitToBeDisplayed(btnTreeHideUnitsContents, waitTime);
            btnTreeHideUnitsContents.clickNoWait();
            logInstruction("LOG INSTRUCTION: CLICKED ON HIDE UNITS AND CONTENT ICON ON NAVIGATION TREE");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON HIDE UNITS AND CONTENT ICON ON NAVIGATION TREE\n METHOD :clickHideUnitsContents" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will click on Logout icon in the Navigation Tree. HLEB Menu.
     * 
     * @author Kapil.Aare
     * @return LoginPage instance
     * @throws Exception
     */
    public LoginPage clickLogout() throws Exception {
        try {
            frameSwitch.switchToTreePane();
            uiDriver.waitToBeDisplayed(btnTreeLogout, waitTime);
            btnTreeLogout.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED ON LOGOUT ICON ON NAVIGATION TREE");
            uiDriver.getUIAlert().acceptAlertIfPresent();
            logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON LOGOUT ICON ON NAVIGATIONTREE \n METHOD :clickLogout" + e
                            .getLocalizedMessage());
        }
        return new LoginPage(uiDriver);
    }

    /**
     * This method will click on Logout icon in the Navigation Tree. HLEB Menu.
     * 
     * @author Kapil.Aare
     * @return NextCourseHomePage instance
     * @throws Exception
     */
    public NextCourseHomePage clickLogoutCancel() throws Exception {
        try {
            frameSwitch.switchToTreePane();
            uiDriver.waitToBeDisplayed(btnTreeLogout, waitTime);
            btnTreeLogout.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION: CLICKED ON LOGOUT ICON ON NAVIGATION TREE");
            uiDriver.getUIAlert().dismissAlertIfPresent();
            logInstruction("LOG INSTRUCTION: DISMISSED ALERT");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON LOGOUT ICON ON NAVIGATIONTREE \n METHOD :clickLogoutCancel" + e
                            .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

    /**
     * This method will click on User Profile icon in the Navigation Tree. HLEB Menu.
     * @author Kapil.Aare
     * @return UserProfilePage instance
     * @throws Exception
     */
    public UserProfilePage clickUserProfile() throws Exception {
        try {
            frameSwitch.switchToTreePane();
            uiDriver.waitToBeDisplayed(btnTreeUserProfile, waitTime);
            btnTreeUserProfile.clickNoWait();
            logInstruction("LOG INSTRUCTION: CLICKED ON USER PROFILE ICON ON NAVIGATION TREE");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON USERPROFILE ICON ON NAVIGATIONTREE \n METHOD :clickUserProfile" + e
                            .getLocalizedMessage());
        }
        return new UserProfilePage(uiDriver);
    }

    /**
     * This method will click on Exit Course icon in the Navigation Tree. HLEB Menu.
     * 
     * @author Kapil.Aare
     * @return DashbpardPage instance
     * @throws Exception
     */
    public DashboardPage clickExitCourse() throws Exception {
        try {
            frameSwitch.switchToTreePane();
            uiDriver.waitToBeDisplayed(btnTreeExitCourse, waitTime);
            btnTreeExitCourse.clickNoWait();
            logInstruction("LOG INSTRUCTION: CLICKED ON  EXIT COURSE ICON ON NAVIGATION TREE");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON  EXIT COURSE ICON ON NAVIGATIONTREE \n METHOD :clickExitCourse" + e
                            .getLocalizedMessage());
        }
        return new DashboardPage(uiDriver);
    }

    /**
     * This method will click on Course Tab on Navigation Tree.
     * 
     * @author Kapil.Aare
     * @return NextCourseHomePage instance
     * @throws Exception
     */
    public NextCourseHomePage clickCourseTab() throws Exception {
        try {
            frameSwitch.switchToTreePane();
            uiDriver.waitToBeDisplayed(tabCourse, waitTime);
            tabCourse.clickNoWait();
            logInstruction("LOG INSTRUCTION: CLICKED ON COURSE TAB");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT COURSE TAB /n METHDO :clickCourseTab" + e
                    .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

    /**
     * This method will click on Course Tab on Navigation Tree.
     * 
     * @author Kapil.Aare
     * @return NextAuthorHomePage instance
     * @throws Exception
     */
    public NextAuthorHomePage clickAuthorTab() throws Exception {
        try {
            frameSwitch.switchToTreePane();
            tabAuthor.clickNoWait();
            logInstruction("LOG INSTRUCTION: CLICKED ON AUTHOR TAB");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT AUTHOR TAB \n METHOD :clickAuthorTab" + e
                    .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * This method will click on Unit Item on Navigation Tree. Default Unit is present in the
     * Course, called as Course Home, depending on the click will return the instance. Either
     * UnitHomePage or NextCourseHomePage or NextAuthorHomePage
     * 
     * @author Kapil.Aare
     * @param String unitName
     * @return Object instance
     * @throws Exception
     */
    public Object clickOnUnit(String unitName) throws Exception {
        try {
            frameSwitch.switchToTreePane();
            lstUnit.replaceValues(unitName);
            uiDriver.waitToBeDisplayed(lstUnit, waitTime);

            String itemType = lstUnit.getAttribute("Id").split("\\|")[1];
            String itemClass = lstUnit.getAttribute("class");
            lstUnit.clickNoWait();
            if (itemType.equals(COURSE_HOME_ITEM)) {
                if (itemClass.equals("AuthorunitON")) {
                    return new NextAuthorHomePage(uiDriver);
                } else {
                    return new NextCourseHomePage(uiDriver);
                }
            }
            if (itemType.equals(UNIT_ITEM)) {
                return new UnitHomePage(uiDriver);
            }
            if (itemType.equals(UNIT_ITEM_MSOFFICEDOC)) {
                return new UnitHomePageForMicrosoftOfficeDocumentPage(uiDriver);
            }
            if (itemType.equals(UNIT_ITEM_WEBCONTENT)) {
                return new UnitHomePageForWebContent(uiDriver);
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SELECT THE NAVIGATIONTREE \n METHOD :clickOnUnit" + e
                            .getLocalizedMessage());
        }
        return null;
    }

    /**
     * This method will click on Content Item on Navigation Tree. Depending on the type of the Item,
     * will return the instance.
     * 
     * @author Kapil.Aare
     * @param String itemName
     * @return Object instnace
     * @throws Exception
     */
    public Object clickOnItem(String itemName) throws Exception {
        frameSwitch.switchToTreePane();
        lstitemclick.replaceValues(itemName);
        uiDriver.waitToBeDisplayed(lstitemclick, waitTime);
        String itemType = lstitemclick.getAttribute("Id").split("\\|")[1];
        String mode = lstitemclick.getAttribute("class");
        lstitemclick.clickNoWait();
        if (itemType.equals(THREADED_DISCUSSION_ITEM)) {
            return new ThreadHomePage(uiDriver);
        }
        if (itemType.equals(SYLLABUS_ITEM)) {
            if (mode.equals("Authorcontentitem") || mode.equals("AuthorcontentitemON")) {
                return new SyllabusHomePage(uiDriver);
            } else {
                return new ViewSyllabusPage(uiDriver);
            }
        }

        if (itemType.equals(COURSE_HOME)) {
            if (mode.equals("Authorunit") || mode.equals("AuthorunitON")) {
                return new NextAuthorHomePage(uiDriver);
            } else {
                return new NextCourseHomePage(uiDriver);
            }
        }
        if (itemType.equals(TEXT_MULTIMEDIA_ITEM)) {
            if (mode.equals("Authorcontentitem") || mode.equals("AuthorcontentitemON")) {
                return new TextMultimediaHomePage(uiDriver);
            } else {
                return new ViewTextMultiMediaPages(uiDriver);
            }
        }

        if (itemType.equals(MICROSOFT_OFFICE_DOCUMENT_ITEM)) {
            if (mode.equals("Authorcontentitem") || mode.equals("AuthorcontentitemON")) {
                return new MicrosoftOfficeDocumentHomePage(uiDriver);
            } else {
                return new MicrosoftOfficeDocumentHomePage(uiDriver);
            }
        }

        if (itemType.equals(EXAM_ITEM)) {
            if (mode.equals("Authorcontentitem") || mode.equals("AuthorcontentitemON")) {
                return new ExamHomePage(uiDriver);
            } else {
                return new ViewExamPage(uiDriver);
            }
        }

        if (itemType.equals(WEB_CONTENT_UPLOAD_ITEM)) {
            if (mode.equals("Authorcontentitem") || mode.equals("AuthorcontentitemON")) {
                return new EditWebContentUploadPage(uiDriver);
            }
        }

        if (itemType.equals(EQUELLA_RESOURCE_ITEM)) {

        }

        return null;
    }

    /**
     * verifying content item exist or not
     * 
     * @author Praveen.Maled
     * @param String unitName
     * @param String contentItem
     * @return boolean
     * @throws Exception
     */
    public boolean isContentItemExist(String unitName, String contentItem) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: verifying  content item");
            frameSwitch.switchToTreePane();
            lnkAuthorTabContentItem.replaceValues(unitName, contentItem);
            return lnkAuthorTabContentItem.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN method 'isContentItemExist'. EXCEPTION WHILE VERIFYING CONTENT ITEM \n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This Method will check whether content item is hidden from student
     * 
     * @author Suchi.Singh
     * @param String unitName
     * @param String contentItem
     * @return boolean
     * @throws Exception
     */
    public boolean isContentItemHiddenFromStudent(String unitName, String contentItem)
            throws Exception {
        String data = "";
        String s = "HIDDEN";
        boolean status = false;
        try {
            logInstruction("LOG INSTRUCTION: getting instructor data");
            frameSwitch.switchToTreePane();
            lnkAuthorTabContentItem.replaceValues(unitName, contentItem);
            uiDriver.waitToBeDisplayed(lnkAuthorTabContentItem, waitTime);
            data = lnkAuthorTabContentItem.getAttribute("title");
            if (data.toLowerCase().contains(s.toLowerCase())) {
                status = true;
            }
        } catch (Exception e) {
        	 throw new Exception("ISSUE IN EXECUTING THE METHOD 'isContentItemHiddenFromStudent' \n" + e.getLocalizedMessage());
        }
        return status;
    }

    /**
     * Method returns the unit row number in the navigation tree
     * 
     * @author Praveen.Maled
     * @param String unitName
     * @return int
     * @throws Exception
     */
    public int getAuthorTabUnitRowNumber(String unitName) throws Exception {        
        try {
            logInstruction("LOG INSTRUCTION: GETTING UNIT ROW NUMBER");
            frameSwitch.switchToTreePane();
            List<UIElement> lstUnits = lstAuthorTabUnits.getUIElementsList();
            for (UIElement unit : lstUnits) {
                if (unit.getText().trim().equals("")) {
                    continue;
                }
                rowNumber++;
                if (unit.getText().equalsIgnoreCase(unitName)) {
                    return rowNumber;
                }
            }
        } catch (Exception e) {
            throw new Exception(
                    "EXCEPTION IN GETTING UNIT NUMBER \n METHOD :getAuthorTabUnitRowNumber" + e
                            .getLocalizedMessage());
        }
        return 0;
    }

    /**
     * method returns content items present inside the unit
     * 
     * @author Praveen.Maled     
     * @param String unitName
     * @return List<String>
     * @throws Exception
     */
    public List<String> getAuthorTabContetnItemsOfUnit(String unitName) throws Exception {
        List<String> contentItems = new ArrayList<String>();

        try {
            int divnumber = getAuthorTabUnitRowNumber(unitName);
            logInstruction("LOG INSTRUCTION: div number:" + divnumber);
            lstAuthorTabContentItem.replaceValues(String.valueOf((divnumber * 2)));
            List<UIElement> items = lstAuthorTabContentItem.getUIElementsList();
            for (UIElement item : items) {
                String contentItem = item.getAttribute("title");
                if (contentItem.contains(": HIDDEN")) {
                    contentItem = contentItem.replaceAll(": HIDDEN", "").trim();
                }
                if (item.getText().equalsIgnoreCase("Learning Outcomes") || item.getText()
                        .equalsIgnoreCase("Syllabus")) {
                    continue;
                }
                contentItems.add(item.getText());
            }

        } catch (Exception e) {
            throw new Exception(
                    "EXCEPTION IN GETTING UNIT CONTENT ITEMS \n METHOD :getAuthorTabContetnItemsOfUnit" + e
                            .getLocalizedMessage());
        }
        return contentItems;

    }

    /**
     * method will return the order number of specified content item
     * 
     * @author Praveen.Maled
     * @param String unitName
     * @param String contentItem
     * @return int
     * @throws Exception
     */
    public int getcontentItemOrderNumber(String unitName, String contentItem) throws Exception {    
        try {
            int divnumber = getAuthorTabUnitRowNumber(unitName);
            lstAuthorTabContentItem.replaceValues(String.valueOf((divnumber * 2)));
            uiDriver.waitToBeDisplayed(lstAuthorTabContentItemUnit, waitTime);
            List<UIElement> items = lstAuthorTabContentItem.getUIElementsList();
            for (UIElement item : items) {
                String content = item.getAttribute("title");
                if (content.contains(": HIDDEN")) {
                    contentItem = contentItem.replaceAll(": HIDDEN", "").trim();
                }
                if (content.equalsIgnoreCase("Learning Outcomes") || content
                        .equalsIgnoreCase("Syllabus")) {
                    continue;
                }
                orderNumber++;
                if (content.equalsIgnoreCase(contentItem)) {
                    return orderNumber;
                }
            }

        } catch (Exception e) {
            throw new Exception(
                    "EXCEPTION IN GETTING UNIT CONTENT ITEM NUMBER \n METHOD :getcontentItemOrderNumber" + e
                            .getLocalizedMessage());
        }
        return 0;
    }

    /**
     * This method is to check if the Author tab is displayed
     * 
     * @author ashish.juyal
     * @throws Exception
     * @return boolean
     */
    public boolean isAuthorTabDisplayed() throws Exception {
        logInstruction("LOG INSTRUCTION: checking the author tab");
        flag = false;
        try {
            frameSwitch.switchToTreePane();
            uiDriver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.MILLISECONDS);
            // AuthorTabOnNavigationTree authorTab = new AuthorTabOnNavigationTree(tabAuthor);

            if (tabAuthor.isDisplayed()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET IF AUTHOR TAB IS DISPLAYED OR NOT. \n METHOD :isAuthorTabDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will check whether item is present on the tree navigation
     * 
     * @author Shishir.Dwivedi
     * @param String item      
     * @return boolean
     * @throws Exception
     */
    public boolean isItemPresent(String item) throws Exception {
        status = false;
        try {
            frameSwitch.switchToTreePane();
            lstItem.replaceValues(item);
            lstItem.isDisplayedAfterWaiting(waitTime);
            if (lstItem.isDisplayed())
                status = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: unable to get the item \n METHOD :isItemPresent" + e
                            .getLocalizedMessage());
        }
        return status;
    }

    /**
     * This method will click on collapse unit
     * 
     * @author kiran kumar
     * @param String item          
     * @return void
     * @throws Exception
     */
    public void clickOnCollapseUnitIcon(String unitName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON COLLAPSE FOR AN UNIT");
            frameSwitch.switchToTreePane();
            imgCollapseunit.replaceValues(unitName);
            uiDriver.waitToBePresent(imgCollapseunit, waitTime);
            imgCollapseunit.clickNoWait();

        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON COLLAPSE \n METHOD :clickOnCollapseUnitIcon");
        }

    }

    /**
     * This method will check is unit collapsed or not
     * 
     * @author kiran kumar
     * @param String item        
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitCollapsed(String unitName) throws Exception {
        flag = true;
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON COLLAPSE FOR AN UNIT");
            frameSwitch.switchToTreePane();
            imgCollapseunit.replaceValues(unitName);
            // uiDriver.waitToBePresent(imgCollapseunit, waitTime);
            flag = imgCollapseunit.isDisplayedAfterWaiting(waitTime);
            // flag = true;
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON COLLAPSE \n METHOD :isUnitCollapsed");
        }
        return !flag;
    }

    /**
     * This method will checks UserSettings icon is present or not the Navigation Tree. HLEB Menu.
     * 
     * @author Raghav
     * @return boolean
     * @throws Exception
     */
    public boolean isUserSettingsDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING IS LOGOUT DISPLAYED OR NOT");
            frameSwitch.switchToTreePane();
            btnTreeUserProfile.isDisplayed();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET THE USER SETTING \n METHOD :isUserSettingsDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will checks is Exit icon in the Navigation Tree. HLEB Menu. @ Suchi.Singh
     * 
     * @author Raghav
     * @return boolean
     * @throws Exception
     */
    public boolean isExitIconDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING IS EXIT ICON DISPLAYED OR NOT");
            frameSwitch.switchToTreePane();
            btnTreeExitCourse.isDisplayed();
            flag = true;
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE EXIT COURSE \n METHOD :isExitIconDisplayed" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will checks is Hide Units and Contents icon in the Navigation Tree. HLEB Menu.
     * 
     * @author kiran kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isHideUnitsContentsDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR HIDE CONTENT");
            frameSwitch.switchToTreePane();
            btnTreeHideUnitsContents.isDisplayed();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET THE HIDE UNIT \n METHOD :isHideUnitsContentsDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will checks is Hide Units and Contents icon in the Navigation Tree. HLEB Menu. 
     * 
     * @author kiran kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isLogoutDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING IS LOGOUT DISPLAYED OR NOt");
            frameSwitch.switchToTreePane();
            btnTreeLogout.isDisplayed();
            flag = true;
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE LOGOUT BUTTON \n METHOD :isLogoutDisplayed" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This Method check the presence of unit in navigation tree
     * 
     * @author kiran.kumar
     * @param String unitname
     * @return boolean
     * @throws Exception
     */
    public boolean isUnitPresent(String unitname) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING IS UNIT PRESENT IN NAVIGATION TREE");
            frameSwitch.switchToTreePane();
            lstUnit.replaceValues(unitname);
            if (lstUnit.isDisplayed()) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            throw new Exception("UNIT IS NOT PRESENT \n METHOD :isUnitPresent" + e
                    .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This Method will give you the text of the Unit
     * 
     * @param String unitName        
     * @return String
     * @throws Exception
     * @author Shishir.Dwivedi;
     */
    public String getTextOfUnit(String unitName) throws Exception {        
        try {
            logInstruction("LOG INSTRUCTION: GETTING UNIT TITLE");
            frameSwitch.switchToTreePane();
            lstUnit.replaceValues(unitName);
            data = lstUnit.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: NOT ABLE TO GET THE UNIT NAME \n METHOD : getTextOfUnit");
        }
        return data;
    }

    /**
     * This method will check whether item is present on the tree navigation along with its length
     * 
     * @author amit.deshmukh
     * @param String item
     * @param int length        
     * @category Milestone 2
     * @return boolean
     * @throws Exception
     */
    public boolean isItemPresentWithGivenLength(String item, int length) throws Exception {
        status = false;
        length1 = 0;

        try {
            lstItem.replaceValues(item);
            frameSwitch.switchToTreePane();
            if (lstItem.isDisplayedAfterWaiting(waitTime))
                length1 = lstItem.getText().length();
            if (length1 <= length)
                status = true;
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE ITEM \n METHOD:isItemPresentWithGivenLength " + e.getLocalizedMessage());
        }
        return status;
    }

    /**
     * This method will check whether item is displayed as FullToolTip on the tree navigation
     * 
     * @author amit.deshmukh
     * @param String item
     *            name of the item
     * @category Milestone 2
     * @return String
     * @throws Exception
     */
    public String isFullUnitNameDisplayedToolTip(String item) throws Exception {        
        try {
            lstItem.replaceValues(item);
            frameSwitch.switchToTreePane();
            if (lstItem.isDisplayedAfterWaiting(waitTime))
                title = lstItem.getAttribute("title");
        } catch (Exception e) {
            throw new Exception("unable to get the item" + e.getLocalizedMessage());
        }
        return title;
    }
/**
     * This Method Returns the Left Navigation Pane List of Entries with LSAuto Prefix and Time Stamp Range
     * 
     * @return Map<String, DeleteItemsBean>
     * @throws Exception
     * @author Raghav S
     */
    
public Map<String, DeleteItemsBean> getLeftNavigationPaneElements() throws Exception {
		Map<String, DeleteItemsBean> courseHomeValues = new HashMap<String, DeleteItemsBean>();
		try {
			logInstruction("LOGINSTRUCTION:GETTING LEFT NAVIGATION PANE ELEMENTS");
			frameSwitch.switchToTreePane();
			List<UIElement> elements = lblleftnavigationpanelist.getUIElementsList();
			for (int i = 0; i < elements.size(); i++) {
				if (StringUtils.isNotBlank(elements.get(i).getText())
						 && (elements.get(i).getText().contains("LSAutoTest")) && (cleanup.verifyOnedayTimeStamp(elements.get(i).getText().trim()))) {
					DeleteItemsBean bean = new DeleteItemsBean();
					bean.setItemName(elements.get(i).getText().trim());
					bean.setUnitOrContentItem(elements.get(i)
							.getAttribute("Id").split("\\|")[0]);
					if (bean.getUnitOrContentItem().equals("unit")) {
						bean.setUnit(true);
						bean.setItemType(elements.get(i).getAttribute("Id")
								.split("\\|")[1]);
						
					}else
					if (!bean.isUnit()) 
						{
						bean.setItemType(elements.get(i).getAttribute("Id")
								.split("\\|")[1]);
					
					}
				courseHomeValues.put(bean.getItemName(), bean);
				}
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN  GETTING 'leftnavigation pane' ELEMENTS"
					+ "\n METHOD:getLeftNavigationPaneElements \n"
					+ e.getLocalizedMessage());
		}

		return courseHomeValues;

	}



}
