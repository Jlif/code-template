package tech.jiangchen.concurrent;

import lombok.SneakyThrows;

/**
 * @author jiangchen
 * @date 2021/07/05
 */
public class SleepUtils {

    @SneakyThrows
    public static void second(int second) {
        Thread.sleep(second * 1000L);
    }
}
