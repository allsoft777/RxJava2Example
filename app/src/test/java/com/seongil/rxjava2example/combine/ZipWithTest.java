package com.seongil.rxjava2example.combine;

import com.google.common.collect.Lists;
import com.seongil.rxjava2example.log.TestLog;

import org.junit.Test;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author seong-il, kim
 * @since 18. 9. 20
 */
public class ZipWithTest {

    @Test
    public void observableZipTest() throws Exception {
        zipStreams1()
              .zipWith(zipStreams2(), (one, two) -> one + "_" + two)
              .subscribe(item -> TestLog.log(item));
    }

    private Observable<String> zipStreams1() {
        final List<String> items1 = Lists.newArrayList("one", "two", "three");
        return Observable.fromIterable(items1);
    }

    private Observable<String> zipStreams2() {
        final List<String> items2 = Lists.newArrayList("five", "six", "seven");
        return Observable.fromIterable(items2);
    }
}
