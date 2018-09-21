package com.seongil.rxjava2example.map;

import com.google.common.collect.Lists;
import com.seongil.rxjava2example.log.TestLog;

import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

/**
 * @author seong-il, kim
 * @since 18. 9. 20
 */
public class SwitchMapTest {

    @Test
    public void testSwitchMap() throws Exception {
        final List<String> items = Lists.newArrayList("a", "b", "c", "d", "e", "f");
        final TestScheduler scheduler = new TestScheduler();

        Observable.fromIterable(items)
              .switchMap(s -> {
                  final int delay = new Random().nextInt(10);
                  return Observable.just(s + "x")
                        .delay(delay, TimeUnit.SECONDS, scheduler);
              })
              .toList()
              .doOnSuccess(item -> TestLog.log(item.toString()))
              .subscribe();

        scheduler.advanceTimeBy(1, TimeUnit.MINUTES);
    }
}
