/**
 * This challenge requires you to determine if every alphabetic character in a string has a plus (+) symbol on the left and right side of itself. For example: the string "+a+b+c+" is good but the string "===+3+f=+b+" is not because the "f" does not have a plus symbol to its right.
 */

 //Create loop; When we find a char we check if it is surrounded by '+'
 
 function simpleSymbols(str){
     //pad string in order not to get out-of-bounds error
     var str = '=' + str + '=';

     //loop through String
     for(var i = 0; i < str.length; i++){
         //check for alphabetic char
         if(str[i].match(/[a-z]/) != null){
             //check for surrounding '+'
             if(str[i-1] !== '+' || str[i+1] !== '+'){
                 return false;
             }
         }
         return true;
     }
 }

if(simpleSymbols('+d+=3=+s+')){
    console.log('Successful string!')
}else{
    console.log('Unsuccessful string!')   
}