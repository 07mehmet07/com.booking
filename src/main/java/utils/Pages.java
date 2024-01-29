package utils;

import lombok.Data;
import pages.HomePage;

@Data
public class Pages {

        private HomePage homePage;



        public Pages() {
            homePage = new HomePage();

        }
}