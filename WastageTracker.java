import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WastageTrackerSender {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://script.google.com/macros/s/AKfycbxW0B-9dr5PBFTRZfjhr5W7ZT4LX1361DYWRAWOEZ0lo4u5ZqUi3j-WzZ2ZnBmnCmTPhQ/exec"); // Replace with your Web App URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String jsonInputString = "{"
                    + "\"date\":\"2025-07-03\","
                    + "\"item\":\"Milk\","
                    + "\"quantity\":\"2\","
                    + "\"reason\":\"Spoiled\""
                    + "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("Response Code: " + code);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
