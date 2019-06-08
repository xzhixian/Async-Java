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
public class WaterfallCall extends AsyncCall{
    private final AsycnComplete complete;
    private final AsyncTask[] asyncRunnables;
    private int index = 0;

    WaterfallCall(AsyncTask[] runnables, AsycnComplete complete) {
        this.complete = complete;
        this.asyncRunnables = runnables;
    }

    
    @Override
    public void call(Exception err) {
        call(err, null);
    }

    @Override
    public void call(Exception err, Object data) {
        if (err != null) {
            complete.onComplete(err);
            return;
        }
        if (asyncRunnables != null) {
            if (index < asyncRunnables.length ) {
                asyncRunnables[index++].async(data, this);
            } else complete.onComplete(null, data);
        }
        
    }
    
}
