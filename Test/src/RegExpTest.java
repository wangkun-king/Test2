import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpTest {

    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?<=\\))");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
        String str2 = "870152738@qq.com";
        String reg = "\\d*@\\w*\\.\\w*";
        Pattern p2 = Pattern.compile(reg);
        Matcher m2 = p2.matcher(str2);
        if(m2.find()){
        	System.out.println(m2.group());
        }
    }
}
