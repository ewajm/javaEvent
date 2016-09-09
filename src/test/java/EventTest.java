import org.junit.*;
import static org.junit.Assert.*;

public class EventTest{
  @Test
  public void newEvent_instantiatesCorrectly_Event() {
    Event testEvent = new Event(100, 1, 1, 1);
    assertEquals(true, testEvent instanceof Event);
  }

  @Test
  public void getNumGuests_returnsmNumGuests_int() {
    Event testEvent = new Event(100, 0, 0, 0);
    int expectedOutput = 100;
    assertEquals(expectedOutput, testEvent.getNumGuests());
  }

  @Test
  public void getFoodType_returnsFoodTypeArray_StringArray() {
    Event testEvent = new Event(100, 0, 0, 0);
    String[] expectedOutput = {"pizza", "tacos", "sandwiches", "those little cream cheese roll things"};
    assertEquals(expectedOutput, testEvent.getFoodType());
  }

  @Test
  public void getBevType_returnsmBevType_String() {
    Event testEvent = new Event(100, 0, 0, 0);
    String expectedOutput = "Water";
    assertEquals(expectedOutput, testEvent.getBevType());
  }

  @Test
  public void getEntertainmentType_returnsEntertainmentTypeArray_StringArray() {
    Event testEvent = new Event(100, 0, 0, 0);
    String[] expectedOutput = {"a deck of cards", "a stack of printed out word searches", "my cousin Kevin playing the kazoo", "a radio"};
    assertArrayEquals(expectedOutput, testEvent.getEntertainmentType());
  }

  @Test
  public void chooseFood_returnsmFoodChoice_String() {
    Event testEvent = new Event(100, 0, 0, 0);
    String expectedOutput = "pizza";
    assertEquals(expectedOutput, testEvent.chooseFood(0));
  }

  @Test
  public void getFoodChoice_returnsmFoodChoice_String() {
    Event testEvent = new Event(100, 0, 0, 0);
    testEvent.chooseFood(0);
    String expectedOutput = "pizza";
    assertEquals(expectedOutput, testEvent.getFoodChoice());
  }

  @Test
  public void chooseEntertainment_returnsmEntertainmentChoice_String() {
    Event testEvent = new Event(100, 0, 0, 0);
    String expectedOutput = "a deck of cards";
    assertEquals(expectedOutput, testEvent.chooseEntertainment(0));
  }

  @Test
  public void getEntertainmentChoice_returnsmEntertainmentChoice_String() {
    Event testEvent = new Event(100, 0, 0, 0);
    testEvent.chooseEntertainment(0);
    String expectedOutput = "a deck of cards";
    assertEquals(expectedOutput, testEvent.getEntertainmentChoice());
  }

  @Test
  public void getCost_returnsPartyCost_int() {
    Event testEvent = new Event(100, 0, 0, 0);
    int expectedOutput = 710;
    assertEquals(expectedOutput, testEvent.getCost());
  }

  @Test
  public void changeMind_changesDesignatedValue() {
    Event testEvent = new Event(100, 0, 0, 0);
    testEvent.changeMind(2, 2);
    String[] expectedOutput = {"actually good sushi", "A full 5 course meal", "beef from cows that were treated really well in life", "locally sourced organic everything"};
    assertArrayEquals(expectedOutput, testEvent.getFoodType());
  }
}
