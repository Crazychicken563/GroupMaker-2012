/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupmaker;

import java.util.*;
public class GroupPerson implements Comparable {
    private String name;
    private ArrayList<String> ok;
    private int numDoneGroups;
    public GroupPerson(String name2, ArrayList<String> okPeople2)
    {
        numDoneGroups=0;
        name=name2;
        ok=okPeople2;
        
    }
    public ArrayList<String> getOK()
    {
        return ok;
    }
    public int getNumDoneGroups()
    {
        return numDoneGroups;
    }
    public void addedToGroup()
    {
        numDoneGroups++;
    }
    public int numPeopleCanWorkWith()
    {
        return ok.size();
    }
    public String getName()
    {
        return name;
    }
    public boolean canWorkWith(String s)
    {
        return ok.indexOf(s)!=-1;
        /*for(int i=0; i<ok.size(); i++)
        {
            if(ok.get(i).equalsIgnoreCase(s))
            {
                return true;
            }
        }
        return false;*/
    }
    public boolean canWorkWith(GroupPerson s)
    {
        return canWorkWith(s.getName());
    }
    public String remove(String s)
    {
        for(int i=0; i<ok.size(); i++)
        {
            if(ok.get(i).equalsIgnoreCase(s))
            {
                
                return ok.remove(i);
                
            }
        }
        return null;
    }
    public void add(String gp)
    {
        ok.add(gp);
    }
    public String toSaveString()
    {
        String s=name+"|";
        for(int i=0; i<ok.size(); i++)
        {
            s+=ok.get(i)+",";
        }
        return s;
    }

    @Override
    public int compareTo(Object t) {
        GroupPerson g=(GroupPerson)t;
        return numPeopleCanWorkWith()-g.numPeopleCanWorkWith();
        
    }
}
