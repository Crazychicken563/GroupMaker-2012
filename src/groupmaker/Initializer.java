/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupmaker;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
public class Initializer {
    public static void main(String[] args)
    {
        try {
            File f=new File("People.txt");
            
            Scanner in =new Scanner(f);
            ArrayList<String> al=new ArrayList<String>();
            
            /*while(in.hasNextLine())
            {
                String line=in.nextLine();
                System.out.println(line);
                al.add(line.substring(0,line.indexOf("|")));
            }*/
            //FileWriter w=new FileWriter(f);
            //f.delete();
            //f.createNewFile();
            for(int i=0; i<26; i++)
            {
                al.add(""+(char)(i+'a'));
            }
            String s="";
            for(int i=0; i<al.size(); i++)
            {
                s+=(al.get(i)+"|");
                for(int j=0; j<al.size(); j++)
                {
                    if(j!=i)
                    {
                        s+=(al.get(j)+","+al.get(j)+",");
                    }
                    
                }
                s+="\n";
            }
            System.out.println(s);
            //w.write(s);
            //w.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
