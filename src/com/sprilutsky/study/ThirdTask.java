package com.sprilutsky.study;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sergey on 16.11.16.
 */
public class ThirdTask {

    public void run() {
        System.out.println("==========START THIRD TASK=========");
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("f.txt"));
            int ch;
            while ((ch = file.read()) != -1) {
                switch ((char) ch) {
                    case 'a': {
                        a++;
                        break;
                    }
                    case 'b': {
                        b++;
                        break;
                    }
                    case 'c': {
                        c++;
                        break;
                    }
                    case 'd': {
                        d++;
                        break;
                    }
                    case 'e': {
                        e++;
                        break;
                    }
                    case 'f': {
                        f++;
                        break;
                    }

                }
            }
            file.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        String leftAlignFormat = "| %-15s | %-4d |%n";
        System.out.format("+-----------------+------+%n");
        System.out.format("| Char            |COUNT |%n");
        System.out.format("+-----------------+------+%n");
        System.out.format(leftAlignFormat, "a", a);
        System.out.format(leftAlignFormat, "b", b);
        System.out.format(leftAlignFormat, "c", c);
        System.out.format(leftAlignFormat, "d", d);
        System.out.format(leftAlignFormat, "e", e);
        System.out.format(leftAlignFormat, "f", f);

        System.out.format("+-----------------+------+%n");
        System.out.println("==========END THIRD TASK=========");
    }
}
