package com.shadow.crawler.Example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.shadow.crawler.util.HttpUtil;
/**
 * 中国天气网爬取全国主要城市地区当天天气预报
 * 
 * @author RuiJiang
 *
 */
public class test {

	private static List<String> cityCode;
	// 全国当天天气查询url前缀
	private static final String prefix = "http://www.weather.com.cn/weather1d/";
	
	public static void main(String[] args) throws IOException {
		Map<String,String> map = new HashMap<String, String>();
		List<tempPojo> tempList = new ArrayList<test.tempPojo>();
		for (String code : cityCode) {
			String url = prefix + code +".shtml";
			//String response = HttpUtil.doPost("https://www.baidu.com", null);
			String response = HttpUtil.doGet(url, map);
			Document doc = Jsoup.parse(response);
			tempPojo temp = new tempPojo();
			// 城市地区域
			Elements cityElements = doc.select("div.xyn-weather-box").select("h2");
			temp.setProvince(cityElements.select("span").first().text());
			System.out.println("省：" + cityElements.select("span").first().text());
			temp.setCity(cityElements.select("div#select").select("span").first().text());
			System.out.println("市：" + cityElements.select("div#select").select("span").first().text());
			// 天气预测域
			Elements forcastElements = doc.select("div.t").select("h1");
			if (forcastElements != null && forcastElements.size() >= 2) {
				temp.setDayTime(forcastElements.get(0).text());
				temp.setNightTime(forcastElements.get(1).text());
				System.out.println("日期白天：" + forcastElements.get(0).text());
				System.out.println("日期夜间：" + forcastElements.get(1).text());
			}
			Elements ele = doc.select("div#today").select("p.tem");
			String[] weaStr = doc.select("p.wea").text().split(" ");
			temp.setWea(weaStr[0]);
			System.out.println("天气：" + weaStr[0]);
			//temp.setSkypop(skypop);
			String[] str = ele.select("span").text().split(" ");
			if (str !=null && str.length > 1) {
				temp.setDayTemp(str[0]);
				temp.setNightTemp(str[1]);
			}
			tempList.add(temp);
		}
		
		//System.out.println(dayTemp + "----------" + nightTemp);
	}
	
