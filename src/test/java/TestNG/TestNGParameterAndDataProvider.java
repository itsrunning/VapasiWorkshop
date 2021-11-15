package TestNG;

import org.testng.annotations.*;

public class TestNGParameterAndDataProvider {


    @Parameters({ "suite-param" })
    @Test
    public void prameterTestOne(String param) {
        System.out.println("Test one suite param is: " + param);
    }



        @Test(dataProvider="testdata")
        public void TestChrome(String userEmail,String password){
            System.out.println(userEmail+"  "+password);

        }
        @DataProvider(name="testdata")
        public Object[][] TestDataFeed(){

            Object [][] loginUserInfo=new Object[2][2];

            loginUserInfo[0][0]="username1@gmail.com";
            loginUserInfo[0][1]="Password1";

            loginUserInfo[1][0]="username2@gmail.com";
            loginUserInfo[1][1]="Password2";
            return loginUserInfo;
        }


    @BeforeMethod
    public void beforeTestAnnotation()
    {
        System.out.println("I run before  every test");
    }

    @AfterMethod
    public void afterTestAnnotation()
    {
        System.out.println("I run after  every test");
    }


}
