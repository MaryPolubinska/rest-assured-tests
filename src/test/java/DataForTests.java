import org.testng.annotations.DataProvider;

public class DataForTests {

    @DataProvider(name = "DataForPosting")
    public Object [][] dataForPost() {
        return new Object[][] {
                {"Kamilla", "Parker", 1},
                {"Jonny", "Depp", 2},
                {"Iasaac", "Newton", 6}
        };
    }

    @DataProvider(name = "DataForDeletion")
    public Object[] DataToDelete() {
        return new Object[] { 8, 9, 10 };
    }


}
