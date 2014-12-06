/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupmaker;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class GroupMaker {

    /**
     * @param args the command line arguments
     */
    private ArrayList<GroupPerson> students;
    private ArrayList<Group> groups;
    
    public GroupMaker()
    {
        students=new ArrayList<GroupPerson>();
        groups=new ArrayList<Group>();
    }
    public void load()
    {
        File f=new File("People.txt");
        try {
            Scanner s=new Scanner(f);
            while(s.hasNextLine())
            {
                String line=s.nextLine();
                GroupPerson gp=(new GroupPerson(line.substring(0,line.indexOf("|")),new ArrayList<String>()));
                line=line.substring(line.indexOf("|")+1);
                while(line.indexOf(",")!=-1)
                {
                    gp.add(line.substring(0,line.indexOf(",")));
                    line=line.substring(line.indexOf(",")+1);
                    
                }
                students.add(gp);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GroupMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    private void sort()
    {
        Collections.sort(students);
    }
    public void createGroups()
    {
        sort();
        int numOverGroups=students.size()%12;
        for(int i=0; i<numOverGroups;i++)
        {
            groups.add(new Group(3));
            
        }
        for(int i=0; i<(students.size()/12)-numOverGroups;i++)
        {
            groups.add(new Group(2));
        }
        int curG=0;
        Random r=new Random();
        if(groups.get(curG).getMaxNumPeople()==3)
        {
            
        }
        
        
    }
    
    
}
