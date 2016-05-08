/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author kotaroh
 */
//BlackJackサーブレットにて処理を実行。
//トランプのスーツとAを11として扱えるルールを無視し、
//同点の場合はDealer側を勝利とする

abstract public class Human 
{
abstract public boolean checkSum();
abstract public ArrayList<Integer> setCard();
abstract public Integer open();
public ArrayList<Integer> myCards = new ArrayList<Integer>();
}