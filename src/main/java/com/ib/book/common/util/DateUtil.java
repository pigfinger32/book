package com.ib.book.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.ib.book.common.Const;

import lombok.extern.slf4j.Slf4j;

/***************************************************
* 
* Project  : ib_book_api
* Package  : com.ib.book.common.util
* Filename : DateUtil.java
* Description : 자바 공통 유틸
* Writer : ljh  
* Date : 2025. 11. 05.
*
* Revision History
* Writer             Date       Description
* ------------------ ---------- -----------------------
* ljh             2025. 11. 05.
*
****************************************************/
@Slf4j
public class DateUtil {
	
	
	
	public static String getCurrentDateTime() {	       
        // 현재 날짜/시간
        Date now = new Date();	        
        // 포맷팅 정의
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
        // 포맷팅 적용
        String formatedNow = formatter.format(now);	        
        return formatedNow;
	 }	
	
	
	/*****************************************************
	 * 날짜 데이타 구분자에 맞는 날짜 형식으로 변환
	 * @param dt
	 * @return String 변환 날짜 데이타
	 *****************************************************/
	public static String getDateAndHourMinute(String dt) {
		String result = "";
		try {
			String[] split = dt.substring(0, 10).split("-");
			String date = split[0] + "년 " + split[1] + "월 " + split[2] + "일 ";
			String fromTime = dt.substring(11,16).replace(":", "시 ") + "분";

			result = date + fromTime;
		} catch(Exception e) {
			log.error("Invalid Parameter Exception. {}, Exeption Info = {}", dt, e);	
			return dt;
		}
		
		return result;
	}

	/*****************************************************
	 * 날짜 데이타 구분자에 맞는 날짜 형식으로 변환
	 * @param delimiter 날짜 토큰
	 * @param rtnFormmat 날짜 포맷 구분자
	 * @return String 변환 날짜 데이타
	 *****************************************************/
	public static String getCurrentDate(String delimiter, String rtnFormmat) {

		// 응답받을 출력 시간
		String szReturn = "";

		try {
			// 캘린더 인스턴스
			Calendar currentWhat = Calendar.getInstance();

			// 현재 년도
			int currentYear = currentWhat.get(Calendar.YEAR);
			// 현재 월
			int currentMonth = currentWhat.get(Calendar.MONTH) + 1;
			// 현재 일
			int currentDay = currentWhat.get(Calendar.DAY_OF_MONTH);
			// 현재 시간(시)
			int currentHour = currentWhat.get(Calendar.HOUR_OF_DAY);
			// 현재 시간(분)
			int currentMinute = currentWhat.get(Calendar.MINUTE);
			// 현재 시간(초)
			int currentSecond = currentWhat.get(Calendar.SECOND);
			// 현재 시간(밀리세컨드)
			int currentMilecond = currentWhat.get(Calendar.MILLISECOND);

			// 현재 년도 4자리 스트링으로 변환
			String yearToday = StringUtil.padLeftwithZero(currentYear, 4);
			// 현재 월 2자리 스트링으로 변환
			String monthToday = StringUtil.padLeftwithZero(currentMonth, 2);
			// 현재 일 2자리 스트링으로 변환
			String dayToday = StringUtil.padLeftwithZero(currentDay, 2);
			// 현재 시간(시) 2자리 스트링으로 변환
			String hourToday = StringUtil.padLeftwithZero(currentHour, 2);
			// 현재 시간(분) 2자리 스트링으로 변환
			String minuteToday = StringUtil.padLeftwithZero(currentMinute, 2);
			// 현재 시간(초) 2자리 스트링으로 변환
			String secondToday = StringUtil.padLeftwithZero(currentSecond, 2);
			// 현재 시간(밀리세컨드) 3자리 스트링으로 변환
			String milecondToday = StringUtil.padLeftwithZero(currentMilecond, 3);

			if (rtnFormmat.equals("YYYY/MM/DD HH:MI:SS")) {
				szReturn = yearToday + "/" + monthToday + "/" + dayToday
										+ " " + hourToday + ":" + minuteToday + ":" + secondToday;
			}else if (rtnFormmat.equals("YYYY.MM.DD HH:MI:SS")) {
				szReturn = yearToday + "." + monthToday + "." + dayToday
						+ " " + hourToday + ":" + minuteToday + ":" + secondToday;
			} else if (rtnFormmat.equals("YYYY-MM-DD")) {
				szReturn = yearToday + "-" + monthToday + "-" + dayToday;
			} else if (rtnFormmat.equals("YYYYMMDD-HHMISS")) {
				szReturn = yearToday + monthToday + dayToday
										+ "-" + hourToday + minuteToday + secondToday;
			} else if (rtnFormmat.equals("YYYYMMDDHHMISS")) {
				szReturn = yearToday + monthToday + dayToday
										+ hourToday + minuteToday + secondToday;
			} else if (rtnFormmat.equals("YYYYMMDDHHMISSMS")) {
				szReturn = yearToday + monthToday + dayToday
						+ hourToday + minuteToday + secondToday + milecondToday.substring(0,2);
			} else if (rtnFormmat.equals("YYYYMMDD")) {
				szReturn = yearToday + monthToday + dayToday;
			} else if (rtnFormmat.equals("HH:MI:SS")) {
				szReturn = hourToday + ":" + minuteToday + ":" + secondToday;
			} else if (rtnFormmat.equals("HHMISS")) {
				szReturn = hourToday + minuteToday + secondToday;
			} else if (rtnFormmat.equals("YYYY")) {
				szReturn = yearToday;
			} else if (rtnFormmat.equals("MM")) {
				szReturn = monthToday;
			} else if (rtnFormmat.equals("DD")) {
				szReturn = dayToday;
			} else if (rtnFormmat.equals("HHMI")) {
				szReturn = hourToday + minuteToday;
			} else if (rtnFormmat.equals("HH:MI")) {
				szReturn = hourToday + ":" + minuteToday;
			} else if (rtnFormmat.equals("MS")) {
				szReturn = milecondToday.substring(0,2);
			} else if (rtnFormmat.equals("dafault")) {
				szReturn = yearToday + delimiter + monthToday + delimiter + dayToday;
			} else {
				szReturn = yearToday + delimiter + monthToday + delimiter + dayToday;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return szReturn;
	}

	/*****************************************************
	 * 날짜 비교
	 * @param day1 비교날짜
	 * @param day2 비교날짜
	 * @param patten 날짜패턴 (default : yyyy-MM-dd)
	 * @return int  day1 = day2 (0 리턴)
	 * 				day1 > day2 (1 리턴)
	 * 				day1 < day2 (-1 리턴)
	 * 			    error 		(-999 리턴)
	 *****************************************************/
	public static int compareTo(String day1, String day2, String patten) {
		int result = 0;

		if(CoreUtil.isEmpty(patten)) {
			patten = Const.DatePatten.YMD_1;
		}

		if(CoreUtil.isNotEmpty(day1) && CoreUtil.isNotEmpty(day2)) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(patten);

				Date date1 = dateFormat.parse(day1);
				Date date2 = dateFormat.parse(day2);


				if(date1.compareTo(date2) > 0) {
					result = 1;
				} else if(date1.compareTo(date2) < 0) {
					result = -1;
				} else {
					result = 0;
				}

			} catch (ParseException e) {
				log.error(e.getMessage());
				result = -999;
			}
		} else {
			log.error("파라메터 오류");
			result = -999;
		}

		return result;
	}

