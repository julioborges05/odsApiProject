package main.SeleniumComponent.View;

import main.DTO.OdsDTO;
import main.DTO.OdsQuestionDTO;
import main.DTO.OdsSubQuestionDTO;
import main.SeleniumComponent.Component.OdsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class OdsView {

    private WebDriver driver;
    private WebDriverWait wait;
    private OdsComponent odsComponent;

    public OdsView(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        odsComponent = PageFactory.initElements(driver, OdsComponent.class);
    }

    public List<OdsDTO> findAllOdsFromOdsPage() {
        List<OdsDTO> odsDTOList = new ArrayList<>();

        for(int i = 0; i < 17; i ++) {
            if (0 == i) {
                driver.get("https://odsbrasil.gov.br/objetivo/objetivo?n=1");
            } else {
                odsComponent.getNextButton().click();
            }
            wait.until(ExpectedConditions.visibilityOfAllElements(odsComponent.getQuestionsAndSubQuestions()));
            OdsDTO odsDTO = new OdsDTO();
            odsDTO.setObjectiveName(odsComponent.getOdsName().getText().split(" - ")[1]);
            odsDTO.setOdsQuestionDTOS(getOdsQuestions());
            odsDTO.setObjectiveNumber(odsComponent.getOdsName().getText().split(" - ")[0].split(" ")[1]);
            odsDTOList.add(odsDTO);
        }

        driver.close();
        return odsDTOList;
    }

    public List<OdsQuestionDTO> getOdsQuestions() {
        List<WebElement> questionsElements = odsComponent.getQuestionsAndSubQuestions().findElements(By.className("mb-3"));
        List<OdsQuestionDTO> questions = new ArrayList<>();

        for(WebElement questionElement :  questionsElements) {
            OdsQuestionDTO odsQuestionDTO = new OdsQuestionDTO();
            odsQuestionDTO.setQuestion(questionElement.findElement(By.className("card-header")).getText()
                    .split(" - ")[1]);
            odsQuestionDTO.setQuestionNumber(questionElement.findElement(By.className("card-header"))
                    .getText().split(" - ")[0].replace(".", " ").split(" ")[1]);
            odsQuestionDTO.setOdsSubQuestionDTOList(getSubQuestions(questionElement));
            questions.add(odsQuestionDTO);
        }

        return questions;
    }

    public List<OdsSubQuestionDTO> getSubQuestions(WebElement question) {
        List<OdsSubQuestionDTO> subQuestionDTOS = new ArrayList<>();
        List<WebElement> subQuestionElements = question.findElements(By.tagName("li"));

        for(WebElement subQuestionElement : subQuestionElements) {
            OdsSubQuestionDTO odsSubQuestionDTO = new OdsSubQuestionDTO();
            odsSubQuestionDTO.setSubQuestion(subQuestionElement.getText().split(" - ")[1]);
            odsSubQuestionDTO.setStatus(subQuestionElement.getAttribute("status"));
            subQuestionDTOS.add(odsSubQuestionDTO);
        }
        return subQuestionDTOS;
    }
}
