/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaasync;

/**
 *
 * @author lenovo
 */
public abstract class AsyncCall {
    public void apply(){
        call(null, null);
    }
    public abstract <T> void call(Exception err,T data);
    public abstract void call(Exception err);
}
