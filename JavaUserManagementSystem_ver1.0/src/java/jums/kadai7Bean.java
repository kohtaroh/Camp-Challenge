/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kotaroh
 */

public class kadai7Bean {
  private String name;
  private String year;
  private String month;
  private String day;
  private String type;
  private String tell;
  private String comment;
                
    public kadai7Bean(){}
    HttpServletRequest request;
    HttpSession session = request.getSession();
    
    public void setName(String name)
    {
        this.name=name;

    }
    public String getName()
    {
        return this.name;
    }        
        
    public void setYear(String year)
    {
        this.year=year;
    }
    public String getYear()
    {
        return this.year;
    }        
        
    public void setMonth(String month)
    {
        this.month=month;
    }
    public String getMonth()
    {
        return this.month;
    }        
        
    public void setDay(String day)
    {
        this.day=day;
    }
    public String getDay()
    {
        return this.day;
    }        
        
    public void setType(String type)
    {
        this.type=type;
    }
    public String getType()
    {
        return this.type;
    }        
        
    public void setTell(String tell)
    {
        this.tell=tell;
    }
    public String getTell()
    {
        return this.tell;
    }        

    public void setComment(String comment)
    {
        this.comment=comment;
    }
    public String getComment()
    {
        return this.comment;
    }        
    
        
        








}
