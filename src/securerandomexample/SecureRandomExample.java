/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securerandomexample;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * A simple example of SecureRandom class from Java security library.
 * @author Momir Sarac
 */
public class SecureRandomExample {

    public static void main(String[] args) {
        
        try {
            // obtain a strong SecureRandom implementation from securerandom.strongAlgorithms property of java.security.Security
            // class
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            // print the provided and algorithm obtained for this secureRandom 
            System.out.println("" + secureRandom.getProvider() + "\n" + secureRandom.getAlgorithm());
            //generate 16-long seed bytes
            byte[] bytes = secureRandom.generateSeed(16);
            //print obtained bytes as string from array 
            System.out.println(Arrays.toString(bytes));
            //to get random bytes, a caller simply passes an array of any length, which is then filled with random bytes:
            secureRandom.nextBytes(bytes);
            //print obtained bytes as string from array 
            System.out.println(Arrays.toString(bytes));
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecureRandomExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
