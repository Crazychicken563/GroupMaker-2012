/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package groupMaker2;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class GroupMaker
{
    public static void main(String[] args)
    {
        
        Random r=new Random();
        Scanner s=null;
        try {
            s = new Scanner(new File("People.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GroupMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Student> students=new ArrayList<Student>();
        //System.out.print("Number of students in class: ");
        int numStudents=0;//s.nextInt();
        while(s.hasNextLine())
        {
            numStudents++;
            String name=s.nextLine();
            students.add(new Student(name.substring(0,name.indexOf("|"))));
        }
        try {
            s = new Scanner(new File("People.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GroupMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        int num=0;
        while(s.hasNextLine())
        {
            
            String name=s.nextLine();
            name=name.substring(name.indexOf("|")+1);
            
            while(name.indexOf(",")!=-1)
            {
                String temp=name.substring(0,name.indexOf(","));
                name=name.substring(name.indexOf(",")+1);
                
                for(int j=0; j<students.size(); j++)
                {
                    if(students.get(j).getName().equalsIgnoreCase(temp))
                    {
                        students.get(num).addOKStudent(students.get(j));
                        j=students.size()+1;
                    }
                }
                
            }
            num++;
            //students.get(i).addOKStudent(null)
            //students.add(new Student(name.substring(0,name.indexOf("|"))));
        }
        try {
            FileWriter fw=new FileWriter(new File("People.txt"));
            for(int i=0; i<students.size(); i++)
            {
                String line=students.get(i).getName()+"|";
                for(int j=0; j<students.size(); j++)
                {
                    if(i!=j)
                    {
                        line+=students.get(j).getName()+","+students.get(j).getName()+",";
                        //students.get(i).addOKStudent(students.get(j));
                    }
                }
                fw.write(line+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GroupMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        /*s.nextLine();
        for(int i=0; i<numStudents; i++)
        {
            System.out.print("Student "+(i+1)+" name: ");
            students.add(new Student(s.nextLine()));
            for(int j=0; j<students.size()-1; j++)
            {
                if(students.get(j).isOK(students.get(students.size()-1)))
                {
                    students.get(students.size()-1).addOKStudent(students.get(j));
                }
                else
                {
                    //System.out.print("Is "+students.get(students.size()-1).getName()+" Ok working with "+students.get(j).getName()+"? (Y or N) ");
                    //if(s.nextLine().equalsIgnoreCase("N")) students.get(students.size()-1).addStopStudent(students.get(j));
                }

            }

        }*/
        System.out.println();
        System.out.print("Number of groups: ");
        Scanner keyboard=new Scanner(System.in);
        int numGroups=keyboard.nextInt();
        keyboard.nextLine();
        Group[] groups=new Group[numGroups];
        for(int i=0;i<numStudents%numGroups; i++)
        {
            groups[i]=new Group(numStudents/numGroups+1);
            //System.out.println(groups[i].getNumInGroup());
        }
        for(int i=numStudents%numGroups; i<numGroups; i++)
        {
            groups[i]=new Group(numStudents/numGroups);
            //System.out.println(groups[i].getNumInGroup());
        }
        for(int i=0; i<numStudents; i++)
        {
           // groups[0].addStudent(new Student("Works"));
            if(groups[r.nextInt(numGroups)].addStudent(students.get(i))==false)
            {
                //System.out.println("AAAHH");
                i--;
            }

        }

        //System.out.println("test");

        //print groups
        for(int i=0; i<numGroups; i++)
        {
            System.out.println("Group" + (i+1));
            groups[i].printMembers();
        }
        String out="";
        try {
            FileWriter fw=new FileWriter(new File("People.txt"));
            for(int i=0; i<students.size(); i++)
            {
                /*String line=students.get(i).getName()+"|";
                for(int j=0; j<students.size(); j++)
                {
                    if(i!=j)
                    {
                        line+=students.get(j).getName()+","+students.get(j).getName()+",";
                        //students.get(i).addOKStudent(students.get(j));
                    }
                }*/
                out+=(students.get(i).toPrintString()+"\n");
            }
            fw.write(out);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GroupMaker.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

}
