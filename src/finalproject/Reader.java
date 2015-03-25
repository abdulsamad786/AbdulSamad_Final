package finalproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 
 * This is a class which helps to read something from standard input.
 * It has imported Buffer Reader class to read the character from input file,
 * IOException class is imported to avoid the failure of reading an input 
 * and InputStreamReader class so that it reads the bytes and converts it into relevant characters
 */
public class Reader {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static public int readInt(String str)
    {
        int value = 0;
        boolean loop = false;

        /**a boolean loop value is taken equals to false and the value becomes true 
         * when Integer scans/reads an integer value       
        */
        while( loop == false )
        {
            System.out.print(str);
            try {
            	// if we assume the line in the file has characters that represent an integer,
            	//we can then use Integer.parseInt() to take that line and turn it into an actual integer
                value = Integer.parseInt(br.readLine());
                loop = true;
            } catch (Exception e) {
                System.out.println("Please enter input int value.");
            }
        }

        return value;
    }


    private static String readString() {
        String value = "";

        try {
            value = br.readLine();
        } catch (IOException e) {
            System.out.println("Please input string value.");
        }

        return value;
    }

    public static String readString(String str) {
        System.out.print(str);

        return readString();
    }



}