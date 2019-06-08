
    // TODO waterfall
    public static void waterfall(AsyncTask[] runnables, AsycnComplete complete) {
        new WaterfallCall(runnables, complete).apply();
    }
    
    
    
    // TODO: eachSeries

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        waterfall(new AsyncTask[]{
            new AsyncTask() {
                @Override
                public void async(Object data, AsyncCall cb) {
                    cb.<Integer>call(null, 1);
                }
            },
            new AsyncTask<Integer>() {
                @Override
                public void async(Integer data, AsyncCall cb) {
                    cb.<Long>call(null, 2L + (int)data);
                }
            },
            new AsyncTask<Long>() {
                @Override
                public void async(Long data, AsyncCall cb) {
                    cb.<Float>call(null, 2.3f + data);
                }
            }
        }, 
        new AsycnComplete<Float>() {
            @Override
            public void onComplete(Exception err, Float data) {
                if (err != null) {
                    System.out.println(".onComplete() err="+err);;
                } else {
                    System.out.println(".onComplete()"+ data);
                }
            }
        });
    }
    
}
