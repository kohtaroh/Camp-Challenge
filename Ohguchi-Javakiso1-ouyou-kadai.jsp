<%
//与えられたクエリストリングを?total=N&number=M&item=Lとする
//購入された商品の種類は常に一種類であり、複数種類は考えない
//また、商品はそれぞれL=1の時:雑貨 L=2の時:生鮮食品 L=3の時:その他 である
//① 今回はL=1:雑貨の場合とする
//     String url ="http://localhost:8080/camp/test.jsp?total=3500&number=20&item=1";
     String N = request.getParameter("total");
     String M = request.getParameter("number");
     String L = request.getParameter("item");
     if (L.equals("1")){
     String item ="雑貨";
     out.println("お買い上げいただいた商品種別は"+item+"<br>");
     }else if (L.equals("2")){
     String item ="生鮮食品";
     out.println("お買い上げいただいた商品種別は"+item+"<br>");
     }else if(L.equals("3")){
     String item ="その他";
     out.println("お買い上げいただいた商品種別は"+item+"<br>");
     }
     Double Na = Double.parseDouble(N);
     Double Ma = Double.parseDouble(M);
     
//② 今回はNを3500円 Mを20個と設定する
//   一個当たりの値段に関して
//   小数点以下は常に切り捨てであり表示しないものとし、
//   割り切れている場合も数字の頭に"約"をつけるものとする
     //Double Na = new Double(N);
     //Double Ma = new Double(M);
     double Ave =Na/Ma;
     out.println("総額は"+(int)Math.floor(Na)+"円です<br>");
     out.println("一個当たりの値段は約"+(int)Math.floor(Ave)+"円です<br>");

//③ ポイントの追加に関して
//   小数点以下は常に切り捨てであり表示しないものとする
     if (Na>=5000){
     double  point = Na*0.05;
     out.println("今回付与されたポイントは"+(int)Math.floor(point)+"点です<br>");
     }else if (Na>=3000){
     double  point = Na*0.04;
     out.println("今回付与されたポイントは"+(int)Math.floor(point)+"点です<br>");
     } else  {
     out.println("今回はポイントが付与されませんでした");
}
%>