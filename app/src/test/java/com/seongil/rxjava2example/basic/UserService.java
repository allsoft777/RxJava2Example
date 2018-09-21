package com.seongil.rxjava2example.basic;

import com.seongil.rxjava2example.log.TestLog;

import io.reactivex.Observable;

/**
 * @author seong-il, kim
 * @since 18. 9. 17
 */
public class UserService {

    public static final int CONSUME_TIME_IN_MILLIS = 1000;

    public User getUserFromHeavyDb() throws InterruptedException {
        TestLog.log("start. getUserFromDb");
        Thread.sleep(CONSUME_TIME_IN_MILLIS);
        TestLog.log("end. getUserFromDb");
        return new User(1);
    }

    public Observable<User> getUserObservableCreate() {
        return Observable.create(e -> {
            try {
                Observable.just(getUserFromHeavyDb());
            } catch (Exception ex) {
                Observable.error(ex);
            }
        });
    }

    public Observable<User> getUserObservableJust() {
        try {
            return Observable.just(getUserFromHeavyDb());
        } catch (InterruptedException e) {
            return Observable.error(e);
        }
    }

    public Observable<User> getUserObservableDefer() {
        return Observable.defer(() -> {
            try {
                User user = getUserFromHeavyDb();
                return Observable.just(user);
            } catch (Exception ex) {
                return Observable.error(ex);
            }
        });
    }

    public Observable<User> getUserFromCallable() {
        return Observable.fromCallable(() -> {
            return getUserFromHeavyDb();
        });
    }
}
