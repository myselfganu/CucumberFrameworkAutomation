package in.raster.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import in.raster.cucumber.utilities.CommonMethod;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // links
    @FindBy(xpath = "//div[@class='chr_user-menu']")
    private WebElement userMenu;

    @FindBy(xpath = "//i[contains(@class,'fa-edit')]/parent::a")
    private WebElement editAccount;

    // General Xpaths
    private String menuItemGeneralXpath = "//li[contains(@class,'menumain') and contains(@class,'menuItemToFind')]";

    // methods for step definitions
    public boolean checkIfMenuItemIsPresent(String menuItemToReplace){
        String currentMenuItemXpath = menuItemGeneralXpath.replace("menuItemToFind",menuItemToReplace);
        try {
            WebElement menuItem = driver.findElement(By.xpath(currentMenuItemXpath));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void mouseHoverTheUserMenu(){
        CommonMethod.mouseHoverToElement(userMenu);
        CommonMethod.mouseHoverToElement(editAccount);
    }

    public void mouserHoverAndClickOnTheEditAccountsLink(){
        editAccount.click();
    }


}
