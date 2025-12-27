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

public class LogErrorStatisticCopy {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Integer LIMIT_SECONDS = 60000;

    public static void main(String[] args) {

        Map<String, Integer> errorCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length < 4) {
                    continue;
                }
                LocalDateTime logTime;
                try {
                    logTime = LocalDateTime.parse(parts[0] + " " + parts[1], formatter);
                }catch (Exception e) {
                    continue;
                }
                LocalDateTime now = LocalDateTime.now();
                if (Duration.between(now, logTime).toSeconds() > LIMIT_SECONDS) {
                    continue;
                }
                String errorCode = parts[3];
                errorCount.put(errorCode, errorCount.getOrDefault(errorCode, 0) + 1);

                List<Map.Entry<String, Integer>> sortList = new ArrayList<>(errorCount.entrySet());
                // 根据value降序排列
                sortList.sort((e1, e2) -> e2.getValue() - e1.getValue());
                System.out.println("最近" + LIMIT_SECONDS + "秒内TOP3的错误码为: %n");
                for (int i = 0; i < Math.min(3, sortList.size()); i++) {
                    System.out.printf("%d. 错误码： %s，出现次数：%d%n", i + 1, sortList.get(i).getKey(), sortList.get(i).getValue());
                }
                System.out.printf("------------------------%n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
