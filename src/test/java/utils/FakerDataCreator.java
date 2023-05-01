package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class FakerDataCreator {

    public static StudentData getRandomStudent() {
        Faker faker = new Faker(new Locale("en"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String gender = faker.options().option("Male", "Female", "Other");
        String userPhone = faker.phoneNumber().subscriberNumber(10);
        SimpleDateFormat sdfDay = new SimpleDateFormat("d", Locale.ENGLISH);
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat sdfYear = new SimpleDateFormat("y", Locale.ENGLISH);
        Date fakerDate = faker.date().birthday();
        String month = sdfMonth.format(fakerDate);
        String year = sdfYear.format(fakerDate);
        String day = sdfDay.format(fakerDate);
        String subject = faker.options().option("Maths", "English", "Chemistry",
                "Arts", "Civics", "Hindi", "History", "Physics");
        String hobby = faker.options().option("Sports", "Reading", "Music");
        String filePath = "src/test/resources/pictures/test.jpg";
        String address = faker.address().fullAddress();
        var mapStateWithCity = Map.of(
                "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
                "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
                "Haryana", new String[]{"Karnal", "Panipat"},
                "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
        );
        String state = (String) faker.options().option(mapStateWithCity.keySet().toArray());
        String city = faker.options().option(mapStateWithCity.get(state));

        return new StudentData()
                .thisFirstName(firstName)
                .thisLastName(lastName)
                .thisUserEmail(userEmail)
                .thisGender(gender)
                .thisUserPhone(userPhone)
                .thisHobby(hobby)
                .thisSubject(subject)
                .thisDay(day)
                .thisMonth(month)
                .thisYear(year)
                .thisFilePath(filePath)
                .thisAddress(address)
                .thisState(state)
                .thisCity(city);

    }
}
