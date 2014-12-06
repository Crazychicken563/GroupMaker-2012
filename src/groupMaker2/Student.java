/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package groupMaker2;
import java.util.*;
public class Student implements Comparable
{
    private String name;
    private ArrayList<Student> ok;
    private ArrayList<Group> allGroups;
    public Student(String name)
    {
        this.name=name;
        ok = new ArrayList<Student>();
        allGroups=new ArrayList<Group>();
    }
    public String getName()
    {
        return name;
    }
    public void addOKStudent(Student s)
    {
        //if(ok.contains(s)==false)
            ok.add(s);
    }
    public boolean isNotOK(Student s)
    {
        if(!ok.contains(s))return true;
        return false;
    }
    public String toPrintString()
    {
        String s=name+"|";
        for(int i=0; i<ok.size(); i++)
        {
            s+=ok.get(i).getName()+",";
        }
        return s;
    }
    public void remove(Student s)
    {
        
        ok.remove(s);
    }
    public int getNumOK()
    {
        return ok.size();
    }

    public int compareTo(Object t) {
        return ((Student)t).getNumOK()-getNumOK();
    }
    public Student pickStudent(int i)
    {
        
        if(ok.size()==0)
        {
            System.out.println("empty");
            return null;
            
        }
        
        Collections.sort(ok);
        System.out.println(ok.get(i).getName());
        return ok.get(i);
    }
    public Student pickStudent(int i, List<Student> l)
    {
        
        ArrayList<Student> temp=sharedPeople(l);
        if(temp.size()<=i)
        {
            System.out.println("pick");
            return null;
            
        }
        Collections.sort(temp);
        return temp.get(i);
    }
    public Student pickStudent(int i, List<Student> l, List<Student> l2)
    {
        
        ArrayList<Student> temp=sharedPeople(l);
        temp=sharedPeople(temp,l2);
        if(temp.size()<=i)
        {
            System.out.println("pick");
            return null;
            
        }
        Collections.sort(temp);
        return temp.get(i);
    }
    public ArrayList<Student> getAllOK()
    {
        return ok;
    }
    public ArrayList<Student> sharedPeople(List<Student> l)
    {
        ArrayList<Student> temp=new ArrayList<Student>();
        for(int i=0; i<ok.size(); i++)
        {
            if(l.indexOf(ok.get(i))!=-1)
            {
                temp.add(ok.get(i));
            }
        }
        return temp;
    }
    public static ArrayList<Student> sharedPeople(List<Student> l,List<Student> l2)
    {
        ArrayList<Student> temp=new ArrayList<Student>();
        for(int i=0; i<l2.size(); i++)
        {
            if(l.indexOf(l2.get(i))!=-1)
            {
                temp.add(l2.get(i));
            }
        }
        return temp;
    }
    public void shuffle()
    {
        Collections.shuffle(ok);
    }
    public void addGroup(Group g)
    {
        
        allGroups.add(g);
        
    }
    public void removeGroup(int i)
    {
        allGroups.remove(i);
    }
    public void removeGroup()
    {
        allGroups.remove(allGroups.size()-1);
    }
    public String groupsString()
    {
        String s="";
        //s+=name+":";
        //s+="\n";
        for(int i=0; i<allGroups.size(); i++)
        {
            s+="Group "+(i+1)+": "+allGroups.get(i).toString2()+"\n";
        }
        return s;
    }
    public int getNumGroups()
    {
        return allGroups.size();
    }


}