	static {
		cityCode = new ArrayList<String>();
		cityCode.add("101010100");
		cityCode.add("101020100");
		cityCode.add("101030100");
		cityCode.add("101040100");
		cityCode.add("101320101");
		cityCode.add("101330101");
		cityCode.add("101050101");
		cityCode.add("101050201");
		cityCode.add("101050301");
		cityCode.add("101050901");
		cityCode.add("101050801");
		cityCode.add("101051301");
		cityCode.add("101051201");
		cityCode.add("101051101");
		cityCode.add("101050401");
		cityCode.add("101051002");
		cityCode.add("101050601");
		cityCode.add("101050501");
		cityCode.add("101050701");
		cityCode.add("101060101");
		cityCode.add("101060301");
		cityCode.add("101060201");
		cityCode.add("101060901");
		cityCode.add("101060601");
		cityCode.add("101060401");
		cityCode.add("101060801");
		cityCode.add("101060701");
		cityCode.add("101060603");
		cityCode.add("101060501");
		cityCode.add("101070101");
		cityCode.add("101070201");
		cityCode.add("101071401");
		cityCode.add("101071301");
		cityCode.add("101070501");
		cityCode.add("101070401");
		cityCode.add("101071101");
		cityCode.add("101071001");
		cityCode.add("101070801");
		cityCode.add("101070901");
		cityCode.add("101071201");
		cityCode.add("101070701");
		cityCode.add("101070601");
		cityCode.add("101070301");
		cityCode.add("101080101");
		cityCode.add("101081013");
		cityCode.add("101080901");
		cityCode.add("101080201");
		cityCode.add("101080601");
		cityCode.add("101081001");
		cityCode.add("101080301");
		cityCode.add("101080701");
		cityCode.add("101080501");
		cityCode.add("101090101");
		cityCode.add("101090501");
		cityCode.add("101090301");
		cityCode.add("101090601");
		cityCode.add("101090901");
		cityCode.add("101091001");
		cityCode.add("101090701");
		cityCode.add("101090801");
		cityCode.add("101090402");
		cityCode.add("101090201");
		cityCode.add("101091101");
		cityCode.add("101180101");
		cityCode.add("101180801");
		cityCode.add("101180901");
		cityCode.add("101180501");
		cityCode.add("101181101");
		cityCode.add("101181201");
		cityCode.add("101180301");
		cityCode.add("101180201");
		cityCode.add("101181301");
		cityCode.add("101180401");
		cityCode.add("101181501");
		cityCode.add("101181701");
		cityCode.add("101180701");
		cityCode.add("101181001");
		cityCode.add("101180601");
		cityCode.add("101181401");
		cityCode.add("101181601");
		cityCode.add("101120101");
		cityCode.add("101120201");
		cityCode.add("101120301");
		cityCode.add("101121301");
		cityCode.add("101120710");
		cityCode.add("101120901");
		cityCode.add("101120501");
		cityCode.add("101121401");
		cityCode.add("101121701");
		cityCode.add("101120701");
		cityCode.add("101121001");
		cityCode.add("101120801");
		cityCode.add("101121501");
		cityCode.add("101121201");
		cityCode.add("101120401");
		cityCode.add("101121101");
		cityCode.add("101121601");
		cityCode.add("101120601");
		cityCode.add("101100101");
		cityCode.add("101100301");
		cityCode.add("101100601");
		cityCode.add("101100401");
		cityCode.add("101100701");
		cityCode.add("101100801");
		cityCode.add("101100501");
		cityCode.add("101100901");
		cityCode.add("101101001");
		cityCode.add("101100201");
		cityCode.add("101101101");
		cityCode.add("101190101");
		cityCode.add("101190401");
		cityCode.add("101190404");
		cityCode.add("101190501");
		cityCode.add("101190408");
		cityCode.add("101190406");
		cityCode.add("101190801");
		cityCode.add("101190203");
		cityCode.add("101190301");
		cityCode.add("101190901");
		cityCode.add("101190402");
		cityCode.add("101190701");
		cityCode.add("101191201");
		cityCode.add("101190201");
		cityCode.add("101191001");
		cityCode.add("101190601");
		cityCode.add("101191101");
		cityCode.add("101191301");
		cityCode.add("101220101");
		cityCode.add("101220105");
		cityCode.add("101220201");
		cityCode.add("101220601");
		cityCode.add("101221501");
		cityCode.add("101221101");
		cityCode.add("101220501");
		cityCode.add("101220801");
		cityCode.add("101221401");
		cityCode.add("101221301");
		cityCode.add("101221201");
		cityCode.add("101220301");
		cityCode.add("101220901");
		cityCode.add("101220701");
		cityCode.add("101220401");
		cityCode.add("101221701");
		cityCode.add("101110101");
		cityCode.add("101110510");
		cityCode.add("101110701");
		cityCode.add("101110801");
		cityCode.add("101110901");
		cityCode.add("101110200");
		cityCode.add("101110401");
		cityCode.add("101110501");
		cityCode.add("101110601");
		cityCode.add("101111001");
		cityCode.add("101110300");
		cityCode.add("101170101");
		cityCode.add("101170401");
		cityCode.add("101170501");
		cityCode.add("101170201");
		cityCode.add("101170301");
		cityCode.add("101160101");
		cityCode.add("101161301");
		cityCode.add("101160401");
		cityCode.add("101160801");
		cityCode.add("101160901");
		cityCode.add("101160501");
		cityCode.add("101160701");
		cityCode.add("101050204");
		cityCode.add("101161101");
		cityCode.add("101160301");
		cityCode.add("101160201");
		cityCode.add("101160601");
		cityCode.add("101150101");
		cityCode.add("101150801");
		cityCode.add("101150701");
		cityCode.add("101150301");
		cityCode.add("101150501");
		cityCode.add("101150601");
		cityCode.add("101150201");
		cityCode.add("101150401");
		cityCode.add("101200101");
		cityCode.add("101200901");
		cityCode.add("101200501");
		cityCode.add("101201001");
		cityCode.add("101200801");
		cityCode.add("101201201");
		cityCode.add("101201101");
		cityCode.add("101200701");
		cityCode.add("101200201");
		cityCode.add("101200401");
		cityCode.add("101201301");
		cityCode.add("101200601");
		cityCode.add("101201401");
		cityCode.add("101200301");
		cityCode.add("101250101");
		cityCode.add("101250901");
		cityCode.add("101250601");
		cityCode.add("101250501");
		cityCode.add("101251501");
		cityCode.add("101250301");
		cityCode.add("101250801");
		cityCode.add("101250201");
		cityCode.add("101250701");
		cityCode.add("101251401");
		cityCode.add("101251001");
		cityCode.add("101250401");
		cityCode.add("101251201");
		cityCode.add("101250202");
		cityCode.add("101251101");
		cityCode.add("101210101");
		cityCode.add("101210201");
		cityCode.add("101210901");
		cityCode.add("101210401");
		cityCode.add("101210801");
		cityCode.add("101210501");
		cityCode.add("101211001");
		cityCode.add("101210301");
		cityCode.add("101210601");
		cityCode.add("101211101");
		cityCode.add("101210701");
		cityCode.add("101240101");
		cityCode.add("101240901");
		cityCode.add("101240201");
		cityCode.add("101240301");
		cityCode.add("101240401");
		cityCode.add("101240601");
		cityCode.add("101241101");
		cityCode.add("101240501");
		cityCode.add("101241001");
		cityCode.add("101240801");
		cityCode.add("101240701");
		cityCode.add("101230101");
		cityCode.add("101230201");
		cityCode.add("101230701");
		cityCode.add("101230901");
		cityCode.add("101230301");
		cityCode.add("101230401");
		cityCode.add("101230501");
		cityCode.add("101230801");
		cityCode.add("101230601");
		cityCode.add("101260101");
		cityCode.add("101260301");
		cityCode.add("101260208");
		cityCode.add("101260201");
		cityCode.add("101260601");
		cityCode.add("101260801");
		cityCode.add("101260701");
		cityCode.add("101260501");
		cityCode.add("101260401");
		cityCode.add("101270101");
		cityCode.add("101271001");
		cityCode.add("101271201");
		cityCode.add("101271601");
		cityCode.add("101271901");
		cityCode.add("101270901");
		cityCode.add("101272101");
		cityCode.add("101271401");
		cityCode.add("101270401");
		cityCode.add("101272001");
		cityCode.add("101270201");
		cityCode.add("101271701");
		cityCode.add("101271101");
		cityCode.add("101270301");
		cityCode.add("101271801");
		cityCode.add("101270601");
		cityCode.add("101271301");
		cityCode.add("101270801");
		cityCode.add("101270701");
		cityCode.add("101271501");
		cityCode.add("101270501");
		cityCode.add("101280101");
		cityCode.add("101280601");
		cityCode.add("101281501");
		cityCode.add("101280201");
		cityCode.add("101281001");
		cityCode.add("101280301");
		cityCode.add("101281301");
		cityCode.add("101281601");
		cityCode.add("101281101");
		cityCode.add("101282001");
		cityCode.add("101280901");
		cityCode.add("101282101");
		cityCode.add("101281201");
		cityCode.add("101281901");
		cityCode.add("101280401");
		cityCode.add("101281701");
		cityCode.add("101280905");
		cityCode.add("101281801");
		cityCode.add("101281401");
		cityCode.add("101280701");
		cityCode.add("101280501");
		cityCode.add("101280800");
		cityCode.add("101300101");
		cityCode.add("101300501");
		cityCode.add("101300510");
		cityCode.add("101300301");
		cityCode.add("101300601");
		cityCode.add("101300901");
		cityCode.add("101300802");
		cityCode.add("101300701");
		cityCode.add("101301101");
		cityCode.add("101300801");
		cityCode.add("101301401");
		cityCode.add("101301001");
		cityCode.add("101301301");
		cityCode.add("101301201");
		cityCode.add("101300401");
		cityCode.add("101300201");
		cityCode.add("101290101");
		cityCode.add("101290501");
		cityCode.add("101290801");
		cityCode.add("101291501");
		cityCode.add("101290301");
		cityCode.add("101291101");
		cityCode.add("101291201");
		cityCode.add("101290401");
		cityCode.add("101290901");
		cityCode.add("101290601");
		cityCode.add("101290701");
		cityCode.add("101291001");
		cityCode.add("101291401");
		cityCode.add("101290201");
		cityCode.add("101310101");
		cityCode.add("101310201");
		cityCode.add("101310205");
		cityCode.add("101310102");
		cityCode.add("101310222");
		cityCode.add("101310212");
		cityCode.add("101130101");
		cityCode.add("101131401");
		cityCode.add("101130801");
		cityCode.add("101130401");
		cityCode.add("101131201");
		cityCode.add("101131301");
		cityCode.add("101130901");
		cityCode.add("101130201");
		cityCode.add("101130301");
		cityCode.add("101131101");
		cityCode.add("101130601");
		cityCode.add("101130501");
		cityCode.add("101131001");
		cityCode.add("101140101");
		cityCode.add("101140701");
		cityCode.add("101140501");
		cityCode.add("101140601");
		cityCode.add("101140201");
		cityCode.add("101140301");
		cityCode.add("101140401");
		cityCode.add("101340102");
		cityCode.add("101340201");
	}
	
