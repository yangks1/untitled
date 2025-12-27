package org.example.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogErrorStatistic {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        // 用于统计错误代码出现次数
        Map<String, Integer> errorCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length < 4) {
                    System.out.println("日志格式不相符");
                    continue;
                }
                LocalDateTime logTime;
                try {
                    String f = parts[0] + " " + parts[1];
                    logTime = LocalDateTime.parse(f, formatter);

                } catch (Exception e){
                    continue;
                }
                LocalDateTime now = LocalDateTime.now();
                if (Duration.between(logTime, now).toSeconds() > 3000) {
                    continue;
                }
                String errorCode = parts[3];
                errorCount.put(errorCode, errorCount.getOrDefault(errorCode, 0) + 1);

                List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(errorCount.entrySet());
                sortedList.sort((e1, e2) -> e2.getValue() - e1.getValue()); //降序排列
                System.out.printf("近一分钟错误码Top3: %n");
                for (int i = 0; i < Math.min(3, sortedList.size()); i++) {
                    Map.Entry<String, Integer> entry = sortedList.get(i);
                    System.out.printf("%d. 错误码：%s，出现次数：%d%n", i + 1, entry.getKey(), entry.getValue());
                }
                System.out.printf("-----------------------------%n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
