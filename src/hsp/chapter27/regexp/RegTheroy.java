package hsp.chapter27.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Agiroy
 * @date 2022/5/13 14:42
 * @effect 分析java正则表达式的底层实现
 */

public class RegTheroy {
    public static void main(String[] args) {
        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布" +
                "了第二代Java平台（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Java2平台" +
                "的微型版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2平台" +
                "的标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的企业版），" +
                "应用3443于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重要的一个里程碑，" +
                "标志着Java的应用开始普及9889 ";

        //目标：匹配素有四个数字
        //1.\\d表示一个任意的数字
        String  regStr = "(\\d\\d)(\\d\\d)";
        //2.创建模式对象【即正则表达式对象】
        Pattern pattern = Pattern.compile(regStr);
        //3.创建一个匹配器
        //创建匹配器matcher，按照正则表达式的规则去匹配content字符串
        Matcher matcher = pattern.matcher(content);

        //4.开始匹配
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }

        /*
        * 如果正则表达式有()分组
        *取出匹配的字符串规则如下
        * group(0)表示匹配到的子字符串
        * group(1)表示匹配到的子字符串的第一组字符串
        * group(2)表示匹配到的子字符串的第二组字符串
        * */
    }
}
