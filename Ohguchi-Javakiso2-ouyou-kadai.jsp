<%
//課題⑩与えられたクエリストリングが?param=33となっていた場合
   int param=33;
   int number=param;
   int n =param;
   
   int times2=0;
   int times3=0;
   int times5=0;
   int times7=0;
   
   if(n%7==0){
   for(;n>=7&&n%7==0;n=n/7){
   times7++;}}
   
   if(n%5==0){
   for(;n>=5&&n%5==0;n=n/5){
   times5++;}}
   
   if(n%3==0){
   for(;n>=3&&n%3==0;n=n/3){
   times3++;}}
   
   if(n%2==0){
   for(;n>=2&&n%2==0;n=n/2){
   times2++;}}
   
   int n7=times7;
   int n5=times5;
   int n3=times3;
   int n2=times2;
   
   String count7="";
   String count5="";
   String count3="";
   String count2="";
   
   if(n7>=1){
   count7="7が"+times7+"個";
   }
   
   if(n5>=1){
   count5="5が"+times5+"個";
   }
   
   if(n3>=1){
   count3="3が"+times3+"個";
   }
   
   if(n2>=1){
   count2="2が"+times2+"個";
   }
   
   if(number==Math.pow(7,times7)*Math.pow(5,times5)
             *Math.pow(3,times3)*Math.pow(2,times2)){
   out.println("元の値"+number+"は素因数分解されると"
                +count2+count3+count5+count7+"になる");
   }else{
   out.println("元の値"+number+"は素因数分解されると"
                +count2+count3+count5+count7+"とその他になる");
   }
%>