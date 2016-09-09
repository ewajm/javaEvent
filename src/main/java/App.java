import java.io.Console;
import java.util.List;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    Console console = System.console();
    boolean leave = false;
    System.out.println("Welcome to Gotham Party Planning - the only remaining party planning company in Gotham City because the rest of them have been destroyed!\nAs the only party planners in the city, we offer a wide variety of options for all party sizes and budgets!\nWe are confident that we can meet your party needs - and even if we can't, it's not like you can go anywhere else!");
    System.out.println("");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~Gotham Party Planning~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("");
    do{
      System.out.println("What would you like to do?\n1. Plan a party\n2. See all planned parties\n3.Leave");
      int userInput = parseWithDefault(console.readLine().trim(), 5);
      if(userInput == 1){
        System.out.println("Let's get started planning your party! How many guests are you planning on accommodating?");
        int guestNum = parseWithDefault(console.readLine().trim(), 50);
        System.out.println("--------------------------------------");
        System.out.println("Next, what level of fancy do you require for your food?\n1. Nothing too fancy\n2. Maybe a little fancy\n3. Pretty goshdarn fancy\n4. The MOST fancy");
        int foodType = getProperInput(4);
        System.out.println("--------------------------------------");
        System.out.println("Moving on, what effect should your beverages have on your guests?\n1. What? Nothing!\n2. Caffeination, please\n3. Inebration, please\n4. Caffeination AND Inebrations wheeeeeeee");
        int bevType = getProperInput(4);
        System.out.println("--------------------------------------");
        System.out.println("Finally, how impressive would you like the entertainment to be?\n1. Eh\n2. It's fine if people immediately forget about what they did the next day\n3. People should talk fondly of this party for at least 2.7 weeks\n4. High school students should learn about this party in their history lessons a century from now");
        int entertainmentType = getProperInput(4);
        Event newEvent = new Event(guestNum, foodType-1, bevType-1, entertainmentType-1);
        System.out.println("");
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~Gotham Party Planning~*~*~*~*~*~*~*~*~*~*~");
        System.out.println("");
        System.out.println("Thank you for your input! Currently, your party will cost: $" + newEvent.getCost());
        System.out.println("Would you like to make any changes before we move on? (Y/N)");
        boolean changeEvent = (console.readLine().toUpperCase().trim().equals("Y"));
        if(changeEvent){
          //change the thing (refactor)
        } else {
          System.out.println("Great! Let's get some details, then.");
          System.out.println("Please choose the number corresponding to the food you want from the options below:");
          String[] foodArray = newEvent.getFoodType();
          for(int i = 0; i < foodArray.length; i++){
            System.out.println(i + ". " + foodArray[i]);
          }
          newEvent.chooseFood(getProperInput(foodArray.length-1));
          System.out.println("--------------------------------------");
          System.out.println("Please choose the number corresponding to the entertainment you want from the options below:");
          String[] entertainmentArray = newEvent.getEntertainmentType();
          for(int i = 0; i < entertainmentArray.length; i++){
            System.out.println(i + ". " + entertainmentArray[i]);
          }
          newEvent.chooseEntertainment(getProperInput(entertainmentArray.length-1));
          System.out.println("");
          System.out.println("~*~*~*~*~*~*~*~*~*~*~*~Gotham Party Planning~*~*~*~*~*~*~*~*~*~*~");
          System.out.println("");
          System.out.println("Thank you! Here is your party summary:");
          System.out.println("Number of guests: " + newEvent.getNumGuests());
          System.out.println("Food: " + newEvent.getFoodChoice());
          System.out.println("Beverages: " + newEvent.getBevType());
          System.out.println("Entertainment: " + newEvent.getEntertainmentChoice());
          System.out.println("--------------------------------------");
          System.out.println("Total Cost: $" + newEvent.getCost());
          System.out.println("");
          System.out.println("~*~*~*~*~*~*~*~*~*~*~*~Gotham Party Planning~*~*~*~*~*~*~*~*~*~*~");
          System.out.println("");
        }
      } else if(userInput == 2){

      } else if(userInput == 3){
        leave = true;
      } else {
        System.out.println("Sorry! That's not one of the options");
      }
    }while(!leave);
  } // end main

  public static int parseWithDefault(String input, int def) {
    try {
        return Math.abs(Integer.parseInt(input));
    }
    catch (NumberFormatException e) {
        return def;
    }
  }

  public static int getProperInput(int maxChoice){
    Console newConsole = System.console();
    int userChoice;
    do{
      userChoice = parseWithDefault(newConsole.readLine(), maxChoice+1);
      if(userChoice > maxChoice){
        System.out.println("Please enter one of the numbers listed.");
      }
    } while (userChoice > maxChoice);
    return userChoice;
  }
}
