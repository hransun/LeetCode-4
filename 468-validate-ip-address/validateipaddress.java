class Solution {
    public String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0) {
            return "Neither";
        }
        if(ip4(IP)){
            return "IPv4";
        }
          if(ip6(IP)){
            return "IPv6";
        }
        return "Neither";
    }
    private boolean ip4(String IP) {
        int dot = 0;
        for(char i: IP.toCharArray()){
            if(i == '.') {
                dot++;
            }
        }
        if (dot != 3) {
            return false;
        }
        String[] groups = IP.split("\\.");
        if(groups.length != 4) {
            return false;
        }
        for(String group: groups) {
            //这里不查length的上线 >3,可能后续int会outofbound
            if(group.length() == 0 || group.length() > 3) {
                return false;
            }
            for(char c: group.toCharArray())
                  //Charater.isletter(c)
                if(!Character.isDigit(c)) {
                    return false;
                }

            int num = Integer.valueOf(group);
            //!String.valueOf(num).equals(group) ==> check the leading zero 90 != 090
            if(!String.valueOf(num).equals(group) || num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }



    private boolean ip6(String IP) {
        IP= IP.toUpperCase();
        int dot = 0;
        for(char c: IP.toCharArray()) {
            if(c == ':') {
                dot++;
            }
        }
        if(dot != 7) {
            return false;
        }
        String[] groups = IP.split(":");
        if(groups.length != 8) {
            return false;
        }
        for(String group: groups) {
            if(group.length() == 0 || group.length() >4) {
                return false;
            }
            for(char c: group.toCharArray()) {
                if(!Character.isDigit(c) && c < 'A' || c > 'F') {
                    return false;
                }
            }
        }
        return true;
    }

}
