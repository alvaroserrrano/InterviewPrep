/**
 * This challenge requires you to capitalize the first letter of each word.*/

 //We will create an array of words, then loop through each word and capitalize the first letter

 //Then we will combine the words into a String

function letterCapitalize(str){
    
    //Split String into an array
    var words = str.split(" ");

    //We split each word
        //Part one-->First letter (capitalize)
        //Part two-->Rest of the String
    for(var i = 0; i < words.length; i++){
        words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
    }

    return words.join(" ");
}

 console.log(letterCapitalize("hello world"));