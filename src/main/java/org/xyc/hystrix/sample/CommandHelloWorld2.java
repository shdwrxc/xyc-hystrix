package org.xyc.hystrix.sample;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by IntelliJ IDEA.
 * Author: wks
 * Date: 2016/12/27
 */
public class CommandHelloWorld2 extends HystrixObservableCommand<String> {

    private final String name;

    public CommandHelloWorld2(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        // a real example would do work like a network call here
//                        observer.onNext("Hello");
                        observer.onNext(name + "!");
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        } );
    }

    public static void main(String[] args) throws Exception {
//        new CommandHelloWorld2("world").observe().toBlocking().toFuture().get();
        System.out.println(new CommandHelloWorld2("world").observe().toBlocking().single());
    }
}
