package com.seongil.rxjava2example.basic;

import com.seongil.rxjava2example.log.TestLog;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.functions.Action;

/**
 * @author seong-il, kim
 * @since 18. 9. 17
 */
public class RxJavaOperators {

    @Test
    public void observableJustCreate() {
        UserService userService = new UserService();

        userService.getUserObservableCreate()
              .doOnSubscribe(___ -> TestLog.log("do on subscribed."))
              .doOnDispose(new Action() {
                  @Override
                  public void run() throws Exception {
                      TestLog.log("disposed the heavyJob operator.");
                  }
              })
              .subscribe(
                    ret -> TestLog.log("[success] " + ret.getId()),
                    thr -> TestLog.log("[error] " + thr.getMessage()));

        waitHeavyJob();
    }

    @Test
    public void observableJustTest() {
        UserService userService = new UserService();

        userService.getUserObservableJust()
              .doOnSubscribe(___ -> TestLog.log("do on subscribed."))
              .doOnDispose(new Action() {
                  @Override
                  public void run() throws Exception {
                      TestLog.log("disposed the heavyJob operator.");
                  }
              })
              .subscribe(
                    ret -> TestLog.log("[success] " + ret.getId()),
                    thr -> TestLog.log("[error] " + thr.getMessage()));

        waitHeavyJob();
    }

    @Test
    public void observableDeferTest() {
        UserService userService = new UserService();

        userService.getUserObservableDefer()
              .doOnSubscribe(___ -> TestLog.log("do on subscribed."))
              .doOnDispose(new Action() {
                  @Override
                  public void run() throws Exception {
                      TestLog.log("disposed the heavyJob operator.");
                  }
              })
              .subscribe(
                    ret -> TestLog.log("[success] " + ret.getId()),
                    thr -> TestLog.log("[error] " + thr.getMessage()));

        waitHeavyJob();
    }

    @Test
    public void observableFromCallableTest() {
        UserService userService = new UserService();

        userService.getUserFromCallable()
              .doOnSubscribe(___ -> TestLog.log("do on subscribed."))
              .doOnDispose(new Action() {
                  @Override
                  public void run() throws Exception {
                      TestLog.log("disposed the heavyJob operator.");
                  }
              })
              .subscribe(
                    ret -> TestLog.log("[success] " + ret.getId()),
                    thr -> TestLog.log("[error] " + thr.getMessage()));

        waitHeavyJob();
    }

    private void waitHeavyJob() {
        Single.timer(UserService.CONSUME_TIME_IN_MILLIS + 100, TimeUnit.MILLISECONDS);
    }
}
