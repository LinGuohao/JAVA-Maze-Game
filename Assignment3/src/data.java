/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lin
 */


public class data {
    String name;
    int point ;
     /**
     * Constructor.
     * @param name
     * @param point
   
     */
    public data(String name ,int point)
    {
        this.name = name;
        this.point = point;
    }
    public int getPoints()
    {
        return  this.point;
    }
}
