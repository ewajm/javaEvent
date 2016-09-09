public class Event {
  private int mNumGuests;
  private String[] mFoodType;
  private String mFoodChoice = "";
  private int mFoodCostPerPerson;
  private String mBevType;
  private int mBevCostPerPerson;
  private String[] mEntertainmentType;
  private String mEntertainmentChoice = "";
  private int mEntertainmentCost;
  private boolean mInsurance;
  private String[][] foodTypeArray = {new String[]{"pizza", "tacos", "sandwiches", "those little cream cheese roll things"}, new String[]{"fancy meat and cheese trays", "buffet style food of an ethnicity of your choice", "everything that we could find to fry has been found and fried", "the kind of sushi you find at Chinese buffets"}, new String[]{"actually good sushi", "A full 5 course meal", "beef from cows that were treated really well in life", "locally sourced organic everything"}, new String[]{"full churrascaria setup", "foods that have to be prepared a certain way or you die that you can brag about having eaten later", "a variety of foods that are deliberately on fire","caviar. just caviar. no other food except mounds of caviar sitting around"}};
  private String[] bevTypeArray = {"Water", "Soda", "Booze", "Soda and Booze"};
  private String[][] entertainmentTypeArray = {new String[]{"a deck of cards", "a stack of printed out word searches", "my cousin Kevin playing the kazoo", "a radio"}, new String[]{"a variety of board games", "a dj that looks like they came straight from the 90s", "my cousin Kevin's band", "a guy in a cowboy hat who we found at last month's stand up comedy night at the bar"}, new String[]{"an actual entertainment coordinator who will jolly everyone through a set of party games", "a karaoke machine and enough alcohol that people stop being too embarassed to use it", "a band that more than 10 people have heard of", "fancy jugglers"}, new String[]{"we will resurrect the deceased music artist of your choice", "the actual cirque du soleil", "an A-list celebrity that will act genuinely interested in your guests' lives for several minutes"}};

  public Event(int numGuests, int foodType, int bevType, int entertainmentType){
    mNumGuests = numGuests;
    mFoodType = foodTypeArray[foodType];
    mFoodCostPerPerson = (int)Math.pow(4, foodType+1);
    mBevType = bevTypeArray[bevType];
    mBevCostPerPerson = (int)Math.pow(3, bevType+1);
    mEntertainmentType = entertainmentTypeArray[entertainmentType];
    mEntertainmentCost = (int)Math.pow(10, entertainmentType+1);
    mInsurance = false;
  }

  public int getNumGuests(){
    return mNumGuests;
  }

  public String[] getFoodType(){
    return mFoodType;
  }

  public String getBevType(){
    return mBevType;
  }

  public String[] getEntertainmentType(){
    return mEntertainmentType;
  }

  public boolean getInsurance(){
    return mInsurance;
  }

  public void setInsurance(boolean insurance){
    mInsurance = insurance;
  }

  public String chooseFood(int choiceNum){
    mFoodChoice = mFoodType[choiceNum];
    return mFoodChoice;
  }

  public String getFoodChoice(){
    return mFoodChoice;
  }

  public String chooseEntertainment(int choiceNum){
    mEntertainmentChoice = mEntertainmentType[choiceNum];
    return mEntertainmentChoice;
  }

  public String getEntertainmentChoice(){
    return mEntertainmentChoice;
  }

  public int getCost(){
    if(!mInsurance){
      return mNumGuests*mFoodCostPerPerson + mNumGuests*mBevCostPerPerson + mEntertainmentCost;
    } else {
      return mNumGuests*mFoodCostPerPerson + mNumGuests*mBevCostPerPerson + mEntertainmentCost;
    }
  }

  public void changeMind(int whatToChange, int changeThingTo){
    switch(whatToChange){
      case 1:
        mNumGuests = changeThingTo;
        break;
      case 2:
        mFoodType = foodTypeArray[changeThingTo];
        mFoodCostPerPerson = (int)Math.pow(4, changeThingTo+1);
        break;
      case 3:
        mBevType = bevTypeArray[changeThingTo];
        mBevCostPerPerson = (int)Math.pow(3, changeThingTo+1);
        break;
      case 4:
        mEntertainmentType = entertainmentTypeArray[changeThingTo];
        mEntertainmentCost = mEntertainmentCost = (int)Math.pow(10, changeThingTo+1);
        break;
    }
  }
}
