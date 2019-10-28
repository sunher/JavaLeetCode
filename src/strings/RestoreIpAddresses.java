package strings;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {



    public List<String> restoreIpAddresses(String s) {

        int length = s.length();

        List<String> list = new ArrayList<>();
        if(length>12){
            return list;
        }
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length-1;j++){
                for(int p=j+1;p<length-1;p++){

                    StringBuilder stringBuilder = new StringBuilder();
                    if((s.substring(0,i+1).length()>1&&s.substring(0,i+1).startsWith("0"))||s.substring(0,i+1).length()>4||Integer.valueOf(s.substring(0,i+1))>255){
                        continue;
                    }
                    if((s.substring(i+1,j+1).length()>1&&s.substring(i+1,j+1).startsWith("0"))||s.substring(i+1,j+1).length()>4||Integer.valueOf(s.substring(i+1,j+1))>255){
                        continue;
                    }
                    if((s.substring(j+1,p+1).length()>1&&s.substring(j+1,p+1).startsWith("0"))||s.substring(j+1,p+1).length()>4||Integer.valueOf(s.substring(j+1,p+1))>255){
                        continue;
                    }
                    if((s.substring(p+1,length).length()>1&&s.substring(p+1,length).startsWith("0"))||s.substring(p+1,length).length()>4||Integer.valueOf(s.substring(p+1,length))>255){
                        continue;
                    }
                    stringBuilder.append(s.substring(0,i+1));
                    stringBuilder.append(".");
                    stringBuilder.append(s.substring(i+1,j+1));
                    stringBuilder.append(".");
                    stringBuilder.append(s.substring(j+1,p+1));
                    stringBuilder.append(".");
                    stringBuilder.append(s.substring(p+1,length));

                    list.add(stringBuilder.toString());



                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        System.out.print(new RestoreIpAddresses().restoreIpAddresses("010010"));
    }
}
