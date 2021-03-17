public class Codec {
    // randam generate the url,cut the url and put into the map
   String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String baseUrl = " http://tinyurl.com/";
    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String urlShort = longUrl.replace("https://leetcode.com/problems/","");
        StringBuilder sb = new StringBuilder();
        for(char c: urlShort.toCharArray()){
            int ranNum = (int)(Math.random()*62);
            sb.append(base.charAt(ranNum));
        }
        String appends;
        if(sb.length() > 6){
            appends = sb.toString().substring(0,6);
        }else{
            appends = sb.toString();
        }
        String url = baseUrl + appends;
        map.put(url, longUrl);
        return url;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
