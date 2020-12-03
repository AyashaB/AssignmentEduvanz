package ApplicationPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonClass.BaseClass;
import Helper.ActionHelper;

public class ShopingCartSummary extends BaseClass {

	WebDriver driver;

	public ShopingCartSummary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "p[class='cart_navigation clearfix'] a")
	WebElement Proceed_to_checkout_InSummary;

	@FindBy(xpath = "//button[@name='processAddress']/span")
	WebElement Proceed_to_checkout_inAddress;

	@FindBy(id = "cgv")
	WebElement checkbox;

	@FindBy(xpath = "//button[@name='processCarrier']/span")
	WebElement Proceed_to_checkout_inShipping;

	@FindBy(xpath = "//p[@class='payment_module']/a")
	List<WebElement> payment;

	@FindBy(css = "button[class*='button-medium'] span")
	WebElement ConfirmMyOrder;

	@FindBy(css = "p[class='cheque-indent'] strong")
	WebElement ConfirmMessage;

	public void clickOnProceed_to_checkout_InSummary() {

		ScrolltoElement(driver, Proceed_to_checkout_InSummary);
		ActionHelper.clickOnElement(driver, Proceed_to_checkout_InSummary);

	}

	public void clickOnProceed_to_checkout_inAddress() {
		ScrolltoElement(driver, Proceed_to_checkout_inAddress);
		ActionHelper.clickOnElement(driver, Proceed_to_checkout_inAddress);
	}

	public void clickOncheckbox() {
		ScrolltoElement(driver, checkbox);
		ActionHelper.clickOnElement(driver, checkbox);
	}

	public void clickOnProceed_to_checkout_inShipping() {
		ScrolltoElement(driver, Proceed_to_checkout_inShipping);
		ActionHelper.clickOnElement(driver, Proceed_to_checkout_inShipping);
	}

	public void clickOnpayment(String pay) {
		if (pay.equalsIgnoreCase("Pay by bank wire")) {
			ScrolltoElement(driver, payment.get(0));
			ActionHelper.clickOnElement(driver, payment.get(0));
		}else if (pay.equalsIgnoreCase("Pay by check")){
			ActionHelper.clickOnElement(driver, payment.get(1));
		}
	}

	public void clickOnConfirmMyOrder() {
		ScrolltoElement(driver, ConfirmMyOrder);
		ActionHelper.clickOnElement(driver, ConfirmMyOrder);
	}

	public String ValidateConfirmMessage() {
		ScrolltoElement(driver, ConfirmMessage);
		return ConfirmMessage.getText();
	}

}
