function topPicClick(e){
   var big=document.getElementById("big"); 

   var bigPic=big.getElementsByTagName("img");  
   var picBeChosen=e.getAttribute("src");
   bigPic[0].src=picBeChosen;
 
}
