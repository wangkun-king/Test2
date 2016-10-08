
public class Test {

//	 public static void main(String[] args) {
////	        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
////
////	        System.out.println(f1 == f2);//true
////	        System.out.println(f3 == f4);//false
//		 String a = "2";
//		 switch (a) {
//		case "1":
//			
//			break;
//
//		default:
//			break;
//		}
//	    }
	public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(111);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }
}
