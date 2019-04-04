/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author luisl
 */
public class CharArray {
    
    private ArrayList<Character> array;
    private ArrayList<Character> stack;
    private ArrayList<Character> result;
    
    public CharArray(){
        array = new ArrayList<>();
    }
    
    public void adding(char a){
        this.array.add(a);
    }
    
    public String convertString(){
        StringBuilder builder = new StringBuilder(this.array.size());
        
        for(Character ch: this.array){
            builder.append(ch);
        }
        
        return builder.toString();
    }
    
    public void removeAll(){
        this.array.clear();
    }
    
    public void removeLast(){
        int a=this.array.size()-1;
        if(a>=0){
            array.remove(a);
        }  
    }
    
    public String shuntingYard(){  
        stack = new ArrayList<>();
        result = new ArrayList<>();
        int a=0;
        
        Iterator<Character> it = this.array.iterator();
        
        while(it.hasNext()){
            if(this.array.get(a)=='A' || this.array.get(a)=='B' || this.array.get(a)=='C' || this.array.get(a)=='D' || this.array.get(a)=='E' || this.array.get(a)=='F'){
                this.result.add(this.array.get(a));//---------------------------Si es a,b,c,d,e ó f se agrega directamente al result
            }
            else if(this.array.get(a)=='^'){//----------------------------------Si es ^ solo se agrega
                this.stack.add(this.array.get(a));
            }else if(this.array.get(a)==')'){//---------------------------------Si es ) saca todos los elementos hasta ( y los mete en el array.
                while(this.stack.get(this.stack.size()-1) != '('){
                    this.result.add(this.stack.get(this.stack.size()-1));
                    this.stack.remove(this.stack.size()-1);
                }
                this.stack.remove(this.stack.size()-1);
            }else if(this.stack.size() > 0 && (this.array.get(a)=='+' || this.array.get(a)=='-')&&(this.stack.get(this.stack.size()-1)=='*' || 
                    this.stack.get(this.stack.size()-1)=='/' || this.stack.get(this.stack.size()-1)=='^')){
                while( this.stack.size() > 0 && (this.stack.get(this.stack.size()-1)=='*' || this.stack.get(this.stack.size()-1)== '/' || this.stack.get(this.stack.size()-1)=='^') ){
                    this.result.add(this.stack.get(this.stack.size()-1));//-----Si es + o - y en stack hay *,/ o ^ los quita y agrega + o -
                    this.stack.remove(this.stack.size()-1);
                }
                this.stack.add(this.array.get(a));
            }else if(this.array.get(a)=='('){
                this.stack.add(this.array.get(a));
            }else if(this.stack.size() > 0 &&(this.array.get(a)=='*'|| this.array.get(a)=='/')&& this.stack.get(this.stack.size()-1)=='^'){
                while(this.stack.size() > 1 || this.stack.get(this.stack.size()-1)=='^'){
                    this.result.add(this.stack.get(this.stack.size()-1));
                    this.stack.remove(this.stack.size()-1);
                }
                this.stack.add(this.array.get(a));
            }else{
                this.stack.add(this.array.get(a));
            }
            
            a++;
            it.next();
        }
        
        while(this.stack.size()>0){
            this.result.add(this.stack.get(this.stack.size()-1));
            this.stack.remove(this.stack.size()-1);
        }
        
        StringBuilder builder = new StringBuilder(this.result.size());
        
        for(Character ch: this.result){
            builder.append(ch);
        }
        
        return builder.toString();
    }
    
    public boolean  isCorrect(){
        int a=0,b=0;
        for(int i=0;i<this.array.size();i++){
            if(this.array.get(i)=='('){
                a++;
            }else{
                if(this.array.get(i)==')'){
                    b++;
                }
            }
        }
        return b==a;
    }
}
