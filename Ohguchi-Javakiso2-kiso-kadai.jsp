<%
//課題①
    int num = 1;
    String massege1 = "";
    switch(num){
    case 1:
    massege1 = "one";
    break;
    case 2:
    massege1 = "two";
    break;
    default:
    massege1 = "想定外";
    }
    out.println(massege1+"<br>");
    
//課題②
    {
    char word = 'A';
    String massege2 = "";
    switch(word){
    case 'A':
    massege2 ="英語";
    break;
    case 'あ':
    massege2 ="日本語";
    break;
    }
    out.println(massege2+"<br>");
    }
//課題③
    {
    long a=1;
    for(int count=0; count<20; count++){
    a=a*8;
    out.println(a+"<br>");
    }}
    
//課題④
    {
    String massage2 ="";
    for(int i=0; i<30; i++) {
    massage2+="A";
    }out.println(massage2+"<br>");
    }
    
//課題⑤
    {
    int a=0;
    for(int count=1; count<=100; count++){
    a+=count;
    }out.println(a+"<br>");
    }
    
//課題⑥
    {
    double yen = 1000;
    while(yen>100){
     yen = yen/2; 
      out.println(yen+"<br>");
    }}
    
//課題⑦
    {
    String box[] ={"10","100","soeda","hayashi","-20","118","END"};
    out.println(box[2]+"<br>");
    }
    
//課題⑧
    {
    String box[] ={"10","100","soeda","hayashi","-20","118","END"};
    box[2]="33";
    out.println(box[2]+"<br>");
    }
%>

<%@ page import="java.util.HashMap"%>
<%
//課題⑨HashMapの利用について上記のpage importを参照する
    HashMap<String, String> hMap = new HashMap<String, String>();
    hMap.put("1", "AAA");
    hMap.put("hello", "world");
    hMap.put("soeda", "33");
    hMap.put("20", "20");    
    out.println("1"+"hello"+"soeda"+"20");
%>
