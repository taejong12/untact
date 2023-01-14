package com.sbs.untact.util;

import java.text.SimpleDateFormat;
import java.util.Date;

// 공용함수
// 유용한 것들
// 딱히 장소를 가리지 않고 유용하게 사용되는 것 다른 프로젝트도 사용가능
public class Util {

	public static String getNowDateStr() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		return format1.format(time);
	}
}
