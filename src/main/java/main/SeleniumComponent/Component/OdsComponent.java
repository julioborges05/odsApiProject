package main.SeleniumComponent.Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OdsComponent {
    @FindBy(className = "faixa-onu-texto")
    private WebElement OdsName;

    @FindBy(id = "accordion")
    private WebElement questionsAndSubQuestions;

    @FindBy(css = "body > div.faixa-onu > div > h4 > a:nth-child(2) > span")
    private WebElement nextButton;

    @FindBy(css = "body > div.faixa-onu > div > h4 > a:nth-child(1) > span")
    private WebElement previousButton;

    public OdsComponent() {
    }

    public WebElement getOdsName() {
        return OdsName;
    }

    public void setOdsName(WebElement odsName) {
        OdsName = odsName;
    }

    public WebElement getQuestionsAndSubQuestions() {
        return questionsAndSubQuestions;
    }

    public void setQuestionsAndSubQuestions(WebElement questionsAndSubQuestions) {
        this.questionsAndSubQuestions = questionsAndSubQuestions;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public void setNextButton(WebElement nextButton) {
        this.nextButton = nextButton;
    }

    public WebElement getPreviousButton() {
        return previousButton;
    }

    public void setPreviousButton(WebElement previousButton) {
        this.previousButton = previousButton;
    }
}
