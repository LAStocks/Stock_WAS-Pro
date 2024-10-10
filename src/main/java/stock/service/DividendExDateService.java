package stock.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Service
public class DividendExDateService {

    public List<String> scrapeDividendCalendar() {
        List<String> dividendData = new ArrayList<>();
        try {
            // URL에 접속하여 HTML을 파싱
            Document document = Jsoup.connect("https://kr.investing.com/dividends-calendar/")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                    .timeout(10 * 1000)
                    .get();

            // 배당 캘린더 테이블을 찾기
            Element calendarTable = document.selectFirst("#dividendsCalendarData");  // 테이블 ID나 클래스로 선택
            if (calendarTable != null) {
                Elements rows = calendarTable.select("tr");

                // 각 행에서 데이터 추출
                for (Element row : rows) {
                    Elements columns = row.select("td");  // 각 열을 추출
                    if (columns.size() > 1) {
                        String companyName = columns.get(1).text();         // 첫 번째 열(회사명)
                        String exDate = columns.get(2).text();              // 두 번째 열(배당락일)
                        String dividendAmount = columns.get(3).text();      // 세 번째 열(배당금)
                        String dividendType = columns.get(4).text();        // 넷 번째 열(배당유형)
                        String dividendPaymentDate = columns.get(5).text(); // 다섯 번째 열(배당지불일자)
                        String dividendYield = columns.get(6).text();       // 다섯 번째 열(연 수익률)
                        // 원하는 데이터를 추출하여 리스트에 추가
                        dividendData.add("회사명: " + companyName + ", 배당락일: " + exDate + ", 배당금: " + dividendAmount + ", 배당유형: " + dividendType + ", 배당지불일: " + dividendPaymentDate + ", 연 수익률: " + dividendYield);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dividendData;  // 스크랩한 배당 캘린더 데이터 반환
    }
}
