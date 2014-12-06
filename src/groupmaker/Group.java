/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupmaker;

import java.util.*;
public class Group {
    private GroupPerson[] group;
    private int numPeop;
    public Group(int numPeople)
    {
        group=new GroupPerson[numPeople];
        numPeop=0;
    }
    public boolean add(GroupPerson g)
    {
        if(!canAdd(g))
        {
            return false;
        }
        g.addedToGroup();
        group[numPeop]=g;
        return true;
        
    }
    private boolean canAdd(GroupPerson g)
    {
        
        if(numPeop==group.length)return false;
        for(int i=0; i<numPeop; i++)
        {
            if(!group[i].canWorkWith(g))
            {
                return false;
            }
        }
        return true;
    }
    public int getMaxNumPeople()
    {
        return group.length;
    }
    
}
