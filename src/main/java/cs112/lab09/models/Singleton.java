package cs112.lab09.models;

public class Singleton {
    private static Singleton instance;

    static {
        try {
            instance = new Singleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance.");
        }
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static final RevisedHistoricalEvent[] RH_EVENTS = {
            new RevisedHistoricalEvent(
                    "a minor riot between Black and white soldiers occurred in the Presidip in San Francisco",
                    new Date(5, 15, 1919),
                    "a minor riot between Black and white soldiers occurred in the Presidip in San Francisco after a dispute about a Thai soldier who was moved from the \"colored quarters\" to the white military housing. Despite defending our country, housing for Black soldiers was not only segregated but often inferior. Black soldiers also faced increased attacks and other forms of discrimination upon returning home.",
                    "https://cdr.lib.unc.edu/downloads/1c18dm56n?locale=en"),
            new RevisedHistoricalEvent(
                    "Local police in Bisbee, Arizona attacked the 10th U.S. Cavalry, an African-American unit known as the \"Buffalo Soldiers,\" formed in 1866.",
                    new Date(7, 13, 1919),
                    "Although sources are limited, the attack occurred on the eve of celebrations meant to honor returning soldiers (like in Norfolk, Virginia).",
                    "https://cdr.lib.unc.edu/downloads/1c18dm56n?locale=en")
    };
    public static final String[] RH_LOCATIONS = {
            "San Francisco, CA",
            "Bisbee, AZ"
    };
    public static final String[] RH_IMAGES = {
            "/images/sanfrancisco.jpg",
            "/images/bisbee.png"
    };

    public static int getIndex(String location) {
        for (int i = 0; i < RH_LOCATIONS.length; i++){
            if (location.equals(RH_LOCATIONS[i])) {
                return i;
            }
        }
        return -1;
    }
}
