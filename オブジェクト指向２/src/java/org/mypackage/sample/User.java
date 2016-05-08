/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.util.*;

/**
 *
 * @author kotaroh
 */

public class User extends Human{
Dealer deal;
public ArrayList<Integer> Deal=new ArrayList<Integer>();
public ArrayList<Integer> Hit=new ArrayList<Integer>();

public User(Dealer param)
{
    deal = param;
}


public ArrayList<Integer> deal(){
Deal.add(deal.Cards.get(0));
deal.Cards.remove(0);
Deal.add(deal.Cards.get(0));
deal.Cards.remove(0);
return Deal;}

public ArrayList<Integer> hit(){
Hit.add(deal.Cards.get(0));
deal.Cards.remove(0);
return Hit;}

public boolean checkSum()
  {
       if(open()<15)
       {
         return true;
       }
        else if(open()>=15)
       {
        return false;
       }
   return false;
  }

public ArrayList<Integer> setCard()
{
  if(Deal.size()==2)
  {
       myCards.add(Deal.get(0));
       myCards.add(Deal.get(1));
       Deal.clear();
  }
  if(Hit.size()>0)
  {
       myCards.add(Hit.get(0));
       Hit.clear();
  }
return myCards;
}

public Integer open()
      {
int A=0;

for(int i=0;myCards.size()>i;i++)
  {
     A =A+myCards.get(i);
   }
     return A;
         }
}