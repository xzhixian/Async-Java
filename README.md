# Async-Java
模仿nodejs的async的工具方法，提供了waterfall使用最简单的方式消除代码中的缩进地狱


##使用方法：
```java
        Async.waterfall(
            new AsyncTask[]{
                new AsyncTask() {
                    @Override
                    public void async(Object data, AsyncCall cb) {
                        cb.<Integer>call(null, 1);
                    }
                },
                new AsyncTask<Integer>() {
                    @Override
                    public void async(Integer data, AsyncCall cb) {
                        cb.<Integer>call(null, 2 + data);
                    }
                },
                new AsyncTask<Integer>() {
                    @Override
                    public void async(Integer data, AsyncCall cb) {
                        cb.<Integer>call(null, 2 + data);
                    }
                }
            }, 
            new AsycnComplete() {
                @Override
                public void onComplete(Exception err, Object data) {
                    if (err != null) {
                        System.out.println(".onComplete() err="+err);;
                    } else {
                        System.out.println(".onComplete()"+(int) data);
                    }
                }
            }
        );
```
