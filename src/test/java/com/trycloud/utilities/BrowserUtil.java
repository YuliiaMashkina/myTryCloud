package com.trycloud.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    public static void waitFor (int seconds){

        try {//because we do not need to wait one more time
            Thread.sleep(seconds*1000);//will be 1 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* WebDriverWait wait = new WebDriverWait(Driver.getDriver(),2);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='blaInvalid Login or Password.']")));
        }catch(TimeoutException e){
            //System.out.println(e.getMessage());
            System.out.println("We did not see the error message element");
        }*/

    public static boolean checkVisibilityOfElement(By locator, int second){
/** * This method will check for visibility of element within the time given
 * @param locator By.id or By.xpath or By.whatever
 * @param second time to wait
 * @return true if the element is found within the time and visible , false if not */

        boolean result = false;
        WebDriverWait wait = new WebDriverWait(com.trycloud.utilities.Driver.getDriver(),second);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(  locator  ));
            result = true;
        }catch(TimeoutException e){
            //System.out.println(e.getMessage());
            System.out.println("We did not see the error message element");
        }

        return result;
}

    /**
     * A utility method to get the texts out of list of web elements
     * @param lstOfWebElements the target list of webelement
     * @return the text inside those web element as List<String>
     */
    public static List<String> getAllText(List<WebElement> lstOfWebElements ){

        List<String> allTextLst = new ArrayList<>();
        for (WebElement eachElement : lstOfWebElements) {
            allTextLst.add(  eachElement.getText()  );
        }

        return  allTextLst ;
    }


   public static boolean listContainsElement(List<String> list, String s){
        boolean result= false;
       for(int i = 0; i < list.size(); i++){
           if(list.get(i).contains(s)){
               result=true;
               break;
           }
       }
       return result;
   }


    public static boolean isAllSelected(List<WebElement> allFiles){

        for (WebElement file : allFiles) {

            if(!file.isSelected()){
                return false;
            }
        }
        return true;
    }











}
