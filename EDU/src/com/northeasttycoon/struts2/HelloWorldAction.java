/**
 * @author NorthEastTycoon
 *
 */
package com.northeasttycoon.struts2;
public class HelloWorldAction{
   private String name;
   private String passWord;
 
   public String getPassWord() {
    return passWord;
}
public void setPassWord(String passWord) {
    this.passWord = passWord;
}
public String execute() throws Exception {
      return "success";
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
}