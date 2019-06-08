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
public abstract class AsycnComplete<T> {
    public void onComplete(Exception err){
        onComplete(err, null);
    }
    public abstract void onComplete(Exception err,T data);
}
