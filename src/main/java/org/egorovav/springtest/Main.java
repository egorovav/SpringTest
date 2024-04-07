package org.egorovav.springtest;

import java.io.*;
import java.awt.GraphicsEnvironment;
import java.net.URISyntaxException;
public class Main{
    public static void main (String [] args) throws IOException, InterruptedException, URISyntaxException{
        Console console = System.console();
        if (console == null && !GraphicsEnvironment.isHeadless()) {
            String location = Main.class.getProtectionDomain().getCodeSource().getLocation().toString();
            String filename = location.substring(6).replace("%20", " ");
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});
        } else {
            SpringTest.main();
            System.out.println("Print exit to enter.");
        }
    }
}
