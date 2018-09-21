package com.seongil.rxjava2example.map;

import com.google.common.collect.Lists;
import com.seongil.rxjava2example.log.TestLog;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

/**
 * @author seong-il, kim
 * @since 18. 9. 20
 */
public class FlatMapAndConcatMapTest {

    @Test
    public void compareFlatMapAndConcatMap() throws Exception {
        final List<String> items = Lists.newArrayList("a", "b", "c", "d", "e", "f");

        // flatMap
        final TestScheduler flatmapScheduler = new TestScheduler();
        Observable.fromIterable(items)
              .flatMap(s -> Observable.just(s + "x")
                    .delay(5, TimeUnit.SECONDS, flatmapScheduler)
                    .doOnNext(str -> TestLog.log(flatmapScheduler.now(TimeUnit.SECONDS) + " ")))
              .toList()
              .doOnSuccess(strings -> System.out.println(
                    "\nend of stream : " + flatmapScheduler.now(TimeUnit.SECONDS) + "\n\n"))
              .subscribe();
        flatmapScheduler.advanceTimeBy(1, TimeUnit.MINUTES);

        // concatMap
        final TestScheduler concatMapScheduler = new TestScheduler();
        Observable.fromIterable(items)
              .concatMap(s -> Observable.just(s + "x")
                    .delay(5, TimeUnit.SECONDS, concatMapScheduler)
                    .doOnNext(str -> TestLog.log(concatMapScheduler.now(TimeUnit.SECONDS) + " ")))
              .toList()
              .doOnSuccess(
                    strings -> System.out.println("\nend of stream : " + concatMapScheduler.now(TimeUnit.SECONDS)))
              .subscribe();
        concatMapScheduler.advanceTimeBy(1, TimeUnit.MINUTES);
    }
}