	protected static class tempPojo {
		String dayDesc;
		String nightDesc;
		String dayTemp;
		String dayTime;
		String nightTime;
		String nightTemp;
		String province;
		String city;
		String wea;
		String skypop;
		
		public String getDayTime() {
			return dayTime;
		}
		public void setDayTime(String dayTime) {
			this.dayTime = dayTime;
		}
		public String getNightTime() {
			return nightTime;
		}
		public void setNightTime(String nightTime) {
			this.nightTime = nightTime;
		}
		public String getDayDesc() {
			return dayDesc;
		}
		public void setDayDesc(String dayDesc) {
			this.dayDesc = dayDesc;
		}
		public String getNightDesc() {
			return nightDesc;
		}
		public void setNightDesc(String nightDesc) {
			this.nightDesc = nightDesc;
		}
		public String getDayTemp() {
			return dayTemp;
		}
		public void setDayTemp(String dayTemp) {
			this.dayTemp = dayTemp;
		}
		public String getNightTemp() {
			return nightTemp;
		}
		public void setNightTemp(String nightTemp) {
			this.nightTemp = nightTemp;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getWea() {
			return wea;
		}
		public void setWea(String wea) {
			this.wea = wea;
		}
		public String getSkypop() {
			return skypop;
		}
		public void setSkypop(String skypop) {
			this.skypop = skypop;
		}
	}
	
	protected static class liveIndex {
		String desc;
		String indexType;
		String guide;
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getIndexType() {
			return indexType;
		}
		public void setIndexType(String indexType) {
			this.indexType = indexType;
		}
		public String getGuide() {
			return guide;
		}
		public void setGuide(String guide) {
			this.guide = guide;
		}
	}
}