	/*****************************************************
	 * 날짜 차이
	 * @param day1 비교날짜
	 * @param day2 비교날짜
	 * @param patten 날짜패턴 (default : yyyy-MM-dd)
	 * @param returnType 리턴유형(D:일, H:시간, M:분, S:초(default))
	 * @return long
	 * 			error (-999 리턴)
	 *****************************************************/
	public static long getDateDiff(String day1, String day2, String patten, String returnType) {
		long result = 0;

		if(CoreUtil.isEmpty(patten)) {
			patten = Const.DatePatten.YMD_1;
		}

		if(CoreUtil.isEmpty(returnType)) {
			returnType = "S";
		}

		if(CoreUtil.isNotEmpty(day1) && CoreUtil.isNotEmpty(day2)) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(patten);

				Date date1 = dateFormat.parse(day1);
				Date date2 = dateFormat.parse(day2);

				long calDate = date1.getTime() - date2.getTime();
				long n = 1;

				if("H".equals(returnType)) {
					n = 24*60*60*1000;
				} else if("H".equals(returnType)) {
					n = 60*60*1000;
				} else if("M".equals(returnType)) {
					n = 60*1000;
				} else {
					n = 1000;
				}

				long calDateDays = calDate / n;

				result = Math.abs(calDateDays);

			} catch (ParseException e) {
				log.error(e.getMessage());
				result = -999;
			}
		} else {
			log.error("파라메터 오류");
			result = -999;
		}

		return result;
	}

	/*****************************************************
	 * 날짜 형식
	 * @param date 날짜
	 * @param patten 날짜패턴 (default : yyyy-MM-dd HH:mm:ss)
	 * @return String
	 *****************************************************/
	public static String getDateFormat(Date date, String patten) {
		if(CoreUtil.isEmpty(patten)) {
			patten = Const.DatePatten.YMDHMS_1;
		}

		if(date == null) {
			Calendar today = Calendar.getInstance();
			date = today.getTime();
		}

		SimpleDateFormat sdf = new SimpleDateFormat(patten);

		return sdf.format(date);
	}

	public static String getDateFormat() {
		return getDateFormat(null, null);
	}

	public static String getDateFormat(String patten) {
		return getDateFormat(null, patten);
	}


	/*****************************************************
	 * 날짜 변경
	 * @param day 			날짜 문자열(yyyy-MM-dd or yyyy-MM-dd HH:mm:ss)
	 * @param type 			변경유형 (default : day) - year(년), month(월), week(주), day(일), hour(시), min(분), sec(초)
	 * @param n 			변경값
	 * @param patten 		날짜패턴 (default : yyyy-MM-dd)
	 * @return String
	 *****************************************************/
	public static String getDateChangeFormat(String day, String type, int n, String patten) {
		LocalDateTime ldt = null;

		if(StringUtils.isBlank(patten)) {
			patten = Const.DatePatten.YMD_1;
		}

		if(!StringUtils.equalsAny(type
				, Const.DateChange.YEAR
				, Const.DateChange.MONTH
				, Const.DateChange.WEEK
				, Const.DateChange.DAY
				, Const.DateChange.HOUR
				, Const.DateChange.MIN
				, Const.DateChange.SEC
		)) {
			type = Const.DateChange.DAY;
		}

		try {

			LocalDateTime dtm = LocalDateTime.now();

			if(StringUtils.isNotBlank(day)) {

				if(day.length() < 11) {
					LocalDate date = LocalDate.parse(day);
					LocalTime time = LocalTime.of(0, 0, 0, 0);
					dtm = LocalDateTime.of(date, time);
				} else {
					dtm = LocalDateTime.parse(day);
				}
			}

			if(n < 0) {
				switch (type) {
					case Const.DateChange.YEAR:
						ldt = dtm.minusYears(-1*n);
						break;
					case Const.DateChange.MONTH:
						ldt = dtm.minusMonths(-1*n);
						break;
					case Const.DateChange.WEEK:
						ldt = dtm.minusWeeks(-1*n);
						break;
					case Const.DateChange.DAY:
						ldt = dtm.minusDays(-1*n);
						break;
					case Const.DateChange.HOUR:
						ldt = dtm.minusHours(-1*n);
						break;
					case Const.DateChange.MIN:
						ldt = dtm.minusMinutes(-1*n);
						break;
					case Const.DateChange.SEC:
						ldt = dtm.minusSeconds(-1*n);
						break;
					default:
						break;
				}
			} else {
				switch (type) {
					case Const.DateChange.YEAR:
						ldt = dtm.plusYears(n);
						break;
					case Const.DateChange.MONTH:
						ldt = dtm.plusMonths(n);
						break;
					case Const.DateChange.WEEK:
						ldt = dtm.plusWeeks(n);
						break;
					case Const.DateChange.DAY:
						ldt = dtm.plusDays(n);
						break;
					case Const.DateChange.HOUR:
						ldt = dtm.plusHours(n);
						break;
					case Const.DateChange.MIN:
						ldt = dtm.plusMinutes(n);
						break;
					case Const.DateChange.SEC:
						ldt = dtm.plusSeconds(n);
						break;
					default:
						break;
				}
			}

		} catch (Exception e) {
			log.error("날짜 처리 오류!!");
			return "";
		}

		return ldt.format(DateTimeFormatter.ofPattern(patten));
	}

	
    private static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");

    public static long getUnixTime(String date) {
        long unixTime = 0;
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul")); 
        try {
            unixTime = dateFormat.parse(date).getTime();
            unixTime = unixTime / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unixTime;
    }	

    public static long getUnixTimeNow() {
    	Date date = new Date();
        long unixTime = 0;
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul")); 
        try {
            unixTime = date.getTime();
            unixTime = unixTime / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unixTime;
    }	    
    
	public static String simpleDate(long lTimestamp) 
    {
        return(changeDateFormat(lTimestamp));       
	}	

	public static String simpleDate(int iTimestamp) 
    {
        long lTimestamp = 0L;
        lTimestamp = Long.parseLong(Integer.toString(iTimestamp)+"000");
        return(changeDateFormat(lTimestamp));
	}	

    public static String changeDateFormat(long lTimestamp)
    {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm");
		java.util.Date date = new java.util.Date(lTimestamp);
		String sCurrentDate = sdf.format(date);
		String sMM = null;
		
		switch(Integer.parseInt(sCurrentDate.substring(3,5))) {
			case 1 : sMM = "JAN";	break;
			case 2 : sMM = "FEB";	break;
			case 3 : sMM = "MAR";	break;
			case 4 : sMM = "APR";	break;
			case 5 : sMM = "MAY";	break;
			case 6 : sMM = "JUN";	break;
			case 7 : sMM = "JUL";	break;
			case 8 : sMM = "AUG";	break;
			case 9 : sMM = "SEP";	break;
			case 10: sMM = "OCT";	break;
			case 11: sMM = "NOV";	break;
			case 12: sMM = "DEC";	break;
		}		
		return sCurrentDate.substring(0,3) + sMM + sCurrentDate.substring(5);
    }


	public static String date_format(int iTimestamp, String sFormat) 
    {
        long lTimestamp = 0L;
        lTimestamp = Long.parseLong(Integer.toString(iTimestamp)+"000");
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		java.util.Date date = new java.util.Date(lTimestamp);
		String sCurrentDate = sdf.format(date);
		return sCurrentDate;
	}
		
}