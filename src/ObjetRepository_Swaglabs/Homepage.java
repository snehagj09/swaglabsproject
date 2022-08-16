package ObjetRepository_Swaglabs;

import org.openqa.selenium.By;

public class Homepage {
	
    public By menu = By.id("react-burger-menu-btn");
	
	public By logout = By.id("logout_sidebar_link");
	public By backpack=By.xpath("//div[starts-with(text(),'Sauce Labs Backpack')]");

}
