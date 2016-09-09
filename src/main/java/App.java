import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console console = System.console();
    System.out.println("Welcome to Gotham Party Planning - the only remaining party planning company in Gotham City because the rest of them have been destroyed!\nAs the only party planners in the city, we offer a wide variety of options for all party sizes and budgets!\nWe are confident that we can meet your party needs - and even if we can't, it's not like you can go anywhere else!");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("Let's get started planning your party! How many guests are you planning on accommodating?");
    int guestNum = Integer.parseInt(console.readLine());
    System.out.println("Next, what level of fancy do you require for your food?\n1. Nothing too fancy\n2. Maybe a little fancy\n3. Pretty goshdarn fancy\n4. The MOST fancy");
    int foodType = Integer.parseInt(console.readLine());
    System.out.println("Moving on, what effect should your beverages have on your guests?\n1. What? Nothing!\n2. Caffeination, please\n3. Inebration, please\n4. Caffeination AND Inebrations wheeeeeeee");
    int bevType = Integer.parseInt(console.readLine());
    System.out.println("Finally, how impressive would you like the entertainment to be?\n1.Eh\n2. It's fine if people immediately forget about what they did the next day\n3. People should talk fondly of this party for at least 2.7 weeks\n4. High school students should learn about this party in their history lessons a century from now");
    int entertainmentType = Integer.parseInt(console.readLine());
    System.out.println("Great! Here is what we have so far: " + guestNum + " " + foodType + " " + bevType + " " + entertainmentType);
  }
}
