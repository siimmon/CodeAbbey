package OneSevenSix;

/**
 * Created by u120987 on 17/05/2016.
 */

import java.io.IOException;
import java.util.*;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class OneSevenSix {
    public static void main(String[] args) throws IOException {
        String token = "71CyU6qo0JPD+jaudS04gDQ0";
        int val = firstRequest(token);

        System.out.print(secondRequest(token, (100-val)));
    }

    public static int firstRequest(String token) throws IOException {
        URL url = new URL("http://codeabbey.sourceforge.net/say-100.php");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        out.write("token="+token);
        out.flush();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));

        /*while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }*/

        line = reader.readLine();

        out.close();
        reader.close();

        String[] lineSplit = line.split(" ");

        int val = Integer.parseInt(lineSplit[1]);

        return val;
    }

    public static String secondRequest(String token, int in) throws IOException {
        URL url = new URL("http://codeabbey.sourceforge.net/say-100.php");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        httpCon.setDoOutput(true);
        httpCon.setRequestMethod("POST");
        OutputStreamWriter out = new OutputStreamWriter(
                httpCon.getOutputStream());
        out.write("token="+token+"&answer="+in);
        out.flush();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));

        /*while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }*/

        line = reader.readLine();

        out.close();
        reader.close();

        return line;
    }
}
