import java.io.Console;
import java.util.List;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) {
    Console console = System.console();
    boolean leave = false;
    List<Event> eventList = new ArrayList<Event>();
    System.out.println("Welcome to Gotham Party Planning - the only remaining party planning company in Gotham City because the rest of them have been destroyed by supervillains!\nAs the only party planners in the city, we offer a wide variety of options for all party sizes and budgets!\nWe are confident that we can meet your party needs - and even if we can't, it's not like you can go anywhere else!");
    System.out.println("");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~Gotham Party Planning~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("");
    do{
      System.out.println("What would you like to do?\n1. Plan a party\n2. See all planned parties\n3. Leave");
      int userInput = parseWithDefault(console.readLine().trim(), 5);
      if(userInput == 1){
        System.out.println("Let's get started planning your party!");
        int guestNum = getPartyElementChoice(1);
        int foodType = getPartyElementChoice(2);
        int bevType = getPartyElementChoice(3);
        int entertainmentType = getPartyElementChoice(4);
        Event newEvent = new Event(guestNum, foodType-1, bevType-1, entertainmentType-1);
        boolean changeEvent;
        do{
          System.out.println("");
          System.out.println("~*~*~*~*~*~*~*~*~*~*~*~Gotham Party Planning~*~*~*~*~*~*~*~*~*~*~");
          System.out.println("");
          System.out.println("Thank you for your input! Currently, your party will cost: $" + newEvent.getCost());
          System.out.println("Would you like to make any changes before we move on? (Y/N)");
          changeEvent = (console.readLine().toUpperCase().trim().equals("Y"));
          if(changeEvent){
            System.out.println("What would you like to change?\n1. Guest Number\n2. Food fanciness\n3.Beverage effect\n4.Entertainment Impressiveness");
            int whatToChange = getProperInput(4);
            int changeThingTo = getPartyElementChoice(whatToChange);
            //need to subtract 1 from changeThingTo because ui choice numbering starts from 1 and arrays start from 0
            newEvent.changeMind(whatToChange, changeThingTo-1);
            //write setters and determine what to set (re-set everything? REFACTOR PARTY ELEMENTS ABOVE AS ARRAY OF INTS AW YISS)
          }
        }while(changeEvent);
        System.out.println("Great! Let's get some details, then.");
        int userPartyDoneChoice;
        do{
          System.out.println("--------------------------------------");
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
          System.out.println("Would you like to purchase anti-supervillain-attack insurance? This will partly cover guests' medical/funeral expenses, counseling fees, and property damage that may arise from such an attack! Y/N (Additional $20,000 cost)");
          boolean villainInsurance = (console.readLine().toUpperCase().trim().equals("Y"));
          newEvent.setInsurance(villainInsurance);
          System.out.println("Thank you! Here is your party summary:");
          printParty(newEvent);
          System.out.println("What do you think?\n1. Looks great let's do it!\n2. I need to change my food/entertainment choice\n3. I need to start over");
          userPartyDoneChoice = getProperInput(3);
        }while(userPartyDoneChoice == 2);
        if(userPartyDoneChoice == 1){
          System.out.println("");
          System.out.println("Great! We will contact you soon! Please note that in order to prevent supervillains from finding out about and targeting our customers' parties, it is company policy to never discuss the timing of these events except in person. If someone claiming to be from Gotham Party Planning calls or emails you asking about the date, they are not a real Gotham Party Planning employee!");
          System.out.println("");
          System.out.println("~*~Gotham Party Planning Disclaimer~*~\nCitizens of Gotham plan large gatherings at their own risk. Gotham Party Planning is unable to offer any guarantees regarding the presence/absence of any supervillains (or Batman/any of his allies) at your event.");
          System.out.println("");
          do{
            System.out.println("I have read and understood the Gotham Party Planning Disclaimer (Y/N)");
          } while(!console.readLine().toUpperCase().trim().equals("Y"));
          eventList.add(newEvent);
        }
      } else if(userInput == 2){
        System.out.println("Here are the parties you are planning so far:");
        for(Event event : eventList){
          printParty(event);
        }
        System.out.println("Press enter to continue:");
        console.readLine();
      } else if(userInput == 3){
        leave = true;
      } else {
        System.out.println("Sorry! That's not one of the options");
      }
    }while(!leave);
  } // end main

  //convenience method for checking if user input parses to integer
  public static int parseWithDefault(String input, int def) {
    try {
        return Math.abs(Integer.parseInt(input));
    }
    catch (NumberFormatException e) {
        return def;
    }
  }

  //convenience method for checking if user input is within proper bounds
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

  public static void printParty(Event event){
    System.out.println("");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~Gotham Party Planning~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("");
    System.out.println("Number of guests: " + event.getNumGuests());
    System.out.println("Food: " + event.getFoodChoice());
    System.out.println("Beverages: " + event.getBevType());
    System.out.println("Entertainment: " + event.getEntertainmentChoice());
    System.out.println("Insurance: " + event.getInsurance());
    System.out.println("--------------------------------------");
    System.out.println("Total Cost: $" + event.getCost());
    System.out.println("");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~Gotham Party Planning~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("");
  }

  //method for outputting party questions
  public static int getPartyElementChoice(int whichElement){
    int inputNum=0;
    Console console = System.console();
    System.out.println("--------------------------------------");
    switch(whichElement){
      case 1:
        System.out.println("How many guests are you planning on accommodating?");
        inputNum = parseWithDefault(console.readLine().trim(), 50);
        break;
      case 2:
        System.out.println("What level of fancy do you require for your food?\n1. Nothing too fancy\n2. Maybe a little fancy\n3. Pretty goshdarn fancy\n4. The MOST fancy");
        inputNum = getProperInput(4);
        break;
      case 3:
        System.out.println("What effect should your beverages have on your guests?\n1. What? Nothing!\n2. Caffeination, please\n3. Inebration, please\n4. Caffeination AND Inebrations wheeeeeeee");
        inputNum = getProperInput(4);
        break;
      case 4:
        System.out.println("How impressive would you like the entertainment to be?\n1. Eh\n2. It's fine if people immediately forget about what they did the next day\n3. People should talk fondly of this party for at least 2.7 weeks\n4. High school students should learn about this party in their history lessons a century from now");
        inputNum = getProperInput(4);
        break;
      default:
        break;
    }
    return inputNum;
  }
}
