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
public interface AsyncTask<T>{
    void async(T data, AsyncCall cb);
}
