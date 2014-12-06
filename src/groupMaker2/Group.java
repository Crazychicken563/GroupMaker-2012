package groupMaker2;


import java.util.*;
public class Group
{
    private ArrayList<Student> g;
    private int numInGroup;
    public Group(int num)
    {
        numInGroup=num;
        g=new ArrayList<Student>();
    }
    public Group(ArrayList<Student> g2)
    {
        g=g2;
    }
    public boolean addStudent(Student s)
    {
        if(g.size()>=numInGroup) return false;
        for(int i=0; i<g.size(); i++)
        {
            if(s.isNotOK(g.get(i))) return false;
        }
        for(int i=0; i<g.size(); i++)
        {
            s.remove(g.get(i));
            g.get(i).remove(s);
            
        }
        
        g.add(s);
        
        return true;
        
    }
    public void printMembers()
    {
        for(int i=0; i<g.size(); i++)
        {
            System.out.println(g.get(i).getName());
        }
        System.out.println();
    }
    public String toString()
    {
        String s="";
        for(int i=0; i<g.size(); i++)
        {
            if(g.get(i)==null) return "";
            s+=(g.get(i).getName())+"\n";
        }
        s+="\n";
        return s;
    }
    public String toString2()
    {
        String s="";
        for(int i=0; i<g.size(); i++)
        {
            if(g.get(i)==null) return "";
            s+=(g.get(i).getName());
            if(i!=g.size()-1)
            {
                s+=", ";
            }
        }
        
        return s;
    }
    public int getNumInGroup()
    {
        return numInGroup;
    }
    public void undo()
    {
        for(int i=0; i<g.size(); i++)
        {
            for(int j=0; j<g.size(); j++)
            {
                if(i!=j)
                {
                    g.get(i).addOKStudent(g.get(j));
                }
            }
        }
        g=new ArrayList<Student>();
    }
    
    public void confirm()
    {
        for(int i=0; i<g.size(); i++)
        {
            Student temp=g.get(i);
            ArrayList<Student> t=new ArrayList<Student>(g);
            t.remove(i);
            temp.addGroup(new Group(t));
            //g.add(temp);
        }
    }
    public void remove(Student s)
    {
        g.remove(s);
    }
}
