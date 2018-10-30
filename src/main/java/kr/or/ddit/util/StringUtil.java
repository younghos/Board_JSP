package kr.or.ddit.util;

public class StringUtil {
	/**
	* Method : getFileNAmeFromHeader
	* 작성자 : pc24
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition 에서 fileName을 추출
	*/
	public static String getFileNAmeFromHeader(String contentDisposition){
		String fileName = "";
		
		String[] splits = contentDisposition.split("; ");
		
		for (String splits_str : splits) {
			if(splits_str.indexOf("filename=") >=0){
				fileName = splits_str.substring(10, splits_str.lastIndexOf("\""));
			}
		}
		return fileName;
	}

	/**
	* Method : getCookie
	* 작성자 : pc24
	* 변경이력 :
	* @param cookieString
	* @param string
	* @return
	* Method 설명 : cookieString에서 string을 추출
	*/
	public static String getCookie(String cookieString, String string) {
		String str = "";
		
		String[] splits = cookieString.split("; ");
		
		for (String splits_str : splits) {
			if(splits_str.indexOf(string+"=") >=0){
				System.out.println(splits_str);
				str = splits_str.substring(splits_str.indexOf("=")+1);
				System.out.println(str);
			}
		}
		return str;
	}
}
